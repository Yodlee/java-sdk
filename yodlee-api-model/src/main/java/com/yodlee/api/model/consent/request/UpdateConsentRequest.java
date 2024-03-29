/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.consent.request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.consent.enums.DataCluster;
import io.swagger.annotations.ApiModelProperty;
import com.yodlee.api.model.consent.ClientTrustedAdvisor;
import com.yodlee.api.model.consent.RenewConsentPreferences;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"scopeId"})
public class UpdateConsentRequest extends AbstractModelComponent implements Request {

	@ApiModelProperty(value = "Applicable Open Banking data cluster values."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>PUT Consent</li>"//
			+ "</ul>")
	@JsonProperty(value = "scopeId", required = true)
	private List<DataCluster> scopeIds;
	


	@ApiModelProperty(value = "preferences for consent renewal."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>PUT consents/{consentId}/renewal</li>"//
			+ "</ul>")
	@JsonProperty("preferences")
	private RenewConsentPreferences preferences;
	
	public RenewConsentPreferences getPreferences() {
		return preferences;
	}

	public void setPreferences(RenewConsentPreferences preferences) {
		this.preferences = preferences;
	}

	@ApiModelProperty(required = true,
			value = "describes information of client trusted advisor")
	@JsonProperty("clientTrustedAdvisor")
	protected List<ClientTrustedAdvisor> clientTrustedAdvisorList;

	

	public List<ClientTrustedAdvisor> getClientTrustedAdvisorList() {
		return clientTrustedAdvisorList;
	}

	public void setClientTrustedAdvisorList(List<ClientTrustedAdvisor> clientTrustedAdvisorList) {
		this.clientTrustedAdvisorList = clientTrustedAdvisorList;
	}

	/**
	 * Applicable Open Banking data cluster values. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>PUT Consent</li>
	 * </ul>
	 * 
	 * @return scopeIds
	 */
	@JsonProperty("scopeId")
	public List<DataCluster> getScopeIds() {
		return scopeIds == null ? null : Collections.unmodifiableList(scopeIds);
	}

	@JsonProperty("scopeId")
	public void setScopeIds(List<DataCluster> scopeId) {
		if (scopeIds == null) {
			scopeIds = new ArrayList<>();
		}
		this.scopeIds = scopeId;
	}

	public boolean addScopeId(DataCluster scopeId) {
		if (scopeIds == null) {
			scopeIds = new ArrayList<>();
		}
		return this.scopeIds.add(scopeId);
	}

	public boolean removeScopeId(DataCluster scopeId) {
		if (scopeIds != null) {
			return this.scopeIds.remove(scopeId);
		}
		return false;
	}

	public void clearScopeIds() {
		if (scopeIds != null) {
			scopeIds.clear();
		}
	}

	@Override
	public String toString() {
		return "UpdateConsentRequest [scopeIds=" + scopeIds + ", preferences=" + preferences
				+ ", clientTrustedAdvisorList=" + clientTrustedAdvisorList + "]";
	}

	
}
