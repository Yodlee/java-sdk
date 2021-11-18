/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.verification;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.AccountHolder;
import com.yodlee.api.model.Money;
import com.yodlee.api.model.account.BankTransferCode;
import com.yodlee.api.model.account.FullAccountNumberList;
import com.yodlee.api.model.account.enums.AccountClassification;
import com.yodlee.api.model.verification.enums.VerifiedAccountsContainer;
import com.yodlee.api.model.verification.enums.VerifiedAccountsFailedReason;
import com.yodlee.api.model.verification.enums.VerifiedAccountsVerificationStatus;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"CONTAINER", "providerId", "providerAccountId", "accountId", "displayedName" ,"providerName", "accountType",
		"accountNumber", "accountName", "availableBalance", "currentBalance", "balance", "cash", "classification",
		"verificationStatus", "failedReason", "isSelected", "fullAccountNumberList", "bankTransferCode", "holder"})
public class VerifiedAccounts extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "The type of service. E.g., Bank, Investment <br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank, investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET /verification/verifiedAccounts"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("CONTAINER")
	protected VerifiedAccountsContainer container;

	@ApiModelProperty(readOnly = true,
					  value = "Identifier of the provider site. The primary key of provider resource. "//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank, investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET /verification/verifiedAccounts</li>"//
							  + "</ul>")
	@JsonProperty("providerId")
	protected String providerId;

	@ApiModelProperty(readOnly = true,
					  value = "The primary key of the provider account resource."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank, investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET /verification/verifiedAccounts</li>"//
							  + "</ul>")
	@JsonProperty("providerAccountId")
	protected Long providerAccountId;

	@ApiModelProperty(readOnly = true,
					  value = "The primary key of the provider account resource."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank, investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET /verification/verifiedAccounts</li>"//
							  + "</ul>")
	@JsonProperty("accountId")
	protected Long accountId;

	@ApiModelProperty(readOnly = true,
			  value = "The name or identification of the account owner, as it appears at the FI site. "
					  + "<br><b>Note:</b> The account holder name can be full or partial based on how it is displayed in the account "
					  + "summary page of the FI site. In most cases, the FI site does not display the full account holder "
					  + "name in the account summary page."//
					  + "<br><br>"//
					  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
					  + "<b>Applicable containers</b>: bank, investment<br>"//
					  + "<b>Endpoints</b>:"//
					  + "<ul>"//
					  + "<li>GET /verification/verifiedAccounts</li>"//
					  + "</ul>")
	@JsonProperty("displayedName")
	protected String displayedName;
	
	@ApiModelProperty(readOnly = true,
					  value = "Service provider or institution name where the account originates. This belongs to the provider resource."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank, investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET /verification/verifiedAccounts</li>"//
							  + "</ul>")
	@JsonProperty("providerName")
	protected String providerName;

	@ApiModelProperty(readOnly = true,
					  value = "The type of account that is aggregated, i.e., savings, checking, charge, HELOC, etc. "
							  + "The account type is derived based on the attributes of the account. " //
							  + "<br><b>Valid Values:</b>"//
							  + "<br><b>Aggregated Account Type</b>"//
							  + "<br><b>bank</b>"//
							  + "<ul>"//
							  + "<li>CHECKING</li>"//
							  + "<li>SAVINGS</li>"//
							  + "<li>MONEY_MARKET</li>"//
							  + "</ul>"//
							  + "<b>investment (SN 1.0)</b>"//
							  + "<ul>"//
							  + "<li>BROKERAGE_MARGIN</li>"//
							  + "<li>BROKERAGE_CASH</li>"//
							  + "<li>BROKERAGE_LINK_ACCOUNT</li>"//
							  + "<li>INDIVIDUAL</li>"//
							  + "<li>CMA</li>"//
							  + "</ul>"//
							  + "<b>investment (SN 2.0)</b>"//
							  + "<ul>"//
							  + "<li>BROKERAGE_MARGIN</li>"//
							  + "<li>BROKERAGE_CASH</li>"//
							  + "<li>BROKERAGE_LINK_ACCOUNT</li>"//
							  + "<li>INDIVIDUAL</li>"//
							  + "<li>CMA</li>"//
							  + "</ul>"//
							  + "<ul>"//
							  + "<li>GET /verification/verifiedAccounts</li>"//
							  + "</ul>")
	@JsonProperty("accountType")
	protected String accountType;

	@ApiModelProperty(readOnly = true,
					  value = "The account number as it appears on the site. (The POST accounts service response return this field as number)<br>"
							  + "<b>Additional Details</b>:<b> Bank / Investment</b>:<br>"
							  + " The account number for the bank account as it appears at the site.<br>"
							  + "In most cases, the site does not display the full account number in the account summary page "
							  + "and additional navigation is required to aggregate it.<br>"//
							  + "<b>Applicable containers</b>: bank, investment<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET /verification/verifiedAccounts</li>"//
							  + "</ul>")
	@JsonProperty("accountNumber")
	protected String accountNumber;

	@ApiModelProperty(readOnly = true,
					  value = "The account name as it appears at the site.<br>"//
							  + "(The POST accounts service response return this field as name)<br>"//
							  + "<b>Applicable containers</b>: bank, investment<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET /verification/verifiedAccounts</li>"//
							  + "</ul>")
	@JsonProperty("accountName")
	protected String accountName;

	@ApiModelProperty(readOnly = true,
					  value = "The balance in the account that is available for spending. "
							  + "For checking accounts with overdraft, available balance may include "
							  + "overdraft amount, if end site adds overdraft balance to available balance.<br>"//
							  + "<b>Applicable containers</b>: bank, investment<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET /verification/verifiedAccounts</li>"//
							  + "</ul>")
	@JsonProperty("availableBalance")
	protected Money availableBalance;

	@ApiModelProperty(readOnly = true,
					  value = "The balance in the account that is available at the beginning of the "
							  + "business day; it is equal to the ledger balance of the account.<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET /verification/verifiedAccounts</li>"//
							  + "</ul>")
	@JsonProperty("currentBalance")
	protected Money currentBalance;

	@ApiModelProperty(readOnly = true,
					  value = "The total account value. " + "<br><b>Additional Details:</b>"
							  + "<br><b>Bank:</b> available balance or current balance."
							  + "<br><b>Investment:</b> The total balance of all the investment account, as it appears on the FI site."
							  + "<b>Applicable containers</b>: bank, investment <br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET /verification/verifiedAccounts</li>"//
							  + "</ul>")
	@JsonProperty("balance")
	protected Money balance;

	@ApiModelProperty(readOnly = true,
					  value = "The amount that is available for immediate withdrawal or the total amount available to purchase securities in a brokerage or investment account."
							  + "<br><b>Note:</b> The cash balance field is only applicable to brokerage related accounts.<br><br>"//
							  + "<b>Aggregated </b><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul><li>GET /verification/verifiedAccounts</li>"//
							  + "</ul>")
	@JsonProperty("cash")
	protected Money cash;

	@ApiModelProperty(readOnly = true, value = "The status of the account verification."//
	)
	@JsonProperty("verificationStatus")
	protected VerifiedAccountsVerificationStatus verificationStatus;

	@ApiModelProperty(readOnly = true, value = "The reason for the verification failure of the account.")//
	@JsonProperty("failedReason")
	protected VerifiedAccountsFailedReason failedReason;
	
	@ApiModelProperty(readOnly = true,
			  value = "The classification of the account such as personal, corporate, etc.<br><br>"//
					  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
					  + "<b>Applicable containers</b>: bank, investment<br>"//
					  + "<b>Endpoints</b>:"//
					  + "<li>GET /verification/verifiedAccounts</li>"//
					  + "</ul>"//
					  + "<b>Applicable Values</b><br>")
	@JsonProperty("classification")
	protected AccountClassification classification;
	
	@ApiModelProperty(readOnly = true,
			  value = "Bank and branch identification information.<br>"//
					  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
					  + "<b>Applicable containers</b>: bank, investment<br>"//
					  + "<b>Endpoints</b>:<br>"//
					  + "<ul>"//
					  + "<li>GET /verification/verifiedAccounts</li>"//
					  + "</ul>"//
			)
	@JsonProperty("bankTransferCode")
	protected List<BankTransferCode> bankTransferCode;
	
	@ApiModelProperty(readOnly = true,
			  value = "Full account number List of the account that contains paymentAccountNumber and unmaskedAccountNumber. "
					  + "<br><br>"//
					  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
					  + "<b>Applicable containers</b>: bank, investment <br>"////
					  + "<b>Endpoints</b>:"//
					  + "<ul>"//
					  + "<li>GET /verification/verifiedAccounts</li>"//
					  + "</ul>")
	@JsonProperty("fullAccountNumberList")
	private FullAccountNumberList fullAccountNumberList;
	
	@ApiModelProperty(readOnly = true,
			  value = "Holder details of the account."//
					  + "<br><br>"//
					  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
					  + "<b>Applicable containers</b>: bank<br>"//
					  + "<b>Endpoints</b>:"//
					  + "<ul>"//
					  + "<li>GET /verification/verifiedAccounts</li>"//
					  + "</ul>")
	@JsonProperty("holder")
	private List<AccountHolder> holders;
	
	@ApiModelProperty(readOnly = true,
			  value = "Indicates if an account is selected by the user in the FastLink 4.0 application")
	@JsonProperty("isSelected")
	private Boolean isSelected;

	/**
	 * The type of service. E.g., Bank, Investment,.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET /verification/verifiedAccounts</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return CONTAINER
	 */
	@JsonProperty("CONTAINER")
	public VerifiedAccountsContainer getContainer() {
		return container;
	}

	/**
	 * Identifier of the provider site. The primary key of provider resource. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET /verification/verifiedAccounts</li>
	 * </ul>
	 * 
	 * @return providerId
	 */
	public String getProviderId() {
		return providerId;
	}

	/**
	 * The primary key of the provider account resource. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET /verification/verifiedAccounts</li>
	 * </ul>
	 * 
	 * @return providerAccountId
	 */
	public Long getProviderAccountId() {
		return providerAccountId;
	}

	/**
	 * The primary key of the provider account resource. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET /verification/verifiedAccounts</li>
	 * </ul>
	 * 
	 * @return accountId
	 */
	public Long getAccountId() {
		return accountId;
	}

	/**
	 * The name or identification of the account owner, as it appears at the FI site. <br>
	 * <b>Note:</b> The account holder name can be full or partial based on how it is displayed in the account summary
	 * page of the FI site. In most cases, the FI site does not display the full account holder name in the account
	 * summary page. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET /verification/verifiedAccounts</li>
	 * </ul>
	 * 
	 * @return displayedName
	 */
	public String getDisplayedName() {
		return displayedName;
	}
	
	/**
	 * Service provider or institution name where the account originates. This belongs to the provider resource. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET /verification/verifiedAccounts</li>
	 * </ul>
	 * 
	 * @return providerName
	 */
	public String getProviderName() {
		return providerName;
	}

	/**
	 * The type of account that is aggregated, i.e., savings, checking, charge, HELOC, etc. The account type is derived
	 * based on the attributes of the account. <br>
	 * <b>Valid Values:</b> <br>
	 * <b>Aggregated Account Type</b> <br>
	 * <b>bank</b>
	 * <ul>
	 * <li>CHECKING</li>
	 * <li>SAVINGS</li>
	 * <li>MONEY_MARKET</li>
	 * </ul>
	 * <b>investment (SN 1.0)</b>
	 * <ul>
	 * <li>BROKERAGE_MARGIN</li>
	 * <li>BROKERAGE_CASH</li>
	 * <li>BROKERAGE_LINK_ACCOUNT</li>
	 * <li>INDIVIDUAL</li>
	 * <li>CMA</li>
	 * </ul>
	 * <b>investment (SN 2.0)</b>
	 * <ul>
	 * <li>BROKERAGE_MARGIN</li>
	 * <li>BROKERAGE_CASH</li>
	 * <li>BROKERAGE_LINK_ACCOUNT</li>
	 * <li>INDIVIDUAL</li>
	 * <li>CMA</li>
	 * </ul>
	 * 
	 * @return accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * The account number as it appears on the site. (The POST accounts service response return this field as
	 * number)<br>
	 * <b>Additional Details</b>:<b> Bank/ Investment</b>:<br>
	 * The account number for the bank account as it appears at the site.<br>
	 * The account number can be full or partial based on how it is displayed in the account summary page of the site.
	 * In most cases, the site does not display the full account number in the account summary page and additional
	 * navigation is required to aggregate it.<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET /verification/verifiedAccounts</li>
	 * </ul>
	 * 
	 * @return accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * The account name as it appears at the site.<br>
	 * (The POST accounts service response return this field as name)<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET /verification/verifiedAccounts</li>
	 * </ul>
	 * 
	 * @return accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * The balance in the account that is available for spending. For checking accounts with overdraft, available
	 * balance may include overdraft amount, if end site adds overdraft balance to available balance.<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:<br>
	 * GET /verification/verifiedAccounts
	 * 
	 * @return availableBalance
	 */
	public Money getAvailableBalance() {
		return availableBalance;
	}

	/**
	 * The balance in the account that is available at the beginning of the business day; it is equal to the ledger
	 * balance of the account.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET /verification/verifiedAccounts</li>
	 * </ul>
	 * 
	 * @return currentBalance
	 */
	public Money getCurrentBalance() {
		return currentBalance;
	}

	/**
	 * The total account value. * <br>
	 * <b>Additional Details:</b> <br>
	 * <b>Bank:</b> available balance or current balance. <br>
	 * <b>Investment:</b> The total balance of all the investment account, as it appears on the FI site. <br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET /verification/verifiedAccounts</li>
	 * </ul>
	 * 
	 * @return balance
	 */
	public Money getBalance() {
		return balance;
	}

	/**
	 * The amount that is available for immediate withdrawal or the total amount available to purchase securities in a
	 * brokerage or investment account. <br>
	 * <b>Note:</b> The cash balance field is only applicable to brokerage related accounts.<br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET /verification/verifiedAccounts</li>
	 * </ul>
	 * 
	 * @return cash
	 */
	public Money getCash() {
		return cash;
	}

	/**
	 * The verification status of account.
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET /verification/verifiedAccounts</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return refreshStatus
	 */
	public VerifiedAccountsVerificationStatus getVerificationStatus() {
		return verificationStatus;
	}

	/**
	 * The verification failure reason for the account.
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <br>
	 * <b>Applicable containers</b>: bank, investment
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET /verification/verifiedAccounts</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return failedReason
	 */
	public VerifiedAccountsFailedReason getFailedReason() {
		return failedReason;
	}
	
	/**
	 * The classification of the account such as personal, corporate, etc.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET /verification/verifiedAccounts</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return classification
	 */
	public AccountClassification getClassification() {
		return classification;
	}
 
	/**
	 * Bank and branch identification information.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET /verification/verifiedAccounts</li>
	 * </ul>
	 * 
	 * @return bankTransferCode
	 */
	@JsonProperty("bankTransferCode")
	public List<BankTransferCode> getBankTransferCode() {
		return bankTransferCode == null ? null : Collections.unmodifiableList(bankTransferCode);
	}
	
	/**
	 * Full account number List of the account that contains paymentAccountNumber and unmaskedAccountNumber
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, investment
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET /verification/verifiedAccounts</li>
	 * </ul>
	 * 
	 * 
	 * @return fullAccountNumberList
	 */
	@JsonProperty("fullAccountNumberList")
	public FullAccountNumberList getFullAccountNumberList() {
		return fullAccountNumberList;
	}
	

	/**
	 * Holder details of the account. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <br>
	 * <b>Applicable containers</b>: bank, investment
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET /verification/verifiedAccounts</li>
	 * </ul>
	 * 
	 * @return holder
	 */
	@JsonProperty("holder")
	public List<AccountHolder> getHolders() {
		return holders == null ? null : Collections.unmodifiableList(holders);
	}
	
	/**
	 * 
	 * Indicates if an account is selected by the user in the FastLink 4.0 application
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <br>
	 * <b>Applicable containers</b>: bank, investment
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET /verification/verifiedAccounts</li>
	 * </ul>
	 * 
	 * @return isSelected
	 */
	@JsonProperty("isSelected")
	public Boolean getIsSelected() {
		return isSelected;
	}

	@Override
	public String toString() {
		return "VerifiedAccounts [container=" + container + ", providerId=" + providerId + ", providerAccountId="
				+ providerAccountId + ", accountId=" + accountId + ", displayedName=" + displayedName
				+ ", providerName=" + providerName + ", accountType=" + accountType + ", accountNumber=" + accountNumber
				+ ", accountName=" + accountName + ", availableBalance=" + availableBalance + ", currentBalance="
				+ currentBalance + ", balance=" + balance + ", cash=" + cash + ", verificationStatus="
				+ verificationStatus + ", failedReason=" + failedReason + ", classification=" + classification
				+ ", bankTransferCode=" + bankTransferCode + ", fullAccountNumberList=" + fullAccountNumberList
				+ ", holders=" + holders + ", isSelected=" + isSelected + "]";
	}
}
