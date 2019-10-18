/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.verification.request;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.verification.Verification;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerificationRequest extends AbstractModelComponent implements Request {

	@JsonProperty("verification")
	@NotNull(message = "{verifications.Verification.required}")
	private Verification verification;

	public Verification getVerification() {
		return verification;
	}

	@JsonProperty("verification")
	public void setVerification(Verification verification) {
		this.verification = verification;
	}

	@Override
	public String toString() {
		return "UpdateVerificationRequest [verification=" + verification + "]";
	}
}
