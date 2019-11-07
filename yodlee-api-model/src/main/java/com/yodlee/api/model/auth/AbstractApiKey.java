/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.auth;

import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractApiKey extends AbstractModelComponent {

	@NotEmpty(message = "{auth.apiKey.publicKey.required}")
	@ApiModelProperty(value = "Public key uploaded by the customer while generating ApiKey."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET /auth/apiKey</li>"//
			+ "<li>POST /auth/apiKey</li>"//
			+ "</ul>")
	@JsonProperty("publicKey")
	protected String publicKey;

	/**
	 * Public key uploaded by the customer while generating ApiKey. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET /auth/apiKey</li>
	 * <li>POST /auth/apiKey</li>
	 * </ul>
	 * 
	 * @return publicKey
	 */
	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
}
