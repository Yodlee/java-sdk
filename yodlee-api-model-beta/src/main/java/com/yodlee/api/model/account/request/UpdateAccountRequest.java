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
import com.yodlee.api.model.account.UpdateAccountInfo;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateAccountRequest extends AbstractModelComponent implements Request {

	@NotNull(message = "{accounts.accountInfo.required}")
	@Valid
	@JsonProperty("account")
	private UpdateAccountInfo accountInfo;

	@JsonProperty("account")
	public UpdateAccountInfo getAccountInfo() {
		return accountInfo;
	}

	@JsonProperty("account")
	public void setAccountInfo(UpdateAccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}

	@Override
	public String toString() {
		return "AccountRequest [accountInfo=" + accountInfo + "]";
	}
}
