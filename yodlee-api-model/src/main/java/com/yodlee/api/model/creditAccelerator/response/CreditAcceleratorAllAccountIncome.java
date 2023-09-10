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

@JsonPropertyOrder({"totalIncomeTxnSummary", "regularIncomeTxnSummary", "servicesIncomeTxnSummary", 
	"retirementTxnSummary", "otherIncomeTxnSummary", "depositTxnSummary"})
public class CreditAcceleratorAllAccountIncome {
	
	@JsonProperty("totalIncomeTxnSummary")
	private List<CreditAcceleratorAllAccountBalanceSummary> totalIncomeTxnSummary;
	
	@JsonProperty("regularIncomeTxnSummary")
	@ApiModelProperty(readOnly = true,
		value = "Sum, count, average, and list of salary/regular income transactions.")
	private List<CreditAcceleratorAllAccountBalanceSummary> regularIncomeTxnSummary;
	
	@JsonProperty("servicesIncomeTxnSummary")
	@ApiModelProperty(readOnly = true,
		value = "Sum, count, average, and list of sales/services income transactions.")
	private List<CreditAcceleratorAllAccountBalanceSummary> servicesIncomeTxnSummary;
	
	@JsonProperty("retirementTxnSummary")
	@ApiModelProperty(readOnly = true,
		value = "Sum, count, average, and list of investment/retirement income transactions.")
	private List<CreditAcceleratorAllAccountBalanceSummary> retirementTxnSummary;
	
	@JsonProperty("otherIncomeTxnSummary")
	@ApiModelProperty(readOnly = true,
		value = "Sum, count, average, and list of other income transactions.")
	private List<CreditAcceleratorAllAccountBalanceSummary> otherIncomeTxnSummary;
	
	@JsonProperty("depositTxnSummary")
	@ApiModelProperty(readOnly = true,
		value = "Sum, count, average, and list of deposit income transactions.")
	private List<CreditAcceleratorAllAccountBalanceSummary> depositTxnSummary;

	public List<CreditAcceleratorAllAccountBalanceSummary> getTotalIncomeTxnSummary() {
		return totalIncomeTxnSummary;
	}

	public List<CreditAcceleratorAllAccountBalanceSummary> getRegularIncomeTxnSummary() {
		return regularIncomeTxnSummary;
	}

	public List<CreditAcceleratorAllAccountBalanceSummary> getServicesIncomeTxnSummary() {
		return servicesIncomeTxnSummary;
	}

	public List<CreditAcceleratorAllAccountBalanceSummary> getRetirementTxnSummary() {
		return retirementTxnSummary;
	}

	public List<CreditAcceleratorAllAccountBalanceSummary> getOtherIncomeTxnSummary() {
		return otherIncomeTxnSummary;
	}

	public List<CreditAcceleratorAllAccountBalanceSummary> getDepositTxnSummary() {
		return depositTxnSummary;
	}

}
