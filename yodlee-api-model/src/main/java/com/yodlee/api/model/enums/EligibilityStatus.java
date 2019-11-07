/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.enums;

public enum EligibilityStatus {
	/**
	 * This status indicates that the account is eligible for next update
	 */
	ALLOW_UPDATE, //
	/**
	 * The status indicates to update or refresh the account by directing the user to edit the provided credentials
	 */
	ALLOW_UPDATE_WITH_CREDENTIALS, //
	/**
	 * The status indicates the account is not eligible for the update or refresh process due to a site issue or a
	 * technical error
	 */
	DISALLOW_UPDATE
}
