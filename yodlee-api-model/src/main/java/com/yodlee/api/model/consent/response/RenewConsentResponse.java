/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.consent.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.consent.RenewConsent;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RenewConsentResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty(value = "consent", required = false)
	private RenewConsent consent;

	@JsonProperty("consent")
	public RenewConsent getConsent() {
		return consent == null ? null : consent;
	}

	@Override
	public String toString() {
		return "RenewConsentResponse [consent=" + consent + "]";
	}
}

