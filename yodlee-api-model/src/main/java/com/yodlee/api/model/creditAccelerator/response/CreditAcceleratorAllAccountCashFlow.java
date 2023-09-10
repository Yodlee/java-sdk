/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"currency", "values"})
public class CreditAcceleratorAllAccountCashFlow {

	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("values")
	private List<CreditAcceleratorAllAccountCashFlowAnalysis> values;

	public String getCurrency() {
		return currency;
	}

	public List<CreditAcceleratorAllAccountCashFlowAnalysis> getValues() {
		return values;
	}
	
}
