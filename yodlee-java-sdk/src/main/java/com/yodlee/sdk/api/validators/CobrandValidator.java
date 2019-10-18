/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.api.validators;

import java.util.List;
import com.yodlee.api.model.cobrand.enums.CobrandNotificationEventType;
import com.yodlee.api.model.cobrand.request.CobrandLoginRequest;
import com.yodlee.api.model.cobrand.request.CreateCobrandNotificationEventRequest;
import com.yodlee.api.model.cobrand.request.UpdateCobrandNotificationEventRequest;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.sdk.api.CobrandApi;
import com.yodlee.sdk.api.exception.ApiException;

public class CobrandValidator {

	private CobrandValidator() {}

	public static void validateCobrandLogin(CobrandApi cobrandApi, String methodName,
			CobrandLoginRequest cobrandLoginRequest) throws ApiException {
		Class<?>[] argTypes = new Class[] {CobrandLoginRequest.class};
		Object[] argValues = new Object[] {cobrandLoginRequest};
		List<Problem> methodProblems = ApiValidator.validate(cobrandApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = ApiValidator.validate(cobrandLoginRequest);
		ApiValidator.collectProblems(methodProblems, modelProblems);
	}

	public static void validateCreateSubscriptionEvent(CobrandApi cobrandApi, String methodName,
			CobrandNotificationEventType eventName, CreateCobrandNotificationEventRequest eventRequest)
			throws ApiException {
		Class<?>[] argTypes =
				new Class[] {CobrandNotificationEventType.class, CreateCobrandNotificationEventRequest.class};
		Object[] argValues = new Object[] {eventName, eventRequest};
		List<Problem> methodProblems = ApiValidator.validate(cobrandApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = ApiValidator.validate(eventRequest);
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(cobrandApi);
		ApiValidator.collectProblems(methodProblems, modelProblems, contextProblems);
	}

	public static void validateUpdateSubscribedEvent(CobrandApi cobrandApi, String methodName,
			CobrandNotificationEventType eventType, UpdateCobrandNotificationEventRequest eventRequest)
			throws ApiException {
		Class<?>[] argTypes =
				new Class[] {CobrandNotificationEventType.class, UpdateCobrandNotificationEventRequest.class};
		Object[] argValues = new Object[] {eventType, eventRequest};
		List<Problem> methodProblems = ApiValidator.validate(cobrandApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = ApiValidator.validate(eventRequest);
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(cobrandApi);
		ApiValidator.collectProblems(methodProblems, modelProblems, contextProblems);
	}

	public static void validateDeleteSubscribedEvent(CobrandApi cobrandApi, String methodName,
			CobrandNotificationEventType eventType) throws ApiException {
		Class<?>[] argTypes = new Class[] {CobrandNotificationEventType.class};
		Object[] argValues = new Object[] {eventType};
		List<Problem> methodProblems = ApiValidator.validate(cobrandApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(cobrandApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateApiContext(CobrandApi cobrandApi) throws ApiException {
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(cobrandApi);
		ApiValidator.collectProblems(contextProblems);
	}
}
