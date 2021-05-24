/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.configuration.cobrand;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractJWTConfiguration extends AbstractBaseConfiguration {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "{config.jwt.apiKey.required}")
	@JsonProperty("apiKey")
	protected String apiKey;

	@NotEmpty(message = "{config.jwt.privateKey.required}")
	@JsonProperty("privateKey")
	protected String privateKey;

	@NotNull(message = "{config.jwt.expiresIn.required}")
	@Min(value = 1, message = "{config.jwt.expiresIn.minimum}")
	// @Max(value = 1800, message = "{config.jwt.expiresIn.maximum}")
	@JsonProperty("expiresIn")
	protected int expiresIn = 1800;

	public AbstractJWTConfiguration() {
		super();
	}

	public AbstractJWTConfiguration(String basePath, String apiVersion, String apiKey, String privateKey,
			Integer expiresIn) {
		super(basePath, apiVersion);
		this.apiKey = apiKey;
		this.privateKey = privateKey;
		this.expiresIn = expiresIn;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
}
