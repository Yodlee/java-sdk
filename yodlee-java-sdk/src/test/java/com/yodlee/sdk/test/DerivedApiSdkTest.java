/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.yodlee.api.model.derived.response.DerivedHoldingSummaryResponse;
import com.yodlee.api.model.derived.response.DerivedNetworthResponse;
import com.yodlee.api.model.derived.response.DerivedTransactionSummaryResponse;
import com.yodlee.api.model.enums.Container;
import com.yodlee.sdk.api.ApiConstants;
import com.yodlee.sdk.api.DerivedApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.validators.DerivedValidator.CategoryType;
import com.yodlee.sdk.api.validators.DerivedValidator.DataPointInterval;
import com.yodlee.sdk.api.validators.DerivedValidator.DerivedInclude;
import com.yodlee.sdk.api.validators.DerivedValidator.GroupType;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.test.utils.PrintUtil;

public class DerivedApiSdkTest {

	public static void TestGetTransactionSummary(DerivedApi derivedApi, String testCaseId, String testCaseName,
			String groupBy, String accountId, String categoryId, String categoryType, String fromDate, String include,
			Boolean includeUserCategory, String interval, String toDate) {
		try {
			Date fdate = new SimpleDateFormat(ApiConstants.YYYY_MM_DD).parse(fromDate);
			Date tdate = new SimpleDateFormat(ApiConstants.YYYY_MM_DD).parse(toDate);
			List<CategoryType> categoryTypes = new ArrayList<CategoryType>();
			categoryTypes.add(CategoryType.valueOf(categoryType));
			List<Long> accountIds = new ArrayList<Long>();
			List<Long> categoryIds = new ArrayList<Long>();
			ApiResponse<DerivedTransactionSummaryResponse> derivedResponse = derivedApi.getTransactionSummary(
					GroupType.valueOf(groupBy), accountIds.toArray(new Long[0]), categoryIds.toArray(new Long[0]),
					categoryTypes.toArray(new CategoryType[0]), fdate, DerivedInclude.valueOf(include),
					includeUserCategory, DataPointInterval.valueOf(interval), tdate);
			assertEquals(derivedResponse.getStatusCode(), 200);
			assertNotNull(derivedResponse.getData());
		} catch (ApiException | ParseException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void TestGetHoldingSummary(DerivedApi derivedApi, String testCaseId, String testCaseName,
			String accountId, String classificationType, String include) {
		try {
			List<Long> accountIds = new ArrayList<Long>();
			ApiResponse<DerivedHoldingSummaryResponse> derivedResponse = derivedApi.getHoldingSummary(
					accountIds.toArray(new Long[0]), classificationType, DerivedInclude.valueOf(include));
			assertEquals(derivedResponse.getStatusCode(), 200);
			assertNotNull(derivedResponse.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void TestGetNetworth(DerivedApi derivedApi, String testCaseId, String testCaseName, String accountId,
			String fromDate, String include, String interval, Integer skip, String toDate, Integer top,
			String container) {
		try {
			Date fdate = new SimpleDateFormat(ApiConstants.YYYY_MM_DD).parse(fromDate);
			Date tdate = new SimpleDateFormat(ApiConstants.YYYY_MM_DD).parse(toDate);
			Container networthContainer = StringUtils.isEmpty(container) ? null : Container.valueOf(container);
			List<Long> accountIds = new ArrayList<Long>();
			ApiResponse<DerivedNetworthResponse> derivedResponse =
					derivedApi.getNetworth(accountIds.toArray(new Long[0]), fdate, DerivedInclude.valueOf(include),
							DataPointInterval.valueOf(interval), skip, tdate, top, networthContainer);
			assertEquals(derivedResponse.getStatusCode(), 200);
			assertNotNull(derivedResponse.getData());
		} catch (ApiException | ParseException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
}
