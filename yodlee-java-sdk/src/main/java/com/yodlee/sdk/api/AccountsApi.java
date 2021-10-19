/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import okhttp3.Call;

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
	 * <b> Note : </b> fullAccountNumber is deprecated and is replaced with fullAccountNumberList in include parameter
	 * and response.
	 * 
	 * @param accountId accountId (required)
	 * @param include profile, holder, fullAccountNumberList, paymentProfile, autoRefresh (optional)
	 * @return {@link ApiResponse}&lt;{@link AccountResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AccountResponse> getAccount(//
			@Digits(integer = 11, fraction = 0, message = "{accounts.param.accountId.invalid}") //
			@Min(value = 1, message = "{accounts.param.accountId.invalid}") long accountId, //
			IncludeParameterValue[] include) throws ApiException {
		LOGGER.info("Accounts getAccount API execution started");
		AccountsValidator.validateGetAccount(this, ApiUtils.getMethodName(), accountId, include);
		CallContext callContext = buildGetAccountContext(accountId, include, null);
		return callContext.getApiClient().execute(callContext.getCall(), AccountResponse.class);
	}

	/**
	 * Get Account Details with request Headers. <br>
	 * The get account details service provides detailed information of an account.<br>
	 * 
	 * <b> Note : </b> fullAccountNumber is deprecated and is replaced with fullAccountNumberList in include parameter
	 * and response.
	 * 
	 * @param accountId accountId (required)
	 * @param include profile, holder, fullAccountNumberList, paymentProfile, autoRefresh (optional)
	 * @param headers Map of headers key-value pair e.g (Accept-Encoding, gzip) (required)
	 * @return {@link ApiResponse}&lt;{@link AccountResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AccountResponse> getAccount(//
			@Digits(integer = 11, fraction = 0, message = "{accounts.param.accountId.invalid}") //
			@Min(value = 1, message = "{accounts.param.accountId.invalid}") long accountId, //
			IncludeParameterValue[] include, //
			Map<String, String> headers) throws ApiException {
		LOGGER.info("Accounts getAccountwithGzip API execution started");
		String contentEncodingValue = headers.get(ApiConstants.ACCEPT_ENCODING);
		AccountsValidator.validateGetAccount(this, ApiUtils.getMethodName(), accountId, include);
		CallContext callContext = buildGetAccountContext(accountId, include, contentEncodingValue);
		return callContext.getApiClient().execute(callContext.getCall(), AccountResponse.class);
	}

	/**
	 * Get Account Details <br>
	 * The get account details service provides detailed information of an account.<br>
	 * 
	 * <b> Note : </b> fullAccountNumber is deprecated and is replaced with fullAccountNumberList in include parameter
	 * and response.
	 * 
	 * @param accountId accountId (required)
	 * @param include profile, holder, fullAccountNumberList, paymentProfile, autoRefresh (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link AccountResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getAccountAsync(//
			@Digits(integer = 11, fraction = 0, message = "{accounts.param.accountId.invalid}") //
			@Min(value = 1, message = "{accounts.param.accountId.invalid}") long accountId, //
			IncludeParameterValue[] include, ApiCallback<AccountResponse> apiCallback) throws ApiException {
		LOGGER.info("Accounts getAccountAsync API execution started");
		AccountsValidator.validateGetAccount(this, ApiUtils.getMethodName(), accountId, include);
		CallContext callContext = buildGetAccountContext(accountId, include, null);
		callContext.getApiClient().executeAsync(callContext.getCall(), AccountResponse.class, apiCallback);
	}

	private CallContext buildGetAccountContext(long accountId, IncludeParameterValue[] include, String contentEncoding)
			throws ApiException {
		String endPoint =
				replacePathVariable(ApiEndpoint.ACCOUNT_ACCOUNTID, PARAM_ACCOUNT_ID, String.valueOf(accountId));
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(endPoint, HttpMethod.GET, null);
		if (include != null) {
			apiContext.addQueryParam(new Pair(PARAM_INCLUDE, ApiUtils.convertArrayToString(include)));
		}
		if (contentEncoding != null) {
			apiContext.addHeaderParam(ApiConstants.ACCEPT_ENCODING, contentEncoding);
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
	 * <b> Note : </b> fullAccountNumber is deprecated and is replaced with fullAccountNumberList in include parameter
	 * and response.
	 * 
	 * @param accountId Comma separated accountIds (optional)
	 * @param container bank/creditCard/investment/insurance/loan/reward/bill/realEstate/otherAssets/otherLiabilities
	 *        (optional)
	 * @param include profile, holder, fullAccountNumberList, paymentProfile, autoRefresh (optional)
	 * @param providerAccountId Comma separated providerAccountIds (optional)
	 * @param requestId The unique identifier that returns contextual data (optional)
	 * @param status Comma separated values ACTIVE/INACTIVE/TO_BE_CLOSED/CLOSED (optional)
	 * @return {@link ApiResponse}&lt;{@link AccountResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AccountResponse> getAllAccounts(//
			@Size(min = 0, max = 100, message = "{accounts.param.accountId.length.invalid}") Long[] accountId, //
			Container container, //
			IncludeParameterValue[] include, //
			@Size(min = 0,
				  max = 100,
				  message = "{accounts.param.providerAccountId.length.invalid}") Long[] providerAccountId, //
			String requestId, //
			ItemAccountStatus[] status) throws ApiException {
		LOGGER.info("Accounts getAllAccounts API execution started");
		AccountsValidator.validateGetAllAccounts(this, ApiUtils.getMethodName(), accountId, container, include,
				providerAccountId, requestId, status);
		CallContext callContext =
				buildAllAccountsContext(accountId, container, include, providerAccountId, requestId, status, null);
		return callContext.getApiClient().execute(callContext.getCall(), AccountResponse.class);
	}
	
	
	/**
	 * Get All Accounts with Gzip Header
	 * Get Accounts The get accounts service provides information about accounts added by the user.<br>
	 * By default, this service returns information for active and to be closed accounts.<br>
	 * If requestId is provided, the accounts that are updated in the context of the requestId will be provided in the
	 * response.<br>
	 * 
	 * <b> Note : </b> fullAccountNumber is deprecated and is replaced with fullAccountNumberList in include parameter
	 * and response.
	 * 
	 * @param accountId Comma separated accountIds (optional)
	 * @param container bank/creditCard/investment/insurance/loan/reward/bill/realEstate/otherAssets/otherLiabilities
	 *        (optional)
	 * @param include profile, holder, fullAccountNumberList, paymentProfile, autoRefresh (optional)
	 * @param providerAccountId Comma separated providerAccountIds (optional)
	 * @param requestId The unique identifier that returns contextual data (optional)
	 * @param status Comma separated values ACTIVE/INACTIVE/TO_BE_CLOSED/CLOSED (optional)
	 * @param headers Map of headers key-value pair e.g (Accept-Encoding, gzip) (required)
	 * @return {@link ApiResponse}&lt;{@link AccountResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AccountResponse> getAllAccounts(//
			@Size(min = 0, max = 100, message = "{accounts.param.accountId.length.invalid}") Long[] accountId, //
			Container container, //
			IncludeParameterValue[] include, //
			@Size(min = 0,
				  max = 100,
				  message = "{accounts.param.providerAccountId.length.invalid}") Long[] providerAccountId, //
			String requestId, //
			ItemAccountStatus[] status, //
			Map<String, String> headers) throws ApiException {
		LOGGER.info("Accounts getAllAccounts API execution started");
		String contentEncodingValue = headers.get(ApiConstants.ACCEPT_ENCODING);
		AccountsValidator.validateGetAllAccounts(this, ApiUtils.getMethodName(), accountId, container, include,
				providerAccountId, requestId, status);
		CallContext callContext =
				buildAllAccountsContext(accountId, container, include, providerAccountId, requestId, status, contentEncodingValue);
		return callContext.getApiClient().execute(callContext.getCall(), AccountResponse.class);
	}

	/**
	 * Get Accounts The get accounts service provides information about accounts added by the user.<br>
	 * By default, this service returns information for active and to be closed accounts.<br>
	 * If requestId is provided, the accounts that are updated in the context of the requestId will be provided in the
	 * response.<br>
	 * 
	 * <b> Note : </b> fullAccountNumber is deprecated and is replaced with fullAccountNumberList in include parameter
	 * and response.
	 * 
	 * @param accountId Comma separated accountIds (optional)
	 * @param container bank/creditCard/investment/insurance/loan/reward/bill/realEstate/otherAssets/otherLiabilities
	 *        (optional)
	 * @param include profile, holder, fullAccountNumberList, paymentProfile, autoRefresh (optional)
	 * @param providerAccountId Comma separated providerAccountIds (optional)
	 * @param requestId The unique identifier that returns contextual data (optional)
	 * @param status Comma separated values ACTIVE/INACTIVE/TO_BE_CLOSED/CLOSED (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link AccountResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getAllAccountsAsync(//
			@Size(min = 0, max = 100, message = "{accounts.param.accountId.length.invalid}") Long[] accountId, //
			Container container, //
			IncludeParameterValue[] include, //
			@Size(min = 0,
				  max = 100,
				  message = "{accounts.param.providerAccountId.length.invalid}") Long[] providerAccountId, //
			String requestId, //
			ItemAccountStatus[] status, ApiCallback<AccountResponse> apiCallback) throws ApiException {
		LOGGER.info("Accounts getAllAccountsAsync API execution started");
		AccountsValidator.validateGetAllAccounts(this, ApiUtils.getMethodName(), accountId, container, include,
				providerAccountId, requestId, status);
		CallContext callContext =
				buildAllAccountsContext(accountId, container, include, providerAccountId, requestId, status, null);
		callContext.getApiClient().executeAsync(callContext.getCall(), AccountResponse.class, apiCallback);
	}
	
	private CallContext buildAllAccountsContext(Long[] accountId, //
			Container container, //
			IncludeParameterValue[] include, //
			Long[] providerAccountId, //
			String requestId, //
			ItemAccountStatus[] status, //
			String contentEncoding) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
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
		if (contentEncoding != null) {
			apiContext.addHeaderParam(ApiConstants.ACCEPT_ENCODING, contentEncoding);
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
			@Digits(integer = 11, fraction = 0, message = "{accounts.param.accountId.invalid}") //
			@Min(value = 1, message = "{accounts.param.accountId.invalid}") Long accountId, Date toDate, //
			Date fromDate, //
			Boolean includeCF, //
			HistoricalBalancesIntervalValue interval, //
			@Min(value = 0, message = "{accounts.param.skip.invalid}") Integer skip, //
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
			@Digits(integer = 11, fraction = 0, message = "{accounts.param.accountId.invalid}") //
			@Min(value = 1, message = "{accounts.param.accountId.invalid}") Long accountId, Date toDate, //
			Date fromDate, //
			Boolean includeCF, //
			HistoricalBalancesIntervalValue interval, //
			@Min(value = 0, message = "{accounts.param.skip.invalid}") Integer skip, //
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

	private CallContext buildGetHistoricalBalancesContext(Long accountId, Date toDate, //
			Date fromDate, //
			Boolean includeCF, //
			HistoricalBalancesIntervalValue interval, //
			Integer skip, //
			Integer top) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
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
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
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
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
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
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(endpoint, HttpMethod.DELETE, null);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Use this service to validate the address before adding the real estate account.<br>
	 * If the address is valid, the service will return the complete address information.<br>
	 * The response will contain multiple addresses if the user-provided input matches with multiple entries in the
	 * vendor database.<br>
	 * In the case of multiple matches, the user can select the appropriate address from the list and then invoke the
	 * add account service with the complete address.<br>
	 * <b>Note:</b> Yodlee recommends to use this service before adding the real estate account to avoid failures.<br>
	 * 
	 * @param evaluateAddressRequest (required)
	 * @return {@link ApiResponse}&lt;{@link EvaluateAddressResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<EvaluateAddressResponse> evaluateAddress(
			@NotNull(message = "{evaluateAddress.address.required}") EvaluateAddressRequest evaluateAddressRequest)
			throws ApiException {
		LOGGER.info("Evaluate Address API execution started");
		AccountsValidator.validateEvaluateAddress(this, ApiUtils.getMethodName(), evaluateAddressRequest);
		CallContext callContext = buildEvaluateAddressContext(evaluateAddressRequest);
		return callContext.getApiClient().execute(callContext.getCall(), EvaluateAddressResponse.class);
	}

	/**
	 * Use this service to validate the address before adding the real estate account.<br>
	 * If the address is valid, the service will return the complete address information.<br>
	 * The response will contain multiple addresses if the user-provided input matches with multiple entries in the
	 * vendor database.<br>
	 * In the case of multiple matches, the user can select the appropriate address from the list and then invoke the
	 * add account service with the complete address.<br>
	 * <b>Note:</b> Yodlee recommends to use this service before adding the real estate account to avoid failures.<br>
	 * 
	 * @param evaluateAddressRequest (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void evaluateAddressAsync(
			@NotNull(message = "{evaluateAddress.address.required}") EvaluateAddressRequest evaluateAddressRequest,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Evaluate Address Async API execution started");
		AccountsValidator.validateEvaluateAddress(this, ApiUtils.getMethodName(), evaluateAddressRequest);
		CallContext callContext = buildEvaluateAddressContext(evaluateAddressRequest);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildEvaluateAddressContext(EvaluateAddressRequest evaluateAddressRequest) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(ApiEndpoint.EVALUATE_ADDRESS, HttpMethod.POST, evaluateAddressRequest);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Migrate Accounts<br>
	 * This service is associated with the open banking (OB) flow.<br>
	 * Before invoking this service, display all the associated accounts to the user by calling the GET
	 * /associatedAccounts API.<br>
	 * The migrate accounts API treats the user's consent acceptance to initiate account migration. Invoking this
	 * service indicates that the user has given the consent to access the associated account information from the
	 * financial institution.<br>
	 * If an existing provider supports bank, card, and loan accounts, and chose only to provide bank and card through
	 * OB APIs, a new providerAccountId for OB will be created.<br>
	 * The bank and card account information will be moved to the new providerAccountId. The loan account will be
	 * retained in the existing provider account.<br>
	 * This service returns the OB providerId and the OB providerAccountId. Note that, as part of this process, there is
	 * a possibility of one or more providerAccounts getting merged.<br>
	 * The update or delete actions will not be allowed for the providerAccounts involved in the migration process until
	 * the user completes the authorization on the OB provider.<br>
	 * The oauthMigrationEligibilityStatus attribute in the GET /accounts API response indicates the accounts included
	 * in the migration process.<br>
	 * 
	 * @param providerAccountId (required)
	 * @return {@link ApiResponse}&lt;{@link AccountMigrationResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AccountMigrationResponse> migrateAccounts(
			@Digits(integer = 11,
					fraction = 0,
					message = "{accounts.param.providerAccountId.invalid}") long providerAccountId)
			throws ApiException {
		LOGGER.info("Accounts migrateAccounts API execution started");
		AccountsValidator.validateMigrateAccounts(this, ApiUtils.getMethodName(), providerAccountId);
		CallContext callContext = buildMigrateAccountsContext(providerAccountId);
		return callContext.getApiClient().execute(callContext.getCall(), AccountMigrationResponse.class);
	}

	/**
	 * Migrate Accounts<br>
	 * This service is associated with the open banking (OB) flow.<br>
	 * Before invoking this service, display all the associated accounts to the user by calling the GET
	 * /associatedAccounts API.<br>
	 * The migrate accounts API treats the user's consent acceptance to initiate account migration. Invoking this
	 * service indicates that the user has given the consent to access the associated account information from the
	 * financial institution.<br>
	 * If an existing provider supports bank, card, and loan accounts, and chose only to provide bank and card through
	 * OB APIs, a new providerAccountId for OB will be created.<br>
	 * The bank and card account information will be moved to the new providerAccountId. The loan account will be
	 * retained in the existing provider account.<br>
	 * This service returns the OB providerId and the OB providerAccountId. Note that, as part of this process, there is
	 * a possibility of one or more providerAccounts getting merged.<br>
	 * The update or delete actions will not be allowed for the providerAccounts involved in the migration process until
	 * the user completes the authorization on the OB provider.<br>
	 * The oauthMigrationEligibilityStatus attribute in the GET /accounts API response indicates the accounts included
	 * in the migration process.<br>
	 * 
	 * @param providerAccountId (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void migrateAccountsAsync(
			@Digits(integer = 11,
					fraction = 0,
					message = "{accounts.param.providerAccountId.invalid}") long providerAccountId,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Accounts migrateAccountsAsync API execution started");
		AccountsValidator.validateMigrateAccounts(this, ApiUtils.getMethodName(), providerAccountId);
		CallContext callContext = buildMigrateAccountsContext(providerAccountId);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildMigrateAccountsContext(long providerAccountId) throws ApiException {
		String endpoint = replacePathVariable(ApiEndpoint.MIGRATEACCOUNTS_PROVIDERACCOUNTID, PARAM_PROVIDER_ACCOUNT_ID,
				String.valueOf(providerAccountId));
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(endpoint, HttpMethod.PUT, null);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Associated Accounts<br>
	 * Yodlee classifies providers into credential-based aggregation and Open Banking (OB) providers.<br>
	 * This service is associated with the OB aggregation flow. As part of the OB solution, financial institutions may
	 * merge their subsidiaries and provide data as a single OB provider.<br>
	 * Before the OB solution, this data was aggregated with different provider IDs.<br>
	 * This service accepts the providerAccountId and returns all accounts of the associated providerAccounts that
	 * belong to the subsidiary of the financial institution.<br>
	 * This data should be displayed to the user to let them select the accounts that they wish to provide consent to
	 * share account data.<br>
	 * 
	 * @param providerAccountId (required)
	 * @return {@link ApiResponse}&lt;{@link AssociatedAccountsResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AssociatedAccountsResponse> getAssociatedAccounts(
			@Digits(integer = 11,
					fraction = 0,
					message = "{accounts.param.providerAccountId.invalid}") long providerAccountId)
			throws ApiException {
		LOGGER.info("Accounts getAssociatedAccounts API execution started");
		AccountsValidator.validateAssociatedAccounts(this, ApiUtils.getMethodName(), providerAccountId);
		CallContext callContext = buildAssociatedAccountsContext(providerAccountId);
		return callContext.getApiClient().execute(callContext.getCall(), AssociatedAccountsResponse.class);
	}

	/**
	 * Associated Accounts<br>
	 * Yodlee classifies providers into credential-based aggregation and Open Banking (OB) providers.<br>
	 * This service is associated with the OB aggregation flow. As part of the OB solution, financial institutions may
	 * merge their subsidiaries and provide data as a single OB provider.<br>
	 * Before the OB solution, this data was aggregated with different provider IDs.<br>
	 * This service accepts the providerAccountId and returns all accounts of the associated providerAccounts that
	 * belong to the subsidiary of the financial institution.<br>
	 * This data should be displayed to the user to let them select the accounts that they wish to provide consent to
	 * share account data.<br>
	 * 
	 * @param providerAccountId (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getAssociatedAccountsAsync(
			@Digits(integer = 11,
					fraction = 0,
					message = "{accounts.param.providerAccountId.invalid}") long providerAccountId,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Accounts getAssociatedAccountsAsync API execution started");
		AccountsValidator.validateAssociatedAccounts(this, ApiUtils.getMethodName(), providerAccountId);
		CallContext callContext = buildAssociatedAccountsContext(providerAccountId);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildAssociatedAccountsContext(long providerAccountId) throws ApiException {
		String endpoint = replacePathVariable(ApiEndpoint.ASSOCIATEDACCOUNTS_PROVIDERACCOUNTID,
				PARAM_PROVIDER_ACCOUNT_ID, String.valueOf(providerAccountId));
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(endpoint, HttpMethod.GET, null);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Latest Balance<br>
	 * The latest balances service provides the latest account balance by initiating a new balance refresh request.
	 * 
	 * @param accountId accountId (required)
	 * @param providerAccountId providerAccountId (required)
	 * @return {@link ApiResponse}&lt;{@link AccountBalanceResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AccountBalanceResponse>
			getAccountBalance(@Size(min = 0, max = 10, message = "{accounts.param.accountId.length.invalid}") //
					@NotEmpty(message = "{accounts.param.accountId.required}") Long[] accountId,//
					@Digits(integer = 11, fraction = 0, message = "{accounts.param.providerAccountId.invalid}")//
					@NotNull(message = "{providerAccounts.param.providerAccountId.required}") long providerAccountId)
					throws ApiException {
		LOGGER.info("Accounts getAccountBal API execution started");
		AccountsValidator.validateAccountBalance(this, ApiUtils.getMethodName(), accountId, providerAccountId);
		CallContext callContext = buildAccountBalanceContext(accountId, providerAccountId);
		return callContext.getApiClient().execute(callContext.getCall(), AccountBalanceResponse.class);
	}

	/**
	 * Latest Balance<br>
	 * The latest balances service provides the latest account balance by initiating a new balance refresh request.
	 * 
	 * @param accountId accountId (required)
	 * @param providerAccountId providerAccountId (required)
	 * @param apiCallback {@link ApiCallback}&lt;{@link AccountBalanceResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getAccountBalanceAsync(@Size(min = 0, max = 10, message = "{accounts.param.accountId.length.invalid}") //
		@NotEmpty(message = "{accounts.param.accountId.required}") Long[] accountId,//
		@Digits(integer = 11, fraction = 0, message = "{accounts.param.providerAccountId.invalid}")//
		@NotNull(message = "{providerAccounts.param.providerAccountId.required}")//
		long providerAccountId, ApiCallback<AccountBalanceResponse> apiCallback) throws ApiException {
		LOGGER.info("Accounts getAccountBal API execution started");
		AccountsValidator.validateAccountBalance(this, ApiUtils.getMethodName(), accountId, providerAccountId);
		CallContext callContext = buildAccountBalanceContext(accountId, providerAccountId);
		callContext.getApiClient().executeAsync(callContext.getCall(), AccountBalanceResponse.class, apiCallback);
	}

	private CallContext buildAccountBalanceContext(Long[] accountId, long providerAccountId) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(ApiEndpoint.ACCOUNT_BALANCE, HttpMethod.GET, null);
		apiContext.addQueryParam(new Pair(PARAM_ACCOUNT_ID, ApiUtils.convertArrayToString(accountId)));
		apiContext.addQueryParam(new Pair(PARAM_PROVIDER_ACCOUNT_ID, String.valueOf(providerAccountId)));
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}
}
