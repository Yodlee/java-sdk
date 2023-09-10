/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.verification;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"fromDate", "toDate", "isPrimaryAccount", "isActiveAccount", "salaryCredits", "incomeCredits"
	, "billPayments", "loanPayments", "mortgagePayments", "cardPayments", "latestTransactions"})
public class ClassificationSummaryTransactionSummary extends AbstractModelComponent {
	
	@ApiModelProperty(readOnly = true,
			  value = "The date from which the transactions are considered for evaluating the attributes (Date of the oldest transaction for the accountId)")
	@JsonProperty("fromDate")
	private String fromDate;
	
	@ApiModelProperty(readOnly = true,
			  value = "The date until which the transactions are considered for evaluating the attributes (Date of the latest transaction for the accountId)")
	@JsonProperty("toDate")
	private String toDate;
	
	@ApiModelProperty(readOnly = true,
			  value = "Indicates whether the account is a primary account based on an implicit logic")
	@JsonProperty("isPrimaryAccount")
	private Boolean isPrimaryAccount;
	
	@ApiModelProperty(readOnly = true,
			  value = "Indicates whether the account is an active account based on an implicit logic")
	@JsonProperty("isActiveAccount")
	private Boolean isActiveAccount;
	
	@ApiModelProperty(readOnly = true,
			  value = "Indicates whether the account has salary credits based on an implicit logic")
	@JsonProperty("salaryCredits")
	private Boolean salaryCredits;
	
	@ApiModelProperty(readOnly = true,
			  value = "Indicates whether the account has any income credits based on an implicit logic")
	@JsonProperty("incomeCredits")
	private Boolean incomeCredits;
	
	@ApiModelProperty(readOnly = true,
			  value = "Indicates whether the account has any bill payments based on an implicit logic")
	@JsonProperty("billPayments")
	private Boolean billPayments;
	
	@ApiModelProperty(readOnly = true,
			  value = "Indicates whether the account has any loan payments based on an implicit logic")
	@JsonProperty("loanPayments")
	private Boolean loanPayments;
	
	@ApiModelProperty(readOnly = true,
			  value = "Indicates whether the account has any mortgage payments based on an implicit logic")
	@JsonProperty("mortgagePayments")
	private Boolean mortgagePayments;
	
	@ApiModelProperty(readOnly = true,
			  value = "Indicates whether the account has any card-related payments based on an implicit logic")
	@JsonProperty("cardPayments")
	private Boolean cardPayments;
	
	@ApiModelProperty(readOnly = true, value = "An array that lists the details about the latest 3 transactions that occurred in the user's account")
	@JsonProperty("latestTransactions")
	private List<ClassificationSummaryTransaction> latestTransactions;
	
	
	/**
	 * The date from which the transactions are considered for evaluating the attributes (Date of the oldest transaction for the accountId)
	 * 
	 * @return fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}
	
	/**
	 * The date until which the transactions are considered for evaluating the attributes (Date of the latest transaction for the accountId)
	 * 
	 * @return toDate
	 */
	public String getToDate() {
		return toDate;
	}
	
	/**
	 * Indicates whether the account is a primary account based on an implicit logic
	 * 
	 * @return isPrimaryAccount
	 */
	public Boolean getIsPrimaryAccount() {
		return isPrimaryAccount;
	}
	
	/**
	 * Indicates whether the account is an active account based on an implicit logic
	 * 
	 * @return isActiveAccount
	 */
	public Boolean getIsActiveAccount() {
		return isActiveAccount;
	}
	
	/**
	 * Indicates whether the account has salary credits based on an implicit logic
	 * 
	 * @return salaryCredits
	 */
	public Boolean getSalaryCredits() {
		return salaryCredits;
	}
	
	/**
	 * Indicates whether the account has any income credits based on an implicit logic
	 * 
	 * @return incomeCredits
	 */
	public Boolean getIncomeCredits() {
		return incomeCredits;
	}
	
	/**
	 * Indicates whether the account has any bill payments based on an implicit logic
	 * 
	 * @return billPayments
	 */
	public Boolean getBillPayments() {
		return billPayments;
	}
	
	/**
	 * Indicates whether the account has any loan payments based on an implicit logic
	 * 
	 * @return loanPayments
	 */
	public Boolean getLoanPayments() {
		return loanPayments;
	}
	
	/**
	 * Indicates whether the account has any mortgage payments based on an implicit logic
	 * 
	 * @return mortgagePayments
	 */
	public Boolean getMortgagePayments() {
		return mortgagePayments;
	}
	
	/**
	 * Indicates whether the account has any card-related payments based on an implicit logic
	 * 
	 * @return cardPayments
	 */
	public Boolean getCardPayments() {
		return cardPayments;
	}
	
	/**
	 * An array that lists the details about the latest 3 transactions that occurred in the user’s account
	 * 
	 * @return latestTransactions
	 */
	public List<ClassificationSummaryTransaction> getLatestTransactions() {
		return latestTransactions;
	}
	
	@Override
	public String toString() {
		return "TransactionSummary [fromDate=" + fromDate + ", toDate=" + toDate + ", isPrimaryAccount=" + isPrimaryAccount
				+ ", isActiveAccount=" + isActiveAccount + ", salaryCredits=" + salaryCredits + ", incomeCredits=" + incomeCredits
				+ ", billPayments=" + billPayments + ", loanPayments=" + loanPayments + ", mortgagePayments=" + mortgagePayments
				+ ", cardPayments=" + cardPayments + ", latestTransactions=" + latestTransactions + "]";
	}
}
