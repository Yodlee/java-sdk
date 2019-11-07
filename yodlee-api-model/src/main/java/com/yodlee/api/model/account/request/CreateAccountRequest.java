/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.account.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.account.CreateAccountInfo;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateAccountRequest extends AbstractModelComponent implements Request{

	@NotNull(message = "{accounts.manualAccountInfo.required}")
	@Valid
	@JsonProperty("account")
	private CreateAccountInfo accountInfo;

	@JsonProperty("account")
	public CreateAccountInfo getAccountInfo() {
		return accountInfo;
	}

	@JsonProperty("account")
	public void setAccountInfo(CreateAccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}

	@Override
	public String toString() {
		return "CreateAccountRequest [accountInfo=" + accountInfo + "]";
	}
}
