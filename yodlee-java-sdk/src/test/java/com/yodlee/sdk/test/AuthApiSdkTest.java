/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test;

import static org.testng.Assert.assertEquals;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.auth.request.ApiKeyRequest;
import com.yodlee.api.model.auth.response.ApiKeyResponse;
import com.yodlee.sdk.api.AuthApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.test.utils.ModelUtil;
import com.yodlee.sdk.test.utils.PrintUtil;

public class AuthApiSdkTest {

	public static void deleteTokenTest(AuthApi authApi, String testCaseId, String testCaseName) {
		try {
			ApiResponse<AbstractModelComponent> deleteToken = authApi.deleteToken();
			PrintUtil.printJSONResponse(testCaseId, testCaseName, deleteToken);
			assertEquals(deleteToken.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void getApiKeysTest(AuthApi authApi, String testCaseId, String testCaseName) {
		try {
			ApiResponse<ApiKeyResponse> apiKeys = authApi.getApiKeys();
			PrintUtil.printJSONResponse(testCaseId, testCaseName, apiKeys);
			assertEquals(apiKeys.getStatusCode(), 200);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void generateApiKeyTest(AuthApi authApi, String testCaseId, String testCaseName, String fileName) {
		try {
			ApiKeyRequest apiKeyRequest = ModelUtil.load(fileName, ApiKeyRequest.class);
			ApiResponse<ApiKeyResponse> apiKeys = authApi.generateApiKey(apiKeyRequest);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, apiKeys);
			assertEquals(apiKeys.getStatusCode(), 200);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void deleteApiKeyTest(AuthApi authApi, String testCaseId, String testCaseName, String fileName) {
		try {
			ApiKeyRequest apiKeyRequest = ModelUtil.load(fileName, ApiKeyRequest.class);
			ApiResponse<ApiKeyResponse> apiKeys = authApi.generateApiKey(apiKeyRequest);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, apiKeys);
			// New key generated
			String apiKey = apiKeys.getData().getApiKeyList().get(0).getKey();
			//
			ApiResponse<AbstractModelComponent> deleteApiKey = authApi.deleteApiKey(apiKey);
			assertEquals(deleteApiKey.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
}
