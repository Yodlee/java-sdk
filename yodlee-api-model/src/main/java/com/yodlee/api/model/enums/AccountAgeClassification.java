/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.enums;

public enum AccountAgeClassification {
	
	/**
	 * <b>Description: </b>Indicates that the account was opened before one year from current date. <br>
	 * <b>Next Action: </b>
	 */
	UNCLASSIFIED,
	//
	//
	/**
	 * 
	 * <b>Description: </b>Indicates that the account is reasonably old and is at least greater than 6 months old. <br>
	 * <b>Next Action: </b>
	 */
	OLD, //
	//
	//
	/**
	 * <b>Description: </b>Indicates that the account is considerably new and is aged between 1 month and 6 months.<br>
	 * <b>Next Action: </b>
	 */
	NEW,
	//
	//
	/**
	 * 
	 * <b>Description: </b>Indicates that the account was opened very recently less than a month ago.<br>
	 * <b>Next Action: </b>
	 */
	RECENT
}
