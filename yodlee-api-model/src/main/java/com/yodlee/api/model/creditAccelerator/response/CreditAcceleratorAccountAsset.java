/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"dailyBalances", "dailyBalanceSummary", "dailyBalanceAnalysis", "negativeBalanceOccurrences",
	"lowBalanceOccurrence", "largeDepositOccurrences", "largeTransferOccurrences", "creditTxnWithTransferSummary",
	"creditTxnWithoutTransferSummary", "depositTxnSummary", "transferTxnSummary", "nsfOccurrences", "investmentHoldingSummary"})
public class CreditAcceleratorAccountAsset {
	
	//Field to be calculated based on Daily data points
	@JsonProperty("dailyBalances")
	private List<CreditAcceleratorDailyBalance> dailyBalances;
	@JsonProperty("dailyBalanceSummary")
	private CreditAcceleratorDailyBalanceSummary dailyBalanceSummary;
	@JsonProperty("dailyBalanceAnalysis")
	private CreditAcceleratorDailyBalanceAnalysis dailyBalanceAnalysis;
	@JsonProperty("negativeBalanceOccurrences")
	private CreditAcceleratorBalanceOccurrence negativeBalanceOccurrences;
	@JsonProperty("lowBalanceOccurrence")
	private CreditAcceleratorLowBalanceOccurrence lowBalanceOccurrence;

	// fields to be calculated based on transactions
	@JsonProperty("largeDepositOccurrences")
	private CreditAcceleratorBalanceOccurrenceWithTxn largeDepositOccurrences;
	@JsonProperty("largeTransferOccurrences")
	private CreditAcceleratorBalanceOccurrenceWithTxn largeTransferOccurrences;
	@JsonProperty("creditTxnWithTransferSummary")
	private CreditAcceleratorBalanceSummary creditTxnWithTransferSummary;
	@JsonProperty("creditTxnWithoutTransferSummary")
	private CreditAcceleratorBalanceSummary creditTxnWithoutTransferSummary;
	@JsonProperty("depositTxnSummary")
	private CreditAcceleratorBalanceSummary depositTxnSummary;
	@JsonProperty("transferTxnSummary")
	private CreditAcceleratorBalanceSummary transferTxnSummary;
	
	//Custom attributes
	@JsonProperty("nsfOccurrences")
	private CreditAcceleratorBalanceOccurrenceWithTxn nsfOccurrences;
	
	//asset classification related field
	@JsonProperty("investmentHoldingSummary")
	private CreditAcceleratorInvestmentHoldingSummary investmentHoldingSummary;

	public List<CreditAcceleratorDailyBalance> getDailyBalances() {
		return dailyBalances;
	}

	public CreditAcceleratorDailyBalanceSummary getDailyBalanceSummary() {
		return dailyBalanceSummary;
	}

	public CreditAcceleratorDailyBalanceAnalysis getDailyBalanceAnalysis() {
		return dailyBalanceAnalysis;
	}

	public CreditAcceleratorBalanceOccurrence getNegativeBalanceOccurrences() {
		return negativeBalanceOccurrences;
	}

	public CreditAcceleratorLowBalanceOccurrence getLowBalanceOccurrence() {
		return lowBalanceOccurrence;
	}

	public CreditAcceleratorBalanceOccurrenceWithTxn getLargeDepositOccurrences() {
		return largeDepositOccurrences;
	}

	public CreditAcceleratorBalanceOccurrenceWithTxn getLargeTransferOccurrences() {
		return largeTransferOccurrences;
	}

	public CreditAcceleratorBalanceSummary getCreditTxnWithTransferSummary() {
		return creditTxnWithTransferSummary;
	}

	public CreditAcceleratorBalanceSummary getCreditTxnWithoutTransferSummary() {
		return creditTxnWithoutTransferSummary;
	}

	public CreditAcceleratorBalanceSummary getDepositTxnSummary() {
		return depositTxnSummary;
	}

	public CreditAcceleratorBalanceSummary getTransferTxnSummary() {
		return transferTxnSummary;
	}

	public CreditAcceleratorBalanceOccurrenceWithTxn getNsfOccurrences() {
		return nsfOccurrences;
	}

	public CreditAcceleratorInvestmentHoldingSummary getInvestmentHoldingSummary() {
		return investmentHoldingSummary;
	}
	
}
