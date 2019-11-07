/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.sdk.client;

import com.squareup.okhttp.Call;

public class CallContext {

	private final ApiClient apiClient;

	private final Call call;

	public CallContext(ApiClient apiClient, Call call) {
		super();
		this.apiClient = apiClient;
		this.call = call;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public Call getCall() {
		return call;
	}
}
