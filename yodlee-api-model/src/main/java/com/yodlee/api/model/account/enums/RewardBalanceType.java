/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 * 
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
