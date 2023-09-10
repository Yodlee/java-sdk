/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"currency", "classificationTypes"})
public class CreditAcceleratorClassification {
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("classificationTypes")
	private List<CreditAcceleratorClassificationType> classificationTypes;

	public String getCurrency() {
		return currency;
	}

	public List<CreditAcceleratorClassificationType> getClassificationTypes() {
		return classificationTypes;
	} 
}
