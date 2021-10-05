/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
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
	 * Data retrieval has failed
	 * 
	 */
	FAILED,//
	/**
	 * Indicates that the migration of the provider account to the open banking provider is in progress.
	 */
	MIGRATION_IN_PROGRESS
}
