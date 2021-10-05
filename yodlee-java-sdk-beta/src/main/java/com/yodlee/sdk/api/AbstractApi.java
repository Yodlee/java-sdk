/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.client.ApiListener;
import com.yodlee.sdk.client.ProgressRequestBody.ProgressRequestListener;
import com.yodlee.sdk.client.ProgressResponseBody;
import com.yodlee.sdk.client.ProgressResponseBody.ProgressListener;
import com.yodlee.sdk.context.Context;
import okhttp3.Interceptor;
import okhttp3.Response;

public abstract class AbstractApi {

	protected Context<?> context;

	private final List<ApiListener> apiListeners = new CopyOnWriteArrayList<>();

	private final Map<String, String> requestHeaderMap = new HashMap<>();

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

	public boolean addRequestHeader(String headerKey, String headerValue) {
		if (headerKey == null || headerValue == null) {
			return false;
		}
		requestHeaderMap.put(headerKey, headerValue);
		return true;
	}

	public boolean removeRequestHeader(String headerkey) {
		if (headerkey == null) {
			return false;
		}
		requestHeaderMap.remove(headerkey);
		return true;
	}

	public void clearRequestHeaderMap() {
		requestHeaderMap.clear();
	}

	public String getRequestHeaderKey(String headerkey) {
		return requestHeaderMap.get(headerkey);
	}

	public Map<String, String> getRequestHeaderMap() {
		return Collections.unmodifiableMap(requestHeaderMap);
	}

	public void setRequestHeaderMap(Map<String, String> requestHeaderMap) {
		this.requestHeaderMap.clear();
		Set<Entry<String, String>> entrySet = requestHeaderMap.entrySet();
		for (Entry<String, String> entry : entrySet) {
			if (entry.getKey() == null || entry.getValue() == null) {
				continue;
			}
		}
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
		final ProgressListener progressListener =
				(bytesRead, contentLength, done) -> fireResponseUpdate(bytesRead, contentLength, done);
		Interceptor interceptor = new Interceptor() {

			@Override
			public Response intercept(Interceptor.Chain chain) throws IOException {
				Response originalResponse = chain.proceed(chain.request());
				return originalResponse.newBuilder()
						.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
			}
		};
		apiClient.registerNetworkInterceptor(interceptor);
	}

	protected ProgressRequestListener requestListener() {
		return (bytesWritten, contentLength, done) -> fireRequestUpdate(bytesWritten, contentLength, done);
	}

	protected String replacePathVariable(String endPoint, String pathVariable, String value) {
		Map<String, String> requestHeaderMap = getRequestHeaderMap();
		return endPoint.replaceAll("\\{" + pathVariable + "\\}",
				getContext().getApiClient(requestHeaderMap).escapeString(value));
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
