/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.statement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "isLatest", "billingPeriodEnd", "accountId", "lastPaymentAmount", "lastPaymentDate",
		"billingPeriodStart", "statementDate", "lastUpdated", "amountDue", "dueDate", "minimumPayment", "newCharges",
		"apr", "cashApr", "interestAmount", "principalAmount", "loanBalance", "cashAdvance"})
public class Statement extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "Unique identifier for the statement."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance<br>"//
	)
	@JsonProperty("id")
	private Long id;

	@ApiModelProperty(readOnly = true,
					  value = "The field is set to true if the statement is the latest generated statement."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance<br>"//
	)
	@JsonProperty("isLatest")
	private Boolean isLatest;

	@ApiModelProperty(readOnly = true,
					  value = "The end date of the statement period."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance<br>"//
	)
	@JsonProperty("billingPeriodEnd")
	private String billingPeriodEnd;

	@ApiModelProperty(readOnly = true,
					  value = "Account to which the statement belongs to."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance<br>"//
	)
	@JsonProperty("accountId")
	private Long accountId;

	@ApiModelProperty(readOnly = true,
					  value = "The last payment done for the previous billing cycle in the current statement period."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance<br>"//
	)
	@JsonProperty("lastPaymentAmount")
	private Money lastPaymentAmount;

	@ApiModelProperty(readOnly = true,
					  value = "The date on which the last payment was done during the billing cycle."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance<br>"//
	)
	@JsonProperty("lastPaymentDate")
	private String lastPaymentDate;

	@ApiModelProperty(readOnly = true,
					  value = "The start date of the statement period."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance<br>"//
	)
	@JsonProperty("billingPeriodStart")
	private String billingPeriodStart;

	@ApiModelProperty(readOnly = true,
					  value = "The date on which the statement is generated."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance<br>"//
	)
	@JsonProperty("statementDate")
	private String statementDate;

	@ApiModelProperty(readOnly = true,
					  value = "The date when the account was last updated by Yodlee."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance<br>"//
	)
	@JsonProperty("lastUpdated")
	private String lastUpdated;

	@ApiModelProperty(readOnly = true,
					  value = "The total amount owed at the end of the billing period."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance<br>"//
	)
	@JsonProperty("amountDue")
	private Money amountDue;

	@ApiModelProperty(readOnly = true,
					  value = "The date by when the minimum payment is due to be paid." + "<br>"//
							  + "<b>Note:</b> The due date that appears in the statement may differ from the due date at the account-level."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance<br>"//
	)
	@JsonProperty("dueDate")
	private String dueDate;

	@ApiModelProperty(readOnly = true,
					  value = "<b>Credit Card:</b> The minimum amount that the consumer has to pay every month on the credit card account. Data provides an up-to-date information to the consumer."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance<br>"//
	)
	@JsonProperty("minimumPayment")
	private Money minimumPayment;

	@ApiModelProperty(readOnly = true,
					  value = "New charges on the statement (i.e., charges since last statement to end of the billing period). Applicable to line of credit loan type."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance<br>"//
	)
	@JsonProperty("newCharges")
	private Money newCharges;

	@ApiModelProperty(readOnly = true,
					  value = "The APR applied to the balance on the credit card account, as available in the statement."
							  + "<br>"//
							  + "<b>Note:</b> In case of variable APR, the APR available on the statement might differ from the APR available at the account-level."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance<br>"//
	)
	@JsonProperty("apr")
	private Double apr;

	@ApiModelProperty(readOnly = true,
					  value = "The APR applicable to cash withdrawals on the credit card account."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance<br>"//
	)
	@JsonProperty("cashApr")
	private Double cashApr;

	@ApiModelProperty(readOnly = true,
					  value = "The interest amount that is part of the amount due or the payment amount."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance<br>"//
	)
	@JsonProperty("interestAmount")
	private Money interestAmount;

	@ApiModelProperty(readOnly = true,
					  value = "The principal amount that is part of the amount due or the payment amount."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance<br>"//
	)
	@JsonProperty("principalAmount")
	private Money principalAmount;

	@ApiModelProperty(readOnly = true,
					  value = "The outstanding principal balance on the loan account."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance<br>"//
	)
	@JsonProperty("loanBalance")
	private Money loanBalance;

	@ApiModelProperty(readOnly = true,
					  value = "Cash Advance is the amount that is withdrawn from credit card over the counter or from an ATM up to the available credit/cash limit."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance<br>"//
	)
	@JsonProperty("cashAdvance")
	private Money cashAdvance;

	/**
	 * The end date of the statement period. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance<br>
	 * 
	 * @return billingPeriodEnd
	 */
	public String getBillingPeriodEnd() {
		return billingPeriodEnd;
	}

	/**
	 * The last payment done for the previous billing cycle in the current statement period. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance<br>
	 * 
	 * @return lastPaymentAmount
	 */
	public Money getLastPaymentAmount() {
		return lastPaymentAmount;
	}

	/**
	 * The date on which the last payment was done during the billing cycle. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance<br>
	 * 
	 * @return lastPaymentDate
	 */
	public String getLastPaymentDate() {
		return lastPaymentDate;
	}

	/**
	 * The start date of the statement period. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance<br>
	 * 
	 * @return billingPeriodStart
	 */
	public String getBillingPeriodStart() {
		return billingPeriodStart;
	}

	/**
	 * The date on which the statement is generated. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance<br>
	 * 
	 * @return statementDate
	 */
	public String getStatementDate() {
		return statementDate;
	}

	/**
	 * The date when the account was last updated by Yodlee. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance<br>
	 * 
	 * @return lastUpdated
	 */
	public String getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * The total amount owed at the end of the billing period. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance<br>
	 * 
	 * @return amountDue
	 */
	public Money getAmountDue() {
		return amountDue;
	}

	/**
	 * The date by when the minimum payment is due to be paid. * <br>
	 * <b>Note:</b> The due date that appears in the statement may differ from the due date at the account-level. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance<br>
	 * 
	 * @return dueDate
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * Unique identifier for the statement. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance<br>
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * The field is set to true if the statement is the latest generated statement. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance<br>
	 * 
	 * @return isLatest
	 */
	public Boolean getIsLatest() {
		return isLatest;
	}

	/**
	 * Account to which the statement belongs to. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance<br>
	 * 
	 * @return accountId
	 */
	public Long getAccountId() {
		return accountId;
	}

	/**
	 * <b>Credit Card:</b> The minimum amount that the consumer has to pay every month on the credit card account. Data
	 * provides an up-to-date information to the consumer. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance<br>
	 * 
	 * @return minimumPayment
	 */
	public Money getMinimumPayment() {
		return minimumPayment;
	}

	/**
	 * New charges on the statement (i.e., charges since last statement to end of the billing period). Applicable to
	 * line of credit loan type. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance<br>
	 * 
	 * @return newCharges
	 */
	public Money getNewCharges() {
		return newCharges;
	}

	/**
	 * The APR applied to the balance on the credit card account, as available in the statement. <br>
	 * <b>Note:</b> In case of variable APR, the APR available on the statement might differ from the APR available at
	 * the account-level. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance<br>
	 * 
	 * @return apr
	 */
	public Double getApr() {
		return apr;
	}

	/**
	 * The APR applicable to cash withdrawals on the credit card account. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance<br>
	 * 
	 * @return cashApr
	 */
	public Double getCashApr() {
		return cashApr;
	}

	/**
	 * The interest amount that is part of the amount due or the payment amount. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance<br>
	 * 
	 * @return interestAmount
	 */
	public Money getInterestAmount() {
		return interestAmount;
	}

	/**
	 * The principal amount that is part of the amount due or the payment amount. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance<br>
	 * 
	 * @return principalAmount
	 */
	public Money getPrincipalAmount() {
		return principalAmount;
	}

	/**
	 * The outstanding principal balance on the loan account. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance<br>
	 * 
	 * @return loanBalance
	 */
	public Money getLoanBalance() {
		return loanBalance;
	}

	/**
	 * Cash Advance is the amount that is withdrawn from credit card over the counter or from an ATM up to the available
	 * credit/cash limit. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance<br>
	 * 
	 * @return cashAdvance
	 */
	public Money getCashAdvance() {
		return cashAdvance;
	}

	@Override
	public String toString() {
		return "Statement [id=" + id + ", isLatest=" + isLatest + ", billingPeriodEnd=" + billingPeriodEnd
				+ ", accountId=" + accountId + ", lastPaymentAmount=" + lastPaymentAmount + ", lastPaymentDate="
				+ lastPaymentDate + ", billingPeriodStart=" + billingPeriodStart + ", statementDate=" + statementDate
				+ ", lastUpdated=" + lastUpdated + ", amountDue=" + amountDue + ", dueDate=" + dueDate
				+ ", minimumPayment=" + minimumPayment + ", newCharges=" + newCharges + ", apr=" + apr + ", cashApr="
				+ cashApr + ", interestAmount=" + interestAmount + ", principalAmount=" + principalAmount
				+ ", loanBalance=" + loanBalance + ", cashAdvance=" + cashAdvance + "]";
	}
}
