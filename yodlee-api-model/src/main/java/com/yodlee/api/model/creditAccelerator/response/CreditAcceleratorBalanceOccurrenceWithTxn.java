/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.transaction.Transaction;

@JsonPropertyOrder({"currency", "values", "transactions"})
public class CreditAcceleratorBalanceOccurrenceWithTxn {
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("values")
	private List<CreditAcceleratorOccurence> values;
	
	@JsonProperty("transactions")
	private List<CreditAcceleratorTransaction> transactions;

	public String getCurrency() {
		return currency;
	}

	public List<CreditAcceleratorOccurence> getValues() {
		return values;
	}

	public List<CreditAcceleratorTransaction> getTransactions() {
		return transactions;
	}

}
