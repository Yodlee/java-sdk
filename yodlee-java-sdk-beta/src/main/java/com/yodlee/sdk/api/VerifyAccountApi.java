/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yodlee.api.model.verifyaccount.request.VerifyAccountRequest;
import com.yodlee.api.model.verifyaccount.response.VerifyAccountResponse;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;
import com.yodlee.sdk.api.validators.VerifyAccountValidator;
import com.yodlee.sdk.client.ApiCallback;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.client.ApiContext;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.client.CallContext;
import com.yodlee.sdk.client.HttpMethod;
import com.yodlee.sdk.context.Context;
import okhttp3.Call;

public class VerifyAccountApi extends AbstractApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(VerifyAccountApi.class);

	private static final String PROVIDER_ACCOUNT_ID = "providerAccountId";

	public VerifyAccountApi(Context<?> context) {
		super(context);
	}

	/**
	 * Verify Accounts Using Transactions The verify account service is used to verify the account's ownership by
	 * matching the transaction details with the accounts aggregated for the user.<br>
	 * 
	 * If a match is identified, the service returns details of all the accounts along with the matched transaction's
	 * details.<br>
	 * If no transaction match is found, an empty response will be returned.<br>
	 * A maximum of 5 transactionCriteria can be passed in a request.<br>
	 * The baseType, date, and amount parameters is mandatory.<br>
	 * The optional dateVariance parameter cannot be more than 7 days. For example, +7, -4, or +/-2.<br>
	 * Pass the container or accountId parameters for better performance.<br>
	 * 
	 * @param providerAccountId providerAccountId (required)
	 * @param verificationParam verificationParam (required)
	 * @return {@link ApiResponse}&lt;{@link VerifyAccountResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<VerifyAccountResponse> verifyAccounts(//
			@Digits(message = "{verifyAccounts.param.providerAccountId.invalid}",
					fraction = 0,
					integer = 11) long providerAccountId,
			@NotNull(message = "{verifyAccounts.verifyAccountRequest.required}") VerifyAccountRequest verificationParam)
			throws ApiException {
		LOGGER.info("VerifyAccounts API execution started");
		VerifyAccountValidator.validatePostVerifyAccount(this, ApiUtils.getMethodName(), providerAccountId,
				verificationParam);
		CallContext callContext = buildverifyAccountsContext(providerAccountId, verificationParam);
		return callContext.getApiClient().execute(callContext.getCall(), VerifyAccountResponse.class);
	}

	/**
	 * Verify Accounts Using Transactions The verify account service is used to verify the account's ownership by
	 * matching the transaction details with the accounts aggregated for the user.<br>
	 * 
	 * If a match is identified, the service returns details of all the accounts along with the matched transaction's
	 * details.<br>
	 * If no transaction match is found, an empty response will be returned.<br>
	 * A maximum of 5 transactionCriteria can be passed in a request.<br>
	 * The baseType, date, and amount parameters should mandatorily be passed.<br>
	 * The optional dateVariance parameter cannot be more than 7 days. For example, +7, -4, or +/-2.<br>
	 * Pass the container or accountId parameters for better performance.<br>
	 * 
	 * @param providerAccountId providerAccountId (required)
	 * @param verificationParam verificationParam (required)
	 * @param apiCallback {@link ApiCallback}&lt;{@link VerifyAccountResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void verifyAccountsAsync(//
			@Digits(message = "{verifyAccounts.param.providerAccountId.invalid}",
					fraction = 0,
					integer = 11) long providerAccountId,
			@NotNull(message = "{verifyAccounts.verifyAccountRequest.required}") VerifyAccountRequest verificationParam,
			ApiCallback<VerifyAccountResponse> apiCallback) throws ApiException {
		LOGGER.info("VerifyAccountsAsync API execution started");
		VerifyAccountValidator.validatePostVerifyAccount(this, ApiUtils.getMethodName(), providerAccountId,
				verificationParam);
		CallContext callContext = buildverifyAccountsContext(providerAccountId, verificationParam);
		callContext.getApiClient().executeAsync(callContext.getCall(), VerifyAccountResponse.class, apiCallback);
	}

	private CallContext buildverifyAccountsContext(long providerAccountId, VerifyAccountRequest verificationParam)
			throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		String apiEndPoint = replacePathVariable(ApiEndpoint.VERIFY_ACCOUNTS, PROVIDER_ACCOUNT_ID,
				String.valueOf(providerAccountId));
		ApiContext apiContext = new ApiContext(apiEndPoint, HttpMethod.POST, verificationParam);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}
}
