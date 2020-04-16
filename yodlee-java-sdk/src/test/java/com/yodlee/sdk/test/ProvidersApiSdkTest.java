/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.lang3.StringUtils;
import com.yodlee.api.model.providers.response.ProviderDetailResponse;
import com.yodlee.api.model.providers.response.ProviderResponse;
import com.yodlee.api.model.providers.response.ProvidersCountResponse;
import com.yodlee.sdk.api.ProvidersApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.validators.ProvidersValidator.ProvidersCapability;
import com.yodlee.sdk.api.validators.ProvidersValidator.ProvidersPriorityType;
import com.yodlee.sdk.client.ApiCallbackAdapter;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.test.utils.PrintUtil;

public class ProvidersApiSdkTest {

	public static void getAllProvidersTest(ProvidersApi providersapi, String testCaseId, String testCaseName,
			String capability, String datasetFilter, String name, String priority, Integer skip, Integer top) {
		try {
			ApiResponse<ProviderResponse> providerResponse = providersapi.getAllProviders(
					StringUtils.isEmpty(capability) ? null : ProvidersCapability.valueOf(capability.toUpperCase()),
					datasetFilter, name,
					StringUtils.isEmpty(priority) ? null : ProvidersPriorityType.valueOf(priority.toUpperCase()), skip,
					top);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, providerResponse);
			assertEquals(providerResponse.getStatusCode(), 200);
			assertNotNull(providerResponse.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void getAllProvidersAsyncTest(ProvidersApi providersapi, String testCaseId, String testCaseName,
			String capability, String datasetFilter, String name, String priority, Integer skip, Integer top) {
		try {
			final CountDownLatch latch = new CountDownLatch(1);
			providersapi.getAllProvidersAsync(
					StringUtils.isEmpty(capability) ? null : ProvidersCapability.valueOf(capability.toUpperCase()),
					datasetFilter, name,
					StringUtils.isEmpty(priority) ? null : ProvidersPriorityType.valueOf(priority.toUpperCase()), skip,
					top, new ApiCallbackAdapter<ProviderResponse>() {

						@Override
						public void onSuccess(ProviderResponse result, int statusCode,
								Map<String, List<String>> responseHeaders) {
							super.onSuccess(result, statusCode, responseHeaders);
							assertEquals(statusCode, 200);
							assertNotNull(result);
							latch.countDown();
						}
					});
			latch.await();
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getProviderTest(ProvidersApi providersapi, String testCaseId, String testCaseName,
			Long providerId) {
		try {
			ApiResponse<ProviderDetailResponse> providerResponse = providersapi.getProvider(providerId);
			assertEquals(providerResponse.getStatusCode(), 200);
			assertNotNull(providerResponse.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void GetProvidersCountTest(ProvidersApi providersapi, String testCaseId, String testCaseName,
			String capability, String datasetFilter, String name, String priority) {
		try {
			ApiResponse<ProvidersCountResponse> providerResponse = providersapi.getProvidersCount(
					StringUtils.isEmpty(capability) ? null : ProvidersCapability.valueOf(capability.toUpperCase()),
					datasetFilter, name,
					StringUtils.isEmpty(priority) ? null : ProvidersPriorityType.valueOf(priority.toUpperCase()));
			PrintUtil.printJSONResponse(testCaseId, testCaseName, providerResponse);
			assertEquals(providerResponse.getStatusCode(), 200);
			assertNotNull(providerResponse.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
}
