/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.builder;

import com.yodlee.sdk.api.AuthApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.configuration.user.ClientCredentialUserConfiguration;
import com.yodlee.sdk.context.ClientCredentialUserContext;

public class ClientCredentialUserContextBuilder implements Builder<ClientCredentialUserConfiguration, ClientCredentialUserContext> {

	@Override
	public ClientCredentialUserContext build(ClientCredentialUserConfiguration clientCredentialConfiguration) throws ApiException {
		ConfigValidationUtil.validateConfig(clientCredentialConfiguration);
		AuthApi authApi = new AuthApi(clientCredentialConfiguration);
		authApi.generateAccessToken();
		return (ClientCredentialUserContext) authApi.getContext();
	}
}
