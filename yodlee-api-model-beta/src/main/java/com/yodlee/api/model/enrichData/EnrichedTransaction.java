/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.enrichData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.enums.Container;
import com.yodlee.api.model.transaction.enums.MeerkatTxnSubType;
import com.yodlee.api.model.transaction.enums.TransactionType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrichedTransaction extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "An unique identifier for the transaction. The combination of the id and account container are unique in the system. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("transactionId")
	protected Long transactionId;

	@ApiModelProperty(readOnly = true,
					  value = "The nature of the transaction, i.e., deposit, refund, payment, etc."
							  + "<br><b>Note</b>: The transaction type field is available only for the United States, Canada, United Kingdom, and India based provider sites. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment<br>"//
	)
	@JsonProperty("type")
	protected TransactionType type;

	@ApiModelProperty(readOnly = true,
					  value = "The transaction subtype field provides a detailed transaction type. For example, purchase is a transaction type and the transaction subtype field indicates if the purchase was made using a debit or credit card."
							  + "<br><b>Note</b>: The transaction subtype field is available only in the United States, Canada, United Kingdom, and India."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("subType")
	protected MeerkatTxnSubType subType;

	@ApiModelProperty(readOnly = true,
					  value = "Identifier of the merchant."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard<br>"//
	)
	@JsonProperty("merchantId")
	private String merchantId;

	@ApiModelProperty(readOnly = true,
					  value = "State of the merchant."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("merchantState")
	protected String merchantState;

	@ApiModelProperty(readOnly = true,
					  value = "City of the merchant."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("merchantCity")
	protected String merchantCity;

	@ApiModelProperty(readOnly = true,
					  value = "Country of the merchant."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("merchantCountry")
	protected String merchantCountry;

	@ApiModelProperty(readOnly = true,
					  value = "The name of the merchant."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("merchantName")
	private String merchantName;

	@ApiModelProperty(readOnly = true,
					  value = "The account's container."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("container")
	protected Container container;

	@ApiModelProperty(readOnly = true,
					  value = "A unique ID that the provider site has assigned to the transaction. The source ID is only available for the pre-populated accounts."//
							  + "<br>Pre-populated accounts are the accounts that the FI customers shares with Yodlee, so that the user does not have to add or aggregate those accounts."//
	)
	@JsonProperty("sourceId")
	protected String sourceId;

	@ApiModelProperty(readOnly = true,
					  value = "The transaction description that appears at the FI site may not be self-explanatory, i.e., the source, purpose of the transaction may not be evident. Yodlee attempts to simplify and make the transaction meaningful to the consumer, and this simplified transaction description is provided in the simple description field."
							  + "Note: The simple description field is available only in the United States, Canada, United Kingdom, and India."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bill, creditCard, insurance, loan<br>"//
	)
	@JsonProperty("simpleDescription")
	private String simpleDescription;

	@ApiModelProperty(readOnly = true,
					  value = "The id of the detail category that is assigned to the transaction. The supported values are provided by GET transactions/categories."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard<br>"//
	)
	@JsonProperty("detailCategoryId")
	protected Long detailCategoryId;

	@ApiModelProperty(readOnly = true,
					  value = "The id of the category assigned to the transaction. This is the id field of the transaction category resource. The supported values are provided by the GET transactions/categories."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("categoryId")
	protected Long categoryId;

	@ApiModelProperty(readOnly = true,
					  value = "The high level category assigned to the transaction. The supported values are provided by the GET transactions/categories. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("highLevelCategoryId")
	protected Long highLevelCategoryId;

	public Long getTransactionId() {
		return transactionId;
	}

	public TransactionType getType() {
		return type;
	}

	public MeerkatTxnSubType getSubType() {
		return subType;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public String getMerchantState() {
		return merchantState;
	}

	public String getMerchantCity() {
		return merchantCity;
	}

	public String getMerchantCountry() {
		return merchantCountry;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public Container getContainer() {
		return container;
	}

	public String getSourceId() {
		return sourceId;
	}

	public String getSimpleDescription() {
		return simpleDescription;
	}

	public Long getDetailCategoryId() {
		return detailCategoryId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public Long getHighLevelCategoryId() {
		return highLevelCategoryId;
	}

	@Override
	public String toString() {
		return "EnrichedTransaction [transactionId=" + transactionId + ", type=" + type + ", subType=" + subType
				+ ", merchantId=" + merchantId + ", merchantState=" + merchantState + ", merchantCity=" + merchantCity
				+ ", merchantCountry=" + merchantCountry + ", merchantName=" + merchantName + ", container=" + container
				+ ", sourceId=" + sourceId + ", simpleDescription=" + simpleDescription + ", detailCategoryId="
				+ detailCategoryId + ", categoryId=" + categoryId + ", highLevelCategoryId=" + highLevelCategoryId
				+ "]";
	}
}
