/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.context;

import com.yodlee.sdk.configuration.cobrand.AbstractClientCredentialConfiguration;

public abstract class AbstractClientCredentialContext<C extends AbstractClientCredentialConfiguration>
		extends AbstractContext<C> {

	private String accessToken;

	private String issuedAt;

	private int expiresIn;

	private String contextHeader;

	private final C clientCredentialConfiguration;

	private boolean autoRenew;

	public AbstractClientCredentialContext(String accessToken, String issuedAt, int expiresIn,
			C clientCredentialConfiguration) {
		this.clientCredentialConfiguration = clientCredentialConfiguration;
		this.accessToken = accessToken;
		this.issuedAt = issuedAt;
		this.expiresIn = expiresIn;
		this.autoRenew = true;
		updateContextHeader(accessToken);
	}

	@Override
	public ContextType getContextType() {
		return ContextType.COBRAND;
	}

	@Override
	public C getConfiguration() {
		return clientCredentialConfiguration;
	}

	@Override
	protected String getContextHeader() {
		return contextHeader;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(String issuedAt) {
		this.issuedAt = issuedAt;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	private void updateContextHeader(String accessToken) {
		contextHeader = String.format("Bearer %s", accessToken);
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
