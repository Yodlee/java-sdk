/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.enums.AdditionalStatusType;
import com.yodlee.api.model.enums.EligibilityStatus;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"additionalStatus", "updateEligibility", "lastUpdated", "nextUpdateScheduled"})
public class AccountDataset extends AbstractDataset {

	@ApiModelProperty(readOnly = true,
					  value = "The status of last update attempted for the dataset. "//
							  + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET providerAccounts</li>"//
							  + "<li>POST providerAccounts</li>"//
							  + "<li>PUT providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("additionalStatus")
	private AdditionalStatusType additionalStatus;

	@ApiModelProperty(readOnly = true,
					  value = "Indicate whether the dataset is eligible for update or not." + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET providerAccounts</li>"//
							  + "<li>POST providerAccounts</li>"//
							  + "<li>PUT providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("updateEligibility")
	private EligibilityStatus updateEligibility;

	@ApiModelProperty(readOnly = true,
					  value = "Indicate when the dataset is last updated successfully for the given provider account."
							  + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET providerAccounts</li>"//
							  + "<li>POST providerAccounts</li>"//
							  + "<li>PUT providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "</ul>")
	@JsonProperty("lastUpdated")
	private String lastUpdated;

	@ApiModelProperty(readOnly = true,
					  value = "Indicate when the last attempt was performed to update the dataset for the given provider account"
							  + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET providerAccounts</li>"//
							  + "<li>POST providerAccounts</li>"//
							  + "<li>PUT providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "</ul>")
	@JsonProperty("lastUpdateAttempt")
	private String lastUpdateAttempt;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates when the next attempt to update the dataset is scheduled."//
							  + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET providerAccounts</li>"//
							  + "<li>POST providerAccounts</li>"//
							  + "<li>PUT providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "</ul>")
	@JsonProperty("nextUpdateScheduled")
	private String nextUpdateScheduled;

	/**
	 * The status of last update attempted for the dataset. <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * <li>GET providerAccounts</li>
	 * <li>POST providerAccounts</li>
	 * <li>PUT providerAccounts/{providerAccountId}</li>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return additional status
	 */
	public AdditionalStatusType getAdditionalStatus() {
		return additionalStatus;
	}

	/**
	 * Indicate whether the dataset is eligible for update or not. * <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * <li>GET providerAccounts</li>
	 * <li>POST providerAccounts</li>
	 * <li>PUT providerAccounts/{providerAccountId}</li>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return eligibility status
	 */
	public EligibilityStatus getUpdateEligibility() {
		return updateEligibility;
	}

	/**
	 * Indicate when the dataset is last updated successfully for the given provider account. <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * <li>GET providerAccounts</li>
	 * <li>POST providerAccounts</li>
	 * <li>PUT providerAccounts/{providerAccountId}</li>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * </ul>
	 * 
	 * @return lastUpdated
	 */
	public String getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * Indicate when the last attempt was performed to update the dataset for the given provider account <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * <li>GET providerAccounts</li>
	 * <li>POST providerAccounts</li>
	 * <li>PUT providerAccounts/{providerAccountId}</li>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * </ul>
	 * 
	 * @return lastUpdateAttempt
	 */
	public String getLastUpdateAttempt() {
		return lastUpdateAttempt;
	}

	/**
	 * Indicates when the next attempt to update the dataset is scheduled. <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * <li>GET providerAccounts</li>
	 * <li>POST providerAccounts</li>
	 * <li>PUT providerAccounts/{providerAccountId}</li>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * </ul>
	 * 
	 * @return nextUpdateScheduled
	 */
	public String getNextUpdateScheduled() {
		return nextUpdateScheduled;
	}

	@Override
	public String toString() {
		return "AccountDataset [additionalStatus=" + additionalStatus + ", updateEligibility=" + updateEligibility
				+ ", lastUpdated=" + lastUpdated + ", lastUpdateAttempt=" + lastUpdateAttempt + ", nextUpdateScheduled="
				+ nextUpdateScheduled + "]";
	}
}
