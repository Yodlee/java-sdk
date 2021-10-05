/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.cobrand;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractCobrandNotificationEvent extends AbstractModelComponent {

	@NotEmpty(message = "{cobrand.event.callbackUrl.required}")
	@URL(message = "{cobrand.event.callbackUrl.invalid}")
	@ApiModelProperty(value = "URL to which the notification should be posted."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET cobrand/config/notifications/events</li>"//
			+ "</ul>")
	@JsonProperty("callbackUrl")
	protected String callbackUrl;

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
}
