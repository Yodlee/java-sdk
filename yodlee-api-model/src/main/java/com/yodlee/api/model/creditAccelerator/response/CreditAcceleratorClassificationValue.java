/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "classificationValue", "amount", "percentage" })
public class CreditAcceleratorClassificationValue {

	@JsonProperty("classificationValue")
	private String classificationValue;

	@JsonProperty("amount")
	private Double amount;

	@JsonProperty("percentage")
	private Double percentage;

	public String getClassificationValue() {
		return classificationValue;
	}

	public Double getAmount() {
		return amount;
	}

	public Double getPercentage() {
		return percentage;
	}
}
