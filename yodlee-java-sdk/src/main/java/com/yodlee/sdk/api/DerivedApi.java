/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yodlee.api.model.annotations.AllowedContainer;
import com.yodlee.api.model.derived.response.DerivedHoldingSummaryResponse;
import com.yodlee.api.model.derived.response.DerivedNetworthResponse;
import com.yodlee.api.model.derived.response.DerivedTransactionSummaryResponse;
import com.yodlee.api.model.enums.Container;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;
import com.yodlee.sdk.api.validators.DerivedValidator;
import com.yodlee.sdk.api.validators.DerivedValidator.CategoryType;
import com.yodlee.sdk.api.validators.DerivedValidator.DataPointInterval;
import com.yodlee.sdk.api.validators.DerivedValidator.DerivedInclude;
import com.yodlee.sdk.api.validators.DerivedValidator.GroupType;
import com.yodlee.sdk.client.ApiCallback;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.client.ApiContext;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.client.CallContext;
import com.yodlee.sdk.client.HttpMethod;
import com.yodlee.sdk.client.Pair;
import com.yodlee.sdk.context.Context;
import okhttp3.Call;

public class DerivedApi extends AbstractApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(DerivedApi.class);

	private static final String PARAM_CATEGORY_TYPE = "categoryType";

	private static final String PARAM_CATEGORY_ID = "categoryId";

	private static final String PARAM_INCLUDE_USER_CATEGORY = "includeUserCategory";

	private static final String PARAM_TOP = "top";

	private static final String PARAM_TO_DATE = "toDate";

	private static final String PARAM_SKIP = "skip";

	private static final String PARAM_INTERVAL = "interval";

	private static final String PARAM_INCLUDE = "include";

	private static final String PARAM_FROM_DATE = "fromDate";

	private static final String PARAM_ACCOUNT_ID = "accountId";

	private static final String PARAM_ACCOUNT_IDS = "accountIds";

	private static final String PARAM_GROUP_BY = "groupBy";

	private static final String PARAM_CONTAINER = "container";

	public DerivedApi(Context<?> context) {
		super(context);
	}

	/**
	 * Get Transaction Summary The transaction summary service provides the summary values of transactions for the given
	 * date range by category type, high-level categories, or system-defined categories.<br>
	 * <br>
	 * Yodlee has the transaction data stored for a day, month, year and week per category as per the availability of
	 * user&#39;s data. If the include parameter value is passed as details, then summary details will be returned
	 * depending on the interval passed-monthly is the default.<br>
	 * <br>
	 * <b>Notes:</b><br>
	 * 1.Details can be requested for only one system-defined category<br>
	 * 2.Dates will not be respected for monthly, yearly, and weekly details<br>
	 * 3.When monthly details are requested, only the fromDate and toDate month will be respected<br>
	 * 4.When yearly details are requested, only the fromDate and toDate year will be respected<br>
	 * 5.For weekly data points, details will be provided for every Sunday date available within the fromDate and
	 * toDate<br>
	 * 
	 * @param groupBy CATEGORY_TYPE, HIGH_LEVEL_CATEGORY or CATEGORY (required)
	 * @param accountId comma separated account Ids (optional)
	 * @param categoryId comma separated categoryIds (optional)
	 * @param categoryTypes INCOME, EXPENSE, TRANSFER, UNCATEGORIZE or DEFERRED_COMPENSATION (optional)
	 * @param fromDate YYYY-MM-DD format (optional)
	 * @param include details (optional)
	 * @param includeUserCategory TRUE/FALSE (optional)
	 * @param interval D-daily, W-weekly, M-mothly or Y-yearly (optional)
	 * @param toDate YYYY-MM-DD format (optional)
	 * @return {@link ApiResponse}&lt;{@link DerivedTransactionSummaryResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<DerivedTransactionSummaryResponse> getTransactionSummary(//
			@NotNull(message = "{derived.param.groupBy.required}") GroupType groupBy, //
			@Size(min = 0, max = 100, message = "{derived.param.accountId.length.invalid}") Long[] accountId, //
			@Size(min = 0, max = 100, message = "{derived.param.categoryId.length.invalid}") Long[] categoryId,
			@Size(min = 0,
				  max = 100,
				  message = "{derived.param.categoryTypes.length.invalid}") CategoryType[] categoryTypes, //
			@Past(message = "{derived.param.fromDate.invalid}") Date fromDate, //
			DerivedInclude include, //
			Boolean includeUserCategory, //
			DataPointInterval interval, //
			@Past(message = "{derived.param.toDate.invalid}") Date toDate) throws ApiException {
		LOGGER.info("Derived getTransactionSummary API execution started");
		DerivedValidator.validateTransactionSummary(this, ApiUtils.getMethodName(), groupBy, accountId, categoryId,
				categoryTypes, fromDate, include, includeUserCategory, interval, toDate);
		CallContext callContext = buildGetTransactionSummaryContext(groupBy, accountId, categoryId, categoryTypes,
				fromDate, include, includeUserCategory, interval, toDate);
		return callContext.getApiClient().execute(callContext.getCall(), DerivedTransactionSummaryResponse.class);
	}

	/**
	 * Get Transaction Summary The transaction summary service provides the summary values of transactions for the given
	 * date range by category type, high-level categories, or system-defined categories.<br>
	 * <br>
	 * Yodlee has the transaction data stored for a day, month, year and week per category as per the availability of
	 * user&#39;s data. If the include parameter value is passed as details, then summary details will be returned
	 * depending on the interval passed-monthly is the default.<br>
	 * <br>
	 * <b>Notes:</b><br>
	 * 1.Details can be requested for only one system-defined category<br>
	 * 2.Dates will not be respected for monthly, yearly, and weekly details<br>
	 * 3.When monthly details are requested, only the fromDate and toDate month will be respected<br>
	 * 4.When yearly details are requested, only the fromDate and toDate year will be respected<br>
	 * 5.For weekly data points, details will be provided for every Sunday date available within the fromDate and
	 * toDate<br>
	 * 
	 * @param groupBy CATEGORY_TYPE, HIGH_LEVEL_CATEGORY or CATEGORY (required)
	 * @param accountId comma separated account Ids (optional)
	 * @param categoryId comma separated categoryIds (optional)
	 * @param categoryTypes INCOME, EXPENSE, TRANSFER, UNCATEGORIZE or DEFERRED_COMPENSATION (optional)
	 * @param fromDate YYYY-MM-DD format (optional)
	 * @param include details (optional)
	 * @param includeUserCategory TRUE/FALSE (optional)
	 * @param interval D-daily, W-weekly, M-mothly or Y-yearly (optional)
	 * @param toDate YYYY-MM-DD format (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link DerivedTransactionSummaryResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getTransactionSummaryAsync(//
			@NotNull(message = "{derived.param.groupBy.required}") GroupType groupBy, //
			@Size(min = 0, max = 100, message = "{derived.param.accountId.length.invalid}") Long[] accountId, //
			@Size(min = 0, max = 100, message = "{derived.param.categoryId.length.invalid}") Long[] categoryId,
			@Size(min = 0,
				  max = 100,
				  message = "{derived.param.categoryTypes.length.invalid}") CategoryType[] categoryTypes, //
			@Past(message = "{derived.param.fromDate.invalid}") Date fromDate, //
			DerivedInclude include, //
			Boolean includeUserCategory, //
			DataPointInterval interval, //
			@Past(message = "{derived.param.toDate.invalid}") Date toDate,
			ApiCallback<DerivedTransactionSummaryResponse> apiCallback) throws ApiException {
		LOGGER.info("Derived getTransactionSummaryAsync API execution started");
		DerivedValidator.validateTransactionSummary(this, ApiUtils.getMethodName(), groupBy, accountId, categoryId,
				categoryTypes, fromDate, include, includeUserCategory, interval, toDate);
		CallContext callContext = buildGetTransactionSummaryContext(groupBy, accountId, categoryId, categoryTypes,
				fromDate, include, includeUserCategory, interval, toDate);
		callContext.getApiClient().executeAsync(callContext.getCall(), DerivedTransactionSummaryResponse.class,
				apiCallback);
	}

	private CallContext buildGetTransactionSummaryContext(GroupType groupBy, Long[] accountId, Long[] categoryId,
			CategoryType[] categoryTypes, Date fromDate, DerivedInclude include, Boolean includeUserCategory,
			DataPointInterval interval, Date toDate) throws ApiException {
		Format formatter = new SimpleDateFormat(ApiConstants.YYYY_MM_DD);
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(ApiEndpoint.DERIVED_TRANSACTION_SUMMARY, HttpMethod.GET, null);
		registerResponseInterceptor(apiClient);
		apiContext.addQueryParam(new Pair(PARAM_GROUP_BY, groupBy.toString()));
		if (accountId != null && accountId.length > 0) {
			apiContext.addQueryParam(new Pair(PARAM_ACCOUNT_ID, ApiUtils.convertArrayToString(accountId)));
		}
		if (categoryId != null && categoryId.length > 0) {
			apiContext.addQueryParam(new Pair(PARAM_CATEGORY_ID, ApiUtils.convertArrayToString(categoryId)));
		}
		if (categoryTypes != null && categoryTypes.length > 0) {
			apiContext.addQueryParam(new Pair(PARAM_CATEGORY_TYPE, ApiUtils.convertArrayToString(categoryTypes)));
		}
		if (fromDate != null) {
			apiContext.addQueryParam(new Pair(PARAM_FROM_DATE, formatter.format(fromDate)));
		}
		if (include != null) {
			apiContext.addQueryParam(new Pair(PARAM_INCLUDE, include.toString()));
		}
		if (includeUserCategory != null) {
			apiContext.addQueryParam(new Pair(PARAM_INCLUDE_USER_CATEGORY, String.valueOf(includeUserCategory)));
		}
		if (interval != null) {
			apiContext.addQueryParam(new Pair(PARAM_INTERVAL, interval.toString()));
		}
		if (toDate != null) {
			apiContext.addQueryParam(new Pair(PARAM_TO_DATE, formatter.format(toDate)));
		}
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get Holding Summary The get holding summary service is used to get the summary of asset classifications for the
	 * user.<br>
	 * By default, accounts with status as ACTIVE and TO BE CLOSED will be considered.<br>
	 * If the include parameter value is passed as details then a summary with holdings and account information is
	 * returned.<br>
	 * 
	 * @param accountIds Comma separated accountIds (optional)
	 * @param classificationType e.g. Country, Sector, etc. (optional)
	 * @param include details (optional)
	 * @return {@link ApiResponse}&lt;{@link DerivedHoldingSummaryResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<DerivedHoldingSummaryResponse> getHoldingSummary(//
			@Size(min = 0, max = 100, message = "{derived.param.accountId.length.invalid}") Long[] accountIds, //
			String classificationType, DerivedInclude include) throws ApiException {
		LOGGER.info("Derived getHoldingSummary API execution started");
		DerivedValidator.validateHoldingSummary(this, ApiUtils.getMethodName(), accountIds, classificationType,
				include);
		CallContext callContext = buildGetHoldingSummaryContext(accountIds, classificationType, include);
		return callContext.getApiClient().execute(callContext.getCall(), DerivedHoldingSummaryResponse.class);
	}

	/**
	 * Get Holding Summary The get holding summary service is used to get the summary of asset classifications for the
	 * user.<br>
	 * By default, accounts with status as ACTIVE and TO BE CLOSED will be considered.<br>
	 * If the include parameter value is passed as details then a summary with holdings and account information is
	 * returned.<br>
	 * 
	 * @param accountIds Comma separated accountIds (optional)
	 * @param classificationType e.g. Country, Sector, etc. (optional)
	 * @param include details (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link DerivedHoldingSummaryResponse}&gt; required
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getHoldingSummaryAsync(//
			@Size(min = 0, max = 100, message = "{derived.param.accountId.length.invalid}") Long[] accountIds, //
			String classificationType, DerivedInclude include, ApiCallback<DerivedHoldingSummaryResponse> apiCallback)
			throws ApiException {
		LOGGER.info("Derived getHoldingSummaryAsync API execution started");
		DerivedValidator.validateHoldingSummary(this, ApiUtils.getMethodName(), accountIds, classificationType,
				include);
		CallContext callContext = buildGetHoldingSummaryContext(accountIds, classificationType, include);
		callContext.getApiClient().executeAsync(callContext.getCall(), DerivedHoldingSummaryResponse.class,
				apiCallback);
	}

	private CallContext buildGetHoldingSummaryContext(Long[] accountIds, String classificationType,
			DerivedInclude include) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(ApiEndpoint.DERIVED_HOLDING_SUMMARY, HttpMethod.GET, null);
		registerResponseInterceptor(apiClient);
		if (accountIds != null && accountIds.length > 0) {
			apiContext.addQueryParam(new Pair(PARAM_ACCOUNT_IDS, ApiUtils.convertArrayToString(accountIds)));
		}
		if (!StringUtils.isEmpty(classificationType)) {
			apiContext.addQueryParam(new Pair(PARAM_FROM_DATE, classificationType));
		}
		if (include != null) {
			apiContext.addQueryParam(new Pair(PARAM_INCLUDE, include.toString()));
		}
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get Networth Summary The get networth service is used to get the networth for the user.<br>
	 * If the include parameter value is passed as details then networth with historical balances is returned. <br>
	 * 
	 * @param accountIds comma separated accountIds (optional)
	 * @param fromDate from date for balance retrieval (YYYY-MM-DD) (optional)
	 * @param include details (optional)
	 * @param interval D-daily, W-weekly or M-monthly (optional)
	 * @param skip skip (Min 0) (optional)
	 * @param toDate toDate for balance retrieval (YYYY-MM-DD) (optional)
	 * @param top top (Max 500) (optional)
	 * @return {@link ApiResponse}&lt;{@link DerivedNetworthResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<DerivedNetworthResponse> getNetworth(//
			Long[] accountIds, //
			@Past(message = "{derived.param.fromDate.invalid}") Date fromDate, //
			DerivedInclude include, //
			DataPointInterval interval, //
			@Min(value = 0, message = "{derived.param.skip.invalid}") Integer skip, //
			@Past(message = "{derived.param.toDate.invalid}") Date toDate, //
			@Min(value = 1, message = "{derived.param.top.invalid}") //
			@Max(value = 500, message = "{derived.param.top.invalid}") Integer top, //
			@AllowedContainer(value = {//
					Container.bank, Container.creditCard,//
					Container.investment, Container.insurance,//
					Container.loan, Container.realEstate,//
					Container.otherAssets, Container.otherLiabilities//
			}, message = "{derived.param.container.invalid}") Container container) throws ApiException {
		LOGGER.info("Derived getNetworth API execution started");
		DerivedValidator.validateNetworth(this, ApiUtils.getMethodName(), accountIds, fromDate, include, interval, skip,
				toDate, top, container);
		CallContext callContext =
				buildGetNetworthContext(accountIds, fromDate, include, interval, skip, toDate, top, container);
		return callContext.getApiClient().execute(callContext.getCall(), DerivedNetworthResponse.class);
	}

	/**
	 * Get Networth Summary The get networth service is used to get the networth for the user.<br>
	 * If the include parameter value is passed as details then networth with historical balances is returned. <br>
	 * 
	 * @param accountIds comma separated accountIds (optional)
	 * @param fromDate from date for balance retrieval (YYYY-MM-DD) (optional)
	 * @param include details (optional)
	 * @param interval D-daily, W-weekly or M-monthly (optional)
	 * @param skip skip (Min 0) (optional)
	 * @param toDate toDate for balance retrieval (YYYY-MM-DD) (optional)
	 * @param top top (Max 500) (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link DerivedNetworthResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getNetworthAsync(//
			Long[] accountIds, //
			@Past(message = "{derived.param.fromDate.invalid}") Date fromDate, //
			DerivedInclude include, //
			DataPointInterval interval, //
			@Min(value = 0, message = "{derived.param.skip.invalid}") Integer skip, //
			@Past(message = "{derived.param.toDate.invalid}") Date toDate, //
			@Min(value = 1, message = "{derived.param.top.invalid}") //
			@Max(value = 500, message = "{derived.param.top.invalid}") Integer top, //
			@AllowedContainer(value = {//
					Container.bank, Container.creditCard,//
					Container.investment, Container.insurance,//
					Container.loan, Container.realEstate,//
					Container.otherAssets, Container.otherLiabilities//
			}, message = "{derived.param.container.invalid}") Container container,
			ApiCallback<DerivedNetworthResponse> apiCallback)//
			throws ApiException {
		LOGGER.info("Derived getNetworthAsync API execution started");
		DerivedValidator.validateNetworth(this, ApiUtils.getMethodName(), accountIds, fromDate, include, interval, skip,
				toDate, top, container);
		CallContext callContext =
				buildGetNetworthContext(accountIds, fromDate, include, interval, skip, toDate, top, container);
		callContext.getApiClient().executeAsync(callContext.getCall(), DerivedNetworthResponse.class, apiCallback);
	}

	private CallContext buildGetNetworthContext(Long[] accountIds, Date fromDate, DerivedInclude include,
			DataPointInterval interval, Integer skip, Date toDate, Integer top, Container container)
			throws ApiException {
		Format formatter = new SimpleDateFormat(ApiConstants.YYYY_MM_DD);
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(ApiEndpoint.DERIVED_NETWORTH, HttpMethod.GET, null);
		registerResponseInterceptor(apiClient);
		if (accountIds != null && accountIds.length > 0) {
			apiContext.addQueryParam(new Pair(PARAM_ACCOUNT_IDS, ApiUtils.convertArrayToString(accountIds)));
		}
		if (fromDate != null) {
			apiContext.addQueryParam(new Pair(PARAM_FROM_DATE, formatter.format(fromDate)));
		}
		if (include != null) {
			apiContext.addQueryParam(new Pair(PARAM_INCLUDE, include.toString()));
		}
		if (interval != null) {
			apiContext.addQueryParam(new Pair(PARAM_INTERVAL, interval.toString()));
		}
		if (skip != null) {
			apiContext.addQueryParam(new Pair(PARAM_SKIP, String.valueOf(skip)));
		}
		if (toDate != null) {
			apiContext.addQueryParam(new Pair(PARAM_TO_DATE, formatter.format(toDate)));
		}
		if (top != null) {
			apiContext.addQueryParam(new Pair(PARAM_TOP, String.valueOf(top)));
		}
		if (container != null) {
			apiContext.addQueryParam(new Pair(PARAM_CONTAINER, String.valueOf(container)));
		}
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}
}
