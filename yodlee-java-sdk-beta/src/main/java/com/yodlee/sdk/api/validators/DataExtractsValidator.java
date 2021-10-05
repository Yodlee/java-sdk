/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api.validators;

import java.util.Date;
import java.util.List;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.sdk.api.DataExtractsApi;
import com.yodlee.sdk.api.exception.ApiException;

public class DataExtractsValidator {

	public enum DataExtractsEventType {
		/**
		 * Data updates that happen on provider accounts, accounts, transactions and holdings data due to user actions
		 * or auto updates. This event is triggered to help the customer perform data extracts from Yodlee system to
		 * their system
		 * 
		 */
		DATA_UPDATES
	}

	public static void validateDataExtractsEvents(DataExtractsApi dataExtractsApi, String methodName,
			DataExtractsEventType eventName, Date fromDate, Date toDate) throws ApiException {
		Class<?>[] argTypes = new Class[] {DataExtractsEventType.class, Date.class, Date.class};
		Object[] argValues = new Object[] {eventName, fromDate, toDate};
		List<Problem> methodProblems = ApiValidator.validate(dataExtractsApi, methodName, argTypes, argValues);
		methodProblems.addAll(ApiValidator.isValidDateRange(fromDate, toDate, "dataExtracts.param.date.range.invalid"));
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(dataExtractsApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateDataExtractsUserData(DataExtractsApi dataExtractsApi, String methodName, Date fromDate,
			String loginName, Date toDate) throws ApiException {
		Class<?>[] argTypes = new Class[] {Date.class, String.class, Date.class};
		Object[] argValues = new Object[] {fromDate, loginName, toDate};
		List<Problem> methodProblems = ApiValidator.validate(dataExtractsApi, methodName, argTypes, argValues);
		methodProblems.addAll(ApiValidator.isValidDateRange(fromDate, toDate, "dataExtracts.param.date.range.invalid"));
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(dataExtractsApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}
}
