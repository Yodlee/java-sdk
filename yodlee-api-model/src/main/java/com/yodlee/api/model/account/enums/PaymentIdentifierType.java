/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
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
