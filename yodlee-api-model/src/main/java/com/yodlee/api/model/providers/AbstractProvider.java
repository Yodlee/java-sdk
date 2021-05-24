/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.providers;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.ProvidersDataset;
import com.yodlee.api.model.providers.enums.ProviderAccountType;
import com.yodlee.api.model.providers.enums.ProviderAuthParameter;
import com.yodlee.api.model.providers.enums.ProviderAuthenticationType;
import com.yodlee.api.model.providers.enums.ProviderPriority;
import com.yodlee.api.model.providers.enums.ProviderStatus;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractProvider extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "Unique identifier for the provider site"
							  + "(e.g., financial institution sites, biller sites, lender sites, etc.)."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("id")
	protected Long id;

	@ApiModelProperty(readOnly = true,
					  value = "The name of a provider site."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("name")
	protected String name;

	@ApiModelProperty(readOnly = true,
					  value = "The login URL of the provider's site."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("loginUrl")
	protected String loginUrl;

	@ApiModelProperty(readOnly = true,
					  value = "The base URL of the provider's site."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("baseUrl")
	protected String baseUrl;

	@ApiModelProperty(readOnly = true,
					  value = "Favicon link of the provider."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("favicon")
	protected String favicon;

	@ApiModelProperty(readOnly = true,
					  value = "The logo link of the provider institution. The link will return the logo in the PNG format."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("logo")
	protected String logo;

	@ApiModelProperty(readOnly = true,
					  value = "Determines if the provider is supported for the cobrand (customer), is in the beta stage, etc. "//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("status")
	protected ProviderStatus status;

	@ApiModelProperty(readOnly = true,
					  value = "The language in which the provider details are provided. For example, a site supports two languages English and French. English being the primary language, the provider response will be provided in French depending on the user's locale. The language follows the two letter ISO code."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("languageISOCode")
	protected String languageISOCode;

	@ApiModelProperty(readOnly = true,
					  value = "The primary language of the site."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("primaryLanguageISOCode")
	protected String primaryLanguageISOCode;

	@ApiModelProperty(readOnly = true,
					  value = "Determines when the provider information was updated by Yodlee. If the customer caches the data, the cache is recommended to be refreshed based on this field."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("lastModified")
	protected String lastModified;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates if a provider site is auto-refreshed."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("isAutoRefreshEnabled")
	protected Boolean isAutoRefreshEnabled;

	@Deprecated
	@ApiModelProperty(readOnly = true,
					  value = "Capability of the site"//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul><br>" + "<b>Note : </b> capability has been deprecated")
	@JsonProperty("capability")
	protected List<Capability> capabilities;

	@ApiModelProperty(readOnly = true,
					  value = "Logical grouping of dataset attributes into datasets such as Basic Aggregation Data, Account Profile and Documents"//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("dataset")
	protected List<ProvidersDataset> datasets;

	@ApiModelProperty(readOnly = true,
					  value = "The authentication type enabled at the provider site. "//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("authType")
	protected ProviderAuthenticationType authType;

	//
	@ApiModelProperty(readOnly = true,
					  value = "Text to guide user through linking an account that belongs to the site"//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("help")
	protected String help;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates that the site has been added by the user at least once."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("isAddedByUser")
	protected String isAddedByUser;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the priority for which the service is invoked."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("PRIORITY")
	protected ProviderPriority priority;

	@ApiModelProperty(readOnly = true,
					  value = "Country to which the provider belongs."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("countryISOCode")
	protected String countryISOCode;

	@ApiModelProperty(readOnly = true,
					  value = "AuthParameter appears in the response only in case of token-based aggregation sites."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("authParameter")
	protected List<ProviderAuthParameter> authParameter;

	@ApiModelProperty(readOnly = true,
					  value = "AccountType supported by the provider, eg: Brokerage Cash, Current"//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("accountType")
	protected List<ProviderAccountType> accountType;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates if a provider site requires consent."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "<li>GET providers</li>"//
							  + "</ul>")
	@JsonProperty("isConsentRequired")
	protected Boolean isConsentRequired;

	/**
	 * Indicates the priority for which the service is invoked. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return PRIORITY
	 */
	@JsonProperty("PRIORITY")
	public ProviderPriority getPriority() {
		return priority;
	}

	/**
	 * Country to which the provider belongs. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return countryISOCode
	 */
	public String getCountryISOCode() {
		return countryISOCode;
	}

	/**
	 * The logo link of the provider institution. The link will return the logo in the PNG format. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * Indicates if a provider site is auto-refreshed. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return isAutoRefreshEnabled
	 */
	public Boolean getIsAutoRefreshEnabled() {
		return isAutoRefreshEnabled;
	}

	/**
	 * The primary language of the site. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return primaryLanguageISOCode
	 */
	public String getPrimaryLanguageISOCode() {
		return primaryLanguageISOCode;
	}

	/**
	 * Determines when the provider information was updated by Yodlee. If the customer caches the data, the cache is
	 * recommended to be refreshed based on this field. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return lastModified
	 */
	public String getLastModified() {
		return lastModified;
	}

	/**
	 * Determines if the provider is supported for the cobrand (customer), is in the beta stage, etc. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return status
	 */
	public ProviderStatus getStatus() {
		return status;
	}

	/**
	 * Unique identifier for the provider site (e.g., financial institution sites, biller sites, lender sites, etc.).
	 * <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * The base URL of the provider's site. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return baseUrl
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * Logical grouping of dataset attributes into datasets such as Basic Aggregation Data, Account Profile and
	 * Documents <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return dataset
	 */
	@JsonProperty("dataset")
	public List<ProvidersDataset> getDataset() {
		return datasets == null ? null : Collections.unmodifiableList(datasets);
	}

	/**
	 * Favicon link of the provider. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return favicon
	 */
	public String getFavicon() {
		return favicon;
	}

	/**
	 * The name of a provider site. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * The login URL of the provider's site. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return loginUrl
	 */
	public String getLoginUrl() {
		return loginUrl;
	}

	/**
	 * The authentication type enabled at the provider site. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return authType
	 */
	public ProviderAuthenticationType getAuthType() {
		return authType;
	}

	/**
	 * The language in which the provider details are provided. For example, a site supports two languages English and
	 * French. English being the primary language, the provider response will be provided in French depending on the
	 * user's locale. The language follows the two letter ISO code. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return languageISOCode
	 */
	public String getLanguageISOCode() {
		return languageISOCode;
	}

	/**
	 * Capability of the site <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * <b> Note : </b> capability has been deprecated
	 * 
	 * @return capability
	 */
	@Deprecated
	@JsonProperty("capability")
	public List<Capability> getCapability() {
		return capabilities == null ? null : Collections.unmodifiableList(capabilities);
	}

	/**
	 * Text to guide user through linking an account that belongs to the site <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return help
	 */
	public String getHelp() {
		return help;
	}

	/**
	 * Indicates that the site has been added by the user at least once. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return the isAddedByUser
	 */
	public String getIsAddedByUser() {
		return isAddedByUser;
	}

	/**
	 * AuthParameter appears in the response only in case of token-based aggregation sites. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return authParameter
	 */
	public List<ProviderAuthParameter> getAuthParameter() {
		return authParameter == null ? null : Collections.unmodifiableList(authParameter);
	}

	/**
	 * AccountType supported by the provider, eg: Brokerage Cash, Current <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return accountType
	 */
	public List<ProviderAccountType> getAccountType() {
		return accountType == null ? null : Collections.unmodifiableList(accountType);
	}

	/**
	 * Indicates if a provider site requires consent. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return isConsentRequired
	 */
	public Boolean getIsConsentRequired() {
		return isConsentRequired;
	}

	@ApiModelProperty(readOnly = true,
					  value = "The screen-scraping providers that are associated to the Open Banking provider ID."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: All Containers<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providers</li>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "</ul>")
	@JsonProperty("associatedProviderIds")
	protected List<Long> associatedProviderIds;

	/**
	 * The screen-scraping providers that are associated to the Open Banking provider ID. <br>
	 * <br>
	 * <b>Applicable containers</b>: All Containers<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return associatedProviderIds
	 */
	@JsonProperty("associatedProviderIds")
	public List<Long> getAssociatedProviderIds() {
		return associatedProviderIds == null ? null : Collections.unmodifiableList(associatedProviderIds);
	}
}
