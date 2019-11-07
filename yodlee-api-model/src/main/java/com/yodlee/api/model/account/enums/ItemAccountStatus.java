/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account.enums;

import java.util.EnumSet;
import java.util.Set;

public enum ItemAccountStatus {
	/**
	 * Active accounts
	 */
	ACTIVE,
	//
	//
	/**
	 * Accounts that are made inactive by the users
	 */
	//
	//
	INACTIVE,
	//
	//
	/**
	 * Active accounts
	 */
	TO_BE_CLOSED,
	//
	//
	/**
	 * Accounts that are found to be closed in the provider site and awaiting confirmation from users to get closed
	 */
	CLOSED,
	//
	//
	/**
	 * This status is applicable only in case of GET dataExtracts/userData
	 */
	DELETED;

	public static Set<ItemAccountStatus> getStatementApplicableStatusTypes() {
		return EnumSet.of(ACTIVE, TO_BE_CLOSED, CLOSED);
	}

	public static Set<ItemAccountStatus> getAccountApplicableStatusTypes() {
		return EnumSet.of(ACTIVE, INACTIVE, TO_BE_CLOSED, CLOSED);
	}

	public static Set<ItemAccountStatus> getUpdateAccountApplicableStatusTypes() {
		return EnumSet.of(ACTIVE, INACTIVE, CLOSED);
	}
}
