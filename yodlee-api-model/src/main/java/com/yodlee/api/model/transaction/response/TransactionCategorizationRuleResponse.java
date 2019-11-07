/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.transaction.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.transaction.TransactionCategorizationRule;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"txnRules"})
public class TransactionCategorizationRuleResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("txnRules")
	private List<TransactionCategorizationRule> transactionCategoryRules;

	@JsonProperty("txnRules")
	public List<TransactionCategorizationRule> getTransactionCategoryRules() {
		return transactionCategoryRules == null ? null : Collections.unmodifiableList(transactionCategoryRules);
	}

	@Override
	public String toString() {
		return "TransactionCategorizationRuleResponse [transactionCategory=" + transactionCategoryRules + "]";
	}
}
