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
import com.yodlee.sdk.builder.ClientCredentialAdminContextBuilder;
import com.yodlee.sdk.builder.ContextBuilderFactory;
import com.yodlee.sdk.configuration.cobrand.ClientCredentialAdminConfiguration;
import com.yodlee.sdk.context.ClientCredentialAdminContext;
import com.yodlee.sdk.test.utils.PrintUtil;

public abstract class AbstractSdkClientCredentialAppTestSuite extends FeedTest {

	protected static ClientCredentialAdminContext setup() {
		ClientCredentialAdminContextBuilder clientCredentialContextBuilder =
				ContextBuilderFactory.createClientCredentialAdminContextBuilder();
		ClientCredentialAdminContext clientCredentialContext = null;
		try (InputStream inStream = AbstractSdkClientCredentialAppTestSuite.class
				.getResourceAsStream("/configuration/clientCredentialAdmin.properties");) {
			Properties properties = new Properties();
			properties.load(inStream);
			ClientCredentialAdminConfiguration clientCredentialConfiguration = new ClientCredentialAdminConfiguration();
			clientCredentialConfiguration.setBasePath(properties.getProperty("basePath").trim());
			clientCredentialConfiguration.setApiVersion(properties.getProperty("apiVersion").trim());
			clientCredentialConfiguration.setClientId(properties.getProperty("clientId").trim());
			clientCredentialConfiguration.setSecret(properties.getProperty("secret").trim());
			clientCredentialConfiguration.setLoginName(properties.getProperty("loginName").trim());
			clientCredentialConfiguration
					.setMaxIdleConnection(Integer.getInteger(properties.getProperty("maxIdleConnection").trim()));
			clientCredentialConfiguration.setConnectionKeepAliveDuration(
					Integer.getInteger(properties.getProperty("connectionKeepAliveDuration").trim()));
			clientCredentialContext = clientCredentialContextBuilder.build(clientCredentialConfiguration);
		} catch (ApiException e) {
			PrintUtil.assertFail("", "ClientCredential token", e);;
		} catch (IOException ioe) {
			PrintUtil.assertFail("", "Exception loading", ioe);
		}
		return clientCredentialContext;
	}

	public static void tearDown() {
		// TODO delete clientCredentialToken
	}
}
