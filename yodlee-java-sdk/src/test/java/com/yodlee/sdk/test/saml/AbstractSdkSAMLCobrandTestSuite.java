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
import com.yodlee.sdk.builder.CobrandContextBuilder;
import com.yodlee.sdk.builder.ContextBuilderFactory;
import com.yodlee.sdk.configuration.cobrand.CobrandConfiguration;
import com.yodlee.sdk.context.CobrandContext;
import com.yodlee.sdk.context.Context;
import com.yodlee.sdk.test.utils.PrintUtil;

public abstract class AbstractSdkSAMLCobrandTestSuite extends FeedTest {

	protected static Context<?> setup() {
		CobrandContext cobrandContext = null;
		try (InputStream inStream =
				AbstractSdkSAMLCobrandTestSuite.class.getResourceAsStream("/configuration/cobrand.properties");) {
			Properties properties = new Properties();
			properties.load(inStream);
			CobrandConfiguration configuration = new CobrandConfiguration();
			configuration.setBasePath(properties.getProperty("basePath"));
			configuration.setApiVersion(properties.getProperty("apiVersion"));
			configuration.setName(properties.getProperty("cobrandName"));
			configuration.setLoginName(properties.getProperty("cobrandLoginName"));
			configuration.setPassword(properties.getProperty("cobrandPassword"));
			configuration.setLocale(properties.getProperty("locale"));
			CobrandContextBuilder cobrandContextBuilder = ContextBuilderFactory.createCobrandContextBuilder();
			cobrandContext = cobrandContextBuilder.build(configuration);
		} catch (ApiException e) {
			System.out.println(e.getServerError());
			PrintUtil.assertFail("", "Cobrand Login", e);
		} catch (IOException ioe) {
			PrintUtil.assertFail("", "Exception loading", ioe);
		}
		return cobrandContext;
	}
}
