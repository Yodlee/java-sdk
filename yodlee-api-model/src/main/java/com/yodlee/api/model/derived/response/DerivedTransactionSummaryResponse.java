/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.derived.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.derived.DerivedTransactionsLinks;
import com.yodlee.api.model.derived.DerivedTransactionsSummary;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"transactionSummary", "links"})
public class DerivedTransactionSummaryResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("transactionSummary")
	private List<DerivedTransactionsSummary> transactionSummaries;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("links")
	private DerivedTransactionsLinks links;

	@JsonProperty("transactionSummary")
	public List<DerivedTransactionsSummary> getTransactionSummaries() {
		return transactionSummaries == null ? null : Collections.unmodifiableList(transactionSummaries);
	}

	public DerivedTransactionsLinks getLinks() {
		return links;
	}

	@Override
	public String toString() {
		return "DerivedTransactionSummaryResponse [transactionSummary=" + transactionSummaries + ", links=" + links
				+ "]";
	}
}
