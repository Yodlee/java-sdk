/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.saml;

import org.databene.benerator.anno.Source;
import org.testng.annotations.Test;
import com.yodlee.api.model.enums.Container;
import com.yodlee.sdk.api.DerivedApi;
import com.yodlee.sdk.test.DerivedApiSdkTest;

public class DerivedApiSdkSamlTest extends AbstractSdkSAMLUserTestSuite {

	DerivedApi derivedApi = new DerivedApi(null);

	public DerivedApiSdkSamlTest() {
		derivedApi.setContext(AbstractSdkSAMLUserTestSuite.setup());
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Derived\\getTransactionSummary.csv")
	public void TestGetTransactionSummary(String testCaseId, String testCaseName, String groupBy, String accountId,
			String categoryId, String categoryType, String fromDate, String include, Boolean includeUserCategory,
			String interval, String toDate, String enabled) {
		DerivedApiSdkTest.TestGetTransactionSummary(derivedApi, testCaseId, testCaseName, groupBy, accountId,
				categoryId, categoryType, fromDate, include, includeUserCategory, interval, toDate);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Derived\\getHoldingSummary.csv")
	public void TestGetHoldingSummary(String testCaseId, String testCaseName, String accountIds,
			String classificationType, String include, String enabled) {
		DerivedApiSdkTest.TestGetHoldingSummary(derivedApi, testCaseId, testCaseName, accountIds, classificationType,
				include);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Derived\\getNetworth.csv")
	public void TestGetNetworth(String testCaseId, String testCaseName, String accountIds, String fromDate,
			String include, String interval, Integer skip, String toDate, Integer top, String enabled,
			String container) {
		DerivedApiSdkTest.TestGetNetworth(derivedApi, testCaseId, testCaseName, accountIds, fromDate, include, interval,
				skip, toDate, top, container);
	}
}
