/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.sampleflow;

import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.builder.ContextBuilderFactory;
import com.yodlee.sdk.builder.JWTAppContextBuilder;
import com.yodlee.sdk.builder.JWTUserContextBuilder;
import com.yodlee.sdk.configuration.cobrand.JWTAppConfiguration;
import com.yodlee.sdk.configuration.user.JWTUserConfiguration;
import com.yodlee.sdk.context.JWTAppContext;
import com.yodlee.sdk.context.JWTUserContext;

public class ContextFactory {

	public static JWTAppContext createJWTAppContext() throws ApiException {
		JWTAppContext jwtAppContext = null;
		JWTAppContextBuilder jwtAppContextBuilder = ContextBuilderFactory.createJWTAppContextBuilder();
		JWTAppConfiguration jwtConfiguration =
				Utils.load("/configuration/jwtConfiguration.json", JWTAppConfiguration.class);
		jwtAppContext = jwtAppContextBuilder.build(jwtConfiguration);
		return jwtAppContext;
	}

	public static JWTUserContext createJWTUserContext(JWTAppConfiguration jwtConfiguration, String user)
			throws ApiException {
		JWTUserContext jwtUserContext = null;
		JWTUserContextBuilder jwtUserContextBuilder = ContextBuilderFactory.createJWTUserContextBuilder();
		JWTUserConfiguration jwtUserConfiguration = new JWTUserConfiguration(jwtConfiguration, user);
		jwtUserConfiguration.setUser(user);
		jwtUserContext = jwtUserContextBuilder.build(jwtUserConfiguration);
		return jwtUserContext;
	}
}
