/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api.validators;

import java.util.List;
import com.yodlee.api.model.consent.request.CreateConsentRequest;
import com.yodlee.api.model.consent.request.UpdateConsentRequest;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.sdk.api.ConsentsApi;
import com.yodlee.sdk.api.exception.ApiException;

public class ConsentsValidator {
	
	public static void validateGetAuthorizationURL(ConsentsApi consentsApi, String methodName, long consentId) throws ApiException {
		Class<?>[] argTypes = new Class[] {long.class};
		Object[] argValues = new Object[] {consentId};
		List<Problem> methodProblems = ApiValidator.validate(consentsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(consentsApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}
	
	public static void validateGetConsent(ConsentsApi consentsApi, String methodName, Long[] consentIds, Long[] providerAccountIds) throws ApiException {
		Class<?>[] argTypes = new Class[] {Long[].class, Long[].class};
		Object[] argValues = new Object[] {consentIds, providerAccountIds};
		List<Problem> methodProblems = ApiValidator.validate(consentsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(consentsApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}
	
	public static void validateCreateConsent(ConsentsApi consentsApi, String methodName, CreateConsentRequest createConsentRequest) throws ApiException {
		Class<?>[] argTypes = new Class[] {CreateConsentRequest.class};
		Object[] argValues = new Object[] {createConsentRequest};
		List<Problem> methodProblems = ApiValidator.validate(consentsApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = ApiValidator.validate(createConsentRequest);
		List<Problem> contextProblems = ApiValidator.validateUserContext(consentsApi);
		ApiValidator.collectProblems(methodProblems, modelProblems, contextProblems);
	}
	
	public static void validateCaptureConsent(ConsentsApi consentsApi, String methodName, long consentId, UpdateConsentRequest updateConsentRequest) throws ApiException {
		Class<?>[] argTypes = new Class[] {long.class, UpdateConsentRequest.class};
		Object[] argValues = new Object[] {consentId, updateConsentRequest};
		List<Problem> methodProblems = ApiValidator.validate(consentsApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = ApiValidator.validate(updateConsentRequest);
		List<Problem> contextProblems = ApiValidator.validateUserContext(consentsApi);
		ApiValidator.collectProblems(methodProblems, modelProblems, contextProblems);
	}
}
