/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 * 
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
