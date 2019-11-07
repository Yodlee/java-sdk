/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.providers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"TOTAL"})
public class ProvidersCount extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("TOTAL")
	private TotalCount total;

	@JsonProperty("TOTAL")
	public TotalCount getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "ProvidersCount [TOTAL=" + total + "]";
	}
}
