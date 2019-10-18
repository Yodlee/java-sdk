/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.enums.PhoneNumberType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"type", "value"})
public class PhoneNumber extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true, value = "type of phone number")
	@JsonProperty("type")
	private PhoneNumberType type;

	@ApiModelProperty(readOnly = true, value = "Phone Number")
	@JsonProperty("value")
	private String value;

	public String getValue() {
		return value;
	}

	public PhoneNumberType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "PhoneNumber [type=" + type + ", value=" + value + "]";
	}
}
