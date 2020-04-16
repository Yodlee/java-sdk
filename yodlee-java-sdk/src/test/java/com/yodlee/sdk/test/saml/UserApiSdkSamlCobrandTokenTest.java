/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.saml;

import java.io.IOException;
import org.databene.benerator.anno.Source;
import org.testng.annotations.Test;
import com.yodlee.sdk.api.UserApi;
import com.yodlee.sdk.test.UserApiSdkTest;

public class UserApiSdkSamlCobrandTokenTest extends AbstractSdkSAMLCobrandTestSuite {

	private final UserApi userApi = new UserApi(null);

	public UserApiSdkSamlCobrandTokenTest() {
		userApi.setContext(UserApiSdkSamlCobrandTokenTest.setup());
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\User\\registerUser.csv")
	public void registerUserUsingPOSTTest(String testCaseId, String testCaseName, String requestModelFile,
			String enabled) throws IOException {
		UserApiSdkTest.registerUser(userApi, testCaseId, testCaseName, requestModelFile);
	}
}
