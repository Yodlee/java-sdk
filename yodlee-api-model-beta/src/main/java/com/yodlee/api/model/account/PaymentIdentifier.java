/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.account.enums.PaymentIdentifierType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"type", "value"})
public class PaymentIdentifier extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true, value = "Type of Identifier")
	@JsonProperty("type")
	private PaymentIdentifierType type;

	@ApiModelProperty(readOnly = true, value = "Value of the identifier")
	@JsonProperty("value")
	private String value;

	public PaymentIdentifierType getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "PaymentIdentifier [type=" + type + ", value=" + value + "]";
	}
}
