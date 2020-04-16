/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.clientcredential;

import org.databene.benerator.anno.Source;
import org.testng.annotations.Test;
import com.yodlee.sdk.api.HoldingsApi;
import com.yodlee.sdk.test.HoldingsApiSdkTest;

public class HoldingsApiSdkClientCredentialUserTokenTest extends AbstractSdkClientCredentialUserTestSuite {

	HoldingsApi holdingsApi = new HoldingsApi(null);

	public HoldingsApiSdkClientCredentialUserTokenTest() {
		holdingsApi.setContext(AbstractSdkClientCredentialUserTestSuite.setup());
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Holdings\\getHoldings.csv")
	public void getHoldingsTest(String testCaseId, String testCaseName, String accountId,
			String assetClassificationClassificationType, String classificationValue, String include,
			Long providerAccountId, String enabled) {
		HoldingsApiSdkTest.getHoldingsTest(holdingsApi, testCaseId, testCaseName, accountId,
				assetClassificationClassificationType, classificationValue, include, providerAccountId);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Holdings\\getSecurities.csv")
	public void getSecuritiesTest(String testCaseId, String testCaseName, String holdingId, String enabled) {
		HoldingsApiSdkTest.getSecuritiesTest(holdingsApi, testCaseId, testCaseName, holdingId);
	}
}
