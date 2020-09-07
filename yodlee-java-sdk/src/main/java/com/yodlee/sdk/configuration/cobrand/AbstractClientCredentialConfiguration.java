/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.configuration.cobrand;

import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractClientCredentialConfiguration extends AbstractBaseConfiguration {

	@NotEmpty(message = "{config.clientId.required}")
	@JsonProperty("clientId")
	private String clientId;

	@NotEmpty(message = "{config.secret.required}")
	@JsonProperty("secret")
	private String secret;

	@NotEmpty(message = "{config.loginName.required}")
	@JsonProperty("loginName")
	private String loginName;

	public AbstractClientCredentialConfiguration() {
		super();
	}

	public AbstractClientCredentialConfiguration(String basePath, String apiVersion) {
		super(basePath, apiVersion);
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
}
