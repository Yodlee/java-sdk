/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.Money;

@JsonPropertyOrder({"totalValues", "classifications"})
public class CreditAcceleratorAllAccountInvestmentHoldingSummary {
	
	@JsonProperty("totalValues")
	private List<Money> totalValues;
	
	@JsonProperty("classifications")
	private List<CreditAcceleratorClassification> classifications;

	public List<Money> getTotalValues() {
		return totalValues;
	}

	public List<CreditAcceleratorClassification> getClassifications() {
		return classifications;
	}

}
