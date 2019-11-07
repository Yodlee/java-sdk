/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.provideraccounts.enums;

public enum ProviderAccountStatus {
	/**
	 * Login to provider site is in progress
	 * 
	 */
	LOGIN_IN_PROGRESS,//
	/**
	 * Additional authentication information is needed from the user
	 * 
	 */
	USER_INPUT_REQUIRED,//
	/**
	 * Login is successful and data aggregation is in progress
	 * 
	 */
	IN_PROGRESS,//
	/**
	 * Data is partially retrieved
	 * 
	 */
	PARTIAL_SUCCESS,//
	/**
	 * Data is retrieved successfully
	 * 
	 */
	SUCCESS,//
	/**
	 * Additional authentication information is needed from the user
	 * 
	 */
	FAILED
}
