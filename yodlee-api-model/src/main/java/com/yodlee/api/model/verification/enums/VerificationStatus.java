/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 * 
 */
package com.yodlee.api.model.verification.enums;

public enum VerificationStatus {
	/**
	 * <b>Description: </b>The account verification process is initiated
	 */
	INITIATED,//
	/**
	 * <b>Description: </b>The micro-deposits and debits for the CDV process are posted to the consumer's account
	 */
	DEPOSITED,//
	/**
	 * <b>Description: </b>The consumer's account verification is successful
	 */
	SUCCESS,//
	/**
	 * <b>Description: </b>Due to technical issues Yodlee could not post the micro-transactions in the user's account
	 */
	FAILED
}
