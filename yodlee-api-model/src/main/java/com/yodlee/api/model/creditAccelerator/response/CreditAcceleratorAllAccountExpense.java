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

@JsonPropertyOrder({"utilitiesTxnSummary", "telecomTxnSummary", "rentTxnSummary", "insuranceTxnSummary", 
	"educationTxnSummary", "taxesTxnSummary", "cashflow"})
public class CreditAcceleratorAllAccountExpense {
	
	@JsonProperty("utilitiesTxnSummary")
	@ApiModelProperty(readOnly = true,
		value = "Sum, count, average, and list of utilities expense transactions.")
	private List<CreditAcceleratorAllAccountBalanceSummary> utilitiesTxnSummary;
	
	@JsonProperty("telecomTxnSummary")
	@ApiModelProperty(readOnly = true,
		value = "Sum, count, average, and list of telecom expense transactions.")
	private List<CreditAcceleratorAllAccountBalanceSummary> telecomTxnSummary;
	
	@JsonProperty("rentTxnSummary")
	@ApiModelProperty(readOnly = true,
		value = "Sum, count, average, and list of rent expense transactions.")
	private List<CreditAcceleratorAllAccountBalanceSummary> rentTxnSummary;
	
	@JsonProperty("insuranceTxnSummary")
	@ApiModelProperty(readOnly = true,
		value = "Sum, count, average, and list of insurance expense transactions.")
	private List<CreditAcceleratorAllAccountBalanceSummary> insuranceTxnSummary;
	
	@JsonProperty("educationTxnSummary")
	@ApiModelProperty(readOnly = true,
		value = "Sum, count, average, and list of education expense transactions.")
	private List<CreditAcceleratorAllAccountBalanceSummary> educationTxnSummary;
	
	@JsonProperty("taxesTxnSummary")
	@ApiModelProperty(readOnly = true,
		value = "Sum, count, average, and list of taxes expense transactions.")
	private List<CreditAcceleratorAllAccountBalanceSummary> taxesTxnSummary;
	
	@JsonProperty("cashflow")
	private List<CreditAcceleratorAllAccountCashFlow> cashflow;

	public List<CreditAcceleratorAllAccountBalanceSummary> getUtilitiesTxnSummary() {
		return utilitiesTxnSummary;
	}

	public List<CreditAcceleratorAllAccountBalanceSummary> getTelecomTxnSummary() {
		return telecomTxnSummary;
	}

	public List<CreditAcceleratorAllAccountBalanceSummary> getRentTxnSummary() {
		return rentTxnSummary;
	}

	public List<CreditAcceleratorAllAccountBalanceSummary> getInsuranceTxnSummary() {
		return insuranceTxnSummary;
	}

	public List<CreditAcceleratorAllAccountBalanceSummary> getEducationTxnSummary() {
		return educationTxnSummary;
	}

	public List<CreditAcceleratorAllAccountBalanceSummary> getTaxesTxnSummary() {
		return taxesTxnSummary;
	}

	public List<CreditAcceleratorAllAccountCashFlow> getCashflow() {
		return cashflow;
	}

}
