/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.transaction.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.transaction.TransactionCategory;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"transactionCategory"})
public class TransactionCategoryResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("transactionCategory")
	private List<TransactionCategory> transactionCategory;

	public List<TransactionCategory> getTransactionCategory() {
		return transactionCategory == null ? null : Collections.unmodifiableList(transactionCategory);
	}

	@Override
	public String toString() {
		return "TransactionCategoryResponse [transactionCategory=" + transactionCategory + "]";
	}
}
