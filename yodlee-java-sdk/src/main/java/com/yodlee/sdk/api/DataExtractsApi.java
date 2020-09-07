/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yodlee.api.model.dataextracts.response.DataExtractsEventResponse;
import com.yodlee.api.model.dataextracts.response.DataExtractsUserDataResponse;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;
import com.yodlee.sdk.api.validators.DataExtractsValidator;
import com.yodlee.sdk.api.validators.DataExtractsValidator.DataExtractsEventType;
import com.yodlee.sdk.client.ApiCallback;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.client.ApiContext;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.client.CallContext;
import com.yodlee.sdk.client.HttpMethod;
import com.yodlee.sdk.client.Pair;
import com.yodlee.sdk.context.Context;
import okhttp3.Call;

public class DataExtractsApi extends AbstractApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataExtractsApi.class);

	private static final String PARAM_LOGIN_NAME = "loginName";

	private static final String PARAM_TO_DATE = "toDate";

	private static final String PARAM_FROM_DATE = "fromDate";

	private static final String PARAM_EVENT_NAME = "eventName";

	public DataExtractsApi(Context<?> context) {
		super(context);
	}

	/**
	 * Get Events The get extracts events service is used to learn about occurrences of data extract related events.
	 * This service currently supports only the DATA_UPDATES event.<br>
	 * Passing the event name as DATA_UPDATES provides information about users for whom data has been modified in the
	 * system for the specified time range. To learn more, please refer to the dataExtracts page.<br>
	 * The fromDate or the toDate parameters value cannot be less than 7 days. The time difference between these fields
	 * cannot be more than 60 minutes.<br>
	 * Cobrand session only has to be passed to invoke this service.<br>
	 * 
	 * @param eventName Event Name (required)
	 * @param fromDate From DateTime (YYYY-MM-DDThh:mm:ssZ) (required)
	 * @param toDate To DateTime (YYYY-MM-DDThh:mm:ssZ) (required)
	 * @return {@link ApiResponse}&lt;{@link DataExtractsEventResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<DataExtractsEventResponse> getDataExtractsEvents(//
			@NotNull(message = "{dataExtracts.param.eventName.required}") DataExtractsEventType eventName,
			@NotNull(message = "{dataExtracts.param.fromDate.required}")//
			@Past(message = "{dataExtracts.param.fromDate.invalid}") Date fromDate,
			@NotNull(message = "{dataExtracts.param.toDate.required}")//
			@Past(message = "{dataExtracts.param.toDate.invalid}") Date toDate) throws ApiException {
		LOGGER.info("DataExtracts getDataExtractsEvents API execution started");
		DataExtractsValidator.validateDataExtractsEvents(this, ApiUtils.getMethodName(), eventName, fromDate, toDate);
		CallContext callContext = buildGetDataExtractsEventsContext(eventName, fromDate, toDate);
		return callContext.getApiClient().execute(callContext.getCall(), DataExtractsEventResponse.class);
	}

	/**
	 * Get Events The get extracts events service is used to learn about occurrences of data extract related events.
	 * This service currently supports only the DATA_UPDATES event.<br>
	 * Passing the event name as DATA_UPDATES provides information about users for whom data has been modified in the
	 * system for the specified time range. To learn more, please refer to the dataExtracts page.<br>
	 * The fromDate or the toDate parameters value cannot be less than 7 days. The time difference between these fields
	 * cannot be more than 60 minutes.<br>
	 * Cobrand session only has to be passed to invoke this service.<br>
	 * 
	 * @param eventName Event Name (required)
	 * @param fromDate From DateTime (YYYY-MM-DDThh:mm:ssZ) (required)
	 * @param toDate To DateTime (YYYY-MM-DDThh:mm:ssZ) (required)
	 * @param apiCallback {@link ApiCallback}&lt;{@link DataExtractsEventResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getDataExtractsEventsAsync(//
			@NotNull(message = "{dataExtracts.param.eventName.required}") DataExtractsEventType eventName,
			@NotNull(message = "{dataExtracts.param.fromDate.required}")//
			@Past(message = "{dataExtracts.param.fromDate.invalid}") Date fromDate,
			@NotNull(message = "{dataExtracts.param.toDate.required}")//
			@Past(message = "{dataExtracts.param.toDate.invalid}") Date toDate,
			ApiCallback<DataExtractsEventResponse> apiCallback) throws ApiException {
		LOGGER.info("DataExtracts getDataExtractsEventsAsync API execution started");
		DataExtractsValidator.validateDataExtractsEvents(this, ApiUtils.getMethodName(), eventName, fromDate, toDate);
		CallContext callContext = buildGetDataExtractsEventsContext(eventName, fromDate, toDate);
		callContext.getApiClient().executeAsync(callContext.getCall(), DataExtractsEventResponse.class, apiCallback);
	}

	private CallContext buildGetDataExtractsEventsContext(//
			DataExtractsEventType eventName, Date fromDate, Date toDate) throws ApiException {
		SimpleDateFormat sdf = getUTCSimpleDateFormat();
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(ApiEndpoint.DATA_EXTRACTS_EVENTS, HttpMethod.GET, null);
		registerResponseInterceptor(apiClient);
		apiContext.addQueryParam(new Pair(PARAM_EVENT_NAME, eventName.name()));
		apiContext.addQueryParam(new Pair(PARAM_FROM_DATE, sdf.format(fromDate)));
		apiContext.addQueryParam(new Pair(PARAM_TO_DATE, sdf.format(toDate)));
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get userData The get user data service is used to get a user's modified data for a particular period of time for
	 * accounts, transactions, holdings, and provider account information.<br>
	 * Cobrand session only has to be passed to invoke this service. The time difference between fromDate and toDate
	 * fields cannot be more than 60 minutes.<br>
	 * 
	 * @param fromDate From DateTime (YYYY-MM-DDThh:mm:ssZ) (required)
	 * @param loginName Login Name (required)
	 * @param toDate To DateTime (YYYY-MM-DDThh:mm:ssZ) (required)
	 * @return {@link ApiResponse}&lt;{@link DataExtractsUserDataResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<DataExtractsUserDataResponse> getDataExtractsUserData(//
			@NotNull(message = "{dataExtracts.param.fromDate.required}")//
			@Past(message = "{dataExtracts.param.fromDate.invalid}") Date fromDate,
			@NotEmpty(message = "{dataExtracts.param.loginName.required}") //
			@Pattern(regexp = "[^\\s]+", message = "{user.loginName.invalid}") String loginName,
			@NotNull(message = "{dataExtracts.param.toDate.required}") //
			@Past(message = "{dataExtracts.param.toDate.invalid}") Date toDate) throws ApiException {
		LOGGER.info("DataExtracts getDataExtractsUserData API execution started");
		DataExtractsValidator.validateDataExtractsUserData(this, ApiUtils.getMethodName(), fromDate, loginName, toDate);
		CallContext callContext = buildGetDataExtractsUserDataContext(fromDate, loginName, toDate);
		return callContext.getApiClient().execute(callContext.getCall(), DataExtractsUserDataResponse.class);
	}

	/**
	 * Get userData The get user data service is used to get a user's modified data for a particular period of time for
	 * accounts, transactions, holdings, and provider account information.<br>
	 * Cobrand session only has to be passed to invoke this service. The time difference between fromDate and toDate
	 * fields cannot be more than 60 minutes.<br>
	 * 
	 * @param fromDate From Date (required)
	 * @param loginName Login Name (required)
	 * @param toDate To Date (required)
	 * @param apiCallback {@link ApiCallback}&lt;{@link DataExtractsUserDataResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getDataExtractsUserDataAsync(//
			@NotNull(message = "{dataExtracts.param.fromDate.required}")//
			@Past(message = "{dataExtracts.param.fromDate.invalid}") Date fromDate,
			@NotEmpty(message = "{dataExtracts.param.loginName.required}") //
			@Pattern(regexp = "[^\\s]+", message = "{user.loginName.invalid}") String loginName,
			@NotNull(message = "{dataExtracts.param.toDate.required}") //
			@Past(message = "{dataExtracts.param.toDate.invalid}") Date toDate,
			ApiCallback<DataExtractsUserDataResponse> apiCallback) throws ApiException {
		LOGGER.info("DataExtracts getDataExtractsUserDataAsync API execution started");
		DataExtractsValidator.validateDataExtractsUserData(this, ApiUtils.getMethodName(), fromDate, loginName, toDate);
		CallContext callContext = buildGetDataExtractsUserDataContext(fromDate, loginName, toDate);
		callContext.getApiClient().executeAsync(callContext.getCall(), DataExtractsUserDataResponse.class, apiCallback);
	}

	private CallContext buildGetDataExtractsUserDataContext(Date fromDate, String loginName, Date toDate)
			throws ApiException {
		SimpleDateFormat sdf = getUTCSimpleDateFormat();
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(ApiEndpoint.DATA_EXTRACTS_USER_DATA, HttpMethod.GET, null);
		registerResponseInterceptor(apiClient);
		apiContext.addQueryParam(new Pair(PARAM_LOGIN_NAME, loginName));
		apiContext.addQueryParam(new Pair(PARAM_FROM_DATE, sdf.format(fromDate)));
		apiContext.addQueryParam(new Pair(PARAM_TO_DATE, sdf.format(toDate)));
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	private static SimpleDateFormat getUTCSimpleDateFormat() {
		SimpleDateFormat formatter = new SimpleDateFormat(ApiConstants.YYYY_MM_DD_T_HH_MM_SS_Z);
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		return formatter;
	}
}
