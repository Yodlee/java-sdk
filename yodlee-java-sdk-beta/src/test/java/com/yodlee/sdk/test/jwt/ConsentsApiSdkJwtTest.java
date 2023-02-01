/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.jwt;

import com.yodlee.sdk.api.IncludeConsentParam;
import org.databene.benerator.anno.Source;
import org.testng.annotations.Test;
import com.yodlee.sdk.api.ConsentsApi;
import com.yodlee.sdk.test.ConsentsApiSdkTest;

public class ConsentsApiSdkJwtTest  extends AbstractSdkJWTUserTestSuite {
	
	private final ConsentsApi consentsApi = new ConsentsApi(null);

	public ConsentsApiSdkJwtTest() {
		consentsApi.setContext(AbstractSdkJWTUserTestSuite.setup());
	}
	
	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Consents\\createConsents.csv")
	public void createConsentTest(String testCaseId, String testCaseName, String fileName, String enabled) {
		ConsentsApiSdkTest.createConsentTest(consentsApi, testCaseId, testCaseName, fileName);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Consents\\createConsents.csv")
	public void captureConsentTest(String testCaseId, String testCaseName, String fileName, String enabled) {
		ConsentsApiSdkTest.captureConsentTest(consentsApi, testCaseId, testCaseName, fileName);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Consents\\getConsents.csv")
	public void getConsentsTest(String testCaseId, String testCaseName, String enabled) {
		ConsentsApiSdkTest.getConsentsTest(consentsApi, testCaseId, testCaseName, null, null,null);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Consents\\getConsentsByProviderAccountIds.csv")
	public void getConsentByproviderAccountIdsTest(String testCaseId, String testCaseName, String providerAccountIds,
			String enabled) {
		ConsentsApiSdkTest.getConsentsTest(consentsApi, testCaseId, testCaseName, null, providerAccountIds,null);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Consents\\getConsentsByConsentIds.csv")
	public void getConsentByconsentIdsTest(String testCaseId, String testCaseName, String consentId, String enabled) {
		ConsentsApiSdkTest.getConsentsTest(consentsApi, testCaseId, testCaseName, consentId, null,null);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Consents\\getConsentsByConsentIds.csv")
	public void getConsentByconsentIdsTestWithRenewal(String testCaseId, String testCaseName, String consentId, String enabled) {
		ConsentsApiSdkTest.getConsentsTest(consentsApi, testCaseId, testCaseName, consentId, null, IncludeConsentParam.RENEWAL);
	}
	
	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Consents\\getAuthorizationURL.csv")
	public void getAuthorizationURLTest(String testCaseId, String testCaseName, long consentId, String enabled) {
		ConsentsApiSdkTest.getAuthorizationURLTest(consentsApi, testCaseId, testCaseName, consentId);
	}
	
	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Consents\\putRenewConsents.csv")
	public void renewConsentTest(String testCaseId, String testCaseName,long consentId, String enabled) {
		ConsentsApiSdkTest.renewConsentTest(consentsApi, testCaseId, testCaseName, consentId, null);
	}
	
	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Consents\\putRenewConsents.csv")
	  public void renewConsentTest1(String testCaseId, String testCaseName,long consentId, String enabled) {
		  ConsentsApiSdkTest.renewConsentTest1(consentsApi, testCaseId, testCaseName, consentId, null);
	  }
	
	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Consents\\putRenewConsents.csv")
	public void renewConsentTestForAU(String testCaseId, String testCaseName,long consentId, String enabled) {
		ConsentsApiSdkTest.renewConsentTest(consentsApi, testCaseId, testCaseName, consentId, null);
	}
}
