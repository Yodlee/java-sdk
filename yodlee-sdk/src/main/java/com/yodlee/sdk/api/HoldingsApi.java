/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.api;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.squareup.okhttp.Call;
import com.yodlee.api.model.holdings.response.HoldingAssetClassificationListResponse;
import com.yodlee.api.model.holdings.response.HoldingResponse;
import com.yodlee.api.model.holdings.response.HoldingSecuritiesResponse;
import com.yodlee.api.model.holdings.response.HoldingTypeListResponse;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;
import com.yodlee.sdk.api.validators.HoldingsValidator;
import com.yodlee.sdk.api.validators.HoldingsValidator.HoldingInclude;
import com.yodlee.sdk.client.ApiCallback;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.client.ApiContext;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.client.CallContext;
import com.yodlee.sdk.client.HttpMethod;
import com.yodlee.sdk.client.Pair;
import com.yodlee.sdk.context.Context;

public class HoldingsApi extends AbstractApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(HoldingsApi.class);

	private static final String PARAM_PROVIDER_ACCOUNT_ID = "providerAccountId";

	private static final String PARAM_INCLUDE = "include";

	private static final String PARAM_CLASSIFICATION_VALUE = "classificationValue";

	private static final String PARAM_ASSET_CLASSIFICATION_CLASSIFICATION_TYPE =
			"assetClassificationClassificationType";

	private static final String PARAM_ACCOUNT_ID = "accountId";

	private static final String PARAM_HOLDING_ID = "holdingId";

	public HoldingsApi(Context<?> context) {
		super(context);
	}

	/**
	 * Get Holdings The get holdings service is used to get the list of holdings of a user.<br>
	 * Supported holding types can be employeeStockOption, <br>
	 * moneyMarketFund, bond, etc. and is obtained using get holding type list service. <br>
	 * Asset classifications for the holdings need to be requested through the "include" parameter.<br>
	 * Asset classification information for holdings are not available by default, as it is a premium feature.<br>
	 * 
	 * @param accountId Comma separated accountId (optional)
	 * @param assetClassificationClassificationType e.g. Country, Sector, etc. (optional)
	 * @param classificationValue e.g. US (optional)
	 * @param include assetClassification (optional)
	 * @param providerAccountId providerAccountId (optional)
	 * @return {@link ApiResponse}&lt;{@link HoldingResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<HoldingResponse> getHoldings(//
			@Size(min = 0, max = 100, message = "{holdings.param.accountId.length.invalid}") Long[] accountId,
			String assetClassificationClassificationType, String classificationValue, HoldingInclude include,
			@Digits(message = "{holdings.param.providerAccountId.invalid}", fraction = 0, integer = 11) //
			@Min(value = 1, message = "{holdings.param.providerAccountId.invalid}") Long providerAccountId)
			throws ApiException {
		LOGGER.info("Holdings getHoldings API execution started");
		HoldingsValidator.validateGetHoldings(this, ApiUtils.getMethodName(), accountId,
				assetClassificationClassificationType, classificationValue, include, providerAccountId);
		CallContext callContext = buildGetHoldingsContext(accountId, assetClassificationClassificationType,
				classificationValue, include, providerAccountId);
		return callContext.getApiClient().execute(callContext.getCall(), HoldingResponse.class);
	}

	/**
	 * Get Holdings The get holdings service is used to get the list of holdings of a user.<br>
	 * Supported holding types can be employeeStockOption, <br>
	 * moneyMarketFund, bond, etc. and is obtained using get holding type list service. <br>
	 * Asset classifications for the holdings need to be requested through the "include" parameter.<br>
	 * Asset classification information for holdings are not available by default, as it is a premium feature.<br>
	 * 
	 * @param accountId Comma separated accountId (optional)
	 * @param assetClassificationClassificationType e.g. Country, Sector, etc. (optional)
	 * @param classificationValue e.g. US (optional)
	 * @param include assetClassification (optional)
	 * @param providerAccountId providerAccountId (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link HoldingResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getHoldingsAsync(//
			@Size(min = 0, max = 100, message = "{holdings.param.accountId.length.invalid}") Long[] accountId,
			String assetClassificationClassificationType, String classificationValue, HoldingInclude include,
			@Digits(message = "{holdings.param.providerAccountId.invalid}", fraction = 0, integer = 11) //
			@Min(value = 1, message = "{holdings.param.providerAccountId.invalid}") Long providerAccountId,
			ApiCallback<HoldingResponse> apiCallback) throws ApiException {
		LOGGER.info("Holdings getHoldingsAsync API execution started");
		HoldingsValidator.validateGetHoldings(this, ApiUtils.getMethodName(), accountId,
				assetClassificationClassificationType, classificationValue, include, providerAccountId);
		CallContext callContext = buildGetHoldingsContext(accountId, assetClassificationClassificationType,
				classificationValue, include, providerAccountId);
		callContext.getApiClient().executeAsync(callContext.getCall(), HoldingResponse.class, apiCallback);
	}

	private CallContext buildGetHoldingsContext(Long[] accountId, String assetClassificationClassificationType,
			String classificationValue, HoldingInclude include, Long providerAccountId) throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(ApiEndpoint.HOLDINGS, HttpMethod.GET, null);
		if (accountId != null) {
			apiContext.addQueryParam(new Pair(PARAM_ACCOUNT_ID, ApiUtils.convertArrayToString(accountId)));
		}
		if (!StringUtils.isEmpty(assetClassificationClassificationType)) {
			apiContext.addQueryParam(
					new Pair(PARAM_ASSET_CLASSIFICATION_CLASSIFICATION_TYPE, assetClassificationClassificationType));
		}
		if (!StringUtils.isEmpty(classificationValue)) {
			apiContext.addQueryParam(new Pair(PARAM_CLASSIFICATION_VALUE, classificationValue));
		}
		if (include != null) {
			apiContext.addQueryParam(new Pair(PARAM_INCLUDE, include.toString()));
		}
		if (providerAccountId != null) {
			apiContext.addQueryParam(new Pair(PARAM_PROVIDER_ACCOUNT_ID, providerAccountId.toString()));
		}
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get Security Details The get security details service is used to get all the security information for the
	 * holdings<br>
	 * 
	 * @param holdingId Comma separated holdingId (optional)
	 * @return {@link ApiResponse}&lt;{@link HoldingSecuritiesResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<HoldingSecuritiesResponse> getSecurities(
			@Size(min = 0, max = 100, message = "{holdings.param.holdingId.length.invalid}") Long[] holdingId)
			throws ApiException {
		LOGGER.info("Holdings getSecurities API execution started");
		HoldingsValidator.validateGetSecurities(this, ApiUtils.getMethodName(), holdingId);
		CallContext callContext = buildGetSecuritiesContext(holdingId);
		return callContext.getApiClient().execute(callContext.getCall(), HoldingSecuritiesResponse.class);
	}

	/**
	 * Get Security Details The get security details service is used to get all the security information for the
	 * holdings<br>
	 * 
	 * @param holdingId Comma separated holdingId (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link HoldingSecuritiesResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getSecuritiesAsync(
			@Size(min = 0, max = 100, message = "{holdings.param.holdingId.length.invalid}") Long[] holdingId,
			ApiCallback<HoldingSecuritiesResponse> apiCallback) throws ApiException {
		LOGGER.info("Holdings getSecuritiesAsync API execution started");
		HoldingsValidator.validateGetSecurities(this, ApiUtils.getMethodName(), holdingId);
		CallContext callContext = buildGetSecuritiesContext(holdingId);
		callContext.getApiClient().executeAsync(callContext.getCall(), HoldingSecuritiesResponse.class, apiCallback);
	}

	private CallContext buildGetSecuritiesContext(Long[] holdingId) throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(ApiEndpoint.HOLDINGS_SECURITIES, HttpMethod.GET, null);
		if (holdingId != null) {
			apiContext.addQueryParam(new Pair(PARAM_HOLDING_ID, ApiUtils.convertArrayToString(holdingId)));
		}
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get Holding Type List The get holding types list service is used to get the supported holding types.<br>
	 * The response includes different holding types such as future, moneyMarketFund, stock, etc.<br>
	 * and it returns the supported holding types <br>
	 * 
	 * @return {@link ApiResponse}&lt;{@link HoldingTypeListResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<HoldingTypeListResponse> getHoldingTypeList() throws ApiException {
		LOGGER.info("Holdings getHoldingTypeList API execution started");
		HoldingsValidator.validateHoldingsContext(this);
		CallContext callContext = buildGetHoldingTypeListContext();
		return callContext.getApiClient().execute(callContext.getCall(), HoldingTypeListResponse.class);
	}

	/**
	 * Get Holding Type List The get holding types list service is used to get the supported holding types.<br>
	 * The response includes different holding types such as future, moneyMarketFund, stock, etc.<br>
	 * and it returns the supported holding types <br>
	 *
	 * @param apiCallback {@link ApiCallback}&lt;{@link HoldingTypeListResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getHoldingTypeListAsync(ApiCallback<HoldingTypeListResponse> apiCallback) throws ApiException {
		LOGGER.info("Holdings getHoldingTypeListAsync API execution started");
		HoldingsValidator.validateHoldingsContext(this);
		CallContext callContext = buildGetHoldingTypeListContext();
		callContext.getApiClient().executeAsync(callContext.getCall(), HoldingTypeListResponse.class, apiCallback);
	}

	private CallContext buildGetHoldingTypeListContext() throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(ApiEndpoint.HOLDINGS_TYPE_LIST, HttpMethod.GET, null);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Get Asset Classification List The get asset classifications list service is used to get the supported asset
	 * classifications. <br>
	 * The response includes different classification types like assetClass, country, sector, style, etc., <br>
	 * and the values corresponding to each type.<br>
	 * 
	 * @return {@link ApiResponse}&lt;{@link HoldingAssetClassificationListResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<HoldingAssetClassificationListResponse> getAssetClassificationList() throws ApiException {
		LOGGER.info("Holdings getAssetClassificationList API execution started");
		HoldingsValidator.validateHoldingsContext(this);
		CallContext callContext = buildGetAssetClassificationListContext();
		return callContext.getApiClient().execute(callContext.getCall(), HoldingAssetClassificationListResponse.class);
	}

	/**
	 * Get Asset Classification List The get asset classifications list service is used to get the supported asset
	 * classifications. <br>
	 * The response includes different classification types like assetClass, country, sector, style, etc., <br>
	 * and the values corresponding to each type.<br>
	 * 
	 * @param apiCallback {@link ApiCallback}&lt;{@link HoldingAssetClassificationListResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getAssetClassificationListAsync(ApiCallback<HoldingAssetClassificationListResponse> apiCallback)
			throws ApiException {
		LOGGER.info("Holdings getAssetClassificationListAsync API execution started");
		HoldingsValidator.validateHoldingsContext(this);
		CallContext callContext = buildGetAssetClassificationListContext();
		callContext.getApiClient().executeAsync(callContext.getCall(), HoldingAssetClassificationListResponse.class,
				apiCallback);
	}

	private CallContext buildGetAssetClassificationListContext() throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(ApiEndpoint.HOLDINGS_ASSET_CLASSIFICATION_LIST, HttpMethod.GET, null);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}
}
