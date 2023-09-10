/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.creditAccelerator.AbstractCreditAcceleratorResponse;
import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({"id", "originalReportId", "status", "configName", "submissionDate", 
	"selectedAccounts", "data", "docContent", "reportConfig", "user"})
public class CreditAcceleratorFile extends AbstractCreditAcceleratorResponse {
	
	@JsonProperty("id")
	@ApiModelProperty(readOnly = true, value = "Unique identifier for credit accelerator report.")
	private long id;
	
	@JsonProperty("selectedAccounts")
	private List<CreditAcceleratorSelectedAccount> selectedAccounts;
	
	@JsonProperty("data")
	@ApiModelProperty(readOnly = true,
		value = "The config name using which the credit accelerator file generation was requested")
	private CreditAcceleratorData data;
	
	@JsonProperty("docContent")
	@ApiModelProperty(readOnly = true,
		value = "Contents of the document in Base64 format")
	private String docContent;
	
	@JsonProperty("reportConfig")
	@ApiModelProperty(readOnly = true,
		value = "The config name using which the credit accelerator file generation was requested")
	private CreditAcceleratorReportConfig reportConfig;
	
	@JsonProperty("user")
	@ApiModelProperty(readOnly = true,
		value = "The config name using which the credit accelerator file generation was requested")
	private CreditAcceleratorUser user;

	public long getId() {
		return id;
	}

	public List<CreditAcceleratorSelectedAccount> getSelectedAccounts() {
		return selectedAccounts;
	}

	public CreditAcceleratorData getData() {
		return data;
	}

	public String getDocContent() {
		return docContent;
	}

	public CreditAcceleratorReportConfig getReportConfig() {
		return reportConfig;
	}

	public CreditAcceleratorUser getUser() {
		return user;
	}
}
