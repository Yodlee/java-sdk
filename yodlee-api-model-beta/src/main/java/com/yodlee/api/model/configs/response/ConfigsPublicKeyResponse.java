/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.configs.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.configs.ConfigsPublicKey;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"publicKey"})
public class ConfigsPublicKeyResponse extends AbstractModelComponent implements Response {

	@JsonProperty("publicKey")
	private ConfigsPublicKey publicKey = new ConfigsPublicKey();

	public ConfigsPublicKeyResponse() {}

	public ConfigsPublicKey getPublicKey() {
		return publicKey;
	}
}
