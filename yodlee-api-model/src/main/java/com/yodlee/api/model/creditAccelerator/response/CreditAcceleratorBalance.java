/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({ "date", "amount", "currency"})
public class CreditAcceleratorBalance {

	@JsonProperty("date")
	@ApiModelProperty(readOnly = true, value = "Date of balance.")
	private String date;

	@JsonProperty("amount")
	@ApiModelProperty(readOnly = true, value = "Balance amount value.")
	private Double amount;
	
	@JsonProperty("currency")
	@ApiModelProperty(readOnly = true, value = "Currency which the amount is in.")
	private CreditAcceleratorData currency;

	public String getDate() {
		return date;
	}

	public Double getAmount() {
		return amount;
	}

	public CreditAcceleratorData getCurrency() {
		return currency;
	}

}
