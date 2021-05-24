/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.context;

import com.yodlee.sdk.configuration.user.JWTUserConfiguration;

public class JWTUserContext extends AbstractJWTContext<JWTUserConfiguration> {

	private static final long serialVersionUID = 1L;

	public JWTUserContext(String jwtToken, JWTUserConfiguration jwtUserConfiguration) {
		super(jwtToken, jwtUserConfiguration);
	}

	@Override
	public ContextType getContextType() {
		return ContextType.USER;
	}
}
