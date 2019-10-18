/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.api.validators;

import java.util.List;
import com.yodlee.api.model.auth.request.ApiKeyRequest;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.sdk.api.AbstractApi;
import com.yodlee.sdk.api.AuthApi;
import com.yodlee.sdk.api.exception.ApiException;

public class AuthValidator {

	private AuthValidator() {}

	public static void validateGenerateApiKey(AbstractApi authApi, String methodName, ApiKeyRequest apiKeyRequest)
			throws ApiException {
		Class<?>[] argTypes = new Class[] {ApiKeyRequest.class};
		Object[] argValues = new Object[] {apiKeyRequest};
		List<Problem> methodProblems = ApiValidator.validate(authApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = ApiValidator.validate(apiKeyRequest);
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(authApi);
		ApiValidator.collectProblems(methodProblems, modelProblems, contextProblems);
	}

	public static void validateContext(AuthApi authApi) throws ApiException {
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(authApi);
		ApiValidator.collectProblems(contextProblems);
	}

	public static void validateDeleteApiKey(AuthApi authApi, String methodName, String key) throws ApiException {
		Class<?>[] argTypes = new Class[] {String.class};
		Object[] argValues = new Object[] {key};
		List<Problem> methodProblems = ApiValidator.validate(authApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(authApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}
}
