/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"statements", "accounts", "holdings", "transactions"})
public class AccountInnerAccess extends AbstractModelComponent {

	@JsonProperty("statements")
	private AccountAccessDetail statements;

	@JsonProperty("accounts")
	private AccountAccessDetail accounts;

	@JsonProperty("holdings")
	private AccountAccessDetail holdings;

	@JsonProperty("transactions")
	private AccountAccessDetail transactions;

	public AccountAccessDetail getStatements() {
		return statements;
	}

	public void setStatements(AccountAccessDetail statements) {
		this.statements = statements;
	}

	public AccountAccessDetail getAccounts() {
		return accounts;
	}

	public void setAccounts(AccountAccessDetail accounts) {
		this.accounts = accounts;
	}

	public AccountAccessDetail getHoldings() {
		return holdings;
	}

	public void setHoldings(AccountAccessDetail holdings) {
		this.holdings = holdings;
	}

	public AccountAccessDetail getTransactions() {
		return transactions;
	}

	public void setTransactions(AccountAccessDetail transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "AccountInnerAccess [statements=" + statements + ", accounts=" + accounts + ", holdings=" + holdings
				+ ", transactions=" + transactions + "]";
	}
}
