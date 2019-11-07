/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.verification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"accountId", "providerAccountId", "verificationType", "transaction", "verificationDate", "reason",
		"verificationStatus", "verificationId", "account"})
public class UpdateVerification extends AbstractVerification {

	@JsonProperty("transaction")
	@NotNull(message = "{verifications.transaction.required}")
	@Valid
	private List<VerificationTransaction> transactions;

	@JsonProperty("transaction")
	public List<VerificationTransaction> getTransactions() {
		return transactions == null ? null : Collections.unmodifiableList(transactions);
	}

	@JsonProperty("transaction")
	public void setTransactions(List<VerificationTransaction> transactions) {
		this.transactions = transactions;
	}

	public boolean addTransaction(VerificationTransaction transaction) {
		if (this.transactions == null) {
			this.transactions = new ArrayList<>();
		}
		return this.transactions.add(transaction);
	}

	public boolean removeTransaction(VerificationTransaction transaction) {
		if (this.transactions != null) {
			return this.transactions.remove(transaction);
		}
		return false;
	}

	public void clearTransaction() {
		if (transactions != null) {
			transactions.clear();
		}
	}

	@Override
	public String toString() {
		return "UpdateVerification [transaction=" + transactions + "]";
	}
}
