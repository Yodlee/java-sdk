/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.account.enums;

public enum SourceAccountStatus {
	/**
	 * The borrower is currently repaying the student loan
	 */
	IN_REPAYMENT,
	/**
	 * The borrower has failed to repay the loan according to the terms of the promissory note
	 */
	DEFAULTED,
	/**
	 * Indicates the borrower is still in school
	 */
	IN_SCHOOL,
	/**
	 * The specified period (usually six months) between the date student graduates or drops below half time status and
	 * the date the loan repayment begins
	 * 
	 */
	IN_GRACE_PERIOD,
	/**
	 * The borrower has failed to make loan repayments when due. Delinquency begins with the first missed loan repayment
	 * 
	 */
	DELINQUENCY,
	/**
	 * A period when the student postpones the loan repayments
	 */
	DEFERMENT
}
