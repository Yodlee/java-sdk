/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.provideraccounts.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class StatusLink {
	
	@JsonProperty("methodType")
	@ApiModelProperty(readOnly = true)
	public String methodType;
	
	@JsonProperty("rel")
	@ApiModelProperty(readOnly = true)
	public String rel;
	
	@JsonProperty("href")
	@ApiModelProperty(readOnly = true)
	public String href;

	public String getMethodType() {
		return methodType;
	}

	public String getRel() {
		return rel;
	}

	public String getHref() {
		return href;
	}

}
