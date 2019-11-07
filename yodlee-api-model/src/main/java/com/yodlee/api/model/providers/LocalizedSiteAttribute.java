/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.providers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "countryISOCode", "languageISOCode", "name", "nameWithCountry", "loginURL", "baseURL", "help",
		"forgetPasswordURL", "loginHelp"})
public class LocalizedSiteAttribute extends AbstractModelComponent {

	@ApiModelProperty(value = "Locale ID Supported")
	@JsonProperty("id")
	private String id;

	@ApiModelProperty(value = "Country supported")
	@JsonProperty("countryISOCode")
	private String countryISOCode;

	@ApiModelProperty(value = "Language supported")
	@JsonProperty("languageISOCode")
	private String languageISOCode;

	@ApiModelProperty(value = "Site name")
	@JsonProperty("name")
	private String name;

	@ApiModelProperty(value = "Site namesuffixed with country name.")
	@JsonProperty("nameWithCountry")
	private String nameWithCountry;

	@ApiModelProperty(value = "The login URL of the provider's site.")
	@JsonProperty("loginURL")
	private String loginURL;

	@ApiModelProperty(value = "The base URL of the provider's site.")
	@JsonProperty("baseURL")
	private String baseURL;

	@ApiModelProperty(value = "Text to guide user through linking an account that belongs to the site")
	@JsonProperty("help")
	private String help;

	@ApiModelProperty(value = "The forget password URL of the provider site.")
	@JsonProperty("forgetPasswordURL")
	private String forgetPasswordURL;

	@ApiModelProperty(value = "Help text to guide the user to choose the correct provider site.")
	@JsonProperty("loginHelp")
	private String loginHelp;

	@Override
	public String toString() {
		return "LocalizedSiteAttribute [id=" + id + ", countryISOCode=" + countryISOCode + ", languageISOCode="
				+ languageISOCode + ", name=" + name + ", nameWithCountry=" + nameWithCountry + ", loginURL=" + loginURL
				+ ", baseURL=" + baseURL + ", help=" + help + ", forgetPasswordURL=" + forgetPasswordURL
				+ ", loginHelp=" + loginHelp + "]";
	}

	/**
	 * Locale ID Supported
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Country supported
	 * 
	 * @return countryISOCode
	 */
	public String getCountryISOCode() {
		return countryISOCode;
	}

	/**
	 * Language supported
	 * 
	 * @return languageISOCode
	 */
	public String getLanguageISOCode() {
		return languageISOCode;
	}

	/**
	 * Site name
	 * 
	 * @return site name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Site namesuffixed with country name.
	 * 
	 * @return nameWithCountry
	 */
	public String getNameWithCountry() {
		return nameWithCountry;
	}

	/**
	 * The login URL of the provider's site.
	 * 
	 * @return loginURL
	 */
	public String getLoginURL() {
		return loginURL;
	}

	/**
	 * The base URL of the provider's site.
	 * 
	 * @return baseURL
	 */
	public String getBaseURL() {
		return baseURL;
	}

	/**
	 * Text to guide user through linking an account that belongs to the site
	 * 
	 * @return help
	 */
	public String getHelp() {
		return help;
	}

	/**
	 * The forget password URL of the provider site.
	 * 
	 * @return forgetPasswordURL
	 */
	public String getForgetPasswordURL() {
		return forgetPasswordURL;
	}

	/**
	 * Help text to guide the user to choose the correct provider site.
	 * 
	 * @return loginHelp
	 */
	public String getLoginHelp() {
		return loginHelp;
	}
}
