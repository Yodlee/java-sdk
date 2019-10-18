/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.cobrand;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"callbackUrl", "name"})
public class UpdateCobrandNotificationEvent extends AbstractModelComponent {

	@NotEmpty(message = "{cobrand.event.callbackUrl.required}")
	@URL(message = "{cobrand.event.callbackUrl.invalid}")
	@ApiModelProperty(value = "URL to which the notification should be posted."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET cobrand/config/notifications/events</li>"//
			+ "</ul>")
	@JsonProperty("callbackUrl")
	private String callbackUrl;

	/**
	 * URL to which the notification should be posted. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET cobrand/config/notifications/events</li>
	 * </ul>
	 * 
	 * @return callback URL
	 */
	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	@Override
	public String toString() {
		return "UpdateCobrandNotificationEvent [callbackUrl=" + callbackUrl + "]";
	}
}
