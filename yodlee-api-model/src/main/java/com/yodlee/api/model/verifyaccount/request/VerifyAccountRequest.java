/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.verifyaccount.request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.enums.Container;
import com.yodlee.api.model.verifyaccount.VerifyTransactionCriteria;

public class VerifyAccountRequest extends AbstractModelComponent implements Request {

	@JsonProperty("accountId")
	private Long accountId;

	@JsonProperty("container")
	private Container container;

	@NotNull(message = "{verifyAccounts.txnCriteria.required}")
	@Size(max = 5, message = "{verifyAccounts.txnCriteria.maxCount}")
	@JsonProperty(value = "transactionCriteria", required = true)
	@Valid
	private List<VerifyTransactionCriteria> transactionCriteriaList;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	@JsonProperty("transactionCriteria")
	public List<VerifyTransactionCriteria> getTransactionCriteriaList() {
		return transactionCriteriaList == null ? null : Collections.unmodifiableList(transactionCriteriaList);
	}

	@JsonProperty("transactionCriteria")
	public void setTransactionCriteria(List<VerifyTransactionCriteria> transactionCriteriaList) {
		this.transactionCriteriaList = transactionCriteriaList;
	}

	public boolean addTransactionCriteria(VerifyTransactionCriteria transactionCriteria) {
		if (transactionCriteriaList == null) {
			transactionCriteriaList = new ArrayList<>();
		}
		return transactionCriteriaList.add(transactionCriteria);
	}

	public boolean removeTransactionCriteria(VerifyTransactionCriteria transactionCriteria) {
		if (transactionCriteriaList != null) {
			return this.transactionCriteriaList.remove(transactionCriteria);
		}
		return false;
	}

	public void clearTransactionCriteriaList() {
		if (transactionCriteriaList != null) {
			transactionCriteriaList.clear();
		}
	}

	@Override
	public String toString() {
		return "VerifyAccountRequest [accountId=" + accountId + ", container=" + container + ", transactionCriteria="
				+ transactionCriteriaList + "]";
	}
}
