/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({ "name", "requestingFirmId", "broker", "referenceNo" })
public class CreditAcceleratorRequestingFirm {

	@JsonProperty("name")
	@ApiModelProperty(readOnly = true,
		value = "Name of the requesting firm")
	private String name;

	@JsonProperty("requestingFirmId")
	@ApiModelProperty(readOnly = true,
		value = "Unique identifier for the requesting firm")
	private String requestingFirmId;

	@JsonProperty("broker")
	@ApiModelProperty(readOnly = true,
		value = "Name of the broker")
	private String broker;

	@JsonProperty("referenceNo")
	@ApiModelProperty(readOnly = true,
		value = "Reference number of requesting firm")
	private String referenceNo;
	
	public CreditAcceleratorRequestingFirm(String name, String requestingFirmId, String broker, String referenceNo) {
		super();
		this.name = name;
		this.requestingFirmId = requestingFirmId;
		this.broker = broker;
		this.referenceNo = referenceNo;
	}
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	
	@JsonProperty("requestingFirmId")
	public String getRequestingFirmId() {
		return requestingFirmId;
	}
	
	@JsonProperty("broker")
	public String getBroker() {
		return broker;
	}
	
	@JsonProperty("referenceNo")
	public String getReferenceNo() {
		return referenceNo;
	}
	
}
