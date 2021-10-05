/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.clientcredential.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.clientcredential.ClientCredentialToken;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"token"})
public class ClientCredentialTokenResponse extends AbstractModelComponent {

	@JsonProperty("token")
	private ClientCredentialToken token;

	public ClientCredentialToken getToken() {
		return token;
	}

	public void setToken(ClientCredentialToken token) {
		this.token = token;
	}
}
