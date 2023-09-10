/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.Money;

@JsonPropertyOrder({"totalValue", "classification"})
public class CreditAcceleratorInvestmentHoldingSummary {
	
	@JsonProperty("totalValue")
	private Money totalValue;
	
	@JsonProperty("classification")
	private CreditAcceleratorClassification classification;

	public Money getTotalValue() {
		return totalValue;
	}

	public CreditAcceleratorClassification getClassification() {
		return classification;
	} 

}
