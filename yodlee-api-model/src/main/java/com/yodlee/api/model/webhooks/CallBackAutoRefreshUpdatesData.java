/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.webhooks;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.account.AutoRefresh;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CallBackAutoRefreshUpdatesData extends AbstractModelComponent {

	@JsonProperty("accountId")
	private List<Long> accountId;

	@JsonProperty("autoRefresh")
	private AutoRefresh autoRefresh;

	@JsonProperty("loginName")
	private String loginName;

	@JsonProperty("providerAccountId")
	private Long providerAccountId;

	@JsonProperty("accountId")
	public List<Long> getAccountId() {
		return accountId == null ? null : Collections.unmodifiableList(accountId);
	}

	@JsonProperty("autoRefresh")
	public AutoRefresh getAutoRefresh() {
		return autoRefresh;
	}

	@JsonProperty("loginName")
	public String getLoginName() {
		return loginName;
	}

	@JsonProperty("providerAccountId")
	public Long getProviderAccountId() {
		return providerAccountId;
	}

	@Override
	public String toString() {
		return "CallBackAutoRefreshUpdatesData [accountId=" + accountId + ", autoRefresh=" + autoRefresh
				+ ", loginName=" + loginName + ", providerAccountId=" + providerAccountId + "]";
	}
}
