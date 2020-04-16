/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.configuration.user;

import com.yodlee.sdk.configuration.cobrand.AbstractClientCredentialConfiguration;

public class ClientCredentialUserConfiguration extends AbstractClientCredentialConfiguration {

	public ClientCredentialUserConfiguration() {
		super();
	}

	public ClientCredentialUserConfiguration(String basePath, String apiVersion) {
		super(basePath, apiVersion);
	}
}
