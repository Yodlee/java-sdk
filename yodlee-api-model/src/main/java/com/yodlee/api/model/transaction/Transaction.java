/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"accountId", "merchant", "status", "CONTAINER", "isManual", "postDate", "categoryType",
		"categoryId", "type", "date", "runningBalance", "id", "amount", "category", "baseType", "highLevelCategoryId",
		"subType", "description", "categorySource", "memo", "cusipNumber", "holdingDescription", "interest", "price",
		"principal", "quantity", "settleDate", "symbol", "transactionDate", "parentCategoryId", "detailCategoryId",
		"checkNumber", "commission", "frequency", "isRecurring","intermediary","isPhysical", "merchantType","sourceType", "createdDate", "lastUpdated"})
public class Transaction extends AbstractTransaction {

	@Override
	public String toString() {
		return "Transaction [accountId=" + accountId + ", merchant=" + merchant + ", status=" + status + ", container="
				+ container + ", isManual=" + isManual + ", postDate=" + postDate + ", categoryType=" + categoryType
				+ ", categoryId=" + categoryId + ", type=" + type + ", date=" + date + ", runningBalance="
				+ runningBalance + ", id=" + id + ", amount=" + amount + ", category=" + category + ", baseType="
				+ baseType + ", highLevelCategoryId=" + highLevelCategoryId + ", subType=" + subType + ", description="
				+ description + ", categorySource=" + categorySource + ", memo=" + memo + ", cusipNumber=" + cusipNumber
				+ ", holdingDescription=" + holdingDescription + ", interest=" + interest + ", price=" + price
				+ ", principal=" + principal + ", quantity=" + quantity + ", settleDate=" + settleDate + ", symbol="
				+ symbol + ", transactionDate=" + transactionDate + ", parentCategoryId=" + parentCategoryId
				+ ", detailCategoryId=" + detailCategoryId + ", checkNumber=" + checkNumber + ", commission="
				+ commission + ", sourceType=" + sourceType + ", createdDate=" + createdDate + ", lastUpdated="
				+ lastUpdated + "]";
	}
}
