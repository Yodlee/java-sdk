/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.account.AccountAddress;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EvaluateAddressResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("address")
	private List<AccountAddress> address;

	@JsonProperty("address")
	public List<AccountAddress> getAccount() {
		return address == null ? null : Collections.unmodifiableList(address);
	}

	@JsonProperty("isValidAddress")
	private boolean isValidAddress;

	@JsonProperty("isValidAddress")
	public boolean getIsValidAddress() {
		return isValidAddress;
	}

	@Override
	public String toString() {
		return "EvaluateAddressResponse [isValidAddress=" + isValidAddress + ",address=" + address + "]";
	}
}
