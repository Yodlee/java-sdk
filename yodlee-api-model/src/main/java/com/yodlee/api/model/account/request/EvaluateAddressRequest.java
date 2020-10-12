/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.account.EvaluateAccountAddress;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EvaluateAddressRequest extends AbstractModelComponent implements Request {

	@NotNull(message = "{evaluateAddress.address.required}")
	@Valid
	@JsonProperty("address")
	private EvaluateAccountAddress address;

	@JsonProperty("address")
	public EvaluateAccountAddress getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(EvaluateAccountAddress address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "EvaluateAddressRequest [address=" + address + "]";
	}
}
