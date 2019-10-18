/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.dataextracts;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"userCount", "fromDate", "toDate", "userData"})
public class DataExtractsEventData extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("userCount")
	private Integer userCount;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("fromDate")
	private String fromDate;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("toDate")
	private String toDate;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("userData")
	private List<DataExtractsEventUserData> userData;

	public Integer getUserCount() {
		return userCount;
	}

	public String getFromDate() {
		return fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	@JsonProperty("userData")
	public List<DataExtractsEventUserData> getUserData() {
		return userData == null ? null : Collections.unmodifiableList(userData);
	}

	@Override
	public String toString() {
		return "EventData [userCount=" + userCount + ", fromDate=" + fromDate + ", toDate=" + toDate + ", userData="
				+ userData + "]";
	}
}
