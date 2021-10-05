/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.builder;

import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.configuration.cobrand.JWTAppConfiguration;
import com.yodlee.sdk.context.JWTAppContext;

public class JWTAppContextBuilder implements Builder<JWTAppConfiguration, JWTAppContext> {

	/**
	 * This method is used to obtain JWT Cobrand context which can be used to invoke any Cobrand bound API. This JWT
	 * Cobrand context holds a JWT token generated during the invocation of this method.
	 * 
	 * @param jwtConfiguration - {@link JWTAppConfiguration}
	 * @return {@link JWTAppContext}
	 * @throws ApiException - {@link ApiException}
	 */
	public JWTAppContext build(JWTAppConfiguration jwtConfiguration) throws ApiException {
		ConfigValidationUtil.validateConfig(jwtConfiguration);
		String jwtToken = JWTUtil.getJWTToken(jwtConfiguration.getApiKey(), jwtConfiguration.getPrivateKey(), null,
				jwtConfiguration.getExpiresIn(), jwtConfiguration.getLocale());
		return new JWTAppContext(jwtToken, jwtConfiguration);
	}
}
