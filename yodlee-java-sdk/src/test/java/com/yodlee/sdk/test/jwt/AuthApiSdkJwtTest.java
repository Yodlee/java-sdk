/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.jwt;

import org.databene.benerator.anno.Source;
import org.testng.annotations.Test;
import com.yodlee.sdk.api.AuthApi;
import com.yodlee.sdk.test.AuthApiSdkTest;

public class AuthApiSdkJwtTest extends AbstractSdkJWTCobrandTestSuite {
	
	private final AuthApi authApi = new AuthApi();
	
	public AuthApiSdkJwtTest() {
		authApi.setContext(AbstractSdkJWTCobrandTestSuite.setup());
	}
	
	@Test(enabled = true)
	public void deleteToken() {
		AuthApiSdkTest.deleteTokenTest(authApi, "1", "delete auth token");
		System.out.println("Creating new jwt token and setting it to context");
		authApi.setContext(AbstractSdkJWTCobrandTestSuite.setup());
		System.out.println("Created new jwt token");
	}
	
	@Test(enabled = true)
	public void getApiKeys() {
		AuthApiSdkTest.getApiKeysTest(authApi, "1", "get all apiKeys");
	}
	
	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Auth\\generateApiKey.csv")
	public void generateApiKey(String testCaseId, String testCaseName, String fileName, String enabled) {
		AuthApiSdkTest.generateApiKeyTest(authApi, testCaseId, testCaseName, fileName);
	}
	
	@Test(enabled = false, dataProvider = "feeder")
	@Source("\\Auth\\deleteApiKey.csv")
	public void deleteApiKey(String testCaseId, String testCaseName, String fileName, String enabled) {
		AuthApiSdkTest.deleteApiKeyTest(authApi, testCaseId, testCaseName, fileName);
	}
}
