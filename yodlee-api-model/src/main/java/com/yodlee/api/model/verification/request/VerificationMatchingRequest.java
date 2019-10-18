/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.verification.request;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.verification.MatchingVerification;

public class VerificationMatchingRequest extends AbstractModelComponent implements Request {
	
	
	@JsonProperty("verification")
	@NotNull(message = "{verifications.MatchingVerification.required}")
	private MatchingVerification verification;

	@JsonProperty("verification")
	public MatchingVerification getVerification() {
		return verification;
	}

	@JsonProperty("verification")
	public void setVerification(MatchingVerification verification) {
		this.verification = verification;
	}

	@Override
	public String toString() {
		return "UpdateVerificationRequest [verification=" + verification + "]";
	}
}
