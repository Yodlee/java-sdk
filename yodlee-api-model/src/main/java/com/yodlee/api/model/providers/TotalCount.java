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
@JsonPropertyOrder({"count"})
public class TotalCount extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("count")
	private Long count;

	public Long getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "TotalCount [count=" + count + "]";
	}
}
