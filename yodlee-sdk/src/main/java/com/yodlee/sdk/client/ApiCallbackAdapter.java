/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.client;

import java.util.List;
import java.util.Map;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.sdk.api.exception.ApiException;

public class ApiCallbackAdapter<T extends AbstractModelComponent> implements ApiCallback<T> {

	@Override
	public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
		/**
		 * Adaptor Method
		 */
	}

	@Override
	public void onSuccess(T result, int statusCode, Map<String, List<String>> responseHeaders) {
		/**
		 * Adaptor Method
		 */
	}

	@Override
	public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
		/**
		 * Adaptor Method
		 */
	}

	@Override
	public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
		/**
		 * Adaptor Method
		 */
	}
}
