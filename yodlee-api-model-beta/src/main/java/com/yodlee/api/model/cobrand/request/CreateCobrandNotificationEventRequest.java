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
import com.yodlee.api.model.cobrand.CreateCobrandNotificationEvent;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateCobrandNotificationEventRequest extends AbstractModelComponent implements Request {

	@NotNull(message = "{cobrand.event.callbackUrl.required}")
	@Valid
	@JsonProperty("event")
	private CreateCobrandNotificationEvent cobrandNotificationEvent;

	@JsonProperty("event")
	public CreateCobrandNotificationEvent getCobrandNotificationEvent() {
		return cobrandNotificationEvent;
	}

	@JsonProperty("event")
	public void setCobrandNotificationEvent(CreateCobrandNotificationEvent event) {
		this.cobrandNotificationEvent = event;
	}
}
