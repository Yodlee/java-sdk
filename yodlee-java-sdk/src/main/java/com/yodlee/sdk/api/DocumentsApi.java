/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.documents.enums.DocType;
import com.yodlee.api.model.documents.response.DocumentDownloadResponse;
import com.yodlee.api.model.documents.response.DocumentResponse;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;
import com.yodlee.sdk.api.validators.DocumentsValidator;
import com.yodlee.sdk.client.ApiCallback;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.client.ApiContext;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.client.CallContext;
import com.yodlee.sdk.client.HttpMethod;
import com.yodlee.sdk.client.Pair;
import com.yodlee.sdk.context.Context;
import okhttp3.Call;

public class DocumentsApi extends AbstractApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(DocumentsApi.class);

	private static final String PARAM_KEYWORD = "Keyword";

	private static final String PARAM_ACCOUNT_ID = "accountId";

	private static final String PARAM_DOC_TYPE = "docType";

	private static final String PARAM_FROM_DATE = "fromDate";

	private static final String PARAM_TO_DATE = "toDate";

	private static final String PARAM_DOCUMENT_ID = "documentId";

	public DocumentsApi(Context<?> context) {
		super(context);
	}

	/**
	 * Get Documents The get documents service allows customers to search or retrieve metadata related to documents.
	 * <br>
	 * The API returns the document as per the input parameters passed. If no date range is provided then all downloaded
	 * <br>
	 * documents will be retrieved. Details of deleted documents or documents associated to closed providerAccount will
	 * not be returned <br>
	 * This API is a premium service which requires subscription in advance to use. Please contact Yodlee Client Services for more information.<br>
	 * 
	 * @param keyword The string used to search a document by its name. (optional)
	 * @param accountId The unique identifier of an account. Retrieve documents for a given accountId. (optional)
	 * @param docType Accepts only one of the following valid document types: STMT, TAX, and EBILL. (optional)
	 * @param fromDate The date from which documents have to be retrieved. (optional)
	 * @param toDate The date to which documents have to be retrieved. (optional)
	 * @return {@link ApiResponse}&lt;{@link DocumentResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public ApiResponse<DocumentResponse> getDocuments(String keyword,//
			@Digits(integer = 11, fraction = 0, message = "{documents.param.accountId.invalid}")//
			@Min(value = 1, message = "{documents.param.accountId.invalid}") Long accountId,//
			DocType docType, //
			Date fromDate,//
			Date toDate) throws ApiException {
		LOGGER.info("Documents getDocuments API execution started");
		DocumentsValidator.validateGetDocuments(this, ApiUtils.getMethodName(), keyword, accountId, docType, fromDate,
				toDate);
		CallContext callContext = buildGetDocumentsContext(keyword, accountId, docType, fromDate, toDate);
		return callContext.getApiClient().execute(callContext.getCall(), DocumentResponse.class);
	}

	/**
	 * Get Documents The get documents service allows customers to search or retrieve metadata related to documents.
	 * <br>
	 * The API returns the document as per the input parameters passed. If no date range is provided then all downloaded
	 * <br>
	 * documents will be retrieved. Details of deleted documents or documents associated to closed providerAccount will
	 * not be returned <br>
	 * This API is a premium service which requires subscription in advance to use. Please contact Yodlee Client Services for more information. <br>
	 * 
	 * @param keyword The string used to search a document by its name. (optional)
	 * @param accountId The unique identifier of an account. Retrieve documents for a given accountId. (optional)
	 * @param docType Accepts only one of the following valid document types: STMT, TAX, and EBILL. (optional)
	 * @param fromDate The date from which documents have to be retrieved. (optional)
	 * @param toDate The date to which documents have to be retrieved. (optional)
	 * @param apiCallback {@link ApiCallback}&lt;{@link DocumentResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 *         response body
	 */
	public void getDocumentsAsync(String keyword,//
			@Digits(integer = 11, fraction = 0, message = "{documents.param.accountId.invalid}") //
			@Min(value = 1, message = "{documents.param.accountId.invalid}") Long accountId,//
			DocType docType,//
			Date fromDate,//
			Date toDate,//
			ApiCallback<DocumentResponse> apiCallback) throws ApiException {
		LOGGER.info("Documents getDocumentsAsync API execution started");
		DocumentsValidator.validateGetDocuments(this, ApiUtils.getMethodName(), keyword, accountId, docType, fromDate,
				toDate);
		CallContext callContext = buildGetDocumentsContext(keyword, accountId, docType, fromDate, toDate);
		callContext.getApiClient().executeAsync(callContext.getCall(), DocumentResponse.class, apiCallback);
	}

	private CallContext buildGetDocumentsContext(String keyword, Long accountId, DocType docType, Date fromDate,
			Date toDate) throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		ApiContext apiContext = new ApiContext(ApiEndpoint.DOCUMENTS, HttpMethod.GET, null);
		SimpleDateFormat formatter = new SimpleDateFormat(ApiConstants.YYYY_MM_DD);
		if (!StringUtils.isBlank(keyword)) {
			apiContext.addQueryParam(new Pair(PARAM_KEYWORD, keyword));
		}
		if (accountId != null) {
			apiContext.addQueryParam(new Pair(PARAM_ACCOUNT_ID, accountId.toString()));
		}
		if (docType != null) {
			apiContext.addQueryParam(new Pair(PARAM_DOC_TYPE, docType.name()));
		}
		if (fromDate != null) {
			String formattedFromDate = formatter.format(fromDate);
			apiContext.addQueryParam(new Pair(PARAM_FROM_DATE, formattedFromDate));
		}
		if (toDate != null) {
			String formattedToDate = formatter.format(toDate);
			apiContext.addQueryParam(new Pair(PARAM_TO_DATE, formattedToDate));
		}
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Download a Document The get document details service allows consumers to download a document. The document is
	 * provided in base64.<br>
	 * Documents can be downloaded only if the document related dataset attributes are subscribed. <br>
	 * 
	 * @param documentId documentId (required)
	 * @return {@link ApiResponse}&lt;{@link DocumentDownloadResponse}&gt;
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 */
	public ApiResponse<DocumentDownloadResponse> downloadDocument(
			@NotNull(message = "{documents.param.documentId.required}") String documentId) throws ApiException {
		LOGGER.info("Documents downloadDocument API execution started");
		DocumentsValidator.validateDeleteOrDownloadDocument(this, ApiUtils.getMethodName(), documentId);
		CallContext callContext = buildDownloadDocumentContext(documentId);
		return callContext.getApiClient().execute(callContext.getCall(), DocumentDownloadResponse.class);
	}

	/**
	 * Download a Document The get document details service allows consumers to download a document. The document is
	 * provided in base64.<br>
	 * Documents can be downloaded only if the document related dataset attributes are subscribed. <br>
	 * 
	 * @param documentId documentId (required)
	 * @param apiCallback {@link ApiCallback}&lt;{@link DocumentDownloadResponse}&gt; (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 */
	public void downloadDocumentAsync(@NotNull(message = "{documents.param.documentId.required}") String documentId,
			ApiCallback<DocumentDownloadResponse> apiCallback) throws ApiException {
		LOGGER.info("Documents downloadDocumentAsync API execution started");
		DocumentsValidator.validateDeleteOrDownloadDocument(this, ApiUtils.getMethodName(), documentId);
		CallContext callContext = buildDownloadDocumentContext(documentId);
		callContext.getApiClient().executeAsync(callContext.getCall(), DocumentDownloadResponse.class, apiCallback);
	}

	private CallContext buildDownloadDocumentContext(String documentId) throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		String endpoint = replacePathVariable(ApiEndpoint.DOCUMENTS_WITH_ID, PARAM_DOCUMENT_ID, documentId);
		ApiContext apiContext = new ApiContext(endpoint, HttpMethod.GET, null);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}

	/**
	 * Delete Document The delete document service allows the consumer to delete a document. The deleted <br>
	 * document will not be returned in the get documents API. The HTTP response code is 204 (success without
	 * content).<br>
	 * Documents can be deleted only if the document related dataset attributes are subscribed.<br>
	 * 
	 * @param documentId documentId (required)
	 * @return null
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 */
	public ApiResponse<AbstractModelComponent> deleteDocument(//
			@NotNull(message = "{documents.param.documentId.required}") String documentId) throws ApiException {
		LOGGER.info("Documents deleteDocument API execution started");
		DocumentsValidator.validateDeleteOrDownloadDocument(this, ApiUtils.getMethodName(), documentId);
		CallContext callContext = buildDeleteDocumentContext(documentId);
		return callContext.getApiClient().execute(callContext.getCall(), null);
	}

	/**
	 * Delete Document The delete document service allows the consumer to delete a document. The deleted <br>
	 * document will not be returned in the get documents API. The HTTP response code is 204 (success without
	 * content).<br>
	 * Documents can be deleted only if the document related dataset attributes are subscribed.<br>
	 * 
	 * @param documentId documentId (required)
	 * @param apiCallback {@link ApiCallback} (required)
	 * @throws ApiException If the input validation fails or API call fails, e.g. server error or cannot deserialize the
	 */
	public void deleteDocumentAsync(//
			@NotNull(message = "{documents.param.documentId.required}") String documentId,//
			ApiCallback<AbstractModelComponent> apiCallback) throws ApiException {
		LOGGER.info("Documents deleteDocumentAsync API execution started");
		DocumentsValidator.validateDeleteOrDownloadDocument(this, ApiUtils.getMethodName(), documentId);
		CallContext callContext = buildDeleteDocumentContext(documentId);
		callContext.getApiClient().executeAsync(callContext.getCall(), apiCallback);
	}

	private CallContext buildDeleteDocumentContext(String documentId) throws ApiException {
		ApiClient apiClient = getContext().getApiClient();
		String endpoint = replacePathVariable(ApiEndpoint.DOCUMENTS_WITH_ID, PARAM_DOCUMENT_ID, documentId);
		ApiContext apiContext = new ApiContext(endpoint, HttpMethod.DELETE, null);
		registerResponseInterceptor(apiClient);
		Call call = apiClient.buildCall(apiContext, requestListener());
		return new CallContext(apiClient, call);
	}
}
