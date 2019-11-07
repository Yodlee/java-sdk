/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;
import com.yodlee.api.model.enums.BaseType;
import com.yodlee.api.model.enums.Container;
import com.yodlee.api.model.transaction.enums.MeerkatTxnSubType;
import com.yodlee.api.model.transaction.enums.SourceType;
import com.yodlee.api.model.transaction.enums.TransactionCategorySource;
import com.yodlee.api.model.transaction.enums.TransactionCategoryType;
import com.yodlee.api.model.transaction.enums.TransactionStatus;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractTransaction extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "The account from which the transaction was made. This is basically the primary key of the account resource. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("accountId")
	protected Long accountId;

	@ApiModelProperty(readOnly = true,
					  value = "The name of the merchant associated with the transaction."
							  + "<br><b>Note</b>: The merchant name field is available only in the United States, Canada, United Kingdom, and India."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("merchant")
	protected Merchant merchant;

	@ApiModelProperty(readOnly = true,
					  value = "The status of the transaction: pending or posted."
							  + "<br><b>Note</b>: Most FI sites only display posted transactions. If the FI site displays transaction status, same will be aggregated.  "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("status")
	protected TransactionStatus status;

	@ApiModelProperty(readOnly = true,
					  value = "The account's container."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("CONTAINER")
	protected Container container;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates if the transaction is aggregated from the FI site or the consumer has manually created the transaction using the application or an API. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("isManual")
	protected Boolean isManual;

	@ApiModelProperty(readOnly = true,
					  value = "The date on which the transaction is posted to the account."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,insurance,loan<br>"//
	)
	@JsonProperty("postDate")
	protected String postDate;

	@ApiModelProperty(readOnly = true,
					  value = "The categoryType of the category assigned to the transaction. This is the type field of the transaction category resource. The supported values are provided by the GET transactions/categories."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("categoryType")
	protected TransactionCategoryType categoryType;

	@ApiModelProperty(readOnly = true,
					  value = "The id of the category assigned to the transaction. This is the id field of the transaction category resource. The supported values are provided by the GET transactions/categories."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("categoryId")
	protected Long categoryId;

	@ApiModelProperty(readOnly = true,
					  value = "The nature of the transaction, i.e., deposit, refund, payment, etc."
							  + "<br><b>Note</b>: The transaction type field is available only for the United States, Canada, United Kingdom, and India based provider sites. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment<br>"//
	)
	@JsonProperty("type")
	protected String type;

	@ApiModelProperty(readOnly = true,
					  value = "The value provided will be either postDate or transactionDate. postDate takes higher priority than transactionDate, except for the investment container as only transactionDate is available. The availability of postDate or transactionDate depends on the provider site."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("date")
	protected String date;

	@ApiModelProperty(readOnly = true,
					  value = "The running balance in an account indicates the balance of the account after every transaction."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment<br>"//
	)
	@JsonProperty("runningBalance")
	protected Money runningBalance;

	@ApiModelProperty(readOnly = true,
					  value = "An unique identifier for the transaction. The combination of the id and account container are unique in the system. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("id")
	protected Long id;

	@ApiModelProperty(readOnly = true,
					  value = "The amount of the transaction as it appears at the FI site. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("amount")
	protected Money amount;

	@ApiModelProperty(readOnly = true,
					  value = "The name of the category assigned to the transaction. This is the category field of the transaction category resource. The supported values are provided by the GET transactions/categories."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("category")
	protected String category;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates if the transaction appears as a debit or a credit transaction in the account. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("baseType")
	protected BaseType baseType;

	@ApiModelProperty(readOnly = true,
					  value = "The high level category assigned to the transaction. The supported values are provided by the GET transactions/categories. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("highLevelCategoryId")
	protected Long highLevelCategoryId;

	@ApiModelProperty(readOnly = true,
					  value = "The transaction subtype field provides a detailed transaction type. For example, purchase is a transaction type and the transaction subtype field indicates if the purchase was made using a debit or credit card."
							  + "<br><b>Note</b>: The transaction subtype field is available only in the United States, Canada, United Kingdom, and India."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("subType")
	protected MeerkatTxnSubType subType;

	@ApiModelProperty(readOnly = true,
					  value = "Description details"//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("description")
	protected Description description;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the source of the category, i.e., categories derived by the system or assigned/provided by the consumer. This is the source field of the transaction category resource. The supported values are provided by the GET transactions/categories."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("categorySource")
	protected TransactionCategorySource categorySource;

	@ApiModelProperty(readOnly = true,
					  value = "Additional notes provided by the user for a particular  transaction through application or API services. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("memo")
	protected String memo;

	//
	@ApiModelProperty(readOnly = true,
					  value = "The CUSIP (Committee on Uniform Securities Identification Procedures) identifies the financial instruments in the United States and Canada."
							  + "<br><b><br><b>Note</b></b>: The CUSIP number field applies only to trade related transactions."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("cusipNumber")
	protected String cusipNumber;

	@ApiModelProperty(readOnly = true,
					  value = "For transactions involving securities, this captures the securities description."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("holdingDescription")
	protected String holdingDescription;

	@ApiModelProperty(readOnly = true,
					  value = "The portion of interest in the transaction amount. The transaction amount can be the amount due, payment amount, minimum amount, repayment, etc."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
	)
	@JsonProperty("interest")
	protected Money interest;

	@ApiModelProperty(readOnly = true,
					  value = "The price of the security for the transaction."
							  + "<br><b>Note</b>: The price field applies only to the trade related transactions. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("price")
	protected Money price;

	@ApiModelProperty(readOnly = true,
					  value = "The portion of the principal in the transaction amount. The transaction amount can be the amount due, payment amount, minimum amount, repayment, etc."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
	)
	@JsonProperty("principal")
	protected Money principal;

	@ApiModelProperty(readOnly = true,
					  value = "The quantity associated with the transaction."
							  + "<br><b>Note</b>: The quantity field applies only to trade-related transactions."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("quantity")
	protected Double quantity;

	@ApiModelProperty(readOnly = true,
					  value = "It is the date on which the transaction is finalized, that is, the date the ownership of the security is transferred to the buyer. The settlement date is usually few days after the transaction date."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("settleDate")
	protected String settleDate;

	@ApiModelProperty(readOnly = true,
					  value = "The symbol of the security being traded."
							  + "<br><b>Note</b>: The settle date field applies only to trade-related transactions. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("symbol")
	protected String symbol;

	@ApiModelProperty(readOnly = true,
					  value = "The date the transaction happens in the account. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("transactionDate")
	protected String transactionDate;

	@ApiModelProperty(readOnly = true,
					  value = "The parentCategoryId of the category assigned to the transaction."
							  + "<br><b>Note</b>: This field will be provided in the response if the transaction is assigned to a user-created category. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("parentCategoryId")
	protected Long parentCategoryId;

	@ApiModelProperty(readOnly = true,
					  value = "The id of the detail category that is assigned to the transaction. The supported values are provided by GET transactions/categories."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard<br>"//
	)
	@JsonProperty("detailCategoryId")
	protected Long detailCategoryId;

	@ApiModelProperty(readOnly = true,
					  value = "The checkNumber of the transaction."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank<br>"//
	)
	@JsonProperty("checkNumber")
	protected String checkNumber;

	@ApiModelProperty(readOnly = true,
					  value = "A commission or brokerage associated with a transaction." + "<br><br>"//
							  + "<br><b>Additional Details</b>:The commission only applies to trade-related transactions."//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("commission")
	protected Money commission;

	@ApiModelProperty(readOnly = true,
					  value = "The source through which the transaction is added to the Yodlee system."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loann<br>"//
							  + "<b>Applicable Values:</b><br>")
	@JsonProperty("sourceType")
	protected SourceType sourceType;

	@ApiModelProperty(readOnly = true, value = "")
	@JsonProperty("createdDate")
	protected String createdDate;

	@ApiModelProperty(readOnly = true, value = "")
	@JsonProperty("lastUpdated")
	protected String lastUpdated;

	/**
	 * Additional notes provided by the user for a particular transaction through application or API services. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * 
	 * @return memo
	 */
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * The name of the merchant associated with the transaction. <br>
	 * <b>Note</b>: The merchant name field is available only in the United States, Canada, United Kingdom, and India.
	 * <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * 
	 * @return merchant
	 */
	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	/**
	 * The status of the transaction: pending or posted. <br>
	 * <b>Note</b>: Most FI sites only display posted transactions. If the FI site displays transaction status, same
	 * will be aggregated. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return status
	 */
	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	/**
	 * The account's container. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return CONTAINER
	 */
	@JsonProperty("CONTAINER")
	public Container getContainer() {
		return container;
	}

	@JsonProperty("CONTAINER")
	public void setContainer(Container container) {
		this.container = container;
	}

	/**
	 * The date on which the transaction is posted to the account. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,insurance,loan<br>
	 * 
	 * @return postDate
	 */
	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	/**
	 * The categoryType of the category assigned to the transaction. This is the type field of the transaction category
	 * resource. The supported values are provided by the GET transactions/categories. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * 
	 * @return categoryType
	 */
	public TransactionCategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(TransactionCategoryType categoryType) {
		this.categoryType = categoryType;
	}

	/**
	 * The nature of the transaction, i.e., deposit, refund, payment, etc. <br>
	 * <b>Note</b>: The transaction type field is available only for the United States, Canada, United Kingdom, and
	 * India based provider sites. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment<br>
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * The value provided will be either postDate or transactionDate. postDate takes higher priority than
	 * transactionDate, except for the investment container as only transactionDate is available. The availability of
	 * postDate or transactionDate depends on the provider site. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * 
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * The running balance in an account indicates the balance of the account after every transaction. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment<br>
	 * 
	 * @return runningBalance
	 */
	public Money getRunningBalance() {
		return runningBalance;
	}

	public void setRunningBalance(Money runningBalance) {
		this.runningBalance = runningBalance;
	}

	/**
	 * The amount of the transaction as it appears at the FI site. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * 
	 * @return amount
	 */
	public Money getAmount() {
		return amount;
	}

	public void setAmount(Money amount) {
		this.amount = amount;
	}

	/**
	 * The name of the category assigned to the transaction. This is the category field of the transaction category
	 * resource. The supported values are provided by the GET transactions/categories. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * 
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Indicates if the transaction appears as a debit or a credit transaction in the account. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return baseType
	 */
	public BaseType getBaseType() {
		return baseType;
	}

	public void setBaseType(BaseType baseType) {
		this.baseType = baseType;
	}

	/**
	 * The transaction subtype field provides a detailed transaction type. For example, purchase is a transaction type
	 * and the transaction subtype field indicates if the purchase was made using a debit or credit card. <br>
	 * <b>Note</b>: The transaction subtype field is available only in the United States, Canada, United Kingdom, and
	 * India. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * 
	 * @return subType
	 */
	public MeerkatTxnSubType getSubType() {
		return subType;
	}

	public void setSubType(MeerkatTxnSubType subType) {
		this.subType = subType;
	}

	/**
	 * Description details <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * 
	 * @return description
	 */
	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	/**
	 * Indicates the source of the category, i.e., categories derived by the system or assigned/provided by the
	 * consumer. This is the source field of the transaction category resource. The supported values are provided by the
	 * GET transactions/categories. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return categorySource
	 */
	public TransactionCategorySource getCategorySource() {
		return categorySource;
	}

	public void setCategorySource(TransactionCategorySource categorySource) {
		this.categorySource = categorySource;
	}

	/**
	 * The CUSIP (Committee on Uniform Securities Identification Procedures) identifies the financial instruments in the
	 * United States and Canada. <br>
	 * <b><br>
	 * Note</b>: The CUSIP number field applies only to trade related transactions. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return cusipNumber
	 */
	public String getCusipNumber() {
		return cusipNumber;
	}

	public void setCusipNumber(String cusipNumber) {
		this.cusipNumber = cusipNumber;
	}

	/**
	 * For transactions involving securities, this captures the securities description. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return holdingDescription
	 */
	public String getHoldingDescription() {
		return holdingDescription;
	}

	public void setHoldingDescription(String holdingDescription) {
		this.holdingDescription = holdingDescription;
	}

	/**
	 * It is the date on which the transaction is finalized, that is, the date the ownership of the security is
	 * transferred to the buyer. The settlement date is usually few days after the transaction date. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return settleDate
	 */
	public String getSettleDate() {
		return settleDate;
	}

	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}

	/**
	 * The symbol of the security being traded. <br>
	 * <b>Note</b>: The settle date field applies only to trade-related transactions. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * The date the transaction happens in the account. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * 
	 * @return transactionDate
	 */
	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * The checkNumber of the transaction. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank<br>
	 * 
	 * @return checkNumber
	 */
	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	/**
	 * The account from which the transaction was made. This is basically the primary key of the account resource. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * 
	 * @return accountId
	 */
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	/**
	 * Indicates if the transaction is aggregated from the FI site or the consumer has manually created the transaction
	 * using the application or an API. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * 
	 * @return isManual
	 */
	public Boolean getIsManual() {
		return isManual;
	}

	public void setIsManual(Boolean isManual) {
		this.isManual = isManual;
	}

	/**
	 * The id of the category assigned to the transaction. This is the id field of the transaction category resource.
	 * The supported values are provided by the GET transactions/categories. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * 
	 * @return categoryId
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * An unique identifier for the transaction. The combination of the id and account container are unique in the
	 * system. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * The high level category assigned to the transaction. The supported values are provided by the GET
	 * transactions/categories. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * 
	 * @return highLevelCategoryId
	 */
	public Long getHighLevelCategoryId() {
		return highLevelCategoryId;
	}

	public void setHighLevelCategoryId(Long highLevelCategoryId) {
		this.highLevelCategoryId = highLevelCategoryId;
	}

	/**
	 * The portion of interest in the transaction amount. The transaction amount can be the amount due, payment amount,
	 * minimum amount, repayment, etc. <br>
	 * <br>
	 * <b>Applicable containers</b>: loan<br>
	 * 
	 * @return interest
	 */
	public Money getInterest() {
		return interest;
	}

	public void setInterest(Money interest) {
		this.interest = interest;
	}

	/**
	 * The price of the security for the transaction. <br>
	 * <b>Note</b>: The price field applies only to the trade related transactions. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return price
	 */
	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

	/**
	 * The portion of the principal in the transaction amount. The transaction amount can be the amount due, payment
	 * amount, minimum amount, repayment, etc. <br>
	 * <br>
	 * <b>Applicable containers</b>: loan<br>
	 * 
	 * @return principal
	 */
	public Money getPrincipal() {
		return principal;
	}

	public void setPrincipal(Money principal) {
		this.principal = principal;
	}

	/**
	 * The quantity associated with the transaction. <br>
	 * <b>Note</b>: The quantity field applies only to trade-related transactions. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return quantity
	 */
	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	/**
	 * The parentCategoryId of the category assigned to the transaction. <br>
	 * <b>Note</b>: This field will be provided in the response if the transaction is assigned to a user-created
	 * category. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * 
	 * @return parentCategoryId
	 */
	public Long getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(Long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	/**
	 * The id of the detail category that is assigned to the transaction. The supported values are provided by GET
	 * transactions/categories. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard<br>
	 * 
	 * @return detailCategoryId
	 */
	public Long getDetailCategoryId() {
		return detailCategoryId;
	}

	public void setDetailCategoryId(Long detailCategoryId) {
		this.detailCategoryId = detailCategoryId;
	}

	/**
	 * A commission or brokerage associated with a transaction. * <br>
	 * <br>
	 * <br>
	 * <b>Additional Details</b>:The commission only applies to trade-related transactions. <b>Applicable
	 * containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * 
	 * @return commission
	 */
	public Money getCommission() {
		return commission;
	}

	public void setCommission(Money commission) {
		this.commission = commission;
	}

	/**
	 * The source through which the transaction is added to the Yodlee system. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loann<br>
	 * <b>Applicable Values:</b><br>
	 * 
	 * @return sourceType
	 */
	public SourceType getSourceType() {
		return sourceType;
	}

	public void setSourceType(SourceType sourceType) {
		this.sourceType = sourceType;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}
