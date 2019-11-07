/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.configuration.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.sdk.configuration.cobrand.AbstractJWTConfiguration;
import com.yodlee.sdk.configuration.cobrand.JWTAppConfiguration;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JWTUserConfiguration extends AbstractJWTConfiguration {

	@JsonProperty("sub")
	private String user;

	public JWTUserConfiguration() {}

	public JWTUserConfiguration(String basePath, String apiVersion, String apiKey, String privateKey, String user,
			Integer expiresIn) {
		super(basePath, apiVersion, apiKey, privateKey, expiresIn);
		this.user = user;
	}

	public JWTUserConfiguration(JWTAppConfiguration jwtAppConfiguration, String user) {
		this(jwtAppConfiguration.getBasePath(), jwtAppConfiguration.getApiVersion(), jwtAppConfiguration.getApiKey(),
				jwtAppConfiguration.getPrivateKey(), user, jwtAppConfiguration.getExpiresIn());
	}

	@JsonProperty("sub")
	public String getUser() {
		return user;
	}

	@JsonProperty("sub")
	public void setUser(String user) {
		this.user = user;
	}
}
