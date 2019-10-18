/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;
import com.yodlee.api.model.account.enums.CoverageAmountType;
import com.yodlee.api.model.account.enums.CoverageLimitType;
import com.yodlee.api.model.account.enums.CoverageUnitType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"type", "limitType", "unitType", "limit", "cover", "met"})
public class CoverageAmount extends AbstractModelComponent {

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
	private CoverageAmountType type;

	@ApiModelProperty(readOnly = true,
					  value = "The type of coverage limit indicates if the coverage is in-network or out-of-network."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance,investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values:</b><br>")
	@JsonProperty("limitType")
	private CoverageLimitType limitType;

	@ApiModelProperty(readOnly = true,
					  value = "The type of coverage unit indicates if the coverage is for an individual or a family."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance,investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values:</b><br>")
	@JsonProperty("unitType")
	private CoverageUnitType unitType;

	@ApiModelProperty(readOnly = true,
					  value = "The maximum amount that will be paid to an individual or an entity for a covered loss"//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance,investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>")
	@JsonProperty("cover")
	private Money cover;

	@ApiModelProperty(readOnly = true,
					  value = "The amount the insurance company paid for the incurred medical expenses."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance,investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>")
	@JsonProperty("met")
	private Money met;

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
	public CoverageAmountType getType() {
		return type;
	}

	public void setType(CoverageAmountType type) {
		this.type = type;
	}

	/**
	 * The type of coverage limit indicates if the coverage is in-network or out-of-network. <br>
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
	 * @return limitType
	 */
	public CoverageLimitType getLimitType() {
		return limitType;
	}

	public void setLimitType(CoverageLimitType limitType) {
		this.limitType = limitType;
	}

	/**
	 * The type of coverage unit indicates if the coverage is for an individual or a family. <br>
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
	 * @return unitType
	 */
	public CoverageUnitType getUnitType() {
		return unitType;
	}

	public void setUnitType(CoverageUnitType unitType) {
		this.unitType = unitType;
	}

	/**
	 * The maximum amount that will be paid to an individual or an entity for a covered loss <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: insurance,investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return cover
	 */
	public Money getCover() {
		return cover;
	}

	public void setCover(Money cover) {
		this.cover = cover;
	}

	/**
	 * The amount the insurance company paid for the incurred medical expenses. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: insurance,investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return met
	 */
	public Money getMet() {
		return met;
	}

	public void setMet(Money met) {
		this.met = met;
	}

	@Override
	public String toString() {
		return "CoverageAmount [type=" + type + ", limitType=" + limitType + ", unitType=" + unitType + ", cover="
				+ cover + ", met=" + met + "]";
	}
}
