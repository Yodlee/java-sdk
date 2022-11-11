/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.verification;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"accountId", "accountName", "accountType", "site", "accountOpenDate", "lastUpdated", "availableBalance", "transactionSummary"})
public class ClassificationSummaryAccountSummary extends AbstractModelComponent {
	
	@ApiModelProperty(readOnly = true,
			  value = "The primary key of the account resource and the unique identifier for the account.<br><br>"//
					  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
					  + "<b>Applicable containers</b>: bank"
					  )
	@JsonProperty("accountId")
	private Long accountId;
	
	@ApiModelProperty(readOnly = true, value = "The account name as it appears at the site")
	@JsonProperty("accountName")
	private String accountName;
	
	@ApiModelProperty(readOnly = true,
			  value = "The type of account that is aggregated such as savings, checking, etc. "
			  		+ "The account type is derived based on the attributes of the account.")
	@JsonProperty("accountType")
	private String accountType;
	
	@ApiModelProperty(readOnly = true, value = "The name of the provider site")
	@JsonProperty("site")
	private String site;
	
	@ApiModelProperty(readOnly = true, value = "The date on which the user opened the account at the provider site")
	@JsonProperty("accountOpenDate")
	private String accountOpenDate;
	
	@ApiModelProperty(readOnly = true, value = "The date-time the account information was last retrieved from the provider site and updated in the Yodlee system")
	@JsonProperty("lastUpdated")
	private String lastUpdated;
	
	@ApiModelProperty(readOnly = true,
			  value = "The balance in the account that is available for spending. The value is aggregated from the provider site during the last refresh.<br>"//
					  + "<b>Note</b>: For checking accounts with overdraft, the available balance amount may include the overdraft amount if the provider site adds the overdraft balance to the available balance.")
	@JsonProperty("availableBalance")
	private Money availableBalance;
	
	@ApiModelProperty(readOnly = true, value = "The transaction summary entity encapsulates the transaction-level summary attributes and account specifics based on the nature of transactions")
	@JsonProperty("transactionSummary")
	private ClassificationSummaryTransactionSummary transactionSummary;
	
	/**
	 * "The primary key of the account resource and the unique identifier for the account<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated <br>
	 * <b>Applicable containers</b>: bank"
	 * 
	 * @return accountId
	 */
	public Long getAccountId() {
		return accountId;
	}
	
	/**
	 * The account name as it appears at the site.
	 * 
	 * @return accountName
	 */
	public String getAccountName() {
		return accountName;
	}
	
	/**
	 * The type of account that is aggregated such as savings, checking, etc. 
	 * The account type is derived based on the attributes of the account.
	 * 
	 * @return accountType
	 */
	public String getAccountType() {
		return accountType;
	}
	
	/**
	 * The name of the provider site.
	 * 
	 * @return site
	 */
	public String getSite() {
		return site;
	}
	
	/**
	 * The date on which the user opened the account at the provider site
	 * 
	 * @return accountOpenDate
	 */
	public String getAccountOpenDate() {
		return accountOpenDate;
	}
	
	/**
	 * The date-time the account information was last retrieved from the provider site and updated in the Yodlee system
	 * 
	 * @return lastUpdated
	 */
	public String getLastUpdated() {
		return lastUpdated;
	}
	
	/**
	 * The balance in the account that is available for spending. The value is aggregated from the provider site during the last refresh.<br>
	 * <b>Note</b>: For checking accounts with overdraft, 
	 * the available balance amount may include the overdraft amount if the provider site adds the overdraft balance to the available balance.
	 * 
	 * @return availableBalance
	 */
	public Money getAvailableBalance() {
		return availableBalance;
	}
	
	/**
	 * The transaction summary entity encapsulates the transaction-level summary attributes and account specifics based on the nature of transactions
	 * 
	 * @return transactionSummary
	 */
	public ClassificationSummaryTransactionSummary getTransactionSummary() {
		return transactionSummary;
	}
	
	@Override
	public String toString() {
		return "AccountSummary [accountId=" + accountId + ", accountName=" + accountName + ", accountType=" + accountType
				+ ", site=" + site + ", accountOpenDate=" + accountOpenDate + ", lastUpdated=" + lastUpdated
				+ ", availableBalance=" + availableBalance + ", transactionSummary=" +transactionSummary + "]";
	}
}
