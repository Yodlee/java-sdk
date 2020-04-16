/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.lang3.StringUtils;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.user.request.UpdateUserRequest;
import com.yodlee.api.model.user.request.UserRequest;
import com.yodlee.api.model.user.response.UserAccessTokensResponse;
import com.yodlee.api.model.user.response.UserDetailResponse;
import com.yodlee.api.model.user.response.UserResponse;
import com.yodlee.sdk.api.UserApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.client.ApiCallbackAdapter;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.test.utils.ModelUtil;
import com.yodlee.sdk.test.utils.PrintUtil;

public class UserApiSdkTest {

	public static void testGetUserDetails(UserApi userApi) {
		try {
			ApiResponse<UserDetailResponse> user = userApi.getUser();
			assertEquals(user.getStatusCode(), 200);
			assertNotNull(user.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail("test case 1", "Get User Details", e);
		}
	}

	public static void registerUser(UserApi userApi, String testCaseId, String testCaseName, String requestModelFile) {
		try {
			UserRequest userRequest = ModelUtil.load(requestModelFile, UserRequest.class);
			userRequest.getUser().setLoginName(userRequest.getUser().getLoginName() + System.currentTimeMillis());
			ApiResponse<UserResponse> user = userApi.registerUser(userRequest);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, user);
			assertEquals(user.getStatusCode(), 200);
			assertNotNull(user.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
	
	public static void registerUserAsync(UserApi userApi, String testCaseId, String testCaseName, String requestModelFile) {
		try {
			final CountDownLatch latch = new CountDownLatch(1);
			UserRequest userRequest = ModelUtil.load(requestModelFile, UserRequest.class);
			userRequest.getUser().setLoginName(userRequest.getUser().getLoginName() + System.currentTimeMillis());
			userApi.registerUserAsync(userRequest, new ApiCallbackAdapter<UserResponse>() {
				@Override
				public void onSuccess(UserResponse result, int statusCode, Map<String, List<String>> responseHeaders) {
					assertEquals(statusCode, 200);
					assertNotNull(result);
					latch.countDown();
				}
				
				@Override
				public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
					fail();
				}
			});
			latch.await();
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		} catch (Exception e) {
			e.printStackTrace();
			fail("oopss" , e);
		}
	}

	public static void testGetAccessTokens(UserApi userApi, String testCaseId, String testCaseName, String appIds) {
		try {
			Long[] appIdsValue = StringUtils.isEmpty(appIds) ? null : convertstringtoLongArray(appIds);
			ApiResponse<UserAccessTokensResponse> response = userApi.getAccessTokens(appIdsValue);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, response);
			assertEquals(response.getStatusCode(), 200);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void testUpdateUserDetails(UserApi userApi, String testCaseId, String testCaseName,
			String requestModelFile) {
		try {
			UpdateUserRequest updateUserRequest = ModelUtil.load(requestModelFile, UpdateUserRequest.class);
			ApiResponse<AbstractModelComponent> user = userApi.updateUser(updateUserRequest);
			assertEquals(user.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void logoutUser(UserApi userApi, String testCaseId, String testCaseName, String requestModelFile) {
		try {
			UserRequest userRequest = ModelUtil.load(requestModelFile, UserRequest.class);
			userRequest.getUser().setLoginName(userRequest.getUser().getLoginName() + System.currentTimeMillis());
			ApiResponse<UserResponse> user = userApi.registerUser(userRequest);
			assertEquals(user.getStatusCode(), 200);
			//
			ApiResponse<AbstractModelComponent> userLogout = userApi.userLogout();
			assertEquals(userLogout.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
	
	private static Long[] convertstringtoLongArray(String param) {
		String[] stringArray = param.split(",");
		Long[] value = new Long[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			value[i] = Long.valueOf(stringArray[i]);
		}
		return value;
	}
}
