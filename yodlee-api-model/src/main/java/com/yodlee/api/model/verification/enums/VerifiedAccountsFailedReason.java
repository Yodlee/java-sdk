/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.verification.enums;

public enum VerifiedAccountsFailedReason {
	
	/**
	 * <b>Description: </b>Required data is not available.<br>
	 */
	REQUIRED_DATA_NOT_AVAILABLE,

	/**
	 * <b>Description: </b>Matching failed.<br>
	 */
	MATCHING_FAILED,
	
	/**
	 * <b>Description: </b>No eligible accounts for given configuration.<br>
	 */
	NO_ELIGIBLE_ACCOUNTS;
}
