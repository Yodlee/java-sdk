/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.context;

import com.yodlee.sdk.api.ApiConstants;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.configuration.cobrand.AbstractBaseConfiguration;

public abstract class AbstractContext<T extends AbstractBaseConfiguration> implements Context<T> {

	protected abstract String getContextHeader();

	@Override
	public ApiClient getApiClient() {
		ApiClient apiClient = new ApiClient(this);
		T configuration = getConfiguration();
		apiClient.setBasePath(configuration.getBasePath());
		apiClient.addHeader(ApiConstants.API_VERSION, configuration.getApiVersion());
		apiClient.addHeader(ApiConstants.AUTHORIZATION, getContextHeader());
		if (configuration.getSocketTimeout() != null) {
			apiClient.setConnectTimeout(configuration.getSocketTimeout());
		}
		if (configuration.getReadTimeout() != null) {
			apiClient.setReadTimeout(configuration.getReadTimeout());
		}
		if (configuration.getWriteTimeout() != null) {
			apiClient.setWriteTimeout(configuration.getWriteTimeout());
		}
		return apiClient;
	}
}
