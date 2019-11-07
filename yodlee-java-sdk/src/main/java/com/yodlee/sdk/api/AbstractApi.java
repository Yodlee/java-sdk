/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.client.ApiListener;
import com.yodlee.sdk.client.ProgressRequestBody.ProgressRequestListener;
import com.yodlee.sdk.client.ProgressResponseBody;
import com.yodlee.sdk.client.ProgressResponseBody.ProgressListener;
import com.yodlee.sdk.context.Context;

public abstract class AbstractApi {

	protected Context<?> context;

	private final List<ApiListener> apiListeners = new CopyOnWriteArrayList<>();

	public AbstractApi(Context<?> context) {
		super();
		this.context = context;
	}

	public Context<?> getContext() {
		return context;
	}

	public void setContext(Context<?> context) {
		this.context = context;
	}

	public boolean addApiListener(ApiListener listener) {
		if (listener == null) {
			return false;
		}
		return apiListeners.add(listener);
	}

	public boolean removeApiListener(ApiListener listener) {
		return apiListeners.remove(listener);
	}

	public void clearApiListeners() {
		apiListeners.clear();
	}

	protected void registerResponseInterceptor(final ApiClient apiClient) {
		final ProgressListener progressListener = new ProgressListener() {

			@Override
			public void update(long bytesRead, long contentLength, boolean done) {
				fireResponseUpdate(bytesRead, contentLength, done);
			}
		};
		com.squareup.okhttp.Interceptor interceptor = new com.squareup.okhttp.Interceptor() {

			@Override
			public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain)
					throws IOException {
				com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
				return originalResponse.newBuilder()
						.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
			}
		};
		apiClient.getHttpClient().networkInterceptors().add(interceptor);
	}

	protected ProgressRequestListener requestListener() {
		return new ProgressRequestListener() {

			@Override
			public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
				fireRequestUpdate(bytesWritten, contentLength, done);
			}
		};
	}

	protected String replacePathVariable(String endPoint, String pathVariable, String value) {
		return endPoint.replaceAll("\\{" + pathVariable + "\\}", getContext().getApiClient().escapeString(value));
	}

	private void fireResponseUpdate(long bytesRead, long contentLength, boolean done) {
		for (ApiListener apiListener : apiListeners) {
			apiListener.responseUpdate(bytesRead, contentLength, done);
		}
	}

	private void fireRequestUpdate(long bytesWritten, long contentLength, boolean done) {
		for (ApiListener apiListener : apiListeners) {
			apiListener.requestUpdate(bytesWritten, contentLength, done);
		}
	}
}
