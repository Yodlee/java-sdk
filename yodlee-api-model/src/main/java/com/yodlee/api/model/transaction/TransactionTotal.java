/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class TransactionTotal {

	@JsonProperty("count")
	private Long count;

	public Long getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "TransactionTotal [count=" + count + "]";
	}
}
