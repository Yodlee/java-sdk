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
import com.yodlee.api.model.account.enums.PaymentBankTransferCodeType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"type", "id"})
public class PaymentBankTransferCode extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true, value = "Type of BankTransferCode")
	@JsonProperty("type")
	private PaymentBankTransferCodeType type;

	@ApiModelProperty(readOnly = true, value = "Value of the identifier")
	@JsonProperty("id")
	private String id;

	public PaymentBankTransferCodeType getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "PaymentBankTransferCode [type=" + type + ", id=" + id + "]";
	}
}
