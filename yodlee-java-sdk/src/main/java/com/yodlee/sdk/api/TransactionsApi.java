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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Call;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.enums.BaseType;
import com.yodlee.api.model.enums.Container;
import com.yodlee.api.model.transaction.enums.TransactionCategoryType;
import com.yodlee.api.model.transaction.request.TransactionCategorizationRuleRequest;
import com.yodlee.api.model.transaction.request.TransactionCategoryRequest;
import com.yodlee.api.model.transaction.request.TransactionRequest;
import com.yodlee.api.model.transaction.request.UpdateCategoryRequest;
import com.yodlee.api.model.transaction.response.TransactionCategorizationRuleResponse;
import com.yodlee.api.model.transaction.response.TransactionCategoryResponse;
import com.yodlee.api.model.transaction.response.TransactionCountResponse;
import com.yodlee.api.model.transaction.response.TransactionResponse;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;
import com.yodlee.sdk.api.validators.TransactionsValidator;
import com.yodlee.sdk.client.ApiCallback;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.client.ApiContext;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.client.CallContext;
import com.yodlee.sdk.client.HttpMethod;
import com.yodlee.sdk.client.Pair;
import com.yodlee.sdk.context.Context;

public class TransactionsApi extends AbstractApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionsApi.class);

	private static final String VALUE_RUN = "run";

	private static final String PARAM_ACTION = "action";

	private static final String PARAM_RULE_ID = "ruleId";

	private static final String PARAM_TRANSACTION_ID = "transactionId";

	private static final String PARAM_TYPE = "type";

	private static final String PARAM_TOP = "top";

	private static final String PARAM_TO_DATE = "toDate";

	private static final String PARAM_SKIP = "skip";

	private static final String PARAM_KEYWORD = "keyword";

	private static final String PARAM_HIGH_LEVEL_CATEGORY_ID = "highLevelCategoryId";

	private static final String PARAM_FROM_DATE = "fromDate";

	private static final String PARAM_DETAIL_CATEGORY_ID = "detailCategoryId";

	private static final String PARAM_CONTAINER = "container";

	private static final String PARAM_CATEGORY_TYPE = "categoryType";

	private static final String PARAM_CATEGORY_ID = "categoryId";

	private static final String PARAM_BASE_TYPE = "baseType";

	private static final String PARAM_ACCOUNT_ID = "accountId";

	public TransactionsApi(Context<?> context) {
		super(context);
	}

	/**
	 * Get Transactions The Transaction service is used to get a list of transactions for a user.<br>
	 * By default, this service returns the last 30 days of transactions from today's date.<br>
	 * The search is performed on these attributes: original, consumer, and simple descriptions.<br>
	 * Values for categoryId parameter can be fetched from get transaction category list service.<br>
	 * The categoryId is used to filter transactions based on system-defined category as well as user-defined
	 * category.<br>
	 * User-defined categoryIds should be provided in the filter with the prefix \&quot;U\&quot;. E.g. U10002 <br>
	 * The skip and top parameters are useful for paginating transactions (i.e., to fetch small transaction <br>
	 * payloads for performance reasons)<br>
	 * Double quotes in the merchant name will be prefixed by backslashes (&amp;#92;) in the response, <br>
	 * e.g. Toys \&quot;R\&quot; Us.<br>
	 * <b>Note</b> <br>
	 * <a href=https://developer.yodlee.com/Yodlee_API/Transaction_Data_Enrichment>TDE</a> is made available for bank
	 * and card accounts and for the US market only.The address field in the response is available only when the TDE key
	 * is turned on.<br>
	 * 
	 * @param accountId Comma separated accountIds (optional)
	 * @param baseType DEBIT/CREDIT (optional)
	 * @param categoryId Comma separated categoryIds (optional)
	 * @param categoryType Transaction Category Type(UNCATEGORIZE, INCOME, TRANSFER, EXPENSE or DEFERRED_COMPENSATION)
	 *        (optional)
	 * @param container bank/creditCard/investment/insurance/loan (optional)
	 * @param detailCategoryId Comma separated detailCategoryIds (optional)
	 * @param fromDate Transaction from date (optional)
	 * @param highLevelCategoryId Comma separated highLevelCategoryIds (optional)
	 * @param keyword Transaction search text (optional)
	 * @param skip skip (Min 0) (optional)
	 * @param toDate Transaction end date (optional)
	 * @param top top (Max 500) (optional)
	 * @param type Transaction Type(SELL,SWEEP, etc.) for bank/creditCard/investment (optional)
	 * @return {@link ApiResponse}&lt;{@link TransactionResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<TransactionResponse> getTransactions(
			@Size(min = 0, max = 100, message = "{transactions.param.accountId.length.invalid}") Long[] accountId,//
			BaseType baseType,//
			@Size(min = 0, max = 100, message = "{transactions.param.categoryId.length.invalid}") Long[] categoryId,
			TransactionCategoryType categoryType, //
			Container container,//
			@Size(min = 0,
				  max = 100,
				  message = "{transactions.param.detailCategoryId.length.invalid}") Long[] detailCategoryId,
			Date fromDate,//
			@Size(min = 0,
				  max = 100,
				  message = "{transactions.param.highLevelCategoryId.length.invalid}") Long[] highLevelCategoryId,
			String keyword, //
			@Min(value = 0, message = "{transactions.param.skip.invalid}") Integer skip,//
			Date toDate,//
			@Min(value = 1, message = "{transactions.param.top.invalid}") //
			@Max(value = 500, message = "{transactions.param.top.invalid}") Integer top, //
			String type) throws ApiException {
		LOGGER.info("Transactions getTransactions API execution started");
		TransactionsValidator.validateGetTransactions(this, ApiUtils.getMethodName(), accountId, baseType, categoryId,
				categoryType, container, detailCategoryId, fromDate, highLevelCategoryId, keyword, skip, toDate, top,
				type);
		CallContext callContext = buildGetTransactionsContext(accountId, baseType, categoryId, categoryType, container,
				detailCategoryId, fromDate, highLevelCategoryId, keyword, skip, toDate, top, type);
		return callContext.getApiClient().execute(callContext.getCall(), TransactionResponse.class);
	}

	/**
	 * Get Transactions The Transaction service is used to get a list of transactions for a user.<br>
	 * By default, this service returns the last 30 days of transactions from today's date.<br>
	 * The search is performed on these attributes: original, consumer, and simple descriptions.<br>
	 * Values for categoryId parameter can be fetched from get transaction category list service.<br>
	 * The categoryId is used to filter transactions based on system-defined category as well as user-defined
	 * category.<br>
	 * User-defined categoryIds should be provided in the filter with the prefix \&quot;U\&quot;. E.g. U10002 <br>
	 * The skip and top parameters are useful for paginating transactions (i.e., to fetch small transaction <br>
	 * payloads for performance reasons)<br>
	 * Double quotes in the merchant name will be prefixed by backslashes (&amp;#92;) in the response, <br>
	 * e.g. Toys \&quot;R\&quot; Us.<br>
	 * <b>Note</b> <br>
	 * <a href=https://developer.yodlee.com/Yodlee_API/Transaction_Data_Enrichment>TDE</a> is made available for bank
	 * and card accounts and for the US market only.The address field in the response is available only when the TDE key
	 * is turned on.<br>
	 * 
	 * @param accountId Comma separated accountIds (optional)
	 * @param baseType DEBIT/CREDIT (optional)
	 * @param categoryId Comma separated categoryIds (optional)
	 * @param categoryType Transaction Category Type(UNCATEGORIZE, INCOME, TRANSFER, EXPENSE or DEFERRED_COMPENSATION)
	 *        (optional)
	 * @param container bank/creditCard/investment/insurance/loan (optional)
	 * @param detailCategoryId Comma separated detailCategoryIds (optional)
	 * @param fromDate Transaction from date (optional)
	 * @param highLevelCategoryId Comma separated highLevelCategoryIds (optional)
	 * @param keyword Transaction search text (optional)
	 * @param skip skip (Min 0) (optional)
	 * @param toDate Transaction end date (optional)
	 * @param top top (Max 500) (optional)
	 * @param type Transaction Type(SELL,SWEEP, etc.) for bank/creditCard/investment (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link TransactionResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getTransactionsAsync(
			@Size(min = 0, max = 100, message = "{transactions.param.accountId.length.invalid}") Long[] accountId,//
			BaseType baseType,//
			@Size(min = 0, max = 100, message = "{transactions.param.categoryId.length.invalid}") Long[] categoryId,
			TransactionCategoryType categoryType, //
			Container container,//
			@Size(min = 0,
				  max = 100,
				  message = "{transactions.param.detailCategoryId.length.invalid}") Long[] detailCategoryId,
			Date fromDate,//
			@Size(min = 0,
				  max = 100,
				  message = "{transactions.param.highLevelCategoryId.length.invalid}") Long[] highLevelCategoryId,
			String keyword, //
			@Min(value = 0, message = "{transactions.param.skip.invalid}") Integer skip,//
			Date toDate,//
			@Min(value = 1, message = "{transactions.param.top.invalid}") //
			@Max(value = 500, message = "{transactions.param.top.invalid}") Integer top, //
			String type, ApiCallback<TransactionResponse> apiCallback) throws ApiException {
		LOGGER.info("Transactions getTransactionsAsync API execution started");
		TransactionsValidator.validateGetTransactions(this, ApiUtils.getMethodName(), accountId, baseType, categoryId,
				categoryType, container, detailCategoryId, fromDate, highLevelCategoryId, keyword, skip, toDate, top,
				type);
		CallContext callContext = buildGetTransactionsContext(accountId, baseType, categoryId, categoryType, container,
				detailCategoryId, fromDate, highLevelCategoryId, keyword, skip, toDate, top, type);
		callContext.getApiClient().executeAsync(callContext.getCall(), TransactionResponse.class, apiCallback);
	}

	private CallContext buildGetTransactionsContext(Long[] accountId, BaseType baseType, Long[] categoryId,
			TransactionCategoryType categoryType, Container container, Long[] detailCategoryId, Date fromDate,
			Long[] highLevelCategoryId, String keyword, Integer skip, Date toDate, Integer top, String type)
			throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(ApiEndpoint.TRANSACTIONS, HttpMethod.GET, null);
		SimpleDateFormat formatter = new SimpleDateFormat(ApiConstants.YYYY_MM_DD);
		if (accountId != null) {
			apiContext.addQueryParam(new Pair(PARAM_ACCOUNT_ID, ApiUtils.convertArrayToString(accountId)));
		}
		if (baseType != null) {
			apiContext.addQueryParam(new Pair(PARAM_BASE_TYPE, baseType.name()));
		}
		if (categoryId != null) {
			apiContext.addQueryParam(new Pair(PARAM_CATEGORY_ID, ApiUtils.convertArrayToString(categoryId)));
		}
		if (categoryType != null) {
			apiContext.addQueryParam(new Pair(PARAM_CATEGORY_TYPE, categoryType.name()));
		}
		if (container != null) {
			apiContext.addQueryParam(new Pair(PARAM_CONTAINER, container.name()));
		}
		if (detailCategoryId != null) {
			apiContext
					.addQueryParam(new Pair(PARAM_DETAIL_CATEGORY_ID, ApiUtils.convertArrayToString(detailCategoryId)));
		}
		if (fromDate != null) {
			String formattedFromDate = formatter.format(fromDate);
			apiContext.addQueryParam(new Pair(PARAM_FROM_DATE, formattedFromDate));
		}
		if (highLevelCategoryId != null) {
			apiContext.addQueryParam(
					new Pair(PARAM_HIGH_LEVEL_CATEGORY_ID, ApiUtils.convertArrayToString(highLevelCategoryId)));
		}
		if (keyword != null) {
			apiContext.addQueryParam(new Pair(PARAM_KEYWORD, keyword));
		}
		if (skip != null) {
			apiContext.addQueryParam(new Pair(PARAM_SKIP, skip.toString()));
		}
		if (toDate != null) {
			String formattedToDate = formatter.format(toDate);
			apiContext.addQueryParam(new Pair(PARAM_TO_DATE, formattedToDate));
		}
		if (top != null) {
			apiContext.addQueryParam(new Pair(PARAM_TOP, top.toString()));
		}
		if (type != null) {
			apiContext.addQueryParam(new Pair(PARAM_TYPE, type));
		}
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get Transactions Count The count service provides the total number of transactions for a specific user depending
	 * on the input parameters passed.<br>
	 * If you are implementing pagination for transactions, call this endpoint before calling GET /transactions to know
	 * the number of transactions that are returned for the input parameters passed.<br>
	 * The functionality of the input parameters remains the same as that of the GET /transactions endpoint.<br>
	 * 
	 * @param accountId Comma separated accountIds (optional)
	 * @param baseType DEBIT/CREDIT (optional)
	 * @param categoryId Comma separated categoryIds (optional)
	 * @param categoryType Transaction Category Type(UNCATEGORIZE, INCOME, TRANSFER, EXPENSE or DEFERRED_COMPENSATION)
	 *        (optional)
	 * @param container bank/creditCard/investment/insurance/loan (optional)
	 * @param detailCategoryId Comma separated detailCategoryIds (optional)
	 * @param fromDate Transaction from date(YYYY-MM-DD) (optional)
	 * @param highLevelCategoryId Comma separated highLevelCategoryIds (optional)
	 * @param keyword Transaction search text (optional)
	 * @param toDate Transaction end date (YYYY-MM-DD) (optional)
	 * @param type Transaction Type(SELL,SWEEP, etc.) (optional)
	 * @return {@link ApiResponse}&lt;{@link TransactionCountResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<TransactionCountResponse> getTransactionsCount(
			@Size(min = 0, max = 100, message = "{transactions.param.accountId.length.invalid}") Long[] accountId,//
			BaseType baseType,//
			@Size(min = 0, max = 100, message = "{transactions.param.categoryId.length.invalid}") Long[] categoryId,//
			TransactionCategoryType categoryType,//
			Container container,//
			@Size(min = 0,
				  max = 100,
				  message = "{transactions.param.detailCategoryId.length.invalid}") Long[] detailCategoryId,//
			Date fromDate,//
			@Size(min = 0,
				  max = 100,
				  message = "{transactions.param.highLevelCategoryId.length.invalid}") Long[] highLevelCategoryId, //
			String keyword,//
			Date toDate,//
			String type) throws ApiException {
		LOGGER.info("Transactions getTransactionsCount API execution started");
		TransactionsValidator.validateGetTransactionsCount(this, ApiUtils.getMethodName(), accountId, baseType,
				categoryId, categoryType, container, detailCategoryId, fromDate, highLevelCategoryId, keyword, toDate,
				type);
		CallContext callContext = buildGetTransactionsCountContext(accountId, baseType, categoryId, categoryType,
				container, detailCategoryId, fromDate, highLevelCategoryId, keyword, toDate, type);
		return callContext.getApiClient().execute(callContext.getCall(), TransactionCountResponse.class);
	}

	/**
	 * Get Transactions Count The count service provides the total number of transactions for a specific user depending
	 * on the input parameters passed.<br>
	 * If you are implementing pagination for transactions, call this endpoint before calling GET /transactions to know
	 * the number of transactions that are returned for the input parameters passed.<br>
	 * The functionality of the input parameters remains the same as that of the GET /transactions endpoint.<br>
	 * 
	 * @param accountId Comma separated accountIds (optional)
	 * @param baseType DEBIT/CREDIT (optional)
	 * @param categoryId Comma separated categoryIds (optional)
	 * @param categoryType Transaction Category Type(UNCATEGORIZE, INCOME, TRANSFER, EXPENSE or DEFERRED_COMPENSATION)
	 *        (optional)
	 * @param container bank/creditCard/investment/insurance/loan (optional)
	 * @param detailCategoryId Comma separated detailCategoryIds (optional)
	 * @param fromDate Transaction from date(YYYY-MM-DD) (optional)
	 * @param highLevelCategoryId Comma separated highLevelCategoryIds (optional)
	 * @param keyword Transaction search text (optional)
	 * @param toDate Transaction end date (YYYY-MM-DD) (optional)
	 * @param type Transaction Type(SELL,SWEEP, etc.) (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link TransactionCountResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getTransactionsCountAsync(
			@Size(min = 0, max = 100, message = "{transactions.param.accountId.length.invalid}") Long[] accountId,//
			BaseType baseType,//
			@Size(min = 0, max = 100, message = "{transactions.param.categoryId.length.invalid}") Long[] categoryId,//
			TransactionCategoryType categoryType,//
			Container container,//
			@Size(min = 0,
				  max = 100,
				  message = "{transactions.param.detailCategoryId.length.invalid}") Long[] detailCategoryId,//
			Date fromDate,//
			@Size(min = 0,
				  max = 100,
				  message = "{transactions.param.highLevelCategoryId.length.invalid}") Long[] highLevelCategoryId, //
			String keyword,//
			Date toDate,//
			String type, ApiCallback<TransactionCountResponse> apiCallback) throws ApiException {
		LOGGER.info("Transactions getTransactionsCountAsync API execution started");
		TransactionsValidator.validateGetTransactionsCount(this, ApiUtils.getMethodName(), accountId, baseType,
				categoryId, categoryType, container, detailCategoryId, fromDate, highLevelCategoryId, keyword, toDate,
				type);
		CallContext callContext = buildGetTransactionsCountContext(accountId, baseType, categoryId, categoryType,
				container, detailCategoryId, fromDate, highLevelCategoryId, keyword, toDate, type);
		callContext.getApiClient().executeAsync(callContext.getCall(), TransactionCountResponse.class, apiCallback);
	}

	private CallContext buildGetTransactionsCountContext(Long[] accountId, BaseType baseType, Long[] categoryId,
			TransactionCategoryType categoryType, Container container, Long[] detailCategoryId, Date fromDate,
			Long[] highLevelCategoryId, String keyword, Date toDate, String type) throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(ApiEndpoint.TRANSACTIONS_COUNT, HttpMethod.GET, null);
		SimpleDateFormat formatter = new SimpleDateFormat(ApiConstants.YYYY_MM_DD);
		if (accountId != null) {
			apiContext.addQueryParam(new Pair(PARAM_ACCOUNT_ID, ApiUtils.convertArrayToString(accountId)));
		}
		if (baseType != null) {
			apiContext.addQueryParam(new Pair(PARAM_BASE_TYPE, baseType.name()));
		}
		if (categoryId != null) {
			apiContext.addQueryParam(new Pair(PARAM_CATEGORY_ID, ApiUtils.convertArrayToString(categoryId)));
		}
		if (categoryType != null) {
			apiContext.addQueryParam(new Pair(PARAM_CATEGORY_TYPE, categoryType.name()));
		}
		if (container != null) {
			apiContext.addQueryParam(new Pair(PARAM_CONTAINER, container.name()));
		}
		if (detailCategoryId != null) {
			apiContext
					.addQueryParam(new Pair(PARAM_DETAIL_CATEGORY_ID, ApiUtils.convertArrayToString(detailCategoryId)));
		}
		if (fromDate != null) {
			String formattedFromDate = formatter.format(fromDate);
			apiContext.addQueryParam(new Pair(PARAM_FROM_DATE, formattedFromDate));
		}
		if (highLevelCategoryId != null) {
			apiContext.addQueryParam(
					new Pair(PARAM_HIGH_LEVEL_CATEGORY_ID, ApiUtils.convertArrayToString(highLevelCategoryId)));
		}
		if (keyword != null) {
			apiContext.addQueryParam(new Pair(PARAM_KEYWORD, keyword));
		}
		if (toDate != null) {
			String formattedToDate = formatter.format(toDate);
			apiContext.addQueryParam(new Pair(PARAM_TO_DATE, formattedToDate));
		}
		if (type != null) {
			apiContext.addQueryParam(new Pair(PARAM_TYPE, type));
		}
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Update Transaction The update transaction service is used to update the category,consumer description, memo for a
	 * transaction.<br>
	 * The HTTP response code is 204 (Success without content).<br>
	 * 
	 * @param transactionId transactionId (required)
	 * @param transactionRequest transactionRequest (required)
	 * @return null
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> updateTransaction(//
			@Min(value = 1, message = "{transactions.param.transactionId.invalid}")//
			@Digits(message = "{transactions.param.transactionId.invalid}",
					fraction = 0,
					integer = 11) long transactionId,//
			@NotNull(message = "{transactions.updateTransaction.required}") TransactionRequest transactionRequest)
			throws ApiException {
		LOGGER.info("Transactions updateTransaction API execution started");
		TransactionsValidator.validateUpdateTransaction(this, ApiUtils.getMethodName(), transactionId,
				transactionRequest);
		CallContext callContext = buildUpdateTransactionContext(transactionId, transactionRequest);
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Update Transaction The update transaction service is used to update the category,consumer description, memo for a
	 * transaction.<br>
	 * The HTTP response code is 204 (Success without content).<br>
	 * 
	 * @param transactionId transactionId (required)
	 * @param transactionRequest transactionRequest (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void updateTransactionAsync(//
			@Min(value = 1, message = "{transactions.param.transactionId.invalid}")//
			@Digits(message = "{transactions.param.transactionId.invalid}",
					fraction = 0,
					integer = 11) long transactionId,//
			@NotNull(message = "{transactions.updateTransaction.required}") TransactionRequest transactionRequest,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Transactions updateTransactionAsync API execution started");
		TransactionsValidator.validateUpdateTransaction(this, ApiUtils.getMethodName(), transactionId,
				transactionRequest);
		CallContext callContext = buildUpdateTransactionContext(transactionId, transactionRequest);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildUpdateTransactionContext(//
			long transactionId,//
			TransactionRequest transactionRequest) throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		String endpoint = replacePathVariable(ApiEndpoint.UPDATE_TRANSACTIONS, PARAM_TRANSACTION_ID,
				String.valueOf(transactionId));
		ApiContext apiContext = new ApiContext(endpoint, HttpMethod.PUT, transactionRequest);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Create Category The create transaction categories service is used to create user-defined categories for a
	 * system-defined category.<br>
	 * The parentCategoryId is the system-defined category id.This can be retrieved using get transaction categories
	 * service.<br>
	 * The categoryName can accept minimum of 1, maximum of 50 alphanumeric or special characters.<br>
	 * The HTTP response code is 201 (Created successfully).<br>
	 * 
	 * @param transactionCategoryRequest User Transaction Category in JSON format (required)
	 * @return null
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> createTransactionCategory(
			@NotNull(message = "{transactions.createTransactionCategory.required}") TransactionCategoryRequest transactionCategoryRequest)
			throws ApiException {
		LOGGER.info("Transactions createTransactionCategory API execution started");
		TransactionsValidator.validateCreateTransactionCategory(this, ApiUtils.getMethodName(),
				transactionCategoryRequest);
		CallContext callContext = buildCreateTransactionCategoryContext(transactionCategoryRequest);
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Create Category The create transaction categories service is used to create user-defined categories for a
	 * system-defined category.<br>
	 * The parentCategoryId is the system-defined category id.This can be retrieved using get transaction categories
	 * service.<br>
	 * The categoryName can accept minimum of 1, maximum of 50 alphanumeric or special characters.<br>
	 * The HTTP response code is 201 (Created successfully).<br>
	 * 
	 * @param transactionCategoryRequest User Transaction Category in JSON format (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void createTransactionCategoryAsync(
			@NotNull(message = "{transactions.createTransactionCategory.required}") TransactionCategoryRequest transactionCategoryRequest,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Transactions createTransactionCategoryAsync API execution started");
		TransactionsValidator.validateCreateTransactionCategory(this, ApiUtils.getMethodName(),
				transactionCategoryRequest);
		CallContext callContext = buildCreateTransactionCategoryContext(transactionCategoryRequest);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildCreateTransactionCategoryContext(TransactionCategoryRequest transactionCategoryRequest)
			throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext =
				new ApiContext(ApiEndpoint.TRANSACTIONS_CATEGORIZATION, HttpMethod.POST, transactionCategoryRequest);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get Transaction Category List The categories service returns the list of available transaction categories.<br>
	 * High level category is returned in the response only if it is opted by the customer.<br>
	 * When invoked by passing the cobrand session, this service returns the supported transaction categories at the
	 * cobrand level. <br>
	 * When invoked by passing the cobrand session and the user session, this service returns the transaction categories
	 * <br>
	 * along with user-defined categories.<br>
	 * Double quotes in the user-defined category name will be prefixed by backslashes (&amp;#92;) in the response, <br>
	 * e.g. Toys \&quot;R\&quot; Us.Source and id are the primary attributes of the category entity.
	 * 
	 * @return {@link ApiResponse}&lt;{@link TransactionCategoryResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<TransactionCategoryResponse> getTransactionCategories() throws ApiException {
		LOGGER.info("Transactions getTransactionCategories API execution started");
		TransactionsValidator.validateCobrandContext(this);
		CallContext callContext = buildGetTransactionCategoriesContext();
		return callContext.getApiClient().execute(callContext.getCall(), TransactionCategoryResponse.class);
	}

	/**
	 * Get Transaction Category List The categories service returns the list of available transaction categories.<br>
	 * High level category is returned in the response only if it is opted by the customer.<br>
	 * When invoked by passing the cobrand session, this service returns the supported transaction categories at the
	 * cobrand level. <br>
	 * When invoked by passing the cobrand session and the user session, this service returns the transaction categories
	 * <br>
	 * along with user-defined categories.<br>
	 * Double quotes in the user-defined category name will be prefixed by backslashes (&amp;#92;) in the response, <br>
	 * e.g. Toys \&quot;R\&quot; Us.Source and id are the primary attributes of the category entity.
	 * 
	 * @param apiCallback {@link ApiCallback}&lt;{@link TransactionCategoryResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getTransactionCategoriesAsync(ApiCallback<TransactionCategoryResponse> apiCallback)
			throws ApiException {
		LOGGER.info("Transactions getTransactionCategoriesAsync API execution started");
		TransactionsValidator.validateCobrandContext(this);
		CallContext callContext = buildGetTransactionCategoriesContext();
		callContext.getApiClient().executeAsync(callContext.getCall(), TransactionCategoryResponse.class, apiCallback);
	}

	private CallContext buildGetTransactionCategoriesContext() throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(ApiEndpoint.TRANSACTIONS_CATEGORIZATION, HttpMethod.GET, null);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Update Category The update transaction categories service is used to update the transaction category name<br>
	 * for a high level category, a system-defined category and a user-defined category.<br>
	 * The renamed category can be set back to the original name by passing an empty string for categoryName.<br>
	 * The categoryName can accept minimum of 1, maximum of 50 alphanumeric or special characters.<br>
	 * The HTTP response code is 204 (Success without content).<br>
	 * 
	 * @param updateCategoryRequest updateCategoryRequest (required)
	 * @return null
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> updateTransactionCategory(
			@NotNull(message = "{transactions.updateTransactionCategory.required}") UpdateCategoryRequest updateCategoryRequest)
			throws ApiException {
		LOGGER.info("Transactions updateTransactionCategory API execution started");
		TransactionsValidator.validateUpdateTransactionCategory(this, ApiUtils.getMethodName(), updateCategoryRequest);
		CallContext callContext = buildUpdateTransactionCategoryContext(updateCategoryRequest);
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Update Category The update transaction categories service is used to update the transaction category name<br>
	 * for a high level category, a system-defined category and a user-defined category.<br>
	 * The renamed category can be set back to the original name by passing an empty string for categoryName.<br>
	 * The categoryName can accept minimum of 1, maximum of 50 alphanumeric or special characters.<br>
	 * The HTTP response code is 204 (Success without content).<br>
	 * 
	 * @param updateCategoryRequest updateCategoryRequest (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void updateTransactionCategoryAsync(
			@NotNull(message = "{transactions.updateTransactionCategory.required}") UpdateCategoryRequest updateCategoryRequest,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Transactions updateTransactionCategoryAsync API execution started");
		TransactionsValidator.validateUpdateTransactionCategory(this, ApiUtils.getMethodName(), updateCategoryRequest);
		CallContext callContext = buildUpdateTransactionCategoryContext(updateCategoryRequest);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildUpdateTransactionCategoryContext(UpdateCategoryRequest updateCategoryRequest)
			throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext =
				new ApiContext(ApiEndpoint.TRANSACTIONS_CATEGORIZATION, HttpMethod.PUT, updateCategoryRequest);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Delete Category The delete transaction categories service is used to delete the given user-defined category.<br>
	 * The HTTP response code is 204 (Success without content).<br>
	 * 
	 * @param categoryId categoryId (required)
	 * @return null
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> deleteTransactionCategory(//
			@Min(value = 1, message = "{transactions.param.categoryId.invalid}")//
			@Digits(message = "{transactions.param.categoryId.invalid}", fraction = 0, integer = 11) long categoryId)
			throws ApiException {
		LOGGER.info("Transactions deleteTransactionCategoryAsync API execution started");
		TransactionsValidator.validateDeleteTransactionCategory(this, ApiUtils.getMethodName(), categoryId);
		CallContext callContext = buildDeleteTransactionCategoryContext(categoryId);
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Delete Category The delete transaction categories service is used to delete the given user-defined category.<br>
	 * The HTTP response code is 204 (Success without content).<br>
	 * 
	 * @param categoryId categoryId (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void deleteTransactionCategoryAsync(//
			@Min(value = 1, message = "{transactions.param.categoryId.invalid}")//
			@Digits(message = "{transactions.param.categoryId.invalid}", fraction = 0, integer = 11) long categoryId,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Transactions deleteTransactionCategoryAsync API execution started");
		TransactionsValidator.validateDeleteTransactionCategory(this, ApiUtils.getMethodName(), categoryId);
		CallContext callContext = buildDeleteTransactionCategoryContext(categoryId);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildDeleteTransactionCategoryContext(long categoryId) throws ApiException {
		String endpoint = replacePathVariable(ApiEndpoint.TRANSACTIONS_CATEGORIZATION_WITH_CATEGORYID,
				PARAM_CATEGORY_ID, String.valueOf(categoryId));
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(endpoint, HttpMethod.DELETE, null);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get Transaction Categorization Rules The get transaction categorization rule service is used to get all the
	 * categorization rules.<br>
	 * 
	 * @return {@link ApiResponse}&lt;{@link TransactionCategorizationRuleResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<TransactionCategorizationRuleResponse> getTransactionCategorizationRules() throws ApiException {
		LOGGER.info("Transactions getTransactionCategorizationRules API execution started");
		TransactionsValidator.validateContext(this);
		CallContext callContext = buildGetTransactionCategorizationRulesContext();
		return callContext.getApiClient().execute(callContext.getCall(), TransactionCategorizationRuleResponse.class);
	}

	/**
	 * Get Transaction Categorization Rules The get transaction categorization rule service is used to get all the
	 * categorization rules.<br>
	 *
	 * @param apiCallback {@link ApiCallback}&lt;{@link TransactionCategorizationRuleResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getTransactionCategorizationRulesAsync(ApiCallback<TransactionCategorizationRuleResponse> apiCallback)
			throws ApiException {
		LOGGER.info("Transactions getTransactionCategorizationRulesAsync API execution started");
		TransactionsValidator.validateContext(this);
		CallContext callContext = buildGetTransactionCategorizationRulesContext();
		callContext.getApiClient().executeAsync(callContext.getCall(), TransactionCategorizationRuleResponse.class,
				apiCallback);
	}

	private CallContext buildGetTransactionCategorizationRulesContext() throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(ApiEndpoint.GET_TRANSACTIONS_CATEGORIZATION_RULES, HttpMethod.GET, null);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Create Transaction Categorization Rule The Create Transaction Categorization Rule endpoint is used to: <br>
	 * Create transaction categorization rules for both system and user-defined categories.<br>
	 * Run all the transaction categorization rules to categorize transactions by calling the endpoint with action=run
	 * as the query parameter. <br>
	 * The input body parameters to create transaction categorization rules follow:<br>
	 * categoryId - This field is mandatory and numeric<br>
	 * priority - This field is optional and numeric. Priority decides the order in which the rule gets applied on
	 * transactions.<br>
	 * ruleClause - This field is mandatory and should contain at least one rule<br>
	 * field - The value can be description or amount<br>
	 * If the field value is description then,<br>
	 * 1. operation - value can be stringEquals or stringContains<br>
	 * 2. value - value should be min of 3 and max of 50 characters<br>
	 * If the field value is amount then, <br>
	 * 1. operation - value can be numberEquals, numberLessThan, numberLessThanEquals, numberGreaterThan or
	 * numberGreaterThanEquals<br>
	 * 2. value - min value 0 and a max value of 99999999999.99 is allowed<br>
	 * The HTTP response code is 201 (Created Successfully).
	 * 
	 * @param transactionCategorizationRuleRequest rules(JSON format) to categorize the transactions (optional)
	 * @return null
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> createTransactionCategorizationRules(
			@NotNull(message = "transactions.createTransactionCategorizationRules.required") TransactionCategorizationRuleRequest transactionCategorizationRuleRequest)
			throws ApiException {
		LOGGER.info("Transactions createTransactionCategorizationRules API execution started");
		TransactionsValidator.validateCreateTransactionCategorizationRules(this, ApiUtils.getMethodName(),
				transactionCategorizationRuleRequest);
		CallContext callContext =
				buildCreateTransactionCategorizationRulesContext(transactionCategorizationRuleRequest);
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Create Transaction Categorization Rule The Create Transaction Categorization Rule endpoint is used to: <br>
	 * Create transaction categorization rules for both system and user-defined categories.<br>
	 * Run all the transaction categorization rules to categorize transactions by calling the endpoint with action=run
	 * as the query parameter. <br>
	 * The input body parameters to create transaction categorization rules follow:<br>
	 * categoryId - This field is mandatory and numeric<br>
	 * priority - This field is optional and numeric. Priority decides the order in which the rule gets applied on
	 * transactions.<br>
	 * ruleClause - This field is mandatory and should contain at least one rule<br>
	 * field - The value can be description or amount<br>
	 * If the field value is description then,<br>
	 * 1. operation - value can be stringEquals or stringContains<br>
	 * 2. value - value should be min of 3 and max of 50 characters<br>
	 * If the field value is amount then, <br>
	 * 1. operation - value can be numberEquals, numberLessThan, numberLessThanEquals, numberGreaterThan or
	 * numberGreaterThanEquals<br>
	 * 2. value - min value 0 and a max value of 99999999999.99 is allowed<br>
	 * The HTTP response code is 201 (Created Successfully).
	 * @param transactionCategorizationRuleRequest - rules(JSON format) to categorize the transactions (optional)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void createTransactionCategorizationRulesAsync(
			@NotNull(message = "transactions.createTransactionCategorizationRules.required")//
			TransactionCategorizationRuleRequest transactionCategorizationRuleRequest,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Transactions createTransactionCategorizationRulesAsync API execution started");
		TransactionsValidator.validateCreateTransactionCategorizationRules(this, ApiUtils.getMethodName(),
				transactionCategorizationRuleRequest);
		CallContext callContext =
				buildCreateTransactionCategorizationRulesContext(transactionCategorizationRuleRequest);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildCreateTransactionCategorizationRulesContext(
			TransactionCategorizationRuleRequest transactionCategorizationRuleRequest) throws ApiException {
		String ruleParamValue = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			ruleParamValue = mapper.writeValueAsString(transactionCategorizationRuleRequest);
		} catch (JsonProcessingException e) {
			LOGGER.error("Already validated, exception will never occur.");
		}
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(ApiEndpoint.TRANSACTIONS_CATEGORIZATION_RULES, HttpMethod.POST, null);
		apiContext.addQueryParam(new Pair("ruleParam", ruleParamValue));
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Run Transaction Categorization Rule The Run Transaction Categorization Rule endpoint is used to: <br>
	 * Create transaction categorization rules for both system and user-defined categories.<br>
	 * Run all the transaction categorization rules to categorize transactions by calling the endpoint with action=run
	 * as the query parameter. <br>
	 * The input body parameters to create transaction categorization rules follow:<br>
	 * categoryId - This field is mandatory and numeric<br>
	 * priority - This field is optional and numeric. Priority decides the order in which the rule gets applied on
	 * transactions.<br>
	 * ruleClause - This field is mandatory and should contain at least one rule<br>
	 * field - The value can be description or amount<br>
	 * If the field value is description then,<br>
	 * 1. operation - value can be stringEquals or stringContains<br>
	 * 2. value - value should be min of 3 and max of 50 characters<br>
	 * If the field value is amount then, <br>
	 * 1. operation - value can be numberEquals, numberLessThan, numberLessThanEquals, numberGreaterThan or
	 * numberGreaterThanEquals<br>
	 * 2. value - min value 0 and a max value of 99999999999.99 is allowed<br>
	 * The HTTP response code is 201 (Created Successfully).
	 * 
	 * @return null
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> runTransactionCategorizationRules() throws ApiException {
		LOGGER.info("Transactions runTransactionCategorizationRules API execution started");
		TransactionsValidator.validateContext(this);
		CallContext callContext = buildRunTransactionCategorizationRulesContext();
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Run Transaction Categorization Rule The Run Transaction Categorization Rule endpoint is used to: <br>
	 * Create transaction categorization rules for both system and user-defined categories.<br>
	 * Run all the transaction categorization rules to categorize transactions by calling the endpoint with action=run
	 * as the query parameter. <br>
	 * The input body parameters to create transaction categorization rules follow:<br>
	 * categoryId - This field is mandatory and numeric<br>
	 * priority - This field is optional and numeric. Priority decides the order in which the rule gets applied on
	 * transactions.<br>
	 * ruleClause - This field is mandatory and should contain at least one rule<br>
	 * field - The value can be description or amount<br>
	 * If the field value is description then,<br>
	 * 1. operation - value can be stringEquals or stringContains<br>
	 * 2. value - value should be min of 3 and max of 50 characters<br>
	 * If the field value is amount then, <br>
	 * 1. operation - value can be numberEquals, numberLessThan, numberLessThanEquals, numberGreaterThan or
	 * numberGreaterThanEquals<br>
	 * 2. value - min value 0 and a max value of 99999999999.99 is allowed<br>
	 * The HTTP response code is 201 (Created Successfully).
	 * 
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void runTransactionCategorizationRulesAsync(ApiCallback<AbstractModelComponent> apiCallback)
			throws ApiException {
		LOGGER.info("Transactions runTransactionCategorizationRulesAsync API execution started");
		TransactionsValidator.validateContext(this);
		CallContext callContext = buildRunTransactionCategorizationRulesContext();
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildRunTransactionCategorizationRulesContext() throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(ApiEndpoint.TRANSACTIONS_CATEGORIZATION_RULES, HttpMethod.POST, null);
		apiContext.addQueryParam(new Pair(PARAM_ACTION, VALUE_RUN));
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Run Transaction Categorization Rule The run transaction categorization rule service is used to run a rule on <br>
	 * transactions, to categorize the transactions.<br>
	 * The HTTP response code is 204 (Success with no content).<br>
	 * 
	 * @param ruleId Unique id of the categorization rule (required)
	 * @return null
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> runTransactionCategorizationRule(//
			@Min(value = 1, message = "{transactions.param.ruleId.invalid}")//
			@Digits(message = "{transactions.param.ruleId.invalid}", fraction = 0, integer = 11) long ruleId)
			throws ApiException {
		LOGGER.info("Transactions runTransactionCategorizationRule API execution started");
		TransactionsValidator.validateRunOrDeleteTransactionCategorizationRule(this, ApiUtils.getMethodName(), ruleId);
		CallContext callContext = buildRunTransactionCategorizationRuleContext(ruleId);
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Run Transaction Categorization Rule The run transaction categorization rule service is used to run a rule on <br>
	 * transactions, to categorize the transactions.<br>
	 * The HTTP response code is 204 (Success with no content).<br>
	 * 
	 * @param ruleId Unique id of the categorization rule (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void runTransactionCategorizationRuleAsync(//
			@Min(value = 1, message = "{transactions.param.ruleId.invalid}")//
			@Digits(message = "{transactions.param.ruleId.invalid}", fraction = 0, integer = 11) long ruleId,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Transactions runTransactionCategorizationRuleAsync API execution started");
		TransactionsValidator.validateRunOrDeleteTransactionCategorizationRule(this, ApiUtils.getMethodName(), ruleId);
		CallContext callContext = buildRunTransactionCategorizationRuleContext(ruleId);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildRunTransactionCategorizationRuleContext(long ruleId) throws ApiException {
		String endpoint = replacePathVariable(ApiEndpoint.TRANSACTIONS_CATEGORIZATION_RULES_WITH_RULEID, PARAM_RULE_ID,
				String.valueOf(ruleId));
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(endpoint, HttpMethod.POST, null);
		apiContext.addQueryParam(new Pair(PARAM_ACTION, VALUE_RUN));
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Update Transaction Categorization Rule The update transaction categorization rule service is used to update a
	 * categorization rule for both system-defined category as well as user-defined category.<br>
	 * ruleParam JSON input should be as explained in the create transaction categorization rule service.<br>
	 * The HTTP response code is 204 (Success without content).<br>
	 * 
	 * @param ruleId ruleId (required)
	 * @param transactionCategoriesRuleRequest transactionCategoriesRuleRequest (required)
	 * @return null
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> updateTransactionCategorizationRule(//
			@Min(value = 1, message = "{transactions.param.ruleId.invalid}")//
			@Digits(message = "{transactions.param.ruleId.invalid}", fraction = 0, integer = 11) long ruleId,//
			@NotNull(message = "{transactions.updateTransactionCategorizationRule.required}") TransactionCategorizationRuleRequest transactionCategoriesRuleRequest)
			throws ApiException {
		LOGGER.info("Transactions updateTransactionCategorizationRule API execution started");
		TransactionsValidator.validateUpdateTransactionCategorizationRule(this, ApiUtils.getMethodName(), ruleId,
				transactionCategoriesRuleRequest);
		CallContext callContext =
				buildUpdateTransactionCategorizationRuleContext(ruleId, transactionCategoriesRuleRequest);
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Update Transaction Categorization Rule The update transaction categorization rule service is used to update a
	 * categorization rule for both system-defined category as well as user-defined category.<br>
	 * ruleParam JSON input should be as explained in the create transaction categorization rule service.<br>
	 * The HTTP response code is 204 (Success without content).<br>
	 * 
	 * @param ruleId ruleId (required)
	 * @param transactionCategoriesRuleRequest transactionCategoriesRuleRequest (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void updateTransactionCategorizationRuleAsync(//
			@Min(value = 1, message = "{transactions.param.ruleId.invalid}")//
			@Digits(message = "{transactions.param.ruleId.invalid}", fraction = 0, integer = 11) long ruleId,//
			@NotNull(message = "{transactions.updateTransactionCategorizationRule.required}") TransactionCategorizationRuleRequest transactionCategoriesRuleRequest,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Transactions updateTransactionCategorizationRuleAsync API execution started");
		TransactionsValidator.validateUpdateTransactionCategorizationRule(this, ApiUtils.getMethodName(), ruleId,
				transactionCategoriesRuleRequest);
		CallContext callContext =
				buildUpdateTransactionCategorizationRuleContext(ruleId, transactionCategoriesRuleRequest);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildUpdateTransactionCategorizationRuleContext(long ruleId,
			TransactionCategorizationRuleRequest transactionCategoriesRuleRequest) throws ApiException {
		String endpoint = replacePathVariable(ApiEndpoint.TRANSACTIONS_CATEGORIZATION_RULES_WITH_RULEID, PARAM_RULE_ID,
				String.valueOf(ruleId));
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(endpoint, HttpMethod.PUT, transactionCategoriesRuleRequest);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Delete Transaction Categorization Rule The delete transaction categorization rule service is used to delete the
	 * given user-defined transaction categorization rule for both system-defined category as well as user-defined
	 * category.<br>
	 * This will delete all the corresponding rule clauses associated with the rule.<br>
	 * The HTTP response code is 204 (Success without content).<br>
	 * 
	 * @param ruleId ruleId (required)
	 * @return null
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> deleteTransactionCategorizationRule(//
			@Min(value = 1, message = "{transactions.param.ruleId.invalid}")//
			@Digits(message = "{transactions.param.ruleId.invalid}", fraction = 0, integer = 11) long ruleId)
			throws ApiException {
		LOGGER.info("Transactions deleteTransactionCategorizationRule API execution started");
		TransactionsValidator.validateRunOrDeleteTransactionCategorizationRule(this, ApiUtils.getMethodName(), ruleId);
		CallContext callContext = buildDeleteTransactionCategorizationRuleContext(ruleId);
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Delete Transaction Categorization Rule The delete transaction categorization rule service is used to delete the
	 * given user-defined transaction categorization rule for both system-defined category as well as user-defined
	 * category.<br>
	 * This will delete all the corresponding rule clauses associated with the rule.<br>
	 * The HTTP response code is 204 (Success without content).<br>
	 * 
	 * @param ruleId ruleId (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void deleteTransactionCategorizationRuleAsync(//
			@Min(value = 1, message = "{transactions.param.ruleId.invalid}")//
			@Digits(message = "{transactions.param.ruleId.invalid}", fraction = 0, integer = 11) long ruleId,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Transactions deleteTransactionCategorizationRuleAsync API execution started");
		TransactionsValidator.validateRunOrDeleteTransactionCategorizationRule(this, ApiUtils.getMethodName(), ruleId);
		CallContext callContext = buildDeleteTransactionCategorizationRuleContext(ruleId);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildDeleteTransactionCategorizationRuleContext(long ruleId) throws ApiException {
		String endpoint = replacePathVariable(ApiEndpoint.TRANSACTIONS_CATEGORIZATION_RULES_WITH_RULEID, PARAM_RULE_ID,
				String.valueOf(ruleId));
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(endpoint, HttpMethod.DELETE, null);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}
}
