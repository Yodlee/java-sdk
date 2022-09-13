/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.saml;

import org.databene.benerator.anno.Source;
import org.testng.annotations.Test;
import com.yodlee.sdk.api.StatementsApi;
import com.yodlee.sdk.test.StatementsApiSdkTest;

public class StatementsApiSdkSamlTest extends AbstractSdkSAMLUserTestSuite {

	private final StatementsApi statementsApi = new StatementsApi(null);

	public StatementsApiSdkSamlTest() {
		statementsApi.setContext(AbstractSdkSAMLUserTestSuite.setup());
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Statements\\getStatements.csv")
	public void getStatementsTest(String testCaseId, String testCaseName, String accountId, String container,
			String fromDate, String isLatest, String status, String enabled) {
		StatementsApiSdkTest.getStatmentsTest(statementsApi, testCaseId, testCaseName, accountId, container, fromDate,
				isLatest, status);
	}
}
