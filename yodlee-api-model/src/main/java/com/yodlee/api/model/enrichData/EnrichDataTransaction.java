/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.enrichData;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;
import com.yodlee.api.model.enums.BaseType;
import com.yodlee.api.model.enrichData.EnrichDataContainer;
import com.yodlee.api.model.transaction.enums.TransactionStatus;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrichDataTransaction extends AbstractModelComponent {

	@ApiModelProperty(value = "A unique ID that the provider site has assigned to the transaction. The source ID is only available for the pre-populated accounts."//
			+ "<br>Pre-populated accounts are the accounts that the FI customers shares with Yodlee, so that the user does not have to add or aggregate those accounts."//
	)
	@Size(min = 1, max = 100, message = "{enrichData.data.invalid}")
	@JsonProperty("sourceId")
	protected String sourceId;

	@JsonProperty("status")
	protected TransactionStatus transactionStatus;

	@ApiModelProperty(value = "The account's container."//
			+ "<br><br>"//
			+ "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
			+ "<b>Applicable Values</b><br>"//
	)
	@NotNull(message = "{enrichData.data.invalid}")
	@JsonProperty("container")
	protected EnrichDataContainer container;

	@ApiModelProperty(value = "The amount of the transaction as it appears at the FI site. "//
			+ "<br><br>"//
			+ "<b>Applicable containers</b>: bank,creditCard<br>"//
	)
	@NotNull(message = "{enrichData.data.invalid}")
	@JsonProperty("amount")
	protected Money amount;

	@ApiModelProperty(value = "Description details"//
			+ "<br><br>"//
			+ "<b>Applicable containers</b>: bank,creditCard<br>"//
	)
	@NotNull(message = "{enrichData.data.invalid}")
	@JsonProperty("description")
	protected EnrichTransactionDescription description;

	@ApiModelProperty(value = "The date on which the transaction is posted to the account."//
			+ "<br><br>"//
			+ "<b>Applicable containers</b>: bank,creditCard<br>"//
	)
	@JsonProperty("postDate")
	protected String postDate;

	@ApiModelProperty(value = "The loginName of the User."//
			+ "<br><br>"//
			+ "<b>Applicable containers</b>: bank,creditCard<br>"//
	)
	@NotEmpty(message = "{enrichData.data.invalid}")
	@JsonProperty("userLoginName")
	protected String userLoginName;

	@ApiModelProperty(value = "The account number as it appears on the site. (The POST accounts service response return this field as number)<br>"
			+ "<b>Additional Details</b>:<b> Bank/ Loan/ Insurance/ Investment/Bill</b>:<br>"
			+ " The account number for the bank account as it appears at the site.<br>"
			+ "<b>Credit Card</b>: The account number of the card account as it appears at the site,<br>"
			+ "i.e., the card number.The account number can be full or partial based on how it is displayed in the account summary page of the site."
			+ "In most cases, the site does not display the full account number in the account summary page "
			+ "and additional navigation is required to aggregate it.<br>"//
			+ "<b>Applicable containers</b>: All Containers<br>"//
			+ "<b>Aggregated / Manual</b>: Both <br>"//
			+ "<b>Endpoints</b>:<br>"//
			+ "<ul>"//
			+ "<li>GET accounts</li>"//
			+ "<li>GET accounts/{accountId}</li>"//
			+ "<li>POST accounts</li>"//
			+ "<li>POST dataExtracts/userData</li>"//
			+ "<li>POST dataEnrich/userData</li>"//
			+ "</ul>")
	@JsonProperty("accountNumber")
	@NotEmpty(message = "{enrichData.data.invalid}")
	protected String accountNumber;

	@ApiModelProperty(value = "The date the transaction happens in the account. "//
			+ "<br><br>"//
			+ "<b>Applicable containers</b>: bank,creditCard<br>"//
	)
	@JsonProperty("transactionDate")
	protected String transactionDate;

	@ApiModelProperty(value = "Indicates if the transaction appears as a debit or a credit transaction in the account. "//
			+ "<br><br>"//
			+ "<b>Applicable containers</b>: bank,creditCard<br>"//
			+ "<b>Applicable Values</b><br>"//
	)
	@NotNull(message = "{enrichData.data.invalid}")
	@JsonProperty("baseType")
	protected BaseType baseType;

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public EnrichDataContainer getContainer() {
		return container;
	}

	public void setContainer(EnrichDataContainer container) {
		this.container = container;
	}

	public Money getAmount() {
		return amount;
	}

	public void setAmount(Money amount) {
		this.amount = amount;
	}

	public EnrichTransactionDescription getDescription() {
		return description;
	}

	public void setDescription(EnrichTransactionDescription description) {
		this.description = description;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BaseType getBaseType() {
		return baseType;
	}

	public void setBaseType(BaseType baseType) {
		this.baseType = baseType;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	@Override
	public String toString() {
		return "EnrichDataTransaction [sourceId=" + sourceId + ", transactionStatus=" + transactionStatus
				+ ", container=" + container + ", amount=" + amount + ", description=" + description + ", postDate="
				+ postDate + ", userLoginName=" + userLoginName + ", accountNumber=" + accountNumber
				+ ", transactionDate=" + transactionDate + ", baseType=" + baseType + "]";
	}
}
