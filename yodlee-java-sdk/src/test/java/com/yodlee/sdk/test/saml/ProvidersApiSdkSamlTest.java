/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.saml;

import org.databene.benerator.anno.Source;
import org.testng.annotations.Test;
import com.yodlee.sdk.api.ProvidersApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.test.ProvidersApiSdkTest;

public class ProvidersApiSdkSamlTest extends AbstractSdkSAMLCobrandTestSuite {

	private static final ProvidersApi providersApi = new ProvidersApi(null);

	public ProvidersApiSdkSamlTest() throws ApiException {
		providersApi.setContext(AbstractSdkSAMLCobrandTestSuite.setup());
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Providers\\getAllProviders.csv")
	public void getAllProvidersTest(String testCaseId, String testCaseName, String capability, //
			String datasetFilter,//
			String name, String priority,//
			Integer skip, Integer top, String enabled) {
		ProvidersApiSdkTest.getAllProvidersTest(providersApi, testCaseId, testCaseName, capability, datasetFilter, name,
				priority, skip, top);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Providers\\getProvider.csv")
	public void getProviderTest(String testCaseId, String testCaseName, Long providerId, String enabled) {
		ProvidersApiSdkTest.getProviderTest(providersApi, testCaseId, testCaseName, providerId);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Providers\\getProvidersCount.csv")
	public void GetProvidersCountTest(String testCaseId, String testCaseName, String capability, //
			String datasetFilter,//
			String name, String priority,//
			String enabled) {
		ProvidersApiSdkTest.GetProvidersCountTest(providersApi, testCaseId, testCaseName, capability, datasetFilter,
				name, priority);
	}
}
