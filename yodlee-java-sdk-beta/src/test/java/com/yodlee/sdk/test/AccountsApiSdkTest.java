/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.account.enums.ItemAccountStatus;
import com.yodlee.api.model.account.request.CreateAccountRequest;
import com.yodlee.api.model.account.request.EvaluateAddressRequest;
import com.yodlee.api.model.account.request.UpdateAccountRequest;
import com.yodlee.api.model.account.response.AccountBalanceResponse;
import com.yodlee.api.model.account.response.AccountHistoricalBalancesResponse;
import com.yodlee.api.model.account.response.AccountMigrationResponse;
import com.yodlee.api.model.account.response.AccountResponse;
import com.yodlee.api.model.account.response.AssociatedAccountsResponse;
import com.yodlee.api.model.account.response.CreatedAccountResponse;
import com.yodlee.api.model.account.response.EvaluateAddressResponse;
import com.yodlee.api.model.enums.Container;
import com.yodlee.sdk.api.AccountsApi;
import com.yodlee.sdk.api.ApiConstants;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.validators.AccountsValidator.HistoricalBalancesIntervalValue;
import com.yodlee.sdk.api.validators.AccountsValidator.IncludeParameterValue;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.test.utils.ModelUtil;
import com.yodlee.sdk.test.utils.PrintUtil;

public class AccountsApiSdkTest {

	public static void getAccountDetailsTest(AccountsApi accountsApi, String testCaseId, String testCaseName,
			String accountId, String include) {
		try {
			Long accountIdAccounts = Long.parseLong(accountId);
			List<IncludeParameterValue> includeParameterValuesList = new ArrayList<IncludeParameterValue>();
			if (!StringUtils.isBlank(include)) {
				String[] split = include.split("#");
				for (String value : split) {
					includeParameterValuesList.add(IncludeParameterValue.valueOf(value));
				}
			}
			IncludeParameterValue[] includeValue = includeParameterValuesList.toArray(new IncludeParameterValue[0]);
			ApiResponse<AccountResponse> accountDetails = accountsApi.getAccount(accountIdAccounts, includeValue);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, accountDetails);
			assertEquals(accountDetails.getStatusCode(), 200);
			assertNotNull(accountDetails.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	/**
	 * 
	 * @param accountsApi
	 * @param testCaseId
	 * @param testCaseName
	 * @param accountId
	 * @param include
	 * @param values
	 * 
	 *        New Method Added for Gzip implementaion for PC
	 */
	public static void getAccountDetailsTestWithGzipVarargs(AccountsApi accountsApi, String testCaseId,
			String testCaseName, String accountId, String include) {
		try {
			Long accountIdAccounts = Long.parseLong(accountId);
			List<IncludeParameterValue> includeParameterValuesList = new ArrayList<IncludeParameterValue>();
			if (!StringUtils.isBlank(include)) {
				String[] split = include.split("#");
				for (String value : split) {
					includeParameterValuesList.add(IncludeParameterValue.valueOf(value));
				}
			}
			IncludeParameterValue[] includeValue = includeParameterValuesList.toArray(new IncludeParameterValue[0]);
			// Creating an empty HashMap
			Map<String, String> map = new HashMap<>();
			map.put(ApiConstants.ACCEPT_ENCODING, "gzip");
			ApiResponse<AccountResponse> accountDetails = accountsApi.getAccount(accountIdAccounts, includeValue, map);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, accountDetails);
			assertEquals(accountDetails.getStatusCode(), 200);
			assertNotNull(accountDetails.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void getAllAccountsTestWithGzipVarargs(AccountsApi accountsApi, String testCaseId, String testCaseName,
			String accountIds, String container, String include, String providerAccountId, String requestId,
			String status) {
		try {
			Container accountsContainer = StringUtils.isEmpty(container) ? null : Container.valueOf(container);
			// status array
			List<ItemAccountStatus> statusList = new ArrayList<ItemAccountStatus>();
			if (!StringUtils.isBlank(status)) {
				String[] split = status.split("#");
				for (String value : split) {
					statusList.add(ItemAccountStatus.valueOf(value));
				}
			}
			ItemAccountStatus[] statusValue = statusList.toArray(new ItemAccountStatus[0]);
			// include array
			List<IncludeParameterValue> includeParameterValuesList = new ArrayList<IncludeParameterValue>();
			if (!StringUtils.isBlank(include)) {
				String[] split = include.split("#");
				for (String value : split) {
					includeParameterValuesList.add(IncludeParameterValue.valueOf(value));
				}
			}
			Long[] accountIdValue = StringUtils.isBlank(accountIds) ? null : convertStringtoLongArray(accountIds);
			Long[] providerAccountIdValue =
					StringUtils.isBlank(providerAccountId) ? null : convertStringtoLongArray(providerAccountId);
			IncludeParameterValue[] includeValue = includeParameterValuesList.toArray(new IncludeParameterValue[0]);
			// Creating an empty HashMap
					Map<String, String> map = new HashMap<>();
					map.put(ApiConstants.ACCEPT_ENCODING, "gzip");
			
			ApiResponse<AccountResponse> allAccounts = accountsApi.getAllAccounts(accountIdValue, accountsContainer,
					includeValue, providerAccountIdValue, requestId, statusValue, map);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, allAccounts);
			assertEquals(allAccounts.getStatusCode(), 200);
			assertNotNull(allAccounts.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
	
	public static void getAllAccountsTest(AccountsApi accountsApi, String testCaseId, String testCaseName,
			String accountIds, String container, String include, String providerAccountId, String requestId,
			String status) {
		try {
			Container accountsContainer = StringUtils.isEmpty(container) ? null : Container.valueOf(container);
			// status array
			List<ItemAccountStatus> statusList = new ArrayList<ItemAccountStatus>();
			if (!StringUtils.isBlank(status)) {
				String[] split = status.split("#");
				for (String value : split) {
					statusList.add(ItemAccountStatus.valueOf(value));
				}
			}
			ItemAccountStatus[] statusValue = statusList.toArray(new ItemAccountStatus[0]);
			// include array
			List<IncludeParameterValue> includeParameterValuesList = new ArrayList<IncludeParameterValue>();
			if (!StringUtils.isBlank(include)) {
				String[] split = include.split("#");
				for (String value : split) {
					includeParameterValuesList.add(IncludeParameterValue.valueOf(value));
				}
			}
			Long[] accountIdValue = StringUtils.isBlank(accountIds) ? null : convertStringtoLongArray(accountIds);
			Long[] providerAccountIdValue =
					StringUtils.isBlank(providerAccountId) ? null : convertStringtoLongArray(providerAccountId);
			IncludeParameterValue[] includeValue = includeParameterValuesList.toArray(new IncludeParameterValue[0]);
			ApiResponse<AccountResponse> allAccounts = accountsApi.getAllAccounts(accountIdValue, accountsContainer,
					includeValue, providerAccountIdValue, requestId, statusValue);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, allAccounts);
			assertEquals(allAccounts.getStatusCode(), 200);
			assertNotNull(allAccounts.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void getHistoricalBalancesTest(AccountsApi accountsApi, String testCaseId, String testCaseName,
			String accountId, String toDate, String fromDate, String includeCF, String interval, String skip,
			String top) {
		try {
			Long accountIdAccounts = StringUtils.isEmpty(accountId) ? null : Long.parseLong(accountId);
			Date toDateValue = StringUtils.isEmpty(toDate) ? null : new Date(Long.parseLong(toDate) * 1000L);;
			Date fromDateValue = StringUtils.isEmpty(fromDate) ? null : new Date(Long.parseLong(fromDate) * 1000L);
			Boolean accountIncludeCF = StringUtils.isEmpty(includeCF) ? null : Boolean.parseBoolean(includeCF);
			HistoricalBalancesIntervalValue intervalValue =
					StringUtils.isBlank(interval) ? null : HistoricalBalancesIntervalValue.valueOf(interval);
			Integer skipValue = StringUtils.isEmpty(skip) ? null : Integer.parseInt(skip);
			Integer topValue = StringUtils.isEmpty(top) ? null : Integer.parseInt(top);
			ApiResponse<AccountHistoricalBalancesResponse> historicalBalances =
					accountsApi.getHistoricalBalances(accountIdAccounts, toDateValue, fromDateValue, accountIncludeCF,
							intervalValue, skipValue, topValue);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, historicalBalances);
			assertEquals(historicalBalances.getStatusCode(), 200);
			assertNotNull(historicalBalances.getData());
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void createManualAccountTest(AccountsApi accountsApi, String testCaseId, String testCaseName,
			String fileName) {
		try {
			CreateAccountRequest accountParam = ModelUtil.load(fileName, CreateAccountRequest.class);
			ApiResponse<CreatedAccountResponse> createManualAccountResponse =
					accountsApi.createManualAccount(accountParam);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, createManualAccountResponse);
			assertEquals(createManualAccountResponse.getStatusCode(), 201);
			assertNotNull(createManualAccountResponse);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void updateAccountTest(AccountsApi accountsApi, String testCaseId, String testCaseName,
			String accountId, String fileName) {
		try {
			UpdateAccountRequest accountRequest = ModelUtil.load(fileName, UpdateAccountRequest.class);
			Long accountAccountId = StringUtils.isEmpty(accountId) ? null : Long.parseLong(accountId);
			ApiResponse<AbstractModelComponent> updateAccount =
					accountsApi.updateAccount(accountAccountId, accountRequest);
			assertEquals(updateAccount.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void deleteAccountWithSpecificIdTest(AccountsApi accountsApi, String testCaseId, String testCaseName,
			String accountId) {
		try {
			Long accountsAccountId = StringUtils.isEmpty(accountId) ? null : Long.parseLong(accountId);
			ApiResponse<AbstractModelComponent> deleteAccount = accountsApi.deleteAccount(accountsAccountId);
			assertEquals(deleteAccount.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void deleteAccountTest(AccountsApi accountsApi, String testCaseId, String testCaseName,
			String fileName) {
		try {
			CreateAccountRequest accountParam = ModelUtil.load(fileName, CreateAccountRequest.class);
			ApiResponse<CreatedAccountResponse> createManualAccountResponse =
					accountsApi.createManualAccount(accountParam);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, createManualAccountResponse);
			Long accountIdValue = createManualAccountResponse.getData().getAccount().get(0).getId();
			ApiResponse<AbstractModelComponent> deleteAccount = accountsApi.deleteAccount(accountIdValue);
			assertEquals(deleteAccount.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void evaluateAddressTest(AccountsApi accountsApi, String testCaseId, String testCaseName,
			String fileName, String enabled) {
		try {
			EvaluateAddressRequest evaluateAddressRequest = ModelUtil.load(fileName, EvaluateAddressRequest.class);
			ApiResponse<EvaluateAddressResponse> evaluateAddressResponse =
					accountsApi.evaluateAddress(evaluateAddressRequest);
			assertEquals(evaluateAddressResponse.getStatusCode(), 200);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	private static Long[] convertStringtoLongArray(String param) {
		if (StringUtils.isBlank(param))
			return null;
		String[] stringArray = param.split("#");
		Long[] value = new Long[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			value[i] = Long.valueOf(stringArray[i]);
		}
		return value;
	}

	public static void getAssociatedAccountsTest(AccountsApi accountsApi, String testCaseId, String testCaseName,
			String pAccId) {
		try {
			Long providerAccountId = StringUtils.isEmpty(pAccId) ? null : Long.parseLong(pAccId);
			ApiResponse<AssociatedAccountsResponse> associatedAccounts =
					accountsApi.getAssociatedAccounts(providerAccountId);
			assertEquals(associatedAccounts.getStatusCode(), 200);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void migrateAccountsTest(AccountsApi accountsApi, String testCaseId, String testCaseName,
			String pAccId) {
		try {
			Long providerAccountId = StringUtils.isEmpty(pAccId) ? null : Long.parseLong(pAccId);
			ApiResponse<AccountMigrationResponse> migrateAccounts = accountsApi.migrateAccounts(providerAccountId);
			assertEquals(migrateAccounts.getStatusCode(), 200);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
	
	public static void getAccountBalanceTest(AccountsApi accountsApi, String testCaseId, String testCaseName,
			String accountIds, String providerAcctId) {
		try {
			Long providerAccountId = StringUtils.isEmpty(providerAcctId) ? null : Long.parseLong(providerAcctId);
			Long[] accountIdValue = StringUtils.isBlank(accountIds) ? null : convertStringtoLongArray(accountIds);
			ApiResponse<AccountBalanceResponse> accountBalanceResponse =
					accountsApi.getAccountBalance(accountIdValue,providerAccountId);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, accountBalanceResponse);
			assertEquals(accountBalanceResponse.getStatusCode(), 200);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
}
