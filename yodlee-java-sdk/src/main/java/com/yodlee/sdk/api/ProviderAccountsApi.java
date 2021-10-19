/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api;

import java.util.Arrays;
import java.util.Map;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Field;
import com.yodlee.api.model.provideraccounts.request.AbstractProviderAccountRequest;
import com.yodlee.api.model.provideraccounts.request.ProviderAccountPreferencesRequest;
import com.yodlee.api.model.provideraccounts.request.ProviderAccountRequest;
import com.yodlee.api.model.provideraccounts.request.RefreshProviderAccountRequest;
import com.yodlee.api.model.provideraccounts.response.AddedProviderAccountResponse;
import com.yodlee.api.model.provideraccounts.response.ProviderAccountDetailResponse;
import com.yodlee.api.model.provideraccounts.response.ProviderAccountResponse;
import com.yodlee.api.model.provideraccounts.response.ProviderAccountUserProfileResponse;
import com.yodlee.api.model.provideraccounts.response.UpdatedProviderAccountResponse;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;
import com.yodlee.sdk.api.validators.ProviderAccountsValidator;
import com.yodlee.sdk.api.validators.ProviderAccountsValidator.ProviderAccountDetailsInclude;
import com.yodlee.sdk.api.validators.ProviderAccountsValidator.ProviderAccountInclude;
import com.yodlee.sdk.client.ApiCallback;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.client.ApiContext;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.client.CallContext;
import com.yodlee.sdk.client.HttpMethod;
import com.yodlee.sdk.client.Pair;
import com.yodlee.sdk.context.Context;
import okhttp3.Call;

public class ProviderAccountsApi extends AbstractApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProviderAccountsApi.class);

	private static final String PARAM_PROVIDER_IDS = "providerIds";

	private static final String PARAM_REQUEST_ID = "requestId";

	private static final String PARAM_INCLUDE = "include";

	private static final String PARAM_PROVIDER_ACCOUNT_IDS = "providerAccountIds";

	private static final String PROVIDER_ID = "providerId";

	private static final String PROVIDER_ACCOUNT_ID = "providerAccountId";

	public ProviderAccountsApi(Context<?> context) {
		super(context);
	}

	/**
	 * <b>Refresh All ProviderAccounts</b><br>
	 * <ul>
	 * <li>This API will trigger a refresh for all the eligible provider accounts(both OB and credential-based
	 * accounts).</li>
	 * <li>This API will not refresh closed, inactive, or UAR accounts, or accounts with refreshes in-progress or
	 * recently refreshed non-OB accounts.</li>
	 * <li>Do not call this API often. Our recommendation is to call this only at the time the user logs in to your
	 * application, because it can hamper other API calls performance.</li>
	 * <li>The response only contains information for accounts that were refreshed. If no accounts are eligible for
	 * refresh, no response is returned.</li>
	 * </ul>
	 * 
	 * @return {@link ApiResponse}&lt;{@link UpdatedProviderAccountResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<UpdatedProviderAccountResponse> refreshAllProviderAccounts() throws ApiException {
		ProviderAccountsValidator.validateRefreshAllProviderAccounts(this, ApiUtils.getMethodName());
		return editCredentialsOrRefreshProviderAccount(null, null);
	}

	/**
	 * <b>Refresh All ProviderAccounts</b><br>
	 * <ul>
	 * <li>This API will trigger a refresh for all the eligible provider accounts(both OB and credential-based
	 * accounts).</li>
	 * <li>This API will not refresh closed, inactive, or UAR accounts, or accounts with refreshes in-progress or
	 * recently refreshed non-OB accounts.</li>
	 * <li>Do not call this API often. Our recommendation is to call this only at the time the user logs in to your
	 * application, because it can hamper other API calls performance.</li>
	 * <li>The response only contains information for accounts that were refreshed. If no accounts are eligible for
	 * refresh, no response is returned.</li>
	 * </ul>
	 * 
	 * @param apiCallback {@link ApiCallback}&lt;{@link UpdatedProviderAccountResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void refreshAllProviderAccountsAsync(ApiCallback<UpdatedProviderAccountResponse> apiCallback)
			throws ApiException {
		ProviderAccountsValidator.validateRefreshAllProviderAccounts(this, ApiUtils.getMethodName());
		editCredentialsOrRefreshProviderAccountAsync(null, null, apiCallback);
	}

	/**
	 * <b>Refresh ProviderAccount</b><br>
	 * This API is used to retrieve the latest information for accounts that belong to one providerAccount from the
	 * provider site. You must allow at least 15 min between requests.<br>
	 * <b> Notes: </b> Check the status of the providerAccount before invoking this API. Do not call this API to trigger
	 * any action on a providerAccount when an action is already in progress for the providerAccount.<br>
	 * Data to be retrieved from the provider site can be overridden using datasetName or dataset. If you do pass
	 * datasetName, all the datasets that are implicitly configured for the dataset will be retrieved.<br>
	 * A dataset may depend on another dataset for retrieval, so the response will include the requested and dependent
	 * datasets.<br>
	 * Check all the dataset additional statuses returned in the response because the provider account status is drawn
	 * from the dataset additional statuses.<br>
	 * If you have subscribed to the REFRESH event notification and invoked this API, relevant notifications will be
	 * sent to the callback URL.<br>
	 * Updating preferences using this API will trigger refreshes
	 * 
	 * @param providerAccountId - ProviderAccountId
	 * @param refreshProviderAccountRequest - Refresh Information
	 * @return {@link ApiResponse}&lt;{@link UpdatedProviderAccountResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<UpdatedProviderAccountResponse> refreshProviderAccount(
			@Digits(message = "{providerAccounts.param.providerAccountId.invalid}",
					fraction = 0, //
					integer = 11) long providerAccountId,
			RefreshProviderAccountRequest refreshProviderAccountRequest) throws ApiException {
		ProviderAccountsValidator.validateRefreshProviderAccount(this, ApiUtils.getMethodName(), providerAccountId,
				refreshProviderAccountRequest);
		return editCredentialsOrRefreshProviderAccount(String.valueOf(providerAccountId),
				refreshProviderAccountRequest);
	}

	/**
	 * <b>Refresh ProviderAccount</b><br>
	 * This API is used to retrieve the latest information for accounts that belong to one providerAccount from the
	 * provider site. You must allow at least 15 min between requests.<br>
	 * <b> Notes: </b> Check the status of the providerAccount before invoking this API. Do not call this API to trigger
	 * any action on a providerAccount when an action is already in progress for the providerAccount.<br>
	 * Data to be retrieved from the provider site can be overridden using datasetName or dataset. If you do pass
	 * datasetName, all the datasets that are implicitly configured for the dataset will be retrieved.<br>
	 * A dataset may depend on another dataset for retrieval, so the response will include the requested and dependent
	 * datasets.<br>
	 * Check all the dataset additional statuses returned in the response because the provider account status is drawn
	 * from the dataset additional statuses.<br>
	 * If you have subscribed to the REFRESH event notification and invoked this API, relevant notifications will be
	 * sent to the callback URL.<br>
	 * Updating preferences using this API will trigger refreshes
	 * 
	 * @param providerAccountId - ProviderAccountId
	 * @param refreshProviderAccountRequest - Refresh Information
	 * @param apiCallback {@link ApiCallback}&lt;{@link UpdatedProviderAccountResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void refreshProviderAccountAsync(
			@Digits(message = "{providerAccounts.param.providerAccountId.invalid}",
					fraction = 0, //
					integer = 11) long providerAccountId,
			RefreshProviderAccountRequest refreshProviderAccountRequest,
			ApiCallback<UpdatedProviderAccountResponse> apiCallback) throws ApiException {
		ProviderAccountsValidator.validateRefreshProviderAccount(this, ApiUtils.getMethodName(), providerAccountId,
				refreshProviderAccountRequest);
		editCredentialsOrRefreshProviderAccountAsync(String.valueOf(providerAccountId), refreshProviderAccountRequest,
				apiCallback);
	}

	/**
	 * <b> Edit Credentials - Notes: </b><br>
	 * <ul>
	 * <li>This API is used to update account credentials when the user has changed the authentication information at
	 * the provider site.</li>
	 * <li>For credentials to be updated in the Yodlee system, field array should be provided as an input</li>
	 * <li>Field array can be obtained from the GET providerAccounts/{providerAccountId}?include=credentials API
	 * response. The credentials provided by the user should be embedded in field array object before you pass to this
	 * API.</li>
	 * <li><b> Notes:</b></li>
	 * <li>Check the status of the providerAccount before invoking this API. Do not call this API to trigger any action
	 * on a providerAccount, when an action is already in progress for the providerAccount.</li>
	 * <li>Data to be retrieved from the provider site can be overridden using datasetName or dataset. If you pass
	 * datasetName, all the datasets that are implicitly configured for the dataset will be retrieved</li>
	 * <li>Encrypt the credentials and answers to the MFA questions using the public key.</li>
	 * <li>If you have subscribed to the REFRESH event notification and invoked this API, relevant notifications will be
	 * sent to the callback URL.</li>
	 * <li>If you had not subscribed for notifications, the get provider account details service has to be polled
	 * continuously to know the process status, till the account addition status is FAILED or PARTIAL_SUCCESS or
	 * SUCCESS</li>
	 * </ul>
	 * 
	 * @param providerAccountId - ProviderAccountId
	 * @param providerAccountRequest - Credentials Information
	 * @return {@link ApiResponse}&lt;{@link UpdatedProviderAccountResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<UpdatedProviderAccountResponse> editProviderAccountCredentials(
			@Min(value = 1L, message = "{providerAccounts.param.providerAccountId.invalid}") //
			@Digits(message = "{providerAccounts.param.providerAccountId.invalid}",
					fraction = 0, //
					integer = 11) long providerAccountId, //
			@NotNull(message = "{providerAccounts.param.providerAccountRequest.required}") ProviderAccountRequest providerAccountRequest)
			throws ApiException {
		ProviderAccountsValidator.validateUpdateProviderAccount(this, ApiUtils.getMethodName(), providerAccountId,
				providerAccountRequest);
		return editCredentialsOrRefreshProviderAccount(String.valueOf(providerAccountId), providerAccountRequest);
	}

	/**
	 * <b> Edit Credentials - Notes: </b><br>
	 * <ul>
	 * <li>This API is used to update account credentials when the user has changed the authentication information at
	 * the provider site.</li>
	 * <li>For credentials to be updated in the Yodlee system, field array should be provided as an input</li>
	 * <li>Field array can be obtained from the GET providerAccounts/{providerAccountId}?include=credentials API
	 * response. The credentials provided by the user should be embedded in field array object before you pass to this
	 * API.</li>
	 * <li><b> Notes:</b></li>
	 * <li>Check the status of the providerAccount before invoking this API. Do not call this API to trigger any action
	 * on a providerAccount, when an action is already in progress for the providerAccount.</li>
	 * <li>Data to be retrieved from the provider site can be overridden using datasetName or dataset. If you pass
	 * datasetName, all the datasets that are implicitly configured for the dataset will be retrieved</li>
	 * <li>Encrypt the credentials and answers to the MFA questions using the public key.</li>
	 * <li>If you have subscribed to the REFRESH event notification and invoked this API, relevant notifications will be
	 * sent to the callback URL.</li>
	 * <li>If you had not subscribed for notifications, the get provider account details service has to be polled
	 * continuously to know the process status, till the account addition status is FAILED or PARTIAL_SUCCESS or
	 * SUCCESS</li>
	 * </ul>
	 * 
	 * @param providerAccountId - ProviderAccountId
	 * @param providerAccountRequest - Credentials Information
	 * @param apiCallback {@link ApiCallback}&lt;{@link UpdatedProviderAccountResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void editProviderAccountCredentialsAsync(
			@Min(value = 1L, message = "{providerAccounts.param.providerAccountId.invalid}") //
			@Digits(message = "{providerAccounts.param.providerAccountId.invalid}",
					fraction = 0, //
					integer = 11) long providerAccountId, //
			@NotNull(message = "{providerAccounts.param.providerAccountRequest.required}") ProviderAccountRequest providerAccountRequest,
			ApiCallback<UpdatedProviderAccountResponse> apiCallback) throws ApiException {
		ProviderAccountsValidator.validateUpdateProviderAccount(this, ApiUtils.getMethodName(), providerAccountId,
				providerAccountRequest);
		editCredentialsOrRefreshProviderAccountAsync(String.valueOf(providerAccountId), providerAccountRequest,
				apiCallback);
	}

	/**
	 * <b> Posting MFA Info - Notes</b>:<br>
	 * This API is used to submit the MFA information for the MFA-enabled provider accounts during add and update
	 * accounts. <br>
	 * You will receive the MFA request details to be presented to the end user in the GET
	 * providerAccounts/{providerAccount} API during polling or through REFRESH webhooks notification.<br>
	 * After receiving the inputs from your user, embed the MFA information provided by the user in the field array
	 * object and pass to this API.<br>
	 * <b>Notes: </b><br>
	 * Encrypt the answers to the MFA questions using the public key.
	 * 
	 * 
	 * @param providerAccountId - ProviderAccountId
	 * @param mfaFields - MFA Information
	 * @return {@link ApiResponse}&lt;{@link UpdatedProviderAccountResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<UpdatedProviderAccountResponse> submitProviderAccountMFA(//
			@Min(value = 1L, message = "{providerAccounts.param.providerAccountId.invalid}") //
			@Digits(message = "{providerAccounts.param.providerAccountId.invalid}", //
					fraction = 0, //
					integer = 11) long providerAccountId, //
			Field[] mfaFields) throws ApiException {
		ProviderAccountsValidator.validateMFAProviderAccount(this, ApiUtils.getMethodName(), providerAccountId,
				mfaFields);
		ProviderAccountRequest providerAccountRequest = new ProviderAccountRequest();
		providerAccountRequest.setField(Arrays.asList(mfaFields));
		return editCredentialsOrRefreshProviderAccount(String.valueOf(providerAccountId), providerAccountRequest);
	}

	/**
	 * <b> Posting MFA Info - Notes</b>:<br>
	 * This API is used to submit the MFA information for the MFA-enabled provider accounts during add and update
	 * accounts. <br>
	 * You will receive the MFA request details to be presented to the end user in the GET
	 * providerAccounts/{providerAccount} API during polling or through REFRESH webhooks notification.<br>
	 * After receiving the inputs from your user, embed the MFA information provided by the user in the field array
	 * object and pass to this API.<br>
	 * <b>Notes: </b><br>
	 * Encrypt the answers to the MFA questions using the public key.
	 * 
	 * 
	 * @param providerAccountId - ProviderAccountId
	 * @param mfaFields - MFA Information
	 * @param apiCallback {@link ApiCallback}&lt;{@link UpdatedProviderAccountResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void submitProviderAccountMFAAsync(//
			@Min(value = 1L, message = "{providerAccounts.param.providerAccountId.invalid}") //
			@Digits(message = "{providerAccounts.param.providerAccountId.invalid}", //
					fraction = 0, //
					integer = 11) long providerAccountId, //
			Field[] mfaFields, ApiCallback<UpdatedProviderAccountResponse> apiCallback) throws ApiException {
		ProviderAccountsValidator.validateMFAProviderAccount(this, ApiUtils.getMethodName(), providerAccountId,
				mfaFields);
		ProviderAccountRequest providerAccountRequest = new ProviderAccountRequest();
		providerAccountRequest.setField(Arrays.asList(mfaFields));
		editCredentialsOrRefreshProviderAccountAsync(String.valueOf(providerAccountId), providerAccountRequest,
				apiCallback);
	}

	/**
	 * Delete Provider Account The delete provider account service is used to delete a provider account <br>
	 * from the Yodlee system. This service also deletes the accounts that are created in the <br>
	 * Yodlee system for that provider account. This service does not return a response. <br>
	 * The HTTP response code is 204 (Success with no content).<br>
	 * 
	 * @param providerAccountId providerAccountId (required)
	 * @return null
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> deleteProviderAccount(//
			@Min(value = 1L, message = "{providerAccounts.param.providerAccountId.invalid}") //
			@Digits(message = "{providerAccounts.param.providerAccountId.invalid}",
					fraction = 0, //
					integer = 11) long providerAccountId)
			throws ApiException {
		LOGGER.info("ProviderAccount deleteProviderAccount API execution started");
		ProviderAccountsValidator.validateDeleteProviderAccount(this, ApiUtils.getMethodName(), providerAccountId);
		CallContext callContext = buildDeleteProviderAccountContext(providerAccountId);
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Delete Provider Account The delete provider account service is used to delete a provider account <br>
	 * from the Yodlee system. This service also deletes the accounts that are created in the <br>
	 * Yodlee system for that provider account. This service does not return a response. <br>
	 * The HTTP response code is 204 (Success with no content).<br>
	 * 
	 * @param providerAccountId providerAccountId (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void deleteProviderAccountAsync(//
			@Min(value = 1L, message = "{providerAccounts.param.providerAccountId.invalid}") //
			@Digits(message = "{providerAccounts.param.providerAccountId.invalid}",
					fraction = 0, //
					integer = 11) long providerAccountId,
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("ProviderAccount deleteProviderAccountAsync API execution started");
		ProviderAccountsValidator.validateDeleteProviderAccount(this, ApiUtils.getMethodName(), providerAccountId);
		CallContext callContext = buildDeleteProviderAccountContext(providerAccountId);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	/**
	 * Get Provider Account Details The get provider account details service is used to learn the status of adding
	 * accounts and updating accounts.<br>
	 * This service has to be called continuously to know the progress level of the triggered process. This service also
	 * provides the MFA information requested by the provider site.<br>
	 * When include=credentials,questions is passed as input, the service returns the credentials (non-password values)
	 * and questions stored in the Yodlee system for that provider account. <br>
	 * <b>Note:</b> The password and answer fields are not returned in the response.<br>
	 * 
	 * @param providerAccountId providerAccountId (required)
	 * @param include include credentials,questions (optional)
	 * @param requestId The unique identifier for the request that returns contextual data (optional)
	 * @return {@link ApiResponse}&lt;{@link ProviderAccountDetailResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<ProviderAccountDetailResponse> getProviderAccount(//
			@Min(value = 1L, message = "{providerAccounts.param.providerAccountId.invalid}") //
			@Digits(message = "{providerAccounts.param.providerAccountId.invalid}",
					fraction = 0, //
					integer = 11) long providerAccountId, //
			ProviderAccountInclude[] include, String requestId) throws ApiException {
		LOGGER.info("ProviderAccount getProviderAccount API execution started");
		ProviderAccountsValidator.validateGetProviderAccount(this, ApiUtils.getMethodName(), providerAccountId, include,
				requestId);
		CallContext callContext = buildGetProviderAccountContext(providerAccountId, include, requestId, null);
		return callContext.getApiClient().execute(callContext.getCall(), ProviderAccountDetailResponse.class);
	}

	/**
	 * Get Provider Account Details with request Headers. <br>
	 * The get provider account details service is used to learn the status of adding accounts and updating
	 * accounts.<br>
	 * 
	 * 
	 * @param providerAccountId providerAccountId (required)
	 * @param include include credentials,questions (optional)
	 * @param requestId The unique identifier for the request that returns contextual data (optional)
	 * @param headers Map of headers key-value pair e.g (Accept-Encoding, gzip) (required)
	 * @return {@link ApiResponse}&lt;{@link ProviderAccountDetailResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<ProviderAccountDetailResponse> getProviderAccount(//
			@Min(value = 1L, message = "{providerAccounts.param.providerAccountId.invalid}") //
			@Digits(message = "{providerAccounts.param.providerAccountId.invalid}",
					fraction = 0, //
					integer = 11) long providerAccountId, //
			ProviderAccountInclude[] include, String requestId, //
			Map<String, String> headers) throws ApiException {
		LOGGER.info("ProviderAccount getProviderAccount API execution started");
		ProviderAccountsValidator.validateGetProviderAccount(this, ApiUtils.getMethodName(), providerAccountId, include,
				requestId);
		String contentEncodingValue = headers.get(ApiConstants.ACCEPT_ENCODING);
		CallContext callContext =
				buildGetProviderAccountContext(providerAccountId, include, requestId, contentEncodingValue);
		return callContext.getApiClient().execute(callContext.getCall(), ProviderAccountDetailResponse.class);
	}

	/**
	 * Get Provider Account Details The get provider account details service is used to learn the status of adding
	 * accounts and updating accounts.<br>
	 * This service has to be called continuously to know the progress level of the triggered process. This service also
	 * provides the MFA information requested by the provider site.<br>
	 * When include=credentials,questions is passed as input, the service returns the credentials (non-password values)
	 * and questions stored in the Yodlee system for that provider account. <br>
	 * <b>Note:</b> The password and answer fields are not returned in the response.<br>
	 * 
	 * @param providerAccountId providerAccountId (required)
	 * @param include include credentials,questions (optional)
	 * @param requestId The unique identifier for the request that returns contextual data (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link ProviderAccountDetailResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getProviderAccountAsync(//
			@Min(value = 1L, message = "{providerAccounts.param.providerAccountId.invalid}") //
			@Digits(message = "{providerAccounts.param.providerAccountId.invalid}",
					fraction = 0, //
					integer = 11) long providerAccountId, //
			ProviderAccountInclude[] include, String requestId, ApiCallback<ProviderAccountDetailResponse> apiCallback)
			throws ApiException {
		LOGGER.info("ProviderAccount getProviderAccountAsync API execution started");
		ProviderAccountsValidator.validateGetProviderAccount(this, ApiUtils.getMethodName(), providerAccountId, include,
				requestId);
		CallContext callContext = buildGetProviderAccountContext(providerAccountId, include, requestId, null);
		callContext.getApiClient().executeAsync(callContext.getCall(), ProviderAccountDetailResponse.class,
				apiCallback);
	}

	/**
	 * Get Provider Accounts The get provider accounts service is used to return all the provider accounts added by the
	 * user. <br>
	 * This includes the failed and successfully added provider accounts.<br>
	 * 
	 * @param include - preferences
	 * @param providerIds - Comma separated providerIds
	 * @return {@link ApiResponse}{@literal <}{@link ProviderAccountResponse}{@literal >}
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<ProviderAccountResponse> getAllProviderAccounts(ProviderAccountDetailsInclude include, //
			Long[] providerIds) throws ApiException {
		LOGGER.info("ProviderAccount getAllProviderAccounts API execution started");
		ProviderAccountsValidator.validateGetAllProviderAccounts(this, ApiUtils.getMethodName(), include, providerIds);
		CallContext callContext = buildGetAllProviderAccountsContext(include, providerIds, null);
		return callContext.getApiClient().execute(callContext.getCall(), ProviderAccountResponse.class);
	}
	
	
	/**
	 * Get Provider Account with request Headers. <br>
	 * 
	 * Get Provider Accounts The get provider accounts service is used to return all the provider accounts added by the
	 * user. <br>
	 * This includes the failed and successfully added provider accounts.<br>
	 * 
	 * @param include - preferences
	 * @param providerIds - Comma separated providerIds
	 * @param headers Map of headers key-value pair e.g (Accept-Encoding, gzip) (required)
	 * @return {@link ApiResponse}{@literal <}{@link ProviderAccountResponse}{@literal >}
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<ProviderAccountResponse> getAllProviderAccounts(ProviderAccountDetailsInclude include, //
			Long[] providerIds, //
			Map<String, String> headers) throws ApiException {
		LOGGER.info("ProviderAccount getAllProviderAccounts API execution started");
		ProviderAccountsValidator.validateGetAllProviderAccounts(this, ApiUtils.getMethodName(), include, providerIds);
		String contentEncodingValue = headers.get(ApiConstants.ACCEPT_ENCODING);
		CallContext callContext = buildGetAllProviderAccountsContext(include, providerIds, contentEncodingValue);
		return callContext.getApiClient().execute(callContext.getCall(), ProviderAccountResponse.class);
	}

	/**
	 * Get Provider Accounts The get provider accounts service is used to return all the provider accounts added by the
	 * user. <br>
	 * This includes the failed and successfully added provider accounts.<br>
	 * 
	 * @param include - preferences
	 * @param providerIds - Comma separated providerIds
	 * @param apiCallback {@link ApiCallback}&lt;{@link ProviderAccountResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getAllProviderAccountsAsync(ProviderAccountDetailsInclude include, //
			Long[] providerIds, ApiCallback<ProviderAccountResponse> apiCallback) throws ApiException {
		LOGGER.info("ProviderAccount getAllProviderAccountsAsync API execution started");
		ProviderAccountsValidator.validateGetAllProviderAccounts(this, ApiUtils.getMethodName(), include, providerIds);
		CallContext callContext = buildGetAllProviderAccountsContext(include, providerIds, null);
		callContext.getApiClient().executeAsync(callContext.getCall(), ProviderAccountResponse.class, apiCallback);
	}

	/**
	 * <b>Credential Based Provider Account Addition:</b><br>
	 * The add account API is used to link the user's account in the Yodlee system. Providers that require multifactor
	 * authentication(MFA) are also supported by this API. The response includes the Yodlee generated ID
	 * (providerAccountId) of the account along with the refresh information.
	 * 
	 * The field array object that is an input to this API will be provided in the get provider details API response.
	 * The user-provided credentials should be embedded in the field array object. The data to be retrieved from the
	 * provider site can be passed using datasetName or dataset. If datasetName is passed, all the attributes that are
	 * implicitly configured for the dataset will be retrieved.
	 * 
	 * This API has webhooks support. If you have subscribed to the REFRESH event notification and has invoked this API
	 * to add an account, relevant notifications will be sent to the callback URL. If you have not subscribed to the
	 * REFRESH event webhooks notification, the get providerAccount API has to be:
	 * <ul>
	 * <li>polled continuously till the login form (supported types are token, question {@literal &} answer, and
	 * captcha) is returned in the response for accounts that require multifactor authentication (MFA)</li>
	 * <li>polled continuously till the account addition status is FAILED or PARTIAL_SUCCESS or SUCCESS The update
	 * account API should be called to post the MFA information to continue adding the account.</li>
	 * </ul>
	 * 
	 * A dataset may depend on another dataset for retrieval, so the response will include the requested datasets and
	 * the dependent datasets. It is necessary to check all the dataset additional statuses returned in the response, as
	 * the provider account status is drawn from the dataset additional statuses.
	 * 
	 * For detailed implementation, refer to the add account flow chart in portal. Pass linkedProviderAccountId in the
	 * input to link a user’s credential-based providerAccount with the open banking providerAccount. Ensure that the
	 * credential-based providerAccount belongs to the same institution. While testing the PKI feature, encrypt the
	 * credentials using the encryption utility. The content type has to be passed as application/json in the body
	 * parameter.
	 * 
	 * @param providerAccountRequest - credentialsParam
	 * @param providerId - providerId
	 * @return {@link ApiResponse}{@literal <}{@link AddedProviderAccountResponse}{@literal >}
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AddedProviderAccountResponse> linkCredentialProviderAccount(
			@NotNull(message = "{providerAccounts.param.providerAccountRequest.required}") ProviderAccountRequest providerAccountRequest, //
			@Min(value = 1, message = "{providerAccounts.param.providerId.invalid}") //
			@Digits(message = "{providerAccounts.param.providerId.invalid}", fraction = 0, integer = 11) //
			long providerId) throws ApiException {
		LOGGER.info("ProviderAccount linkCredentialProviderAccount API execution started");
		ProviderAccountsValidator.validateLinkProviderAccount(this, ApiUtils.getMethodName(), providerId,
				providerAccountRequest);
		return linkProviderAccount(providerAccountRequest, providerId);
	}

	/**
	 * <b>Credential Based Provider Account Addition:</b><br>
	 * The add account API is used to link the user's account in the Yodlee system. Providers that require multifactor
	 * authentication(MFA) are also supported by this API. The response includes the Yodlee generated ID
	 * (providerAccountId) of the account along with the refresh information.
	 * 
	 * The field array object that is an input to this API will be provided in the get provider details API response.
	 * The user-provided credentials should be embedded in the field array object. The data to be retrieved from the
	 * provider site can be passed using datasetName or dataset. If datasetName is passed, all the attributes that are
	 * implicitly configured for the dataset will be retrieved.
	 * 
	 * This API has webhooks support. If you have subscribed to the REFRESH event notification and has invoked this API
	 * to add an account, relevant notifications will be sent to the callback URL. If you have not subscribed to the
	 * REFRESH event webhooks notification, the get providerAccount API has to be:
	 * <ul>
	 * <li>polled continuously till the login form (supported types are token, question {@literal &} answer, and
	 * captcha) is returned in the response for accounts that require multifactor authentication (MFA)</li>
	 * <li>polled continuously till the account addition status is FAILED or PARTIAL_SUCCESS or SUCCESS The update
	 * account API should be called to post the MFA information to continue adding the account.</li>
	 * </ul>
	 * 
	 * A dataset may depend on another dataset for retrieval, so the response will include the requested datasets and
	 * the dependent datasets. It is necessary to check all the dataset additional statuses returned in the response, as
	 * the provider account status is drawn from the dataset additional statuses.
	 * 
	 * For detailed implementation, refer to the add account flow chart in portal. Pass linkedProviderAccountId in the
	 * input to link a user’s credential-based providerAccount with the open banking providerAccount. Ensure that the
	 * credential-based providerAccount belongs to the same institution. While testing the PKI feature, encrypt the
	 * credentials using the encryption utility. The content type has to be passed as application/json in the body
	 * parameter.
	 * 
	 * @param providerAccountRequest - credentialsParam
	 * @param providerId - ProviderId
	 * @param apiCallback {@link ApiCallback}&lt;{@link AddedProviderAccountResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void linkCredentialProviderAccountAsync(
			@NotNull(message = "{providerAccounts.param.providerAccountRequest.required}") ProviderAccountRequest providerAccountRequest, //
			@Min(value = 1, message = "{providerAccounts.param.providerId.invalid}") //
			@Digits(message = "{providerAccounts.param.providerId.invalid}", fraction = 0, integer = 11) //
			long providerId, ApiCallback<AddedProviderAccountResponse> apiCallback) throws ApiException {
		LOGGER.info("ProviderAccount linkCredentialProviderAccountAsync API execution started");
		ProviderAccountsValidator.validateLinkProviderAccount(this, ApiUtils.getMethodName(), providerId,
				providerAccountRequest);
		linkProviderAccountAsync(providerAccountRequest, providerId, apiCallback);
	}

	/**
	 * Get User Profile Details The get provider accounts profile service is used to return the user profile details
	 * that are associated to the provider account. <br>
	 * 
	 * @param providerAccountId Comma separated providerAccountIds. (optional)
	 * @return {@link ApiResponse}&lt;{@link ProviderAccountUserProfileResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<ProviderAccountUserProfileResponse> getProviderAccountProfile(Long[] providerAccountId)
			throws ApiException {
		LOGGER.info("ProviderAccount getProviderAccountProfile API execution started");
		ProviderAccountsValidator.validateGetProviderAccountProfiles(this, ApiUtils.getMethodName(), providerAccountId);
		CallContext callContext = buildGetProviderAccountProfilesContext(providerAccountId);
		return callContext.getApiClient().execute(callContext.getCall(), ProviderAccountUserProfileResponse.class);
	}

	/**
	 * Get User Profile Details The get provider accounts profile service is used to return the user profile details
	 * that are associated to the provider account. <br>
	 * 
	 * @param providerAccountId Comma separated providerAccountIds. (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link ProviderAccountUserProfileResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getProviderAccountProfileAsync(Long[] providerAccountId,
			ApiCallback<ProviderAccountUserProfileResponse> apiCallback) throws ApiException {
		LOGGER.info("ProviderAccount getProviderAccountProfileAsync API execution started");
		ProviderAccountsValidator.validateGetProviderAccountProfiles(this, ApiUtils.getMethodName(), providerAccountId);
		CallContext callContext = buildGetProviderAccountProfilesContext(providerAccountId);
		callContext.getApiClient().executeAsync(callContext.getCall(), ProviderAccountUserProfileResponse.class,
				apiCallback);
	}

	/**
	 * Update Preferences This endpoint is used to update preferences like data extracts and auto refreshes without
	 * triggering refresh for the providerAccount.<br>
	 * Setting isDataExtractsEnabled to false will not trigger data extracts notification and dataExtracts/events will
	 * not reflect any data change that is happening for the providerAccount.<br>
	 * Modified data will not be provided in the dataExtracts/userData endpoint.<br>
	 * Setting isAutoRefreshEnabled to false will not trigger auto refreshes for the provider account.<br>
	 * 
	 * @param preferences preferences (required)
	 * @param providerAccountId providerAccountId (required)
	 * @return null
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<AbstractModelComponent> updatePreferences(
			@NotNull(message = "{providerAccounts.param.preferences.required}") ProviderAccountPreferencesRequest preferences, //
			@NotNull(message = "{providerAccounts.param.providerAccountId.required}") //
			@Digits(message = "{providerAccounts.param.providerAccountId.invalid}", fraction = 0, integer = 11) //
			Long providerAccountId) throws ApiException {
		LOGGER.info("ProviderAccount updatePreferences API execution started");
		ProviderAccountsValidator.validateUpdatePreferences(this, ApiUtils.getMethodName(), preferences,
				providerAccountId);
		CallContext callContext = buildUpdatePreferencesContext(preferences, providerAccountId);
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Update Preferences This endpoint is used to update preferences like data extracts and auto refreshes without
	 * triggering refresh for the providerAccount.<br>
	 * Setting isDataExtractsEnabled to false will not trigger data extracts notification and dataExtracts/events will
	 * not reflect any data change that is happening for the providerAccount.<br>
	 * Modified data will not be provided in the dataExtracts/userData endpoint.<br>
	 * Setting isAutoRefreshEnabled to false will not trigger auto refreshes for the provider account.<br>
	 * 
	 * @param preferences preferences (required)
	 * @param providerAccountId providerAccountId (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void updatePreferencesAsync(
			@NotNull(message = "{providerAccounts.param.preferences.required}") ProviderAccountPreferencesRequest preferences, //
			@NotNull(message = "{providerAccounts.param.providerAccountId.required}") //
			@Digits(message = "{providerAccounts.param.providerAccountId.invalid}", fraction = 0, integer = 11) //
			Long providerAccountId, ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("ProviderAccount updatePreferencesAsync API execution started");
		ProviderAccountsValidator.validateUpdatePreferences(this, ApiUtils.getMethodName(), preferences,
				providerAccountId);
		CallContext callContext = buildUpdatePreferencesContext(preferences, providerAccountId);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private ApiResponse<UpdatedProviderAccountResponse> editCredentialsOrRefreshProviderAccount(
			String providerAccountIds, AbstractProviderAccountRequest providerAccountRequest) throws ApiException {
		LOGGER.info("ProviderAccount editCredentialsOrRefreshProviderAccount API execution started");
		CallContext callContext =
				buildEditCredentialsOrRefreshProviderAccountContext(providerAccountIds, providerAccountRequest);
		return callContext.getApiClient().execute(callContext.getCall(), UpdatedProviderAccountResponse.class);
	}

	private void editCredentialsOrRefreshProviderAccountAsync(String providerAccountIds,
			AbstractProviderAccountRequest providerAccountRequest,
			ApiCallback<UpdatedProviderAccountResponse> apiCallback) throws ApiException {
		LOGGER.info("ProviderAccount editCredentialsOrRefreshProviderAccountAsync API execution started");
		CallContext callContext =
				buildEditCredentialsOrRefreshProviderAccountContext(providerAccountIds, providerAccountRequest);
		callContext.getApiClient().executeAsync(callContext.getCall(), UpdatedProviderAccountResponse.class,
				apiCallback);
	}

	private CallContext buildEditCredentialsOrRefreshProviderAccountContext(String providerAccountIds,
			AbstractProviderAccountRequest providerAccountRequest) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(ApiEndpoint.PROVIDER_ACCOUNTS, HttpMethod.PUT, providerAccountRequest);
		apiContext.addQueryParam(new Pair(PARAM_PROVIDER_ACCOUNT_IDS, providerAccountIds));
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	private CallContext buildDeleteProviderAccountContext(long providerAccountId) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		String apiEndPoint = replacePathVariable(ApiEndpoint.PROVIDER_ACCOUNT_DETAILS, PROVIDER_ACCOUNT_ID,
				String.valueOf(providerAccountId));
		ApiContext apiContext = new ApiContext(apiEndPoint, HttpMethod.DELETE, null);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	private CallContext buildGetProviderAccountContext(long providerAccountId, //
			ProviderAccountInclude[] include, String requestId, String contentEncoding) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		String apiEndPoint = replacePathVariable(ApiEndpoint.PROVIDER_ACCOUNT_DETAILS, PROVIDER_ACCOUNT_ID,
				String.valueOf(providerAccountId));
		ApiContext apiContext = new ApiContext(apiEndPoint, HttpMethod.GET, null);
		if (include != null) {
			apiContext.addQueryParam(new Pair(PARAM_INCLUDE, ApiUtils.convertArrayToString(include)));
		}
		if (!StringUtils.isEmpty(requestId)) {
			apiContext.addQueryParam(new Pair(PARAM_REQUEST_ID, requestId));
		}
		if (contentEncoding != null) {
			apiContext.addHeaderParam(ApiConstants.ACCEPT_ENCODING, contentEncoding);
		}
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	private CallContext buildGetAllProviderAccountsContext(ProviderAccountDetailsInclude include, //
			Long[] providerIds, String contentEncoding) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(ApiEndpoint.PROVIDER_ACCOUNTS, HttpMethod.GET, null);
		if (include != null) {
			apiContext.addQueryParam(new Pair(PARAM_INCLUDE, include.toString()));
		}
		if (providerIds != null) {
			apiContext.addQueryParam(new Pair(PARAM_PROVIDER_IDS, ApiUtils.convertArrayToString(providerIds)));
		}
		if (contentEncoding != null) {
			apiContext.addHeaderParam(ApiConstants.ACCEPT_ENCODING, contentEncoding);
		}
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	private ApiResponse<AddedProviderAccountResponse> linkProviderAccount(ProviderAccountRequest providerAccountRequest, //
			Long providerId) throws ApiException {
		LOGGER.info("ProviderAccount linkProviderAccount API execution started");
		CallContext callContext = buildLinkProviderAccountContext(providerAccountRequest, providerId);
		return callContext.getApiClient().execute(callContext.getCall(), AddedProviderAccountResponse.class);
	}

	private void linkProviderAccountAsync(ProviderAccountRequest providerAccountRequest, //
			Long providerId, ApiCallback<AddedProviderAccountResponse> apiCallback) throws ApiException {
		LOGGER.info("ProviderAccount linkProviderAccountAsync API execution started");
		CallContext callContext = buildLinkProviderAccountContext(providerAccountRequest, providerId);
		callContext.getApiClient().executeAsync(callContext.getCall(), AddedProviderAccountResponse.class, apiCallback);
	}

	private CallContext buildLinkProviderAccountContext(ProviderAccountRequest providerAccountRequest, //
			Long providerId) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(ApiEndpoint.PROVIDER_ACCOUNTS, HttpMethod.POST, providerAccountRequest);
		apiContext.addQueryParam(new Pair(PROVIDER_ID, providerId.toString()));
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	private CallContext buildGetProviderAccountProfilesContext(Long[] providerAccountId) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		ApiContext apiContext = new ApiContext(ApiEndpoint.PROVIDER_ACCOUNTS_PROFILE, HttpMethod.GET, null);
		if (providerAccountId != null) {
			apiContext.addQueryParam(new Pair(PROVIDER_ACCOUNT_ID, ApiUtils.convertArrayToString(providerAccountId)));
		}
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	private CallContext buildUpdatePreferencesContext(ProviderAccountPreferencesRequest preferences, //
			Long providerAccountId) throws ApiException {
		ApiClient apiClient = getContext().getApiClient(getRequestHeaderMap());
		String apiEndPoint = replacePathVariable(ApiEndpoint.PROVIDER_ACCOUNTS_PREFERENCES, PROVIDER_ACCOUNT_ID,
				providerAccountId.toString());
		ApiContext apiContext = new ApiContext(apiEndPoint, HttpMethod.PUT, preferences);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}
}
