/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.enums.IdentifierType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"type", "value"})
public class Identifier extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true, value = "Type of Identifier")
	@JsonProperty("type")
	private IdentifierType type;

	@ApiModelProperty(readOnly = true, value = "Value of the identifier")
	@JsonProperty("value")
	private String value;

	public IdentifierType getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Identifier [type=" + type + ", value=" + value + "]";
	}
}
