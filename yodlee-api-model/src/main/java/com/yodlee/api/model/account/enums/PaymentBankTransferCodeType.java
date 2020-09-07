/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account.enums;

/**
 * enum for BankTransferCodes
 *
 */
public enum PaymentBankTransferCodeType {
	ROUTING_NUMBER(1),//
	BSB(2),
	IFSC(4),
	SORT_CODE(5);

	private int id;

	private PaymentBankTransferCodeType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
