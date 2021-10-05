/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api.validators;

import java.util.Date;
import java.util.List;
import com.yodlee.api.model.documents.enums.DocType;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.sdk.api.DocumentsApi;
import com.yodlee.sdk.api.exception.ApiException;

public class DocumentsValidator {

	private DocumentsValidator() {}

	public static void validateGetDocuments(DocumentsApi documentsApi, String methodName, String keyword,
			Long accountId, DocType docType, Date fromDate, Date toDate) throws ApiException {
		Class<?>[] argTypes = new Class[] {String.class, Long.class, DocType.class, Date.class, Date.class};
		Object[] argValues = new Object[] {keyword, accountId, docType, fromDate, toDate};
		List<Problem> methodProblems = ApiValidator.validate(documentsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(documentsApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}

	public static void validateDeleteOrDownloadDocument(DocumentsApi documentsApi, String methodName, String documentId)
			throws ApiException {
		Class<?>[] argTypes = new Class[] {String.class};
		Object[] argValues = new Object[] {documentId};
		List<Problem> methodProblems = ApiValidator.validate(documentsApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(documentsApi);
		ApiValidator.collectProblems(methodProblems, contextProblems);
	}
}
