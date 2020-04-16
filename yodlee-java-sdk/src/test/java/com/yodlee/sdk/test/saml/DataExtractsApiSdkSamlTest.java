/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.saml;

import org.databene.benerator.anno.Source;
import org.testng.annotations.Test;
import com.yodlee.sdk.api.DataExtractsApi;
import com.yodlee.sdk.test.DataExtractsApiSdkTest;

public class DataExtractsApiSdkSamlTest extends AbstractSdkSAMLCobrandTestSuite {

	DataExtractsApi dataExtractsApi = new DataExtractsApi(null);

	public DataExtractsApiSdkSamlTest() {
		dataExtractsApi.setContext(AbstractSdkSAMLCobrandTestSuite.setup());
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\DataExtracts\\getDataExtractsEvents.csv")
	public void testGetDataExtractsEvents(String testCaseId, String testCaseName, String eventName, String fromDate,
			String toDate, String enabled) {
		DataExtractsApiSdkTest.testGetDataExtractsEvents(dataExtractsApi, testCaseId, testCaseName, eventName, fromDate,
				toDate);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\DataExtracts\\getuserData.csv")
	public void testGetUserData(String testCaseId, String testCaseName, String fromDate, String loginName,
			String toDate, String enabled) {
		DataExtractsApiSdkTest.testGetUserData(dataExtractsApi, testCaseId, testCaseName, fromDate, loginName, toDate);
	}
}
