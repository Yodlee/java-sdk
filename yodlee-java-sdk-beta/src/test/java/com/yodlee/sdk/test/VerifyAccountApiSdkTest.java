/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test;

import static org.testng.Assert.assertEquals;
import com.yodlee.api.model.verifyaccount.request.VerifyAccountRequest;
import com.yodlee.api.model.verifyaccount.response.VerifyAccountResponse;
import com.yodlee.sdk.api.VerifyAccountApi;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.test.utils.ModelUtil;
import com.yodlee.sdk.test.utils.PrintUtil;

public class VerifyAccountApiSdkTest {

	public static void getVerifyAccountUsingPOSTTest(VerifyAccountApi verifyAccountApi, String testCaseId,
			String testCaseName, String fileName, Long providerAccountId) {
		try {
			VerifyAccountRequest verifyAccountRequest = ModelUtil.load(fileName, VerifyAccountRequest.class);
			ApiResponse<VerifyAccountResponse> verifyAccountsResponse =
					verifyAccountApi.verifyAccounts(providerAccountId, verifyAccountRequest);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, verifyAccountsResponse);
			assertEquals(verifyAccountsResponse.getStatusCode(), 200);
		} catch (Exception e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
}
