/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
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
