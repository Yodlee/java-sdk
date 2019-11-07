/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api;

import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.squareup.okhttp.Call;
import com.yodlee.api.model.verification.enums.VerificationType;
import com.yodlee.api.model.verification.request.UpdateVerificationRequest;
import com.yodlee.api.model.verification.request.VerificationMatchingRequest;
import com.yodlee.api.model.verification.request.VerificationRequest;
import com.yodlee.api.model.verification.response.VerificationResponse;
import com.yodlee.api.model.verification.response.VerificationStatusResponse;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;
import com.yodlee.sdk.api.validators.VerificationValidator;
import com.yodlee.sdk.client.ApiCallback;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.client.ApiContext;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.client.CallContext;
import com.yodlee.sdk.client.HttpMethod;
import com.yodlee.sdk.client.Pair;
import com.yodlee.sdk.context.Context;

public class VerificationApi extends AbstractApi {

	private static final String VERIFICATION_TYPE = "verificationType";

	private static final String PROVIDER_ACCOUNT_ID = "providerAccountId";

	private static final String ACCOUNT_ID = "accountId";

	private static final Logger LOGGER = LoggerFactory.getLogger(VerificationApi.class);

	public VerificationApi(Context<?> context) {
		super(context);
	}

	/**
	 * Get Verification Details The get verification status service is used to retrieve the verification status of all
	 * accounts<br>
	 * for which the MS or CDV process has been initiated.<br>
	 * For the MS process, the account details object returns the aggregated information of the<br>
	 * verified accounts. For the CDV process, the account details object returns the user<br>
	 * provided account information.<br>
	 * 
	 * @param accountId Comma separated accountId (optional)
	 * @param providerAccountId Comma separated providerAccountId (optional)
	 * @param verificationType verificationType (optional)
	 * @return {@link ApiResponse}&lt;{@link VerificationStatusResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<VerificationStatusResponse> getVerificationDetails(Long[] accountId, Long[] providerAccountId,
			VerificationType verificationType) throws ApiException {
		LOGGER.info("Verification GetVerificationDetails API execution started");
		VerificationValidator.validateGetVerificationDetails(this, ApiUtils.getMethodName(), providerAccountId,
				accountId, verificationType);
		CallContext callContext = buildGetVerificationDetailsContext(accountId, providerAccountId, verificationType);
		return callContext.getApiClient().execute(callContext.getCall(), VerificationStatusResponse.class);
	}

	/**
	 * Get Verification Details The get verification status service is used to retrieve the verification status of all
	 * accounts<br>
	 * for which the MS or CDV process has been initiated.<br>
	 * For the MS process, the account details object returns the aggregated information of the<br>
	 * verified accounts. For the CDV process, the account details object returns the user<br>
	 * provided account information.<br>
	 * 
	 * @param accountId Comma separated accountId (optional)
	 * @param providerAccountId Comma separated providerAccountId (optional)
	 * @param verificationType verificationType (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link VerificationStatusResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getVerificationDetailsAsync(Long[] accountId, Long[] providerAccountId,
			VerificationType verificationType, ApiCallback<VerificationStatusResponse> apiCallback)
			throws ApiException {
		LOGGER.info("Verification GetVerificationDetailsAsync API execution started");
		VerificationValidator.validateGetVerificationDetails(this, ApiUtils.getMethodName(), providerAccountId,
				accountId, verificationType);
		CallContext callContext = buildGetVerificationDetailsContext(accountId, providerAccountId, verificationType);
		callContext.getApiClient().executeAsync(callContext.getCall(), VerificationStatusResponse.class, apiCallback);
	}

	private CallContext buildGetVerificationDetailsContext(Long[] accountId, Long[] providerAccountId,
			VerificationType verificationType) throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(ApiEndpoint.VERIFICATION, HttpMethod.GET, null);
		if (accountId != null && accountId.length > 0) {
			apiContext.addQueryParam(new Pair(ACCOUNT_ID, ApiUtils.convertArrayToString(accountId)));
		}
		if (providerAccountId != null && providerAccountId.length > 0) {
			apiContext.addQueryParam(new Pair(PROVIDER_ACCOUNT_ID, ApiUtils.convertArrayToString(providerAccountId)));
		}
		if (verificationType != null) {
			apiContext.addQueryParam(new Pair(VERIFICATION_TYPE, verificationType.toString()));
		}
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Initiate Challenge Deposit Verification The post verification service is used to initiate thechallenge deposit
	 * account verification (CDV) process to verify account ownership.<br>
	 * TheCDV process can verify ownership of only bank accounts (i.e., checking and savings).<br>
	 * Once the CDV process is initiated Yodlee will post the microtransaction (i.e., credit and debit) in the user's
	 * account.<br>
	 * The CDV process takes 2 to 3 days to complete as it requires the user to provide the microtransaction
	 * details.<br>
	 * The CDV process is currently supported only in the United States.<br>
	 * The verificationId in the response can be used to track the verification request.<br>
	 * 
	 * @param verificationParam(required)
	 * @return {@link ApiResponse}&lt;{@link VerificationResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<VerificationResponse> initiateCDVerification(
			@NotNull(message = "{verifications.VerificationRequest.required}") VerificationRequest verificationParam)
			throws ApiException {
		LOGGER.info("Verification InitiateCDVerification execution started");
		VerificationValidator.validateInitiateCDVerification(this, ApiUtils.getMethodName(), verificationParam);
		CallContext callContext = buildInitiateCDVerificationContext(verificationParam);
		return callContext.getApiClient().execute(callContext.getCall(), VerificationResponse.class);
	}

	/**
	 * Initiate Challenge Deposit Verification The post verification service is used to initiate thechallenge deposit
	 * account verification (CDV) process to verify account ownership.<br>
	 * TheCDV process can verify ownership of only bank accounts (i.e., checking and savings).<br>
	 * Once the CDV process is initiated Yodlee will post the microtransaction (i.e., credit and debit) in the user's
	 * account.<br>
	 * The CDV process takes 2 to 3 days to complete as it requires the user to provide the microtransaction
	 * details.<br>
	 * The CDV process is currently supported only in the United States.<br>
	 * The verificationId in the response can be used to track the verification request.<br>
	 * 
	 * @param verificationParam (required)
	 * @param apiCallback {@link ApiCallback}&lt;{@link VerificationResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void initiateCDVerificationAsync(
			@NotNull(message = "{verifications.VerificationRequest.required}") VerificationRequest verificationParam,
			ApiCallback<VerificationResponse> apiCallback) throws ApiException {
		LOGGER.info("Verification InitiateCDVerificationAsync execution started");
		VerificationValidator.validateInitiateCDVerification(this, ApiUtils.getMethodName(), verificationParam);
		CallContext callContext = buildInitiateCDVerificationContext(verificationParam);
		callContext.getApiClient().executeAsync(callContext.getCall(), VerificationResponse.class, apiCallback);
	}

	private CallContext buildInitiateCDVerificationContext(VerificationRequest verificationParam) throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(ApiEndpoint.VERIFICATION, HttpMethod.POST, verificationParam);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Perform Matching Verification The post verification service is used to initiate the matching service (MS) to
	 * verify account ownership. <br>
	 * The MS can verify ownership of only bank accounts (i.e., checking and savings).<br>
	 * MS verification - The MS verification can be initiated only for an already aggregated account or a
	 * providerAccount. <br>
	 * The prerequisite for the MS verification process is to request the following ACCT_PROFILE dataset attributes<br>
	 * FULL_ACCT_NUMBER<br>
	 * BANK_TRANSFER_CODE (optional based on the configuration done for the customer)<br>
	 * HOLDER_NAME <br>
	 * In the MS verification process, a string-match of the account holder name with the registered user name is
	 * performed instantaneously. <br>
	 * Contact the Yodlee CustomerCare team to configure the full name or only the last name match. <br >
	 * 
	 * @param verificationParam verification information (required)
	 * @return {@link ApiResponse}&lt;{@link VerificationResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<VerificationResponse> performMatchingVerification(
			@NotNull(message = "{verifications.VerificationMatchingRequest.required}") VerificationMatchingRequest verificationParam)
			throws ApiException {
		LOGGER.info("Verification PerformMatchingVerificationAsync execution started");
		VerificationValidator.validateMatchingVerification(this, ApiUtils.getMethodName(), verificationParam);
		CallContext callContext = buildPerformMatchingVerificationContext(verificationParam);
		return callContext.getApiClient().execute(callContext.getCall(), VerificationResponse.class);
	}

	/**
	 * Perform Matching Verification The post verification service is used to initiate the matching service (MS) to
	 * verify account ownership. <br>
	 * The MS can verify ownership of only bank accounts (i.e., checking and savings).<br>
	 * MS verification - The MS verification can be initiated only for an already aggregated account or a
	 * providerAccount. <br>
	 * The prerequisite for the MS verification process is to request the following ACCT_PROFILE dataset attributes<br>
	 * FULL_ACCT_NUMBER<br>
	 * BANK_TRANSFER_CODE (optional based on the configuration done for the customer)<br>
	 * HOLDER_NAME <br>
	 * In the MS verification process, a string-match of the account holder name with the registered user name is
	 * performed instantaneously. <br>
	 * Contact the Yodlee CustomerCare team to configure the full name or only the last name match. <br >
	 * 
	 * @param verificationParam verification information (required)
	 * @param apiCallback {@link ApiCallback}&lt;{@link VerificationResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void performMatchingVerificationAsync(
			@NotNull(message = "{verifications.VerificationMatchingRequest.required}") VerificationMatchingRequest verificationParam,
			ApiCallback<VerificationResponse> apiCallback) throws ApiException {
		LOGGER.info("Verification PerformMatchingVerificationAsync execution started");
		VerificationValidator.validateMatchingVerification(this, ApiUtils.getMethodName(), verificationParam);
		CallContext callContext = buildPerformMatchingVerificationContext(verificationParam);
		callContext.getApiClient().executeAsync(callContext.getCall(), VerificationResponse.class, apiCallback);
	}

	private CallContext buildPerformMatchingVerificationContext(VerificationMatchingRequest verificationParam)
			throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(ApiEndpoint.VERIFICATION, HttpMethod.POST, verificationParam);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Perform Challenge Deposit Verification The put verification service is used to complete the CDV process.<br>
	 * In the CDV process, the user-provided microtransaction details (i.e., credit and debit) is matched against the
	 * microtransactions posted by Yodlee.<br>
	 * For a successful verification of the account&#39;s ownership both microtransaction details should match.<br>
	 * The CDV process is currently supported only in the United States.
	 * 
	 * @param updateVerificationRequest verification information (required)
	 * @return {@link ApiResponse}&lt;{@link VerificationResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<VerificationResponse> performCDVerification(
			@NotNull(message = "{verifications.UpdateVerificationRequest.required}") UpdateVerificationRequest updateVerificationRequest)
			throws ApiException {
		LOGGER.info("Verification PerformCDVerification API execution started");
		VerificationValidator.validatePerformCDVerification(this, ApiUtils.getMethodName(), updateVerificationRequest);
		CallContext callContext = buildPerformCDVerificationContext(updateVerificationRequest);
		return callContext.getApiClient().execute(callContext.getCall(), VerificationResponse.class);
	}

	/**
	 * Perform Challenge Deposit Verification The put verification service is used to complete the CDV process.<br>
	 * In the CDV process, the user-provided microtransaction details (i.e., credit and debit) is matched against the
	 * microtransactions posted by Yodlee.<br>
	 * For a successful verification of the account&#39;s ownership both microtransaction details should match.<br>
	 * The CDV process is currently supported only in the United States.
	 * 
	 * @param updateVerificationRequest verification information (required)
	 * @param apiCallback {@link ApiCallback}&lt;{@link VerificationResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void performCDVerificationAsync(
			@NotNull(message = "{verifications.UpdateVerificationRequest.required}") UpdateVerificationRequest updateVerificationRequest,
			ApiCallback<VerificationResponse> apiCallback) throws ApiException {
		LOGGER.info("Verification PerformCDVerificationAsync API execution started");
		VerificationValidator.validatePerformCDVerification(this, ApiUtils.getMethodName(), updateVerificationRequest);
		CallContext callContext = buildPerformCDVerificationContext(updateVerificationRequest);
		callContext.getApiClient().executeAsync(callContext.getCall(), VerificationResponse.class, apiCallback);
	}

	private CallContext buildPerformCDVerificationContext(UpdateVerificationRequest updateVerificationRequest)
			throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(ApiEndpoint.VERIFICATION, HttpMethod.PUT, updateVerificationRequest);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}
}
