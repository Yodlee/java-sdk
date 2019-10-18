/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 * 
 */
package com.yodlee.api.model.account.enums;

public enum CoverageAmountType {
	/**
	 * The amount paid for covered health care services before the health insurance plan starts paying
	 */
	DEDUCTIBLE,//
	/**
	 * The maximum amount the insurer has to pay for covered health care services in a plan year
	 */
	OUT_OF_POCKET,
	/**
	 * A cap on the benefits the insurance company will pay in a year while the insurer is enrolled in a particular
	 * health insurance plan
	 */
	ANNUAL_BENEFIT,
	/**
	 * The maximum amount the insurance company pays for nonessential healthcare services
	 */
	MAX_BENEFIT,
	/**
	 * The maximum amount payable in the event of a claim by the policyholder
	 */
	COVERAGE_AMOUNT,
	/**
	 * As part of the income protection cover, the monthly amount provided as financial support in the event of sickness
	 * or injury
	 */
	MONTHLY_BENEFIT,
	/**
	 * Any coverage type other than what has been listed here
	 */
	OTHER,
}
