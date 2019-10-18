/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
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
