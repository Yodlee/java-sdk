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
@JsonPropertyOrder({"consentId", "title", "titleBody", "expirationDate", "dataAccessFrequency", "consentStatus",
		"providerId", "scope"})
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

	@ApiModelProperty(name = "dataAccessFrequency",
					  required = true,
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

	@ApiModelProperty(name = "scope",
					  required = true,
					  value = "Scope describes about the consent permissions and their purpose.")
	@JsonProperty("scope")
	protected List<Scope> scopes;

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

	@JsonProperty("scope")
	public void setScopes(List<Scope> scope) {
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
}
