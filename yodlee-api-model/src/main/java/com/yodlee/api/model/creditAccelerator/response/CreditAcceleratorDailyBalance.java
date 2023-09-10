/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({ "date", "currency", "amount" })
public class CreditAcceleratorDailyBalance {

	@JsonProperty("date")
	@ApiModelProperty(readOnly = true, value = "Daily balance date")
	private String date;

	@JsonProperty("currency")
	@ApiModelProperty(readOnly = true, value = "Currency which the amount is in.")
	private String currency;

	@JsonProperty("amount")
	@ApiModelProperty(readOnly = true, value = "Daily balance amount")
	private Double amount;

	public String getDate() {
		return date;
	}

	public String getCurrency() {
		return currency;
	}

	public Double getAmount() {
		return amount;
	}
}
