/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.webhooks;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.account.AutoRefresh;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CallBackAutoRefreshUpdatesData {

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
