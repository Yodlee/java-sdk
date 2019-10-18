/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.transaction.enums;

public enum MeerkatTxnType {
	AUTHORIZATION(1),
	CHARGES_FEES(2),
	DEBIT(3),
	INTEREST(4),
	PURCHASE(5),
	PAYMENT(6),
	REFUND(7),
	TRANSFER(8),
	WITHDRAWAL(9),
	CREDIT(10),
	DEFERRED(11),
	DEPOSIT(12),
	VOID(13),
	POS_DEBIT(14),
	CASH_ADVANCE(15),
	BANK_ADJUSTMENT(16),
	DEPOSITS_CREDITS(17),
	OTHER_DEPOSITS(18),
	OTHER_WITHDRAWALS(19);

	private long id;

	private MeerkatTxnType(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public static boolean exists(String type) {
		try {
			if (type != null) {
				valueOf(type);
				return true;
			}
		} catch (IllegalArgumentException e) {
			return false;
		}
		return false;
	}
}
