/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 * 
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
