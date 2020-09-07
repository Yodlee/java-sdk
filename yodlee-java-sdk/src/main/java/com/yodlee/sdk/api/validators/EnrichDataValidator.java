/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api.validators;

import java.util.List;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.sdk.api.EnrichDataApi;
import com.yodlee.sdk.api.exception.ApiException;

public class EnrichDataValidator {

	public static void validatePushUserData(EnrichDataApi enrichDataApi, String method) throws ApiException {
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(enrichDataApi);
		ApiValidator.collectProblems(contextProblems);
	}
}
