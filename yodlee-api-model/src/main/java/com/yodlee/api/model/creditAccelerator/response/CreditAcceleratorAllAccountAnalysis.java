/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"asset", "income", "expense"})
public class CreditAcceleratorAllAccountAnalysis {

	@JsonProperty("asset")
	private CreditAcceleratorAllAccountAsset asset;
	
	@JsonProperty("income")
	private CreditAcceleratorAllAccountIncome income;
	
	@JsonProperty("expense")
	private CreditAcceleratorAllAccountExpense expense;

	public CreditAcceleratorAllAccountAsset getAsset() {
		return asset;
	}

	public CreditAcceleratorAllAccountIncome getIncome() {
		return income;
	}

	public CreditAcceleratorAllAccountExpense getExpense() {
		return expense;
	}
	
}
