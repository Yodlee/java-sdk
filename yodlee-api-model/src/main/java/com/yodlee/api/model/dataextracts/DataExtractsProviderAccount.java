/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.dataextracts;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.provideraccounts.AbstractProviderAccount;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "aggregationSource", "providerId", "isManual", "createdDate", "requestId", "status",
		"dataset", "loginForm", "isAutoRefreshPreferred", "isDataExtractsPreferred", "preferences", "isDeleted", "oauthMigrationStatus",
		"destinationProviderAccountId", "sourceProviderAccountIds"})
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

	@ApiModelProperty(readOnly = true,
					  value = "Indicates if the provider account is deleted from the system."//
							  + "<b>Applicable containers</b>: All Containers<br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("isDeleted")
	protected Boolean isDeleted;

	@ApiModelProperty(readOnly = true,
			  value = "The providerAccountId that is retained as part of the many-to-one OAuth migration process.<br>"//
					  + "<b>Endpoints</b>:"//
					  + "<ul>"//
					  + "<li>GET dataExtracts/userData</li>"//
					  + "</ul>")
	@JsonProperty("destinationProviderAccountId")
	protected Long destinationProviderAccountId;

	@ApiModelProperty(readOnly = true,
			  value = "The providerAccountIds that are deleted and merged into the destinationProviderAccountId as part of the many-to-one OAuth migration process.<br>"//
					  + "<b>Endpoints</b>:"//
					  + "<ul>"//
					  + "<li>GET dataExtracts/userData</li>"//
					  + "</ul>")
	@JsonProperty("sourceProviderAccountIds")
	protected List<Long> sourceProviderAccountIds;
	
	@ApiModelProperty(readOnly = true,
			  value = "Attribute to specify whether the user has to input(credentials/MFA) for refreshing an account.<br>"//
					  + "<b>Endpoints</b>:"//
					  + "<ul>"//
					  + "<li>GET providerAccounts</li>"//
					  + "<li>GET GET providerAccounts/{providerAccountId}</li>"//
					  + "</ul>")
	
	@JsonProperty("isRealTimeMFA")
	protected boolean isRealTimeMFA;
	
	@ApiModelProperty(name = "consentId",
			  required = false,
			  value = "Consent Id generated through POST Consent."//
			  + "<br><br>"//
			  + "<b>Endpoints</b>:"//
			  + "<ul>"//
			  + "<li>GET providerAccounts</li>"//
			  + "<li>POST providerAccounts</li>"//
			  + "<li>PUT providerAccounts/{providerAccountId}</li>"//
			  + "<li>GET providerAccounts/{providerAccountId}</li>"//
			  + "</ul>")
	@JsonProperty("consentId")
	private Long consentId;

	public boolean getIsRealTimeMFA() {
		return isRealTimeMFA;
	}
	
	public Long getConsentId() {
		return consentId;
	}

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

	/**
	 * Indicates if the account is marked as deleted. <b>Applicable containers</b>: All Containers<br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET dataExtracts/userData</li>
	 * </ul>
	 * 
	 * @return isDeleted
	 */
	public Boolean getIsDeleted() {
		return isDeleted;
	}



	/**
	 * The providerAccountId that is retained as part of the many-to-one OAuth migration process.<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET dataExtracts/userData</li>
	 * </ul>
	 *
	 * @return the destinationProviderAccountId
	 */
	public Long getDestinationProviderAccountId() {
		return destinationProviderAccountId;
	}



	/**
	 * The providerAccountIds that are deleted and merged into the destinationProviderAccountId as part of the many-to-one OAuth migration process.<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET dataExtracts/userData</li>
	 * </ul>
	 *
	 * @return the sourceProviderAccountIds
	 */
	public List<Long> getSourceProviderAccountIds() {
		return sourceProviderAccountIds;
	}

	@Override
	public String toString() {
		return "DataExtractsProviderAccount [createdDate=" + createdDate + ", id=" + id + ", aggregationSource="
				+ aggregationSource + ", providerId=" + providerId + ", isManual=" + isManual + ", requestId="
				+ requestId + ", status=" + status + ", datasets=" + datasets + ", isDeleted=" + isDeleted 
				+ ", oauthMigrationStatus=" + openBankingMigrationStatusType
				+ ", destinationProviderAccountId=" + destinationProviderAccountId + ", sourceProviderAccountIds=" + sourceProviderAccountIds +"]";
	}
}
