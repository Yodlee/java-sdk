/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.webhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"notificationId", "info", "loginName", "data"})
public class CallBackRefreshEvent {

	@JsonProperty("notificationId")
	private String notificationId;

	@JsonProperty("info")
	private String info;

	@JsonProperty("loginName")
	private String loginName;

	@JsonProperty("data")
	private CallBackRefreshData data;

	@JsonProperty("notificationId")
	public String getNotificationId() {
		return notificationId;
	}

	@JsonProperty("info")
	public String getInfo() {
		return info;
	}

	@JsonProperty("loginName")
	public String getLoginName() {
		return loginName;
	}

	@JsonProperty("data")
	public CallBackRefreshData getData() {
		return data;
	}

	@Override
	public String toString() {
		return "CallBackRefreshEvent [notificationId=" + notificationId + ", info=" + info + ", loginName=" + loginName
				+ ", data=" + data + "]";
	}
}
