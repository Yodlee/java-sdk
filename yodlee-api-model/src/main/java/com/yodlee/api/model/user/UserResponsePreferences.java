/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
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
