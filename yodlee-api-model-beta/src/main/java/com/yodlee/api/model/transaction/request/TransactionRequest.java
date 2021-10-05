/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.transaction.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.transaction.UpdateTransaction;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionRequest extends AbstractModelComponent implements Request {

	@NotNull(message = "{transactions.updateTransaction.required}")
	@Valid
	@JsonProperty("transaction")
	private UpdateTransaction transaction;

	public UpdateTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(UpdateTransaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "TransactionRequest [transaction=" + transaction + "]";
	}
}
