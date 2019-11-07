/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AccountHolder;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"fullAccountNumber", "CONTAINER", "providerAccountId", "accountName", "accountStatus",
		"accountNumber", "aggregationSource", "isAsset", "balance", "id", "userClassification", "includeInNetWorth",
		"providerId", "providerName", "isManual", "availableBalance", "currentBalance", "accountType", "displayedName",
		"createdDate", "dueDate", "401kLoan", "annuityBalance", "interestPaidYTD", "interestPaidLastYear",
		"interestRateType", "collateral", "annualPercentageYield", "premium", "remainingBalance", "policyEffectiveDate",
		"policyFromDate", "policyToDate", "deathBenefit", "policyTerm", "policyStatus", "apr", "cashApr",
		"availableCash", "availableCredit", "cash", "cashValue", "classification", "expirationDate", "faceAmount",
		"interestRate", "lastPayment", "lastPaymentAmount", "lastPaymentDate", "lastUpdated", "marginBalance",
		"maturityAmount", "maturityDate", "moneyMarketBalance", "nickname", "runningBalance", "totalCashLimit",
		"totalCreditLine", "totalUnvestedBalance", "totalVestedBalance", "escrowBalance", "homeInsuranceType",
		"lifeInsuranceType", "originalLoanAmount", "principalBalance", "premiumPaymentTerm", "recurringPayment", "term",
		"totalCreditLimit", "enrollmentDate", "primaryRewardUnit", "currentLevel", "nextLevel", "shortBalance",
		"lastEmployeeContributionAmount", "lastEmployeeContributionDate", "memo", "originationDate", "overDraftLimit",
		"valuationType", "homeValue", "estimatedDate", "address", "historicalBalances", "loanPayoffAmount",
		"loanPayByDate", "profile", "bankTransferCode", "rewardBalance", "frequency", "amountDue", "minimumAmountDue",
		"dataset", "holder", "associatedProviderAccountId", "loanPayOffDetails", "coverage", "sourceAccountStatus",
		"repaymentPlanType", "guarantor", "lender", "paymentProfile", "autoRefresh"})
public class Account extends AbstractAccount {

	@ApiModelProperty(readOnly = true,
					  value = "Full account number of the account that is included only when include = fullAccountNumber is provided in the request. "
							  + "For student loan account the account number that will be used for ACH or fund transfer"//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Applicable containers</b>: bank, creditCard, investment, insurance, loan, reward, bill, otherAssets, otherLiabilities <br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>")
	@JsonProperty("fullAccountNumber")
	private String fullAccountNumber;

	@ApiModelProperty(readOnly = true,
					  value = "Profile information of the account."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>")
	@JsonProperty("profile")
	private AccountProfile profile;

	@ApiModelProperty(readOnly = true,
					  value = "Holder details of the account."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>")
	@JsonProperty("holder")
	private List<AccountHolder> holders;

	@ApiModelProperty(readOnly = true,
					  value = "The payment profile attribute contains information such as payment address, payment identifier, etc., "//
							  + "that are required to set up a payment. "//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>")
	@JsonProperty("paymentProfile")
	private PaymentProfile paymentProfile;

	@ApiModelProperty(readOnly = true,
					  value = "Auto refresh account-related information."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>")
	@JsonProperty("autoRefresh")
	private AutoRefresh autoRefresh;

	/**
	 * Auto refresh account-related information. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return autoRefresh
	 */
	public AutoRefresh getAutoRefresh() {
		return autoRefresh;
	}

	/**
	 * Full account number of the account that is included only when include = fullAccountNumber is provided in the
	 * request. For student loan account the account number that will be used for ACH or fund transfer <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: bank, creditCard, investment, insurance, loan, reward, bill, otherAssets,
	 * otherLiabilities <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return fullAccountNumber
	 */
	public String getFullAccountNumber() {
		return fullAccountNumber;
	}

	/**
	 * Holder details of the account. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return holder
	 */
	@JsonProperty("holder")
	public List<AccountHolder> getHolders() {
		return holders == null ? null : Collections.unmodifiableList(holders);
	}

	/**
	 * Profile information of the account. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return profile
	 */
	public AccountProfile getProfile() {
		return profile;
	}

	/**
	 * The payment profile attribute contains information such as payment address, payment identifier, etc., that are
	 * required to set up a payment. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return paymentProfile
	 */
	public PaymentProfile getPaymentProfile() {
		return paymentProfile;
	}

	@Override
	public String toString() {
		return "Account [fullAccountNumber=" + fullAccountNumber + ", profile=" + profile + ", holders=" + holders
				+ ", paymentProfile=" + paymentProfile + ", autoRefresh=" + autoRefresh + ", container=" + container
				+ ", providerAccountId=" + providerAccountId + ", accountName=" + accountName + ", accountStatus="
				+ accountStatus + ", accountNumber=" + accountNumber + ", aggregationSource=" + aggregationSource
				+ ", isAsset=" + isAsset + ", balance=" + balance + ", id=" + id + ", userClassification="
				+ userClassification + ", includeInNetWorth=" + includeInNetWorth + ", providerId=" + providerId
				+ ", providerName=" + providerName + ", isManual=" + isManual + ", availableBalance=" + availableBalance
				+ ", currentBalance=" + currentBalance + ", accountType=" + accountType + ", displayedName="
				+ displayedName + ", createdDate=" + createdDate + ", dueDate=" + dueDate + ", loan401k=" + loan401k
				+ ", annuityBalance=" + annuityBalance + ", interestPaidYTD=" + interestPaidYTD
				+ ", interestPaidLastYear=" + interestPaidLastYear + ", interestRateType=" + interestRateType
				+ ", collateral=" + collateral + ", annualPercentageYield=" + annualPercentageYield + ", premium="
				+ premium + ", remainingBalance=" + remainingBalance + ", policyEffectiveDate=" + policyEffectiveDate
				+ ", policyFromDate=" + policyFromDate + ", policyToDate=" + policyToDate + ", deathBenefit="
				+ deathBenefit + ", policyTerm=" + policyTerm + ", policyStatus=" + policyStatus + ", apr=" + apr
				+ ", cashApr=" + cashApr + ", availableCash=" + availableCash + ", availableCredit=" + availableCredit
				+ ", cash=" + cash + ", cashValue=" + cashValue + ", classification=" + classification
				+ ", expirationDate=" + expirationDate + ", faceAmount=" + faceAmount + ", interestRate=" + interestRate
				+ ", lastPayment=" + lastPayment + ", lastPaymentAmount=" + lastPaymentAmount + ", lastPaymentDate="
				+ lastPaymentDate + ", lastUpdated=" + lastUpdated + ", marginBalance=" + marginBalance
				+ ", maturityAmount=" + maturityAmount + ", maturityDate=" + maturityDate + ", moneyMarketBalance="
				+ moneyMarketBalance + ", nickname=" + nickname + ", runningBalance=" + runningBalance
				+ ", totalCashLimit=" + totalCashLimit + ", totalCreditLine=" + totalCreditLine
				+ ", totalUnvestedBalance=" + totalUnvestedBalance + ", totalVestedBalance=" + totalVestedBalance
				+ ", escrowBalance=" + escrowBalance + ", homeInsuranceType=" + homeInsuranceType
				+ ", lifeInsuranceType=" + lifeInsuranceType + ", originalLoanAmount=" + originalLoanAmount
				+ ", principalBalance=" + principalBalance + ", premiumPaymentTerm=" + premiumPaymentTerm
				+ ", recurringPayment=" + recurringPayment + ", term=" + term + ", totalCreditLimit=" + totalCreditLimit
				+ ", enrollmentDate=" + enrollmentDate + ", primaryRewardUnit=" + primaryRewardUnit + ", currentLevel="
				+ currentLevel + ", nextLevel=" + nextLevel + ", shortBalance=" + shortBalance
				+ ", lastEmployeeContributionAmount=" + lastEmployeeContributionAmount
				+ ", lastEmployeeContributionDate=" + lastEmployeeContributionDate + ", memo=" + memo
				+ ", originationDate=" + originationDate + ", overDraftLimit=" + overDraftLimit + ", valuationType="
				+ valuationType + ", homeValue=" + homeValue + ", estimatedDate=" + estimatedDate + ", address="
				+ address + ", loanPayoffAmount=" + loanPayoffAmount + ", loanPayByDate=" + loanPayByDate
				+ ", bankTransferCode=" + bankTransferCode + ", rewardBalance=" + rewardBalance + ", frequency="
				+ frequency + ", amountDue=" + amountDue + ", minimumAmountDue=" + minimumAmountDue + ", datasets="
				+ datasets + ", associatedProviderAccountIds=" + associatedProviderAccountIds + ", loanPayOffDetails="
				+ loanPayOffDetails + ", coverage=" + coverage + ", sourceAccountStatus=" + sourceAccountStatus
				+ ", repaymentPlanType=" + repaymentPlanType + ", guarantor=" + guarantor + ", lender=" + lender + "]";
	}
}
