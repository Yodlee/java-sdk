/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.enums;

import java.util.EnumSet;
import java.util.Set;

public enum FullAccountNumberFields {
	/**
	 * paymentAccountNumber
	 */
	paymentAccountNumber, //
	/**
	 * unmaskedAccountNumber
	 */
	unmaskedAccountNumber;

	public static Set<FullAccountNumberFields> getTransactionContainers() {
		return EnumSet.of(paymentAccountNumber, unmaskedAccountNumber);
	}
}
