/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountMigrationResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("providerAccountId")
	private long providerAccountId;

	@JsonProperty("providerAccountId")
	public long getProviderAccountId() {
		return providerAccountId;
	}

	@ApiModelProperty(readOnly = true)
	@JsonProperty("providerId")
	private long providerId;

	@JsonProperty("providerId")
	public long getProviderId() {
		return providerId;
	}

	@Override
	public String toString() {
		return "ProviderAccountMigrationResponse [providerAccountId=" + providerAccountId + ", providerId=" + providerId + "]";
	}
}
