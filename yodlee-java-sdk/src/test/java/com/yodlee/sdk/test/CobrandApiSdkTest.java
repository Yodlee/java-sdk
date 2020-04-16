/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.cobrand.enums.CobrandNotificationEventType;
import com.yodlee.api.model.cobrand.request.CreateCobrandNotificationEventRequest;
import com.yodlee.api.model.cobrand.request.UpdateCobrandNotificationEventRequest;
import com.yodlee.api.model.cobrand.response.CobrandNotificationResponse;
import com.yodlee.api.model.cobrand.response.CobrandPublicKeyResponse;
import com.yodlee.sdk.api.CobrandApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.builder.CobrandContextBuilder;
import com.yodlee.sdk.builder.ContextBuilderFactory;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.configuration.cobrand.CobrandConfiguration;
import com.yodlee.sdk.context.CobrandContext;
import com.yodlee.sdk.test.saml.AbstractSdkSAMLCobrandTestSuite;
import com.yodlee.sdk.test.utils.ModelUtil;
import com.yodlee.sdk.test.utils.PrintUtil;

public class CobrandApiSdkTest {

	private static CobrandContext cobrandContext;

	public static void testCobrandLogin(CobrandApi cobrandApi, String testCaseId, String testCaseName) {
		try (InputStream inStream =
				AbstractSdkSAMLCobrandTestSuite.class.getResourceAsStream("/configuration/cobrand.properties");) {
			Properties properties = new Properties();
			properties.load(inStream);
			CobrandConfiguration configuration = new CobrandConfiguration();
			configuration.setBasePath(properties.getProperty("basePath"));
			configuration.setApiVersion(properties.getProperty("apiVersion"));
			configuration.setName(properties.getProperty("cobrandName"));
			configuration.setLoginName(properties.getProperty("cobrandLoginName"));
			configuration.setPassword(properties.getProperty("cobrandPassword"));
			configuration.setLocale(properties.getProperty("locale"));
			CobrandContextBuilder cobrandContextBuilder = ContextBuilderFactory.createCobrandContextBuilder();
			cobrandContext = cobrandContextBuilder.build(configuration);
			cobrandApi.setContext(cobrandContext);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, null);
			System.out.println(cobrandContext);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		} catch (IOException ioe) {
			PrintUtil.assertFail("", "Exception loading", ioe);
		}
	}

	public static void testCobrandLogout(CobrandApi cobrandApi) {
		try {
			assertEquals(cobrandApi.cobrandLogout().getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail("", "Cobrand Logout", e);
		}
	}

	public static void testSubsribeEvent(CobrandApi cobrandApi, String testCaseId, String testCaseName, String fileName,
			String eventName) {
		// deleteSubscribedEvent(cobrandApi, testCaseId, testCaseName,eventName);
		try {
			CreateCobrandNotificationEventRequest eventRequest =
					ModelUtil.load(fileName, CreateCobrandNotificationEventRequest.class);
			ApiResponse<AbstractModelComponent> subribeEvent =
					cobrandApi.createSubscriptionEvent(CobrandNotificationEventType.valueOf(eventName), eventRequest);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, null);
			assertEquals(subribeEvent.getStatusCode(), 201);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		} finally {
			deleteSubscribedEvent(cobrandApi, testCaseId, testCaseName, eventName);
		}
	}

	public static void testGetSubsribedEvent(CobrandApi cobrandApi, String testCaseId, String testCaseName,
			String fileName, String eventName) {
		try {
			CreateCobrandNotificationEventRequest eventRequest =
					ModelUtil.load(fileName, CreateCobrandNotificationEventRequest.class);
			//
			subscribeEvent(cobrandApi, eventName, eventRequest);
			//
			ApiResponse<CobrandNotificationResponse> subscribedEvents = cobrandApi.getSubscribedEvents(
					StringUtils.isEmpty(eventName) ? null : CobrandNotificationEventType.valueOf(eventName));
			PrintUtil.printJSONResponse(testCaseId, testCaseName, subscribedEvents);
			assertEquals(subscribedEvents.getStatusCode(), 200);
			ApiResponse<CobrandNotificationResponse> subscribedEventsWithNoVAlue = cobrandApi.getSubscribedEvents(null);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, subscribedEventsWithNoVAlue);
			// assertNotNull(subscribedEvents.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		} finally {
			deleteSubscribedEvent(cobrandApi, testCaseId, testCaseName, eventName);
		}
	}

	public static void testUpdateSubsribedEvent(CobrandApi cobrandApi, String testCaseId, String testCaseName,
			String fileNametoSubcribe, String fileName, String eventName) {
		try {
			CreateCobrandNotificationEventRequest eventRequest =
					ModelUtil.load(fileNametoSubcribe, CreateCobrandNotificationEventRequest.class);
			UpdateCobrandNotificationEventRequest updateEventRequest =
					ModelUtil.load(fileName, UpdateCobrandNotificationEventRequest.class);
			//
			subscribeEvent(cobrandApi, eventName, eventRequest);
			//
			ApiResponse<AbstractModelComponent> updateEvent = cobrandApi
					.updateSubscribedEvent(CobrandNotificationEventType.valueOf(eventName), updateEventRequest);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, null);
			assertEquals(updateEvent.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		} finally {
			deleteSubscribedEvent(cobrandApi, testCaseId, testCaseName, eventName);
		}
	}

	public static void testDeleteSubsribeEvent(CobrandApi cobrandApi, String testCaseId, String testCaseName,
			String fileName, String eventName) {
		// cobrandApi.deleteSubscribedEvent(CobrandNotificationEventType.valueOf(eventName));
		try {
			CreateCobrandNotificationEventRequest eventRequest =
					ModelUtil.load(fileName, CreateCobrandNotificationEventRequest.class);
			subscribeEvent(cobrandApi, eventName, eventRequest);
			//
			ApiResponse<AbstractModelComponent> deleteEvent =
					cobrandApi.deleteSubscribedEvent(CobrandNotificationEventType.valueOf(eventName));
			PrintUtil.printJSONResponse(testCaseId, testCaseName, null);
			assertEquals(deleteEvent.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void testGetPublicKey(CobrandApi cobrandApi, String testCaseId, String testCaseName) {
		try {
			ApiResponse<CobrandPublicKeyResponse> publicKey = cobrandApi.getPublicKey();
			PrintUtil.printJSONResponse(testCaseId, testCaseName, publicKey);
			assertEquals(publicKey.getStatusCode(), 200);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	private static void deleteSubscribedEvent(CobrandApi cobrandApi, String testCaseId, String testCaseName,
			String eventName) {
		try {
			ApiResponse<AbstractModelComponent> deleteEvent = cobrandApi.deleteSubscribedEvent(
					StringUtils.isEmpty(eventName) ? null : CobrandNotificationEventType.valueOf(eventName));
			assertEquals(deleteEvent.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	private static void subscribeEvent(CobrandApi cobrandApi, String eventName,
			CreateCobrandNotificationEventRequest eventRequest) throws ApiException {
		ApiResponse<AbstractModelComponent> subribeEvent = cobrandApi.createSubscriptionEvent(
				StringUtils.isEmpty(eventName) ? null : CobrandNotificationEventType.valueOf(eventName), eventRequest);
		assertEquals(subribeEvent.getStatusCode(), 201);
	}
}
