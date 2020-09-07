/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api;

import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.configs.enums.ConfigsNotificationEventType;
import com.yodlee.api.model.configs.request.CreateConfigsNotificationEventRequest;
import com.yodlee.api.model.configs.request.UpdateConfigsNotificationEventRequest;
import com.yodlee.api.model.configs.response.ConfigsNotificationResponse;
import com.yodlee.api.model.configs.response.ConfigsPublicKeyResponse;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;
import com.yodlee.sdk.api.validators.ConfigsValidator;
import com.yodlee.sdk.client.ApiCallback;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.client.ApiContext;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.client.CallContext;
import com.yodlee.sdk.client.HttpMethod;
import com.yodlee.sdk.client.Pair;
import com.yodlee.sdk.context.Context;
import okhttp3.Call;

public class ConfigsApi extends AbstractApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigsApi.class);

	private static final String PARAM_EVENT_NAME = "eventName";

	public ConfigsApi(Context<?> context) {
		super(context);
	}

	/**
	 * Subscribe Event The subscribe events service is used to subscribe to an event for receiving notifications.<br>
	 * The callback URL, where the notification will be posted should be provided to this service.<br>
	 * Customers can subscribe to REFRESH,DATA_UPDATES and AUTO_REFRESH_UPDATES event.<br>
	 * <br>
	 * <b>Notes</b>:<br>
	 * This service is not available in developer sandbox/test environment and will be made available for testing in
	 * your dedicated environment, once the contract is signed.<br>
	 * The content type has to be passed as application/json for the body parameter.<br>
	 * 
	 * @param eventName event Name (required)
	 * @param eventRequest event Request (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> createSubscriptionNotificationEvent(
			@NotNull(message = "{configs.param.eventName.required}") ConfigsNotificationEventType eventName,//
			@NotNull(message = "{configs.CreateConfigsNotificationEventRequest.required}") CreateConfigsNotificationEventRequest eventRequest)
			throws ApiException {
		LOGGER.info("Configs createSubscriptionNotificationEvent API execution started");
		ConfigsValidator.validateCreateSubscriptionNotificationEvent(this, ApiUtils.getMethodName(), eventName,
				eventRequest);
		CallContext callContext = buildCreateSubscriptionNotificationEventContext(eventName, eventRequest);
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Subscribe Event The subscribe events service is used to subscribe to an event for receiving notifications.<br>
	 * The callback URL, where the notification will be posted should be provided to this service.<br>
	 * Customers can subscribe to REFRESH,DATA_UPDATES and AUTO_REFRESH_UPDATES event.<br>
	 * <br>
	 * <b>Notes</b>:<br>
	 * This service is not available in developer sandbox/test environment and will be made available for testing in
	 * your dedicated environment, once the contract is signed.<br>
	 * The content type has to be passed as application/json for the body parameter.<br>
	 * 
	 * @param eventName event Name (required)
	 * @param eventRequest event Request (required)
	 * @param apiCallBack {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void createSubscriptionNotificationEventAsync(
			@NotNull(message = "{configs.param.eventName.required}") ConfigsNotificationEventType eventName,//
			@NotNull(message = "{configs.CreateConfigsNotificationEventRequest.required}") CreateConfigsNotificationEventRequest eventRequest,
			ApiCallback<AbstractModelComponent> apiCallBack) throws ApiException {
		LOGGER.info("Configs createSubscriptionNotificationEventAsync API execution started");
		ConfigsValidator.validateCreateSubscriptionNotificationEvent(this, ApiUtils.getMethodName(), eventName,
				eventRequest);
		CallContext callContext = buildCreateSubscriptionNotificationEventContext(eventName, eventRequest);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallBack);
	}

	private CallContext buildCreateSubscriptionNotificationEventContext(ConfigsNotificationEventType eventName,
			CreateConfigsNotificationEventRequest eventRequest) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		String endPoint = replacePathVariable(ApiEndpoint.CONFIGS_NOTIFICATIONS_EVENTS_EVENT_NAME, PARAM_EVENT_NAME,
				eventName.toString());
		ApiContext apiContext = new ApiContext(endPoint, HttpMethod.POST, eventRequest);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Update Subscription The update events service is used to update the callback URL.<br>
	 * <b>Note:</b> The content type has to be passed as application/json for the body parameter. <br>
	 * 
	 * @param eventName event Name (required)
	 * @param eventRequest event Request (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> updateSubscribedNotificationEvent(
			@NotNull(message = "{configs.param.eventName.required}") ConfigsNotificationEventType eventName,
			@NotNull(message = "{configs.UpdateConfigsNotificationEventRequest.required}") UpdateConfigsNotificationEventRequest eventRequest)
			throws ApiException {
		LOGGER.info("Configs updateSubscribedNotificationEvent API execution started");
		ConfigsValidator.validateUpdateSubscribedNotificationEvent(this, ApiUtils.getMethodName(), eventName,
				eventRequest);
		CallContext callContext = buildUpdateSubscribedNotificationEventContext(eventName, eventRequest);
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Update Subscription The update events service is used to update the callback URL.<br>
	 * <b>Note:</b> The content type has to be passed as application/json for the body parameter. <br>
	 * 
	 * @param eventName event Name (required)
	 * @param eventRequest event Request (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void updateSubscribedNotificationEventAsync(
			@NotNull(message = "{configs.param.eventName.required}") ConfigsNotificationEventType eventName,
			@NotNull(message = "{configs.UpdateConfigsNotificationEventRequest.required}") UpdateConfigsNotificationEventRequest eventRequest,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Configs updateSubscribedNotificationEventAsync API execution started");
		ConfigsValidator.validateUpdateSubscribedNotificationEvent(this, ApiUtils.getMethodName(), eventName,
				eventRequest);
		CallContext callContext = buildUpdateSubscribedNotificationEventContext(eventName, eventRequest);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildUpdateSubscribedNotificationEventContext(ConfigsNotificationEventType eventName,
			UpdateConfigsNotificationEventRequest eventRequest) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		String endPoint = replacePathVariable(ApiEndpoint.CONFIGS_NOTIFICATIONS_EVENTS_EVENT_NAME, PARAM_EVENT_NAME,
				eventName.toString());
		ApiContext apiContext = new ApiContext(endPoint, HttpMethod.PUT, eventRequest);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Delete Subscription The delete events service is used to unsubscribe from an events service.<br>
	 * 
	 * @param eventName event Name (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> deleteSubscribedNotificationEvent(
			@NotNull(message = "{configs.param.eventName.required}") ConfigsNotificationEventType eventName)
			throws ApiException {
		LOGGER.info("Configs deleteSubscribedNotificationEvent API execution started");
		ConfigsValidator.validateDeleteSubscribedNotificationEvent(this, ApiUtils.getMethodName(), eventName);
		CallContext callContext = buildDeleteSubscribedNotificationEventContext(eventName);
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Delete Subscription The delete events service is used to unsubscribe from an events service.<br>
	 * 
	 * @param eventName event Name (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void deleteSubscribedNotificationEventAsync(
			@NotNull(message = "{configs.param.eventName.required}") ConfigsNotificationEventType eventName,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Configs deleteSubscribedNotificationEventAsync API execution started");
		ConfigsValidator.validateDeleteSubscribedNotificationEvent(this, ApiUtils.getMethodName(), eventName);
		CallContext callContext = buildDeleteSubscribedNotificationEventContext(eventName);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildDeleteSubscribedNotificationEventContext(ConfigsNotificationEventType eventName)
			throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		String endPoint = replacePathVariable(ApiEndpoint.CONFIGS_NOTIFICATIONS_EVENTS_EVENT_NAME, PARAM_EVENT_NAME,
				eventName.toString());
		ApiContext apiContext = new ApiContext(endPoint, HttpMethod.DELETE, null);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get Public Key The get public key service provides the public key that should be used to encrypt user credentials
	 * while invoking POST /providerAccounts and PUT /providerAccounts endpoints.<br>
	 * This service will only work if the PKI (public key infrastructure) feature is enabled for the customer.<br>
	 * <b>Note:</b> The key in the response is a string in PEM format. <br>
	 * 
	 * @return {@link ApiResponse}&lt;{@link ConfigsPublicKeyResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<ConfigsPublicKeyResponse> getPublicEncryptionKey() throws ApiException {
		LOGGER.info("Configs getPublicEncryptionKey API execution started");
		ConfigsValidator.validateApiContext(this);
		CallContext callContext = buildGetPublicEncryptionKeyContext();
		return callContext.getApiClient().execute(callContext.getCall(), ConfigsPublicKeyResponse.class);
	}

	/**
	 * Get Public Key The get public key service provides the public key that should be used to encrypt user credentials
	 * while invoking POST /providerAccounts and PUT /providerAccounts endpoints.<br>
	 * This service will only work if the PKI (public key infrastructure) feature is enabled for the customer.<br>
	 * <b>Note:</b> The key in the response is a string in PEM format. <br>
	 * 
	 * @param apiCallback {@link ApiCallback}&lt;{@link ConfigsPublicKeyResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getPublicEncryptionKeyAsync(ApiCallback<ConfigsPublicKeyResponse> apiCallback) throws ApiException {
		LOGGER.info("Configs getPublicEncryptionKeyAsync API execution started");
		ConfigsValidator.validateApiContext(this);
		CallContext callContext = buildGetPublicEncryptionKeyContext();
		callContext.getApiClient().executeAsync(callContext.getCall(), ConfigsPublicKeyResponse.class, apiCallback);
	}

	private CallContext buildGetPublicEncryptionKeyContext() throws ApiException {
		ApiContext apiContext = new ApiContext(ApiEndpoint.CONFIGS_PUBLIC_KEY, HttpMethod.GET, null);
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get Subscribed Events The get events service provides the list of events for which consumers subscribed <br>
	 * to receive notifications. <br>
	 * 
	 * @param eventName event Name (optional)
	 * @return {@link ApiResponse}&lt;{@link ConfigsNotificationResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<ConfigsNotificationResponse>
			getSubscribedNotificationEvents(ConfigsNotificationEventType eventName) throws ApiException {
		LOGGER.info("Configs getSubscribedNotificationEvents API execution started");
		ConfigsValidator.validateApiContext(this);
		CallContext callContext = buildGetSubscribedNotificationEventsContext(eventName);
		return callContext.getApiClient().execute(callContext.getCall(), ConfigsNotificationResponse.class);
	}

	/**
	 * Get Subscribed Events The get events service provides the list of events for which consumers subscribed <br>
	 * to receive notifications. <br>
	 * 
	 * @param eventName event Name (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link ConfigsNotificationResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getSubscribedNotificationEventsAsync(ConfigsNotificationEventType eventName,
			ApiCallback<ConfigsNotificationResponse> apiCallback) throws ApiException {
		LOGGER.info("Configs getSubscribedNotificationEventsAsync API execution started");
		ConfigsValidator.validateApiContext(this);
		CallContext callContext = buildGetSubscribedNotificationEventsContext(eventName);
		callContext.getApiClient().executeAsync(callContext.getCall(), ConfigsNotificationResponse.class, apiCallback);
	}

	private CallContext buildGetSubscribedNotificationEventsContext(ConfigsNotificationEventType eventName)
			throws ApiException {
		ApiContext apiContext = new ApiContext(ApiEndpoint.CONFIGS_NOTIFICATIONS_EVENTS, HttpMethod.GET, null);
		if (eventName != null) {
			apiContext.addQueryParam(new Pair(PARAM_EVENT_NAME, eventName.name()));
		}
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}
}
