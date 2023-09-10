/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CreditAcceleratorAddressType {
	
	BUSINESS("BUSINESS"),

	WORK("WORK"),

	PAYMENT("PAYMENT"),

	PAYOFF("PAYOFF"),

	HOME("HOME");

	private String value;

	CreditAcceleratorAddressType(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

}
