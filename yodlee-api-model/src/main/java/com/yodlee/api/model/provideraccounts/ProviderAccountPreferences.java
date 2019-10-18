/*
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.provideraccounts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(value = Include.NON_NULL)
public class ProviderAccountPreferences extends AbstractModelComponent {

	@ApiModelProperty(value = "Indicates if the updates to the provider account should be "
			+ "part of the data extracts event notification or the data extract data retrieval service." + "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providerAccounts?include=preferences</li>"//
			+ "<li>GET providerAccounts/{providerAccountId}?include=preferences</li>"//
			+ "</ul>"//
	)
	@JsonProperty("isDataExtractsEnabled")
	private Boolean isDataExtractsEnabled;

	@ApiModelProperty(value = "Indicates if auto-refreshes have to be triggered for the provider account."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providerAccounts?include=preferences</li>"//
			+ "<li>GET providerAccounts/{providerAccountId}?include=preferences</li>"//
			+ "</ul>"//
	)
	@JsonProperty("isAutoRefreshEnabled")
	private Boolean isAutoRefreshEnabled;
	
	@ApiModelProperty(value = "LinkedproviderAccountd is a providerAccountId linked by the user to the primary provider account. <br>"//
			+ "LinkedProviderAccountId and the providerAccountId belongs to the same institution."
            + "<br><br>"//
            + "<b>Endpoints</b>:"//
            + "<ul>"//
            + "<li>POST Provider Account</li>"//
            + "<li>PUT Provider Account</li>"//
            + "<li>GET Provider Accounts</li>"//
            + "</ul>" )
	@JsonProperty(value ="linkedProviderAccountId", required = false)
	private Long linkedProviderAccountId;

	/**
	 * Indicates if the updates to the provider account should be part of the data extracts event notification or the
	 * data extract data retrieval service. * <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts?include=preferences</li>
	 * <li>GET providerAccounts/{providerAccountId}?include=preferences</li>
	 * </ul>
	 * 
	 * @return isDataExtractsEnabled
	 */
	public Boolean getIsDataExtractsEnabled() {
		return isDataExtractsEnabled;
	}

	public void setIsDataExtractsEnabled(Boolean isDataExtractsEnabled) {
		this.isDataExtractsEnabled = isDataExtractsEnabled;
	}

	/**
	 * Indicates if auto-refreshes have to be triggered for the provider account. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts?include=preferences</li>
	 * <li>GET providerAccounts/{providerAccountId}?include=preferences</li>
	 * </ul>
	 * 
	 * @return isAutoRefreshEnabled
	 */
	public Boolean getIsAutoRefreshEnabled() {
		return isAutoRefreshEnabled;
	}

	public void setIsAutoRefreshEnabled(Boolean isAutoRefreshEnabled) {
		this.isAutoRefreshEnabled = isAutoRefreshEnabled;
	}
	
	
	/**
	* LinkedproviderAccountd is a providerAccountId linked by the user to the primary provider account. <br>
	* LinkedProviderAccountId and the providerAccountId belongs to the same institution.
    * <br><br>
    * <b>Endpoints</b>:
    * <ul>
    * <li>POST Provider Account</li>
    * <li>PUT Provider Account</li>
    * <li>GET Provider Accounts</li>
    * </ul>
    * 
    * @return linkedProviderAccountId
    */
	public Long getLinkedProviderAccountId() {
		return linkedProviderAccountId;
	}
	
	public void setLinkedProviderAccountId(Long linkedProviderAccountId) {
		this.linkedProviderAccountId = linkedProviderAccountId;
	}

	@Override
	public String toString() {
		return "ProviderAccountPreferences [isDataExtractsEnabled=" + isDataExtractsEnabled + ", isAutoRefreshEnabled="
				+ isAutoRefreshEnabled + ", linkedProviderAccountId=" + linkedProviderAccountId + "]";
	}
	
}
