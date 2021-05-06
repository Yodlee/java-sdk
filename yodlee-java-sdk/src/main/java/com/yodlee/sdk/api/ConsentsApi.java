/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.consent.request.CreateConsentRequest;
import com.yodlee.api.model.consent.request.UpdateConsentRequest;
import com.yodlee.api.model.consent.response.ConsentResponse;
import com.yodlee.api.model.consent.response.CreatedConsentResponse;
import com.yodlee.api.model.consent.response.UpdatedConsentResponse;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;
import com.yodlee.sdk.api.validators.ConsentsValidator;
import com.yodlee.sdk.client.ApiCallback;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.client.ApiContext;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.client.CallContext;
import com.yodlee.sdk.client.HttpMethod;
import com.yodlee.sdk.client.Pair;
import com.yodlee.sdk.context.Context;
import okhttp3.Call;

public class ConsentsApi extends AbstractApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsentsApi.class);
	
	private static final String PARAM_CONSENTS_ID = "consentId";
	private static final String PARAM_PROVIDERACCOUNTS_ID = "providerAccountId";
	
	public ConsentsApi(Context<?> context) {
		super(context);
	}
	
	/**
	 * Get Consent Details<br> 
	 * The get authorization URL for consent service provides the authorization URL for the renew consent flow, 
	 * within the consent dashboard.<br>
	 * Note:This service supports the localization feature and accepts locale as a header parameter.<br>
	 * 
	 * @param consentId (required)
	 * @return {@link ApiResponse}&lt;{@link UpdatedConsentResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<UpdatedConsentResponse> getAuthorizationURL(
			@Digits(integer = 11,
					fraction = 0,
					message = "{consents.param.consentId.invalid}") long consentId)
			throws ApiException {
		LOGGER.info("Consents getAuthorizationURL API execution started");
		ConsentsValidator.validateGetAuthorizationURL(this, ApiUtils.getMethodName(), consentId);
		CallContext callContext = buildGetAuthorizationURLContext(consentId);
		return callContext.getApiClient().execute(callContext.getCall(), UpdatedConsentResponse.class);
	}
	
	/**
	 * Get Consent Details<br> 
	 * The get authorization URL for consent service provides the authorization URL for the renew consent flow, 
	 * within the consent dashboard.<br>
	 * Note:This service supports the localization feature and accepts locale as a header parameter.<br>
	 * 
	 * @param consentId (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getAuthorizationURLAsync(
			@Digits(integer = 11,
					fraction = 0,
					message = "{consents.param.consentId.invalid}") long consentId,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Consents getAuthorizationURL API execution started");
		ConsentsValidator.validateGetAuthorizationURL(this, ApiUtils.getMethodName(), consentId);
		CallContext callContext = buildGetAuthorizationURLContext(consentId);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildGetAuthorizationURLContext(long consentId) throws ApiException {
		String endpoint = replacePathVariable(ApiEndpoint.GETCONSENTS_CONSENTID,
				PARAM_CONSENTS_ID, String.valueOf(consentId));
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(endpoint, HttpMethod.GET, null);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}


	/**
	 * Put Consent<br> 
	 * The update consent service is used to capture the user acceptance of the consent presented to him or her.<br>
	 * This service returns the authorization-redirect URL that should be used to display to the user, the bank's authentication interface.<br>
	 * Note:This service supports the localization feature and accepts locale as a header parameter.<br>
	 * 
	 * @param consentId (required)
	 * @param updateConsentRequest updateConsentRequest (required)
	 * @return {@link ApiResponse}&lt;{@link UpdatedConsentResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<UpdatedConsentResponse> captureConsent(
			@Digits(integer = 11,
					fraction = 0,
					message = "{consents.param.consentId.invalid}") long consentId,
			@NotNull(message = "{consents.updateConsentRequest.required}") UpdateConsentRequest updateConsentRequest)
			throws ApiException {
		LOGGER.info("Consents captureConsent API execution started");
		ConsentsValidator.validateCaptureConsent(this, ApiUtils.getMethodName(), consentId, updateConsentRequest);
		CallContext callContext = buildCaptureConsentContext(consentId, updateConsentRequest);
		return callContext.getApiClient().execute(callContext.getCall(), UpdatedConsentResponse.class);
	}
	
	/**
	 * Put Consent<br> 
	 * The update consent service is used to capture the user acceptance of the consent presented to him or her.<br>
	 * This service returns the authorization-redirect URL that should be used to display to the user, the bank's authentication interface.<br>
	 * Note:This service supports the localization feature and accepts locale as a header parameter.<br>
	 * 
	 * @param consentId (required)
	 * @param updateConsentRequest updateConsentRequest (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void captureConsentAsync(
			@Digits(integer = 11,
					fraction = 0,
					message = "{accounts.param.consentId.invalid}") long consentId,
			@NotNull(message = "{consents.updateConsentRequest.required}") UpdateConsentRequest updateConsentRequest,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Consents captureConsent API execution started");
		ConsentsValidator.validateCaptureConsent(this, ApiUtils.getMethodName(), consentId, updateConsentRequest);
		CallContext callContext = buildCaptureConsentContext(consentId, updateConsentRequest);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildCaptureConsentContext(long consentId, UpdateConsentRequest updateConsentRequest) throws ApiException {
		String endpoint = replacePathVariable(ApiEndpoint.PUTCONSENTS_CONSENTID,
				PARAM_CONSENTS_ID, String.valueOf(consentId));
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(endpoint, HttpMethod.PUT, updateConsentRequest);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	
	/**
	 * Post Consent<br> 
	 * The generate consent service is used to generate all the consent information and permissions associated to a provider.<br>
	 * The scope provided in the response is based on the providerId and the datasets provided in the input.<br>
     * If no dataset value is provided, the datasets that are configured for the customer will be considered.<br>
     * The configured dataset can be overridden by providing the dataset as an input.<br>
     * If no applicationName is provided in the input, the default applicationName will be considered.<br> 
	 * Note:This service supports the localization feature and accepts locale as a header parameter.<br>
	 * 
	 * @param createConsentRequest createConsentRequest (required)
	 * @return {@link ApiResponse}&lt;{@link CreatedConsentResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<CreatedConsentResponse> createConsent(
			@NotNull(message = "{consents.createConsentRequest.required}") CreateConsentRequest createConsentRequest)
			throws ApiException {
		LOGGER.info("Consents createConsent API execution started");
		ConsentsValidator.validateCreateConsent(this, ApiUtils.getMethodName(), createConsentRequest);
		CallContext callContext = buildCreateConsentContext(createConsentRequest);
		return callContext.getApiClient().execute(callContext.getCall(), CreatedConsentResponse.class);
	}
	
	/**
	 * Post Consent<br> 
	 * The update consent service is used to capture the user acceptance of the consent presented to him or her.<br>
	 * This service returns the authorization-redirect URL that should be used to display to the user, the bank's authentication interface.<br>
	 * Note:This service supports the localization feature and accepts locale as a header parameter.<br>
	 * 
	 * @param createConsentRequest createConsentRequest (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void createConsentAsync(
			@NotNull(message = "{consents.createConsentRequest.required}") CreateConsentRequest createConsentRequest,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Consents createConsent API execution started");
		ConsentsValidator.validateCreateConsent(this, ApiUtils.getMethodName(), createConsentRequest);
		CallContext callContext = buildCreateConsentContext(createConsentRequest);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildCreateConsentContext(CreateConsentRequest createConsentRequest) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext =
				new ApiContext(ApiEndpoint.POSTCONSENTS, HttpMethod.POST, createConsentRequest);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get Consent<br> 
	 * The get consent service is used to retrieve all the consents submitted to Yodlee.<br>
	 * The service can be used to build a manage consent interface or a consent dashboard to implement the renew and revoke consent flows.<br>
	 * Note:This service supports the localization feature and accepts locale as a header parameter.<br>
	 * 
	 * @param consentIds Comma separated consentIds (optional)
	 * @param providerAccountIds Comma separated providerAccountIds (optional)
	 * @return {@link ApiResponse}&lt;{@link ConsentResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<ConsentResponse> getConsent(
			@Size(min = 0, max = 100,
					message = "{consents.param.consentId.length.invalid}") Long[] consentIds,
			@Size(min = 0, max = 100,
        	message = "{consents.param.providerAccountId.length.invalid}") Long[] providerAccountIds)
			throws ApiException {
		LOGGER.info("Consents getAuthorizationURL API execution started");
		ConsentsValidator.validateGetConsent(this, ApiUtils.getMethodName(), consentIds, providerAccountIds);
		CallContext callContext = buildGetConsentContext(consentIds, providerAccountIds);
		return callContext.getApiClient().execute(callContext.getCall(), ConsentResponse.class);
	}
	
	/**
	 * Get Consent<br> 
	 * The get consent service is used to retrieve all the consents submitted to Yodlee.<br>
	 * The service can be used to build a manage consent interface or a consent dashboard to implement the renew and revoke consent flows.<br>
	 * Note:This service supports the localization feature and accepts locale as a header parameter.<br>
	 * 
	 * @param consentIds Comma separated consentIds (optional)
	 * @param providerAccountIds Comma separated providerAccountIds (optional)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getConsentAsync(
			@Size(min = 0, max = 100,
			message = "{consents.param.consentId.length.invalid}") Long[] consentIds,
			@Size(min = 0, max = 100,
        	message = "{consents.param.providerAccountId.length.invalid}") Long[] providerAccountIds,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Consents getAuthorizationURL API execution started");
		ConsentsValidator.validateGetConsent(this, ApiUtils.getMethodName(), consentIds, providerAccountIds);
		CallContext callContext = buildGetConsentContext(consentIds, providerAccountIds);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildGetConsentContext(Long[] consentIds, Long[] providerAccountIds) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(ApiEndpoint.GETCONSENTS, HttpMethod.GET, null);
		if (consentIds != null) {
			apiContext.addQueryParam(new Pair(PARAM_CONSENTS_ID, ApiUtils.convertArrayToString(consentIds)));
		}
		if (providerAccountIds != null) {
			apiContext.addQueryParam(new Pair(PARAM_PROVIDERACCOUNTS_ID, ApiUtils.convertArrayToString(providerAccountIds)));
		}
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}
}
