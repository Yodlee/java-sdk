/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.providers.enums;

public enum ProviderAuthenticationType {
	/**
	 * The site that supports open authentication
	 */
	OAUTH,//
	/**
	 * The authentication system of the site expects only credentials like userId, password, customer id, etc
	 */
	CREDENTIALS,//
	/**
	 * Multifactor authentication is implemented at the provider site
	 */
	MFA_CREDENTIALS
}
