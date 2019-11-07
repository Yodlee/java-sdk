/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.providers;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.LoginForm;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "name", "loginUrl", "baseUrl", "favicon", "logo", "status", "languageISOCode",
		"primaryLanguageISOCode", "lastModified", "isAutoRefreshEnabled", "capability", "dataset", "authType", "help",
		"oAuthSite", "isProviderOwned", "isAddedByUser", "PRIORITY", "countryISOCode", "mfaType", "loginForm",
		"authParameter", "accountType", "isConsentRequired"})
public class ProviderDetail extends AbstractProvider {

	@ApiModelProperty(readOnly = true,
					  value = "This entity represents the structure of the login or MFA form that is displayed to the user at the provider site. For performance reasons, this field is returned only when a single provider is requested in the request."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "</ul>")
	@JsonProperty("loginForm")
	private List<LoginForm> loginForms;

	/**
	 * This entity represents the structure of the login or MFA form that is displayed to the user at the provider site.
	 * For performance reasons, this field is returned only when a single provider is requested in the request. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return loginForm
	 */
	@JsonProperty("loginForm")
	public List<LoginForm> getLoginForms() {
		return loginForms == null ? null : Collections.unmodifiableList(loginForms);
	}

	@Override
	public String toString() {
		return "ProviderDetail [loginForms=" + loginForms + ", id=" + id + ", name=" + name + ", loginUrl=" + loginUrl
				+ ", baseUrl=" + baseUrl + ", favicon=" + favicon + ", logo=" + logo + ", status=" + status
				+ ", languageISOCode=" + languageISOCode + ", primaryLanguageISOCode=" + primaryLanguageISOCode
				+ ", lastModified=" + lastModified + ", isAutoRefreshEnabled=" + isAutoRefreshEnabled
				+ ", capabilities=" + capabilities + ", datasets=" + datasets + ", authType=" + authType + ", help="
				+ help + ", isAddedByUser=" + isAddedByUser + ", priority=" + priority + ", countryISOCode="
				+ countryISOCode + ", authParameter=" + authParameter + ", accountType=" + accountType
				+ ", isConsentRequired=" + isConsentRequired + "]";
	}
}
