/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account.enums;

public enum FrequencyType {
	/**
	 * Occurs every day
	 */
	DAILY,//
	/**
	 * Occurs once
	 */
	ONE_TIME,
	/**
	 * Occurs once in a week
	 */
	WEEKLY,
	/**
	 * Occurs once in two weeks
	 */
	EVERY_2_WEEKS,
	/**
	 * Occurs once in 15 days
	 */
	SEMI_MONTHLY,
	/**
	 * Occurs once in a month
	 */
	MONTHLY,
	/**
	 * Occurs once in three months
	 */
	QUARTERLY,
	/**
	 * Occurs once in six months
	 */
	SEMI_ANNUALLY,
	/**
	 * Occurs once in a year
	 */
	ANNUALLY,
	/**
	 * Occurs once in two months
	 */
	EVERY_2_MONTHS,
	EBILL,
	/**
	 * Occurs on first day of every month
	 */
	FIRST_DAY_MONTHLY,
	/**
	 * Occurs on last day of every month
	 */
	LAST_DAY_MONTHLY,
	/**
	 * Occurs once in four weeks
	 */
	EVERY_4_WEEKS,
	UNKNOWN,
	OTHER
}
