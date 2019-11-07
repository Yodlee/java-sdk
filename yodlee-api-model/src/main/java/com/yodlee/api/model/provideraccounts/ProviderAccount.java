/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.provideraccounts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "aggregationSource", "providerId", "consentId", "isManual", "createdDate", "requestId", "status",
		"dataset", "loginForm", "isAutoRefreshPreferred", "isDataExtractsPreferred", "preferences"})
public class ProviderAccount extends AbstractProviderAccount {

	@ApiModelProperty(readOnly = true,
					  value = "The date on when the provider account is created in the system."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts</li>"//
							  + "<li>POST providerAccounts</li>"//
							  + "<li>PUT providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "</ul>")
	@JsonProperty("createdDate")
	private String createdDate;

	@ApiModelProperty(readOnly = true,
					  value = "User preference values for Auto-Refresh and DataExtracts Notification"//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts</li>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "</ul>")
	@JsonProperty("preferences")
	private ProviderAccountPreferences preferences;
	
	@ApiModelProperty(name = "consentId",
			  required = true,
			  value = "Consent Id generated through POST Consent."//
			  + "<br><br>"//
			  + "<b>Endpoints</b>:"//
			  + "<ul>"//
			  + "<li>GET providerAccounts</li>"//
			  + "<li>POST providerAccounts</li>"//
			  + "<li>PUT providerAccounts/{providerAccountId}</li>"//
			  + "<li>GET providerAccounts/{providerAccountId}</li>"//
			  + "</ul>")
	@JsonProperty("consentId")
	private Long consentId;
	
	public Long getConsentId() {
		return consentId;
	}

	/**
	 * The date on when the provider account is created in the system. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts</li>
	 * <li>POST providerAccounts</li>
	 * <li>PUT providerAccounts/{providerAccountId}</li>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * </ul>
	 * 
	 * @return createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * User preference values for Auto-Refresh and DataExtracts Notification <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts</li>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * </ul>
	 * 
	 * @return preferences
	 */
	public ProviderAccountPreferences getPreferences() {
		return preferences;
	}

	@Override
	public String toString() {
		return "ProviderAccount [createdDate=" + createdDate + ", consentId=" + consentId + ", preferences=" + preferences + "]";
	}
}
