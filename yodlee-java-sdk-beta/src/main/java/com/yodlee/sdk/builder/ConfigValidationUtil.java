/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.builder;

import java.util.ArrayList;
import java.util.List;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.api.model.validator.Validator;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.validators.ApiValidator;
import com.yodlee.sdk.configuration.cobrand.AbstractBaseConfiguration;

public class ConfigValidationUtil {

	private ConfigValidationUtil() {}

	public static void validateConfig(AbstractBaseConfiguration configuration) throws ApiException {
		List<Problem> configProblems = new ArrayList<>();
		if (configuration == null) {
			configProblems.add(new Problem("Configuration is required", ""));
		} else {
			configProblems.addAll(Validator.validate(configuration));
		}
		ApiValidator.collectProblems(configProblems);
	}
}
