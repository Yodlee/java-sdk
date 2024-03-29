/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api.validators;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.yodlee.api.model.account.CreateAccountInfo;
import com.yodlee.api.model.account.EvaluateAccountAddress;
import com.yodlee.api.model.account.UpdateAccountInfo;
import com.yodlee.api.model.account.enums.FrequencyType;
import com.yodlee.api.model.account.enums.ItemAccountStatus;
import com.yodlee.api.model.account.request.CreateAccountRequest;
import com.yodlee.api.model.account.request.EvaluateAddressRequest;
import com.yodlee.api.model.account.request.UpdateAccountRequest;
import com.yodlee.api.model.enums.Container;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.sdk.api.AccountsApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;

/**
 * <b> Note : </b> fullAccountNumber is deprecated and is replaced with fullAccountNumberList in include parameter and
 * response.
 */
public class AccountsValidator {

	public enum IncludeParameterValue {
		profile,//
		holder,//
		fullAccountNumber,//
		fullAccountNumberList,
		paymentProfile,//
		autoRefresh;
	}

	public enum HistoricalBalancesIntervalValue {
		D,//
		W,//
		M;
	}

	public static void validateGetAccount(AccountsApi accountsApi, String methodName, Long accountId,
			IncludeParameterValue[] include) throws ApiException {
		Class<?>[] argTypes = new Class[] {long.class, IncludeParameterValue[].class};
		Object[] argValues = new Object[] {accountId, include};
		List<Problem> methodProblems = ApiValidator.validate(accountsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(accountsApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateGetAllAccounts(AccountsApi accountsApi, String methodName, Long[] accountId,
			Container container, IncludeParameterValue[] include, Long[] providerAccountId, String requestId,
			ItemAccountStatus[] status) throws ApiException {
		List<Problem> problems = new ArrayList<>();
		problems.addAll(validateGetAllAccountRequest(accountId, providerAccountId, status));
		Class<?>[] argTypes = new Class[] {Long[].class, Container.class, IncludeParameterValue[].class, Long[].class,
				String.class, ItemAccountStatus[].class};
		Object[] argValues = new Object[] {accountId, container, include, providerAccountId, requestId, status};
		List<Problem> methodProblems = ApiValidator.validate(accountsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(accountsApi);
		ApiValidator.collectProblems(problems, methodProblems, contextProblems);
	}

	public static void validateGetHistoricalBalances(AccountsApi accountsApi, String methodName, Long accountId,
			Date toDate, Date fromDate, Boolean includeCF, HistoricalBalancesIntervalValue interval, Integer skip,
			Integer top) throws ApiException {
		Class<?>[] argTypes = new Class[] {Long.class, Date.class, Date.class, Boolean.class,
				HistoricalBalancesIntervalValue.class, Integer.class, Integer.class};
		Object[] argValues = new Object[] {accountId, toDate, fromDate, includeCF, interval, skip, top};
		List<Problem> methodProblems = ApiValidator.validate(accountsApi, methodName, argTypes, argValues);
		List<Problem> problems = new ArrayList<>();
		problems.addAll(ApiValidator.isValidDateRange(fromDate, toDate, "accounts.param.dateRange.invalid"));
		List<Problem> contextProblems = ApiValidator.validateUserContext(accountsApi);
		ApiValidator.collectProblems(problems, methodProblems, contextProblems);
	}

	public static void validateDeleteAccount(AccountsApi accountsApi, String methodName, long accountId)
			throws ApiException {
		Class<?>[] argTypes = new Class[] {long.class};
		Object[] argValues = new Object[] {accountId};
		List<Problem> methodProblems = ApiValidator.validate(accountsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(accountsApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateCreateManualAccount(AccountsApi accountsApi, String methodName,
			CreateAccountRequest accountParam) throws ApiException {
		Class<?>[] argTypes = new Class[] {CreateAccountRequest.class};
		Object[] argValues = new Object[] {accountParam};
		List<Problem> methodProblems = ApiValidator.validate(accountsApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = ApiValidator.validate(accountParam);
		List<Problem> contextProblems = ApiValidator.validateUserContext(accountsApi);
		List<Problem> problems = validateCreateManualAccount(accountParam);
		ApiValidator.collectProblems(problems, methodProblems, modelProblems, contextProblems);
	}

	public static void validateUpdateAccount(AccountsApi accountsApi, String methodName, long accountId,
			UpdateAccountRequest accountRequest) throws ApiException {
		Class<?>[] argTypes = new Class[] {long.class, UpdateAccountRequest.class};
		Object[] argValues = new Object[] {accountId, accountRequest};
		List<Problem> methodProblems = ApiValidator.validate(accountsApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = ApiValidator.validate(accountRequest);
		List<Problem> contextProblems = ApiValidator.validateUserContext(accountsApi);
		List<Problem> problems = validateUpdateAccount(accountRequest);
		ApiValidator.collectProblems(problems, methodProblems, modelProblems, contextProblems);
	}

	private static List<Problem> validateCreateManualAccount(CreateAccountRequest accountParam) {
		List<Problem> problems = new ArrayList<>();
		if (accountParam != null) {
			CreateAccountInfo accountInfo = accountParam.getAccountInfo();
			if (accountInfo != null) {
				processAccounts(problems, accountInfo);
			}
		}
		return problems;
	}

	private static void processAccounts(List<Problem> problems, CreateAccountInfo accountInfo) {
		String accountType = accountInfo.getAccountType();
		if ("REAL_ESTATE".equalsIgnoreCase(accountType)) {
			processRealEstateAccounts(problems, accountInfo);
		}
		if ("OTHER_ASSETS".equalsIgnoreCase(accountType) || "OTHER_LIABILITIES".equalsIgnoreCase(accountType)) {
			processAssetLiabilityAccounts(problems, accountInfo);
		}
		if ("BILLS".equalsIgnoreCase(accountType) || "CREDIT".equalsIgnoreCase(accountType)
				|| "LOAN".equalsIgnoreCase(accountType) || "HOME_LOAN".equalsIgnoreCase(accountType)
				|| "PERSONAL_LOAN".equalsIgnoreCase(accountType) || "INSURANCE".equalsIgnoreCase(accountType)) {
			processOtherAccounts(problems, accountInfo);
		} else {
			FrequencyType frequency = accountInfo.getFrequency();
			problems.addAll(isFrequencyExist(frequency));
		}
		String includeInNetWorth = accountInfo.getIncludeInNetWorth();
		problems.addAll(isValidIncludeInNetworth(includeInNetWorth));
	}

	private static void processOtherAccounts(List<Problem> problems, CreateAccountInfo accountInfo) {
		if (accountInfo.getDueDate() == null) {
			problems.add(new Problem(ApiUtils.getErrorMessage("accounts.manualAccountInfo.dueDate.required"), ""));
		}
	}

	private static void processAssetLiabilityAccounts(List<Problem> problems, CreateAccountInfo accountInfo) {
		if (accountInfo.getBalance() == null) {
			problems.add(new Problem(ApiUtils.getErrorMessage("accounts.manualAccountInfo.balance.required"), ""));
		}
	}

	private static void processRealEstateAccounts(List<Problem> problems, CreateAccountInfo accountInfo) {
		if (accountInfo.getValuationType() == null) {
			problems.add(
					new Problem(ApiUtils.getErrorMessage("accounts.manualAccountInfo.valuationType.required"), ""));
		}
	}

	private static List<Problem> validateUpdateAccount(UpdateAccountRequest accountRequest) {
		List<Problem> problems = new ArrayList<>();
		UpdateAccountInfo accountInfo = accountRequest.getAccountInfo();
		if (accountInfo != null) {
			Container container = accountInfo.getContainer();
			if (container != null && container != Container.creditCard
					&& container != Container.loan && container != Container.insurance) {
				FrequencyType frequency = accountInfo.getFrequency();
				problems.addAll(isFrequencyExist(frequency));
			}
			String includeInNetWorth = accountInfo.getIncludeInNetWorth();
			problems.addAll(isValidIncludeInNetworth(includeInNetWorth));
			problems.addAll(validAccountStatus(accountInfo));
			problems.addAll(
					ApiUtils.validatePattern(accountInfo.getAccountName(), "^\\s+.*", "accounts.accountName.space"));
		}
		return problems;
	}

	private static List<Problem> validAccountStatus(UpdateAccountInfo accountInfo) {
		List<Problem> problems = new ArrayList<>();
		ItemAccountStatus accountStatus = accountInfo.getAccountStatus();
		if (accountStatus != null
				&& !ItemAccountStatus.getUpdateAccountApplicableStatusTypes().contains(accountStatus)) {
			problems.add(new Problem(
					ApiUtils.getErrorMessage("accounts.accountInfo.accountStatus.invalid", accountStatus.name()), ""));
		}
		return problems;
	}

	private static List<Problem> isFrequencyExist(FrequencyType frequency) {
		List<Problem> problems = new ArrayList<>();
		if (frequency != null) {
			problems.add(new Problem(ApiUtils.getErrorMessage("accounts.accountInfo.frequency.notSupported"), ""));
		}
		return problems;
	}

	private static List<Problem> isValidIncludeInNetworth(String includeInNetWorth) {
		List<Problem> problems = new ArrayList<>();
		if (includeInNetWorth != null && !"TRUE".equalsIgnoreCase(includeInNetWorth)
				&& !"FALSE".equalsIgnoreCase(includeInNetWorth)) {
			problems.add(new Problem(ApiUtils.getErrorMessage("accounts.accountInfo.includeInNetWorth.invalid"), ""));
		}
		return problems;
	}

	private static List<Problem> validateGetAllAccountRequest(Long[] accountId, Long[] providerAccountId,
			ItemAccountStatus[] status) {
		List<Problem> problems = new ArrayList<>();
		problems.addAll(validateAccountStatus(status));
		problems.addAll(ApiValidator.validateId(accountId, "accounts.param.accountId.invalid"));
		problems.addAll(ApiValidator.validateId(providerAccountId, "accounts.param.providerAccountId.invalid"));
		return problems;
	}

	private static List<Problem> validateAccountStatus(ItemAccountStatus[] status) {
		List<Problem> problems = new ArrayList<>();
		if (status != null && status.length > 0) {
			for (ItemAccountStatus statusValue : status) {
				if (!ItemAccountStatus.getAccountApplicableStatusTypes().contains(statusValue)) {
					problems.add(new Problem(
							ApiUtils.getErrorMessage("accounts.param.status.invalid", statusValue.name()), ""));
				}
			}
		}
		return problems;
	}

	public static void validateEvaluateAddress(AccountsApi accountsApi, String methodName,
			EvaluateAddressRequest evaluateAddressRequest) throws ApiException {
		Class<?>[] argTypes = new Class[] {EvaluateAddressRequest.class};
		Object[] argValues = new Object[] {evaluateAddressRequest};
		List<Problem> methodProblems = ApiValidator.validate(accountsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(accountsApi);
		List<Problem> modelProblems = evaluateAddressRequest.validate();
		List<Problem> cityStateOrZipPresentProblems =
				validateCityStateOrZipPresent(evaluateAddressRequest.getAddress());
		ApiValidator.collectProblems(methodProblems, contextProblems, modelProblems, cityStateOrZipPresentProblems);
	}

	private static List<Problem> validateCityStateOrZipPresent(EvaluateAccountAddress evaluateAccountAddress) {
		List<Problem> problems = new ArrayList<>();
		if (evaluateAccountAddress != null && isZipEmpty(evaluateAccountAddress)) {
			boolean isCityEmpty = isCityEmpty(evaluateAccountAddress);
			boolean isStateEmpty = isStateEmpty(evaluateAccountAddress);
			if (isCityEmpty && isStateEmpty) {
				problems.add(new Problem(ApiUtils.getErrorMessage("evaluateAddress.address.zip.required"), ""));
			} else if (isCityEmpty) {
				problems.add(new Problem(ApiUtils.getErrorMessage("evaluateAddress.address.city.required"), ""));
			} else if (isStateEmpty) {
				problems.add(new Problem(ApiUtils.getErrorMessage("evaluateAddress.address.state.required"), ""));
			}
		}
		return problems;
	}

	private static boolean isZipEmpty(EvaluateAccountAddress evaluateAccountAddress) {
		return StringUtils.isEmpty(evaluateAccountAddress.getZip());
	}

	private static boolean isCityEmpty(EvaluateAccountAddress evaluateAccountAddress) {
		return StringUtils.isEmpty(evaluateAccountAddress.getCity());
	}

	private static boolean isStateEmpty(EvaluateAccountAddress evaluateAccountAddress) {
		return StringUtils.isEmpty(evaluateAccountAddress.getState());
	}

	public static void validateMigrateAccounts(AccountsApi accountsApi, String methodName, long providerAccountId)
			throws ApiException {
		Class<?>[] argTypes = new Class[] {long.class};
		Object[] argValues = new Object[] {providerAccountId};
		List<Problem> methodProblems = ApiValidator.validate(accountsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(accountsApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateAssociatedAccounts(AccountsApi accountsApi, String methodName, long providerAccountId)
			throws ApiException {
		Class<?>[] argTypes = new Class[] {long.class};
		Object[] argValues = new Object[] {providerAccountId};
		List<Problem> methodProblems = ApiValidator.validate(accountsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(accountsApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}
	
	public static void validateAccountBalance(AccountsApi accountsApi, String methodName, Long[] accountIds, long providerAccountId)
			throws ApiException {
		Class<?>[] argTypes = new Class[] {Long[].class, long.class};
		Object[] argValues = new Object[] {accountIds, providerAccountId};
		List<Problem> methodProblems = ApiValidator.validate(accountsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(accountsApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}
}
