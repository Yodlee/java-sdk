/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"utilitiesTxnSummary", "telecomTxnSummary", "rentTxnSummary",
	"insuranceTxnSummary", "educationTxnSummary", "taxesTxnSummary", "cashflow"})
public class CreditAcceleratorAccountExpense {
	
	@JsonProperty("utilitiesTxnSummary")
	private CreditAcceleratorBalanceSummary utilitiesTxnSummary;
	
	@JsonProperty("telecomTxnSummary")
	private CreditAcceleratorBalanceSummary telecomTxnSummary;
	
	@JsonProperty("rentTxnSummary")
	private CreditAcceleratorBalanceSummary rentTxnSummary;
	
	@JsonProperty("insuranceTxnSummary")
	private CreditAcceleratorBalanceSummary insuranceTxnSummary;
	
	@JsonProperty("educationTxnSummary")
	private CreditAcceleratorBalanceSummary educationTxnSummary;
	
	@JsonProperty("taxesTxnSummary")
	private CreditAcceleratorBalanceSummary taxesTxnSummary;
	
	@JsonProperty("cashflow")
	private CreditAcceleratorCashFlow cashflow;

	public CreditAcceleratorBalanceSummary getUtilitiesTxnSummary() {
		return utilitiesTxnSummary;
	}

	public CreditAcceleratorBalanceSummary getTelecomTxnSummary() {
		return telecomTxnSummary;
	}

	public CreditAcceleratorBalanceSummary getRentTxnSummary() {
		return rentTxnSummary;
	}

	public CreditAcceleratorBalanceSummary getInsuranceTxnSummary() {
		return insuranceTxnSummary;
	}

	public CreditAcceleratorBalanceSummary getEducationTxnSummary() {
		return educationTxnSummary;
	}

	public CreditAcceleratorBalanceSummary getTaxesTxnSummary() {
		return taxesTxnSummary;
	}

	public CreditAcceleratorCashFlow getCashflow() {
		return cashflow;
	}
	
}
