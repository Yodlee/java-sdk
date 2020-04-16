/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.sampleflow;

import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.builder.ContextBuilderFactory;
import com.yodlee.sdk.builder.ClientCredentialAdminContextBuilder;
import com.yodlee.sdk.builder.ClientCredentialUserContextBuilder;
import com.yodlee.sdk.configuration.cobrand.ClientCredentialAdminConfiguration;
import com.yodlee.sdk.configuration.user.ClientCredentialUserConfiguration;
import com.yodlee.sdk.context.ClientCredentialAdminContext;
import com.yodlee.sdk.context.ClientCredentialUserContext;

public class ContextFactory {

	private ContextFactory() {}

	public static ClientCredentialAdminContext createClientCredentialAdminContext() throws ApiException {
		ClientCredentialAdminContext clientCredentialAdminContext = null;
		ClientCredentialAdminContextBuilder clientCredentialAdminContextBuilder =
				ContextBuilderFactory.createClientCredentialAdminContextBuilder();
		ClientCredentialAdminConfiguration clientCredentialConfiguration = Utils.load(
				"/configuration/clientCredentialAdminConfiguration.json", ClientCredentialAdminConfiguration.class);
		clientCredentialAdminContext = clientCredentialAdminContextBuilder.build(clientCredentialConfiguration);
		return clientCredentialAdminContext;
	}

	public static ClientCredentialUserContext createClientCredentialUserContext() throws ApiException {
		ClientCredentialUserContext clientCredentialUserContext = null;
		ClientCredentialUserContextBuilder clientCredentialUserContextBuilder =
				ContextBuilderFactory.createClientCredentialUserContextBuilder();
		ClientCredentialUserConfiguration clientCredentialUserConfiguration = Utils
				.load("/configuration/clientCredentialUserConfiguration.json", ClientCredentialUserConfiguration.class);
		clientCredentialUserContext = clientCredentialUserContextBuilder.build(clientCredentialUserConfiguration);
		UserManager.getInstance().addUser(clientCredentialUserConfiguration.getLoginName(),
				clientCredentialUserContext);
		return clientCredentialUserContext;
	}
}
