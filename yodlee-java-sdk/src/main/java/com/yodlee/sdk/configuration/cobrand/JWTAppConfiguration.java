/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.sdk.configuration.cobrand;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JWTAppConfiguration extends AbstractJWTConfiguration {

	public JWTAppConfiguration() {}

	public JWTAppConfiguration(String basePath, String apiVersion, String apiKey, String privateKey,
			Integer expiresIn) {
		super(basePath, apiVersion, apiKey, privateKey, expiresIn);
	}
}
