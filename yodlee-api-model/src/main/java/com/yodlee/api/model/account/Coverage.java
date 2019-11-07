/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.account;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.account.enums.CoveragePlanType;
import com.yodlee.api.model.account.enums.CoverageType;
import io.swagger.annotations.ApiModelProperty;

public class Coverage extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "The type of coverage provided to an individual or an entity."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance,investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values:</b><br>")
	@JsonProperty("type")
	private CoverageType type;

	@ApiModelProperty(readOnly = true,
					  value = "The date on which the coverage for the account starts."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance,investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>")
	@JsonProperty("startDate")
	private String startDate;

	@ApiModelProperty(readOnly = true,
					  value = "The date on which the coverage for the account ends or expires."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance,investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>")
	@JsonProperty("endDate")
	private String endDate;

	@ApiModelProperty(readOnly = true,
					  value = "The coverage amount-related details."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance,investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>")
	@JsonProperty("amount")
	private List<CoverageAmount> amount;

	@ApiModelProperty(readOnly = true,
					  value = "The plan type for an insurance provided to an individual or an entity."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values:</b><br>")
	@JsonProperty("planType")
	private CoveragePlanType planType;

	/**
	 * The type of coverage provided to an individual or an entity. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: insurance,investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * <b>Applicable Values:</b><br>
	 * 
	 * @return type
	 */
	public CoverageType getType() {
		return type;
	}

	public void setType(CoverageType type) {
		this.type = type;
	}

	/**
	 * The date on which the coverage for the account starts. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: insurance,investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * The date on which the coverage for the account ends or expires. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: insurance,investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * The coverage amount-related details. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: insurance,investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return amount
	 */
	public List<CoverageAmount> getAmount() {
		return amount;
	}

	public void setAmount(List<CoverageAmount> amount) {
		this.amount = amount;
	}

	/**
	 * The plan type for an insurance provided to an individual or an entity. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: insurance<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * <b>Applicable Values:</b><br>
	 * 
	 * @return planType
	 */
	public CoveragePlanType getPlanType() {
		return planType;
	}

	public void setPlanType(CoveragePlanType planType) {
		this.planType = planType;
	}

	@Override
	public String toString() {
		return "Coverage [type=" + type + ", startDate=" + startDate + ", endDate=" + endDate + ", amount=" + amount
				+ ", planType=" + planType + "]";
	}
}
