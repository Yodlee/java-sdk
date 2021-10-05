/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"access"})
public class AccountAccess extends AbstractModelComponent {

	@JsonProperty("access")
	private AccountInnerAccess accountInnerAccess;

	@JsonProperty("access")
	public AccountInnerAccess getAccountInnerAccess() {
		return accountInnerAccess;
	}

	@JsonProperty("access")
	public void setAccountInnerAccess(AccountInnerAccess accountInnerAccess) {
		this.accountInnerAccess = accountInnerAccess;
	}

	@Override
	public String toString() {
		return "AccountAccess [accountInnerAccess=" + accountInnerAccess + "]";
	}
}
