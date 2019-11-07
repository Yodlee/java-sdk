/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.dataextracts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.transaction.AbstractTransaction;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"accountId", "merchant", "status", "CONTAINER", "isManual", "postDate", "categoryType",
		"categoryId", "type", "date", "runningBalance", "id", "amount", "category", "baseType", "highLevelCategoryId",
		"subType", "description", "categorySource", "memo", "cusipNumber", "holdingDescription", "interest", "price",
		"principal", "quantity", "settleDate", "symbol", "transactionDate", "parentCategoryId", "detailCategoryId",
		"checkNumber", "commission", "frequency", "isRecurring", "sourceType", "createdDate", "lastUpdated"})
public class DataExtractsTransaction extends AbstractTransaction {

	@ApiModelProperty(readOnly = true,
					  value = "Indicates if the transaction is marked as deleted."//
							  + "<b>Applicable containers</b>: All Containers<br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("isDeleted")
	protected Boolean isDeleted;

	/**
	 * Indicates if the transaction is marked as deleted. <b>Applicable containers</b>: All Containers<br>
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

	@Override
	public String toString() {
		return "DataExtractsTransaction [isDeleted=" + isDeleted + ", accountId=" + accountId + ", merchant=" + merchant
				+ ", status=" + status + ", container=" + container + ", isManual=" + isManual + ", postDate="
				+ postDate + ", categoryType=" + categoryType + ", categoryId=" + categoryId + ", type=" + type
				+ ", date=" + date + ", runningBalance=" + runningBalance + ", id=" + id + ", amount=" + amount
				+ ", category=" + category + ", baseType=" + baseType + ", highLevelCategoryId=" + highLevelCategoryId
				+ ", subType=" + subType + ", description=" + description + ", categorySource=" + categorySource
				+ ", memo=" + memo + ", cusipNumber=" + cusipNumber + ", holdingDescription=" + holdingDescription
				+ ", interest=" + interest + ", price=" + price + ", principal=" + principal + ", quantity=" + quantity
				+ ", settleDate=" + settleDate + ", symbol=" + symbol + ", transactionDate=" + transactionDate
				+ ", parentCategoryId=" + parentCategoryId + ", detailCategoryId=" + detailCategoryId + ", checkNumber="
				+ checkNumber + ", commission=" + commission + ", sourceType=" + sourceType + ", createdDate="
				+ createdDate + ", lastUpdated=" + lastUpdated + "]";
	}
}
