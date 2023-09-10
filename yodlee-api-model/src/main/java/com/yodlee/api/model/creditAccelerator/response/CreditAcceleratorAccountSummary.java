/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.account.CreditAcceleratorAccount;
import com.yodlee.api.model.holdings.Holding;

@JsonPropertyOrder({"accountAnalysis", "details", "transactions", "holdings", "accountVerification"})
public class CreditAcceleratorAccountSummary {
	
	@JsonProperty("accountAnalysis")
	private CreditAcceleratorAccountAnalysis accountAnalysis;
	
	@JsonProperty("details")
	private CreditAcceleratorAccount details;
	
	@JsonProperty("transactions")
	private List<CreditAcceleratorTransaction> transactions;
	
	@JsonProperty("holdings")
	private List<Holding> holdings;
	
	@JsonProperty("accountVerification")
	private CreditAcceleratorAccountVerification accountVerification;

	public CreditAcceleratorAccountAnalysis getAccountAnalysis() {
		return accountAnalysis;
	}

	public CreditAcceleratorAccount getDetails() {
		return details;
	}

	public List<CreditAcceleratorTransaction> getTransactions() {
		return transactions;
	}

	public List<Holding> getHoldings() {
		return holdings;
	}

	public CreditAcceleratorAccountVerification getAccountVerification() {
		return accountVerification;
	}

}
