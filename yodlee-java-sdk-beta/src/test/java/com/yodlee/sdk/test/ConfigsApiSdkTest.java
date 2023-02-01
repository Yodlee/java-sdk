/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test;

import static org.testng.Assert.assertEquals;
import org.apache.commons.lang3.StringUtils;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.configs.enums.ConfigsNotificationEventType;
import com.yodlee.api.model.configs.request.CreateConfigsNotificationEventRequest;
import com.yodlee.api.model.configs.request.UpdateConfigsNotificationEventRequest;
import com.yodlee.api.model.configs.response.ConfigsNotificationResponse;
import com.yodlee.api.model.configs.response.ConfigsPublicKeyResponse;
import com.yodlee.sdk.api.ConfigsApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.test.utils.ModelUtil;
import com.yodlee.sdk.test.utils.PrintUtil;

public class ConfigsApiSdkTest {

	public static void testSubsribeNotificationEvent(ConfigsApi configsApi, String testCaseId, String testCaseName,
			String fileName, String eventName) {
		// deleteSubscribedEvent(configsApi, testCaseId, testCaseName,eventName);
		try {
			CreateConfigsNotificationEventRequest eventRequest =
					ModelUtil.load(fileName, CreateConfigsNotificationEventRequest.class);
			ApiResponse<AbstractModelComponent> subribeEvent = configsApi
					.createSubscriptionNotificationEvent(ConfigsNotificationEventType.valueOf(eventName), eventRequest);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, null);
			assertEquals(subribeEvent.getStatusCode(), 201);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		} finally {
			deleteSubscribedNotificationEvent(configsApi, testCaseId, testCaseName, eventName);
		}
	}

	public static void testGetSubsribedNotificationEvent(ConfigsApi configsApi, String testCaseId, String testCaseName,
			String fileName, String eventName) {
		try {
			CreateConfigsNotificationEventRequest eventRequest =
					ModelUtil.load(fileName, CreateConfigsNotificationEventRequest.class);
			//
			subscribeNotificationEvent(configsApi, eventName, eventRequest);
			//
			ApiResponse<ConfigsNotificationResponse> subscribedEvents = configsApi.getSubscribedNotificationEvents(
					StringUtils.isEmpty(eventName) ? null : ConfigsNotificationEventType.valueOf(eventName));
			PrintUtil.printJSONResponse(testCaseId, testCaseName, subscribedEvents);
			assertEquals(subscribedEvents.getStatusCode(), 200);
			ApiResponse<ConfigsNotificationResponse> subscribedEventsWithNoVAlue =
					configsApi.getSubscribedNotificationEvents(null);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, subscribedEventsWithNoVAlue);
			// assertNotNull(subscribedEvents.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		} finally {
			deleteSubscribedNotificationEvent(configsApi, testCaseId, testCaseName, eventName);
		}
	}

	public static void testUpdateSubsribedNotificationEvent(ConfigsApi configsApi, String testCaseId,
			String testCaseName, String fileNametoSubcribe, String fileName, String eventName) {
		try {
			CreateConfigsNotificationEventRequest eventRequest =
					ModelUtil.load(fileNametoSubcribe, CreateConfigsNotificationEventRequest.class);
			UpdateConfigsNotificationEventRequest updateEventRequest =
					ModelUtil.load(fileName, UpdateConfigsNotificationEventRequest.class);
			//
			subscribeNotificationEvent(configsApi, eventName, eventRequest);
			//
			ApiResponse<AbstractModelComponent> updateEvent = configsApi.updateSubscribedNotificationEvent(
					ConfigsNotificationEventType.valueOf(eventName), updateEventRequest);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, null);
			assertEquals(updateEvent.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		} finally {
			deleteSubscribedNotificationEvent(configsApi, testCaseId, testCaseName, eventName);
		}
	}

	public static void testDeleteSubsribeNotificationEvent(ConfigsApi configsApi, String testCaseId,
			String testCaseName, String fileName, String eventName) {
		// configsApi.deleteSubscribedEvent(ConfigsNotificationEventType.valueOf(eventName));
		try {
			CreateConfigsNotificationEventRequest eventRequest =
					ModelUtil.load(fileName, CreateConfigsNotificationEventRequest.class);
			subscribeNotificationEvent(configsApi, eventName, eventRequest);
			//
			ApiResponse<AbstractModelComponent> deleteEvent =
					configsApi.deleteSubscribedNotificationEvent(ConfigsNotificationEventType.valueOf(eventName));
			PrintUtil.printJSONResponse(testCaseId, testCaseName, null);
			assertEquals(deleteEvent.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void testGetPublicEncryptionKey(ConfigsApi configsApi, String testCaseId, String testCaseName) {
		try {
			ApiResponse<ConfigsPublicKeyResponse> publicKey = configsApi.getPublicEncryptionKey();
			PrintUtil.printJSONResponse(testCaseId, testCaseName, publicKey);
			assertEquals(publicKey.getStatusCode(), 200);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	private static void deleteSubscribedNotificationEvent(ConfigsApi configsApi, String testCaseId, String testCaseName,
			String eventName) {
		try {
			ApiResponse<AbstractModelComponent> deleteEvent = configsApi.deleteSubscribedNotificationEvent(
					StringUtils.isEmpty(eventName) ? null : ConfigsNotificationEventType.valueOf(eventName));
			assertEquals(deleteEvent.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	private static void subscribeNotificationEvent(ConfigsApi configsApi, String eventName,
			CreateConfigsNotificationEventRequest eventRequest) throws ApiException {
		ApiResponse<AbstractModelComponent> subribeEvent = configsApi.createSubscriptionNotificationEvent(
				StringUtils.isEmpty(eventName) ? null : ConfigsNotificationEventType.valueOf(eventName), eventRequest);
		assertEquals(subribeEvent.getStatusCode(), 201);
	}
}
