/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.providers.enums;

public enum ProviderAuthParameter {
	/**
	 * Authorization code used to refer to authorization associated with a consent during open banking data retrieval. 
	 */
	authorizationCode,//
	/**
	 * OpenID Connect id_token represented as a JSON Web Token, representing an user's identification.
	 */
	idToken
}
