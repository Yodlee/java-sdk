/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.context;

import com.yodlee.sdk.api.ApiConstants;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.configuration.cobrand.CobrandConfiguration;

public class CobrandContext extends AbstractContext<CobrandConfiguration> {

	private final String cobSession;

	private final CobrandConfiguration cobrandConfiguration;

	private final String contextHeader;

	public CobrandContext(String cobSession, CobrandConfiguration cobrandConfiguration) {
		this.cobSession = cobSession;
		this.cobrandConfiguration = cobrandConfiguration;
		contextHeader = String.format("{cobSession=%s}", cobSession);
	}

	@Override
	public ContextType getContextType() {
		return ContextType.COBRAND;
	}

	protected String getContextHeader() {
		return contextHeader;
	}

	@Override
	public ApiClient getApiClient() {
		ApiClient apiClient = super.getApiClient();
		apiClient.addHeader(ApiConstants.COBRAND_NAME, cobrandConfiguration.getName());
		return apiClient;
	}

	@Override
	public CobrandConfiguration getConfiguration() {
		return cobrandConfiguration;
	}

	public String getCobSession() {
		return cobSession;
	}
}
