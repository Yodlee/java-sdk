/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.configs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"callbackUrl"})
public class UpdateConfigsNotificationEvent extends AbstractConfigsNotificationEvent {

	@Override
	public String toString() {
		return "UpdateConfigsNotificationEvent [callbackUrl=" + callbackUrl + "]";
	}
}
