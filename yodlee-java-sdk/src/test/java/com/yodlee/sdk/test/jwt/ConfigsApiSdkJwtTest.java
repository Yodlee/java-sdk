/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.jwt;

import org.databene.benerator.anno.Source;
import org.testng.annotations.Test;
import com.yodlee.sdk.api.ConfigsApi;
import com.yodlee.sdk.test.ConfigsApiSdkTest;

public class ConfigsApiSdkJwtTest extends AbstractSdkJWTCobrandTestSuite {

	private static final ConfigsApi configsApi = new ConfigsApi(null);

	public ConfigsApiSdkJwtTest() {
		configsApi.setContext(AbstractSdkJWTCobrandTestSuite.setup());
	}

	@Test(enabled = false, dataProvider = "feeder")
	@Source("\\Configs\\publicEncryptionKey.csv")
	public void publicEncryptionKeyUsingGETTest(String testCaseId, String testCaseName, String enabled) {
		ConfigsApiSdkTest.testGetPublicEncryptionKey(configsApi, testCaseId, testCaseName);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Configs\\subscribeNotificationEvent.csv")
	public void subscribeNotificationEventUsingPOSTTest(String testCaseId, String testCaseName, String fileName,
			String eventName, String enabled) {
		ConfigsApiSdkTest.testSubsribeNotificationEvent(configsApi, testCaseId, testCaseName, fileName, eventName);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Configs\\getSubscribedNotificationEvents.csv")
	public void getSubscribedNotificationEventsUsingGETTest(String testCaseId, String testCaseName, String fileName,
			String eventName, String enabled) {
		ConfigsApiSdkTest.testGetSubsribedNotificationEvent(configsApi, testCaseId, testCaseName, fileName, eventName);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Configs\\updateSubscriptionNotification.csv")
	public void updateSubscriptionNotificationUsingPUTTest(String testCaseId, String testCaseName,
			String fileNametoSubcribe, String fileName, String eventName, String enabled) {
		ConfigsApiSdkTest.testUpdateSubsribedNotificationEvent(configsApi, testCaseId, testCaseName, fileNametoSubcribe,
				fileName, eventName);
	}

	@Test(enabled = true, dataProvider = "feeder")
	@Source("\\Configs\\deleteSubscriptionNotification.csv")
	public void deleteSubscriptionNotificationUsingDELETETest(String testCaseId, String testCaseName, String fileName,
			String eventName, String enabled) {
		ConfigsApiSdkTest.testDeleteSubsribeNotificationEvent(configsApi, testCaseId, testCaseName, fileName,
				eventName);
	}
}
