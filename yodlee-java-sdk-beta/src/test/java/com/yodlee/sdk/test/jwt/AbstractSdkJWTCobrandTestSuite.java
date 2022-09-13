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
import com.yodlee.sdk.builder.JWTAppContextBuilder;
import com.yodlee.sdk.configuration.cobrand.JWTAppConfiguration;
import com.yodlee.sdk.context.JWTAppContext;
import com.yodlee.sdk.test.utils.PrintUtil;

public abstract class AbstractSdkJWTCobrandTestSuite extends FeedTest {

	protected static JWTAppContext setup() {
		JWTAppContextBuilder jwtCobrandContextBuilder = ContextBuilderFactory.createJWTAppContextBuilder();
		JWTAppContext jwtCobrandContext = null;
		try (InputStream inStream =
				AbstractSdkJWTCobrandTestSuite.class.getResourceAsStream("/configuration/jwt.properties");) {
			Properties properties = new Properties();
			properties.load(inStream);
			JWTAppConfiguration jwtConfiguration = new JWTAppConfiguration();
			jwtConfiguration.setBasePath(properties.getProperty("basePath"));
			jwtConfiguration.setApiVersion(properties.getProperty("apiVersion"));
			jwtConfiguration.setApiKey(properties.getProperty("apiKey"));
			jwtConfiguration.setExpiresIn(Integer.parseInt(properties.getProperty("expiresIn")));
			jwtConfiguration.setLocale(properties.getProperty("locale"));
			jwtConfiguration.setPrivateKey(properties.getProperty("privateKey"));
			jwtCobrandContext = jwtCobrandContextBuilder.build(jwtConfiguration);
			return jwtCobrandContext;
		} catch (ApiException e) {
			PrintUtil.assertFail("", "JWT Cobrand token", e);;
		} catch (IOException ioe) {
			PrintUtil.assertFail("", "Exception loading", ioe);
		}
		return jwtCobrandContext;
	}

	public static void tearDown() {
		// TODO delete jwtToken
	}
}
