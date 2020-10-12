/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yodlee.api.model.enums.AddressType;

public class EvaluateAccountAddress extends AccountAddress {

	@Override
	@NotNull(message = "{evaluateAddress.address.street.required}")
	public String getStreet() {
		return super.getStreet();
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@JsonIgnore
	@Override
	public String getAddress1() {
		throw new UnsupportedOperationException("Address1 property not supported");
	}

	@JsonIgnore
	@Override
	public String getAddress2() {
		throw new UnsupportedOperationException("Address2 property not supported");
	}

	@JsonIgnore
	@Override
	public String getCountry() {
		throw new UnsupportedOperationException("Country property not supported");
	}

	@JsonIgnore
	@Override
	public String getSourceType() {
		throw new UnsupportedOperationException("SourceType property not supported");
	}

	@JsonIgnore
	@Override
	public AddressType getType() {
		throw new UnsupportedOperationException("Type property not supported");
	}

	@JsonIgnore
	@Override
	public void setAddress1(String address1) {
		throw new UnsupportedOperationException("Address1 property not supported");
	}

	@JsonIgnore
	@Override
	public void setAddress2(String address2) {
		throw new UnsupportedOperationException("Address2 property not supported");
	}

	@JsonIgnore
	@Override
	public void setCountry(String country) {
		throw new UnsupportedOperationException("Country property not supported");
	}
}
