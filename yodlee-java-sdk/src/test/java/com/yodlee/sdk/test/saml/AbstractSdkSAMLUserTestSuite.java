/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.saml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.databene.feed4testng.FeedTest;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.builder.ContextBuilderFactory;
import com.yodlee.sdk.builder.UserContextBuilder;
import com.yodlee.sdk.configuration.user.UserConfiguration;
import com.yodlee.sdk.context.UserContext;
import com.yodlee.sdk.test.utils.ModelUtil;
import com.yodlee.sdk.test.utils.PrintUtil;

public abstract class AbstractSdkSAMLUserTestSuite extends FeedTest {

	protected static UserContext setup() {
		UserContext userContext = null;
		try (InputStream inStream =
				AbstractSdkSAMLCobrandTestSuite.class.getResourceAsStream("/configuration/samlUser.properties");) {
			Properties properties = new Properties();
			properties.load(inStream);
			UserConfiguration samlConfiguration = new UserConfiguration();
			samlConfiguration.setBasePath(properties.getProperty("basePath"));
			samlConfiguration.setApiVersion(properties.getProperty("apiVersion"));
			samlConfiguration.setName(properties.getProperty("cobrandName"));
			samlConfiguration.setLoginName(properties.getProperty("cobrandLoginName"));
			samlConfiguration.setPassword(properties.getProperty("cobrandPassword"));
			samlConfiguration.setLocale(properties.getProperty("locale"));
			samlConfiguration.setIssuer(properties.getProperty("issuer"));
			samlConfiguration.setSource(properties.getProperty("source"));
			String samlResponse = ModelUtil.loadSamlResponse(properties.get("samlResponse").toString());
			samlConfiguration.setSamlResponse(samlResponse);
			UserContextBuilder samlUserContextBuilder = ContextBuilderFactory.createUserContextBuilder();
			userContext = samlUserContextBuilder.build(samlConfiguration);
		} catch (ApiException e) {
			PrintUtil.assertFail("1", "SAML User Login", e);
		} catch (IOException ioe) {
			PrintUtil.assertFail("", "Exception loading", ioe);
		}
		return userContext;
	}
}
