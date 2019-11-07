/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"key", "publicKey", "expiryTime"})
public class ApiKeyOutput extends AbstractApiKey {

	@ApiModelProperty(value = "ApiKey or the issuer key used to generate the JWT token for authentication."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET /auth/apiKey</li>"//
			+ "<li>POST /auth/apiKey</li>"//
			+ "</ul>")
	@JsonProperty("key")
	private String key;

	@ApiModelProperty(value = "The date on which the apiKey was created for the customer."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET /auth/apiKey</li>"//
			+ "<li>POST /auth/apiKey</li>"//
			+ "</ul>")
	@JsonProperty("createdDate")
	private String createdDate;

	@ApiModelProperty(value = "Time in seconds after which the JWT token created for users expires."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET /auth/apiKey</li>"//
			+ "<li>POST /auth/apiKey</li>"//
			+ "</ul>")
	@JsonProperty("expiresIn")
	private Long expiresIn;

	/**
	 * ApiKey or the issuer key used to generate the JWT token for authentication. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET /auth/apiKey</li>
	 * <li>POST /auth/apiKey</li>
	 * </ul>
	 * 
	 * @return key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Time in seconds after which the JWT token created for users expires. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET /auth/apiKey</li>
	 * <li>POST /auth/apiKey</li>
	 * </ul>
	 * 
	 * @return expiresIn
	 */
	public Long getExpiresIn() {
		return expiresIn;
	}

	/**
	 * The date on which the apiKey was created for the customer. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET /auth/apiKey</li>
	 * <li>POST /auth/apiKey</li>
	 * </ul>
	 * 
	 * @return createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	@Override
	public String toString() {
		return "ApiKeyOutput [key=" + key + ", issueDate=" + createdDate + ", expiryTime=" + expiresIn + "]";
	}
}
