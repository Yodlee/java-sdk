/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.saml;

import org.databene.benerator.anno.Source;
import org.testng.annotations.Test;
import com.yodlee.sdk.api.VerifyAccountApi;
import com.yodlee.sdk.test.VerifyAccountApiSdkTest;

public class VerifyAccountApiSdkSamlTest extends AbstractSdkSAMLUserTestSuite {

	private final VerifyAccountApi verifyAccountApi = new VerifyAccountApi(null);

	public VerifyAccountApiSdkSamlTest() {
		verifyAccountApi.setContext(AbstractSdkSAMLUserTestSuite.setup());
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\VerifyAccount\\createVerifyAccount.csv")
	public void getVerifyAccountUsingPOSTTest(String testCaseId, String testCaseName, Long providerAccountId,
			String fileName) {
		VerifyAccountApiSdkTest.getVerifyAccountUsingPOSTTest(verifyAccountApi, testCaseId, testCaseName, fileName,
				providerAccountId);
	}
}
