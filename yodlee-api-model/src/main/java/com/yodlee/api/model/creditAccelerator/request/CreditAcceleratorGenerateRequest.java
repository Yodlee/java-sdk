/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.creditAccelerator.CreditAcceleratorRequestingFirm;
import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({"configName", "accountIds", "requestingFirm"})
public class CreditAcceleratorGenerateRequest {
	
	@JsonProperty("configName")
	@ApiModelProperty(readOnly = true,
		value = "The config name using which the credit accelerator file generation was requested")
	private String configName;
	
	@JsonProperty("accountIds")
	@ApiModelProperty(readOnly = true,
		value ="Mention account ids for which credit accelerator file generation is getting requested. mentioned accountid should belong to containers bank or loan or investment")
	private List<Long> accountIds;
	
	@JsonProperty("requestingFirm")
	private CreditAcceleratorRequestingFirm requestingFirm;
	
	public String getConfigName() {
		return configName;
	}
	public List<Long> getAccountIds() {
		return accountIds;
	}
	public CreditAcceleratorRequestingFirm getRequestingFirm() {
		return requestingFirm;
	}

}
