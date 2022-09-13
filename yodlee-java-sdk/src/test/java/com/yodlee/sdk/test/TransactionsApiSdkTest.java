/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.lang3.StringUtils;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.enums.BaseType;
import com.yodlee.api.model.enums.Container;
import com.yodlee.api.model.transaction.TransactionCategorizationRule;
import com.yodlee.api.model.transaction.enums.TransactionCategoryType;
import com.yodlee.api.model.transaction.request.TransactionCategorizationRuleRequest;
import com.yodlee.api.model.transaction.request.TransactionCategoryRequest;
import com.yodlee.api.model.transaction.request.TransactionRequest;
import com.yodlee.api.model.transaction.request.UpdateCategoryRequest;
import com.yodlee.api.model.transaction.response.TransactionCategorizationRuleResponse;
import com.yodlee.api.model.transaction.response.TransactionCategoryResponse;
import com.yodlee.api.model.transaction.response.TransactionCountResponse;
import com.yodlee.api.model.transaction.response.TransactionResponse;
import com.yodlee.api.model.user.enums.Locale;
import com.yodlee.sdk.api.ApiConstants;
import com.yodlee.sdk.api.TransactionsApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.client.ApiCallbackAdapter;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.test.utils.ModelUtil;
import com.yodlee.sdk.test.utils.PrintUtil;

public class TransactionsApiSdkTest {

	public static void getTransactionsTest(TransactionsApi transactionsApi, String testCaseId, String testCaseName,
			String accountId, String baseType, String categoryId, String categoryType, String container,
			String detailCategoryId, String fromDate, String highLevelCategoryId, String keyword, String skip,
			String toDate, String top, String type) {
		try {
			BaseType baseTypeValue = StringUtils.isEmpty(baseType) ? null : BaseType.valueOf(baseType);
			TransactionCategoryType categoryTypeValue =
					StringUtils.isEmpty(categoryType) ? null : TransactionCategoryType.valueOf(categoryType);
			Container containerValue = StringUtils.isEmpty(container) ? null : Container.valueOf(container);
			Integer skipValue = StringUtils.isEmpty(skip) ? null : Integer.valueOf(skip);
			Integer topValue = StringUtils.isEmpty(top) ? null : Integer.valueOf(top);
			Date toDateValue = StringUtils.isEmpty(toDate) ? null : new Date(Long.parseLong(toDate) * 1000L);
			Date fromDateValue = StringUtils.isEmpty(fromDate) ? null : new Date(Long.parseLong(fromDate) * 1000L);
			Long[] accountIdValue = StringUtils.isEmpty(accountId) ? null : convertstringtoLongArray(accountId);
			Long[] categoryIdValue = StringUtils.isEmpty(categoryId) ? null : convertstringtoLongArray(categoryId);
			Long[] detailCategoryIdValue =
					StringUtils.isEmpty(detailCategoryId) ? null : convertstringtoLongArray(detailCategoryId);
			Long[] highLevelCategoryIdValue =
					StringUtils.isEmpty(highLevelCategoryId) ? null : convertstringtoLongArray(highLevelCategoryId);
			ApiResponse<TransactionResponse> transactions = transactionsApi.getTransactions(accountIdValue,
					baseTypeValue, categoryIdValue, categoryTypeValue, containerValue, detailCategoryIdValue,
					fromDateValue, highLevelCategoryIdValue, keyword, skipValue, toDateValue, topValue, type);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, transactions);
			assertEquals(transactions.getStatusCode(), 200);
			assertNotNull(transactions.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void getTransactionsTestwithGzip(TransactionsApi transactionsApi, String testCaseId,
			String testCaseName, String accountId, String baseType, String categoryId, String categoryType,
			String container, String detailCategoryId, String fromDate, String highLevelCategoryId, String keyword,
			String skip, String toDate, String top, String type) {
		try {
			BaseType baseTypeValue = StringUtils.isEmpty(baseType) ? null : BaseType.valueOf(baseType);
			TransactionCategoryType categoryTypeValue =
					StringUtils.isEmpty(categoryType) ? null : TransactionCategoryType.valueOf(categoryType);
			Container containerValue = StringUtils.isEmpty(container) ? null : Container.valueOf(container);
			Integer skipValue = StringUtils.isEmpty(skip) ? null : Integer.valueOf(skip);
			Integer topValue = StringUtils.isEmpty(top) ? null : Integer.valueOf(top);
			Date toDateValue = StringUtils.isEmpty(toDate) ? null : new Date(Long.parseLong(toDate) * 1000L);
			Date fromDateValue = StringUtils.isEmpty(fromDate) ? null : new Date(Long.parseLong(fromDate) * 1000L);
			Long[] accountIdValue = StringUtils.isEmpty(accountId) ? null : convertstringtoLongArray(accountId);
			Long[] categoryIdValue = StringUtils.isEmpty(categoryId) ? null : convertstringtoLongArray(categoryId);
			Long[] detailCategoryIdValue =
					StringUtils.isEmpty(detailCategoryId) ? null : convertstringtoLongArray(detailCategoryId);
			Long[] highLevelCategoryIdValue =
					StringUtils.isEmpty(highLevelCategoryId) ? null : convertstringtoLongArray(highLevelCategoryId);
			// Creating an empty HashMap
			Map<String, String> map = new HashMap<>();
			map.put(ApiConstants.ACCEPT_ENCODING, "gzip");
			ApiResponse<TransactionResponse> transactions = transactionsApi.getTransactions(accountIdValue,
					baseTypeValue, categoryIdValue, categoryTypeValue, containerValue, detailCategoryIdValue,
					fromDateValue, highLevelCategoryIdValue, keyword, skipValue, toDateValue, topValue, type, map);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, transactions);
			assertEquals(transactions.getStatusCode(), 200);
			assertNotNull(transactions.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void getTransactionsCountTest(TransactionsApi transactionsApi, String testCaseId, String testCaseName,
			String accountId, String baseType, String categoryId, String categoryType, String container,
			String detailCategoryId, String fromDate, String highLevelCategoryId, String keyword, String skip,
			String toDate, String top, String type) {
		try {
			BaseType baseTypeValue = StringUtils.isEmpty(baseType) ? null : BaseType.valueOf(baseType);
			TransactionCategoryType categoryTypeValue =
					StringUtils.isEmpty(categoryType) ? null : TransactionCategoryType.valueOf(categoryType);
			Container containerValue = StringUtils.isEmpty(container) ? null : Container.valueOf(container);
			Date toDateValue = StringUtils.isEmpty(toDate) ? null : new Date(Long.parseLong(toDate) * 1000L);
			Date fromDateValue = StringUtils.isEmpty(fromDate) ? null : new Date(Long.parseLong(fromDate) * 1000L);
			Long[] accountIdValue = StringUtils.isEmpty(accountId) ? null : convertstringtoLongArray(accountId);
			Long[] categoryIdValue = StringUtils.isEmpty(categoryId) ? null : convertstringtoLongArray(categoryId);
			Long[] detailCategoryIdValue =
					StringUtils.isEmpty(detailCategoryId) ? null : convertstringtoLongArray(detailCategoryId);
			Long[] highLevelCategoryIdValue =
					StringUtils.isEmpty(highLevelCategoryId) ? null : convertstringtoLongArray(highLevelCategoryId);
			ApiResponse<TransactionCountResponse> transactions = transactionsApi.getTransactionsCount(accountIdValue,
					baseTypeValue, categoryIdValue, categoryTypeValue, containerValue, detailCategoryIdValue,
					fromDateValue, highLevelCategoryIdValue, keyword, toDateValue, type);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, transactions);
			assertEquals(transactions.getStatusCode(), 200);
			assertNotNull(transactions.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void updateTransactionTest(TransactionsApi transactionsApi, String testCaseId, String testCaseName,
			String transactionId, String fileName) {
		try {
			TransactionRequest transactionRequest = ModelUtil.load(fileName, TransactionRequest.class);
			Long transactionIdValue = StringUtils.isEmpty(transactionId) ? null : Long.valueOf(transactionId);
			ApiResponse<AbstractModelComponent> updateTransaction =
					transactionsApi.updateTransaction(transactionIdValue, transactionRequest);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, updateTransaction);
			assertEquals(updateTransaction.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void createTransactionCategoryTest(TransactionsApi transactionsApi, String testCaseId,
			String testCaseName, String fileName) {
		try {
			TransactionCategoryRequest transactionCategoryRequest =
					ModelUtil.load(fileName, TransactionCategoryRequest.class);
			ApiResponse<AbstractModelComponent> createTransactionCategory =
					transactionsApi.createTransactionCategory(transactionCategoryRequest);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, createTransactionCategory);
			assertEquals(createTransactionCategory.getStatusCode(), 201);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void createTransactionCategoryAsyncTest(TransactionsApi transactionsApi, String testCaseId,
			String testCaseName, String fileName) {
		try {
			final CountDownLatch countDownLatch = new CountDownLatch(1);
			TransactionCategoryRequest transactionCategoryRequest =
					ModelUtil.load(fileName, TransactionCategoryRequest.class);
			transactionsApi.createTransactionCategoryAsync(transactionCategoryRequest,
					new ApiCallbackAdapter<AbstractModelComponent>() {

						@Override
						public void onSuccess(AbstractModelComponent result, int statusCode,
								Map<String, List<String>> responseHeaders) {
							assertEquals(statusCode, 201);
							countDownLatch.countDown();
						}

						@Override
						public void onFailure(ApiException e, int statusCode,
								Map<String, List<String>> responseHeaders) {
							try {
								fail();
							} finally {
								countDownLatch.countDown();
							}
						}
					});
			countDownLatch.await();
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception Occured : ", e);
		}
	}

	public static void getTransactionCategoriesTest(TransactionsApi transactionsApi, String testCaseId,
			String testCaseName) {
		try {
			transactionsApi.addRequestHeader(ApiConstants.LOCALE, Locale.fr_CA.toString());
			ApiResponse<TransactionCategoryResponse> transactionCategories = transactionsApi.getTransactionCategories();
			transactionsApi.removeRequestHeader(ApiConstants.LOCALE);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, transactionCategories);
			System.out.println("Output : " + transactionCategories.getData().getTransactionCategory().get(2));
			assertEquals(transactionCategories.getStatusCode(), 200);
			assertNotNull(transactionCategories);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void updateTransactionCategoryTest(TransactionsApi transactionsApi, String testCaseId,
			String testCaseName, String updateFileName) {
		try {
			UpdateCategoryRequest updateCategoryRequest = ModelUtil.load(updateFileName, UpdateCategoryRequest.class);
			ApiResponse<AbstractModelComponent> updateTransactionCategory =
					transactionsApi.updateTransactionCategory(updateCategoryRequest);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, updateTransactionCategory);
			assertEquals(updateTransactionCategory.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void deleteTransactionCategoryTest(TransactionsApi transactionsApi, String testCaseId,
			String testCaseName, String fileName, String categoryId) {
		try {
			TransactionCategoryRequest transactionCategoryRequest =
					ModelUtil.load(fileName, TransactionCategoryRequest.class);
			ApiResponse<AbstractModelComponent> createTransactionCategory =
					transactionsApi.createTransactionCategory(transactionCategoryRequest);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, createTransactionCategory);
			Long categoryIdValue = StringUtils.isEmpty(categoryId) ? 105L : Long.valueOf(categoryId);
			ApiResponse<AbstractModelComponent> deleteTransactionCategory =
					transactionsApi.deleteTransactionCategory(categoryIdValue);
			assertEquals(deleteTransactionCategory.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void getTransactionCategorizationRules(TransactionsApi transactionsApi, String testCaseId,
			String testCaseName) {
		try {
			ApiResponse<TransactionCategorizationRuleResponse> transactionCategorizationRules =
					transactionsApi.getTransactionCategorizationRules();
			PrintUtil.printJSONResponse(testCaseId, testCaseName, transactionCategorizationRules);
			assertEquals(transactionCategorizationRules.getStatusCode(), 200);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void createTransactionCategorizationRulesTest(TransactionsApi transactionsApi, String testCaseId,
			String testCaseName, String fileName) {
		try {
			TransactionCategorizationRuleRequest transactionCategorizationRuleRequest =
					ModelUtil.load(fileName, TransactionCategorizationRuleRequest.class);
			ApiResponse<AbstractModelComponent> createTransactionCategorizationRules =
					transactionsApi.createTransactionCategorizationRules(transactionCategorizationRuleRequest);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, createTransactionCategorizationRules);
			assertEquals(createTransactionCategorizationRules.getStatusCode(), 201);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void runTransactionCategorizationRulesTest(TransactionsApi transactionsApi, String testCaseId,
			String testCaseName) {
		try {
			ApiResponse<AbstractModelComponent> runTransactionCategorizationRules =
					transactionsApi.runTransactionCategorizationRules();
			PrintUtil.printJSONResponse(testCaseId, testCaseName, runTransactionCategorizationRules);
			assertEquals(runTransactionCategorizationRules.getStatusCode(), 201);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void runTransactionCategorizationRuleTest(TransactionsApi transactionsApi, String testCaseId,
			String testCaseName, String fileName) {
		try {
			createTransactionCategorizationRulesTest(transactionsApi, testCaseId, testCaseName, fileName);
			ApiResponse<TransactionCategorizationRuleResponse> transactionCategorizationRules =
					transactionsApi.getTransactionCategorizationRules();
			List<TransactionCategorizationRule> transactionCategoryRules =
					transactionCategorizationRules.getData().getTransactionCategoryRules();
			Long userDefinedRuleId = transactionCategoryRules != null && !transactionCategoryRules.isEmpty()
					? transactionCategoryRules.get(0).getUserDefinedRuleId()
					: 2L;
			ApiResponse<AbstractModelComponent> runTransactionCategorizationRule =
					transactionsApi.runTransactionCategorizationRule(userDefinedRuleId);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, runTransactionCategorizationRule);
			assertEquals(runTransactionCategorizationRule.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void updateTransactionCategorizationRuleTest(TransactionsApi transactionsApi, String testCaseId,
			String testCaseName, String createfileName, String updateFileName) {
		try {
			TransactionCategorizationRuleRequest transactionCategorizationRuleRequestcreate =
					ModelUtil.load(createfileName, TransactionCategorizationRuleRequest.class);
			TransactionCategorizationRuleRequest transactionCategorizationRuleRequestupdate =
					ModelUtil.load(updateFileName, TransactionCategorizationRuleRequest.class);
			transactionsApi.createTransactionCategorizationRules(transactionCategorizationRuleRequestcreate);
			//
			ApiResponse<TransactionCategorizationRuleResponse> transactionCategorizationRules =
					transactionsApi.getTransactionCategorizationRules();
			List<TransactionCategorizationRule> transactionCategoryRules =
					transactionCategorizationRules.getData().getTransactionCategoryRules();
			long userDefinedRuleId = transactionCategoryRules != null && !transactionCategoryRules.isEmpty()
					? transactionCategoryRules.get(0).getUserDefinedRuleId()
					: 1;
			//
			ApiResponse<AbstractModelComponent> updateTransactionCategorizationRule = transactionsApi
					.updateTransactionCategorizationRule(userDefinedRuleId, transactionCategorizationRuleRequestupdate);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, updateTransactionCategorizationRule);
			assertEquals(updateTransactionCategorizationRule.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void deleteTransactionCategorizationRuleTest(TransactionsApi transactionsApi, String testCaseId,
			String testCaseName, String fileName) {
		try {
			createTransactionCategorizationRulesTest(transactionsApi, testCaseId, testCaseName, fileName);
			//
			ApiResponse<TransactionCategorizationRuleResponse> transactionCategorizationRules =
					transactionsApi.getTransactionCategorizationRules();
			List<TransactionCategorizationRule> transactionCategoryRules =
					transactionCategorizationRules.getData().getTransactionCategoryRules();
			long userDefinedRuleId = transactionCategoryRules != null && !transactionCategoryRules.isEmpty()
					? transactionCategoryRules.get(0).getUserDefinedRuleId()
					: 1101;
			ApiResponse<AbstractModelComponent> deleteTransactionCategorizationRule =
					transactionsApi.deleteTransactionCategorizationRule(userDefinedRuleId);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, deleteTransactionCategorizationRule);
			assertEquals(deleteTransactionCategorizationRule.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	private static Long[] convertstringtoLongArray(String param) {
		String[] stringArray = param.split(",");
		Long[] value = new Long[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			value[i] = Long.valueOf(stringArray[i]);
		}
		return value;
	}
}
