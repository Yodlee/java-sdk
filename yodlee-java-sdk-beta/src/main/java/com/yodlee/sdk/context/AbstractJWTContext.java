/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.context;

import com.yodlee.sdk.configuration.cobrand.AbstractJWTConfiguration;

public abstract class AbstractJWTContext<C extends AbstractJWTConfiguration> extends AbstractContext<C> {

	private static final long serialVersionUID = 1L;

	protected final C configuration;

	protected String jwtToken;

	private String contextHeader;

	private boolean autoRenew = true;

	public AbstractJWTContext(String jwtToken, C configuration) {
		super();
		this.jwtToken = jwtToken;
		this.configuration = configuration;
		this.autoRenew = true;
		updateContextHeader(jwtToken);
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
		updateContextHeader(jwtToken);
	}

	protected String getContextHeader() {
		return contextHeader;
	}

	@Override
	public C getConfiguration() {
		return configuration;
	}

	public boolean isAutoRenew() {
		return autoRenew;
	}

	public void setAutoRenew(boolean autoRenewToken) {
		this.autoRenew = autoRenewToken;
	}

	private void updateContextHeader(String jwtToken) {
		contextHeader = String.format("Bearer %s", jwtToken);
	}
}
