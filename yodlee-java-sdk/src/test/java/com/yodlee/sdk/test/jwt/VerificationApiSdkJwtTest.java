/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.jwt;

import org.databene.benerator.anno.Source;
import org.testng.annotations.Test;
import com.yodlee.api.model.verification.enums.VerificationType;
import com.yodlee.sdk.api.VerificationApi;
import com.yodlee.sdk.test.VerificationApiSdkTest;

public class VerificationApiSdkJwtTest extends AbstractSdkJWTUserTestSuite {

	private final VerificationApi verificationApi = new VerificationApi(null);

	public VerificationApiSdkJwtTest() {
		verificationApi.setContext(AbstractSdkJWTUserTestSuite.setup());
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Verification\\getVerificationStatus.csv")
	public void getVericationUsingGETTest(String testCaseId, String testCaseName, String providerAccountId,
			String accountId, String verificationType) {
		VerificationApiSdkTest.getVerificationUsingGETTest(verificationApi, testCaseId, testCaseName, providerAccountId,
				accountId, VerificationType.MATCHING);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Verification\\postCDV.csv")
	public void processCDVTest(String testCaseId, String testCaseName, String fileName) {
		VerificationApiSdkTest.processCDVUsingPOSTTest(verificationApi, testCaseId, testCaseName, fileName);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Verification\\postMatchingVerification.csv")
	public void processMatchingTest(String testCaseId, String testCaseName, String fileName) {
		VerificationApiSdkTest.processMatchingUsingPOSTTest(verificationApi, testCaseId, testCaseName, fileName);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Verification\\putCDV.csv")
	public void processUpdateCDVTest(String testCaseId, String testCaseName, String fileName) {
		VerificationApiSdkTest.processCDVUsingPUTTest(verificationApi, testCaseId, testCaseName, fileName);
	}
}
