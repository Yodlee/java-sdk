/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.sdk.api.validators;

import java.util.ArrayList;
import java.util.List;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.sdk.api.HoldingsApi;
import com.yodlee.sdk.api.exception.ApiException;

public class HoldingsValidator {

	public enum HoldingInclude {
		isAssetTransferEligible,//
		assetClassification
	}

	public static void validateGetSecurities(HoldingsApi holdingsApi, String methodName, Long[] holdingId)
			throws ApiException {
		Class<?>[] argTypes = new Class[] {Long[].class};
		Object[] argValues = new Object[] {holdingId};
		List<Problem> methodProblems = ApiValidator.validate(holdingsApi, methodName, argTypes, argValues);
		methodProblems.addAll(ApiValidator.validateId(holdingId, "holdings.param.holdingId.invalid"));
		List<Problem> contextProblems = ApiValidator.validateUserContext(holdingsApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateGetHoldings(HoldingsApi holdingsApi, String methodName, Long[] accountId,
			String assetClassificationClassificationType, String classificationValue, HoldingInclude include,
			Long providerAccountId) throws ApiException {
		Class<?>[] argTypes = new Class[] {Long[].class, String.class, String.class, HoldingInclude.class, Long.class};
		Object[] argValues = new Object[] {accountId, assetClassificationClassificationType, classificationValue,
				include, providerAccountId};
		List<Problem> methodProblems = ApiValidator.validate(holdingsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(holdingsApi);
		List<Problem> problems = new ArrayList<>();
		problems.addAll(ApiValidator.validateId(accountId, "holdings.param.accountId.invalid"));
		ApiValidator.collectProblems(problems, methodProblems, contextProblems);
	}

	public static void validateHoldingsContext(HoldingsApi holdingsApi) throws ApiException {
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(holdingsApi);
		ApiValidator.collectProblems(contextProblems);
	}
}
