/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.sdk.api.validators;

import java.util.List;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.api.model.verifyaccount.request.VerifyAccountRequest;
import com.yodlee.sdk.api.VerifyAccountApi;
import com.yodlee.sdk.api.exception.ApiException;

public class VerifyAccountValidator {

	private VerifyAccountValidator() {}

	public static void validatePostVerifyAccount(VerifyAccountApi verifyAccountApi, String methodName,
			long providerAccountId, VerifyAccountRequest verificationParam) throws ApiException {
		Class<?>[] argTypes = new Class[] {long.class, VerifyAccountRequest.class};
		Object[] argValues = new Object[] {providerAccountId, verificationParam};
		List<Problem> methodProblems = ApiValidator.validate(verifyAccountApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(verifyAccountApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}
}
