/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.clientcredential;

import java.io.IOException;
import org.databene.benerator.anno.Source;
import org.testng.annotations.Test;
import com.yodlee.sdk.api.UserApi;
import com.yodlee.sdk.test.UserApiSdkTest;

public class UserApiSdkClientCredentialAppTokenTest extends AbstractSdkClientCredentialAppTestSuite {

	private final UserApi userApi = new UserApi(null);

	public UserApiSdkClientCredentialAppTokenTest() {
		userApi.setContext(AbstractSdkClientCredentialAppTestSuite.setup());
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\User\\registerUser.csv")
	public void registerUserUsingPOSTTest(String testCaseId, String testCaseName, String requestModelFile,
			String enabled) throws IOException {
		UserApiSdkTest.registerUser(userApi, testCaseId, testCaseName, requestModelFile);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\User\\registerUser.csv")
	public void registerUserUsingPOSTAsyncTest(String testCaseId, String testCaseName, String requestModelFile,
			String enabled) throws IOException {
		UserApiSdkTest.registerUserAsync(userApi, testCaseId, testCaseName, requestModelFile);
	}
}
