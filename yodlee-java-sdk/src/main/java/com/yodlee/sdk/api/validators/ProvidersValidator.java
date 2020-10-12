/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api.validators;

import java.util.List;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.sdk.api.ProvidersApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;

public class ProvidersValidator {

	private ProvidersValidator() {}

	public enum ProvidersPriorityType {
		SUGGESTED("suggested"),//
		POPULAR("popular"), //
		COBRAND("cobrand");

		private String type;

		private ProvidersPriorityType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
	}

	public enum ProvidersCapability {
		CHALLENGE_DEPOSIT_VERIFICATION
	}

	public static void validateGetProviders(ProvidersApi providersApi, String method, ProvidersCapability capability,
			String datasetFilter, String fullAccountNumberFields, String name, ProvidersPriorityType priority, Integer skip, Integer top)
			throws ApiException {
		Class<?>[] argTypes = new Class[] {ProvidersCapability.class, String.class, String.class, String.class,
				ProvidersPriorityType.class, Integer.class, Integer.class};
		Object[] argValues = new Object[] {capability, datasetFilter, fullAccountNumberFields, name, priority, skip, top};
		List<Problem> methodProblems = ApiValidator.validate(providersApi, method, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(providersApi);
		methodProblems.addAll(ApiUtils.isConflictingParams(name, top, "providers.param.name.top.invalid"));
		methodProblems.addAll(ApiUtils.isConflictingParams(name, skip, "providers.param.name.skip.invalid"));
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateGetProviderDetails(ProvidersApi providersApi, String method, Long providerId)
			throws ApiException {
		Class<?>[] argTypes = new Class[] {Long.class};
		Object[] argValues = new Object[] {providerId};
		List<Problem> methodProblems = ApiValidator.validate(providersApi, method, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(providersApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateGetProvidersCount(ProvidersApi providersApi, String method,
			ProvidersCapability capability, String datasetFilter, String fullAccountNumberFields, String name, ProvidersPriorityType priority)
			throws ApiException {
		Class<?>[] argTypes =
				new Class[] {ProvidersCapability.class, String.class, String.class, String.class, ProvidersPriorityType.class,};
		Object[] argValues = new Object[] {capability, datasetFilter, fullAccountNumberFields, name, priority};
		List<Problem> methodProblems = ApiValidator.validate(providersApi, method, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateCobrandContext(providersApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}
}
