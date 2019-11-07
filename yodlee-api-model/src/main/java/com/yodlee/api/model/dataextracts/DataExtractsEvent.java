/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.dataextracts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"info", "data"})
public class DataExtractsEvent extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("info")
	private String info;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("data")
	private DataExtractsEventData data;

	public String getInfo() {
		return info;
	}

	public DataExtractsEventData getData() {
		return data;
	}

	@Override
	public String toString() {
		return "Event [info=" + info + ", data=" + data + "]";
	}
}
