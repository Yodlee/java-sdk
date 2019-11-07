/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.consent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"consentId", "providerId", "authorizationUrl"})
public class UpdateConsent extends AbstractModelComponent {

	@ApiModelProperty(name = "consentId",
					  value = "Unique identifier for consent. This is created during consent creation.")
	@JsonProperty("consentId")
	private Long consentId;

	@ApiModelProperty(name = "providerId",
					  value = "Unique identifier for the provider account resource. This is created during account addition.")
	@JsonProperty("providerId")
	private Long providerId;

	@ApiModelProperty(name = "authorizationUrl",
					  value = "Authorization url generated for the request through PUT Consent to reach endsite.")
	@JsonProperty("authorizationUrl")
	private String authorizationUrl;

	/**
	 * Unique identifier for consent. This is created during consent creation. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>PUT Consent</li>
	 * </ul>
	 * 
	 * @return consentId
	 */
	public Long getConsentId() {
		return consentId;
	}

	/**
	 * Unique identifier for the provider account resource. This is created during account addition. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>PUT Consent</li>
	 * </ul>
	 * 
	 * @return providerId
	 */
	public Long getProviderId() {
		return providerId;
	}

	/**
	 * Authorization url generated for the request through PUT Consent to reach endsite. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>PUT Consent</li>
	 * </ul>
	 * 
	 * @return authorizationUrl
	 */
	public String getAuthorizationUrl() {
		return authorizationUrl;
	}

	@Override
	public String toString() {
		return "UpdateConsent [consentId=" + consentId + ", providerId=" + providerId + ", authorizationUrl="
				+ authorizationUrl + "]";
	}
}
