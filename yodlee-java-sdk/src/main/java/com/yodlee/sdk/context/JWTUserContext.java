/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
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
