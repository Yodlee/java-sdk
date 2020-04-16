/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test;

import static org.testng.Assert.assertEquals;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.documents.enums.DocType;
import com.yodlee.api.model.documents.response.DocumentDownloadResponse;
import com.yodlee.api.model.documents.response.DocumentResponse;
import com.yodlee.sdk.api.DocumentsApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.test.utils.PrintUtil;

public class DocumentsApiSdkTest {

	public static void getDocumentsTest(DocumentsApi documentsApi, String testCaseId, String testCaseName,
			String keyword, String accountId, String docType, String fromDate, String toDate) {
		try {
			Long accountIdValue = StringUtils.isBlank(accountId) ? null : Long.valueOf(accountId);
			DocType docTypeValue = StringUtils.isBlank(docType) ? null : DocType.valueOf(docType);
			Date fromDateValue = StringUtils.isEmpty(fromDate) ? null : new Date(Long.parseLong(fromDate) * 1000L);
			Date toDateValue = StringUtils.isEmpty(toDate) ? null : new Date(Long.parseLong(toDate) * 1000L);
			ApiResponse<DocumentResponse> documents =
					documentsApi.getDocuments(keyword, accountIdValue, docTypeValue, fromDateValue, toDateValue);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, documents);
			assertEquals(documents.getStatusCode(), 200);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void downloadDocumentTest(DocumentsApi documentsApi, String testCaseId, String testCaseName,
			String documentId) {
		try {
			ApiResponse<DocumentDownloadResponse> document = documentsApi.downloadDocument(documentId);
			PrintUtil.printJSONResponse(testCaseId, testCaseName, document);
			assertEquals(document.getStatusCode(), 200);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
		
	}

	public static void deleteDocumentTest(DocumentsApi documentsApi, String testCaseId, String testCaseName,
			String documentId) {
		try {
			ApiResponse<AbstractModelComponent> deleteDocument = documentsApi.deleteDocument(documentId);
			assertEquals(deleteDocument.getStatusCode(), 204);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
		
	}
}
