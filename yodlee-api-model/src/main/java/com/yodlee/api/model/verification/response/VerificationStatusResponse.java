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
import com.yodlee.api.model.verification.Verification;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerificationStatusResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("verification")
	private List<Verification> verifications;

	@JsonProperty("verification")
	public List<Verification> getVerifications() {
		return verifications == null ? null : Collections.unmodifiableList(verifications);
	}

	@Override
	public String toString() {
		return "VerificationStatusResponse [verification=" + verifications + "]";
	}
}
