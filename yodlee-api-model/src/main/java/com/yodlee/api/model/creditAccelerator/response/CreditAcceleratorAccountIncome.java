/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"regularIncomeTxnSummary", "servicesIncomeTxnSummary", "retirementTxnSummary", "otherIncomeTxnSummary", 
	"depositTxnSummary"})
public class CreditAcceleratorAccountIncome {

	@JsonProperty("regularIncomeTxnSummary")
	private CreditAcceleratorBalanceSummary regularIncomeTxnSummary;
	
	@JsonProperty("servicesIncomeTxnSummary")
	private CreditAcceleratorBalanceSummary servicesIncomeTxnSummary;
	
	@JsonProperty("retirementTxnSummary")
	private CreditAcceleratorBalanceSummary retirementTxnSummary;
	
	@JsonProperty("otherIncomeTxnSummary")
	private CreditAcceleratorBalanceSummary otherIncomeTxnSummary;
	
	@JsonProperty("depositTxnSummary")
	private CreditAcceleratorBalanceSummary depositTxnSummary;

	public CreditAcceleratorBalanceSummary getRegularIncomeTxnSummary() {
		return regularIncomeTxnSummary;
	}

	public CreditAcceleratorBalanceSummary getServicesIncomeTxnSummary() {
		return servicesIncomeTxnSummary;
	}

	public CreditAcceleratorBalanceSummary getRetirementTxnSummary() {
		return retirementTxnSummary;
	}

	public CreditAcceleratorBalanceSummary getOtherIncomeTxnSummary() {
		return otherIncomeTxnSummary;
	}

	public CreditAcceleratorBalanceSummary getDepositTxnSummary() {
		return depositTxnSummary;
	}
	
}
