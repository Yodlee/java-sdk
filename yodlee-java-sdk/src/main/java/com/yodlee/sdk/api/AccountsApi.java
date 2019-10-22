/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.squareup.okhttp.Call;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.account.enums.ItemAccountStatus;
import com.yodlee.api.model.account.request.CreateAccountRequest;
import com.yodlee.api.model.account.request.UpdateAccountRequest;
import com.yodlee.api.model.account.response.AccountHistoricalBalancesResponse;
import com.yodlee.api.model.account.response.AccountResponse;
import com.yodlee.api.model.account.response.CreatedAccountResponse;
import com.yodlee.api.model.enums.Container;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;
import com.yodlee.sdk.api.validators.AccountsValidator;
import com.yodlee.sdk.api.validators.AccountsValidator.HistoricalBalancesIntervalValue;
import com.yodlee.sdk.api.validators.AccountsValidator.IncludeParameterValue;
import com.yodlee.sdk.client.ApiCallback;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.client.ApiContext;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.client.CallContext;
import com.yodlee.sdk.client.HttpMethod;
import com.yodlee.sdk.client.Pair;
import com.yodlee.sdk.context.Context;

public class AccountsApi extends AbstractApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountsApi.class);

	private static final String PARAM_TOP = "top";

	private static final String PARAM_SKIP = "skip";

	private static final String PARAM_INTERVAL = "interval";

	private static final String PARAM_INCLUDE_CF = "includeCF";

	private static final String PARAM_FROM_DATE = "fromDate";

	private static final String PARAM_TO_DATE = "toDate";

	private static final String PARAM_STATUS = "status";

	private static final String PARAM_REQUEST_ID = "requestId";

	private static final String PARAM_PROVIDER_ACCOUNT_ID = "providerAccountId";

	private static final String PARAM_INCLUDE = "include";

	private static final String PARAM_ACCOUNT_ID = "accountId";

	private static final String PARAM_CONTAINER = "container";

	public AccountsApi(Context<?> context) {
		super(context);
	}

	/**
	 * Get Account Details <br>
	 * The get account details service provides detailed information of an account.<br>
	 * 
	 * @param accountId accountId (required)
	 * @param container bank/creditCard/investment/insurance/loan/reward/bill/realEstate/otherAssets/otherLiabilities
	 *        (required)
	 * @param include profile, holder, fullAccountNumber, paymentProfile, autoRefresh (optional)
	 * @return {@link ApiResponse}&lt;{@link AccountResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AccountResponse> getAccount(//
			@Digits(integer = 11, fraction = 0, message = "{accounts.param.accountId.invalid}") //
			@Min(value = 1, message = "{accounts.param.accountId.invalid}") long accountId,//
			@NotNull(message = "{accounts.param.container.required}") Container container,//
			IncludeParameterValue[] include) throws ApiException {
		LOGGER.info("Accounts getAccount API execution started");
		AccountsValidator.validateGetAccount(this, ApiUtils.getMethodName(), accountId, container, include);
		CallContext callContext = buildGetAccountContext(accountId, container, include);
		return callContext.getApiClient().execute(callContext.getCall(), AccountResponse.class);
	}

	/**
	 * Get Account Details <br>
	 * The get account details service provides detailed information of an account.<br>
	 * 
	 * @param accountId accountId (required)
	 * @param container bank/creditCard/investment/insurance/loan/reward/bill/realEstate/otherAssets/otherLiabilities
	 *        (required)
	 * @param include profile, holder, fullAccountNumber, paymentProfile, autoRefresh (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link AccountResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getAccountAsync(//
			@Digits(integer = 11, fraction = 0, message = "{accounts.param.accountId.invalid}") //
			@Min(value = 1, message = "{accounts.param.accountId.invalid}") long accountId,//
			@NotNull(message = "{accounts.param.container.required}") Container container,//
			IncludeParameterValue[] include, ApiCallback<AccountResponse> apiCallback) throws ApiException {
		LOGGER.info("Accounts getAccountAsync API execution started");
		AccountsValidator.validateGetAccount(this, ApiUtils.getMethodName(), accountId, container, include);
		CallContext callContext = buildGetAccountContext(accountId, container, include);
		callContext.getApiClient().executeAsync(callContext.getCall(), AccountResponse.class, apiCallback);
	}

	private CallContext buildGetAccountContext(long accountId, Container container, IncludeParameterValue[] include)
			throws ApiException {
		String endPoint =
				replacePathVariable(ApiEndpoint.ACCOUNT_ACCOUNTID, PARAM_ACCOUNT_ID, String.valueOf(accountId));
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(endPoint, HttpMethod.GET, null);
		if (container != null) {
			apiContext.addQueryParam(new Pair(PARAM_CONTAINER, container.name()));
		}
		if (include != null) {
			apiContext.addQueryParam(new Pair(PARAM_INCLUDE, ApiUtils.convertArrayToString(include)));
		}
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get Accounts The get accounts service provides information about accounts added by the user.<br>
	 * By default, this service returns information for active and to be closed accounts.<br>
	 * If requestId is provided, the accounts that are updated in the context of the requestId will be provided in the
	 * response.<br>
	 * 
	 * @param accountId Comma separated accountIds (optional)
	 * @param container bank/creditCard/investment/insurance/loan/reward/bill/realEstate/otherAssets/otherLiabilities
	 *        (optional)
	 * @param include profile, holder, fullAccountNumber, paymentProfile, autoRefresh (optional)
	 * @param providerAccountId Comma separated providerAccountIds (optional)
	 * @param requestId The unique identifier that returns contextual data (optional)
	 * @param status Comma separated values ACTIVE/INACTIVE/TO_BE_CLOSED/CLOSED (optional)
	 * @return {@link ApiResponse}&lt;{@link AccountResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AccountResponse> getAllAccounts(//
			@Size(min = 0, max = 100, message = "{accounts.param.accountId.length.invalid}") Long[] accountId,//
			Container container,//
			IncludeParameterValue[] include,//
			@Size(min = 0,
				  max = 100,
				  message = "{accounts.param.providerAccountId.length.invalid}") Long[] providerAccountId,//
			String requestId,//
			ItemAccountStatus[] status) throws ApiException {
		LOGGER.info("Accounts getAllAccounts API execution started");
		AccountsValidator.validateGetAllAccounts(this, ApiUtils.getMethodName(), accountId, container, include,
				providerAccountId, requestId, status);
		CallContext callContext =
				buildAllAccountsContext(accountId, container, include, providerAccountId, requestId, status);
		return callContext.getApiClient().execute(callContext.getCall(), AccountResponse.class);
	}

	/**
	 * Get Accounts The get accounts service provides information about accounts added by the user.<br>
	 * By default, this service returns information for active and to be closed accounts.<br>
	 * If requestId is provided, the accounts that are updated in the context of the requestId will be provided in the
	 * response.<br>
	 * 
	 * @param accountId Comma separated accountIds (optional)
	 * @param container bank/creditCard/investment/insurance/loan/reward/bill/realEstate/otherAssets/otherLiabilities
	 *        (optional)
	 * @param include profile, holder, fullAccountNumber, paymentProfile, autoRefresh (optional)
	 * @param providerAccountId Comma separated providerAccountIds (optional)
	 * @param requestId The unique identifier that returns contextual data (optional)
	 * @param status Comma separated values ACTIVE/INACTIVE/TO_BE_CLOSED/CLOSED (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link AccountResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getAllAccountsAsync(//
			@Size(min = 0, max = 100, message = "{accounts.param.accountId.length.invalid}") Long[] accountId,//
			Container container,//
			IncludeParameterValue[] include,//
			@Size(min = 0,
				  max = 100,
				  message = "{accounts.param.providerAccountId.length.invalid}") Long[] providerAccountId,//
			String requestId,//
			ItemAccountStatus[] status, ApiCallback<AccountResponse> apiCallback) throws ApiException {
		LOGGER.info("Accounts getAllAccountsAsync API execution started");
		AccountsValidator.validateGetAllAccounts(this, ApiUtils.getMethodName(), accountId, container, include,
				providerAccountId, requestId, status);
		CallContext callContext =
				buildAllAccountsContext(accountId, container, include, providerAccountId, requestId, status);
		callContext.getApiClient().executeAsync(callContext.getCall(), AccountResponse.class, apiCallback);
	}

	private CallContext buildAllAccountsContext(Long[] accountId,//
			Container container,//
			IncludeParameterValue[] include,//
			Long[] providerAccountId,//
			String requestId,//
			ItemAccountStatus[] status) throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(ApiEndpoint.ACCOUNTS, HttpMethod.GET, null);
		if (accountId != null) {
			apiContext.addQueryParam(new Pair(PARAM_ACCOUNT_ID, ApiUtils.convertArrayToString(accountId)));
		}
		if (container != null) {
			apiContext.addQueryParam(new Pair(PARAM_CONTAINER, container.name()));
		}
		if (include != null) {
			apiContext.addQueryParam(new Pair(PARAM_INCLUDE, ApiUtils.convertArrayToString(include)));
		}
		if (providerAccountId != null) {
			apiContext.addQueryParam(
					new Pair(PARAM_PROVIDER_ACCOUNT_ID, ApiUtils.convertArrayToString(providerAccountId)));
		}
		if (!StringUtils.isEmpty(requestId)) {
			apiContext.addQueryParam(new Pair(PARAM_REQUEST_ID, requestId));
		}
		if (status != null) {
			apiContext.addQueryParam(new Pair(PARAM_STATUS, ApiUtils.convertArrayToString(status)));
		}
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get Historical Balances The historical balances service is used to retrieve the historical balances for an
	 * account or a user.<br>
	 * Historical balances are daily (D), weekly (W), and monthly (M). <br>
	 * The interval input should be passed as D, W, and M to retrieve the desired historical balances. The default
	 * interval is daily (D). <br>
	 * When no account id is provided, historical balances of the accounts that are active, to be closed, and closed are
	 * provided in the response. <br>
	 * If the fromDate and toDate are not passed, the last 90 days of data will be provided. <br>
	 * The date field in the response denotes the date for which the balance is requested.<br>
	 * includeCF needs to be sent as true if the customer wants to return carried forward balances <br>
	 * for a date when the data is not available. <br>
	 * asofDate field in the response denotes the date as of which the balance was updated for that account.<br>
	 * When there is no balance available for a requested date and if includeCF is sent as true, the previous <br>
	 * date for which the balance is available is provided in the response. When there is no previous <br>
	 * balance available, no data will be sent. <br>
	 * 
	 * @param accountId accountId (optional)
	 * @param toDate toDate for balance retrieval (optional)
	 * @param fromDate from date for balance retrieval (optional)
	 * @param includeCF Consider carry forward logic for missing balances (optional)
	 * @param interval D-daily, W-weekly or M-monthly (optional)
	 * @param skip skip (Min 0) (optional)
	 * @param top top (Max 500) (optional)
	 * @return {@link ApiResponse}&lt;{@link AccountHistoricalBalancesResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AccountHistoricalBalancesResponse> getHistoricalBalances(//
			@Digits(integer = 11, fraction = 0, message = "{accounts.param.accountId.invalid}")//
			@Min(value = 1, message = "{accounts.param.accountId.invalid}") Long accountId, Date toDate,//
			Date fromDate,//
			Boolean includeCF, //
			HistoricalBalancesIntervalValue interval, //
			@Min(value = 0, message = "{accounts.param.skip.invalid}") Integer skip,//
			@Min(value = 1, message = "{accounts.param.top.invalid}") //
			@Max(value = 500, message = "{accounts.param.top.invalid}") Integer top) throws ApiException {
		LOGGER.info("Accounts getHistoricalBalances API execution started");
		AccountsValidator.validateGetHistoricalBalances(this, ApiUtils.getMethodName(), accountId, toDate, fromDate,
				includeCF, interval, skip, top);
		CallContext callContext =
				buildGetHistoricalBalancesContext(accountId, toDate, fromDate, includeCF, interval, skip, top);
		return callContext.getApiClient().execute(callContext.getCall(), AccountHistoricalBalancesResponse.class);
	}

	/**
	 * Get Historical Balances The historical balances service is used to retrieve the historical balances for an
	 * account or a user.<br>
	 * Historical balances are daily (D), weekly (W), and monthly (M). <br>
	 * The interval input should be passed as D, W, and M to retrieve the desired historical balances. The default
	 * interval is daily (D). <br>
	 * When no account id is provided, historical balances of the accounts that are active, to be closed, and closed are
	 * provided in the response. <br>
	 * If the fromDate and toDate are not passed, the last 90 days of data will be provided. <br>
	 * The date field in the response denotes the date for which the balance is requested.<br>
	 * includeCF needs to be sent as true if the customer wants to return carried forward balances <br>
	 * for a date when the data is not available. <br>
	 * asofDate field in the response denotes the date as of which the balance was updated for that account.<br>
	 * When there is no balance available for a requested date and if includeCF is sent as true, the previous <br>
	 * date for which the balance is available is provided in the response. When there is no previous <br>
	 * balance available, no data will be sent. <br>
	 * 
	 * @param accountId accountId (optional)
	 * @param toDate toDate for balance retrieval (optional)
	 * @param fromDate from date for balance retrieval (optional)
	 * @param includeCF Consider carry forward logic for missing balances (optional)
	 * @param interval D-daily, W-weekly or M-monthly (optional)
	 * @param skip skip (Min 0) (optional)
	 * @param top top (Max 500) (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link AccountHistoricalBalancesResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getHistoricalBalancesAsync(
			@Digits(integer = 11, fraction = 0, message = "{accounts.param.accountId.invalid}")//
			@Min(value = 1, message = "{accounts.param.accountId.invalid}") Long accountId, Date toDate,//
			Date fromDate,//
			Boolean includeCF, //
			HistoricalBalancesIntervalValue interval, //
			@Min(value = 0, message = "{accounts.param.skip.invalid}") Integer skip,//
			@Min(value = 1, message = "{accounts.param.top.invalid}") //
			@Max(value = 500, message = "{accounts.param.top.invalid}") Integer top,
			ApiCallback<AccountHistoricalBalancesResponse> apiCallback) throws ApiException {
		LOGGER.info("Accounts getHistoricalBalancesAsync API execution started");
		AccountsValidator.validateGetHistoricalBalances(this, ApiUtils.getMethodName(), accountId, toDate, fromDate,
				includeCF, interval, skip, top);
		CallContext callContext =
				buildGetHistoricalBalancesContext(accountId, toDate, fromDate, includeCF, interval, skip, top);
		callContext.getApiClient().executeAsync(callContext.getCall(), AccountHistoricalBalancesResponse.class,
				apiCallback);
	}

	private CallContext buildGetHistoricalBalancesContext(Long accountId, Date toDate,//
			Date fromDate,//
			Boolean includeCF, //
			HistoricalBalancesIntervalValue interval, //
			Integer skip,//
			Integer top) throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(ApiEndpoint.GET_HISTORICAL_BALANCES, HttpMethod.GET, null);
		SimpleDateFormat formatter = new SimpleDateFormat(ApiConstants.YYYY_MM_DD);
		if (accountId != null) {
			apiContext.addQueryParam(new Pair(PARAM_ACCOUNT_ID, accountId.toString()));
		}
		if (toDate != null) {
			String formattedFromDate = formatter.format(toDate);
			apiContext.addQueryParam(new Pair(PARAM_TO_DATE, formattedFromDate));
		}
		if (fromDate != null) {
			String formattedFromDate = formatter.format(fromDate);
			apiContext.addQueryParam(new Pair(PARAM_FROM_DATE, formattedFromDate));
		}
		if (includeCF != null) {
			apiContext.addQueryParam(new Pair(PARAM_INCLUDE_CF, includeCF.toString()));
		}
		if (interval != null) {
			apiContext.addQueryParam(new Pair(PARAM_INTERVAL, interval.name()));
		}
		if (skip != null) {
			apiContext.addQueryParam(new Pair(PARAM_SKIP, skip.toString()));
		}
		if (top != null) {
			apiContext.addQueryParam(new Pair(PARAM_TOP, top.toString()));
		}
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Add Manual Account The add account service is used to add manual accounts.<br>
	 * The response of add account service includes the account name , account number and Yodlee generated account
	 * id.<br>
	 * All manual accounts added will be included as part of networth calculation by default.<br>
	 * Add manual account support is available for bank, card, investment, insurance, loan and bills container only.<br>
	 * 
	 * @param accountParam accountParam (required)
	 * @return {@link ApiResponse}&lt;{@link CreatedAccountResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<CreatedAccountResponse> createManualAccount(
			@NotNull(message = "{accounts.manualAccountInfo.required}") CreateAccountRequest accountParam)
			throws ApiException {
		LOGGER.info("Accounts createManualAccount API execution started");
		AccountsValidator.validateCreateManualAccount(this, ApiUtils.getMethodName(), accountParam);
		CallContext callContext = buildcreateManualAccountContext(accountParam);
		return callContext.getApiClient().execute(callContext.getCall(), CreatedAccountResponse.class);
	}

	/**
	 * Add Manual Account The add account service is used to add manual accounts.<br>
	 * The response of add account service includes the account name , account number and Yodlee generated account
	 * id.<br>
	 * All manual accounts added will be included as part of networth calculation by default.<br>
	 * Add manual account support is available for bank, card, investment, insurance, loan and bills container only.<br>
	 * 
	 * @param accountParam accountParam (required)
	 * @param apiCallback {@link ApiCallback}&lt;{@link CreatedAccountResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void createManualAccountAsync(
			@NotNull(message = "{accounts.manualAccountInfo.required}") CreateAccountRequest accountParam,
			ApiCallback<CreatedAccountResponse> apiCallback) throws ApiException {
		LOGGER.info("Accounts createManualAccountAsync API execution started");
		AccountsValidator.validateCreateManualAccount(this, ApiUtils.getMethodName(), accountParam);
		CallContext callContext = buildcreateManualAccountContext(accountParam);
		callContext.getApiClient().executeAsync(callContext.getCall(), CreatedAccountResponse.class, apiCallback);
	}

	private CallContext buildcreateManualAccountContext(CreateAccountRequest accountParam) throws ApiException {
		AccountsValidator.validateCreateManualAccount(this, ApiUtils.getMethodName(), accountParam);
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(ApiEndpoint.ACCOUNTS, HttpMethod.POST, accountParam);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Update Account The update account service is used to update manual and aggregated accounts.<br>
	 * The HTTP response code is 204 (Success without content).<br>
	 * Update manual account support is available for bank, card, investment, insurance, loan, bills, otherAssets,
	 * otherLiabilities and realEstate containers only.<br>
	 * <b>Note:</b> A real estate account update is only supported for manual valuation.<br>
	 * 
	 * @param accountId accountId (required)
	 * @param accountRequest accountRequest (required)
	 * @return null
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> updateAccount(
			@Digits(integer = 11, fraction = 0, message = "{accounts.param.accountId.invalid}") long accountId, //
			@NotNull(message = "{accounts.accountInfo.required}") UpdateAccountRequest accountRequest)
			throws ApiException {
		LOGGER.info("Accounts updateAccount API execution started");
		AccountsValidator.validateUpdateAccount(this, ApiUtils.getMethodName(), accountId, accountRequest);
		CallContext callContext = buildUpdateAccountContext(accountId, accountRequest);
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Update Account The update account service is used to update manual and aggregated accounts.<br>
	 * The HTTP response code is 204 (Success without content).<br>
	 * Update manual account support is available for bank, card, investment, insurance, loan, bills, otherAssets,
	 * otherLiabilities and realEstate containers only.<br>
	 * <b>Note:</b> A real estate account update is only supported for manual valuation.<br>
	 * 
	 * @param accountId accountId (required)
	 * @param accountRequest accountRequest (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void updateAccountAsync(
			@Digits(integer = 11, fraction = 0, message = "{accounts.param.accountId.invalid}") long accountId, //
			@NotNull(message = "{accounts.accountInfo.required}") UpdateAccountRequest accountRequest,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Accounts updateAccountAsync API execution started");
		AccountsValidator.validateUpdateAccount(this, ApiUtils.getMethodName(), accountId, accountRequest);
		CallContext callContext = buildUpdateAccountContext(accountId, accountRequest);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildUpdateAccountContext(long accountId, //
			UpdateAccountRequest accountRequest) throws ApiException {
		String endpoint =
				replacePathVariable(ApiEndpoint.ACCOUNT_ACCOUNTID, PARAM_ACCOUNT_ID, String.valueOf(accountId));
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(endpoint, HttpMethod.PUT, accountRequest);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Delete Account The delete account service allows an account to be deleted.<br>
	 * This service does not return a response. The HTTP response code is 204 (Success with no content).<br>
	 * 
	 * @param accountId accountId (required)
	 * @return null
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> deleteAccount(
			@Digits(integer = 11, fraction = 0, message = "{accounts.param.accountId.invalid}") long accountId)
			throws ApiException {
		LOGGER.info("Accounts deleteAccount API execution started");
		AccountsValidator.validateDeleteAccount(this, ApiUtils.getMethodName(), accountId);
		CallContext callContext = buildDeleteAccountContext(accountId);
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Delete Account The delete account service allows an account to be deleted.<br>
	 * This service does not return a response. The HTTP response code is 204 (Success with no content).<br>
	 * 
	 * @param accountId accountId (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void deleteAccountAsync(
			@Digits(integer = 11, fraction = 0, message = "{accounts.param.accountId.invalid}") long accountId,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Accounts deleteAccountAsync API execution started");
		AccountsValidator.validateDeleteAccount(this, ApiUtils.getMethodName(), accountId);
		CallContext callContext = buildDeleteAccountContext(accountId);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildDeleteAccountContext(long accountId) throws ApiException {
		String endpoint =
				replacePathVariable(ApiEndpoint.ACCOUNT_ACCOUNTID, PARAM_ACCOUNT_ID, String.valueOf(accountId));
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(endpoint, HttpMethod.DELETE, null);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}
}
