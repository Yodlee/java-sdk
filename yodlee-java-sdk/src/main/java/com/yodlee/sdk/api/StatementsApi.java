/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.squareup.okhttp.Call;
import com.yodlee.api.model.account.enums.ItemAccountStatus;
import com.yodlee.api.model.enums.Container;
import com.yodlee.api.model.statement.response.StatementResponse;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;
import com.yodlee.sdk.api.validators.StatementsValidator;
import com.yodlee.sdk.client.ApiCallback;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.client.ApiContext;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.client.CallContext;
import com.yodlee.sdk.client.HttpMethod;
import com.yodlee.sdk.client.Pair;
import com.yodlee.sdk.context.Context;

public class StatementsApi extends AbstractApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(StatementsApi.class);

	private static final String PARAM_FROM_DATE = "fromDate";

	private static final String PARAM_STATUS = "status";

	private static final String PARAM_IS_LATEST = "isLatest";

	private static final String PARAM_CONTAINER = "container";

	private static final String PARAM_ACCOUNT_ID = "accountId";

	public StatementsApi(Context<?> context) {
		super(context);
	}

	/**
	 * Get Statements The statements service is used to get the list of statement related information. <br>
	 * By default, all the latest statements of active and to be closed accounts are retrieved for the user. <br>
	 * Certain sites do not have both a statement date and a due date. When a fromDate is passed as an <br>
	 * input, all the statements that have the due date on or after the passed date are retrieved. <br>
	 * For sites that do not have the due date, statements that have the statement date <br>
	 * on or after the passed date are retrieved. <br>
	 * The default value of "isLatest" is true. To retrieve historical statements isLatest needs to be set to false.<br>
	 * 
	 * @param accountId accountId (optional)
	 * @param container creditCard/loan/bill/insurance (optional)
	 * @param fromDate from date for statement retrieval (optional)
	 * @param isLatest isLatest (true/false) (optional)
	 * @param status ACTIVE/TO_BE_CLOSED/CLOSED (optional)
	 * @return {@link ApiResponse}&lt;{@link StatementResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<StatementResponse> getStatements(//
			@Min(value = 1, message = "{statements.param.accountId.invalid}")//
			@Digits(message = "{statements.param.accountId.invalid}", fraction = 0, integer = 11) Long accountId,//
			Container container,//
			Date fromDate,//
			Boolean isLatest,//
			ItemAccountStatus status) throws ApiException {
		LOGGER.info("Statements getStatements API execution started");
		StatementsValidator.validateGetStatement(this, ApiUtils.getMethodName(), accountId, container, fromDate,
				isLatest, status);
		CallContext callContext = buildGetStatementsContext(accountId, container, fromDate, isLatest, status);
		return callContext.getApiClient().execute(callContext.getCall(), StatementResponse.class);
	}

	/**
	 * Get Statements The statements service is used to get the list of statement related information. <br>
	 * By default, all the latest statements of active and to be closed accounts are retrieved for the user. <br>
	 * Certain sites do not have both a statement date and a due date. When a fromDate is passed as an <br>
	 * input, all the statements that have the due date on or after the passed date are retrieved. <br>
	 * For sites that do not have the due date, statements that have the statement date <br>
	 * on or after the passed date are retrieved. <br>
	 * The default value of "isLatest" is true. To retrieve historical statements isLatest needs to be set to false.<br>
	 * 
	 * @param accountId accountId (optional)
	 * @param container creditCard/loan/bill/insurance (optional)
	 * @param fromDate from date for statement retrieval (optional)
	 * @param isLatest isLatest (true/false) (optional)
	 * @param status ACTIVE/TO_BE_CLOSED/CLOSED (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link StatementResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getStatementsAsync(//
			@Min(value = 1, message = "{statements.param.accountId.invalid}")//
			@Digits(message = "{statements.param.accountId.invalid}", fraction = 0, integer = 11) Long accountId,//
			Container container,//
			Date fromDate,//
			Boolean isLatest,//
			ItemAccountStatus status, ApiCallback<StatementResponse> apiCallback) throws ApiException {
		LOGGER.info("Statements getStatementsAsync API execution started");
		StatementsValidator.validateGetStatement(this, ApiUtils.getMethodName(), accountId, container, fromDate,
				isLatest, status);
		CallContext callContext = buildGetStatementsContext(accountId, container, fromDate, isLatest, status);
		callContext.getApiClient().executeAsync(callContext.getCall(), StatementResponse.class, apiCallback);
	}

	private CallContext buildGetStatementsContext(Long accountId,//
			Container container,//
			Date fromDate,//
			Boolean isLatest,//
			ItemAccountStatus status) throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(ApiEndpoint.STATEMENTS, HttpMethod.GET, null);
		SimpleDateFormat formatter = new SimpleDateFormat(ApiConstants.YYYY_MM_DD);
		if (accountId != null) {
			apiContext.addQueryParam(new Pair(PARAM_ACCOUNT_ID, accountId.toString()));
		}
		if (container != null) {
			apiContext.addQueryParam(new Pair(PARAM_CONTAINER, container.name()));
		}
		if (isLatest != null) {
			apiContext.addQueryParam(new Pair(PARAM_IS_LATEST, isLatest.toString()));
		}
		if (status != null) {
			apiContext.addQueryParam(new Pair(PARAM_STATUS, status.name()));
		}
		if (fromDate != null) {
			String formattedFromDate = formatter.format(fromDate);
			apiContext.addQueryParam(new Pair(PARAM_FROM_DATE, formattedFromDate));
		}
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}
}
