/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
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
