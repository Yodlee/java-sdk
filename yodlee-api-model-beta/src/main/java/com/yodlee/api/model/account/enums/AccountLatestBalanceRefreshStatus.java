/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account.enums;

public enum AccountLatestBalanceRefreshStatus {
	
	
	/*
	 * The consumer's account balance refresh is successful
	 */
	SUCCESS, //
	/*
	 * The IN_PROGRESS status is returned when the account refresh process is not completed within a period of 30
	 * seconds (configurable).
	 */
	IN_PROGRESS, //
	/*
	 * The consumer's account balance refresh has failed.
	 */
	FAILED;
}
