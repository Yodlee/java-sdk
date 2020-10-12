/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.providers;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.enums.FullAccountNumberFields;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDays extends AbstractModelComponent {

	private Integer numberOfTransactionDays;
	
	private List<FullAccountNumberFields> fullAccountNumberFields;

	public Integer getNumberOfTransactionDays() {
		return numberOfTransactionDays;
	}

	public List<FullAccountNumberFields> getFullAccountNumberFields() {
		return fullAccountNumberFields;
	}
	
	@Override
	public String toString() {
		return "TransactionDays [numberOfTransactionDays=" + numberOfTransactionDays + ", fullAccountNumberFields="
				+ fullAccountNumberFields + "]";
	}
}
