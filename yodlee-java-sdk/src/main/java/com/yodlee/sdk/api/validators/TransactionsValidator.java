/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.sdk.api.validators;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.yodlee.api.model.enums.AggregationSource;
import com.yodlee.api.model.enums.BaseType;
import com.yodlee.api.model.enums.Container;
import com.yodlee.api.model.transaction.FieldOperation;
import com.yodlee.api.model.transaction.enums.MeerkatTxnType;
import com.yodlee.api.model.transaction.enums.Operation;
import com.yodlee.api.model.transaction.enums.TransactionCategoryType;
import com.yodlee.api.model.transaction.enums.TransactionClauseType;
import com.yodlee.api.model.transaction.enums.TransactionType;
import com.yodlee.api.model.transaction.request.TransactionCategorizationRuleRequest;
import com.yodlee.api.model.transaction.request.TransactionCategoryRequest;
import com.yodlee.api.model.transaction.request.TransactionRequest;
import com.yodlee.api.model.transaction.request.UpdateCategoryRequest;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.sdk.api.ApiConstants;
import com.yodlee.sdk.api.TransactionsApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;

public class TransactionsValidator {

	private TransactionsValidator() {}

	public static void validateGetTransactions(TransactionsApi transactionsApi, String methodName, Long[] accountId,
			BaseType baseType, Long[] categoryId, TransactionCategoryType categoryType, Container container,
			Long[] detailCategoryId, Date fromDate, Long[] highLevelCategoryId, String keyword, Integer skip,
			Date toDate, Integer top, String type) throws ApiException {
		Class<?>[] argTypes = new Class[] {Long[].class, BaseType.class, Long[].class, TransactionCategoryType.class,
				Container.class, Long[].class, Date.class, Long[].class, String.class, Integer.class, Date.class,
				Integer.class, String.class};
		Object[] argValues = new Object[] {accountId, baseType, categoryId, categoryType, container, detailCategoryId,
				fromDate, highLevelCategoryId, keyword, skip, toDate, top, type};
		List<Problem> methodProblems = ApiValidator.validate(transactionsApi, methodName, argTypes, argValues);
		List<Problem> problems = validateTransactionRequest(accountId, categoryId, container, detailCategoryId,
				fromDate, highLevelCategoryId, toDate, type);
		List<Problem> contextProblems = ApiValidator.validateUserContext(transactionsApi);
		ApiValidator.collectProblems(problems, methodProblems, contextProblems);
	}

	public static void validateGetTransactionsCount(TransactionsApi transactionsApi, String methodName,
			Long[] accountId, BaseType baseType, Long[] categoryId, TransactionCategoryType categoryType,
			Container container, Long[] detailCategoryId, Date fromDate, Long[] highLevelCategoryId, String keyword,
			Date toDate, String type) throws ApiException {
		Class<?>[] argTypes = new Class[] {Long[].class, BaseType.class, Long[].class, TransactionCategoryType.class,
				Container.class, Long[].class, Date.class, Long[].class, String.class, Date.class, String.class};
		Object[] argValues = new Object[] {accountId, baseType, categoryId, categoryType, container, detailCategoryId,
				fromDate, highLevelCategoryId, keyword, toDate, type};
		List<Problem> methodProblems = ApiValidator.validate(transactionsApi, methodName, argTypes, argValues);
		List<Problem> problems = validateTransactionRequest(accountId, categoryId, container, detailCategoryId,
				fromDate, highLevelCategoryId, toDate, type);
		List<Problem> contextProblems = ApiValidator.validateUserContext(transactionsApi);
		ApiValidator.collectProblems(problems, methodProblems, contextProblems);
	}

	public static void validateUpdateTransaction(TransactionsApi transactionsApi, String methodName, long transactionId,
			TransactionRequest transactionRequest) throws ApiException {
		Class<?>[] argTypes = new Class[] {long.class, TransactionRequest.class};
		Object[] argValues = new Object[] {transactionId, transactionRequest};
		List<Problem> methodProblems = ApiValidator.validate(transactionsApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = ApiValidator.validate(transactionRequest);
		Container container = null;
		if (transactionRequest != null && transactionRequest.getTransaction() != null) {
			container = transactionRequest.getTransaction().getContainer();
		}
		List<Problem> problems = validateTransactionContainer(container, "transactions.container.invalid");
		List<Problem> contextProblems = ApiValidator.validateUserContext(transactionsApi);
		ApiValidator.collectProblems(problems, methodProblems, modelProblems, contextProblems);
	}

	public static void validateCreateTransactionCategory(TransactionsApi transactionsApi, String methodName,
			TransactionCategoryRequest transactionCategoryRequest) throws ApiException {
		Class<?>[] argTypes = new Class[] {TransactionCategoryRequest.class};
		Object[] argValues = new Object[] {transactionCategoryRequest};
		List<Problem> methodProblems = ApiValidator.validate(transactionsApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = ApiValidator.validate(transactionCategoryRequest);
		List<Problem> contextProblems = ApiValidator.validateUserContext(transactionsApi);
		ApiValidator.collectProblems(methodProblems, modelProblems, contextProblems);
	}

	public static void validateCreateTransactionCategorizationRules(TransactionsApi transactionsApi, String methodName,
			TransactionCategorizationRuleRequest transactionCategorizationRuleRequest) throws ApiException {
		Class<?>[] argTypes = new Class[] {TransactionCategorizationRuleRequest.class};
		Object[] argValues = new Object[] {transactionCategorizationRuleRequest};
		List<Problem> methodProblems = ApiValidator.validate(transactionsApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = ApiValidator.validate(transactionCategorizationRuleRequest);
		List<Problem> problems = validateTranscationCategoryRuleRequest(transactionCategorizationRuleRequest, true);
		List<Problem> contextProblems = ApiValidator.validateUserContext(transactionsApi);
		ApiValidator.collectProblems(problems, methodProblems, modelProblems, contextProblems);
	}

	public static void validateUpdateTransactionCategorizationRule(TransactionsApi transactionsApi, String methodName,
			long ruleId, TransactionCategorizationRuleRequest transactionCategorizationRuleRequest)
			throws ApiException {
		Class<?>[] argTypes = new Class[] {long.class, TransactionCategorizationRuleRequest.class};
		Object[] argValues = new Object[] {ruleId, transactionCategorizationRuleRequest};
		List<Problem> methodProblems = ApiValidator.validate(transactionsApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = ApiValidator.validate(transactionCategorizationRuleRequest);
		List<Problem> problems = validateTranscationCategoryRuleRequest(transactionCategorizationRuleRequest, false);
		List<Problem> contextProblems = ApiValidator.validateUserContext(transactionsApi);
		ApiValidator.collectProblems(problems, methodProblems, modelProblems, contextProblems);
	}

	public static void validateRunOrDeleteTransactionCategorizationRule(TransactionsApi transactionsApi,
			String methodName, long ruleId) throws ApiException {
		Class<?>[] argTypes = new Class[] {long.class};
		Object[] argValues = new Object[] {ruleId};
		List<Problem> methodProblems = ApiValidator.validate(transactionsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(transactionsApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateDeleteTransactionCategory(TransactionsApi transactionsApi, String methodName,
			long categoryId) throws ApiException {
		Class<?>[] argTypes = new Class[] {long.class};
		Object[] argValues = new Object[] {categoryId};
		List<Problem> methodProblems = ApiValidator.validate(transactionsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(transactionsApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateUpdateTransactionCategory(TransactionsApi transactionsApi, String methodName,
			UpdateCategoryRequest updateCategoryRequest) throws ApiException {
		Class<?>[] argTypes = new Class[] {UpdateCategoryRequest.class};
		Object[] argValues = new Object[] {updateCategoryRequest};
		List<Problem> methodProblems = ApiValidator.validate(transactionsApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = ApiValidator.validate(updateCategoryRequest);
		List<Problem> problems = validateUpdateCategoryRequest(updateCategoryRequest);
		List<Problem> contextProblems = ApiValidator.validateUserContext(transactionsApi);
		ApiValidator.collectProblems(problems, methodProblems, modelProblems, contextProblems);
	}

	public static void validateContext(TransactionsApi transactionsApi) throws ApiException {
		List<Problem> contextProblems = ApiValidator.validateUserContext(transactionsApi);
		ApiValidator.collectProblems(contextProblems);
	}

	public static void validateCobrandContext(TransactionsApi transactionsApi) throws ApiException {
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(transactionsApi);
		ApiValidator.collectProblems(contextProblems);
	}

	private static List<Problem> validateTransactionContainer(Container container, String messageKey) {
		List<Problem> problems = new ArrayList<>();
		if (container != null && !Container.getTransactionContainers().contains(container)) {
			problems.add(new Problem(ApiUtils.getErrorMessage(messageKey, container), ""));
		}
		return problems;
	}

	private static List<Problem> validateUpdateCategoryRequest(UpdateCategoryRequest updateCategoryRequest) {
		List<Problem> problems = new ArrayList<>();
		if (updateCategoryRequest != null && updateCategoryRequest.getCategoryName() == null
				&& updateCategoryRequest.getHighLevelCategoryName() == null) {
			String errorMessage = ApiUtils
					.getErrorMessage("transactions.updateCategory.categoryName.or.highLevelCategoryName.required");
			problems.add(new Problem(errorMessage, ""));
		}
		return problems;
	}

	private static List<Problem> validateTranscationCategoryRuleRequest(
			TransactionCategorizationRuleRequest transactionCategorizationRuleRequest, boolean createRequest) {
		List<Problem> problems = new ArrayList<>();
		if (transactionCategorizationRuleRequest != null && transactionCategorizationRuleRequest.getRule() != null) {
			AggregationSource source = transactionCategorizationRuleRequest.getRule().getSource();
			if (createRequest && source == null) {
				problems.add(new Problem(ApiUtils.getErrorMessage("transactions.rule.source.required"), ""));
			}
			List<FieldOperation> ruleClauses = transactionCategorizationRuleRequest.getRule().getRuleClauses();
			for (FieldOperation ruleClause : ruleClauses) {
				TransactionClauseType field = ruleClause.field();
				Object value = ruleClause.getValue();
				Operation operation = ruleClause.getOperation();
				if (TransactionClauseType.amount == (field) && value != null && operation != null) {
					problems.addAll(validateTransactionClauseTypeAmount(value, operation));
				}
				if (TransactionClauseType.description.equals(field) && value != null) {
					problems.addAll(validateTransactionClauseTypeDesc(value, operation));
				}
			}
		}
		return problems;
	}

	private static List<Problem> validateTransactionClauseTypeDesc(Object value, Operation operation) {
		List<Problem> problems = new ArrayList<>();
		if (StringUtils.isEmpty(value.toString())) {
			problems.add(new Problem(
					ApiUtils.getErrorMessage("transactions.rule.ruleClauses.description.value.invalid"), ""));
		}
		if (operation != null && !operation.isStringOperation()) {
			String errorMessage =
					ApiUtils.getErrorMessage("transactions.rule.ruleClauses.description.operation.invalid");
			problems.add(new Problem(errorMessage, ""));
		}
		return problems;
	}

	private static List<Problem> validateTransactionClauseTypeAmount(Object value, Operation operation) {
		List<Problem> problems = new ArrayList<>();
		if (!value.toString().matches(ApiConstants.ONLY_NUMBER)) {
			String errorMessage = ApiUtils.getErrorMessage("transactions.rule.ruleClauses.amount.value.invalid");
			problems.add(new Problem(errorMessage, ""));
		}
		if (!operation.isNumericOperation()) {
			String errorMessage = ApiUtils.getErrorMessage("transactions.rule.ruleClauses.amount.operation.invalid");
			problems.add(new Problem(errorMessage, ""));
		}
		return problems;
	}

	private static List<Problem> validateTransactionRequest(Long[] accountId, Long[] categoryId, Container container,
			Long[] detailCategoryId, Date fromDate, Long[] highLevelCategoryId, Date toDate, String type) {
		List<Problem> problems = validateTransactionContainer(container, "transactions.param.container.invalid");
		problems.addAll(ApiValidator.isValidDateRange(fromDate, toDate,
				ApiUtils.getErrorMessage("transactions.param.dateRange.invalid")));
		problems.addAll(ApiValidator.validateId(accountId, "transactions.param.accountId.invalid"));
		problems.addAll(ApiValidator.validateId(categoryId, "transactions.param.categoryId.invalid"));
		problems.addAll(ApiValidator.validateId(detailCategoryId, "transactions.param.detailCategoryId.invalid"));
		problems.addAll(ApiValidator.validateId(highLevelCategoryId, "transactions.param.highLevelCategoryId.invalid"));
		problems.addAll(validateTransactionType(container, type));
		return problems;
	}

	private static List<Problem> validateTransactionType(Container container, String type) {
		List<Problem> problems = new ArrayList<>();
		if (!StringUtils.isEmpty(type)) {
			StringBuilder sbType = new StringBuilder();
			sbType.append(Character.isDigit(type.charAt(0)) ? "_" : "").append(type);
			String processedType = sbType.toString();
			if (TransactionType.exists(processedType) && MeerkatTxnType.exists(processedType)) {
				containerBelongsToTransactionTypeAndMeerkatTxnType(container, problems);
			} else if (TransactionType.exists(processedType)) {
				containerBelongsToTransactionTypeOnly(container, problems);
			} else if (MeerkatTxnType.exists(processedType)) {
				containerBelongsToMeerkatTxnTypeOnly(container, problems);
			} else {
				createProblemForInvalidType(problems);
			}
		}
		return problems;
	}

	private static void containerBelongsToMeerkatTxnTypeOnly(Container container, List<Problem> problems) {
		if (container != null && !(container == Container.creditCard || container == Container.bank
				|| container == Container.investment || container == Container.loan)) {
			createProblemIfTypeNotSupportedTypeForContainer(container, problems);
		}
	}

	private static void containerBelongsToTransactionTypeOnly(Container container, List<Problem> problems) {
		if (container != null && (container == Container.bank || container == Container.creditCard)) {
			createProblemForInvalidType(problems);
		}
	}

	private static void containerBelongsToTransactionTypeAndMeerkatTxnType(Container container,
			List<Problem> problems) {
		if (container != null && !(container == Container.bank || container == Container.creditCard
				|| container == Container.investment || container == Container.loan)) {
			createProblemIfTypeNotSupportedTypeForContainer(container, problems);
		}
	}

	private static void createProblemForInvalidType(List<Problem> problems) {
		problems.add(new Problem(ApiUtils.getErrorMessage("transactions.param.type.invalid"), ""));
	}

	private static void createProblemIfTypeNotSupportedTypeForContainer(Container container, List<Problem> problems) {
		problems.add(new Problem(ApiUtils.getErrorMessage("transactions.param.type.notSupported", container), ""));
	}
}
