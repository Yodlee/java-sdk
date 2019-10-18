/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"currency", "locale"})
public class UserRequestPreferences extends AbstractUserPreferences {

	@Override
	public String toString() {
		return "UserRequestPreferences [currency=" + currency + ", locale=" + locale + ", timeZone=" + timeZone
				+ ", dateFormat=" + dateFormat + "]";
	}
}
