/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.dataextracts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"methodType", "rel", "href"})
public class DataExtractsEventLinks extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("methodType")
	private String methodType;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("rel")
	private String rel;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("href")
	private String href;

	public String getMethodType() {
		return methodType;
	}

	public String getRel() {
		return rel;
	}

	public String getHref() {
		return href;
	}

	@Override
	public String toString() {
		return "Links [methodType=" + methodType + ", rel=" + rel + ", href=" + href + "]";
	}
}
