/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account.enums;

public enum RewardBalanceType {
	/**
	 * Reward Balance that will be expired
	 */
	EXPIRING_BALANCE,//
	/**
	 * The balance required to reach a reward level
	 */
	BALANCE_TO_LEVEL,//
	/**
	 * The balance required to qualify for a reward
	 */
	BALANCE_TO_REWARD,//
	/**
	 * Reward Balance
	 */
	BALANCE,//
	/**
	 * Total reward balance available
	 */
	TOTAL_BALANCE
}
