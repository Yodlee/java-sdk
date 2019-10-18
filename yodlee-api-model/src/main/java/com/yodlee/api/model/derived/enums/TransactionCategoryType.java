/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 * 
 */
package com.yodlee.api.model.derived.enums;

public enum TransactionCategoryType {
	/**
	 * The transaction category belongs to a transfer category type
	 */
	TRANSFER,//
	/**
	 * The transaction category belongs to deferred compensation type
	 */
	DEFERRED_COMPENSATION,//
	/**
	 * The transaction does not seem to be categorized
	 */
	UNCATEGORIZE,//
	/**
	 * The transaction category belongs to an income type
	 */
	INCOME,//
	/**
	 * The transaction category belongs to an expense type
	 */
	EXPENSE
}
