/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.verification.enums;

public enum VerificationFailureReasonType {
	//
	// *************************************************
	// MS Failure Reasons
	// *************************************************
	/**
	 * <b>Description: </b>The account holder's name related details are not available at the FI site
	 */
	DATA_NOT_AVAILABLE,//
	/**
	 * <b>Description: </b>The account verification process has failed due to account holder's data mismatch
	 */
	ACCOUNT_HOLDER_MISMATCH,//
	/**
	 * <b>Description: </b>The account verification process has failed as the full account number and bank transfer code
	 * are not available
	 * 
	 */
	FULL_ACCOUNT_NUMBER_AND_BANK_TRANSFER_CODE_NOT_AVAILABLE,//
	/**
	 * <b>Description: </b>The account verification process has failed as the full account number is not available
	 * 
	 */
	FULL_ACCOUNT_NUMBER_NOT_AVAILABLE,//
	/**
	 * <b>Description: </b>The account verification process has failed as the bank transfer code is not available
	 * 
	 */
	BANK_TRANSFER_CODE_NOT_AVAILABLE,//
	//
	// *************************************************
	// CDV Failure Reasons
	// *************************************************
	/**
	 * <b>Description: </b>The time limit to verify the micro-transaction details has expired
	 * 
	 */
	EXPIRED,//
	/**
	 * <b>Description: </b>The account verification process has failed due to data mismatch
	 * 
	 */
	DATA_MISMATCH,//
	/**
	 * <b>Description: </b>The consumer's account verification has failed
	 * 
	 */
	INSTRUCTION_GENERATION_ERROR
}
