/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.saml;

import org.databene.benerator.anno.Source;
import org.testng.annotations.Test;
import com.yodlee.api.model.verification.enums.VerificationType;
import com.yodlee.sdk.api.VerificationApi;
import com.yodlee.sdk.test.VerificationApiSdkTest;

public class VerificationApiSdkSamlTest extends AbstractSdkSAMLUserTestSuite {

	private final VerificationApi verificationApi = new VerificationApi(null);

	public VerificationApiSdkSamlTest() {
		verificationApi.setContext(AbstractSdkSAMLUserTestSuite.setup());
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Verification\\getVerificationStatus.csv")
	public void getVericationUsingGETTest(String testCaseId, String testCaseName, String providerAccountId,
			String accountId, VerificationType verificationType) {
		VerificationApiSdkTest.getVerificationUsingGETTest(verificationApi, testCaseId, testCaseName, providerAccountId,
				accountId, verificationType);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Verification\\postCDV.csv")
	public void getVericationUsingGETTest(String testCaseId, String testCaseName, String fileName) {
		VerificationApiSdkTest.processCDVUsingPOSTTest(verificationApi, testCaseId, testCaseName, fileName);
	}
	

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Verification\\postMatchingVerification.csv")
	public void processMatchingTest(String testCaseId, String testCaseName, String fileName) {
		VerificationApiSdkTest.processMatchingUsingPOSTTest(verificationApi, testCaseId, testCaseName, fileName);
	}
}
