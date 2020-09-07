/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.auth.request.ApiKeyRequest;
import com.yodlee.api.model.auth.response.ApiKeyResponse;
import com.yodlee.api.model.clientcredential.ClientCredentialToken;
import com.yodlee.api.model.clientcredential.response.ClientCredentialTokenResponse;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;
import com.yodlee.sdk.api.validators.AuthValidator;
import com.yodlee.sdk.client.ApiCallback;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.client.ApiContext;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.client.CallContext;
import com.yodlee.sdk.client.HttpMethod;
import com.yodlee.sdk.configuration.cobrand.AbstractClientCredentialConfiguration;
import com.yodlee.sdk.configuration.cobrand.ClientCredentialAdminConfiguration;
import com.yodlee.sdk.configuration.user.ClientCredentialUserConfiguration;
import com.yodlee.sdk.context.Context;
import com.yodlee.sdk.context.ClientCredentialAdminContext;
import com.yodlee.sdk.context.ClientCredentialUserContext;
import okhttp3.Call;

public class AuthApi extends AbstractApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthApi.class);

	private static final String PARAM_API_KEY = "key";

	private final AbstractClientCredentialConfiguration clientCredentialConfiguration;

	public AuthApi() {
		this(null, null);
	}

	public AuthApi(AbstractClientCredentialConfiguration clientCredentialConfiguration) {
		this(null, clientCredentialConfiguration);
	}

	public AuthApi(Context<?> context) {
		this(context, null);
	}

	public AuthApi(Context<?> context, AbstractClientCredentialConfiguration clientCredentialConfiguration) {
		super(context);
		this.clientCredentialConfiguration = clientCredentialConfiguration;
	}

	/**
	 * This endpoint revokes the token passed in the Authorization header for API Key based authentication and
	 * credential(clientId and secret) based authentication. This service does not return a response. The HTTP response
	 * code is 204 (Success with no content)<br>
	 * 
	 * @return null
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> deleteToken() throws ApiException {
		LOGGER.info("Auth deleteToken API execution started");
		CallContext callContext = buildDeleteTokenContext();
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Delete Token This endpoint revokes the token passed in the Authorization header for API Key based
	 * authentication.<br>
	 * This service does not return a response. The HTTP response code is 204 (Success with no content).<br>
	 * 
	 * @param apiCallBack {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void deleteTokenAsync(ApiCallback<AbstractModelComponent> apiCallBack) throws ApiException {
		LOGGER.info("Auth deleteTokenAsync API execution started");
		CallContext callContext = buildDeleteTokenContext();
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallBack);
	}

	private CallContext buildDeleteTokenContext() throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(ApiEndpoint.AUTH_DELETE_TOKEN, HttpMethod.DELETE, null);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Generate API Key This endpoint is used to generate an API key. The RSA public key you provide should be in<br>
	 * 2048 bit PKCS#8 encoded format. A public key is a mandatory input for generating the API key.<br>
	 * The public key should be a unique key. The apiKeyId you get in the response is what you should<br>
	 * use to generate the JWT token.<br>
	 * You can use one of the following authorization methods to access<br>
	 * this API:<br>
	 * <ol>
	 * <li>cobsession</li>
	 * <li>JWT token</li>
	 * </ol>
	 * Alternatively, you can use base 64 encoded cobrandLogin and cobrandPassword in the Authorization header (Format:
	 * Authorization: Basic {@literal <}encoded value of cobrandLogin: cobrandPassword{@literal >})<br>
	 * <b>Note:</b><br>
	 * This service is not available in developer sandbox environment and will be made available for testing in your
	 * dedicated environment. The content type has to be passed as application/json for the body parameter.
	 * 
	 * @param apiKeyRequest apiKeyRequest (required)
	 * @return {@link ApiResponse}&lt;{@link ApiKeyResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<ApiKeyResponse> generateApiKey(
			@NotNull(message = "{auth.apiKeyRequest.required}") ApiKeyRequest apiKeyRequest) throws ApiException {
		LOGGER.info("Auth generateApiKey API execution started");
		AuthValidator.validateGenerateApiKey(this, ApiUtils.getMethodName(), apiKeyRequest);
		CallContext callContext = buildGenerateApiKeyContext(apiKeyRequest);
		return callContext.getApiClient().execute(callContext.getCall(), ApiKeyResponse.class);
	}

	/**
	 * Generate API Key This endpoint is used to generate an API key. The RSA public key you provide should be in<br>
	 * 2048 bit PKCS#8 encoded format. A public key is a mandatory input for generating the API key.<br>
	 * The public key should be a unique key. The apiKeyId you get in the response is what you should<br>
	 * use to generate the JWT token.<br>
	 * You can use one of the following authorization methods to access<br>
	 * this API:<br>
	 * <ol>
	 * <li>cobsession</li>
	 * <li>JWT token</li>
	 * </ol>
	 * Alternatively, you can use base 64 encoded cobrandLogin and cobrandPassword in the Authorization header (Format:
	 * Authorization: Basic {@literal <}encoded value of cobrandLogin: cobrandPassword{@literal >})<br>
	 * <b>Note:</b><br>
	 * This service is not available in developer sandbox environment and will be made available for testing in your
	 * dedicated environment. The content type has to be passed as application/json for the body parameter.
	 * 
	 * @param apiKeyRequest apiKeyRequest (required)
	 * @param apiCallback {@link ApiCallback}&lt;{@link ApiKeyResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void generateApiKeyAsync(@NotNull(message = "{auth.apiKeyRequest.required}") ApiKeyRequest apiKeyRequest,
			ApiCallback<ApiKeyResponse> apiCallback) throws ApiException {
		LOGGER.info("AuthAsync generateApiKeyAsync API execution started");
		AuthValidator.validateGenerateApiKey(this, ApiUtils.getMethodName(), apiKeyRequest);
		CallContext callContext = buildGenerateApiKeyContext(apiKeyRequest);
		callContext.getApiClient().executeAsync(callContext.getCall(), ApiKeyResponse.class, apiCallback);
	}

	private CallContext buildGenerateApiKeyContext(ApiKeyRequest apiKeyRequest) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(ApiEndpoint.AUTH_APIKEY, HttpMethod.POST, apiKeyRequest);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get API Keys This endpoint provides the list of API keys that exist for a customer.<br>
	 * You can use one of the following authorization methods to access this API:<br>
	 * <ol>
	 * <li>cobsession</li>
	 * <li>JWT token</li>
	 * </ol>
	 * <b>Notes:</b><br>
	 * This service is not available in developer sandbox environment and will be made available<br>
	 * for testing in your dedicated environment.
	 * 
	 * @return {@link ApiResponse}&lt;{@link ApiKeyResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<ApiKeyResponse> getApiKeys() throws ApiException {
		LOGGER.info("Auth getApiKeys API execution started");
		AuthValidator.validateContext(this);
		CallContext callContext = buildGetApiKeysContext();
		return callContext.getApiClient().execute(callContext.getCall(), ApiKeyResponse.class);
	}

	/**
	 * Get API Keys This endpoint provides the list of API keys that exist for a customer.<br>
	 * You can use one of the following authorization methods to access this API:<br>
	 * <ol>
	 * <li>cobsession</li>
	 * <li>JWT token</li>
	 * </ol>
	 * <b>Notes:</b><br>
	 * This service is not available in developer sandbox environment and will be made available<br>
	 * for testing in your dedicated environment.
	 * 
	 * @param apiCallback {@link ApiCallback}&lt;{@link ApiKeyResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getApiKeysAsync(ApiCallback<ApiKeyResponse> apiCallback) throws ApiException {
		LOGGER.info("Auth getApiKeysAsync API execution started");
		AuthValidator.validateContext(this);
		CallContext callContext = buildGetApiKeysContext();
		callContext.getApiClient().executeAsync(callContext.getCall(), ApiKeyResponse.class, apiCallback);
	}

	private CallContext buildGetApiKeysContext() throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(ApiEndpoint.AUTH_APIKEY, HttpMethod.GET, null);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Delete API Key This endpoint allows an existing API key to be deleted.<br>
	 * You can use one of the following authorization methods to access this API:<br>
	 * <ol>
	 * <li>cobsession</li>
	 * <li>JWT token</li>
	 * </ol>
	 * <b>Notes:</b><br>
	 * This service is not available in developer sandbox environment and will be made available<br>
	 * for testing in your dedicated environment.
	 * 
	 * @param key key (required)
	 * @return null
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent>
			deleteApiKey(@NotEmpty(message = "{auth.param.apiKey.required}") String key) throws ApiException {
		LOGGER.info("Auth deleteApiKey API execution started");
		AuthValidator.validateDeleteApiKey(this, ApiUtils.getMethodName(), key);
		CallContext callContext = buildDeleteApiKeyContext(key);
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Delete API Key This endpoint allows an existing API key to be deleted.<br>
	 * You can use one of the following authorization methods to access this API:<br>
	 * <ol>
	 * <li>cobsession</li>
	 * <li>JWT token</li>
	 * </ol>
	 * <b>Notes:</b><br>
	 * This service is not available in developer sandbox environment and will be made available<br>
	 * for testing in your dedicated environment.
	 * 
	 * @param key key (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void deleteApiKeyAsync(@NotEmpty(message = "{auth.param.apiKey.required}") String key,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Auth deleteApiKeyAsync API execution started");
		AuthValidator.validateDeleteApiKey(this, ApiUtils.getMethodName(), key);
		CallContext callContext = buildDeleteApiKeyContext(key);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildDeleteApiKeyContext(@NotEmpty(message = "{auth.param.apiKey.required}") String key)
			throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		String endpoint = replacePathVariable(ApiEndpoint.AUTH_DELETE_APIKEY, PARAM_API_KEY, key);
		ApiContext apiContext = new ApiContext(endpoint, HttpMethod.DELETE, null);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * This service is used to generate access token to access YSL 1.1 api's, two type of access token can be generated
	 * using this service. <br>
	 * <br>
	 * <b>Admin access token:</b> using this token api's which need admin level privilege can be access, like POST
	 * /user/register etc. This token is generated when admin user name is passed in loginName with valid
	 * credentials(clientId and secret). You can find your credentials by navigating to My Accounts -> API Dashboard ->
	 * Credentials. <br>
	 * <br>
	 * <b>User access token:</b> Using this token api's which need user level privileges can be accessed, like GET
	 * /transactions etc. This service also performs an implicit user registration, i.e. for valid clientId and secret
	 * if a login name is passed which is not an existing user, yodlee system will recognize the request to register the
	 * user and provide the User access token, user details can later be updated by using PUT user/register service.
	 * <br>
	 * <br>
	 * <b>Note:</b> If you are an existing customer and want to use this authentication service, contact Yodlee customer
	 * care to get your credentials
	 * 
	 * @return {@link ApiResponse}&lt;{@link ClientCredentialTokenResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<ClientCredentialTokenResponse> generateAccessToken() throws ApiException {
		ApiContext apiContext = generateAccessTokenApiContext();
		ApiClient apiClient = getApiClient();
		Call call = apiClient.buildCall(apiContext, null);
		ApiResponse<ClientCredentialTokenResponse> clientCredentialTokenResponse =
				apiClient.execute(call, ClientCredentialTokenResponse.class);
		if (clientCredentialTokenResponse != null && clientCredentialTokenResponse.getData() != null) {
			ClientCredentialToken token = clientCredentialTokenResponse.getData().getToken();
			setContext(createContext(token));
		}
		return clientCredentialTokenResponse;
	}

	private Context<?> createContext(ClientCredentialToken token) {
		if (token != null) {
			if (clientCredentialConfiguration instanceof ClientCredentialAdminConfiguration) {
				return new ClientCredentialAdminContext(token.getAccessToken(), token.getIssuedAt(),
						token.getExpiresIn(), (ClientCredentialAdminConfiguration) clientCredentialConfiguration);
			} else if (clientCredentialConfiguration instanceof ClientCredentialUserConfiguration) {
				return new ClientCredentialUserContext(token.getAccessToken(), token.getIssuedAt(),
						token.getExpiresIn(), (ClientCredentialUserConfiguration) clientCredentialConfiguration);
			}
		}
		return null;
	}

	private ApiContext generateAccessTokenApiContext() {
		// Adding headers
		ApiContext apiContext = new ApiContext(ApiEndpoint.AUTH, HttpMethod.POST, null);
		apiContext.clearHeaderParams();
		apiContext.addHeaderParam(ApiConstants.API_VERSION, clientCredentialConfiguration.getApiVersion());
		apiContext.addHeaderParam(ApiConstants.CONTENT_TYPE, ApiConstants.X_WWW_FORM_URL_ENCODED);
		apiContext.addHeaderParam(ApiConstants.LOGIN_NAME, clientCredentialConfiguration.getLoginName());
		// Add form url encoded request body
		apiContext.addFormParam(ApiConstants.CLIENT_ID, clientCredentialConfiguration.getClientId());
		apiContext.addFormParam(ApiConstants.SECRET, clientCredentialConfiguration.getSecret());
		return apiContext;
	}

	private ApiClient getApiClient() {
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath(clientCredentialConfiguration.getBasePath());
		apiClient.addHeader(ApiConstants.API_VERSION, clientCredentialConfiguration.getApiVersion());
		if (clientCredentialConfiguration.getLocale() != null) {
			apiClient.addHeader(ApiConstants.LOCALE, clientCredentialConfiguration.getLocale());
		}
		if (clientCredentialConfiguration.getSocketTimeout() != null) {
			apiClient.setConnectTimeout(clientCredentialConfiguration.getSocketTimeout());
		}
		if (clientCredentialConfiguration.getReadTimeout() != null) {
			apiClient.setReadTimeout(clientCredentialConfiguration.getReadTimeout());
		}
		if (clientCredentialConfiguration.getWriteTimeout() != null) {
			apiClient.setWriteTimeout(clientCredentialConfiguration.getWriteTimeout());
		}
		return apiClient;
	}
}
