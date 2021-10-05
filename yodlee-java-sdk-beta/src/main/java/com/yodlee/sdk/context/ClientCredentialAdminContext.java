/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.context;

import com.yodlee.sdk.configuration.cobrand.ClientCredentialAdminConfiguration;

public class ClientCredentialAdminContext extends AbstractClientCredentialContext<ClientCredentialAdminConfiguration> {

	private static final long serialVersionUID = 1L;

	public ClientCredentialAdminContext(String accessToken, String issuedAt, int expiresIn,
			ClientCredentialAdminConfiguration clientCredentialAdminConfiguration) {
		super(accessToken, issuedAt, expiresIn, clientCredentialAdminConfiguration);
	}

	@Override
	public ContextType getContextType() {
		return ContextType.COBRAND;
	}
}
