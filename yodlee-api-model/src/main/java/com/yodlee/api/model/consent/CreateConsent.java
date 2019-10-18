/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.consent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"consentId", "title", "titleBody", "expirationDate", "dataAccessFrequency", "consentStatus",
		"providerId", "scope"})
public class CreateConsent extends AbstractConsent {

	@Override
	public String toString() {
		return "CreateConsent [getConsentId()=" + getConsentId() + ", getTitle()=" + getTitle() + ", getTitleBody()="
				+ getTitleBody() + ", getScope()=" + getScopes() + ", getExpirationDate()=" + getExpirationDate()
				+ ", getDataAccessFrequency()=" + getDataAccessFrequency() + ", getConsentStatus()="
				+ getConsentStatus() + ", getProviderId()=" + getProviderId() + ", toString()=" + super.toString()
				+ ", validate()=" + validate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
