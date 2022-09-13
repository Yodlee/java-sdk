/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.payment.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class PaymentProcessorTokenResponse {

	@ApiModelProperty(readOnly = true, value = "token")
	@JsonProperty("token")
	private List<AccountToken> tokens;

	public List<AccountToken> getTokens() {
		return tokens;
	}

	class AccountToken {
		@ApiModelProperty(readOnly = true, value = "The unique identifier for the user's account.")
		@JsonProperty("accountId")
		Long accountId;

		@ApiModelProperty(readOnly = true, value = "The unique token that the payment partner can use to make API request to the Envestnet | Yodlee system.")
		@JsonProperty("processorToken")
		String processorToken;

		public Long getAccountId() {
			return accountId;
		}

		public String getProcessorToken() {
			return processorToken;
		}

	}
}
