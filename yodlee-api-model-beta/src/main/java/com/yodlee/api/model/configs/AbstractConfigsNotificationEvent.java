/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.configs;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractConfigsNotificationEvent extends AbstractModelComponent {

	@NotEmpty(message = "{configs.event.callbackUrl.required}")
	@URL(message = "{configs.event.callbackUrl.invalid}")
	@ApiModelProperty(value = "URL to which the notification should be posted."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET configs/notifications/events</li>"//
			+ "</ul>")
	@JsonProperty("callbackUrl")
	protected String callbackUrl;

	/**
	 * URL to which the notification should be posted. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET configs/notifications/events</li>
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
