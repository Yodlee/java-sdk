/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Field;
import com.yodlee.api.model.provideraccounts.request.ProviderAccountPreferencesRequest;
import com.yodlee.api.model.provideraccounts.request.ProviderAccountRequest;
import com.yodlee.api.model.provideraccounts.request.RefreshProviderAccountRequest;
import com.yodlee.api.model.provideraccounts.response.AddedProviderAccountResponse;
import com.yodlee.api.model.provideraccounts.response.ProviderAccountDetailResponse;
import com.yodlee.api.model.provideraccounts.response.ProviderAccountResponse;
import com.yodlee.api.model.provideraccounts.response.ProviderAccountUserProfileResponse;
import com.yodlee.api.model.provideraccounts.response.UpdatedProviderAccountResponse;
import com.yodlee.sdk.api.ApiConstants;
import com.yodlee.sdk.api.ProviderAccountsApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.validators.ProviderAccountsValidator.ProviderAccountDetailsInclude;
import com.yodlee.sdk.api.validators.ProviderAccountsValidator.ProviderAccountInclude;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.test.utils.ModelUtil;
import com.yodlee.sdk.test.utils.PrintUtil;

public class ProviderAccountsApiSdkTest {

	public static void deleteProviderAccountTest(ProviderAccountsApi providerAccountsApi, String testCaseId,
			String testCaseName, Long providerAccountId) {
		try {
			ApiResponse<AbstractModelComponent> providerAccountsResponse =
					providerAccountsApi.deleteProviderAccount(providerAccountId);
			assertEquals(providerAccountsResponse.getStatusCode(), 200);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	
	public static void getProviderAccountTest(ProviderAccountsApi providerAccountsApi, String testCaseId,
			String testCaseName, Long providerAccountId, String include, String requestId) {
		try {
			ProviderAccountInclude includes[] = null;
			if (!StringUtils.isEmpty(include)) {
				String[] splitIncludes = include.split("#");
				includes = new ProviderAccountInclude[splitIncludes.length];
				for (int i = 0; i < splitIncludes.length; i++) {
					includes[i] = ProviderAccountInclude.valueOf(splitIncludes[i]);
				}
			}
			ApiResponse<ProviderAccountDetailResponse> providerAccountsResponse =
					providerAccountsApi.getProviderAccount(providerAccountId, includes, requestId);
			assertEquals(providerAccountsResponse.getStatusCode(), 200);
			assertNotNull(providerAccountsResponse.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
	
	public static void getProviderAccountTestwithGzip(ProviderAccountsApi providerAccountsApi, String testCaseId,
			String testCaseName, Long providerAccountId, String include, String requestId) {
		try {
			ProviderAccountInclude includes[] = null;
			if (!StringUtils.isEmpty(include)) {
				String[] splitIncludes = include.split("#");
				includes = new ProviderAccountInclude[splitIncludes.length];
				for (int i = 0; i < splitIncludes.length; i++) {
					includes[i] = ProviderAccountInclude.valueOf(splitIncludes[i]);
				}
			}
			
			  // Creating an empty HashMap
			Map<String, String> map = new HashMap<>();
	        map.put(ApiConstants.CONTENT_ENCODING, "gzip");
			ApiResponse<ProviderAccountDetailResponse> providerAccountsResponse =
					providerAccountsApi.getProviderAccount(providerAccountId, includes, requestId, map);
			assertEquals(providerAccountsResponse.getStatusCode(), 200);
			assertNotNull(providerAccountsResponse.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void getAllProviderAccountsTest(ProviderAccountsApi providerAccountsApi, String testCaseId,
			String testCaseName, String include, String providerIds) {
		try {
			Long[] ids = null;
			if (!StringUtils.isEmpty(providerIds)) {
				String[] splitIds = providerIds.split("#");
				ids = new Long[splitIds.length];
				for (int i = 0; i < splitIds.length; i++) {
					ids[i] = Long.parseLong(splitIds[i]);
				}
			}
			ApiResponse<ProviderAccountResponse> providerAccountsResponse =
					providerAccountsApi.getAllProviderAccounts(StringUtils.isEmpty(include) ? null //
							: ProviderAccountDetailsInclude.valueOf(include), ids);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, providerAccountsResponse);
			assertEquals(providerAccountsResponse.getStatusCode(), 200);
			assertNotNull(providerAccountsResponse.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
	
	public static void getAllProviderAccountsTestwithGzip(ProviderAccountsApi providerAccountsApi, String testCaseId,
			String testCaseName, String include, String providerIds) {
		try {
			Long[] ids = null;
			if (!StringUtils.isEmpty(providerIds)) {
				String[] splitIds = providerIds.split("#");
				ids = new Long[splitIds.length];
				for (int i = 0; i < splitIds.length; i++) {
					ids[i] = Long.parseLong(splitIds[i]);
				}
			}
			
			  // Creating an empty HashMap
			Map<String, String> map = new HashMap<>();
	        map.put(ApiConstants.CONTENT_ENCODING, "gzip");
	        
			ApiResponse<ProviderAccountResponse> providerAccountsResponse =
					providerAccountsApi.getAllProviderAccounts(StringUtils.isEmpty(include) ? null //
							: ProviderAccountDetailsInclude.valueOf(include), ids, map);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, providerAccountsResponse);
			assertEquals(providerAccountsResponse.getStatusCode(), 200);
			assertNotNull(providerAccountsResponse.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void linkProviderAccountTest(ProviderAccountsApi providerAccountsApi, String testCaseId,
			String testCaseName, long providerId, String fileName) {
		try {
			ProviderAccountRequest providerAccountRequest = ModelUtil.load(fileName, ProviderAccountRequest.class);
			ApiResponse<AddedProviderAccountResponse> providerAccountsResponse =
					providerAccountsApi.linkCredentialProviderAccount(providerAccountRequest, providerId);
			assertEquals(providerAccountsResponse.getStatusCode(), 201);
			assertNotNull(providerAccountsResponse.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void getProviderAccountProfilesTest(ProviderAccountsApi providerAccountsApi, String testCaseId,
			String testCaseName, String providerAccountId) {
		try {
			Long[] ids = null;
			if (!StringUtils.isEmpty(providerAccountId)) {
				String[] splitIds = providerAccountId.split("#");
				ids = new Long[splitIds.length];
				for (int i = 0; i < splitIds.length; i++) {
					ids[i] = Long.parseLong(splitIds[i]);
				}
			}
			ApiResponse<ProviderAccountUserProfileResponse> providerAccountsResponse =
					providerAccountsApi.getProviderAccountProfile(ids);
			assertEquals(providerAccountsResponse.getStatusCode(), 200);
			assertNotNull(providerAccountsResponse.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void updatePreferencesTest(ProviderAccountsApi providerAccountsApi, String testCaseId,
			String testCaseName, String fileName, Long providerAccountId) {
		try {
			ProviderAccountPreferencesRequest preferences =
					ModelUtil.load(fileName, ProviderAccountPreferencesRequest.class);
			ApiResponse<AbstractModelComponent> providerAccountsResponse =
					providerAccountsApi.updatePreferences(preferences, providerAccountId);
			assertEquals(providerAccountsResponse.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void refreshProviderAccountTest(ProviderAccountsApi providerAccountsApi, String testCaseId,
			String testCaseName, String providerAccountId, String fileName) {
		RefreshProviderAccountRequest providerAccountRequest = ModelUtil.load(fileName,
				RefreshProviderAccountRequest.class);
		try {
			ApiResponse<UpdatedProviderAccountResponse> providerAccountsResponse = providerAccountsApi
					.refreshProviderAccount(providerAccountId != null ? Long.parseLong(providerAccountId) : null, providerAccountRequest);
			assertEquals(providerAccountsResponse.getStatusCode(), 200);
			assertNotNull(providerAccountsResponse.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void refreshAllProviderAccountsTest(ProviderAccountsApi providerAccountsApi, String testCaseId,
			String testCaseName, String providerAccountIds, String fileName) {
		try {
			ApiResponse<UpdatedProviderAccountResponse> providerAccountsResponse =
					providerAccountsApi.refreshAllProviderAccounts();
			assertEquals(providerAccountsResponse.getStatusCode(), 200);
			assertNotNull(providerAccountsResponse.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void updateProviderAccount(ProviderAccountsApi providerAccountsApi, String testCaseId,
			String testCaseName, String providerAccountId, String fileName) {
		ProviderAccountRequest providerAccountRequest = ModelUtil.load(fileName, ProviderAccountRequest.class);
		try {
			ApiResponse<UpdatedProviderAccountResponse> providerAccountsResponse =
					providerAccountsApi.editProviderAccountCredentials(
							providerAccountId != null ? Long.parseLong(providerAccountId) : null,
							providerAccountRequest);
			assertEquals(providerAccountsResponse.getStatusCode(), 200);
			assertNotNull(providerAccountsResponse.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void updateMFA(ProviderAccountsApi providerAccountsApi, String testCaseId, String testCaseName,
			String providerAccountId, String fileName) {
		ProviderAccountRequest providerAccountRequest = ModelUtil.load(fileName, ProviderAccountRequest.class);
		try {
			ApiResponse<UpdatedProviderAccountResponse> providerAccountsResponse = providerAccountsApi
					.submitProviderAccountMFA(providerAccountId != null ? Long.parseLong(providerAccountId) : null,
							providerAccountRequest.getField().toArray(new Field[0]));
			assertEquals(providerAccountsResponse.getStatusCode(), 200);
			assertNotNull(providerAccountsResponse.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
}
