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
@JsonPropertyOrder({"user", "loginName"})
public class AccountShared extends AbstractModelComponent {

	@JsonProperty("user")
	private AccountSharedUser sharedUser;

	@JsonProperty("loginName")
	private String loginName;

	@JsonProperty("user")
	public AccountSharedUser getSharedUser() {
		return sharedUser;
	}

	@JsonProperty("user")
	public void setSharedUser(AccountSharedUser sharedUser) {
		this.sharedUser = sharedUser;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Override
	public String toString() {
		return "AccountShared [sharedUser=" + sharedUser + ", loginName=" + loginName + "]";
	}
}
