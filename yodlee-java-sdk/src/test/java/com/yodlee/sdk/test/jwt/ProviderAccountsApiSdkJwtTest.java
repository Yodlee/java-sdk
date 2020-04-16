/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.jwt;

import org.databene.benerator.anno.Source;
import org.testng.annotations.Test;
import com.yodlee.sdk.api.ProviderAccountsApi;
import com.yodlee.sdk.test.ProviderAccountsApiSdkTest;

public class ProviderAccountsApiSdkJwtTest extends AbstractSdkJWTUserTestSuite {

	ProviderAccountsApi providerAccountsApi = new ProviderAccountsApi(null);

	public ProviderAccountsApiSdkJwtTest() {
		providerAccountsApi.setContext(AbstractSdkJWTUserTestSuite.setup());
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\ProviderAccounts\\updateProviderAccount.csv")
	public void refreshProviderAccountTest(String testCaseId, String testCaseName, String providerAccountId,
			String fileName, String enabled) {
		ProviderAccountsApiSdkTest.refreshProviderAccountTest(providerAccountsApi, testCaseId, testCaseName,
				providerAccountId, fileName);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\ProviderAccounts\\updateProviderAccount.csv")
	public void refreshAllProviderAccountsTest(String testCaseId, String testCaseName, String providerAccountIds,
			String fileName, String enabled) {
		ProviderAccountsApiSdkTest.refreshAllProviderAccountsTest(providerAccountsApi, testCaseId, testCaseName,
				providerAccountIds, fileName);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\ProviderAccounts\\updateProviderAccount.csv")
	public void updateProviderAccount(String testCaseId, String testCaseName, String providerAccountId, String fileName,
			String enabled) {
		ProviderAccountsApiSdkTest.updateProviderAccount(providerAccountsApi, testCaseId, testCaseName,
				providerAccountId, fileName);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\ProviderAccounts\\updateProviderAccount.csv")
	public void updateMFA(String testCaseId, String testCaseName, String providerAccountId, String fileName,
			String enabled) {
		ProviderAccountsApiSdkTest.updateMFA(providerAccountsApi, testCaseId, testCaseName, providerAccountId,
				fileName);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\ProviderAccounts\\deleteProviderAccount.csv")
	public void deleteProviderAccountTest(String testCaseId, String testCaseName, Long providerAccountId,
			String enabled) {
		ProviderAccountsApiSdkTest.deleteProviderAccountTest(providerAccountsApi, testCaseId, testCaseName,
				providerAccountId);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\ProviderAccounts\\getProviderAccount.csv")
	public void getProviderAccountTest(String testCaseId, String testCaseName, Long providerAccountId, String include,
			String requestId, String enabled) {
		ProviderAccountsApiSdkTest.getProviderAccountTest(providerAccountsApi, testCaseId, testCaseName,
				providerAccountId, include, requestId);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\ProviderAccounts\\getAllProviderAccounts.csv")
	public void getAllProviderAccountsTest(String testCaseId, String testCaseName, String include, String providerIds,
			String enabled) {
		ProviderAccountsApiSdkTest.getAllProviderAccountsTest(providerAccountsApi, testCaseId, testCaseName, include,
				providerIds);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\ProviderAccounts\\linkProviderAccount.csv")
	public void linkProviderAccountTest(String testCaseId, String testCaseName, long providerId, String fileName,
			String enabled) {
		ProviderAccountsApiSdkTest.linkProviderAccountTest(providerAccountsApi, testCaseId, testCaseName, providerId,
				fileName);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\ProviderAccounts\\getProviderAccountProfiles.csv")
	public void getProviderAccountProfilesTest(String testCaseId, String testCaseName, String providerAccountId,
			String enabled) {
		ProviderAccountsApiSdkTest.getProviderAccountProfilesTest(providerAccountsApi, testCaseId, testCaseName,
				providerAccountId);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\ProviderAccounts\\updatePreferences.csv")
	public void updatePreferencesTest(String testCaseId, String testCaseName, String fileName, Long providerAccountId,
			String enabled) {
		ProviderAccountsApiSdkTest.updatePreferencesTest(providerAccountsApi, testCaseId, testCaseName, fileName,
				providerAccountId);
	}
}
