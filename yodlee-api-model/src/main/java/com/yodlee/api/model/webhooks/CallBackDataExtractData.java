/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.webhooks;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CallBackDataExtractData extends AbstractModelComponent {

	@JsonProperty("toDate")
	private String toDate;

	@JsonProperty("fromDate")
	private String fromDate;

	@JsonProperty("userCount")
	private Integer userCount;

	@JsonProperty("userData")
	private List<UserData> userData;

	@JsonProperty("toDate")
	public String getToDate() {
		return toDate;
	}

	@JsonProperty("fromDate")
	public String getFromDate() {
		return fromDate;
	}

	@JsonProperty("userCount")
	public Integer getUserCount() {
		return userCount;
	}

	@JsonProperty("userData")
	public List<UserData> getUserData() {
		return userData == null ? null : Collections.unmodifiableList(userData);
	}

	@Override
	public String toString() {
		return "CallBackDataExtractData [toDate=" + toDate + ", fromDate=" + fromDate + ", userCount=" + userCount
				+ ", userData=" + userData + "]";
	}
}
