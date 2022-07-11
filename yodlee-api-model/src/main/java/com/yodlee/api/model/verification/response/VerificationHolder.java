/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.verification.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Name;
import com.yodlee.api.model.Response;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ownership", "name"})
public class VerificationHolder extends AbstractModelComponent implements Response {
	
	@ApiModelProperty(readOnly = true, value = "Indicates the ownership of the account")
	@JsonProperty("ownership")
	private String ownership;
	
	@ApiModelProperty(readOnly = true, value = "The name of the account holder")
	@JsonProperty("name")
	private Name name;

	@JsonProperty("name")
	public Name getName() {
		return name;
	}
	
	@JsonProperty("ownership")
	public String getOwnership() {
		return ownership;
	}
	
	@Override
	public String toString() {
		return "VerificationHolder [ownership=" + ownership + ", name=" + name + "]";
	}
}

