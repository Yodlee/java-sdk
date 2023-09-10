/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.Name;

import io.swagger.annotations.ApiModelProperty;


@JsonPropertyOrder({"name", "ownership"})
public class CreditAcceleratorHolder {
	
	@JsonProperty("name")
	private Name name;
	
	@JsonProperty("ownership")
	@ApiModelProperty(readOnly = true, value = "Indicates the ownership of the account.")
	private String ownership;

	public Name getName() {
		return name;
	}

	public String getOwnership() {
		return ownership;
	}
}
