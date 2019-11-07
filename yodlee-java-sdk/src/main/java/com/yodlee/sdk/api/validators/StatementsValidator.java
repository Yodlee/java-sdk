/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api.validators;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.yodlee.api.model.account.enums.ItemAccountStatus;
import com.yodlee.api.model.enums.Container;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.sdk.api.StatementsApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;

public class StatementsValidator {

	private StatementsValidator() {}

	public static void validateGetStatement(StatementsApi statementsApi, String methodName, Long accountId,
			Container container, Date fromDate, Boolean isLatest, ItemAccountStatus status) throws ApiException {
		List<Problem> problems = new ArrayList<>();
		if (container != null && !Container.getStatementContainers().contains(container)) {
			problems.add(new Problem(ApiUtils.getErrorMessage("statements.param.container.invalid",container.name()), ""));
		}
		if (status != null && !ItemAccountStatus.getStatementApplicableStatusTypes().contains(status)) {
			problems.add(new Problem(ApiUtils.getErrorMessage("statements.param.status.invalid",status.name()), ""));
		}
		Class<?>[] argTypes =
				new Class[] {Long.class, Container.class, Date.class, Boolean.class, ItemAccountStatus.class};
		Object[] argValues = new Object[] {accountId, container, fromDate, isLatest, status};
		List<Problem> methodProblems = ApiValidator.validate(statementsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(statementsApi);
		ApiValidator.collectProblems(problems, methodProblems, contextProblems);
	}
}
