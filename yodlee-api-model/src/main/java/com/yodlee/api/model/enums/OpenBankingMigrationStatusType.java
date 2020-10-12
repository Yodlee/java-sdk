/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.enums;


public enum OpenBankingMigrationStatusType {
	/**
	 * Migration to the Open Banking provider is in progress.
	 */
	IN_PROGRESS,
	/**
	 * Eligible and yet to be migrated to the Open Banking provider.
	 */
	TO_BE_MIGRATED,
	/**
	 * Successfully migrated to the Open Banking provider.
	 */
	COMPLETED
}
