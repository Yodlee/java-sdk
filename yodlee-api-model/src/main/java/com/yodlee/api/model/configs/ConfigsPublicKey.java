/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.configs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

public class ConfigsPublicKey extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "The key name used for encryption."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET configs/publicKey</li>"//
							  + "</ul>")
	@JsonProperty("alias")
	private String alias;

	@ApiModelProperty(readOnly = true,
					  value = "Public key that the customer should be using to encrypt the credentials and answers before sending to the add & update providerAccounts APIs."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET configs/publicKey</li>"//
							  + "</ul>")
	@JsonProperty("key")
	private String key;

	/**
	 * The key name used for encryption. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET configs/publicKey</li>
	 * </ul>
	 * 
	 * @return key alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Public key that the customer should be using to encrypt the credentials and answers before sending to the add &
	 * update providerAccounts APIs. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET configs/publicKey</li>
	 * </ul>
	 * 
	 * @return key as pem String
	 */
	public String getKey() {
		return key;
	}
}
