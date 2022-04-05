/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class RenewalConsent extends AbstractModelComponent{
	@ApiModelProperty(value = "Consent default renewal duration."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>PUT consents/{consentId}/renewal</li>"//
			+ "</ul>")
	@JsonProperty("defaultRenewalDuration")
	private String defaultRenewalDuration;
	
	@ApiModelProperty(value = "Consent eligibility for reauthorization."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>PUT consents/{consentId}/renewal</li>"//
			+ "</ul>")
	@JsonProperty("isReauthorizationRequired")
	private Boolean isReauthorizationRequired;

	
	/**
	 * Consent default renewal duration. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>PUT consents/{consentId}/renewal</li>
	 * </ul>
	 * 
	 * @return defaultRenewalDuration
	 */
	public String getDefaultRenewalDuration() {
		return defaultRenewalDuration;
	}

	public void setDefaultRenewalDuration(String defaultRenewalDuration) {
		this.defaultRenewalDuration = defaultRenewalDuration;
	}

	/**
	 * Consent eligibility for reauthorization. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>PUT consents/{consentId}/renewal</li>
	 * </ul>
	 * 
	 * @return isReauthorizationRequired
	 */
	public Boolean getIsReauthorizationRequired() {
		return isReauthorizationRequired;
	}

	public void setIsReauthorizationRequired(Boolean isReauthorizationRequired) {
		this.isReauthorizationRequired = isReauthorizationRequired;
	}

	@Override
	public String toString() {
		return "RenewalConsent [defaultRenewalDuration=" + defaultRenewalDuration + ", isReauthorizationRequired="
				+ isReauthorizationRequired + "]";
	}
	
}
