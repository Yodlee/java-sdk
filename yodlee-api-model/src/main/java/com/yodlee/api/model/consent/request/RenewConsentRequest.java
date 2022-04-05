/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.consent.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.RenewalConsent;
import com.yodlee.api.model.Request;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RenewConsentRequest extends AbstractModelComponent implements Request{

	@ApiModelProperty(value = "renewal entity from consent details service, containing default consent duration and reauthorization eligibility."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>PUT consents/{consentId}/renewal</li>"//
			+ "</ul>")
	@JsonProperty(value = "renewal", required = true)
	private RenewalConsent renewal;

	/**
	 * renewal entity from consent details service, containing default consent duration and reauthorization eligibility. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>PUT consents/{consentId}/renewal</li>
	 * </ul>
	 * @return renewal
	 */
	public RenewalConsent getRenewal() {
		return renewal;
	}

	public void setRenewal(RenewalConsent renewal) {
		this.renewal = renewal;
	}
}
