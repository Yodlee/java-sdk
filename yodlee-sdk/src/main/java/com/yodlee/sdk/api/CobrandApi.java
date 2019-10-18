/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.api;

import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.squareup.okhttp.Call;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.cobrand.enums.CobrandNotificationEventType;
import com.yodlee.api.model.cobrand.request.CobrandLoginRequest;
import com.yodlee.api.model.cobrand.request.CreateCobrandNotificationEventRequest;
import com.yodlee.api.model.cobrand.request.UpdateCobrandNotificationEventRequest;
import com.yodlee.api.model.cobrand.response.CobrandLoginResponse;
import com.yodlee.api.model.cobrand.response.CobrandNotificationResponse;
import com.yodlee.api.model.cobrand.response.CobrandPublicKeyResponse;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;
import com.yodlee.sdk.api.validators.CobrandValidator;
import com.yodlee.sdk.client.ApiCallback;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.client.ApiContext;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.client.CallContext;
import com.yodlee.sdk.client.HttpMethod;
import com.yodlee.sdk.client.Pair;
import com.yodlee.sdk.configuration.cobrand.CobrandConfiguration;
import com.yodlee.sdk.context.CobrandContext;
import com.yodlee.sdk.context.Context;

public class CobrandApi extends AbstractApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(CobrandApi.class);

	private static final String PARAM_EVENT_NAME = "eventName";

	private final CobrandConfiguration cobrandConfiguration;

	public CobrandApi() {
		this(null, null);
	}

	public CobrandApi(CobrandConfiguration cobrandConfiguration) {
		this(null, cobrandConfiguration);
	}

	public CobrandApi(Context<?> context, CobrandConfiguration cobrandConfiguration) {
		super(context);
		this.cobrandConfiguration = cobrandConfiguration;
	}

	/**
	 * Cobrand Login The cobrand login service authenticates a cobrand.<br>
	 * Cobrand session in the response includes the cobrand session token (cobSession) <br>
	 * which is used in subsequent API calls like registering or signing in the user. <br>
	 * The idle timeout for a cobrand session is 2 hours and the absolute timeout is 24 hours. This service can be <br>
	 * invoked to create a new cobrand session token. <br>
	 * <b>Note:</b> This endpoint is deprecated for customers using the API Key-based authentication and is applicable
	 * only to customers who use the SAML-based authentication.<br>
	 * The content type has to be passed as application/json for the body parameter. <br>
	 * 
	 * @param cobrandLoginRequest cobrandLoginRequest (required)
	 * @return {@link ApiResponse}&lt;{@link CobrandLoginResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<CobrandLoginResponse> cobrandLogin(
			@NotNull(message = "{cobrand.required}") CobrandLoginRequest cobrandLoginRequest) throws ApiException {
		LOGGER.info("Cobrand cobrandLogin API execution started");
		CobrandValidator.validateCobrandLogin(this, ApiUtils.getMethodName(), cobrandLoginRequest);
		CallContext callContext = buildCobrandLoginContext(cobrandLoginRequest);
		ApiResponse<CobrandLoginResponse> cobrandLoginResponse =
				callContext.getApiClient().execute(callContext.getCall(), CobrandLoginResponse.class);
		String cobSession = cobrandLoginResponse.getData().getSession().getCobSession();
		CobrandContext cobrandContext = new CobrandContext(cobSession, cobrandConfiguration);
		setContext(cobrandContext);
		LOGGER.info("Cobrand cobrandLogin API execution ended and set the CobrandContext");
		return cobrandLoginResponse;
	}

	/**
	 * Cobrand Login The cobrand login service authenticates a cobrand.<br>
	 * Cobrand session in the response includes the cobrand session token (cobSession) <br>
	 * which is used in subsequent API calls like registering or signing in the user. <br>
	 * The idle timeout for a cobrand session is 2 hours and the absolute timeout is 24 hours. This service can be <br>
	 * invoked to create a new cobrand session token. <br>
	 * <b>Note:</b> This endpoint is deprecated for customers using the API Key-based authentication and is applicable
	 * only to customers who use the SAML-based authentication.<br>
	 * The content type has to be passed as application/json for the body parameter. <br>
	 * 
	 * @param cobrandLoginRequest cobrandLoginRequest (required)
	 * @param apiCallBack {@link ApiCallback}&lt;{@link CobrandLoginResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void cobrandLoginAsync(@NotNull(message = "{cobrand.required}") CobrandLoginRequest cobrandLoginRequest,
			ApiCallback<CobrandLoginResponse> apiCallBack) throws ApiException {
		LOGGER.info("Cobrand cobrandLoginAsync API execution started");
		CobrandValidator.validateCobrandLogin(this, ApiUtils.getMethodName(), cobrandLoginRequest);
		CallContext callContext = buildCobrandLoginContext(cobrandLoginRequest);
		callContext.getApiClient().executeAsync(callContext.getCall(), CobrandLoginResponse.class, apiCallBack);
	}

	private CallContext buildCobrandLoginContext(CobrandLoginRequest cobrandLoginRequest) throws ApiException {
		ApiContext apiContext = new ApiContext(ApiEndpoint.COBRAND_LOGIN, HttpMethod.POST, cobrandLoginRequest);
		ApiClient apiClient = getApiClient();
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Cobrand Logout The cobrand logout service is used to log out the cobrand.<br>
	 * This service does not return a response. The HTTP response code is 204 (Success with no content).<br>
	 * <b>Note:</b> This endpoint is deprecated for customers using the API Key-based authentication and is applicable
	 * only to customers who use the SAML-based authentication.<br>
	 * 
	 * @throws ApiException If fail to call the API
	 */
	public ApiResponse<AbstractModelComponent> cobrandLogout() throws ApiException {
		LOGGER.info("Cobrand Logout API execution started");
		CobrandValidator.validateApiContext(this);
		CallContext callContext = buildCobrandLogoutContext();
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Cobrand Logout The cobrand logout service is used to log out the cobrand.<br>
	 * This service does not return a response. The HTTP response code is 204 (Success with no content).<br>
	 * <b>Note:</b> This endpoint is deprecated for customers using the API Key-based authentication and is applicable
	 * only to customers who use the SAML-based authentication.<br>
	 * 
	 * @param apiCallBack {@link ApiCallback} (required)
	 * @throws ApiException If fail to call the API
	 */
	public void cobrandLogoutAsync(ApiCallback<AbstractModelComponent> apiCallBack) throws ApiException {
		LOGGER.info("Cobrand cobrandLogoutAsync API execution started");
		CobrandValidator.validateApiContext(this);
		CallContext callContext = buildCobrandLogoutContext();
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallBack);
	}

	private CallContext buildCobrandLogoutContext() throws ApiException {
		ApiContext apiContext = new ApiContext(ApiEndpoint.COBRAND_LOGOUT, HttpMethod.POST, null);
		ApiClient apiClient = getContext().getApiClient();
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
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
	public ApiResponse<AbstractModelComponent> createSubscriptionEvent(
			@NotNull(message = "{cobrand.param.eventName.required}") CobrandNotificationEventType eventName,//
			@NotNull(message = "{cobrand.CreateCobrandNotificationEventRequest.required}") CreateCobrandNotificationEventRequest eventRequest)
			throws ApiException {
		LOGGER.info("Cobrand createSubscriptionEvent API execution started");
		CobrandValidator.validateCreateSubscriptionEvent(this, ApiUtils.getMethodName(), eventName, eventRequest);
		CallContext callContext = buildCreateSubscriptionEventContext(eventName, eventRequest);
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
	public void createSubscriptionEventAsync(
			@NotNull(message = "{cobrand.param.eventName.required}") CobrandNotificationEventType eventName,//
			@NotNull(message = "{cobrand.CreateCobrandNotificationEventRequest.required}") CreateCobrandNotificationEventRequest eventRequest,
			ApiCallback<AbstractModelComponent> apiCallBack) throws ApiException {
		LOGGER.info("Cobrand createSubscriptionEventAsync API execution started");
		CobrandValidator.validateCreateSubscriptionEvent(this, ApiUtils.getMethodName(), eventName, eventRequest);
		CallContext callContext = buildCreateSubscriptionEventContext(eventName, eventRequest);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallBack);
	}

	private CallContext buildCreateSubscriptionEventContext(CobrandNotificationEventType eventName,
			CreateCobrandNotificationEventRequest eventRequest) throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		String endPoint = replacePathVariable(ApiEndpoint.COBRAND_CONFIG_NOTIFICATIONS_EVENTS_EVENT_NAME,
				PARAM_EVENT_NAME, eventName.toString());
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
	public ApiResponse<AbstractModelComponent> updateSubscribedEvent(
			@NotNull(message = "{cobrand.param.eventName.required}") CobrandNotificationEventType eventName,
			@NotNull(message = "{cobrand.UpdateCobrandNotificationEventRequest.required}") UpdateCobrandNotificationEventRequest eventRequest)
			throws ApiException {
		LOGGER.info("Cobrand updateSubscribedEvent API execution started");
		CobrandValidator.validateUpdateSubscribedEvent(this, ApiUtils.getMethodName(), eventName, eventRequest);
		CallContext callContext = buildUpdateSubscribedEventContext(eventName, eventRequest);
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
	public void updateSubscribedEventAsync(
			@NotNull(message = "{cobrand.param.eventName.required}") CobrandNotificationEventType eventName,
			@NotNull(message = "{cobrand.UpdateCobrandNotificationEventRequest.required}") UpdateCobrandNotificationEventRequest eventRequest,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Cobrand updateSubscribedEventAsync API execution started");
		CobrandValidator.validateUpdateSubscribedEvent(this, ApiUtils.getMethodName(), eventName, eventRequest);
		CallContext callContext = buildUpdateSubscribedEventContext(eventName, eventRequest);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildUpdateSubscribedEventContext(CobrandNotificationEventType eventName,
			UpdateCobrandNotificationEventRequest eventRequest) throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		String endPoint = replacePathVariable(ApiEndpoint.COBRAND_CONFIG_NOTIFICATIONS_EVENTS_EVENT_NAME,
				PARAM_EVENT_NAME, eventName.toString());
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
	public ApiResponse<AbstractModelComponent> deleteSubscribedEvent(
			@NotNull(message = "{cobrand.param.eventName.required}") CobrandNotificationEventType eventName)
			throws ApiException {
		LOGGER.info("Cobrand deleteSubscribedEvent API execution started");
		CobrandValidator.validateDeleteSubscribedEvent(this, ApiUtils.getMethodName(), eventName);
		CallContext callContext = buildDeleteSubscribedEventContext(eventName);
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
	public void deleteSubscribedEventAsync(
			@NotNull(message = "{cobrand.param.eventName.required}") CobrandNotificationEventType eventName,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Cobrand deleteSubscribedEventAsync API execution started");
		CobrandValidator.validateDeleteSubscribedEvent(this, ApiUtils.getMethodName(), eventName);
		CallContext callContext = buildDeleteSubscribedEventContext(eventName);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildDeleteSubscribedEventContext(CobrandNotificationEventType eventName) throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		String endPoint = replacePathVariable(ApiEndpoint.COBRAND_CONFIG_NOTIFICATIONS_EVENTS_EVENT_NAME,
				PARAM_EVENT_NAME, eventName.toString());
		ApiContext apiContext = new ApiContext(endPoint, HttpMethod.DELETE, null);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get Public Key The get public key service provides the customer the public key that should be used to encrypt the
	 * user credentials before sending it to Yodlee.<br>
	 * This endpoint is useful only for PKI enabled.<br>
	 * 
	 * @return {@link ApiResponse}&lt;{@link CobrandPublicKeyResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<CobrandPublicKeyResponse> getPublicKey() throws ApiException {
		LOGGER.info("Cobrand getPublicKey API execution started");
		CobrandValidator.validateApiContext(this);
		CallContext callContext = buildGetPublicKeyContext();
		return callContext.getApiClient().execute(callContext.getCall(), CobrandPublicKeyResponse.class);
	}

	/**
	 * Get Public Key The get public key service provides the customer the public key that should be used to encrypt the
	 * user credentials before sending it to Yodlee.<br>
	 * This endpoint is useful only for PKI enabled.<br>
	 * 
	 * @param apiCallback {@link ApiCallback}&lt;{@link CobrandPublicKeyResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getPublicKeyAsync(ApiCallback<CobrandPublicKeyResponse> apiCallback) throws ApiException {
		LOGGER.info("Cobrand getPublicKeyAsync API execution started");
		CobrandValidator.validateApiContext(this);
		CallContext callContext = buildGetPublicKeyContext();
		callContext.getApiClient().executeAsync(callContext.getCall(), CobrandPublicKeyResponse.class, apiCallback);
	}

	private CallContext buildGetPublicKeyContext() throws ApiException {
		ApiContext apiContext = new ApiContext(ApiEndpoint.COBRAND_PUBLIC_KEY, HttpMethod.GET, null);
		ApiClient apiClient = getContext().getApiClient();
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get Subscribed Events The get events service provides the list of events for which consumers subscribed <br>
	 * to receive notifications. <br>
	 * 
	 * @param eventName event Name (optional)
	 * @return {@link ApiResponse}&lt;{@link CobrandNotificationResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<CobrandNotificationResponse> getSubscribedEvents(CobrandNotificationEventType eventName)
			throws ApiException {
		LOGGER.info("Cobrand getPublicKey API execution started");
		CobrandValidator.validateApiContext(this);
		CallContext callContext = buildGetSubscribedEventsContext(eventName);
		return callContext.getApiClient().execute(callContext.getCall(), CobrandNotificationResponse.class);
	}

	/**
	 * Get Subscribed Events The get events service provides the list of events for which consumers subscribed <br>
	 * to receive notifications. <br>
	 * 
	 * @param eventName event Name (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link CobrandNotificationResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getSubscribedEventsAsync(CobrandNotificationEventType eventName,
			ApiCallback<CobrandNotificationResponse> apiCallback) throws ApiException {
		LOGGER.info("Cobrand getPublicKeyAsync API execution started");
		CobrandValidator.validateApiContext(this);
		CallContext callContext = buildGetSubscribedEventsContext(eventName);
		callContext.getApiClient().executeAsync(callContext.getCall(), CobrandNotificationResponse.class, apiCallback);
	}

	private CallContext buildGetSubscribedEventsContext(CobrandNotificationEventType eventName) throws ApiException {
		ApiContext apiContext = new ApiContext(ApiEndpoint.COBRAND_CONFIG_NOTIFICATIONS_EVENTS, HttpMethod.GET, null);
		if (eventName != null) {
			apiContext.addQueryParam(new Pair(PARAM_EVENT_NAME, eventName.name()));
		}
		ApiClient apiClient = getContext().getApiClient();
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	private ApiClient getApiClient() {
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath(cobrandConfiguration.getBasePath());
		apiClient.addHeader(ApiConstants.COBRAND_NAME, cobrandConfiguration.getName());
		apiClient.addHeader(ApiConstants.API_VERSION, cobrandConfiguration.getApiVersion());
		if (cobrandConfiguration.getSocketTimeout() != null) {
			apiClient.setConnectTimeout(cobrandConfiguration.getSocketTimeout());
		}
		if (cobrandConfiguration.getReadTimeout() != null) {
			apiClient.setReadTimeout(cobrandConfiguration.getReadTimeout());
		}
		if (cobrandConfiguration.getWriteTimeout() != null) {
			apiClient.setWriteTimeout(cobrandConfiguration.getWriteTimeout());
		}
		return apiClient;
	}
}
