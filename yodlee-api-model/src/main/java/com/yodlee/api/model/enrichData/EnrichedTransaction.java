/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.enrichData;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.account.BusinessCategory;
import com.yodlee.api.model.account.enums.AccountClassification;
import com.yodlee.api.model.transaction.enums.MeerkatTxnSubType;
import com.yodlee.api.model.transaction.enums.MerchantType;
import com.yodlee.api.model.transaction.enums.TransactionType;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrichedTransaction extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "An unique identifier for the transaction. The combination of the id and account container are unique in the system. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("transactionId")
	protected Long transactionId;

	@ApiModelProperty(readOnly = true,
					  value = "The nature of the transaction, i.e., deposit, refund, payment, etc."
							  + "<br><b>Note</b>: The transaction type field is available only for the United States, Canada, United Kingdom, and India based provider sites. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard<br>"//
	)
	@JsonProperty("type")
	protected TransactionType type;

	@ApiModelProperty(readOnly = true,
					  value = "The transaction subtype field provides a detailed transaction type. For example, purchase is a transaction type and the transaction subtype field indicates if the purchase was made using a debit or credit card."
							  + "<br><b>Note</b>: The transaction subtype field is available only in the United States, Canada, United Kingdom, and India."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
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
							  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("merchantState")
	protected String merchantState;

	@ApiModelProperty(readOnly = true,
					  value = "City of the merchant."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("merchantCity")
	protected String merchantCity;

	@ApiModelProperty(readOnly = true,
					  value = "Country of the merchant."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("merchantCountry")
	protected String merchantCountry;

	@ApiModelProperty(readOnly = true,
					  value = "The name of the merchant."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("merchantName")
	private String merchantName;

	@ApiModelProperty(readOnly = true,
					  value = "The account's container."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("container")
	protected EnrichDataContainer container;

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
							  + "<b>Applicable containers</b>: creditCard, loan<br>"//
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
							  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("categoryId")
	protected Long categoryId;

	@ApiModelProperty(readOnly = true,
					  value = "The high level category assigned to the transaction. The supported values are provided by the GET transactions/categories. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("highLevelCategoryId")
	protected Long highLevelCategoryId;
	
	@ApiModelProperty(readOnly = true,
			  value = "Indicates if the transaction is happened online or in-store. "//
					  + "<br><br>"//
					  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
			)
	@JsonProperty("isPhysical")
	protected Boolean isPhysical;
	
	@ApiModelProperty(readOnly = true,
			  value = "Indicates if the transaction is recurring or not. "//
					  + "<br><br>"//
					  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
			)
	@JsonProperty("isRecurring")
	protected Boolean isRecurring;
	
	@ApiModelProperty(readOnly = true,
			  value = "The business categories of the merchant."//
					  + "<br><br>"//
					  + "<b>Applicable containers</b>: bank,creditCard<br>"//
					  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("categoryLabel")
	private List<String> categoryLabel;
	
	@ApiModelProperty(readOnly = true,
			  value = "The classification of the account such as personal, corporate, etc.<br><br>"//
					  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
					  + "<b>Applicable containers</b>: bank, creditCard, loan<br>"//
	)
	@JsonProperty("classification")
	protected AccountClassification classification;
	
	@ApiModelProperty(readOnly = true,
			  value = "The business categories of the merchant."//
					  + "<br><br>"//
					  + "<b>Applicable containers</b>: bank,creditCard<br>"//
					  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("businessCategory")
	private BusinessCategory businessCategory;
	
	@ApiModelProperty(readOnly = true,
	  		  value = "The intermediaries of the transaction."//
			  + "<br><br>"//
			  + "<b>Applicable containers</b>:  bank,creditCard,loan<br>"//
	)
	@JsonProperty("intermediaries")
	protected List<String> intermediaries;
	
	@ApiModelProperty(readOnly = true,
			  value = "Indicates the merchantType of the transaction.e.g:-BILLERS,SUBSCRIPTION,OTHERS "//
					  + "<br><br>"//
					  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
			)
	@JsonProperty("merchantType")
	protected MerchantType merchantType;
	
	@ApiModelProperty(readOnly = true,
			  value = "The name of the category assigned to the transaction. This is the category field of the transaction category resource. The supported values are provided by the GET transactions/categories."//
					  + "<br><br>"//
					  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("category")
	protected String category;
	
	@ApiModelProperty(readOnly = true,
			  value = "The logo of the merchant."//
					  + "<br><br>"//
					  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("merchantLogoURL")
	protected String merchantLogoURL;
	
	@ApiModelProperty(readOnly = true,
			  value = "sourceMerchantId of the merchant."//
					  + "<br><br>"//
					  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("sourceMerchantId")
	protected String sourceMerchantId;
	
	@ApiModelProperty(readOnly = true,
			  value = "merchantWebsite of the merchant."//
					  + "<br><br>"//
					  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("merchantWebsite")
	protected String merchantWebsite;
	
	@ApiModelProperty(readOnly = true,
			  value = "PhoneNumber of the merchant."//
					  + "<br><br>"//
					  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("merchantPhoneNumber")
	protected String merchantPhoneNumber;
	
	@ApiModelProperty(readOnly = true,
			  value = "Email of the merchant."//
					  + "<br><br>"//
					  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("merchantEmail")
	protected String merchantEmail;
	
	@ApiModelProperty(readOnly = true,
			  value = "Longitude of the merchant."//
					  + "<br><br>"//
					  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("merchantLongitude")
	protected String merchantLongitude;
	
	@ApiModelProperty(readOnly = true,
			  value = "Latitude of the merchant."//
					  + "<br><br>"//
					  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("merchantLatitude")
	protected String merchantLatitude;
	
	@ApiModelProperty(readOnly = true,
			  value = "Address1 of the merchant."//
					  + "<br><br>"//
					  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("merchantAddress1")
	protected String merchantAddress1;
	
	@ApiModelProperty(readOnly = true,
			  value = "Zip code of the merchant."//
					  + "<br><br>"//
					  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("merchantZip")
	protected String merchantZip;
	
	@ApiModelProperty(readOnly = true,
			  value = "Frequency is set to MONTHLY if the merchantType is BILLERS."//
					  + "<br><br>"//
					  + "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("frequency")
	protected String frequency;

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

	public EnrichDataContainer getContainer() {
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

	public Boolean getIsPhysical() {
		return isPhysical;
	}

	public Boolean getIsRecurring() {
		return isRecurring;
	}

	public List<String> getCategoryLabel() {
		return categoryLabel;
	}

	public AccountClassification getClassification() {
		return classification;
	}

	public String getFrequency() {
		return frequency;
	}

	public BusinessCategory getBusinessCategory() {
		return businessCategory;
	}

	public List<String> getIntermediaries() {
		return intermediaries;
	}

	public MerchantType getMerchantType() {
		return merchantType;
	}

	public String getCategory() {
		return category;
	}

	public String getMerchantLogoURL() {
		return merchantLogoURL;
	}

	public String getSourceMerchantId() {
		return sourceMerchantId;
	}

	public String getMerchantWebsite() {
		return merchantWebsite;
	}

	public String getMerchantPhoneNumber() {
		return merchantPhoneNumber;
	}

	public String getMerchantEmail() {
		return merchantEmail;
	}

	public String getMerchantLongitude() {
		return merchantLongitude;
	}

	public String getMerchantLatitude() {
		return merchantLatitude;
	}

	public String getMerchantAddress1() {
		return merchantAddress1;
	}

	public String getMerchantZip() {
		return merchantZip;
	}

	@Override
	public String toString() {
		return "EnrichedTransaction [transactionId=" + transactionId + ", type=" + type + ", subType=" + subType
				+ ", merchantId=" + merchantId + ", merchantState=" + merchantState + ", merchantCity=" + merchantCity
				+ ", merchantCountry=" + merchantCountry + ", merchantName=" + merchantName + ", container=" + container
				+ ", sourceId=" + sourceId + ", simpleDescription=" + simpleDescription + ", detailCategoryId="
				+ detailCategoryId + ", categoryId=" + categoryId + ", highLevelCategoryId=" + highLevelCategoryId
				+ ", isPhysical=" + isPhysical + ", isRecurring=" + isRecurring + ", categoryLabel=" + categoryLabel
				+ ", classification=" + classification + ", businessCategory=" + businessCategory + ", intermediaries="
				+ intermediaries + ", merchantType=" + merchantType + ", category=" + category + ", merchantLogoURL="
				+ merchantLogoURL + ", sourceMerchantId=" + sourceMerchantId + ", merchantWebsite=" + merchantWebsite
				+ ", merchantPhoneNumber=" + merchantPhoneNumber + ", merchantEmail=" + merchantEmail
				+ ", merchantLongitude=" + merchantLongitude + ", merchantLatitude=" + merchantLatitude
				+ ", merchantAddress1=" + merchantAddress1 + ", merchantZip=" + merchantZip + ", frequency=" + frequency
				+ "]";
	}
}
