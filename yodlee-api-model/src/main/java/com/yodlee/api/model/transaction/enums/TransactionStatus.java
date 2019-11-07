/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.transaction.enums;

public enum TransactionStatus {
	/**
	 * Denotes that the transaction is realized on the account's balance
	 */
	POSTED,//
	/**
	 * Denotes that the transaction is not yet realized on the account's balance
	 */
	PENDING,//
	/**
	 * Denotes that the transacation is a future dated transaction
	 */
	SCHEDULED,
	/**
	 * Denotes the failed transactions. It is only applicable to rejected claims in a Flexible Spending account
	 */
	FAILED
}
