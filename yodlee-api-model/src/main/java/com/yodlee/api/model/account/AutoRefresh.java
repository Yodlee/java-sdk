/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.account.enums.AutoRefreshAdditionalStatus;
import com.yodlee.api.model.account.enums.AutoRefreshStatus;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"status", "additionalStatus", "asOfDate"})
public class AutoRefresh {

	@ApiModelProperty(readOnly = true,
					  value = "Indicates whether auto refresh is enabled or disabled."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("status")
	private AutoRefreshStatus status;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the reason for the status."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("additionalStatus")
	private AutoRefreshAdditionalStatus additionalStatus;

	@ApiModelProperty(readOnly = true,
					  value = "Date on which the auto refresh status is determined."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>")
	@JsonProperty("asOfDate")
	private String asOfDate;

	/**
	 * Indicates whether auto refresh is enabled or disabled. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return status
	 */
	public AutoRefreshStatus getStatus() {
		return status;
	}

	/**
	 * Indicates the reason for the status. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return additionalStatus
	 */
	public AutoRefreshAdditionalStatus getAdditionalStatus() {
		return additionalStatus;
	}

	/**
	 * Date on which the auto refresh status is determined. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return asOfDate
	 */
	public String getAsOfDate() {
		return asOfDate;
	}

	@Override
	public String toString() {
		return "AutoRefresh [status=" + status + ", additionalStatus=" + additionalStatus + ", asOfDate=" + asOfDate
				+ "]";
	}
}
