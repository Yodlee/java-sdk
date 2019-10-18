/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.webhooks;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"notificationId", "info", "loginName", "data"})
public class CallBackAutoRefreshUpdatesEvent {

	@JsonProperty("notificationId")
	private String notificationId;

	@JsonProperty("notificationTimestamp")
	private String notificationTimestamp;

	@JsonProperty("info")
	private String info;

	@JsonProperty("data")
	private List<CallBackAutoRefreshUpdatesData> data;

	@JsonProperty("notificationId")
	public String getNotificationId() {
		return notificationId;
	}

	@JsonProperty("notificationTimestamp")
	public String getNotificationTimestamp() {
		return notificationTimestamp;
	}

	@JsonProperty("info")
	public String getInfo() {
		return info;
	}

	@JsonProperty("data")
	public List<CallBackAutoRefreshUpdatesData> getData() {
		return data == null ? null : Collections.unmodifiableList(data);
	}

	@Override
	public String toString() {
		return "CallBackAutoRefreshUpdatesEvent [notificationId=" + notificationId + ", notificationTimestamp="
				+ notificationTimestamp + ", info=" + info + ", data=" + data + "]";
	}
}
