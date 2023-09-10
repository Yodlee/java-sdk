/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;

import io.swagger.annotations.ApiModelProperty;

public class CreditAcceleratorStatement extends AbstractModelComponent {
	
	@JsonProperty("accountId")
	@ApiModelProperty(readOnly = true,
	  value = "The primary key of the account resource and the unique identifier for the account."
	          + "<br><br>"//
	          + "<b>Aggregated / Manual</b>: Both <br>"//
	          + "<b>Applicable containers</b>: All containers<br>"//
	          + "<b>Endpoints</b>:"//
	          + "<ul>"//
	          + "<li>GET accounts </li>"//
	          + "<li>GET accounts/{accountId}</li>"//
	          + "<li>GET investmentOptions</li>"//
	          + "<li>GET accounts/historicalBalances</li>"//
	          + "<li>POST accounts</ul>")
	private Long accountId;
	
	@JsonProperty("status")
	@ApiModelProperty(readOnly = true,
	  value = "Status of the doc download for given configName or reportId")
	private String status;
	
	@JsonProperty("additionalStatus")
	private String additionalStatus;
	
	@JsonProperty("documents")
	private List<CreditAcceleratorDocument> documents;

	public Long getAccountId() {
		return accountId;
	}

	public String getStatus() {
		return status;
	}

	public String getAdditionalStatus() {
		return additionalStatus;
	}

	public List<CreditAcceleratorDocument> getDocuments() {
		return documents;
	}

}
