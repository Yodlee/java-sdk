/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.consent.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.RenewalConsent;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.consent.RenewConsentPreferences;
import com.yodlee.api.model.consent.ClientTrustedAdvisor;

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
	
	@ApiModelProperty(value = "preferences for consent renewal."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>PUT consents/{consentId}/renewal</li>"//
			+ "</ul>")
	@JsonProperty("preferences")
	private RenewConsentPreferences preferences;
	
	
	@ApiModelProperty(required = true,value = "describes information of client trusted advisor.")
	@JsonProperty("clientTrustedAdvisor")
	private List<ClientTrustedAdvisor> clientTrustedAdvisor;

	public List<ClientTrustedAdvisor> getClientTrustedAdvisor() {
		return clientTrustedAdvisor;
	}

	public void setClientTrustedAdvisor(List<ClientTrustedAdvisor> clientTrustedAdvisor) {
		this.clientTrustedAdvisor = clientTrustedAdvisor;
	}

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

	
	/**
	 * preferences for consent renewal. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>PUT consents/{consentId}/renewal</li>
	 * </ul>
	 * 
	 * @return preferences
	 */
	
	public RenewConsentPreferences getPreferences() {
		return preferences;
	}

	public void setPreferences(RenewConsentPreferences preferences) {
		this.preferences = preferences;
	}
	
	@Override
	public String toString() {
		return "[renewal=" + renewal + ", preferences=" + preferences + " , clientTrustedAdvisor= " +clientTrustedAdvisor +"]";
	}
}
