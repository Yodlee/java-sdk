/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.enums.EmailType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Email extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("type")
	private EmailType type;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("value")
	private String value;

	public String getValue() {
		return value;
	}

	public EmailType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Email [type=" + type + ", value=" + value + "]";
	}
}
