/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 * 
 */
package com.yodlee.api.model.account.enums;

public enum CoverageType {
	// Health Insurance
	/**
	 * A type of coverage under health insurance that covers some or all costs of routine vision care
	 */
	VISION,
	/**
	 * A type of coverage under health insurance that covers some or all costs of routine dental care
	 */
	DENTAL,
	MEDICAL,
	/**
	 * A type of coverage under health insurance that covers some or all costs of health care
	 */
	HEALTH,
	// Life Insurance
	/**
	 * A type of coverage that applies only to superannuation fund and life insurance and provides death benefits as
	 * part of the coverage
	 */
	DEATH_COVER,
	/**
	 * A type of coverage that applies only to superannuation fund and life insurance accounts and provides disability
	 * benefits as part of the coverage
	 */
	TOTAL_PERMANENT_DISABILITY,
	/**
	 * A type of coverage that applies only to life insurance accounts and provides accidental death benefits as part of
	 * the coverage
	 */
	ACCIDENTAL_DEATH_COVER,
	// SuperAnnuation (Investment) includes DEATH_COVER
	/**
	 * A type of coverage that is provided to the owner of the superannuation fund. The income protection cover is
	 * available up to a percentage of the monthly income to provide an affordable-level of financial protection in the
	 * event of sickness or injury
	 */
	INCOME_PROTECTION,
	/**
	 * A type of coverage provided as part of the superannuation fund. This coverage includes the benefits of both
	 * disability and death
	 */
	DEATH_TOTAL_PERMANENT_DISABILITY,
	OTHER
}
