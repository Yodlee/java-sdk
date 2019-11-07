/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.derived.enums;

public enum BalanceDataSourceType {
	/**
	 * Scraped balance from the provider site
	 */
	S,//
	/**
	 * Calculated balance by the system
	 */
	C,//
	/**
	 * Last available balance that was carry forwarded for the days when account was not updated
	 */
	CF
}
