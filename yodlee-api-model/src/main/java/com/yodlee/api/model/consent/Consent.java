/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.consent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"consentId", "title", "titleBody", "expirationDate","dataAccessFrequency","consentStatus","providerId", "providerAccountId","scope"})
public class Consent extends AbstractConsent {
	
	
	@ApiModelProperty(readOnly = true,
			  value = "Unique identifier for the provider account resource. <br>" //
			  		  + "This is created during account addition."//
					  + "<br><br>"//
					  + "<b>Endpoints</b>:"//
					  + "<ul>"//
					  + "<li>GET providerAccounts</li>"//
					  + "</ul>")
	@JsonProperty("providerAccountId")
	private Long id;
	
	/**
	* Unique identifier for the provider account resource. <br>
	* This is created during account addition.
	* <br><br>
	* <b>Endpoints</b>:
	* <ul>
	* <li>GET Consent</li>
	* </ul>
	* 
	* @return id
	*/
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Consent [id=" + id + ", consentId=" + consentId + ", title=" + title + ", titleBody=" + titleBody
				+ ", expirationDate=" + expirationDate + ", dataAccessFrequency=" + dataAccessFrequency
				+ ", consentStatus=" + consentStatus + ", providerId=" + providerId + ", scopes=" + scopes + "]";
	}
	
}
