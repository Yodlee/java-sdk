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
import com.yodlee.api.model.account.AccountLatestBalance;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountBalanceResponse extends AbstractModelComponent implements Response {
	
	@ApiModelProperty(readOnly = true)
	@JsonProperty("accountBalance")
	private List<AccountLatestBalance> accountBalanceList;

	@JsonProperty("accountBalance")
	public List<AccountLatestBalance> getAccountLatestBalance() {
		return accountBalanceList == null ? null : Collections.unmodifiableList(accountBalanceList);
	}

	@Override
	public String toString() {
		return "AccountBalanceResponse [accountBalance=" + accountBalanceList + "]";
	}
}

