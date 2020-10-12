/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractAddress;
import com.yodlee.api.model.enums.AddressType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"address1", "address2", "street", "city", "state", "zip",
		"country", "sourceType", "type"})
public class AccountAddress extends AbstractAddress {

	@JsonProperty("sourceType")
	private String sourceType;

	@JsonProperty("type")
	private AddressType type;

	@JsonProperty("street")
	protected String street;

	public String getSourceType() {
		return sourceType;
	}

	public AddressType getType() {
		return type;
	}

	public String getStreet() {
		return street;
	}

	@Override
	public String toString() {
		return "AccountAddress [sourceType=" + sourceType + ", type=" + type + ", address1=" + address1 + ", address2="
				+ address2 + ", street=" + street + ", state=" + state + ", city=" + city + ", zip=" + zip
				+ ", country=" + country + "]";
	}
}
