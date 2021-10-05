/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"currency", "timeZone", "dateFormat", "locale"})
public class UserResponsePreferences extends AbstractUserPreferences {

	@Override
	public String toString() {
		return "UserPreferences [timeZone=" + timeZone + ", dateFormat=" + dateFormat + ", currency=" + currency
				+ ", locale=" + locale + "]";
	}
}
