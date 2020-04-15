/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.clientcredential;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"token"})
public class ClientCredentialToken {

	@ApiModelProperty(readOnly = true,
					  value = "Access Token to access YSL 1.1 services."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>POST /auth/token</li>"//
							  + "</ul>"//
	)
	@JsonProperty("accessToken")
	private String accessToken;

	@ApiModelProperty(readOnly = true,
					  value = "The date and time on which accessToken was created for the customer."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>POST /auth/token</li>"//
							  + "</ul>"//
	)
	@JsonProperty("issuedAt")
	private String issuedAt;

	@ApiModelProperty(readOnly = true,
					  value = "Time in seconds after which the issued accessToken expires."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>POST /auth/token</li>"//
							  + "</ul>"//
	)
	@JsonProperty("expiresIn")
	private int expiresIn;

	/**
	 * Access Token to access YSL 1.1 services. <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST /auth/token</li>
	 * </ul>
	 * 
	 * @return accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * The date and time on which accessToken was created for the customer. <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST /auth/token</li>
	 * </ul>
	 * 
	 * @return issuedAt
	 */
	public String getIssuedAt() {
		return issuedAt;
	}

	/**
	 * Time in seconds after which the issued accessToken expires. <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST /auth/token</li>
	 * </ul>
	 * 
	 * @return expiresIn
	 */
	public int getExpiresIn() {
		return expiresIn;
	}
}
