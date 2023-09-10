/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class CreditAcceleratorRefreshRequest {
	
	@JsonProperty("configName")
	@ApiModelProperty(readOnly = true,
	  value = "The config name using which the credit accelerator file generation was requested")
	private String configName;

}
