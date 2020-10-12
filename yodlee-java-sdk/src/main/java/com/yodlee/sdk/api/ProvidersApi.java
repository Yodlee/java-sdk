/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yodlee.api.model.providers.response.ProviderDetailResponse;
import com.yodlee.api.model.providers.response.ProviderResponse;
import com.yodlee.api.model.providers.response.ProvidersCountResponse;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;
import com.yodlee.sdk.api.validators.ProvidersValidator;
import com.yodlee.sdk.api.validators.ProvidersValidator.ProvidersCapability;
import com.yodlee.sdk.api.validators.ProvidersValidator.ProvidersPriorityType;
import com.yodlee.sdk.client.ApiCallback;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.client.ApiContext;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.client.CallContext;
import com.yodlee.sdk.client.HttpMethod;
import com.yodlee.sdk.client.Pair;
import com.yodlee.sdk.context.Context;
import okhttp3.Call;

public class ProvidersApi extends AbstractApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProvidersApi.class);

	private static final String PARAM_TOP = "top";

	private static final String PARAM_SKIP = "skip";

	private static final String PARAM_PRIORITY = "priority";

	private static final String PARAM_NAME = "name";

	private static final String PARAM_DATASET$FILTER = "dataset$filter";

	private static final String FULL_ACCT_NUMBER_FIELDS = "fullAccountNumberFields";

	private static final String PARAM_CAPABILITY = "capability";

	private static final String PARAM_PROVIDER_ID = "providerId";

	public ProvidersApi(Context<?> context) {
		super(context);
	}

	/**
	 * Get Providers The get provider service is used to get all the providers that are enabled, <br>
	 * search a provider service by name or routing number and get popular sites of a region. <br>
	 * The valid values for priority are: <br>
	 * 1. cobrand: Returns providers enabled for the cobrand (Default priority)<br>
	 * 2. popular: Returns providers popular among users of the customer<br>
	 * <br>
	 * Datasets,attributes and containers that are enabled for the customer alone will be returned in the response<br>
	 * Input for the dataset$filter should adhere to the following expression:<br>
	 * {@literal <}dataset.name{@literal >}[{@literal <}attribute.name{@literal >}.container[{@literal <}container
	 * {@literal >} OR {@literal <}container{@literal >}] OR
	 * {@literal <}attribute.name{@literal >}.container[{@literal <}container{@literal >}]] <br>
	 * OR {@literal <}dataset.name{@literal >}[{@literal <}attribute.name{@literal >} OR
	 * {@literal <}attribute.name{@literal >}]<br>
	 * <b>dataset$filter value examples:</b><br>
	 * ACCT_PROFILE[FULL_ACCT_NUMBER.container[bank OR investment OR creditCard]]<br>
	 * ACCT_PROFILE[FULL_ACCT_NUMBER.container[bank]]<br>
	 * BASIC_AGG_DATA[ACCOUNT_DETAILS.container[bank OR investment] OR HOLDINGS.container[bank]] OR
	 * ACCT_PROFILE[FULL_ACCT_NUMBER.container[bank]]<br>
	 * BASIC_AGG_DATA<br>
	 * BASIC_AGG_DATA OR ACCT_PROFILE<br>
	 * BASIC_AGG_DATA [ ACCOUNT_DETAILS OR HOLDINGS ]<br>
	 * BASIC_AGG_DATA [ ACCOUNT_DETAILS] OR DOCUMENT <br>
	 * BASIC_AGG_DATA [ BASIC_ACCOUNT_INFO OR ACCOUNT_DETAILS ] <br>
	 * <br>
	 * The fullAcountNumberFields is specified to filter the providers that have paymentAccountNumber or
	 * unmaskedAccountNumber support in the FULL_ACCT_NUMBER dataset attribute.<br>
	 * <b>Examples for usage of fullAccountNumberFields –</b><br>
	 * dataset$filter=ACCT_PROFILE[ FULL_ACCT_NUMBER.container [ bank ]] &amp;
	 * fullAccountNumberFields=paymentAccountNumber<br>
	 * dataset$filter=ACCT_PROFILE[ FULL_ACCT_NUMBER.container [ bank ]] &amp;
	 * fullAccountNumberFields=unmaskedAccountNumber<br>
	 * dataset$filter=ACCT_PROFILE[ FULL_ACCT_NUMBER.container [ bank ]] &amp;
	 * fullAccountNumberFields=unmaskedAccountNumber,paymentAccountNumber<br>
	 * <br>
	 * 
	 * <b>Note:</b> <br>
	 * 1. When this service is invoked without any filters, the service performs slowly and takes a few minutes to
	 * return data in the response.<br>
	 * 2. The recommendation is to use this service with filters when used in a flow involving user interactions.
	 * 
	 * @param capability CHALLENGE_DEPOSIT_VERIFICATION (deprecated)
	 * @param datasetFilter Expression to filter the providers by dataset(s) or dataset attribute(s). The default value
	 *        will be the dataset or dataset attributes configured as default for the customer. (optional)
	 * @param name Name in minimum 1 character or routing number. (optional)
	 * @param priority Search priority (optional)
	 * @param skip skip (Min 0) - This is not applicable along with &#39;name&#39; parameter. (optional)
	 * @param top top (Max 500) - This is not applicable along with &#39;name&#39; parameter. (optional)
	 * @param fullAccountNumberFields fullAccountNumber (optional)
	 * @return {@link ApiResponse}&lt;{@link ProviderResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<ProviderResponse> getAllProviders(@Deprecated ProvidersCapability capability, //
			String datasetFilter,//
			String name, ProvidersPriorityType priority,//
			@Min(value = 0, message = "{providers.param.skip.invalid}") Integer skip,//
			@Min(value = 1, message = "{providers.param.top.invalid}") //
			@Max(value = 500, message = "{providers.param.top.invalid}") Integer top,//
			String fullAccountNumberFields) throws ApiException {
		LOGGER.info("Providers getAllProviders API execution started");
		ProvidersValidator.validateGetProviders(this, ApiUtils.getMethodName(), capability, datasetFilter,
				fullAccountNumberFields, name, priority, skip, top);
		CallContext callContext = buildGetAllProvidersContext(capability, datasetFilter, fullAccountNumberFields, name,
				priority, skip, top);
		return callContext.getApiClient().execute(callContext.getCall(), ProviderResponse.class);
	}

	/**
	 * Get Providers The get provider service is used to get all the providers that are enabled, <br>
	 * search a provider service by name or routing number and get popular sites of a region. <br>
	 * The valid values for priority are: <br>
	 * 1. cobrand: Returns providers enabled for the cobrand (Default priority)<br>
	 * 2. popular: Returns providers popular among users of the customer<br>
	 * <br>
	 * Datasets,attributes and containers that are enabled for the customer alone will be returned in the response<br>
	 * Input for the dataset$filter should adhere to the following expression:<br>
	 * {@literal <}dataset.name{@literal >}[{@literal <}attribute.name{@literal >}.container[{@literal <}container
	 * {@literal >} OR {@literal <}container{@literal >}] OR
	 * {@literal <}attribute.name{@literal >}.container[{@literal <}container{@literal >}]] <br>
	 * OR {@literal <}dataset.name{@literal >}[{@literal <}attribute.name{@literal >} OR {@literal
	 * <}attribute.name{@literal >}]<br>
	 * <b>dataset$filter value examples:</b><br>
	 * ACCT_PROFILE[FULL_ACCT_NUMBER.container[bank OR investment OR creditCard]]<br>
	 * ACCT_PROFILE[FULL_ACCT_NUMBER.container[bank]]<br>
	 * BASIC_AGG_DATA[ACCOUNT_DETAILS.container[bank OR investment] OR HOLDINGS.container[bank]] OR
	 * ACCT_PROFILE[FULL_ACCT_NUMBER.container[bank]]<br>
	 * BASIC_AGG_DATA<br>
	 * BASIC_AGG_DATA OR ACCT_PROFILE<br>
	 * BASIC_AGG_DATA [ ACCOUNT_DETAILS OR HOLDINGS ]<br>
	 * BASIC_AGG_DATA [ ACCOUNT_DETAILS] OR DOCUMENT <br>
	 * BASIC_AGG_DATA [ BASIC_ACCOUNT_INFO OR ACCOUNT_DETAILS ] <br>
	 * <br>
	 * The fullAcountNumberFields is specified to filter the providers that have paymentAccountNumber or
	 * unmaskedAccountNumber support in the FULL_ACCT_NUMBER dataset attribute.<br>
	 * <b>Examples for usage of fullAccountNumberFields –</b><br>
	 * dataset$filter=ACCT_PROFILE[ FULL_ACCT_NUMBER.container [ bank ]] &amp;
	 * fullAccountNumberFields=paymentAccountNumber<br>
	 * dataset$filter=ACCT_PROFILE[ FULL_ACCT_NUMBER.container [ bank ]] &amp;
	 * fullAccountNumberFields=unmaskedAccountNumber<br>
	 * dataset$filter=ACCT_PROFILE[ FULL_ACCT_NUMBER.container [ bank ]] &amp;
	 * fullAccountNumberFields=unmaskedAccountNumber,paymentAccountNumber<br>
	 * <br>
	 * 
	 * <b>Note:</b> <br>
	 * 1. When this service is invoked without any filters, the service performs slowly and takes a few minutes to
	 * return data in the response.<br>
	 * 2. The recommendation is to use this service with filters when used in a flow involving user interactions.
	 * 
	 * @param capability CHALLENGE_DEPOSIT_VERIFICATION (deprecated)
	 * @param datasetFilter Expression to filter the providers by dataset(s) or dataset attribute(s). The default value
	 *        will be the dataset or dataset attributes configured as default for the customer. (optional)
	 * @param name Name in minimum 1 character or routing number. (optional)
	 * @param priority Search priority (optional)
	 * @param skip skip (Min 0) - This is not applicable along with &#39;name&#39; parameter. (optional)
	 * @param top top (Max 500) - This is not applicable along with &#39;name&#39; parameter. (optional)
	 * @param fullAccountNumberFields fullAccountNumber (optional)
	 * @param apiCallBack {@link ApiCallback}&lt;{@link ProviderResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getAllProvidersAsync(@Deprecated ProvidersCapability capability, //
			String datasetFilter,//
			String name, ProvidersPriorityType priority,//
			@Min(value = 0, message = "{providers.param.skip.invalid}") Integer skip,//
			@Min(value = 1, message = "{providers.param.top.invalid}") //
			@Max(value = 500, message = "{providers.param.top.invalid}") Integer top,//
			String fullAccountNumberFields,//
			ApiCallback<ProviderResponse> apiCallBack) throws ApiException {
		LOGGER.info("Providers getAllProvidersAsync API execution started");
		ProvidersValidator.validateGetProviders(this, ApiUtils.getMethodName(), capability, datasetFilter,
				fullAccountNumberFields, name, priority, skip, top);
		CallContext callContext = buildGetAllProvidersContext(capability, datasetFilter, fullAccountNumberFields, name,
				priority, skip, top);
		callContext.getApiClient().executeAsync(callContext.getCall(), ProviderResponse.class, apiCallBack);
	}

	private CallContext buildGetAllProvidersContext(ProvidersCapability capability, //
			String datasetFilter,//
			String fullAccountNumberFields,//
			String name, ProvidersPriorityType priority,//
			Integer skip,//
			Integer top) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiCallModel = new ApiContext(ApiEndpoint.PROVIDERS, HttpMethod.GET, null);
		// Add query params
		if (capability != null) {
			apiCallModel.addQueryParam(new Pair(PARAM_CAPABILITY, capability.toString()));
		}
		if (!StringUtils.isEmpty(datasetFilter)) {
			apiCallModel.addQueryParam(new Pair(PARAM_DATASET$FILTER, datasetFilter));
		}
		if (!StringUtils.isEmpty(fullAccountNumberFields)) {
			apiCallModel.addQueryParam(new Pair(FULL_ACCT_NUMBER_FIELDS, fullAccountNumberFields));
		}
		if (!StringUtils.isEmpty(name)) {
			apiCallModel.addQueryParam(new Pair(PARAM_NAME, name));
		}
		if (priority != null) {
			apiCallModel.addQueryParam(new Pair(PARAM_PRIORITY, priority.toString()));
		}
		if (skip != null) {
			apiCallModel.addQueryParam(new Pair(PARAM_SKIP, skip.toString()));
		}
		if (top != null) {
			apiCallModel.addQueryParam(new Pair(PARAM_TOP, top.toString()));
		}
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiCallModel, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get Provider Details The get provider detail service is used to get detailed information including the login form
	 * for a provider.<br>
	 * The response is a provider object that includes information such as name of the provider, <br>
	 * provider&#39;s base URL, a list of containers supported by the provider, the login form details of the provider,
	 * etc.<br>
	 * Only enabled datasets, attributes and containers gets returned in the response.<br>
	 * 
	 * @param providerId providerId (required)
	 * @return {@link ApiResponse}&lt;{@link ProviderDetailResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<ProviderDetailResponse> getProvider(//
			@NotNull(message = "{providers.param.providerId.required}")//
			@Min(value = 0L, message = "{providers.param.providerId.invalid}") Long providerId) throws ApiException {
		LOGGER.info("Providers getProvider API execution started");
		ProvidersValidator.validateGetProviderDetails(this, ApiUtils.getMethodName(), providerId);
		CallContext callContext = buildgetProviderContext(providerId);
		return callContext.getApiClient().execute(callContext.getCall(), ProviderDetailResponse.class);
	}

	/**
	 * Get Provider Details The get provider detail service is used to get detailed information including the login form
	 * for a provider.<br>
	 * The response is a provider object that includes information such as name of the provider, <br>
	 * provider&#39;s base URL, a list of containers supported by the provider, the login form details of the provider,
	 * etc.<br>
	 * Only enabled datasets, attributes and containers gets returned in the response.<br>
	 * 
	 * @param providerId providerId (required)
	 * @param apiCallback {@link ApiCallback}&lt;{@link ProviderDetailResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getProviderAsync(//
			@NotNull(message = "{providers.param.providerId.required}")//
			@Min(value = 0L, message = "{providers.param.providerId.invalid}") Long providerId,
			ApiCallback<ProviderDetailResponse> apiCallback) throws ApiException {
		LOGGER.info("Providers getProviderAsync API execution started");
		ProvidersValidator.validateGetProviderDetails(this, ApiUtils.getMethodName(), providerId);
		CallContext callContext = buildgetProviderContext(providerId);
		callContext.getApiClient().executeAsync(callContext.getCall(), ProviderDetailResponse.class, apiCallback);
	}

	private CallContext buildgetProviderContext(Long providerId) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		String apiEndPoint = replacePathVariable(ApiEndpoint.PROVIDER_DETAIL, PARAM_PROVIDER_ID, providerId.toString());
		registerResponseInterceptor(apiClient);
		ApiContext apiCallModel = new ApiContext(apiEndPoint, HttpMethod.GET, null);
		Call call = apiClient.buildCall(apiCallModel, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get Providers Count The count service provides the total number of providers that get returned in the GET
	 * /providers depending on the input parameters passed.<br>
	 * If you are implementing pagination for providers, call this endpoint before calling GET /providers to know the
	 * number of providers that are returned for the input parameters passed.<br>
	 * The functionality of the input parameters remains the same as that of the GET /providers endpoint<br>
	 * .
	 * 
	 * @param capability CHALLENGE_DEPOSIT_VERIFICATION (deprecated)
	 * @param datasetFilter Expression to filter the providers by dataset(s) or dataset attribute(s). The default value
	 *        will be the dataset or dataset attributes configured as default for the customer. (optional)
	 * @param name Name in minimum 1 character or routing number. (optional)
	 * @param priority Search priority (optional)
	 * @param fullAccountNumberFields fullAccountNumber (optional)
	 * @return {@link ApiResponse}&lt;{@link ProvidersCountResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<ProvidersCountResponse> getProvidersCount(@Deprecated ProvidersCapability capability,//
			String datasetFilter, String name, ProvidersPriorityType priority, String fullAccountNumberFields)
			throws ApiException {
		LOGGER.info("Providers getProvidersCount API execution started");
		ProvidersValidator.validateGetProvidersCount(this, ApiUtils.getMethodName(), capability, datasetFilter,
				fullAccountNumberFields, name, priority);
		CallContext callContext =
				buildGetProvidersCountContext(capability, datasetFilter, fullAccountNumberFields, name, priority);
		return callContext.getApiClient().execute(callContext.getCall(), ProvidersCountResponse.class);
	}

	/**
	 * Get Providers Count The count service provides the total number of providers that get returned in the GET
	 * /providers depending on the input parameters passed.<br>
	 * If you are implementing pagination for providers, call this endpoint before calling GET /providers to know the
	 * number of providers that are returned for the input parameters passed.<br>
	 * The functionality of the input parameters remains the same as that of the GET /providers endpoint<br>
	 * .
	 * 
	 * @param capability CHALLENGE_DEPOSIT_VERIFICATION (deprecated)
	 * @param datasetFilter Expression to filter the providers by dataset(s) or dataset attribute(s). The default value
	 *        will be the dataset or dataset attributes configured as default for the customer. (optional)
	 * @param name Name in minimum 1 character or routing number. (optional)
	 * @param priority Search priority (optional)
	 * @param fullAccountNumberFields fullAccountNumber (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link ProvidersCountResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getProvidersCountAsync(@Deprecated ProvidersCapability capability,//
			String datasetFilter, String name, ProvidersPriorityType priority,
			String fullAccountNumberFields, //
			ApiCallback<ProvidersCountResponse> apiCallback) throws ApiException {
		LOGGER.info("Providers getProvidersCountAsync API execution started");
		ProvidersValidator.validateGetProvidersCount(this, ApiUtils.getMethodName(), capability, datasetFilter,
				fullAccountNumberFields, name, priority);
		CallContext callContext =
				buildGetProvidersCountContext(capability, datasetFilter, fullAccountNumberFields, name, priority);
		callContext.getApiClient().executeAsync(callContext.getCall(), ProvidersCountResponse.class, apiCallback);
	}

	private CallContext buildGetProvidersCountContext(ProvidersCapability capability,//
			String datasetFilter, String fullAccountNumberFields, String name, ProvidersPriorityType priority)
			throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiCallModel = new ApiContext(ApiEndpoint.PROVIDERS_COUNT, HttpMethod.GET, null);
		if (capability != null) {
			apiCallModel.addQueryParam(new Pair(PARAM_CAPABILITY, capability.toString()));
		}
		if (!StringUtils.isEmpty(datasetFilter)) {
			apiCallModel.addQueryParam(new Pair(PARAM_DATASET$FILTER, datasetFilter));
		}
		if (!StringUtils.isEmpty(fullAccountNumberFields)) {
			apiCallModel.addQueryParam(new Pair(FULL_ACCT_NUMBER_FIELDS, fullAccountNumberFields));
		}
		if (!StringUtils.isEmpty(name)) {
			apiCallModel.addQueryParam(new Pair(PARAM_NAME, name));
		}
		if (priority != null) {
			apiCallModel.addQueryParam(new Pair(PARAM_PRIORITY, priority.toString()));
		}
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiCallModel, requestListener());
		return new CallContext(apiClient, call);
	}
}
