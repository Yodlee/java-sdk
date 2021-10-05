/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.provideraccounts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"statusCode", "statusMessage", "lastRefreshed", "lastRefreshAttempt", "nextRefreshScheduled",
		"lastUpdated"})
public class RefreshInfo extends AbstractModelComponent {

	@ApiModelProperty(value = "Error code")
	@JsonProperty("statusCode")
	private String statusCode;

	@ApiModelProperty(value = "Detailed error description")
	@JsonProperty("statusMessage")
	private String statusMessage;

	@ApiModelProperty(value = "The balance and the details last successfully updated")
	@JsonProperty("lastRefreshed")
	private String lastRefreshed;

	@ApiModelProperty(value = "The last attempt made to refresh the account")
	@JsonProperty("lastRefreshAttempt")
	private String lastRefreshAttempt;

	@ApiModelProperty(value = "Next refresh scheduled time")
	@JsonProperty("nextRefreshScheduled")
	private String nextRefreshScheduled;

	@ApiModelProperty(value = "Last Updated date and time")
	@JsonProperty("lastUpdated")
	private String lastUpdated;

	/**
	 * Error code
	 * 
	 * @return error code
	 */
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Detailed error description
	 * 
	 * @return statusMessage
	 */
	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	/**
	 * The balance and the details last successfully updated
	 * 
	 * @return lastRefreshed
	 */
	public String getLastRefreshed() {
		return lastRefreshed;
	}

	public void setLastRefreshed(String lastRefreshed) {
		this.lastRefreshed = lastRefreshed;
	}

	/**
	 * The last attempt made to refresh the account
	 * 
	 * @return lastRefreshAttempt
	 */
	public String getLastRefreshAttempt() {
		return lastRefreshAttempt;
	}

	public void setLastRefreshAttempt(String lastRefreshAttempt) {
		this.lastRefreshAttempt = lastRefreshAttempt;
	}

	/**
	 * Next refresh scheduled time
	 * 
	 * @return nextRefreshScheduled
	 */
	public String getNextRefreshScheduled() {
		return nextRefreshScheduled;
	}

	public void setNextRefreshScheduled(String nextRefreshScheduled) {
		this.nextRefreshScheduled = nextRefreshScheduled;
	}

	/**
	 * Last Updated date and time
	 * 
	 * @return lastUpdated
	 */
	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "RefreshInfo [statusCode=" + statusCode + ", statusMessage=" + statusMessage + ", lastRefreshed="
				+ lastRefreshed + ", lastRefreshAttempt=" + lastRefreshAttempt + ", nextRefreshScheduled="
				+ nextRefreshScheduled + ", lastUpdated=" + lastUpdated + "]";
	}
}
