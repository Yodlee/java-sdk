/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.consent.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.consent.CreateConsent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreatedConsentResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty(value = "consent", required = false)
	private List<CreateConsent> consents;

	@JsonProperty("consent")
	public List<CreateConsent> getConsents() {
		return consents == null ? null : Collections.unmodifiableList(consents);
	}

	@Override
	public String toString() {
		return "CreatedConsentResponse [consents=" + consents + "]";
	}
}
