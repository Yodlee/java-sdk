/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.context;

import com.yodlee.sdk.configuration.user.ClientCredentialUserConfiguration;

public class ClientCredentialUserContext extends AbstractClientCredentialContext<ClientCredentialUserConfiguration> {

	private static final long serialVersionUID = 1L;

	public ClientCredentialUserContext(String accessToken, String issuedAt, int expiresIn,
			ClientCredentialUserConfiguration clientCredentialUserConfiguration) {
		super(accessToken, issuedAt, expiresIn, clientCredentialUserConfiguration);
	}

	@Override
	public ContextType getContextType() {
		return ContextType.USER;
	}
}
