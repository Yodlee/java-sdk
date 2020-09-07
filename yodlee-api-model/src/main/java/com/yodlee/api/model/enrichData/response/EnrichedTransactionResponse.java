/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.enrichData.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.enrichData.EnrichedTransaction;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"enrichedTransaction"})
public class EnrichedTransactionResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("enrichedTransaction")
	private List<EnrichedTransaction> transaction;

	@JsonProperty("enrichedTransaction")
	public List<EnrichedTransaction> getTransactions() {
		return transaction == null ? null : Collections.unmodifiableList(transaction);
	}

	@Override
	public String toString() {
		return "EnrichedTransactionResponse [enrichedTransaction=" + transaction + "]";
	}
}
