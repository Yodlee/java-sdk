/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"asset", "income", "expense"})
public class CreditAcceleratorAccountAnalysis {
	
	@JsonProperty("asset")
	private CreditAcceleratorAccountAsset asset;
	
	@JsonProperty("income")
	private CreditAcceleratorAccountIncome income;
	
	@JsonProperty("expense")
	private CreditAcceleratorAccountExpense expense;

	public CreditAcceleratorAccountAsset getAsset() {
		return asset;
	}

	public CreditAcceleratorAccountIncome getIncome() {
		return income;
	}

	public CreditAcceleratorAccountExpense getExpense() {
		return expense;
	}
}
