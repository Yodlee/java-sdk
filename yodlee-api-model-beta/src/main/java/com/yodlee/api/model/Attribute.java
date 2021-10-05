/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.providers.ContainerAttributes;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "container", "containerAttributes", "fromDate", "toDate", "fromFinYear", "toFinYear"})
public class Attribute extends AbstractAttribute {

	/**
	 * Applicable only to TRANSACTIONS attributes of BASIC_AGG_DATA dataset.
	 */
	@ApiModelProperty(readOnly = true, value = "Applicable only to TRANSACTIONS attributes of BASIC_AGG_DATA dataset."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providers</li>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "<li>POST providerAccounts</li>"//
			+ "<li>PUT providerAccounts</li>"//
			+ "</ul>"//
	)
	@JsonProperty("containerAttributes")
	private ContainerAttributes containerAttributes;

	/**
	 * Applicable only to TRANSACTIONS attributes of BASIC_AGG_DATA dataset. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers</li>
	 * <li>GET providers/{providerId}</li>
	 * <li>POST providerAccounts</li>
	 * <li>PUT providerAccounts</li>
	 * </ul>
	 * 
	 * @return container attributes
	 */
	public ContainerAttributes getContainerAttributes() {
		return containerAttributes;
	}

	public void setContainerAttributes(ContainerAttributes containerAttributes) {
		this.containerAttributes = containerAttributes;
	}

	@ApiModelProperty(readOnly = true, value = "Applicable only to EBILLS and STATEMENTS attributes of DOCUMENT dataset."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>POST providerAccounts</li>"//
			+ "<li>PUT providerAccounts</li>"//
			+ "</ul>"//
	)
	@JsonProperty("fromDate")
	private String fromDate;
	
	@ApiModelProperty(readOnly = true, value = "Applicable only to EBILLS and STATEMENTS attributes of DOCUMENT dataset."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>POST providerAccounts</li>"//
			+ "<li>PUT providerAccounts</li>"//
			+ "</ul>"//
	)
	@JsonProperty("toDate")
	private String toDate;
	
	@ApiModelProperty(readOnly = true, value = "Applicable only to TAX attribute of DOCUMENT dataset."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>POST providerAccounts</li>"//
			+ "<li>PUT providerAccounts</li>"//
			+ "</ul>"//
	)
	@JsonProperty("fromFinYear")
	private String fromFinYear;
	
	@ApiModelProperty(readOnly = true, value = "Applicable only to TAX attribute of DOCUMENT dataset."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>POST providerAccounts</li>"//
			+ "<li>PUT providerAccounts</li>"//
			+ "</ul>"//
	)
	@JsonProperty("toFinYear")
	private String toFinYear;

	
	/**
	 * Applicable only to EBILLS and STATEMENTS attributes of DOCUMENT dataset.
	 * <br><br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST providerAccounts</li>
	 * <li>PUT providerAccounts</li>
	 * </ul>
	 * 
	 * @return fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}

	
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * Applicable only to EBILLS and STATEMENTS attributes of DOCUMENT dataset.
	 * <br><br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST providerAccounts</li>
	 * <li>PUT providerAccounts</li>
	 * </ul>
	 * 
	 * @return toDate
	 */
	public String getToDate() {
		return toDate;
	}

	
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	/**
	 * Applicable only to TAX attribute of DOCUMENT dataset.
	 * <br><br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST providerAccounts</li>
	 * <li>PUT providerAccounts</li>
	 * </ul> 
	 * 
	 * @return fromFinYear
	 */
	public String getFromFinYear() {
		return fromFinYear;
	}

	
	public void setFromFinYear(String fromFinYear) {
		this.fromFinYear = fromFinYear;
	}

	/**
	 * Applicable only to TAX attribute of DOCUMENT dataset.
	 * <br><br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST providerAccounts</li>
	 * <li>PUT providerAccounts</li>
	 * </ul> 
	 * 
	 * @return toFinYear
	 */
	public String getToFinYear() {
		return toFinYear;
	}

	
	public void setToFinYear(String toFinYear) {
		this.toFinYear = toFinYear;
	}

	@Override
	public String toString() {
		return "Attribute [containerAttributes=" + containerAttributes + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", fromFinYear=" + fromFinYear + ", toFinYear=" + toFinYear + ", name=" + name + ", containers="
				+ containers + "]";
	}
}
