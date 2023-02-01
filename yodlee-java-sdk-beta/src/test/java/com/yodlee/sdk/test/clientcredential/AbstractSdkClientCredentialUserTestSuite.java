/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.clientcredential;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.databene.feed4testng.FeedTest;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.builder.ClientCredentialUserContextBuilder;
import com.yodlee.sdk.builder.ContextBuilderFactory;
import com.yodlee.sdk.configuration.user.ClientCredentialUserConfiguration;
import com.yodlee.sdk.context.ClientCredentialUserContext;
import com.yodlee.sdk.test.utils.PrintUtil;

public abstract class AbstractSdkClientCredentialUserTestSuite extends FeedTest {

	protected static ClientCredentialUserContext setup() {
		ClientCredentialUserContextBuilder clientCredentialContextBuilder =
				ContextBuilderFactory.createClientCredentialUserContextBuilder();
		ClientCredentialUserContext clientCredentialContext = null;
		try (InputStream inStream = AbstractSdkClientCredentialAppTestSuite.class
				.getResourceAsStream("/configuration/clientCredentialUser.properties");) {
			Properties properties = new Properties();
			properties.load(inStream);
			ClientCredentialUserConfiguration clientCredentialUserConfiguration =
					new ClientCredentialUserConfiguration();
			clientCredentialUserConfiguration.setBasePath(properties.getProperty("basePath").trim());
			clientCredentialUserConfiguration.setApiVersion(properties.getProperty("apiVersion").trim());
			clientCredentialUserConfiguration.setClientId(properties.getProperty("clientId").trim());
			clientCredentialUserConfiguration.setSecret(properties.getProperty("secret").trim());
			clientCredentialUserConfiguration.setLoginName(properties.getProperty("loginName").trim());
			clientCredentialUserConfiguration
					.setMaxIdleConnection(Integer.getInteger(properties.getProperty("maxIdleConnection").trim()));
			clientCredentialUserConfiguration.setConnectionKeepAliveDuration(
					Integer.getInteger(properties.getProperty("connectionKeepAliveDuration").trim()));
			clientCredentialContext = clientCredentialContextBuilder.build(clientCredentialUserConfiguration);
		} catch (ApiException e) {
			PrintUtil.assertFail("", "ClientCredential token", e);;
		} catch (IOException ioe) {
			PrintUtil.assertFail("", "Exception loading", ioe);
		}
		return clientCredentialContext;
	}

	public static void tearDown() {
		// TODO - delete JWT token
	}
}
