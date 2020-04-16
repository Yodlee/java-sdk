/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.jwt;

import org.databene.benerator.anno.Source;
import org.testng.annotations.Test;
import com.yodlee.sdk.api.AccountsApi;
import com.yodlee.sdk.test.AccountsApiSdkTest;

public class AccountsApiSdkJwtTest extends AbstractSdkJWTUserTestSuite {

	private final AccountsApi accountsApi = new AccountsApi(null);

	public AccountsApiSdkJwtTest() {
		accountsApi.setContext(AbstractSdkJWTUserTestSuite.setup());
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Accounts\\getAccountDetails.csv")
	public void getAccountDetails(String testCaseId, String testCaseName, String accountId, String container,
			String include, String enabled) {
		AccountsApiSdkTest.getAccountDetailsTest(accountsApi, testCaseId, testCaseName, accountId, container, include);
	}

	@Test(enabled = false, dataProvider = "feeder")
	@Source("\\Accounts\\getAccountDetailsNeg.csv")
	public void getAccountDetailsNeg(String testCaseId, String testCaseName, String accountId, String container,
			String include, String enabled) {
		AccountsApiSdkTest.getAccountDetailsTest(accountsApi, testCaseId, testCaseName, accountId, container, include);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Accounts\\getAllAccounts.csv")
	public void getAllAccounts(String testCaseId, String testCaseName, String accountId, String container,
			String include, String providerAccountId, String requestId, String status, String enabled) {
		AccountsApiSdkTest.getAllAccountsTest(accountsApi, testCaseId, testCaseName, accountId, container, include,
				providerAccountId, requestId, status);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Accounts\\getHistoricalBalances.csv")
	public void getHistoricalBalances(String testCaseId, String testCaseName, String accountId, String toDate,
			String fromDate, String includeCF, String interval, String skip, String top, String enabled) {
		AccountsApiSdkTest.getHistoricalBalancesTest(accountsApi, testCaseId, testCaseName, accountId, toDate, fromDate,
				includeCF, interval, skip, top);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Accounts\\addManualAccount.csv")
	public void createManualAccount(String testCaseId, String testCaseName, String fileName, String enabled) {
		AccountsApiSdkTest.createManualAccountTest(accountsApi, testCaseId, testCaseName, fileName);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Accounts\\updateAccount.csv")
	public void updateAccount(String testCaseId, String testCaseName, String accountId, String fileName,
			String enabled) {
		AccountsApiSdkTest.updateAccountTest(accountsApi, testCaseId, testCaseName, accountId, fileName);
	}

	@Test(enabled = false, dataProvider = "feeder")
	@Source("\\Accounts\\deleteAccount.csv")
	public void deleteAccountWithSpecificId(String testCaseId, String testCaseName, String accountId, String enabled) {
		AccountsApiSdkTest.deleteAccountWithSpecificIdTest(accountsApi, testCaseId, testCaseName, accountId);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Accounts\\deleteAccount.csv")
	public void deleteAccount(String testCaseId, String testCaseName, String fileName, String enabled) {
		AccountsApiSdkTest.deleteAccountTest(accountsApi, testCaseId, testCaseName, fileName);
	}
}
