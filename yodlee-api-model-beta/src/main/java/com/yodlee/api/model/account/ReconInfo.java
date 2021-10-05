/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.account.enums.ReconStatus;
import com.yodlee.api.model.account.enums.ReconType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"reconType", "reconStatus", "partnerAccountId", "lastReconDate"})
public class ReconInfo extends AbstractModelComponent {

	@JsonProperty("reconType")
	private ReconType reconType;

	@JsonProperty("reconStatus")
	private ReconStatus reconStatus;

	@JsonProperty("partnerAccountId")
	private String partnerAccountId;

	@JsonProperty("lastReconDate")
	private String lastReconDate;

	public ReconType getReconType() {
		return reconType;
	}

	public void setReconType(ReconType reconType) {
		this.reconType = reconType;
	}

	public ReconStatus getReconStatus() {
		return reconStatus;
	}

	public void setReconStatus(ReconStatus reconStatus) {
		this.reconStatus = reconStatus;
	}

	public String getPartnerAccountId() {
		return partnerAccountId;
	}

	public void setPartnerAccountId(String partnerAccountId) {
		this.partnerAccountId = partnerAccountId;
	}

	public String getLastReconDate() {
		return lastReconDate;
	}

	public void setLastReconDate(String lastReconDate) {
		this.lastReconDate = lastReconDate;
	}

	@Override
	public String toString() {
		return "ReconInfo [reconType=" + reconType + ", reconStatus=" + reconStatus + ", partnerAccountId="
				+ partnerAccountId + ", lastReconDate=" + lastReconDate + "]";
	}
}
