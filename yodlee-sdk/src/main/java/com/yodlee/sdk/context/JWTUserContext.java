/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.context;

import com.yodlee.sdk.configuration.user.JWTUserConfiguration;

public class JWTUserContext extends AbstractJWTContext<JWTUserConfiguration> {

	public JWTUserContext(String jwtToken, JWTUserConfiguration jwtUserConfiguration) {
		super(jwtToken, jwtUserConfiguration);
	}

	@Override
	public ContextType getContextType() {
		return ContextType.USER;
	}
}
