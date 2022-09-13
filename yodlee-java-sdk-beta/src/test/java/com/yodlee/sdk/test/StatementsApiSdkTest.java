/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import com.yodlee.api.model.account.enums.ItemAccountStatus;
import com.yodlee.api.model.enums.Container;
import com.yodlee.api.model.statement.response.StatementResponse;
import com.yodlee.sdk.api.ApiConstants;
import com.yodlee.sdk.api.StatementsApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.test.utils.PrintUtil;

public class StatementsApiSdkTest {

	public static void getStatmentsTest(StatementsApi statementsApi, String testCaseId, String testCaseName,
			String accountId, String container, String fromDate, String isLatest, String status) {
		try {
			Container statementContainer = StringUtils.isEmpty(container) ? null : Container.valueOf(container);
			ItemAccountStatus accountStatus = StringUtils.isEmpty(status) ? null : ItemAccountStatus.valueOf(status);
			Boolean isLatestStatement = StringUtils.isEmpty(isLatest) ? null : Boolean.valueOf(isLatest);
			Long statementAccountId = StringUtils.isEmpty(accountId) ? null : Long.parseLong(accountId);
			Date fromDateValue = StringUtils.isEmpty(fromDate) ? null : new Date(Long.parseLong(fromDate) * 1000L);
			ApiResponse<StatementResponse> statements = statementsApi.getStatements(statementAccountId,
					statementContainer, fromDateValue, isLatestStatement, accountStatus);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, statements);
			assertEquals(statements.getStatusCode(), 200);
			assertNotNull(statements);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void getStatmentsTestwithGzip(StatementsApi statementsApi, String testCaseId, String testCaseName,
			String accountId, String container, String fromDate, String isLatest, String status) {
		try {
			Container statementContainer = StringUtils.isEmpty(container) ? null : Container.valueOf(container);
			ItemAccountStatus accountStatus = StringUtils.isEmpty(status) ? null : ItemAccountStatus.valueOf(status);
			Boolean isLatestStatement = StringUtils.isEmpty(isLatest) ? null : Boolean.valueOf(isLatest);
			Long statementAccountId = StringUtils.isEmpty(accountId) ? null : Long.parseLong(accountId);
			Date fromDateValue = StringUtils.isEmpty(fromDate) ? null : new Date(Long.parseLong(fromDate) * 1000L);
			// Creating an empty HashMap
			Map<String, String> map = new HashMap<>();
			map.put(ApiConstants.ACCEPT_ENCODING, "gzip");
			ApiResponse<StatementResponse> statements = statementsApi.getStatements(statementAccountId,
					statementContainer, fromDateValue, isLatestStatement, accountStatus, map);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, statements);
			assertEquals(statements.getStatusCode(), 200);
			assertNotNull(statements);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
}
