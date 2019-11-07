/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.cobrand.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.cobrand.CreateCobrandNotificationEvent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CobrandNotificationResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("event")
	private List<CreateCobrandNotificationEvent> events;

	@JsonProperty("event")
	public List<CreateCobrandNotificationEvent> getEvent() {
		return events == null ? null : Collections.unmodifiableList(events);
	}

	@Override
	public String toString() {
		return "CobrandNotificationResponse [events=" + events + "]";
	}
}
