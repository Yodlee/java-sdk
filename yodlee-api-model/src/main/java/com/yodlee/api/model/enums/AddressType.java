/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.enums;

public enum AddressType {
	HOME(2),//
	BUSINESS(3),//
	POBOX(4),//
	RETAIL(5),//
	OFFICE(6),//
	SMALL_BUSINESS(7),//
	COMMUNICATION(8),//
	PERMANENT(9),//
	STATEMENT_ADDRESS(10),//
	PAYMENT(11),//
	PAYOFF(12),//
	UNKNOWN(1);//

	private int id;

	private AddressType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
