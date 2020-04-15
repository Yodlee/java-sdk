/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.enrichData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.validation.Valid;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"user", "account", "transaction"})
public class EnrichUserData extends AbstractModelComponent implements Request {

	@Valid
	@NotEmpty(message = "{enrichData.data.invalid}")
	@JsonProperty("user")
	private List<EnrichDataUser> users;

	@Valid
	@NotEmpty(message = "{enrichData.data.invalid}")
	@JsonProperty("account")
	private List<EnrichDataAccount> accounts;

	@Valid
	@NotEmpty(message = "{enrichData.data.invalid}")
	@JsonProperty("transaction")
	private List<EnrichDataTransaction> transactions;

	@JsonProperty("user")
	public List<EnrichDataUser> getUsers() {
		return users == null ? null : Collections.unmodifiableList(users);
	}

	public void setUsers(List<EnrichDataUser> user) {
		this.users = user;
	}

	public boolean addUser(EnrichDataUser user) {
		if (user == null) {
			return false;
		}
		if (users == null) {
			users = new ArrayList<>();
		}
		return users.add(user);
	}

	public boolean removeUser(EnrichDataUser user) {
		if (user == null) {
			return false;
		}
		return users.remove(user);
	}

	public void clearUsers() {
		if (users != null) {
			users.clear();
		}
	}

	@JsonProperty("account")
	public List<EnrichDataAccount> getAccounts() {
		return accounts == null ? null : Collections.unmodifiableList(accounts);
	}

	public void setAccounts(List<EnrichDataAccount> account) {
		this.accounts = account;
	}

	public boolean addAccount(EnrichDataAccount account) {
		if (account == null) {
			return false;
		}
		if (accounts == null) {
			accounts = new ArrayList<>();
		}
		return accounts.add(account);
	}

	public boolean removeAccount(EnrichDataAccount account) {
		if (account == null) {
			return false;
		}
		return accounts.remove(account);
	}

	public void clearAccounts() {
		if (accounts != null) {
			accounts.clear();
		}
	}

	@JsonProperty("transaction")
	public List<EnrichDataTransaction> getTransactions() {
		return transactions == null ? null : Collections.unmodifiableList(transactions);
	}

	public void setTransactions(List<EnrichDataTransaction> transaction) {
		this.transactions = transaction;
	}

	public boolean addTransaction(EnrichDataTransaction transaction) {
		if (transaction == null) {
			return false;
		}
		if (transactions == null) {
			transactions = new ArrayList<>();
		}
		return transactions.add(transaction);
	}

	public boolean removeTransaction(EnrichDataTransaction transaction) {
		if (transaction == null) {
			return false;
		}
		return transactions.remove(transaction);
	}

	public void clearTransactions() {
		if (transactions != null) {
			transactions.clear();
		}
	}

	@Override
	public String toString() {
		return "UserDataFeed [user=" + users + ", account=" + accounts + ", transaction=" + transactions + "]";
	}
}
