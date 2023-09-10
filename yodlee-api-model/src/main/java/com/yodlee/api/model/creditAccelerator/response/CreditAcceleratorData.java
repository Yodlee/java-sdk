/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"accounts", "allAccountAnalysis"})
public class CreditAcceleratorData {
	
	@JsonProperty("accounts")
	private List<CreditAcceleratorAccountSummary> accounts;
	
	@JsonProperty("allAccountAnalysis")
	private CreditAcceleratorAllAccountAnalysis allAccountAnalysis;

	public List<CreditAcceleratorAccountSummary> getAccounts() {
		return accounts;
	}

	public CreditAcceleratorAllAccountAnalysis getAllAccountAnalysis() {
		return allAccountAnalysis;
	}
}
