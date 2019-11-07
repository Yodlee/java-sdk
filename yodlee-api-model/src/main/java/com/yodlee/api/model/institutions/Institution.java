/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.institutions;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.providers.enums.ProviderPriority;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "name", "loginUrl", "baseUrl", "favicon", "logo", "languageISOCode", "primaryLanguageISOCode", "lastModified", "providerId","isAddedByUser", "PRIORITY", "countryISOCode"})
public class Institution extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "Unique identifier for the provider site."//
							  + "(e.g., financial institution sites, biller sites, lender sites, etc.)."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET institutions</li>"//
							  + "</ul>")
	@JsonProperty("id")
	private Long id;

	@ApiModelProperty(readOnly = true,
					  value = "The name of a provider site."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET institutions</li>"//
							  + "</ul>")
	@JsonProperty("name")
	private String name;

	@ApiModelProperty(readOnly = true,
					  value = "The login URL of the provider's site."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET institutions</li>"//
							  + "</ul>")
	@JsonProperty("loginUrl")
	private String loginUrl;

	@ApiModelProperty(readOnly = true,
					  value = "The base URL of the provider's site."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET institutions</li>"//
							  + "</ul>")
	@JsonProperty("baseUrl")
	private String baseUrl;

	@ApiModelProperty(readOnly = true,
					  value = "Favicon link of the provider."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET institutions</li>"//
							  + "</ul>")
	@JsonProperty("favicon")
	private String favicon;

	@ApiModelProperty(readOnly = true,
					  value = "The logo link of the provider institution. The link will return the logo in the PNG format."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET institutions</li>"//
							  + "</ul>")
	@JsonProperty("logo")
	private String logo;

	@ApiModelProperty(readOnly = true,
					  value = "The language in which the provider details are provided. For example, a site supports two languages English and French. English being the primary language, the provider response will be provided in French depending on the user's locale. The language follows the two letter ISO code."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET institutions</li>"//
							  + "</ul>")
	@JsonProperty("languageISOCode")
	private String languageISOCode;

	@ApiModelProperty(readOnly = true,
					  value = "The primary language of the site."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET institutions</li>"//
							  + "</ul>")
	@JsonProperty("primaryLanguageISOCode")
	private String primaryLanguageISOCode;

	@ApiModelProperty(readOnly = true,
					  value = "Determines when the provider information was updated by Yodlee. If the customer caches the data, the cache is recommended to be refreshed based on this field."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET institutions</li>"//
							  + "</ul>")
	@JsonProperty("lastModified")
	private String lastModified;

	@ApiModelProperty(readOnly = true,
					  value = "providerId"//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET institutions</li>"//
							  + "</ul>")
	@JsonProperty("providerId")
	private final List<Long> providerId = new ArrayList<>();

	@ApiModelProperty(readOnly = true,
					  value = "Indicates that the site has been added by the user at least once."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET institutions</li>"//
							  + "</ul>")
	@JsonProperty("isAddedByUser")
	private String isAddedByUser;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the priority for which the service is invoked."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET institutions</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("PRIORITY")
	private ProviderPriority priority;

	@ApiModelProperty(readOnly = true,
					  value = "Country to which the provider belongs."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET institutions</li>"//
							  + "</ul>")
	@JsonProperty("countryISOCode")
	private String countryISOCode;
	/**
	  * Indicates the priority for which the service is invoked.
	  * <br><br>
	  * <b>Endpoints</b>:
	  * <ul>
	  * <li>GET institutions</li>
	  * </ul>
	  * <b>Applicable Values</b><br>
	  * @return priority
	  */
	@JsonProperty("PRIORITY")
	public ProviderPriority getPriority() {
		return priority;
	}

	/**
	 * Country to which the provider belongs.
	 * <br><br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET institutions</li>
	 * </ul>
	 *  @return countryISOCode
	 */
	public String getCountryISOCode() {
		return countryISOCode;
	}

	/**
	 * Indicates that the site has been added by the user at least once.
	 * <br><br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET institutions</li>
	 * </ul>
	 * @return isAddedByUser
	 */
	public String getIsAddedByUser() {
		return isAddedByUser;
	}

	/**
	 * The logo link of the provider institution. The link will return the logo in the PNG format.
	 * <br><br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET institutions</li>
	 * </ul>
	 * @return logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * The primary language of the site.
	 * <br><br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET institutions</li>
	 * </ul>
	 * @return primaryLanguageISOCode
	 */
	public String getPrimaryLanguageISOCode() {
		return primaryLanguageISOCode;
	}

	/**
	 * Determines when the provider information was updated by Yodlee. If the customer caches the data, the cache is recommended to be refreshed based on this field.
	 * <br><br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET institutions</li>
	 * </ul>
	 * @return lastModified
	 */
	public String getLastModified() {
		return lastModified;
	}

	/**
	 * Unique identifier for the provider site.
	 * (e.g., financial institution sites, biller sites, lender sites, etc.).
	 * <br><br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET institutions</li>
	 * </ul>
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * The base URL of the provider's site.
	 * <br><br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET institutions</li>
	 * </ul>
	 * @return baseUrl
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * Favicon link of the provider.
	 * <br><br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET institutions</li>
	 * </ul>
	 * @return favicon
	 */
	public String getFavicon() {
		return favicon;
	}

	/**
	 * The name of a provider site.
	 * <br><br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET institutions</li>
	 * </ul>
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * The login URL of the provider's site.
	 * <br><br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET institutions</li>
	 * </ul>
	 * @return loginUrl
	 */
	public String getLoginUrl() {
		return loginUrl;
	}

	/**
	 * The language in which the provider details are provided. For example, a site supports two languages English and French. English being the primary language, the provider response will be provided in French depending on the user's locale. The language follows the two letter ISO code.
	 * <br><br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET institutions</li>
	 * </ul>
	 * @return languageISOCode
	 */
	public String getLanguageISOCode() {
		return languageISOCode;
	}

	/**
	 * providerId
	 * <br><br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET institutions</li>
	 * </ul>
	 * @return providerId
	 */
	public List<Long> getProviderId() {
		return providerId;
	}

	@Override
	public String toString() {
		return "Institution [id=" + id
				+ ", name=" + name + ", loginUrl=" + loginUrl + ", baseUrl=" + baseUrl + ", favicon=" + favicon
				+ ", logo=" + logo + ", languageISOCode=" + languageISOCode
				+ ", primaryLanguageISOCode=" + primaryLanguageISOCode + ", lastModified=" + lastModified
				+ ", providerId=" + providerId + ", isAddedByUser=" + isAddedByUser
				+ ", priority=" + priority + ", countryISOCode=" + countryISOCode + "]";
	}
}
