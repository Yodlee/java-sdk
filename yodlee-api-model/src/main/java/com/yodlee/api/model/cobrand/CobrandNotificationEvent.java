/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.cobrand;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.cobrand.enums.CobrandNotificationEventType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"callbackUrl", "name"})
public class CobrandNotificationEvent extends AbstractCobrandNotificationEvent {

	@ApiModelProperty(value = "Name of the event for which the customers must subscribe to receive notifications."
			+ "<br>" + "<b>Valid Value:</b> Notification Events Name"//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET cobrand/config/notifications/events</li>"//
			+ "</ul>"//
			+ "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("name")
	private CobrandNotificationEventType CobrandNotificationEventName;

	/**
	 * Name of the event for which the customers must subscribe to receive notifications. <br>
	 * <b>Valid Value:</b> Notification Events Name <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET cobrand/config/notifications/events</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return Cobrand notification event type name
	 */
	@JsonProperty("name")
	public CobrandNotificationEventType getName() {
		return CobrandNotificationEventName;
	}

	public void setCobrandNotificationEventName(CobrandNotificationEventType CobrandNotificationEventName) {
		this.CobrandNotificationEventName = CobrandNotificationEventName;
	}

	@Override
	public String toString() {
		return "CreateCobrandNotificationEvent [callbackUrl=" + callbackUrl + ", CobrandNotificationEventName="
				+ CobrandNotificationEventName + "]";
	}
}
