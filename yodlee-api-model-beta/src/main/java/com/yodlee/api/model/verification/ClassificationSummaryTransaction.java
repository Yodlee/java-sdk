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
import com.yodlee.api.model.enums.BaseType;
import com.yodlee.api.model.transaction.Description;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"description", "amount", "date", "baseType", "merchant"})
public class ClassificationSummaryTransaction extends AbstractModelComponent {
	
	@ApiModelProperty(readOnly = true, value = "The description of the transaction")
	@JsonProperty("description")
	private Description description;

	@ApiModelProperty(readOnly = true, value = "The amount of the transaction as it appears at the provider site")
	@JsonProperty("amount")
	private Money amount;
	
	@ApiModelProperty(readOnly = true, value = "The date the transaction happens in the account")
	@JsonProperty("date")
	private String date;
	
	@ApiModelProperty(readOnly = true, value = "Indicates if the transaction appears as a debit or a credit transaction in the account")
	@JsonProperty("baseType")
	private BaseType baseType;
	
	@ApiModelProperty(readOnly = true, value = "The name of the merchant corresponding to the transaction")
	@JsonProperty("merchant")
	protected ClassificationSummaryMerchant merchant;
	
	/**
	 * The description of the transaction
	 * 
	 * @return description
	 */
	public Description getDescription() {
		return description;
	}
	
	/**
	 * The amount of the transaction as it appears at the provider site
	 * 
	 * @return amount
	 */
	public Money getAmount() {
		return amount;
	}
	
	/**
	 * The date the transaction happens in the account
	 * 
	 * @return date
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * Indicates if the transaction appears as a debit or a credit transaction in the account
	 * 
	 * @return baseType
	 */
	public BaseType getBaseType() {
		return baseType;
	}
	
	/**
	 * The name of the merchant corresponding to the transaction
	 * 
	 * @return merchant
	 */
	public ClassificationSummaryMerchant getMerchant() {
		return merchant;
	}
	
	@Override
	public String toString() {
		return "Transaction [amount=" + amount + ", date=" + date + ", baseType=" + baseType 
				+ ", description=" + description + ", merchant=" + merchant + "]";
	}
	
}
