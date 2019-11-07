/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.provideraccounts;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.LoginForm;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "aggregationSource", "providerId", "consentId", "isManual", "createdDate", "requestId",
		"status", "dataset", "loginForm", "isAutoRefreshPreferred", "isDataExtractsPreferred", "preferences"})
public class ProviderAccountDetail extends AbstractProviderAccount {

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

	//
	@ApiModelProperty(readOnly = true,
					  value = "This entity gets returned in the response for only MFA based provider accounts during the add/update account polling process. This indicates that the MFA information is expected from the user to complete the process. This represents the structure of MFA form that is displayed to the user in the provider site."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts</li>"//
							  + "<li>POST providerAccounts</li>"//
							  + "<li>PUT providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "</ul>")
	@JsonProperty("loginForm")
	private List<LoginForm> loginForm;

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
	 * This entity gets returned in the response for only MFA based provider accounts during the add/update account
	 * polling process. This indicates that the MFA information is expected from the user to complete the process. This
	 * represents the structure of MFA form that is displayed to the user in the provider site. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts</li>
	 * <li>POST providerAccounts</li>
	 * <li>PUT providerAccounts/{providerAccountId}</li>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * </ul>
	 * 
	 * @return loginForm
	 */
	public List<LoginForm> getLoginForm() {
		return loginForm == null ? null : Collections.unmodifiableList(loginForm);
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
		return "ProviderAccount [createdDate=" + createdDate + ", loginForm=" + loginForm + ", preferences="
				+ preferences + ", id=" + id + ", consentId=" + consentId + ", aggregationSource=" + aggregationSource
				+ ", providerId=" + providerId + ", isManual=" + isManual + ", requestId=" + requestId + ", status="
				+ status + ", datasets=" + datasets + "]";
	}
}
