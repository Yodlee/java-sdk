/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.creditAccelerator.enums.CreditAcceleratorStatus;

import io.swagger.annotations.ApiModelProperty;

public abstract class AbstractCreditAcceleratorResponse extends AbstractModelComponent {
	
	@JsonProperty("originalReportId")
	@ApiModelProperty(readOnly = true, value = "Report id of original report on which refresh is performed. This is not available when report is generated for the first time.")
	private Long originalReportId;
	
	@JsonProperty("configName")
	@ApiModelProperty(readOnly = true,
	  value = "The config name using which the credit accelerator file generation was requested")
	private String configName;
	
	@JsonProperty("status")
	@ApiModelProperty(readOnly = true,
	  value = "Generation status of the requested credit accelerator file requested")
	private CreditAcceleratorStatus status;
	
	@JsonProperty("submissionDate")
	@ApiModelProperty(readOnly = true,
	  value = "Date on which the request to generate credit accelerator file was submitted")
	private String submissionDate;
	
	public Long getOriginalReportId() {
		return originalReportId;
	}
	public String getConfigName() {
		return configName;
	}
	public CreditAcceleratorStatus getStatus() {
		return status;
	}
	public String getSubmissionDate() {
		return submissionDate;
	}
	
}
