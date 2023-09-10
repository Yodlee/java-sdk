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
import com.yodlee.api.model.consent.Consent;
import com.yodlee.api.model.consent.ConsentPreferences;
import com.yodlee.api.model.consent.Preferences;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsentPreferencesResponse extends AbstractModelComponent implements Response {

	
	@ApiModelProperty(name = "consentId", required = true, value = "Consent Id generated through POST Consent.")
    @JsonProperty("consentId")
    private Long consentId;
	
	@ApiModelProperty(name = "preferences", required = true, value = "User chosen preference value for consent expiration")
    @JsonProperty("preferences")
    private Preferences preferences;
	
	public Long getConsentId() {
		return consentId;
	}

	public void setConsentId(Long consentId) {
		this.consentId = consentId;
	}

	public Preferences getPreferences() {
		return preferences;
	}

	public void setPreferences(Preferences preferences) {
		this.preferences = preferences;
	}
	
	@Override
	public String toString() {
		return "ConsentPreferencesResponse [consentId=" + consentId + ", preferences=" + preferences + "]";
	}


	
}
