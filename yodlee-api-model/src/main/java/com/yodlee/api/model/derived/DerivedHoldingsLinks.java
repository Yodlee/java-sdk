/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.derived;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"holdings"})
public class DerivedHoldingsLinks extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("holdings")
	private String holdings;

	public String getHoldings() {
		return holdings;
	}

	@Override
	public String toString() {
		return "HoldingsLinks [holdings=" + holdings + "]";
	}
}
