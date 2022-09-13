/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import org.apache.commons.lang3.StringUtils;

import com.yodlee.api.model.account.response.AccountBalanceResponse;
import com.yodlee.api.model.verification.enums.VerificationType;
import com.yodlee.api.model.verification.enums.VerifiedAccountsVerificationStatus;
import com.yodlee.api.model.verification.request.UpdateVerificationRequest;
import com.yodlee.api.model.verification.request.VerificationMatchingRequest;
import com.yodlee.api.model.verification.request.VerificationRequest;
import com.yodlee.api.model.verification.response.VerificationResponse;
import com.yodlee.api.model.verification.response.VerificationStatusResponse;
import com.yodlee.api.model.verification.response.VerifiedAccountResponse;
import com.yodlee.sdk.api.VerificationApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.test.utils.ModelUtil;
import com.yodlee.sdk.test.utils.PrintUtil;
import junit.framework.Assert;

public class VerificationApiSdkTest {

	public static void getVerificationUsingGETTest(VerificationApi verificationApi, String testCaseId,
			String testCaseName, String providerAccountId, String accountId, VerificationType verificationType) {
		try {
			Long[] pIds = null;
			if (!StringUtils.isEmpty(providerAccountId)) {
				String[] splitIds = providerAccountId.split("#");
				pIds = new Long[splitIds.length];
				for (int i = 0; i < splitIds.length; i++) {
					pIds[i] = Long.parseLong(splitIds[i]);
				}
			}
			Long[] accIds = null;
			if (!StringUtils.isEmpty(accountId)) {
				String[] splitIds = accountId.split("#");
				accIds = new Long[splitIds.length];
				for (int i = 0; i < splitIds.length; i++) {
					accIds[i] = Long.parseLong(splitIds[i]);
				}
			}
			ApiResponse<VerificationStatusResponse> verificationStatusResponse =
					verificationApi.getVerificationDetails(accIds, pIds, verificationType);
			assertNotNull(verificationStatusResponse.getData());
		} catch (Exception e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void processCDVUsingPOSTTest(VerificationApi verificationApi, String testCaseId, String testCaseName,
			String fileName) {
		try {
			VerificationRequest verificationRequest = ModelUtil.load(fileName, VerificationRequest.class);
			ApiResponse<VerificationResponse> verificationResponse =
					verificationApi.initiateCDVerification(verificationRequest);
			Assert.assertNotNull(verificationResponse.getData());
		} catch (ApiException e) {
			assertEquals(e.getHttpStatus(), 400);
			assertTrue(e.getResponseBody().contains("Y800"));
		} catch (Exception e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void processMatchingUsingPOSTTest(VerificationApi verificationApi, String testCaseId,
			String testCaseName, String fileName) {
		try {
			VerificationMatchingRequest verificationRequest =
					ModelUtil.load(fileName, VerificationMatchingRequest.class);
			ApiResponse<VerificationResponse> verificationResponse =
					verificationApi.performMatchingVerification(verificationRequest);
			Assert.assertNotNull(verificationResponse.getData());
		} catch (ApiException e) {
			assertEquals(e.getHttpStatus(), 400);
			assertTrue(e.getResponseBody().contains("Y800"));
		} catch (Exception e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void processCDVUsingPUTTest(VerificationApi verificationApi, String testCaseId, String testCaseName,
			String fileName) {
		try {
			UpdateVerificationRequest verificationRequest = ModelUtil.load(fileName, UpdateVerificationRequest.class);
			ApiResponse<VerificationResponse> verificationResponse =
					verificationApi.performCDVerification(verificationRequest);
			Assert.assertNotNull(verificationResponse.getData());
		} catch (ApiException e) {
			assertEquals(e.getHttpStatus(), 400);
			assertTrue(e.getResponseBody().contains("Y800"));
		} catch (Exception e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
	
	public static void getVerifiedAccounts(VerificationApi verificationApi, String testCaseId, String testCaseName,  
			String providerAccountId, String accountId, String isSelected, String verificationStatus) {
		try {
			Long providerAccId = StringUtils.isEmpty(providerAccountId) ? null : Long.parseLong(providerAccountId);
			Long[] accountIdValue = StringUtils.isBlank(accountId) ? null : convertStringtoLongArray(accountId);
			VerifiedAccountsVerificationStatus[] status = StringUtils.isBlank(verificationStatus) ? null : convertStringtoStatusArray(verificationStatus);
			String[] selected = null;
			
			if (!StringUtils.isBlank(isSelected)) {
				String[] split =isSelected.split("#");
				selected = new String[split.length];
				for (int i = 0; i < split.length; i++) {
					selected[i] = split[i];
				}
			}
			
			ApiResponse<VerifiedAccountResponse> verifiedAccountsResponse =
					verificationApi.getVerifiedAccounts(providerAccId, accountIdValue, status, selected);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, verifiedAccountsResponse);
			assertEquals(verifiedAccountsResponse.getStatusCode(), 200);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
	
	private static Long[] convertStringtoLongArray(String param) {
		if (StringUtils.isBlank(param))
			return null;
		String[] stringArray = param.split("#");
		Long[] value = new Long[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			value[i] = Long.valueOf(stringArray[i]);
		}
		return value;
	}
	
	private static VerifiedAccountsVerificationStatus[] convertStringtoStatusArray(String param) {
		if (StringUtils.isBlank(param))
			return null;
		String[] stringArray = param.split("#");
		VerifiedAccountsVerificationStatus[] value = new VerifiedAccountsVerificationStatus[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			value[i] = VerifiedAccountsVerificationStatus.valueOf(stringArray[i]);
		}
		return value;
	}
}
