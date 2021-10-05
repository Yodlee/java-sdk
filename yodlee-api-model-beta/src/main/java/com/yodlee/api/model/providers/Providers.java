/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.providers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "name", "loginUrl", "baseUrl", "favicon", "logo", "status", "languageISOCode",
		"primaryLanguageISOCode", "lastModified", "isAutoRefreshEnabled", "capability", "dataset", "authType", "help",
		"oAuthSite", "isProviderOwned", "isAddedByUser", "PRIORITY", "countryISOCode", "mfaType", "forgetPasswordUrl",
		"loginHelp", "authParameter", "accountType", "isConsentRequired", "associatedProviderIds"})
public class Providers extends AbstractProvider {

	@ApiModelProperty(readOnly = true,
					  value = "The forget password URL of the provider site."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("forgetPasswordUrl")
	private String forgetPasswordUrl;

	@ApiModelProperty(readOnly = true,
					  value = "Help text to guide the user to choose the correct provider site."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("loginHelp")
	private String loginHelp;

	/**
	 * The forget password URL of the provider site. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return forgetPasswordUrl
	 */
	public String getForgetPasswordUrl() {
		return forgetPasswordUrl;
	}

	/**
	 * Help text to guide the user to choose the correct provider site. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return loginHelp
	 */
	public String getLoginHelp() {
		return loginHelp;
	}

	@Override
	public String toString() {
		return "Providers [forgetPasswordUrl=" + forgetPasswordUrl + ", loginHelp=" + loginHelp + ", id=" + id
				+ ", name=" + name + ", loginUrl=" + loginUrl + ", baseUrl=" + baseUrl + ", favicon=" + favicon
				+ ", logo=" + logo + ", status=" + status + ", languageISOCode=" + languageISOCode
				+ ", primaryLanguageISOCode=" + primaryLanguageISOCode + ", lastModified=" + lastModified
				+ ", isAutoRefreshEnabled=" + isAutoRefreshEnabled + ", capabilities=" + capabilities + ", datasets="
				+ datasets + ", authType=" + authType + ", help=" + help + ", isAddedByUser=" + isAddedByUser
				+ ", priority=" + priority + ", countryISOCode=" + countryISOCode + ", authParameter=" + authParameter
				+ ", accountType=" + accountType + ", isConsentRequired=" + isConsentRequired 
				+ ", associatedProviderIds=" + associatedProviderIds +"]";
	}
}
