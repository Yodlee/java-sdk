/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.verification.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.verification.UpdateVerification;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateVerificationRequest extends AbstractModelComponent implements Request {

	@JsonProperty("verification")
	private UpdateVerification verification;

	public UpdateVerification getVerification() {
		return verification;
	}

	@JsonProperty("verification")
	public void setVerification(UpdateVerification verification) {
		this.verification = verification;
	}

	@Override
	public String toString() {
		return "UpdateVerificationRequest [verification=" + verification + "]";
	}
}
