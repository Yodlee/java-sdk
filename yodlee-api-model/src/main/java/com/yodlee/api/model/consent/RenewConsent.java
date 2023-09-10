/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.consent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"consentId", "title", "titleBody", "expirationDate","dataAccessFrequency","consentStatus","providerId", "providerAccountId","scope"})
public class RenewConsent extends AbstractConsent {
	
	
	@ApiModelProperty(readOnly = true,
			  value = "Authorization url generated for the request through PUT Consent to reach endsite. <br>" //
			  		+ "OR during get authorization url call. <br>" //
			  		  + "This is created during account addition."//
					  + "<br><br>"//
					  + "<b>Endpoints</b>:"//
					  + "<ul>"//
					  + "<li>GET providerAccounts</li>"//
					  + "</ul>")
	@JsonProperty("authorizationUrl")
	private String authorizationUrl;
	
	/**
	* Authorization url generated for the request through PUT Consent to reach endsite. <br>
	* OR during get authorization url call. <br>
	* <br>
	* <b>Endpoints</b>:
	* <ul>
	* <li>GET Consent</li>
	* </ul>
	* 
	* @return authorizationUrl
	*/
	public String getAuthorizationUrl() {
		return authorizationUrl;
	}
	@ApiModelProperty(readOnly = true,
			  value = "Unique identifier for the provider account resource. <br>" //
			  		  + "This is created during account addition."//
					  + "<br><br>"//
					  + "<b>Endpoints</b>:"//
					  + "<ul>"//
					  + "<li>GET providerAccounts</li>"//
					  + "<li>GET accounts</li>"//
					  + "<li>GET consents</li>"//
					  + "</ul>")
	@JsonProperty("providerAccountId")
	private Long providerAccountId;
	
	
	/**
	* Unique identifier for the provider account resource. <br> <br>
	* This is created during account addition. <br>
	* <br>
	* <b>Endpoints</b>:
	* <ul>
	* <li>GET providerAccounts</li>
	* </ul>
	* 
	* @return providerAccountId
	*/
	public Long getproviderAccountId() {
		return providerAccountId;
	}


	@Override
	public String toString() {
		return "RenewConsent [authorizationUrl=" + authorizationUrl + ", providerAccountId=" + providerAccountId
				+ ", consentId=" + consentId + ", title=" + title + ", titleBody=" + titleBody + ", expirationDate="
				+ expirationDate + ", startDate=" + startDate + ", applicationDisplayName=" + applicationDisplayName
				+ ", dataAccessFrequency=" + dataAccessFrequency + ", consentStatus=" + consentStatus + ", providerId="
				+ providerId + ", renewal=" + renewal + ", scopes=" + scopes + ", otspADR="
				+ otspADR + ", otspADRName=" + otspADRName + ", clientADR=" + clientADR + ", preferences=" + preferences + ", thirdPartyADR=" + thirdPartyADR + "]";
	}

}
