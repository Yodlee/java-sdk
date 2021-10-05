/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.cobrand.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"keyAlias", "keyAsPemString"})
public class CobrandPublicKeyResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true,
					  value = "The key name used for encryption."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET cobrand/publicKey</li>"//
							  + "</ul>")
	@JsonProperty("keyAlias")
	private String keyAlias;

	@ApiModelProperty(readOnly = true,
					  value = "Public key that the customer should be using to encrypt the credentials and answers before sending to the add & update providerAccounts APIs."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET cobrand/publicKey</li>"//
							  + "</ul>")
	@JsonProperty("keyAsPemString")
	private String keyAsPemString;

	/**
	 * The key name used for encryption. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET cobrand/publicKey</li>
	 * </ul>
	 * 
	 * @return key alias
	 */
	public String getKeyAlias() {
		return keyAlias;
	}

	/**
	 * Public key that the customer should be using to encrypt the credentials and answers before sending to the add and
	 * update providerAccounts APIs. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET cobrand/publicKey</li>
	 * </ul>
	 * 
	 * @return key as pem String
	 */
	public String getKeyAsPemString() {
		return keyAsPemString;
	}

	@Override
	public String toString() {
		return "CobrandPublicKeyResponse [keyAlias=" + keyAlias + ", keyAsPemString=" + keyAsPemString + "]";
	}
}
