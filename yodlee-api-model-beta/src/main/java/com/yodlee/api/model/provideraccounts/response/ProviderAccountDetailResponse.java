/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.provideraccounts.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.provideraccounts.ProviderAccountDetail;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProviderAccountDetailResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("providerAccount")
	private List<ProviderAccountDetail> providerAccounts;

	public List<ProviderAccountDetail> getProviderAccount() {
		return providerAccounts == null ? null : Collections.unmodifiableList(providerAccounts);
	}

	@Override
	public String toString() {
		return "GetProviderAccountRespone [providerAccounts=" + providerAccounts + "]";
	}
}
