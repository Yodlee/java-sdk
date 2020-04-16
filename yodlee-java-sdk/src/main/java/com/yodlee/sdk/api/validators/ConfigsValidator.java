/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api.validators;

import java.util.List;
import com.yodlee.api.model.configs.enums.ConfigsNotificationEventType;
import com.yodlee.api.model.configs.request.CreateConfigsNotificationEventRequest;
import com.yodlee.api.model.configs.request.UpdateConfigsNotificationEventRequest;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.sdk.api.ConfigsApi;
import com.yodlee.sdk.api.exception.ApiException;

public class ConfigsValidator {

	private ConfigsValidator() {}

	public static void validateCreateSubscriptionNotificationEvent(ConfigsApi configsApi, String methodName,
			ConfigsNotificationEventType eventName, CreateConfigsNotificationEventRequest eventRequest)
			throws ApiException {
		Class<?>[] argTypes =
				new Class[] {ConfigsNotificationEventType.class, CreateConfigsNotificationEventRequest.class};
		Object[] argValues = new Object[] {eventName, eventRequest};
		List<Problem> methodProblems = ApiValidator.validate(configsApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = ApiValidator.validate(eventRequest);
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(configsApi);
		ApiValidator.collectProblems(methodProblems, modelProblems, contextProblems);
	}

	public static void validateUpdateSubscribedNotificationEvent(ConfigsApi configsApi, String methodName,
			ConfigsNotificationEventType eventType, UpdateConfigsNotificationEventRequest eventRequest)
			throws ApiException {
		Class<?>[] argTypes =
				new Class[] {ConfigsNotificationEventType.class, UpdateConfigsNotificationEventRequest.class};
		Object[] argValues = new Object[] {eventType, eventRequest};
		List<Problem> methodProblems = ApiValidator.validate(configsApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = ApiValidator.validate(eventRequest);
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(configsApi);
		ApiValidator.collectProblems(methodProblems, modelProblems, contextProblems);
	}

	public static void validateDeleteSubscribedNotificationEvent(ConfigsApi configsApi, String methodName,
			ConfigsNotificationEventType eventType) throws ApiException {
		Class<?>[] argTypes = new Class[] {ConfigsNotificationEventType.class};
		Object[] argValues = new Object[] {eventType};
		List<Problem> methodProblems = ApiValidator.validate(configsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(configsApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateApiContext(ConfigsApi configsApi) throws ApiException {
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(configsApi);
		ApiValidator.collectProblems(contextProblems);
	}
}
