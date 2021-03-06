/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.context;

import com.yodlee.sdk.configuration.cobrand.JWTAppConfiguration;

public class JWTAppContext extends AbstractJWTContext<JWTAppConfiguration> {

	private static final long serialVersionUID = 1L;

	public JWTAppContext(String jwtToken, JWTAppConfiguration jwtAppConfiguration) {
		super(jwtToken, jwtAppConfiguration);
	}

	@Override
	public ContextType getContextType() {
		return ContextType.COBRAND;
	}
}
