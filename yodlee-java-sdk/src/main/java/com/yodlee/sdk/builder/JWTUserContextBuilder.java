/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.builder;

import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.configuration.user.JWTUserConfiguration;
import com.yodlee.sdk.context.JWTUserContext;

public class JWTUserContextBuilder implements Builder<JWTUserConfiguration, JWTUserContext> {

	/**
	 * This method is used to obtain JWT User context which can be used to invoke any API. This JWT User context holds a
	 * JWT token generated during the invocation of this method.
	 * 
	 * @param jwtConfiguration - {@link JWTUserConfiguration}
	 * @return {@link JWTUserContext}
	 * @throws ApiException - {@link ApiException}
	 */
	public JWTUserContext build(JWTUserConfiguration jwtConfiguration) throws ApiException {
		ConfigValidationUtil.validateConfig(jwtConfiguration);
		String jwtToken = JWTUtil.getJWTToken(jwtConfiguration.getApiKey(), jwtConfiguration.getPrivateKey(),
				jwtConfiguration.getUser(), jwtConfiguration.getExpiresIn(), jwtConfiguration.getLocale());
		return new JWTUserContext(jwtToken, jwtConfiguration);
	}
}
