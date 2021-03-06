/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.webhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"event"})
public class CallBackRefreshEventResponse extends AbstractModelComponent implements Response {

	@JsonProperty("event")
	private CallBackRefreshEvent event;

	@JsonProperty("event")
	public CallBackRefreshEvent getEvent() {
		return event;
	}

	@Override
	public String toString() {
		return "CallBackRefreshEventResponse [event=" + event + "]";
	}
}
