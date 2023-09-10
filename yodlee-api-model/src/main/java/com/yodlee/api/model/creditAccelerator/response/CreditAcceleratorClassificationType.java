/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"classificationType", "classificationValues", "total"})
public class CreditAcceleratorClassificationType {
	
	@JsonProperty("classificationType")
	private String classificationType;
	
	@JsonProperty("classificationValues")
	private List<CreditAcceleratorClassificationValue> classificationValues;
	
	@JsonProperty("total")
	private List<CreditAcceleratorClassificationValue> total;
	
	public String getClassificationType() {
		return classificationType;
	}

	public List<CreditAcceleratorClassificationValue> getClassificationValues() {
		return classificationValues;
	}

	public List<CreditAcceleratorClassificationValue> getTotal() {
		return total;
	}

}
