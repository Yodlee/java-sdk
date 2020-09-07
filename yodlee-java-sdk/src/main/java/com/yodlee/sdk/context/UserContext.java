/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.context;

import java.util.Map;
import com.yodlee.sdk.api.ApiConstants;
import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.configuration.user.UserConfiguration;

public class UserContext extends AbstractContext<UserConfiguration> {

	private final String cobsession;

	private final String userSession;

	private final String contextHeader;

	private final UserConfiguration userConfiguration;

	private boolean autoRenew;

	public UserContext(String cobsession, String userSession, UserConfiguration userConfiguration) {
		super();
		this.cobsession = cobsession;
		this.userSession = userSession;
		contextHeader = String.format("{cobSession=%s},{userSession=%s}", cobsession, userSession);
		this.userConfiguration = userConfiguration;
	}

	@Override
	public ContextType getContextType() {
		return ContextType.USER;
	}

	public String getCobsession() {
		return cobsession;
	}

	public String getUserSession() {
		return userSession;
	}

	@Override
	public ApiClient getApiClient(Map<String, String> requestHeaderMap) {
		ApiClient apiClient = super.getApiClient(requestHeaderMap);
		apiClient.addHeader(ApiConstants.COBRAND_NAME, userConfiguration.getName());
		return apiClient;
	}

	protected String getContextHeader() {
		return contextHeader;
	}

	@Override
	public UserConfiguration getConfiguration() {
		return userConfiguration;
	}

	@Override
	public boolean isAutoRenew() {
		return autoRenew;
	}

	@Override
	public void setAutoRenew(boolean autoRenew) {
		this.autoRenew = autoRenew;
	}
}
