/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api.validators;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.sdk.api.DerivedApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;

public class DerivedValidator {

	private static final String CATEGORY_TYPE = "CATEGORY_TYPE";

	private static final String HIGH_LEVEL_CATEGORY = "HIGH_LEVEL_CATEGORY";

	private static final String CATEGORY = "CATEGORY";

	public enum GroupType {
		CATEGORY_TYPE, //
		HIGH_LEVEL_CATEGORY, //
		CATEGORY;
	}

	public enum CategoryType {
		INCOME, EXPENSE, TRANSFER, UNCATEGORIZE, DEFERRED_COMPENSATION;
	}

	public enum DataPointInterval {
		D, W, M, Y
	}

	public enum DerivedInclude {
		details
	}

	public static void validateTransactionSummary(DerivedApi derivedApi, String methodName, GroupType groupBy,
			Long[] accountId, Long[] categoryId, CategoryType[] categoryType, Date fromDate, DerivedInclude include,
			Boolean includeUserCategory, DataPointInterval interval, Date toDate) throws ApiException {
		Class<?>[] argTypes = new Class[] {GroupType.class, Long[].class, Long[].class, CategoryType[].class,
				Date.class, DerivedInclude.class, Boolean.class, DataPointInterval.class, Date.class};
		Object[] argValues = new Object[] {groupBy, accountId, categoryId, categoryType, fromDate, include,
				includeUserCategory, interval, toDate};
		List<Problem> methodProblems = ApiValidator.validate(derivedApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(derivedApi);
		methodProblems.addAll(ApiValidator.isValidDateRange(fromDate, toDate, "derived.param.date.range.invalid"));
		methodProblems.addAll(ApiValidator.validateId(accountId, "derived.param.accountId.invalid"));
		methodProblems.addAll(ApiValidator.validateId(categoryId, "derived.param.categoryId.invalid"));
		methodProblems.addAll(validateCategoryType(groupBy, categoryType));
		methodProblems.addAll(validateCategoryId(groupBy, categoryId));
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	private static List<Problem> validateCategoryId(GroupType groupBy, Long[] categoryId) {
		List<Problem> problems = new ArrayList<>();
		if (groupBy != null && groupBy.toString().equalsIgnoreCase(CATEGORY_TYPE) && categoryId != null) {
			problems.add(new Problem(ApiUtils.getErrorMessage("derived.param.categoryId.groupBy.invalid"), ""));
		}
		return problems;
	}

	private static List<Problem> validateCategoryType(GroupType groupBy, CategoryType[] categoryType) {
		List<Problem> problems = new ArrayList<>();
		if (groupBy != null
				&& (groupBy.toString().equalsIgnoreCase(CATEGORY)
						|| groupBy.toString().equalsIgnoreCase(HIGH_LEVEL_CATEGORY))
				&& (categoryType == null || categoryType.length < 1)) {
			problems.add(new Problem(ApiUtils.getErrorMessage("derived.param.categoryType.required"), ""));
		}
		return problems;
	}

	public static void validateHoldingSummary(DerivedApi derivedApi, String methodName, Long[] accountIds,
			String classificationType, DerivedInclude include) throws ApiException {
		Class<?>[] argTypes = new Class[] {Long[].class, String.class, DerivedInclude.class};
		Object[] argValues = new Object[] {accountIds, classificationType, include};
		List<Problem> methodProblems = ApiValidator.validate(derivedApi, methodName, argTypes, argValues);
		methodProblems.addAll(ApiValidator.validateId(accountIds, "derived.param.accountIds.invalid"));
		List<Problem> contextProblems = ApiValidator.validateUserContext(derivedApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateNetworth(DerivedApi derivedApi, String methodName, Long[] accountIds, Date fromDate,
			DerivedInclude include, DataPointInterval interval, Integer skip, Date toDate, Integer top)
			throws ApiException {
		Class<?>[] argTypes = new Class[] {Long[].class, Date.class, DerivedInclude.class, DataPointInterval.class,
				Integer.class, Date.class, Integer.class};
		Object[] argValues = new Object[] {accountIds, fromDate, include, interval, skip, toDate, top};
		List<Problem> methodProblems = ApiValidator.validate(derivedApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(derivedApi);
		methodProblems.addAll(ApiValidator.isValidDateRange(fromDate, toDate, "derived.param.date.range.invalid"));
		methodProblems.addAll(ApiValidator.validateId(accountIds, "derived.param.accountIds.invalid"));
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}
}
