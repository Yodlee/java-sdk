/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.auth.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.Request;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder()
public class AuthTokenRequest implements Request {

	@ApiModelProperty(value = "clientId issued by Yodlee is used to generate the OAuth token for authentication.")
	@JsonProperty("clientId")
	private String clientId;

	@ApiModelProperty(value = "secret issued by Yodlee is used to generate the OAuth token for authentication.")
	@JsonProperty("secret")
	private String secret;

	/**
	 * clientId issued by Yodlee is used to generate the OAuth token for
	 * authentication.<br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST /auth/token</li>
	 * </ul>
	 * 
	 * @return clientId
	 */
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * 
	 * secret issued by Yodlee is used to generate the OAuth token for
	 * authentication.<br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST /auth/token</li>
	 * </ul>
	 * 
	 * @return secret
	 */
	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Override
	public String toString() {
		return "AuthTokenRequest [clientId=" + clientId + ", secret=" + secret + "]";
	}

}
