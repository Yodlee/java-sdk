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
import java.util.Date;
import java.util.TimeZone;
import com.yodlee.api.model.dataextracts.response.DataExtractsEventResponse;
import com.yodlee.api.model.dataextracts.response.DataExtractsUserDataResponse;
import com.yodlee.sdk.api.ApiConstants;
import com.yodlee.sdk.api.DataExtractsApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.validators.DataExtractsValidator.DataExtractsEventType;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.test.utils.PrintUtil;

public class DataExtractsApiSdkTest {

	public static void testGetDataExtractsEvents(DataExtractsApi dataExtractsApi, String testCaseId,
			String testCaseName, String eventName, String fromDate, String toDate) {
		try {
			Date fdate = new SimpleDateFormat(ApiConstants.YYYY_MM_DD_T_HH_MM_SS_Z).parse(fromDate);
			Date tdate = new SimpleDateFormat(ApiConstants.YYYY_MM_DD_T_HH_MM_SS_Z).parse(toDate);
			ApiResponse<DataExtractsEventResponse> eventsResponse =
					dataExtractsApi.getDataExtractsEvents(DataExtractsEventType.valueOf(eventName), fdate, tdate);
			assertEquals(eventsResponse.getStatusCode(), 200);
			assertNotNull(eventsResponse.getData());
		} catch (ApiException | ParseException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void testGetUserData(DataExtractsApi dataExtractsApi, String testCaseId, String testCaseName,
			String fromDate, String loginName, String toDate) {
		try {
			testUTCDate(getDate(fromDate), fromDate);
			testUTCDate(getDate(toDate), toDate);
			Date fdate = new SimpleDateFormat(ApiConstants.YYYY_MM_DD_T_HH_MM_SS_Z).parse(fromDate);
			Date tdate = new SimpleDateFormat(ApiConstants.YYYY_MM_DD_T_HH_MM_SS_Z).parse(toDate);
			ApiResponse<DataExtractsUserDataResponse> userDataResponse =
					dataExtractsApi.getDataExtractsUserData(fdate, loginName, tdate, null, null, toDate);
			assertEquals(userDataResponse.getStatusCode(), 200);
			assertNotNull(userDataResponse.getData());
		} catch (ApiException | ParseException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	private static String testUTCDate(Date fDate, String expectedDate) {
		String fdate = null;
		SimpleDateFormat sdf = new SimpleDateFormat(ApiConstants.YYYY_MM_DD_T_HH_MM_SS_Z);
		//If the below line is commented, the test case will fail.
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		fdate = sdf.format(fDate);
		assertEquals(fdate, expectedDate);
		return fdate;
	}

	private static Date getDate(String fromDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(ApiConstants.YYYY_MM_DD_T_HH_MM_SS_Z);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		return sdf.parse(fromDate);
	}

	public static void main(String[] args) throws ParseException {
		String fromDate = "2017-02-20T10:18:44Z";
		testUTCDate(getDate(fromDate), fromDate);
	}
}
