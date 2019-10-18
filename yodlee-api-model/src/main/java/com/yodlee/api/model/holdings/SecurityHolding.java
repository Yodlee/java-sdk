/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.holdings;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "security"})
public class SecurityHolding extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("id")
	private String id;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("security")
	private Security security;

	public String getId() {
		return id;
	}

	public Security getSecurity() {
		return security;
	}

	@Override
	public String toString() {
		return "SecurityHolding [id=" + id + ", security=" + security + "]";
	}
}
