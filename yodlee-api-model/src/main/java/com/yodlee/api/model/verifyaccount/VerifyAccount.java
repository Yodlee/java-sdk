/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.verifyaccount;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerifyAccount extends AbstractModelComponent {

	@JsonProperty("account")
	private List<VerifiedAccount> account;

	@JsonProperty("transactionCriteria")
	private List<VerifyTransactionCriteria> transactionCriteria;

	public List<VerifiedAccount> getAccount() {
		return account == null ? null : Collections.unmodifiableList(account);
	}

	public List<VerifyTransactionCriteria> getTransactionCriteria() {
		return transactionCriteria == null ? null : Collections.unmodifiableList(transactionCriteria);
	}

	@Override
	public String toString() {
		return "VerifyAccount [account=" + account + ", transactionCriteria=" + transactionCriteria + "]";
	}
}
