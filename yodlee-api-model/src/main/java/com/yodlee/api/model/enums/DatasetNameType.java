/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.enums;

public enum DatasetNameType {
	/**
	 * Indicates basic aggregation data like accounts, transactions, etc
	 */
	BASIC_AGG_DATA,//
	/**
	 * Indicates advance aggregation data like interest details and payment details
	 */
	ADVANCE_AGG_DATA,//
	/**
	 * Indicates account profile datas like full account number, routing number, etc
	 */
	ACCT_PROFILE,//
	/**
	 * Indicates document data like bank statements, tax documents, etc
	 */
	DOCUMENT//
}
