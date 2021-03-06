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
public class AccountSharedUser extends AbstractModelComponent {

	@JsonProperty("access")
	private AccountAccess accountAccess;

	@JsonProperty("access")
	public AccountAccess getAccountAccess() {
		return accountAccess;
	}

	@JsonProperty("access")
	public void setAccountAccess(AccountAccess accountAccess) {
		this.accountAccess = accountAccess;
	}

	@Override
	public String toString() {
		return "AccountSharedUser [accountAccess=" + accountAccess + "]";
	}
}
