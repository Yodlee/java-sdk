/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.webhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"notificationId", "info", "loginName", "data"})
public class CallBackDataExtractEvent {

	@JsonProperty("info")
	private String info;

	@JsonProperty("data")
	private CallBackDataExtractData data;

	@JsonProperty("notificationId")
	private String notificationId;

	@JsonProperty("info")
	public String getInfo() {
		return info;
	}

	@JsonProperty("data")
	public CallBackDataExtractData getData() {
		return data;
	}

	@JsonProperty("notificationId")
	public String getNotificationId() {
		return notificationId;
	}

	@Override
	public String toString() {
		return "CallBackDataExtractEvent [info=" + info + ", data=" + data + ", notificationId=" + notificationId + "]";
	}
}
