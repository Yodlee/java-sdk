/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.webhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"event"})
public class CallBackDataExtractEventResponse {

	@JsonProperty("event")
	private CallBackDataExtractEvent event;

	@JsonProperty("event")
	public CallBackDataExtractEvent getEvent() {
		return event;
	}

	@Override
	public String toString() {
		return "CallBackDataExtractEventResponse [event=" + event + "]";
	}
}
