/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.dataextracts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.provideraccounts.AbstractProviderAccount;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "aggregationSource", "providerId", "isManual", "createdDate", "requestId", "status",
		"dataset", "loginForm", "isAutoRefreshPreferred", "isDataExtractsPreferred", "preferences"})
public class DataExtractsProviderAccount extends AbstractProviderAccount {

	@ApiModelProperty(readOnly = true,
					  value = "The date on when the provider account is created in the system."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts</li>"//
							  + "<li>POST providerAccounts</li>"//
							  + "<li>PUT providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "</ul>")
	@JsonProperty("createdDate")
	private String createdDate;

	/**
	 * The date on when the provider account is created in the system. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts</li>
	 * <li>POST providerAccounts</li>
	 * <li>PUT providerAccounts/{providerAccountId}</li>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * </ul>
	 * 
	 * @return createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	@Override
	public String toString() {
		return "DataExtractsProviderAccount [createdDate=" + createdDate + ", id=" + id + ", aggregationSource="
				+ aggregationSource + ", providerId=" + providerId + ", isManual=" + isManual + ", requestId="
				+ requestId + ", status=" + status + ", datasets=" + datasets + "]";
	}
}
