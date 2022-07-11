/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.transaction.enums;

public enum MeerkatTxnType {
	CHARGES_FEES(2),
	INTEREST(4),
	PURCHASE(5),
	PAYMENT(6),
	REFUND(7),
	TRANSFER(8),
	WITHDRAWAL(9),
	DEPOSIT(12),
	DEPOSITS_CREDITS(17);

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
