/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.builder;

import com.yodlee.sdk.api.UserApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.configuration.cobrand.CobrandConfiguration;
import com.yodlee.sdk.configuration.user.UserConfiguration;
import com.yodlee.sdk.context.CobrandContext;
import com.yodlee.sdk.context.UserContext;

public class UserContextBuilder implements Builder<UserConfiguration, UserContext> {

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
		CobrandConfiguration cobrandConfiguration = new CobrandConfiguration();
		cobrandConfiguration.setBasePath(userConfiguration.getBasePath());
		cobrandConfiguration.setApiVersion(userConfiguration.getApiVersion());
		cobrandConfiguration.setName(userConfiguration.getName());
		cobrandConfiguration.setLocale(userConfiguration.getLocale());
		cobrandConfiguration.setLoginName(userConfiguration.getLoginName());
		cobrandConfiguration.setPassword(userConfiguration.getPassword());
		CobrandContextBuilder cobrandContextBuilder = ContextBuilderFactory.createCobrandContextBuilder();
		CobrandContext cobrandContext = cobrandContextBuilder.build(cobrandConfiguration);
		UserApi userApi = new UserApi(cobrandContext, userConfiguration);
		userApi.samlLogin(userConfiguration.getSamlResponse(), userConfiguration.getIssuer(),
				userConfiguration.getSource());
		return (UserContext) userApi.getContext();
	}
}
