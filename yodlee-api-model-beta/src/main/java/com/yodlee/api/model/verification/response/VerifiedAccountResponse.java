/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.verification.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.enums.AdditionalStatusType;
import com.yodlee.api.model.verification.VerifiedAccounts;
import com.yodlee.api.model.verification.enums.VerifiedAccountsVerificationState;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerifiedAccountResponse extends AbstractModelComponent implements Response {
	
	@ApiModelProperty(readOnly = true)
	@JsonProperty("verifiedAccount")
	private List<VerifiedAccounts> verifiedAccountList;
	
	@ApiModelProperty(readOnly = true, value = "The unique identifier for the verification request that returns contextual data")
	@JsonProperty("requestId")
	private String requestId;
	
	@ApiModelProperty(readOnly = true, value = "The date of the verification request")
	@JsonProperty("requestDate")
	private String requestDate;
	
	@ApiModelProperty(readOnly = true, value = "The overall status of the verification request")
	@JsonProperty("state")
	private VerifiedAccountsVerificationState state;

	@ApiModelProperty(readOnly = true, value= "The reason for the failure of the verification request")
	@JsonProperty("failedReason")
	private AdditionalStatusType failedReason;

	@JsonProperty("verifiedAccount")
	public List<VerifiedAccounts> getVerifiedAccountList() {
		return verifiedAccountList == null ? null : Collections.unmodifiableList(verifiedAccountList);
	}

	@JsonProperty("requestId")
	public String getRequestId() {
		return requestId;
	}

	@JsonProperty("requestDate")
	public String getRequestDate() {
		return requestDate;
	}

	@JsonProperty("state")
	public VerifiedAccountsVerificationState getState() {
		return state;
	}

	@JsonProperty("failedReason")
	public AdditionalStatusType getFailedReason() {
		return failedReason;
	}

	@Override
	public String toString() {
		return "VerifiedAccountResponse [verifiedAccountList=" + verifiedAccountList + ", requestId=" + requestId
				+ ", requestDate=" + requestDate + ", state=" + state + ", failedReason=" + failedReason + "]";
	}
}

