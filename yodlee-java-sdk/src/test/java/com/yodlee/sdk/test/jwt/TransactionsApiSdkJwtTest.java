/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.jwt;

import org.databene.benerator.anno.Source;
import org.testng.annotations.Test;
import com.yodlee.sdk.api.TransactionsApi;
import com.yodlee.sdk.test.TransactionsApiSdkTest;

public class TransactionsApiSdkJwtTest extends AbstractSdkJWTUserTestSuite {

	private final TransactionsApi transactionsApi = new TransactionsApi(null);

	public TransactionsApiSdkJwtTest() {
		transactionsApi.setContext(AbstractSdkJWTUserTestSuite.setup());
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Transactions\\getTransactions.csv")
	public void getTransactions(String testCaseId, String testCaseName, String accountId, String baseType,
			String categoryId, String categoryType, String container, String detailCategoryId, String fromDate,
			String highLevelCategoryId, String keyword, String skip, String toDate, String top, String type,
			String enabled) {
		TransactionsApiSdkTest.getTransactionsTest(transactionsApi, testCaseId, testCaseName, accountId, baseType,
				categoryId, categoryType, container, detailCategoryId, fromDate, highLevelCategoryId, keyword, skip,
				toDate, top, type);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Transactions\\getTransactions.csv")
	public void getTransactionsCount(String testCaseId, String testCaseName, String accountId, String baseType,
			String categoryId, String categoryType, String container, String detailCategoryId, String fromDate,
			String highLevelCategoryId, String keyword, String skip, String toDate, String top, String type,
			String enabled) {
		TransactionsApiSdkTest.getTransactionsCountTest(transactionsApi, testCaseId, testCaseName, accountId, baseType,
				categoryId, categoryType, container, detailCategoryId, fromDate, highLevelCategoryId, keyword, skip,
				toDate, top, type);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Transactions\\updateTransactions.csv")
	public void updateTransaction(String testCaseId, String testCaseName, String transactionId, String fileName,
			String enabled) {
		TransactionsApiSdkTest.updateTransactionTest(transactionsApi, testCaseId, testCaseName, transactionId,
				fileName);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Transactions\\createTransactionCategory.csv")
	public void createTransactionCategory(String testCaseId, String testCaseName, String fileName, String enabled) {
		TransactionsApiSdkTest.createTransactionCategoryTest(transactionsApi, testCaseId, testCaseName, fileName);
	}
	
	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Transactions\\createTransactionCategory.csv")
	public void createTransactionCategoryAsync(String testCaseId, String testCaseName, String fileName, String enabled) {
		TransactionsApiSdkTest.createTransactionCategoryAsyncTest(transactionsApi, testCaseId, testCaseName, fileName);
	}

	@Test(enabled = true)
	public void getTransactionCategories() {
		TransactionsApiSdkTest.getTransactionCategoriesTest(transactionsApi, "1", "GET Transaction Categories");
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Transactions\\updateTransactionCategory.csv")
	public void updateTransactionCategory(String testCaseId, String testCaseName, String updateFileName,
			String enabled) {
		TransactionsApiSdkTest.updateTransactionCategoryTest(transactionsApi, testCaseId, testCaseName, updateFileName);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Transactions\\deleteTransactionCategory.csv")
	public void deleteTransactionCategory(String testCaseId, String testCaseName, String fileName, String categoryId,
			String enabled) {
		TransactionsApiSdkTest.deleteTransactionCategoryTest(transactionsApi, testCaseId, testCaseName, fileName,
				categoryId);
	}

	@Test(enabled = true)
	public void getTransactionCategorizationRules() {
		TransactionsApiSdkTest.getTransactionCategorizationRules(transactionsApi, "1",
				"GET TransactionCategorizationRules");
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Transactions\\createTransactionCategorizationRules.csv")
	public void createTransactionCategorizationRules(String testCaseId, String testCaseName, String fileName,
			String enabled) {
		TransactionsApiSdkTest.createTransactionCategorizationRulesTest(transactionsApi, testCaseId, testCaseName,
				fileName);
	}

	@Test(enabled = true)
	public void runTransactionCategorizationRules() {
		TransactionsApiSdkTest.runTransactionCategorizationRulesTest(transactionsApi, "1",
				"run TransactionCategorizationRules");
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Transactions\\createTransactionCategorizationRules.csv")
	public void runTransactionCategorizationRule(String testCaseId, String testCaseName, String fileName,
			String enabled) {
		TransactionsApiSdkTest.runTransactionCategorizationRuleTest(transactionsApi, testCaseId, testCaseName,
				fileName);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Transactions\\updateTransactionCategorizationRules.csv")
	public void updateTransactionCategorizationRule(String testCaseId, String testCaseName, String createFileName,
			String updateFileName, String enabled) {
		TransactionsApiSdkTest.updateTransactionCategorizationRuleTest(transactionsApi, testCaseId, testCaseName,
				createFileName, updateFileName);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Transactions\\createTransactionCategorizationRules.csv")
	public void deleteTransactionCategorizationRule(String testCaseId, String testCaseName, String fileName,
			String enabled) {
		TransactionsApiSdkTest.deleteTransactionCategorizationRuleTest(transactionsApi, testCaseId, testCaseName,
				fileName);
	}
}
