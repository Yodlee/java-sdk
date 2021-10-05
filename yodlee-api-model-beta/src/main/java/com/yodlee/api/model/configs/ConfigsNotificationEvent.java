/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.configs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.configs.enums.ConfigsNotificationEventType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"callbackUrl", "name"})
public class ConfigsNotificationEvent extends AbstractConfigsNotificationEvent {

	@ApiModelProperty(value = "Name of the event for which the customers must subscribe to receive notifications."
			+ "<br>" + "<b>Valid Value:</b> Notification Events Name"//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET configs/notifications/events</li>"//
			+ "</ul>"//
			+ "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("name")
	private ConfigsNotificationEventType configsNotificationEventName;

	/**
	 * Name of the event for which the customers must subscribe to receive notifications. <br>
	 * <b>Valid Value:</b> Notification Events Name <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET configs/notifications/events</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return configs notification event type name
	 */
	@JsonProperty("name")
	public ConfigsNotificationEventType getName() {
		return configsNotificationEventName;
	}

	public void setConfigsNotificationEventName(ConfigsNotificationEventType configsNotificationEventName) {
		this.configsNotificationEventName = configsNotificationEventName;
	}

	@Override
	public String toString() {
		return "CreateConfigsNotificationEvent [callbackUrl=" + callbackUrl + ", configsNotificationEventName="
				+ configsNotificationEventName + "]";
	}
}
