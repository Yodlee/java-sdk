/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.apache.commons.lang3.StringUtils;
import com.yodlee.api.model.holdings.response.HoldingAssetClassificationListResponse;
import com.yodlee.api.model.holdings.response.HoldingResponse;
import com.yodlee.api.model.holdings.response.HoldingSecuritiesResponse;
import com.yodlee.api.model.holdings.response.HoldingTypeListResponse;
import com.yodlee.sdk.api.HoldingsApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.validators.HoldingsValidator.HoldingInclude;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.test.utils.PrintUtil;

public class HoldingsApiSdkTest {

	public static void getHoldingsTest(HoldingsApi holdingsapi, String testCaseId, String testCaseName,
			String accountId, String assetClassificationClassificationType, String classificationValue, String include,
			Long providerAccountId) {
		try {
			Long[] ids = null;
			if (!StringUtils.isEmpty(accountId)) {
				String[] splitIds = accountId.split("#");
				ids = new Long[splitIds.length];
				for (int i = 0; i < splitIds.length; i++) {
					ids[i] = Long.parseLong(splitIds[i]);
				}
			}
			ApiResponse<HoldingResponse> holdingsResponse =
					holdingsapi.getHoldings(ids, assetClassificationClassificationType,//
							classificationValue, StringUtils.isEmpty(include) ? null : HoldingInclude.valueOf(include),
							providerAccountId);
			assertEquals(holdingsResponse.getStatusCode(), 200);
			assertNotNull(holdingsResponse.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void getHoldingTypeListTest(HoldingsApi holdingsapi, String testCaseId, String testCaseName) {
		try {
			ApiResponse<HoldingTypeListResponse> holdingsResponse = holdingsapi.getHoldingTypeList();
			assertEquals(holdingsResponse.getStatusCode(), 200);
			assertNotNull(holdingsResponse.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void getAssetClassificationList(HoldingsApi holdingsapi, String testCaseId, String testCaseName) {
		try {
			ApiResponse<HoldingAssetClassificationListResponse> holdingsResponse =
					holdingsapi.getAssetClassificationList();
			assertEquals(holdingsResponse.getStatusCode(), 200);
			assertNotNull(holdingsResponse.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void getSecuritiesTest(HoldingsApi holdingsApi, String testCaseId, String testCaseName,
			String holdingId) {
		try {
			Long[] ids = null;
			if (!StringUtils.isEmpty(holdingId)) {
				String[] splitIds = holdingId.split("#");
				ids = new Long[splitIds.length];
				for (int i = 0; i < splitIds.length; i++) {
					ids[i] = Long.parseLong(splitIds[i]);
				}
			}
			ApiResponse<HoldingSecuritiesResponse> holdingsResponse = holdingsApi.getSecurities(ids);
			assertEquals(holdingsResponse.getStatusCode(), 200);
			assertNotNull(holdingsResponse.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
}
