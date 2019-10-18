/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.provideraccounts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.enums.AdditionalStatusType;
import com.yodlee.api.model.enums.DatasetNameType;
import com.yodlee.api.model.enums.EligibilityStatus;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "additionalStatus", "updateEligibility", "lastUpdated", "lastUpdateAttempt", "attribute"})
public class DataSetInfo extends AbstractModelComponent {

	@ApiModelProperty(value = "The name of the dataset requested from the provider site" + "<br><br>"//
			+ "<b>Account Type</b>: Manual<br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET accounts</li>"//
			+ "<li>GET accounts/{accountId}</li>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "<li>GET providers</li>"//
			+ "</ul>"//
			+ "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("name")
	private DatasetNameType name;

	@ApiModelProperty(value = "The status of last update attempted for the dataset. " + "<br><br>"//
			+ "<b>Account Type</b>: Aggregated<br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET accounts</li>"//
			+ "<li>GET accounts/{accountId}</li>"//
			+ "</ul>"//
			+ "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("additionalStatus")
	private AdditionalStatusType additionalStatus;

	@ApiModelProperty(value = "Indicate whether the dataset is eligible for update or not." + "<br><br>"//
			+ "<b>Account Type</b>: Aggregated<br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET accounts</li>"//
			+ "<li>GET accounts/{accountId}</li>"//
			+ "</ul>"//
			+ "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("updateEligibility")
	private EligibilityStatus updateEligibility;

	@ApiModelProperty(value = "Indicate when the dataset is last updated successfully for the given provider account."
			+ "<br><br>"//
			+ "<b>Account Type</b>: Aggregated<br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET accounts</li>"//
			+ "<li>GET accounts/{accountId}</li>"//
			+ "</ul>")
	@JsonProperty("lastUpdated")
	private String lastUpdated;

	@ApiModelProperty(value = "Indicate when the last attempt was performed to update the dataset for the given provider account"
			+ "<br><br>"//
			+ "<b>Account Type</b>: Aggregated<br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET accounts</li>"//
			+ "<li>GET accounts/{accountId}</li>"//
			+ "</ul>")
	@JsonProperty("lastUpdateAttempt")
	private String lastUpdateAttempt;

	@ApiModelProperty(value = "Indicate when the next attempt is scheduled to update the dataset for the given provider account"
			+ "<br><br>"//
			+ "<b>Account Type</b>: Aggregated<br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET accounts</li>"//
			+ "<li>GET accounts/{accountId}</li>"//
			+ "</ul>")
	@JsonProperty("nextUpdateScheduled")
	private String nextUpdateScheduled;

	/**
	 * Indicate when the last attempt was performed to update the dataset for the given provider account <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return lastUpdateAttempt
	 */
	public String getLastUpdateAttempt() {
		return lastUpdateAttempt;
	}

	public void setLastUpdateAttempt(String lastUpdateAttempt) {
		this.lastUpdateAttempt = lastUpdateAttempt;
	}

	/**
	 * Indicate whether the dataset is eligible for update or not. * <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return updateEligibility
	 */
	public EligibilityStatus getUpdateEligibility() {
		return updateEligibility;
	}

	public void setUpdateEligibility(EligibilityStatus updateEligibility) {
		this.updateEligibility = updateEligibility;
	}

	/**
	 * The name of the dataset requested from the provider site * <br>
	 * <br>
	 * <b>Account Type</b>: Manual<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return name
	 */
	public DatasetNameType getName() {
		return name;
	}

	public void setName(DatasetNameType name) {
		this.name = name;
	}

	/**
	 * The status of last update attempted for the dataset. * <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return additionalStatus
	 */
	public AdditionalStatusType getAdditionalStatus() {
		return additionalStatus;
	}

	public void setAdditionalStatus(AdditionalStatusType additionalStatus) {
		this.additionalStatus = additionalStatus;
	}

	@Override
	public String toString() {
		return "DataSetInfo [name=" + name + ", additionalStatus=" + additionalStatus + ", updateEligibility="
				+ updateEligibility + ", lastUpdated=" + lastUpdated + ", lastUpdateAttempt=" + lastUpdateAttempt
				+ ", nextUpdateScheduled=" + nextUpdateScheduled + "]";
	}
}
