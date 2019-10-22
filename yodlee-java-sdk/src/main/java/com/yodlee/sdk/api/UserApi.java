/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.api;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.squareup.okhttp.Call;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.user.request.UpdateUserRequest;
import com.yodlee.api.model.user.request.UserRequest;
import com.yodlee.api.model.user.response.UserAccessTokensResponse;
import com.yodlee.api.model.user.response.UserDetailResponse;
import com.yodlee.api.model.user.response.UserResponse;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;
import com.yodlee.sdk.api.validators.UserValidator;
import com.yodlee.sdk.client.ApiCallback;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.client.ApiContext;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.client.CallContext;
import com.yodlee.sdk.client.HttpMethod;
import com.yodlee.sdk.client.Pair;
import com.yodlee.sdk.configuration.user.UserConfiguration;
import com.yodlee.sdk.context.CobrandContext;
import com.yodlee.sdk.context.Context;
import com.yodlee.sdk.context.UserContext;

public class UserApi extends AbstractApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserApi.class);

	private static final String PARAM_APP_IDS = "appIds";

	private static final String PARAM_SOURCE = "source";

	private static final String PARAM_ISSUER = "issuer";

	private static final String PARAM_SAML_RESPONSE = "samlResponse";

	private final UserConfiguration configuration;

	public UserApi(Context<?> context, UserConfiguration configuration) {
		super(context);
		this.configuration = configuration;
	}

	public UserApi(Context<?> context) {
		this(context, null);
	}

	/**
	 * Saml Login The SAML login service is used to authenticate system users with a SAML response.<br>
	 * A new user will be created with the input provided if that user isn't already in the system.<br>
	 * For existing users, the system will make updates based on changes or new information.<br>
	 * When authentication is successful, a user session token is returned.<br>
	 * <b>Note:</b> The content type has to be passed as application/x-www-form-urlencoded. <br>
	 * issuer, source and samlResponse should be passed as body parameters.<br>
	 * 
	 * @param issuer issuer (required)
	 * @param samlResponse samlResponse (required)
	 * @param source source (required)
	 * @return {@link ApiResponse}&lt;{@link UserResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<UserResponse> samlLogin(//
			@NotEmpty(message = "{user.param.samlResponse.required}") String samlResponse,//
			@NotEmpty(message = "{user.param.issuer.required}") String issuer,//
			@NotEmpty(message = "{user.param.source.required}") String source) throws ApiException {
		LOGGER.info("User SamlLogin API execution started");
		UserValidator.validateSamlLogin(this, ApiUtils.getMethodName(), samlResponse, issuer, source);
		CallContext callContext = buildSamlLoginContext(samlResponse, issuer, source);
		ApiResponse<UserResponse> userResponse =
				callContext.getApiClient().execute(callContext.getCall(), UserResponse.class);
		UserContext userContext = new UserContext(((CobrandContext) getContext()).getCobSession(),
				userResponse.getData().getUser().getSession().getUserSession(), configuration);
		setContext(userContext);
		LOGGER.info("User SamlLogin API execution ended after setting userContext");
		return userResponse;
	}

	/**
	 * Saml Login The SAML login service is used to authenticate system users with a SAML response.<br>
	 * A new user will be created with the input provided if that user isn't already in the system.<br>
	 * For existing users, the system will make updates based on changes or new information.<br>
	 * When authentication is successful, a user session token is returned.<br>
	 * <b>Note:</b> The content type has to be passed as application/x-www-form-urlencoded. <br>
	 * issuer, source and samlResponse should be passed as body parameters.<br>
	 * 
	 * @param issuer issuer (required)
	 * @param samlResponse samlResponse (required)
	 * @param source source (required)
	 * @param apiCallback {@link ApiCallback}&lt;{@link UserResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void samlLoginAsync(//
			@NotEmpty(message = "{user.param.samlResponse.required}") String samlResponse,//
			@NotEmpty(message = "{user.param.issuer.required}") String issuer,//
			@NotEmpty(message = "{user.param.source.required}") String source,//
			ApiCallback<UserResponse> apiCallback) throws ApiException {
		LOGGER.info("User SamlLoginAsync API execution started");
		UserValidator.validateSamlLogin(this, ApiUtils.getMethodName(), samlResponse, issuer, source);
		CallContext callContext = buildSamlLoginContext(samlResponse, issuer, source);
		callContext.getApiClient().executeAsync(callContext.getCall(), UserResponse.class, apiCallback);
	}

	private CallContext buildSamlLoginContext(String samlResponse,//
			String issuer,//
			String source) throws ApiException {
		ApiContext apiContext = new ApiContext(ApiEndpoint.USER_SAML_LOGIN, HttpMethod.POST, null);
		apiContext.addQueryParam(new Pair(PARAM_SAML_RESPONSE, samlResponse));
		apiContext.addQueryParam(new Pair(PARAM_ISSUER, issuer));
		apiContext.addQueryParam(new Pair(PARAM_SOURCE, source));
		ApiClient apiClient = getContext().getApiClient();
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Register User The register user service is used to register a user in Yodlee.<br>
	 * The loginName cannot include spaces and must be between 3 and 150 characters.<br>
	 * locale passed must be one of the supported locales for the customer. <br>
	 * Currency provided in the input will be respected in the derived services and the amount fields in the response
	 * will be provided in the preferred currency.<br>
	 * userParam is accepted as a body parameter. <br>
	 * <b>Note:</b> user.password is no longer supported.<br>
	 * The content type has to be passed as application/json for the body parameter.<br>
	 * 
	 * @param userRequest userRequest (required)
	 * @return {@link ApiResponse}&lt;{@link UserResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<UserResponse> registerUser(
			@NotNull(message = "{user.UserRequest.required}") UserRequest userRequest) throws ApiException {
		LOGGER.info("User registerUser API execution started");
		UserValidator.validateRegisterUser(this, ApiUtils.getMethodName(), userRequest);
		CallContext callContext = buildRegisterUserContext(userRequest);
		return callContext.getApiClient().execute(callContext.getCall(), UserResponse.class);
	}

	/**
	 * Register User The register user service is used to register a user in Yodlee.<br>
	 * The loginName cannot include spaces and must be between 3 and 150 characters.<br>
	 * locale passed must be one of the supported locales for the customer. <br>
	 * Currency provided in the input will be respected in the derived services and the amount fields in the response
	 * will be provided in the preferred currency.<br>
	 * userParam is accepted as a body parameter. <br>
	 * <b>Note:</b> user.password is no longer supported.<br>
	 * The content type has to be passed as application/json for the body parameter.<br>
	 * 
	 * @param userRequest userRequest (required)
	 * @param apiCallback ApiCallback&lt;{@link UserResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void registerUserAsync(@NotNull(message = "{user.UserRequest.required}") UserRequest userRequest,
			ApiCallback<UserResponse> apiCallback) throws ApiException {
		LOGGER.info("User registerUserAsync API execution started");
		UserValidator.validateRegisterUser(this, ApiUtils.getMethodName(), userRequest);
		CallContext callContext = buildRegisterUserContext(userRequest);
		callContext.getApiClient().executeAsync(callContext.getCall(), UserResponse.class, apiCallback);
	}

	private CallContext buildRegisterUserContext(UserRequest userRequest) throws ApiException {
		ApiContext apiContext = new ApiContext(ApiEndpoint.USER_REGISTER, HttpMethod.POST, userRequest);
		ApiClient apiClient = getContext().getApiClient();
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get User Details The get user details service is used to get the user profile information and the application
	 * <br>
	 * preferences set at the time of user registration.<br>
	 * 
	 * @return {@link ApiResponse}&lt;{@link UserDetailResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<UserDetailResponse> getUser() throws ApiException {
		LOGGER.info("User getUser API execution started");
		UserValidator.validateApiContext(this);
		CallContext callContext = buildGetUserContext();
		return callContext.getApiClient().execute(callContext.getCall(), UserDetailResponse.class);
	}

	/**
	 * Get User Details The get user details service is used to get the user profile information and the application
	 * <br>
	 * preferences set at the time of user registration.<br>
	 * 
	 * @param apiCallback {@link ApiCallback}&lt;{@link UserDetailResponse}&gt; (required)
	 * 
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getUserAsync(ApiCallback<UserDetailResponse> apiCallback) throws ApiException {
		LOGGER.info("User getUserAsync API execution started");
		UserValidator.validateApiContext(this);
		CallContext callContext = buildGetUserContext();
		callContext.getApiClient().executeAsync(callContext.getCall(), UserDetailResponse.class, apiCallback);
	}

	private CallContext buildGetUserContext() throws ApiException {
		ApiContext apiContext = new ApiContext(ApiEndpoint.USER_DETAILS, HttpMethod.GET, null);
		ApiClient apiClient = getContext().getApiClient();
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * User Logout <b>Deprecated</b>: This endpoint is deprecated for API Key-based authentication. The user logout
	 * service allows the user to log out of the application.<br>
	 * The service does not return a response body. The HTTP response code is 204 (Success with no content).<br>
	 * 
	 * @return null
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> userLogout() throws ApiException {
		LOGGER.info("User userLogout API execution started");
		UserValidator.validateApiContext(this);
		CallContext callContext = buildUserLogoutContext();
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * User Logout <b>Deprecated</b>: This endpoint is deprecated for API Key-based authentication. The user logout
	 * service allows the user to log out of the application.<br>
	 * The service does not return a response body. The HTTP response code is 204 (Success with no content).<br>
	 * 
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void userLogoutAsync(ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("User userLogoutAsync API execution started");
		UserValidator.validateApiContext(this);
		CallContext callContext = buildUserLogoutContext();
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildUserLogoutContext() throws ApiException {
		ApiContext apiContext = new ApiContext(ApiEndpoint.USER_LOGOUT, HttpMethod.POST, null);
		ApiClient apiClient = getContext().getApiClient();
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Update User Details The update user details service is used to update user details like name, address, currency
	 * preference, etc.<br>
	 * Currency provided in the input will be respected in the
	 * <a href="https://developer.yodlee.com/apidocs/index.php#!/derived">derived</a> services and the amount fields in
	 * the response will be provided in the preferred currency.<br>
	 * The HTTP response code is 204 (Success without content). <br>
	 * 
	 * @param userRequest userRequest (required)
	 * @return null
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> updateUser(
			@NotNull(message = "{user.UpdateUserRequest.required}") UpdateUserRequest userRequest) throws ApiException {
		LOGGER.info("User updateUser API execution started");
		UserValidator.validateUpdateUser(this, ApiUtils.getMethodName(), userRequest);
		CallContext callContext = buildUpdateUserContext(userRequest);
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Update User Details The update user details service is used to update user details like name, address, currency
	 * preference, etc.<br>
	 * Currency provided in the input will be respected in the
	 * <a href="https://developer.yodlee.com/apidocs/index.php#!/derived">derived</a> services and the amount fields in
	 * the response will be provided in the preferred currency.<br>
	 * The HTTP response code is 204 (Success without content). <br>
	 * 
	 * @param userRequest userRequest (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void updateUserAsync(@NotNull(message = "{user.UpdateUserRequest.required}") UpdateUserRequest userRequest,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("User updateUserAsync API execution started");
		UserValidator.validateUpdateUser(this, ApiUtils.getMethodName(), userRequest);
		CallContext callContext = buildUpdateUserContext(userRequest);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildUpdateUserContext(UpdateUserRequest userRequest) throws ApiException {
		ApiContext apiContext = new ApiContext(ApiEndpoint.USER_DETAILS, HttpMethod.PUT, userRequest);
		ApiClient apiClient = getContext().getApiClient();
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get Access Tokens The Get Access Tokens service is used to retrieve the access tokens for the application id(s)
	 * provided.<br>
	 * URL in the response can be used to launch the application for which token is requested.<br>
	 * <b>Note:</b> This endpoint is deprecated for customers using the API Key-based authentication <br>
	 * and is applicable only to customers who use the SAML-based authentication.<br>
	 * 
	 * @param appIds appIds (required)
	 * @return {@link ApiResponse}&lt;{@link UserAccessTokensResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<UserAccessTokensResponse>
			getAccessTokens(@NotEmpty(message = "{user.param.finappId.required}") Long[] appIds) throws ApiException {
		LOGGER.info("User getAccessToken API execution started");
		UserValidator.validateGetAccessTokens(this, ApiUtils.getMethodName(), appIds);
		CallContext callContext = buildGetAccessTokensContext(appIds);
		return callContext.getApiClient().execute(callContext.getCall(), UserAccessTokensResponse.class);
	}

	/**
	 * Get Access Tokens The Get Access Tokens service is used to retrieve the access tokens for the application id(s)
	 * provided.<br>
	 * URL in the response can be used to launch the application for which token is requested.<br>
	 * <b>Note:</b> This endpoint is deprecated for customers using the API Key-based authentication <br>
	 * and is applicable only to customers who use the SAML-based authentication.<br>
	 * 
	 * @param appIds appIds (required)
	 * @param apiCallback {@link ApiCallback}&lt;{@link UserAccessTokensResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getAccessTokensAsync(@NotEmpty(message = "{user.param.finappId.required}") Long[] appIds,
			ApiCallback<UserAccessTokensResponse> apiCallback) throws ApiException {
		LOGGER.info("User getAccessTokensAsync API execution started");
		UserValidator.validateGetAccessTokens(this, ApiUtils.getMethodName(), appIds);
		CallContext callContext = buildGetAccessTokensContext(appIds);
		callContext.getApiClient().executeAsync(callContext.getCall(), UserAccessTokensResponse.class, apiCallback);
	}

	private CallContext buildGetAccessTokensContext(Long[] appIds) throws ApiException {
		ApiContext apiContext = new ApiContext(ApiEndpoint.USER_ACCESS_TOKEN, HttpMethod.GET, null);
		ApiClient apiClient = getContext().getApiClient();
		apiContext.addQueryParam(new Pair(PARAM_APP_IDS, ApiUtils.convertArrayToString(appIds)));
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Delete User The delete user service is used to delete or unregister a user from Yodlee. <br>
	 * Once deleted, the information related to the users cannot be retrieved. <br>
	 * The HTTP response code is 204 (Success without content)<br>
	 * 
	 * @return null
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> unregister() throws ApiException {
		LOGGER.info("User unregister API execution started");
		UserValidator.validateApiContext(this);
		CallContext callContext = buildUnregisterContext();
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Delete User The delete user service is used to delete or unregister a user from Yodlee. <br>
	 * Once deleted, the information related to the users cannot be retrieved. <br>
	 * The HTTP response code is 204 (Success without content)<br>
	 * 
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void unregisterAsync(ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("User unregisterAsync API execution started");
		UserValidator.validateApiContext(this);
		CallContext callContext = buildUnregisterContext();
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildUnregisterContext() throws ApiException {
		ApiContext apiContext = new ApiContext(ApiEndpoint.USER_UNREGISTER, HttpMethod.DELETE, null);
		ApiClient apiClient = getContext().getApiClient();
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}
}
