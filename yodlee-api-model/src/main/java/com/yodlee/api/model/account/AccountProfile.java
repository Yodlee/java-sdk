/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractProfile;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"address", "email", "phoneNumber", "identifier"})
public class AccountProfile extends AbstractProfile {

	@Override
	public String toString() {
		return "AccountProfile [addresses=" + addresses + ", phoneNumbers=" + phoneNumbers + ", identifiers="
				+ identifiers + ", emails=" + emails + "]";
	}
}
