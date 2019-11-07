/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.providers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yodlee.api.model.AbstractModelComponent;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDays extends AbstractModelComponent {

	private Integer numberOfTransactionDays;

	public Integer getNumberOfTransactionDays() {
		return numberOfTransactionDays;
	}

	@Override
	public String toString() {
		return "TransactionDays [numberOfTransactionDays=" + numberOfTransactionDays + "]";
	}
}
