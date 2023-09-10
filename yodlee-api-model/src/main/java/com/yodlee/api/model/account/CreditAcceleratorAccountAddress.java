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

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"address1", "address2", "address3", "street", "fullAddress", "city", "state", "zip", "country", "sourceType",
		"type"})
public class CreditAcceleratorAccountAddress extends AbstractAddress {

	@JsonProperty("sourceType")
	@ApiModelProperty(readOnly = true, value = "Address Source.")
	private String sourceType;

	@JsonProperty("type")
	@ApiModelProperty(readOnly = true, value = "Type of address.")
	private AddressType type;

	@JsonProperty("street")
	@ApiModelProperty(readOnly = true, value = "Street.")
	protected String street;
	
	@JsonProperty("fullAddress")
	@ApiModelProperty(readOnly = true, value = "Full Address.")
	protected String fullAddress;

	public String getSourceType() {
		return sourceType;
	}

	public AddressType getType() {
		return type;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	@Override
	public String toString() {
		return "AccountAddress [sourceType=" + sourceType + ", type=" + type + ", street=" + street + ", address1="
				+ address1 + ", address2=" + address2 + ", address3=" + address3 + ", state=" + state + ", city=" + city
				+ ", zip=" + zip + ", country=" + country + "]";
	}
}
