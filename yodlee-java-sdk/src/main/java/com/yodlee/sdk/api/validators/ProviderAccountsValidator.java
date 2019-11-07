/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.sdk.api.validators;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.yodlee.api.model.Field;
import com.yodlee.api.model.ProvidersDataset;
import com.yodlee.api.model.provideraccounts.request.ProviderAccountPreferencesRequest;
import com.yodlee.api.model.provideraccounts.request.ProviderAccountRequest;
import com.yodlee.api.model.provideraccounts.request.RefreshProviderAccountRequest;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.sdk.api.ProviderAccountsApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;

public class ProviderAccountsValidator {

	private static final String CONFLICTING_DATASET_ERROR_MSG = "providerAccounts.param.dataset.datasetName.invalid";

	public enum ProviderAccountInclude {
		credentials,//
		questions,//
		preferences
	}

	public enum ProviderAccountDetailsInclude {
		preferences
	}

	public static void validateDeleteProviderAccount(ProviderAccountsApi providerAccountsApi, String methodName,
			long providerAccountId) throws ApiException {
		Class<?>[] argTypes = new Class[] {long.class};
		Object[] argValues = new Object[] {providerAccountId};
		List<Problem> methodProblems = ApiValidator.validate(providerAccountsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(providerAccountsApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateGetProviderAccount(ProviderAccountsApi providerAccountsApi, String methodName,
			long providerAccountId, ProviderAccountInclude[] include, String requestId) throws ApiException {
		Class<?>[] argTypes = new Class[] {long.class, ProviderAccountInclude[].class, String.class};
		Object[] argValues = new Object[] {providerAccountId, include, requestId};
		List<Problem> methodProblems = ApiValidator.validate(providerAccountsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(providerAccountsApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateGetAllProviderAccounts(ProviderAccountsApi providerAccountsApi, String methodName,
			ProviderAccountDetailsInclude include, Long[] providerIds) throws ApiException {
		Class<?>[] argTypes = new Class[] {ProviderAccountDetailsInclude.class, Long[].class};
		Object[] argValues = new Object[] {include, providerIds};
		List<Problem> contextProblems = ApiValidator.validateUserContext(providerAccountsApi);
		List<Problem> methodProblems = ApiValidator.validate(providerAccountsApi, methodName, argTypes, argValues);
		methodProblems.addAll(ApiValidator.validateId(providerIds, "providerAccounts.param.providerIds.invalid"));
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateLinkProviderAccount(ProviderAccountsApi providerAccountsApi, String methodName,
			long providerId, ProviderAccountRequest providerAccountRequest) throws ApiException {
		Class<?>[] argTypes = new Class[] {ProviderAccountRequest.class, long.class};
		Object[] argValues = new Object[] {providerAccountRequest, providerId};
		List<Problem> contextProblems = ApiValidator.validateUserContext(providerAccountsApi);
		List<Problem> modelproblems = ApiValidator.validate(providerAccountRequest);
		List<Problem> methodProblems = ApiValidator.validate(providerAccountsApi, methodName, argTypes, argValues);
		if (providerAccountRequest != null) {
			methodProblems.addAll(validateDatasetDuplication(providerAccountRequest.getDatasets()));
			methodProblems.addAll(ApiUtils.isConflictingParams(providerAccountRequest.getDatasets(),
					providerAccountRequest.getDatasetName(), CONFLICTING_DATASET_ERROR_MSG));
			methodProblems.addAll(validateFields(providerAccountRequest.getField()));
		}
		ApiValidator.collectProblems(methodProblems, contextProblems, modelproblems);
	}

	private static List<Problem> validateFields(List<Field> fields) {
		List<Problem> problems = new ArrayList<>();
		if (fields == null)
			return problems;
		if (fields.size() < 2) {
			problems.add(new Problem(ApiUtils.getErrorMessage("providerAccounts.param.field.required"), ""));
		}
		return problems;
	}

	private static List<Problem> validateDatasetDuplication(List<ProvidersDataset> datasets) {
		List<Problem> problems = new ArrayList<>();
		if (datasets == null || datasets.isEmpty())
			return problems;
		Set<ProvidersDataset> providerSet = new HashSet<>();
		for (ProvidersDataset providersDataset : datasets) {
			if (!providerSet.add(providersDataset)) {
				problems.add(new Problem(ApiUtils.getErrorMessage("providerAccounts.param.dataset.invalid"), ""));
				return problems;
			}
		}
		return problems;
	}

	public static void validateGetProviderAccountProfiles(ProviderAccountsApi providerAccountsApi, String methodName,
			Long[] providerAccountId) throws ApiException {
		Class<?>[] argTypes = new Class[] {Long[].class};
		Object[] argValues = new Object[] {providerAccountId};
		List<Problem> contextProblems = ApiValidator.validateUserContext(providerAccountsApi);
		List<Problem> methodProblems = ApiValidator.validate(providerAccountsApi, methodName, argTypes, argValues);
		methodProblems.addAll(
				ApiValidator.validateId(providerAccountId, "providerAccounts.param.providerAccountIds.invalid"));
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateUpdatePreferences(ProviderAccountsApi providerAccountsApi, String methodName,
			ProviderAccountPreferencesRequest preferences, Long providerAccountId) throws ApiException {
		Class<?>[] argTypes = new Class[] {ProviderAccountPreferencesRequest.class, Long.class};
		Object[] argValues = new Object[] {preferences, providerAccountId};
		List<Problem> methodProblems = ApiValidator.validate(providerAccountsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(providerAccountsApi);
		List<Problem> modelproblems = ApiValidator.validate(preferences);
		ApiValidator.collectProblems(methodProblems, contextProblems, modelproblems);
	}

	public static void validateMFAProviderAccount(ProviderAccountsApi providerAccountsApi, String methodName,
			long providerAccountId, Field[] mfaFields) throws ApiException {
		Class<?>[] argTypes = new Class[] {long.class, Field[].class};
		Object[] argValues = new Object[] {providerAccountId, mfaFields};
		List<Problem> methodProblems = ApiValidator.validate(providerAccountsApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = new ArrayList<>();
		if (mfaFields != null) {
			for (Field field : mfaFields) {
				if (field != null)
					modelProblems.addAll(field.validate());
			}
		}
		List<Problem> contextProblems = ApiValidator.validateUserContext(providerAccountsApi);
		ApiValidator.collectProblems(methodProblems, modelProblems, contextProblems);
	}

	public static void validateUpdateProviderAccount(ProviderAccountsApi providerAccountsApi, String methodName,
			long providerAccountId, ProviderAccountRequest providerAccountRequest) throws ApiException {
		Class<?>[] argTypes = new Class[] {long.class, ProviderAccountRequest.class};
		Object[] argValues = new Object[] {providerAccountId, providerAccountRequest};
		List<Problem> modelProblems = ApiValidator.validate(providerAccountRequest);
		List<Problem> contextProblems = ApiValidator.validateUserContext(providerAccountsApi);
		List<Problem> methodProblems = ApiValidator.validate(providerAccountsApi, methodName, argTypes, argValues);
		if (providerAccountRequest != null) {
			methodProblems.addAll(validateDatasetDuplication(providerAccountRequest.getDatasets()));
			methodProblems.addAll(ApiUtils.isConflictingParams(providerAccountRequest.getDatasets(),
					providerAccountRequest.getDatasetName(), CONFLICTING_DATASET_ERROR_MSG));
			methodProblems.addAll(validateFields(providerAccountRequest.getField()));
		}
		ApiValidator.collectProblems(methodProblems, modelProblems, contextProblems);
	}

	public static void validateRefreshAllProviderAccounts(ProviderAccountsApi providerAccountsApi, String methodName)
			throws ApiException {
		Class<?>[] argTypes = new Class[] {};
		Object[] argValues = new Object[] {};
		List<Problem> methodProblems = ApiValidator.validate(providerAccountsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(providerAccountsApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateRefreshProviderAccount(ProviderAccountsApi providerAccountsApi, String methodName,
			long providerAccountId, RefreshProviderAccountRequest refreshProviderAccountRequest) throws ApiException {
		Class<?>[] argTypes = new Class[] {long.class, RefreshProviderAccountRequest.class};
		Object[] argValues = new Object[] {providerAccountId, refreshProviderAccountRequest};
		List<Problem> methodProblems = ApiValidator.validate(providerAccountsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(providerAccountsApi);
		if (refreshProviderAccountRequest != null) {
			methodProblems.addAll(validateDatasetDuplication(refreshProviderAccountRequest.getDatasets()));
			methodProblems.addAll(ApiUtils.isConflictingParams(refreshProviderAccountRequest.getDatasets(),
					refreshProviderAccountRequest.getDatasetName(), CONFLICTING_DATASET_ERROR_MSG));
		}
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}
}
