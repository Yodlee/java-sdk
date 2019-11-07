/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.providers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "container", "containerAttributes"})
public class ContainerAttributes extends AbstractModelComponent {

	@JsonProperty("CREDITCARD")
	private TransactionDays creditTransactionDays;

	@JsonProperty("BANK")
	private TransactionDays bankTransactionDays;

	@JsonProperty("LOAN")
	private TransactionDays loanTransactionDays;

	@JsonProperty("INVESTMENT")
	private TransactionDays investmentTransactionDays;

	@JsonProperty("INSURANCE")
	private TransactionDays insuranceTransactionDays;

	@JsonProperty("BANK")
	public TransactionDays getBankTransactionDays() {
		return bankTransactionDays;
	}

	@JsonProperty("CREDITCARD")
	public TransactionDays getCreditTransactionDays() {
		return creditTransactionDays;
	}

	@JsonProperty("LOAN")
	public TransactionDays getLoanTransactionDays() {
		return loanTransactionDays;
	}

	@JsonProperty("INVESTMENT")
	public TransactionDays getInvestmentTransactionDays() {
		return investmentTransactionDays;
	}

	public TransactionDays getInsuranceTransactionDays() {
		return insuranceTransactionDays;
	}

	@Override
	public String toString() {
		return "ContainerAttributes [creditTransactionDays=" + creditTransactionDays + ", bankTransactionDays="
				+ bankTransactionDays + ", loanTransactionDays=" + loanTransactionDays + ", investmentTransactionDays="
				+ investmentTransactionDays + ", insuranceTransactionDays=" + insuranceTransactionDays + "]";
	}
}
