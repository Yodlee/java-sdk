/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
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
