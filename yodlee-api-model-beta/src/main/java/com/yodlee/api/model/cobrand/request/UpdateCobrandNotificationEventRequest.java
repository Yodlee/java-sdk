/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.cobrand.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.cobrand.UpdateCobrandNotificationEvent;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateCobrandNotificationEventRequest extends AbstractModelComponent implements Request {

	@NotNull(message = "{cobrand.UpdateCobrandNotificationEventRequest.required}")
	@Valid
	@JsonProperty("event")
	private UpdateCobrandNotificationEvent cobrandNotificationEvent;

	@JsonProperty("event")
	public UpdateCobrandNotificationEvent getCobrandNotificationEvent() {
		return cobrandNotificationEvent;
	}

	@JsonProperty("event")
	public void setCobrandNotificationEvent(UpdateCobrandNotificationEvent event) {
		this.cobrandNotificationEvent = event;
	}
}
