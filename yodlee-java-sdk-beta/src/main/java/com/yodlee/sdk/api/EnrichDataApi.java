/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yodlee.api.model.enrichData.request.EnrichDataRequest;
import com.yodlee.api.model.enrichData.response.EnrichedTransactionResponse;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;
import com.yodlee.sdk.api.validators.EnrichDataValidator;
import com.yodlee.sdk.client.ApiCallback;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.client.ApiContext;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.client.CallContext;
import com.yodlee.sdk.client.HttpMethod;
import com.yodlee.sdk.context.Context;

public class EnrichDataApi extends AbstractApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProvidersApi.class);

	public EnrichDataApi(Context<?> context) {
		super(context);
	}

	/**
	 * <b>Push User Data </b><br>
	 * The data enrich API v1.1 allows customers to get the transactions enriched in real-time by feeding the data into
	 * the Yodlee Platform. To get the transactions enriched, it is necessary that users, accounts, and transactions are
	 * updated to the Yodlee Platform.<br>
	 * The following features are supported through the data enrich API:
	 * <ul>
	 * <li>Add user</li>
	 * <li>Add account</li>
	 * <li>Update account</li>
	 * <li>Add transactions</li>
	 * <li>Update transactions</li>
	 * </ul>
	 * Yodlee will enrich the transactions with the following information:
	 * <ul>
	 * <li>Category</li>
	 * <li>High Level Category</li>
	 * <li>Detail Category</li>
	 * <li>Simple description</li>
	 * <li>Merchant details
	 * <ul>
	 * <li>Name</li>
	 * <li>Address</li>
	 * </ul>
	 * </li>
	 * <li>Transaction type</li>
	 * <li>Transaction subtype</li>
	 * </ul>
	 * The data feed through the enrich APIs will be updated to the Yodlee Platform in real time. The updated accounts
	 * and transactions information can then be retrieved from the system using the respective Yodlee 1.1 APIs.<br>
	 * 
	 * <b> Implementation Notes </b>
	 * <ul>
	 * <li>Supported only through credential-based authentication mechanisms.</li>
	 * <li>Customer must be TLS 1.2 compliant to integrate with the data enrich API.</li>
	 * <li>Supported account types are savings, checking, and credit.</li>
	 * <li>A maximum of 128 transactions can be passed to the API.</li>
	 * <li>As the data enrich API is a premium offering and is priced per API call, Yodlee recommends not to call the
	 * API to update accounts and transactions.</li>
	 * <li>The minimum required parameters to create account and transaction is accepted. The Yodlee data model supports
	 * more parameters than what is accepted in this API. Customers can make the rest of the parameters available during
	 * the auto-refresh process of the accounts.</li>
	 * <li>Though few input parameters are optional, Yodlee recommends passing them as the account information will make
	 * complete sense to the consumers when it is displayed in the Yodlee applications or widgets.</li>
	 * </ul>
	 * 
	 * @param userData - user data (required)
	 * @return {@link ApiResponse}&lt;{@link EnrichedTransactionResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<EnrichedTransactionResponse> pushUserData(EnrichDataRequest userData) throws ApiException {
		LOGGER.info("DataFeed pushUserData API execution started");
		EnrichDataValidator.validatePushUserData(this, ApiUtils.getMethodName());
		CallContext callContext = buildPushUserDataContext(userData);
		return callContext.getApiClient().execute(callContext.getCall(), EnrichedTransactionResponse.class);
	}

	/**
	 * <b>Push User Data </b><br>
	 * The data enrich API v1.1 allows customers to get the transactions enriched in real-time by feeding the data into
	 * the Yodlee Platform. To get the transactions enriched, it is necessary that users, accounts, and transactions are
	 * updated to the Yodlee Platform.<br>
	 * The following features are supported through the data enrich API:
	 * <ul>
	 * <li>Add user</li>
	 * <li>Add account</li>
	 * <li>Update account</li>
	 * <li>Add transactions</li>
	 * <li>Update transactions</li>
	 * </ul>
	 * Yodlee will enrich the transactions with the following information:
	 * <ul>
	 * <li>Category</li>
	 * <li>High Level Category</li>
	 * <li>Detail Category</li>
	 * <li>Simple description</li>
	 * <li>Merchant details
	 * <ul>
	 * <li>Name</li>
	 * <li>Address</li>
	 * </ul>
	 * </li>
	 * <li>Transaction type</li>
	 * <li>Transaction subtype</li>
	 * </ul>
	 * The data feed through the enrich APIs will be updated to the Yodlee Platform in real time. The updated accounts
	 * and transactions information can then be retrieved from the system using the respective Yodlee 1.1 APIs.<br>
	 * 
	 * <b> Implementation Notes </b>
	 * <ul>
	 * <li>Supported only through credential-based authentication mechanisms.</li>
	 * <li>Customer must be TLS 1.2 compliant to integrate with the data enrich API.</li>
	 * <li>Supported account types are savings, checking, and credit.</li>
	 * <li>A maximum of 128 transactions can be passed to the API.</li>
	 * <li>As the data enrich API is a premium offering and is priced per API call, Yodlee recommends not to call the
	 * API to update accounts and transactions.</li>
	 * <li>The minimum required parameters to create account and transaction is accepted. The Yodlee data model supports
	 * more parameters than what is accepted in this API. Customers can make the rest of the parameters available during
	 * the auto-refresh process of the accounts.</li>
	 * <li>Though few input parameters are optional, Yodlee recommends passing them as the account information will make
	 * complete sense to the consumers when it is displayed in the Yodlee applications or widgets.</li>
	 * </ul>
	 * 
	 * @param apiCallback {@link ApiCallback}&lt;{@link EnrichedTransactionResponse}&gt;
	 * @param userData - user data (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void pushUserDataAsync(ApiCallback<EnrichedTransactionResponse> apiCallback, EnrichDataRequest userData)
			throws ApiException {
		LOGGER.info("DataFeed pushUserDataAsync API execution started");
		EnrichDataValidator.validatePushUserData(this, ApiUtils.getMethodName());
		CallContext callContext = buildPushUserDataContext(userData);
		callContext.getApiClient().executeAsync(callContext.getCall(), EnrichedTransactionResponse.class, apiCallback);
	}

	private CallContext buildPushUserDataContext(EnrichDataRequest userData) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiCallModel = new ApiContext(ApiEndpoint.DATAENRICH_USER_DATA, HttpMethod.POST, userData);
		registerResponseInterceptor(apiClient);
		okhttp3.Call call = apiClient.buildCall(apiCallModel, requestListener());
		return new CallContext(apiClient, call);
	}
}
