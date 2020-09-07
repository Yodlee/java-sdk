/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
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
