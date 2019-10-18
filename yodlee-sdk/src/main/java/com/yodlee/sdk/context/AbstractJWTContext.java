/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.context;

import com.yodlee.sdk.configuration.cobrand.AbstractJWTConfiguration;

public abstract class AbstractJWTContext<C extends AbstractJWTConfiguration> extends AbstractContext<C> {

	protected final C configuration;

	protected String jwtToken;

	private String contextHeader;

	private boolean autoRenewToken;

	public AbstractJWTContext(String jwtToken, C configuration) {
		super();
		this.jwtToken = jwtToken;
		this.configuration = configuration;
		this.autoRenewToken = true;
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

	public boolean isAutoRenewToken() {
		return autoRenewToken;
	}

	public void setAutoRenewToken(boolean autoRenewToken) {
		this.autoRenewToken = autoRenewToken;
	}

	private void updateContextHeader(String jwtToken) {
		contextHeader = String.format("Bearer %s", jwtToken);
	}
}
