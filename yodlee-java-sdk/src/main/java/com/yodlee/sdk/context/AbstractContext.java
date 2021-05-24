/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.context;

import com.yodlee.sdk.api.ApiConstants;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.configuration.cobrand.AbstractBaseConfiguration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class AbstractContext<T extends AbstractBaseConfiguration> implements Context<T> {

	private static final long serialVersionUID = 1L;

	protected abstract String getContextHeader();

	@Override
	public ApiClient getApiClient(Map<String, String> requestHeaderMap) {
		ApiClient apiClient = new ApiClient(this);
		T configuration = getConfiguration();
		apiClient.setBasePath(configuration.getBasePath());
		apiClient.addHeader(ApiConstants.API_VERSION, configuration.getApiVersion());
		apiClient.addHeader(ApiConstants.AUTHORIZATION, getContextHeader());
		if (requestHeaderMap != null) {
			Set<Entry<String, String>> entrySet = requestHeaderMap.entrySet();
			for (Entry<String, String> headermap : entrySet) {
				if (headermap.getKey() != null && headermap.getValue() != null) {
					apiClient.addHeader(headermap.getKey(), headermap.getValue());
				}
			}
		}
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
