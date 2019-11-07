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
import com.yodlee.api.model.account.AccountHistory;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountHistoricalBalancesResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("account")
	private List<AccountHistory> accountHistories;

	@JsonProperty("account")
	public List<AccountHistory> getAccountHistories() {
		return accountHistories == null ? null : Collections.unmodifiableList(accountHistories);
	}

	@Override
	public String toString() {
		return "AccountHistoricalBalancesResponse [accountHistories=" + accountHistories + "]";
	}
}
