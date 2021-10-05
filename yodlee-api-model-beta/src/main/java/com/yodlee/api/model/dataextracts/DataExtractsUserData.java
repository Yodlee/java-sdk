/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.dataextracts;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"user", "holding", "totalTransactionsCount", "transaction", "account", "providerAccount"})
public class DataExtractsUserData extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("user")
	private DataExtractsUser user;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("holding")
	private List<DataExtractsHolding> holdings;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("totalTransactionsCount")
	private Long totalTransactionsCount;
	
	@ApiModelProperty(readOnly = true)
	@JsonProperty("transaction")
	private List<DataExtractsTransaction> transactions;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("account")
	private List<DataExtractsAccount> accounts;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("providerAccount")
	private List<DataExtractsProviderAccount> providerAccounts;

	@JsonProperty("holding")
	public List<DataExtractsHolding> getHoldings() {
		return holdings == null ? null : Collections.unmodifiableList(holdings);
	}
	
	@JsonProperty("totalTransactionsCount")
	public Long getTotalTransactionsCount() {
		return totalTransactionsCount;
	}

	@JsonProperty("transaction")
	public List<DataExtractsTransaction> getTransactions() {
		return transactions == null ? null : Collections.unmodifiableList(transactions);
	}

	@JsonProperty("account")
	public List<DataExtractsAccount> getAccounts() {
		return accounts == null ? null : Collections.unmodifiableList(accounts);
	}

	@JsonProperty("providerAccount")
	public List<DataExtractsProviderAccount> getProviderAccounts() {
		return providerAccounts == null ? null : Collections.unmodifiableList(providerAccounts);
	}

	public DataExtractsUser getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "DataExtractsUserData [holdings=" + holdings + ", totalTransactionsCount=" + 
				+ totalTransactionsCount + ", transactions=" + transactions + ", accounts="
				+ accounts + ", providerAccounts=" + providerAccounts + ", user=" + user + "]";
	}
}
