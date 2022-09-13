/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.consent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.consent.enums.ConsentStatus;
import com.yodlee.api.model.consent.enums.DataAccessFrequency;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"consentId", "title", "titleBody", "startDate","expirationDate",
		"dataAccessFrequency", "consentStatus",
		"providerId", "applicationDisplayName","otspADR","otspADRName",
		"clientADR","renewal","scope","preferences","thirdPartyADR"})
public abstract class AbstractConsent extends AbstractModelComponent {

	@ApiModelProperty(name = "consentId", required = true, value = "Consent Id generated through POST Consent.")
	@JsonProperty("consentId")
	protected Long consentId;

	@ApiModelProperty(name = "title", required = true, value = "Title for the consent form.")
	@JsonProperty("title")
	protected String title;

	@ApiModelProperty(name = "titleBody", required = true, value = "Description for the title.")
	@JsonProperty("titleBody")
	protected String titleBody;

	@ApiModelProperty(name = "expirationDate", required = true, value = "Consent expiry date.")
	@JsonProperty("expirationDate")
	protected String expirationDate;

	@ApiModelProperty(name = "startDate", required = true, value = "Consent start date.")
	@JsonProperty("startDate")
	protected String startDate;

	@ApiModelProperty(name = "otspADR", required = false, value = "Unique/Accredition Id of the ADR")
	@JsonProperty("otspADR")
	protected String otspADR;

	@ApiModelProperty(name = "otspADRName", required = false, value = "Name of the Accredited Data Recipient/Organization")
	@JsonProperty("otspADRName")
	protected String otspADRName;

	@ApiModelProperty(name = "clientADR", required = true, value = "Client Name of the ADR")
	@JsonProperty("clientADR")
	protected String clientADR;

	@ApiModelProperty(name = "applicationDisplayName", required = true, value = "Application display name.")
	@JsonProperty("applicationDisplayName")
	protected String applicationDisplayName;

	@ApiModelProperty(name = "dataAccessFrequency",
					  required = false,
					  value = "Data Access Frequency explains the number of times that this consent can be used."
							  + "<br>"//
							  + " Otherwise called as consent frequency type.") //
	@JsonProperty("dataAccessFrequency")
	protected DataAccessFrequency dataAccessFrequency;

	@ApiModelProperty(name = "consentStatus", required = true, value = "Status of the consent.")
	@JsonProperty("consentStatus")
	protected ConsentStatus consentStatus;

	@ApiModelProperty(name = "providerId",
					  required = true,
					  value = "Provider Id for which the consent needs to be generated.")
	@JsonProperty("providerId")
	protected Long providerId;

	@ApiModelProperty(name = "renewal",
			required = false,
			value = "Renewal describes the sharing duration and reauthorization required.")
	@JsonProperty("renewal")
	protected Renewal renewal;

	@ApiModelProperty(name = "preferences",
			required = true,
			value = "Preferences describes options about the additional usage of data or purge data")
	@JsonProperty("preferences")
	protected List<Preferences> preferences;

	@ApiModelProperty(name = "scope",
					  required = true,
					  value = "Scope describes about the consent permissions and their purpose.")
	@JsonProperty("scope")
	protected List<Scope> scopes;

	@ApiModelProperty(name = "thirdPartyADR",
			required = false,
			value = "ThirdPartyADR describes details of additional parties which are accredited data recipients under organization")
	@JsonProperty("thirdPartyADR")
	protected List<ThirdPartyADR> thirdPartyADR;

	/**
	 * Consent Id generated through POST Consent. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * </ul>
	 * 
	 * @return consentId
	 */
	public Long getConsentId() {
		return consentId;
	}

	/**
	 * Title for the consent form. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * </ul>
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Description for the title. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * </ul>
	 * 
	 * @return titleBody
	 */
	public String getTitleBody() {
		return titleBody;
	}

	/**
	 * Scope describes about the consent permissions and their purpose. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * </ul>
	 * 
	 * @return scope
	 */
	@JsonProperty("scope")
	public List<Scope> getScopes() {
		return scopes == null ? null : Collections.unmodifiableList(scopes);
	}

	/**
	 * Consent expiry date. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * </ul>
	 * 
	 * @return expirationDate
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * Data Access Frequency explains the number of times that this consent can be used. <br>
	 * Otherwise called as consent frequency type. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * </ul>
	 * 
	 * @return dataAccessFrequency
	 */
	public DataAccessFrequency getDataAccessFrequency() {
		return dataAccessFrequency;
	}

	/**
	 * Status of the consent. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * </ul>
	 * 
	 * @return consentStatus
	 */
	public ConsentStatus getConsentStatus() {
		return consentStatus;
	}

	/**
	 * Unique identifier for the provider site. (e.g., financial institution sites, biller sites, lender sites, etc.).
	 * <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * </ul>
	 * 
	 * @return providerId
	 */
	public Long getProviderId() {
		return providerId;
	}

	public void setConsentId(Long consentId) {
		this.consentId = consentId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTitleBody(String titleBody) {
		this.titleBody = titleBody;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setDataAccessFrequency(DataAccessFrequency dataAccessFrequency) {
		this.dataAccessFrequency = dataAccessFrequency;
	}

	public void setConsentStatus(ConsentStatus consentStatus) {
		this.consentStatus = consentStatus;
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}

	@JsonProperty("scope") public void setScopes(List<Scope> scope) {
		if (scopes == null) {
			scopes = new ArrayList<>();
		}
		scopes = scope;
	}

	public boolean addScope(Scope scope) {
		if (scopes == null) {
			scopes = new ArrayList<>();
		}
		return this.scopes.add(scope);
	}

	public boolean removeScopeId(Scope scope) {
		if (scopes != null) {
			return this.scopes.remove(scope);
		}
		return false;
	}

	public void clearScopeIds() {
		if (scopes != null) {
			scopes.clear();
		}
	}

	/**
	 * Consent start date. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET Consent</li>
	 * </ul>
	 *
	 * @return startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * application display name. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET Consent</li>
	 * </ul>
	 *
	 * @return applicationDisplayName
	 */
	public String getApplicationDisplayName() {
		return applicationDisplayName;
	}

	public void setApplicationDisplayName(String applicationDisplayName) {
		this.applicationDisplayName = applicationDisplayName;
	}

	/**
	 * containing default consent duration and reauthorization eligibility. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET Consent</li>
	 * </ul>
	 *
	 * @return renewal
	 */
	public Renewal getRenewal() {
		return renewal;
	}

	public void setRenewal(Renewal renewal) {
		this.renewal = renewal;
	}
	/**
	 * containing ADR name and Details <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * </ul>
	 *
	 * @return otspADR
	 */
	public String getOtspADR() {
		return otspADR;
	}

	public void setOtspADR(String otspADR) {
		this.otspADR = otspADR;
	}

	/**
	 * containing ADR name and Details <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * </ul>
	 *
	 * @return otspADRName
	 */

	public String getOtspADRName() {
		return otspADRName;
	}

	public void setOtspADRName(String otspADRName) {
		this.otspADRName = otspADRName;
	}

	/**
	 * containing ADR name and Details <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * </ul>
	 *
	 * @return clientADR
	 */
	public String getClientADR() {
		return clientADR;
	}

	public void setClientADR(String clientADR) {
		this.clientADR = clientADR;
	}

	/**
	 * containing Preference of the User on the consent provided<br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * </ul>
	 *
	 * @return preferences
	 */
	@JsonProperty("preferences")
	public List<Preferences> getPreferences() {
		return preferences == null ? null : Collections.unmodifiableList(preferences);
	}


	@JsonProperty("preferences")
	public void setPreferences(List<Preferences> preference) {
		if (preferences == null) {
			preferences = new ArrayList<>();
		}
		preferences = preference;
	}

	/**
	 * containing thirdPartyADR details on the consent provided<br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * </ul>
	 *
	 * @return thirdPartyADR
	 */
	@JsonProperty("thirdPartyADR")
	public List<ThirdPartyADR> getThirdPartyADR() {
		return thirdPartyADR;
	}

	@JsonProperty("thirdPartyADR")
	public void setThirdPartyADR(List<ThirdPartyADR> thirdPartyADR) {
		if (thirdPartyADR == null) {
			thirdPartyADR = new ArrayList<>();
		}
		this.thirdPartyADR = thirdPartyADR;
	}
}
