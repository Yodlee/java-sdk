/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.jwt;

import org.databene.benerator.anno.Source;
import org.testng.annotations.Test;
import com.yodlee.sdk.api.UserApi;
import com.yodlee.sdk.test.UserApiSdkTest;

public class UserApiSdkJwtUserTokenTest extends AbstractSdkJWTUserTestSuite {

	private final UserApi userApi = new UserApi(null);

	public UserApiSdkJwtUserTokenTest() {
		userApi.setContext(AbstractSdkJWTUserTestSuite.setup());
	}

	@Test(enabled = true)
	public void userDetailUsingGETTest() {
		UserApiSdkTest.testGetUserDetails(userApi);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("User\\updateUser.csv")
	public void updateUserDetailsUsingPUTTest(String testCaseId, String testCaseName, String requestModelFile,
			String enabled) {
		UserApiSdkTest.testUpdateUserDetails(userApi, testCaseId, testCaseName, requestModelFile);
	}
}
