/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.verification;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClassificationSummaryMerchant extends AbstractModelComponent {
	
	@ApiModelProperty(readOnly = true, value = "The name of the merchant")
	@JsonProperty("name")
	private String name;
	
	/**
	 * The name of the merchant
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Merchant [name=" + name + "]";
	}

}
