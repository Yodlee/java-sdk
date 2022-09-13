/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.payment.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class PaymentAccountResponse {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("account")
	private List<PaymentAccount> accounts;

	@JsonProperty("account")
	public List<PaymentAccount> getAccount() {
		return accounts == null ? null : Collections.unmodifiableList(accounts);
	}

	@Override
	public String toString() {
		return "PaymentAccountResponse [accounts=" + accounts + "]";
	}
}
