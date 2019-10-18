/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.account.enums;

public enum PaymentIdentifierType {
	REFERENCE_NUMBER(1),//
	PLATFORM_CODE(2);

	private int id;

	private PaymentIdentifierType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
