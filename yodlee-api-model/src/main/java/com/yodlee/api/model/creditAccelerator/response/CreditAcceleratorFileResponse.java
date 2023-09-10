/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.creditAccelerator.AbstractCreditAcceleratorResponse;

import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({"reportId", "originalReportId", "configName", "status", "submissionDate"})
public class CreditAcceleratorFileResponse extends AbstractCreditAcceleratorResponse {
	
	@JsonProperty("reportId")
	@ApiModelProperty(readOnly = true,
	  value = "Unique identifier for the credit accelerator file")
	private long reportId;

	public long getReportId() {
		return reportId;
	}

}
