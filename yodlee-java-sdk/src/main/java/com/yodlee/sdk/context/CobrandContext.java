/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.context;

import java.util.Map;
import com.yodlee.sdk.api.ApiConstants;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.configuration.cobrand.CobrandConfiguration;

public class CobrandContext extends AbstractContext<CobrandConfiguration> {

	private static final long serialVersionUID = 1L;

	private final String cobSession;

	private final CobrandConfiguration cobrandConfiguration;

	private final String contextHeader;

	private boolean autoRenew = false;

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
	public ApiClient getApiClient(Map<String, String> requestHeaderMap) {
		ApiClient apiClient = super.getApiClient(requestHeaderMap);
		apiClient.addHeader(ApiConstants.COBRAND_NAME, cobrandConfiguration.getName());
		return apiClient;
	}

	@Override
	public CobrandConfiguration getConfiguration() {
		return cobrandConfiguration;
	}

	@Override
	public boolean isAutoRenew() {
		return autoRenew;
	}

	@Override
	public void setAutoRenew(boolean autoRenew) {
		this.autoRenew = autoRenew;
	}

	public String getCobSession() {
		return cobSession;
	}
}
