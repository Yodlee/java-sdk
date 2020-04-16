/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.jwt;

import org.databene.benerator.anno.Source;
import org.testng.annotations.Test;
import com.yodlee.sdk.api.HoldingsApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.test.HoldingsApiSdkTest;

public class HoldingsApiSdkJwtCobrandTokenTest extends AbstractSdkJWTCobrandTestSuite {
	
	private static final HoldingsApi holdingsApi = new HoldingsApi(null);

	public HoldingsApiSdkJwtCobrandTokenTest() throws ApiException {
		holdingsApi.setContext(AbstractSdkJWTCobrandTestSuite.setup());
	}
	
	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Holdings\\getHoldingTypeList.csv")
	public void getHoldingTypeList(String testCaseId, String testCaseName,String enabled) {
		HoldingsApiSdkTest.getHoldingTypeListTest(holdingsApi, testCaseId, testCaseName);
	}
	
	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Holdings\\getAssetClassificationList.csv")
	public void getAssetClassificationList(String testCaseId, String testCaseName,String enabled) {
		HoldingsApiSdkTest.getAssetClassificationList(holdingsApi, testCaseId, testCaseName);
	}
}
