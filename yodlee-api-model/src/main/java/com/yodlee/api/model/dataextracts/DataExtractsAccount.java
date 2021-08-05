/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.dataextracts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.account.AbstractAccount;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"CONTAINER", "providerAccountId", "accountName", "accountStatus", "accountNumber",
		"aggregationSource", "isAsset", "balance", "id", "userClassification", "includeInNetWorth", "providerId",
		"providerName", "isManual", "availableBalance", "currentBalance", "accountType", "displayedName", "createdDate",
		"sourceId", "dueDate", "401kLoan", "annuityBalance", "interestPaidYTD", "interestPaidLastYear",
		"interestRateType", "collateral", "annualPercentageYield", "premium", "remainingBalance", "policyEffectiveDate",
		"policyFromDate", "policyToDate", "deathBenefit", "policyTerm", "policyStatus", "apr", "availableCash",
		"availableCredit", "cash", "cashValue", "classification", "expirationDate", "faceAmount", "interestRate",
		"lastPayment", "lastPaymentAmount", "lastPaymentDate", "lastUpdated", "marginBalance", "maturityAmount",
		"maturityDate", "moneyMarketBalance", "nickname", "runningBalance", "totalCashLimit", "totalCreditLine",
		"totalUnvestedBalance", "totalVestedBalance", "escrowBalance", "homeInsuranceType", "lifeInsuranceType",
		"originalLoanAmount", "principalBalance", "premiumPaymentTerm", "recurringPayment", "term", "totalCreditLimit",
		"enrollmentDate", "primaryRewardUnit", "currentLevel", "nextLevel", "shortBalance",
		"lastEmployeeContributionAmount", "lastEmployeeContributionDate", "memo", "originationDate", "overDraftLimit",
		"valuationType", "homeValue", "estimatedDate", "address", "historicalBalances", "loanPayoffAmount",
		"loanPayByDate", "bankTransferCode", "rewardBalance", "frequency", "amountDue", "minimumAmountDue", "dataset",
		"associatedProviderAccountId", "loanPayOffDetails", "coverage", "sourceAccountStatus", "repaymentPlanType",
		"guarantor", "lender", "oauthMigrationStatus", "sourceProviderAccountId"})
public class DataExtractsAccount extends AbstractAccount {

	@ApiModelProperty(readOnly = true,
					  value = "Indicates if the account is marked as deleted."//
							  + "<b>Applicable containers</b>: All Containers<br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("isDeleted")
	protected Boolean isDeleted;

	@ApiModelProperty(readOnly = true,
			  value = "The providerAccountId that is deleted and merged into the destinationProviderAccountId as part of the many-to-one OAuth migration process.<br>"//
					  + "<b>Endpoints</b>:"//
					  + "<ul>"//
					  + "<li>GET dataExtracts/userData</li>"//
					  + "</ul>")
	@JsonProperty("sourceProviderAccountId")
	protected Long sourceProviderAccountId;

	/**
	 * Indicates if the account is marked as deleted. <b>Applicable containers</b>: All Containers<br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET dataExtracts/userData</li>
	 * </ul>
	 * 
	 * @return isDeleted
	 */
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	/**
	 * The providerAccountId that is deleted and merged into the destinationProviderAccountId as part of the many-to-one OAuth migration process.<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET dataExtracts/userData</li>
	 * </ul>
	 *
	 * @return the sourceProviderAccountId
	 */
	public Long getSourceProviderAccountId() {
		return sourceProviderAccountId;
	}

	@Override
	public String toString() {
		return "DataExtractsAccount [isDeleted=\" + isDeleted + \", container=" + container + ", providerAccountId="
				+ providerAccountId + ", accountName=" + accountName + ", accountStatus=" + accountStatus
				+ ", accountNumber=" + accountNumber + ", aggregationSource=" + aggregationSource + ", isAsset="
				+ isAsset + ", balance=" + balance + ", id=" + id + ", userClassification=" + userClassification
				+ ", includeInNetWorth=" + includeInNetWorth + ", providerId=" + providerId + ", providerName="
				+ providerName + ", isManual=" + isManual + ", availableBalance=" + availableBalance
				+ ", currentBalance=" + currentBalance + ", accountType=" + accountType + ", displayedName="
				+ displayedName + ", createdDate=" + createdDate + ", sourceId=" + sourceId + ", dueDate=" + dueDate
				+ ", loan401k=" + loan401k + ", annuityBalance=" + annuityBalance + ", interestPaidYTD="
				+ interestPaidYTD + ", interestPaidLastYear=" + interestPaidLastYear + ", interestRateType="
				+ interestRateType + ", collateral=" + collateral + ", annualPercentageYield=" + annualPercentageYield
				+ ", premium=" + premium + ", remainingBalance=" + remainingBalance + ", policyEffectiveDate="
				+ policyEffectiveDate + ", policyFromDate=" + policyFromDate + ", policyToDate=" + policyToDate
				+ ", deathBenefit=" + deathBenefit + ", policyTerm=" + policyTerm + ", policyStatus=" + policyStatus
				+ ", apr=" + apr + ", availableCash=" + availableCash + ", availableCredit=" + availableCredit
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
				+ ", repaymentPlanType=" + repaymentPlanType + ", guarantor=" + guarantor + ", lender=" + lender 
				+ ", oauthMigrationStatus=" + openBankingMigrationStatusType
				+ ", sourceProviderAccountId=" + sourceProviderAccountId + "]";
	}
}
