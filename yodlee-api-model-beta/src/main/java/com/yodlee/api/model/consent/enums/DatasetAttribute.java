/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.consent.enums;

public enum DatasetAttribute {
	/**
	 * Indicates account profile, full account number.<br>
	 */
	ACCT_PROFILE_FULL_ACCT_NUMBER("ACCT_PROFILE.FULL_ACCT_NUMBER"),//
	/**
	 * Indicates account profile, bank transfer code.<br>
	 */
	ACCT_PROFILE_BANK_TRANSFER_CODE("ACCT_PROFILE.BANK_TRANSFER_CODE"),//
	/**
	 * Indicates account profile, holder name.<br>
	 */
	ACCT_PROFILE_HOLDER_NAME("ACCT_PROFILE.HOLDER_NAME"),//
	/**
	 * Indicates account profile, holder details.<br>
	 */
	ACCT_PROFILE_HOLDER_DETAILS("ACCT_PROFILE.HOLDER_DETAILS"),//
	/**
	 * Indicates basic aggregation data, account details .<br>
	 */
	BASIC_AGG_DATA_ACCOUNT_DETAILS("BASIC_AGG_DATA.ACCOUNT_DETAILS"),//
	/**
	 * Indicates basic aggregation data, statements.<br>
	 */
	BASIC_AGG_DATA_STATEMENTS("BASIC_AGG_DATA.STATEMENTS"),//
	/**
	 * Indicates basic aggregation data, transactions.<br>
	 */
	BASIC_AGG_DATA_TRANSACTIONS("BASIC_AGG_DATA.TRANSACTIONS"),//
	/**
	 * Indicates basic aggregation data, basic account info.<br>
	 */
	BASIC_AGG_DATA_BASIC_ACCOUNT_INFO("BASIC_AGG_DATA.BASIC_ACCOUNT_INFO");//

	public final String label;

	private DatasetAttribute(String label) {
		this.label = label;
	}
}
