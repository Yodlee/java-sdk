/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({"totalBankBalances", "totalInvestmentBalances", "totalBalances", "negativeBalanceOccurrences",
	"lowBalanceOccurrence", "largeDepositOccurrences", "largeTransferOccurrences", "creditTxnWithTransferSummary",
	"creditTxnWithoutTransferSummary", "depositTxnSummary", "transferTxnSummary", "nsfOccurrences", "investmentHoldingSummary"})
public class CreditAcceleratorAllAccountAsset {
	
	// Fields to be calculated based on Account Bean/Balances
	@JsonProperty("totalBankBalances")
	@ApiModelProperty(readOnly = true,
		value = "Total sum of currentBalance values across all Bank accounts, grouped by Currency.")
	private List<CreditAcceleratorBalance> totalBankBalances;
	
	@JsonProperty("totalInvestmentBalances")
	@ApiModelProperty(readOnly = true,
		value = "Total sum of Investment Balance values across all Investment accounts, grouped by Currency.")
	private List<CreditAcceleratorBalance> totalInvestmentBalances;
	
	@JsonProperty("totalBalances")
	@ApiModelProperty(readOnly = true,
		value = "Total sum of currentBalance (Bank) and totalBalance (Investment) values across all Bank and Investment accounts, grouped by Currency.")
	private List<CreditAcceleratorBalance> totalBalances;
	
	// Field to be calculated based on Daily data points
	@JsonProperty("negativeBalanceOccurrences")
	@ApiModelProperty(readOnly = true,
		value = "For each time period, the number of times where Daily Balance is less than zero, grouped by Currency.")
	private List<CreditAcceleratorAllAccountBalanceOccurrence> negativeBalanceOccurrences;
	
	@JsonProperty("lowBalanceOccurrence")
	@ApiModelProperty(readOnly = true,
		value = "For each time period, the number of times where Daily Balance is within each segment range, grouped by Currency.")
	private CreditAcceleratorLowBalanceOccurenceALL lowBalanceOccurrence;
	
	// fields to be calculated based on transactions
	@JsonProperty("largeDepositOccurrences")
	@ApiModelProperty(readOnly = true,
		value = "For each time period, the number of times where transactions exceeded the large transaction amount, grouped by Currency.")
	private List<CreditAcceleratorAllAccountBalanceOccurrence> largeDepositOccurrences;
	
	@JsonProperty("largeTransferOccurrences")
	@ApiModelProperty(readOnly = true,
		value = "For each time period, the number of times where transactions exceeded the large transaction amount, grouped by Currency.")
	private List<CreditAcceleratorAllAccountBalanceOccurrence> largeTransferOccurrences;
	
	@JsonProperty("creditTxnWithTransferSummary")
	@ApiModelProperty(readOnly = true,
		value = "Sum, count, and average of all credit transactions (including transfers), grouped by Currency.")
	private List<CreditAcceleratorAllAccountBalanceSummary> creditTxnWithTransferSummary;
	
	@JsonProperty("creditTxnWithoutTransferSummary")
	@ApiModelProperty(readOnly = true,
		value = "Sum, count, and average of all credit transactions (excluding transfers), grouped by Currency.")
	private List<CreditAcceleratorAllAccountBalanceSummary> creditTxnWithoutTransferSummary;
	
	@JsonProperty("depositTxnSummary")
	@ApiModelProperty(readOnly = true,
		value = "Sum, count, and average of all deposit transactions, grouped by Currency..")
	private List<CreditAcceleratorAllAccountBalanceSummary> depositTxnSummary;
	
	@JsonProperty("transferTxnSummary")
	@ApiModelProperty(readOnly = true,
		value = "Sum, count, and average of all transfer transactions, grouped by Currency.")
	private List<CreditAcceleratorAllAccountBalanceSummary> transferTxnSummary;
	
	//Custom attributes
	@JsonProperty("nsfOccurrences")
	@ApiModelProperty(readOnly = true,
		value = "For each time period, the number of times NSF has occurred, grouped by Currency.")
	private List<CreditAcceleratorAllAccountBalanceOccurrence> nsfOccurrences;
	
	//asset classification related field
	@JsonProperty("investmentHoldingSummary")
	@ApiModelProperty(readOnly = true,
		value = "Investment holding summary includes total holdings value as well as the sum value for all investments by classification.")
	private CreditAcceleratorAllAccountInvestmentHoldingSummary investmentHoldingSummary;

	public List<CreditAcceleratorBalance> getTotalBankBalances() {
		return totalBankBalances;
	}

	public List<CreditAcceleratorBalance> getTotalInvestmentBalances() {
		return totalInvestmentBalances;
	}

	public List<CreditAcceleratorBalance> getTotalBalances() {
		return totalBalances;
	}

	public List<CreditAcceleratorAllAccountBalanceOccurrence> getNegativeBalanceOccurrences() {
		return negativeBalanceOccurrences;
	}

	public CreditAcceleratorLowBalanceOccurenceALL getLowBalanceOccurrence() {
		return lowBalanceOccurrence;
	}

	public List<CreditAcceleratorAllAccountBalanceOccurrence> getLargeDepositOccurrences() {
		return largeDepositOccurrences;
	}

	public List<CreditAcceleratorAllAccountBalanceOccurrence> getLargeTransferOccurrences() {
		return largeTransferOccurrences;
	}

	public List<CreditAcceleratorAllAccountBalanceSummary> getCreditTxnWithTransferSummary() {
		return creditTxnWithTransferSummary;
	}

	public List<CreditAcceleratorAllAccountBalanceSummary> getCreditTxnWithoutTransferSummary() {
		return creditTxnWithoutTransferSummary;
	}

	public List<CreditAcceleratorAllAccountBalanceSummary> getDepositTxnSummary() {
		return depositTxnSummary;
	}

	public List<CreditAcceleratorAllAccountBalanceSummary> getTransferTxnSummary() {
		return transferTxnSummary;
	}

	public List<CreditAcceleratorAllAccountBalanceOccurrence> getNsfOccurrences() {
		return nsfOccurrences;
	}

	public CreditAcceleratorAllAccountInvestmentHoldingSummary getInvestmentHoldingSummary() {
		return investmentHoldingSummary;
	}
	
}
