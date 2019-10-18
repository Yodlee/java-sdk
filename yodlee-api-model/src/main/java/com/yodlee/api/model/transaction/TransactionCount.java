/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class TransactionCount {

	@JsonProperty("TOTAL")
	private TransactionTotal total;

	@JsonProperty("TOTAL")
	public TransactionTotal getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "TransactionCount [total=" + total + "]";
	}
}
