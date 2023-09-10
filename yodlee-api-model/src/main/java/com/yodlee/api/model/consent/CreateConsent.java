/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
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
		return "CreateConsent [consentId=" + consentId + ", title=" + title + ", titleBody=" + titleBody
				+ ", expirationDate=" + expirationDate + ", startDate=" + startDate + ", revokeDate=" + revokeDate
				+ ", providerConsentId=" + providerConsentId + ", revokeDateTime=" + revokeDateTime
				+ ", expirationDateTime=" + expirationDateTime + ", startDateTime=" + startDateTime + ", otspADR="
				+ otspADR + ", otspADRName=" + otspADRName + ", clientADR=" + clientADR + ", applicationDisplayName="
				+ applicationDisplayName + ", dataAccessFrequency=" + dataAccessFrequency + ", consentStatus="
				+ consentStatus + ", providerId=" + providerId + ", renewal=" + renewal + ", preferences=" + preferences
				+ ", links=" + links + ", scopes=" + scopes + ", thirdPartyADR=" + thirdPartyADR
				+ ", userDataTreatment=" + userDataTreatment + ", clientTrustedAdvisorList=" + clientTrustedAdvisorList
				+ "]";
	}
	
}
