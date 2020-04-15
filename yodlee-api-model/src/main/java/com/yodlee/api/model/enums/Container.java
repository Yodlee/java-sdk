/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.enums;

import java.util.EnumSet;
import java.util.Set;

public enum Container {

	/**
	 * Applicable for Aggregated and Manual
	 */
	bank, //
	/**
	 * Applicable for Aggregated and Manual
	 */
	creditCard,
	/**
	 * Applicable for Aggregated and Manual
	 */
	investment,
	/**
	 * Applicable for Aggregated and Manual
	 */
	insurance,
	/**
	 * Applicable for Aggregated and Manual
	 */
	loan,
	/**
	 * Applicable for Aggregated and Manual
	 */
	reward,
	/**
	 * Applicable for Aggregated and Manual
	 */
	bill,
	/**
	 * Applicable for Manual
	 */
	realEstate,
	/**
	 * Applicable for Manual
	 */
	otherAssets,
	/**
	 * Applicable for Manual
	 */
	otherLiabilities;

	public static Set<Container> getTransactionContainers() {
		return EnumSet.of(bank, creditCard, investment, insurance, loan);
	}

	public static Set<Container> getStatementContainers() {
		return EnumSet.of(creditCard, insurance, loan, bill);
	}
}
