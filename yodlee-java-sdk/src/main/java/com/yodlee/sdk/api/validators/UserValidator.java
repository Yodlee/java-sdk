/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api.validators;

import java.util.ArrayList;
import java.util.List;
import com.yodlee.api.model.user.request.UpdateUserRequest;
import com.yodlee.api.model.user.request.UserRequest;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.sdk.api.UserApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;
import com.yodlee.sdk.context.ContextType;

public class UserValidator {

	private UserValidator() {}

	public static void validateSamlLogin(UserApi userApi, String methodName, String issuer, String samlResponse,
			String source) throws ApiException {
		Class<?>[] argTypes = new Class[] {String.class, String.class, String.class};
		Object[] argValues = new Object[] {issuer, samlResponse, source};
		List<Problem> methodProblems = ApiValidator.validate(userApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(userApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateRegisterUser(UserApi userApi, String methodName, UserRequest userRequest)
			throws ApiException {
		Class<?>[] argTypes = new Class[] {UserRequest.class};
		Object[] argValues = new Object[] {userRequest};
		List<Problem> methodProblems = ApiValidator.validate(userApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = ApiValidator.validate(userRequest);
		List<Problem> contextProblems =
				validateContextTypeForRegisteration(ContextType.COBRAND, userApi.getContext().getContextType());
		ApiValidator.collectProblems(methodProblems, modelProblems, contextProblems);
	}

	public static void validateUpdateUser(UserApi userApi, String methodName, UpdateUserRequest userRequest)
			throws ApiException {
		Class<?>[] argTypes = new Class[] {UpdateUserRequest.class};
		Object[] argValues = new Object[] {userRequest};
		List<Problem> methodProblems = ApiValidator.validate(userApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = ApiValidator.validate(userRequest);
		List<Problem> contextProblems = ApiValidator.validateUserContext(userApi);
		ApiValidator.collectProblems(methodProblems, modelProblems, contextProblems);
	}

	public static void validateGetAccessTokens(UserApi userApi, String methodName, Long[] appIds) throws ApiException {
		Class<?>[] argTypes = new Class[] {Long[].class};
		Object[] argValues = new Object[] {appIds};
		List<Problem> methodProblems = ApiValidator.validate(userApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(userApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateApiContext(UserApi userApi) throws ApiException {
		List<Problem> problems = ApiValidator.validateUserContext(userApi);
		ApiValidator.collectProblems(problems);
	}

	private static List<Problem> validateContextTypeForRegisteration(ContextType expectedContext,
			ContextType currentContext) {
		List<Problem> problems = new ArrayList<>();
		if (expectedContext != currentContext) {
			Problem problem = new Problem(ApiUtils.getErrorMessage("config.user.token.not.required"), "");
			problems.add(problem);
		}
		return problems;
	}
}
