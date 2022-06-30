/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.user.enums.Currency;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"amount", "currency", "convertedAmount", "convertedCurrency"})
public class Money extends AbstractModelComponent {

	@NotNull(message="{amount.required}")
	@JsonProperty("amount")
	private Double amount;

	@JsonProperty("currency")
	private Currency currency;

	@JsonProperty("convertedAmount")
	private Double convertedAmount;

	@JsonProperty("convertedCurrency")
	private Currency convertedCurrency;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Double getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(Double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

	public Currency getConvertedCurrency() {
		return convertedCurrency;
	}

	public void setConvertedCurrency(Currency convertedCurrency) {
		this.convertedCurrency = convertedCurrency;
	}

	@Override public String toString() {
		return "Money [" + "amount=" + amount + ", currency=" + currency + ", convertedAmount=" + convertedAmount
				+ ", convertedCurrency=" + convertedCurrency + "}";
	}
}
