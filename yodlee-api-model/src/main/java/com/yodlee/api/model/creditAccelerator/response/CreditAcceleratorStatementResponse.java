/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.creditAccelerator.enums.CreditAcceleratorStatus;

import io.swagger.annotations.ApiModelProperty;

public class CreditAcceleratorStatementResponse extends AbstractModelComponent {
	
	@JsonProperty("reportId")
	@ApiModelProperty(readOnly = true,
	  value = "Unique identifier for the credit accelerator file")
	private Long reportId;
	
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
	
	@JsonProperty("statements")
	private List<CreditAcceleratorStatement> statements;

	public Long getReportId() {
		return reportId;
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

	public List<CreditAcceleratorStatement> getStatements() {
		return statements;
	}
	
}
