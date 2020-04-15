/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.configs.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.configs.CreateConfigsNotificationEvent;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateConfigsNotificationEventRequest extends AbstractModelComponent implements Request {

	@NotNull(message = "{configs.event.callbackUrl.required}")
	@Valid
	@JsonProperty("event")
	private CreateConfigsNotificationEvent configsNotificationEvent;

	@JsonProperty("event")
	public CreateConfigsNotificationEvent getConfigsNotificationEvent() {
		return configsNotificationEvent;
	}

	@JsonProperty("event")
	public void setConfigsNotificationEvent(CreateConfigsNotificationEvent event) {
		this.configsNotificationEvent = event;
	}
}
