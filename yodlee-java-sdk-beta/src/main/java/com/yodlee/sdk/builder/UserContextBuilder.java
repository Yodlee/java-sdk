/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.builder;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yodlee.sdk.api.UserApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.configuration.cobrand.CobrandConfiguration;
import com.yodlee.sdk.configuration.user.UserConfiguration;
import com.yodlee.sdk.context.CobrandContext;
import com.yodlee.sdk.context.UserContext;

public class UserContextBuilder implements Builder<UserConfiguration, UserContext> {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserContextBuilder.class);
	
	private static Map<String,CobrandContext> cobrandMap = new HashMap<>();
	/**
	 * This method is used to obtain User context which can be used to invoke any API. This User context holds a
	 * cobSession and userSession obtained during the invocation of this method.
	 * 
	 * @param userConfiguration {@link UserConfiguration}
	 * @return {@link UserContext}
	 * @throws ApiException - {@link ApiException}
	 */
	public UserContext build(UserConfiguration userConfiguration) throws ApiException {
		ConfigValidationUtil.validateConfig(userConfiguration);
		Boolean expiredContext = false;
		String clientName = userConfiguration.getName();
		CobrandContext cobrandContext = cobrandMap.get(clientName);
		if(cobrandContext == null) {
			cobrandContext = doCobLogin(userConfiguration);
		}
		try {
    		return doSamlLogin(userConfiguration, cobrandContext);
		}catch(ApiException e) {
			if(e.getResponseBody().contains("Y008")) {
				LOGGER.info("cobSession is expired");
				expiredContext = true;
			}else {
				throw e;
			}
		}
		if(expiredContext) {
			LOGGER.info("cobSession is expired, hence recreating the session");
			cobrandContext = doCobLogin(userConfiguration);
			return doSamlLogin(userConfiguration, cobrandContext);
		}
		return null;
	}
	
	private UserContext doSamlLogin(UserConfiguration userConfiguration, CobrandContext cobrandContext)
			throws ApiException {
		UserApi userApi = new UserApi(cobrandContext, userConfiguration);
		userApi.samlLogin(userConfiguration.getSamlResponse(), userConfiguration.getIssuer(),
				userConfiguration.getSource());
		return (UserContext) userApi.getContext();
	}
	
	private CobrandContext doCobLogin(UserConfiguration userConfiguration) throws ApiException {
		CobrandConfiguration cobrandConfiguration = new CobrandConfiguration();
		cobrandConfiguration.setBasePath(userConfiguration.getBasePath());
		cobrandConfiguration.setApiVersion(userConfiguration.getApiVersion());
		cobrandConfiguration.setName(userConfiguration.getName());
		cobrandConfiguration.setLocale(userConfiguration.getLocale());
		cobrandConfiguration.setLoginName(userConfiguration.getLoginName());
		cobrandConfiguration.setPassword(userConfiguration.getPassword());
		
		ConfigValidationUtil.validateConfig(cobrandConfiguration);
		
		CobrandContext cobrandContext;
		CobrandContextBuilder cobrandContextBuilder = ContextBuilderFactory.createCobrandContextBuilder();
		cobrandContext = cobrandContextBuilder.build(cobrandConfiguration);
		cobrandMap.put(cobrandConfiguration.getName(), cobrandContext);
		return cobrandContext;
	}
}
