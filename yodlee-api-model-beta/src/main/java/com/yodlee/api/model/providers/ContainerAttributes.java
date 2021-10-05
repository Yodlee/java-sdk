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

	@JsonProperty("CREDITCARD")
	public TransactionDays getCreditTransactionDays() {
		return creditTransactionDays;
	}

	public void setCreditTransactionDays(TransactionDays creditTransactionDays) {
		this.creditTransactionDays = creditTransactionDays;
	}

	@JsonProperty("BANK")
	public TransactionDays getBankTransactionDays() {
		return bankTransactionDays;
	}

	public void setBankTransactionDays(TransactionDays bankTransactionDays) {
		this.bankTransactionDays = bankTransactionDays;
	}

	@JsonProperty("LOAN")
	public TransactionDays getLoanTransactionDays() {
		return loanTransactionDays;
	}

	public void setLoanTransactionDays(TransactionDays loanTransactionDays) {
		this.loanTransactionDays = loanTransactionDays;
	}

	@JsonProperty("INVESTMENT")
	public TransactionDays getInvestmentTransactionDays() {
		return investmentTransactionDays;
	}

	public void setInvestmentTransactionDays(TransactionDays investmentTransactionDays) {
		this.investmentTransactionDays = investmentTransactionDays;
	}

	public TransactionDays getInsuranceTransactionDays() {
		return insuranceTransactionDays;
	}

	public void setInsuranceTransactionDays(TransactionDays insuranceTransactionDays) {
		this.insuranceTransactionDays = insuranceTransactionDays;
	}

	@Override
	public String toString() {
		return "ContainerAttributes [creditTransactionDays=" + creditTransactionDays + ", bankTransactionDays="
				+ bankTransactionDays + ", loanTransactionDays=" + loanTransactionDays + ", investmentTransactionDays="
				+ investmentTransactionDays + ", insuranceTransactionDays=" + insuranceTransactionDays + "]";
	}
}
