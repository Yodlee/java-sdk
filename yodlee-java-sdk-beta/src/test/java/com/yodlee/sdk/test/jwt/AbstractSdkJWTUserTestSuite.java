/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.jwt;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.databene.feed4testng.FeedTest;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.builder.ContextBuilderFactory;
import com.yodlee.sdk.builder.JWTUserContextBuilder;
import com.yodlee.sdk.configuration.user.JWTUserConfiguration;
import com.yodlee.sdk.context.JWTUserContext;
import com.yodlee.sdk.test.utils.PrintUtil;

public abstract class AbstractSdkJWTUserTestSuite extends FeedTest {

	protected static JWTUserContext setup() {
		JWTUserContext jwtUserContext = null;
		JWTUserContextBuilder jwtUserContextBuilder = ContextBuilderFactory.createJWTUserContextBuilder();
		try (InputStream inStream =
				AbstractSdkJWTUserTestSuite.class.getResourceAsStream("/configuration/jwtUser.properties");) {
			Properties properties = new Properties();
			properties.load(inStream);
			JWTUserConfiguration jwtConfiguration = new JWTUserConfiguration();
			jwtConfiguration.setBasePath(properties.getProperty("basePath"));
			jwtConfiguration.setApiVersion(properties.getProperty("apiVersion"));
			jwtConfiguration.setApiKey(properties.getProperty("apiKey"));
			jwtConfiguration.setPrivateKey(properties.getProperty("privateKey"));
			jwtConfiguration.setExpiresIn(Integer.parseInt(properties.getProperty("expiresIn")));
			jwtConfiguration.setLocale(properties.getProperty("locale"));
			jwtConfiguration.setUser(properties.getProperty("sub"));
			jwtUserContext = jwtUserContextBuilder.build(jwtConfiguration);
		} catch (ApiException e) {
			PrintUtil.assertFail("", "get jwt user token", e);
		} catch (IOException ioe) {
			PrintUtil.assertFail("", "Exception loading", ioe);
		}
		return jwtUserContext;
	}

	public static void tearDown() {
		// TODO - delete JWT token
	}
}
