/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.builder;

/**
 * Factory to obtain various types of Context builders.
 * 
 *
 */
public class ContextBuilderFactory {

	private ContextBuilderFactory() {}

	/**
	 * This method is used to obtain JWT Cobrand Context builder which helps creating Cobrand Context(JWT Token).<br>
	 * JWT Cobrand Context can be used to invoke Cobrand bound APIs.
	 * 
	 * 
	 * @return The Cobrand JWT token context builder
	 */
	public static JWTAppContextBuilder createJWTAppContextBuilder() {
		return new JWTAppContextBuilder();
	}

	/**
	 * This method is used to obtain JWT User Context builder which helps creating User Context(JWT Token).<br>
	 * JWT User Context can be used to invoke any API.
	 * 
	 * @return The User JWT token context builder
	 */
	public static JWTUserContextBuilder createJWTUserContextBuilder() {
		return new JWTUserContextBuilder();
	}

	/**
	 * 
	 * 
	 * This method is used to obtain Cobrand Context builder which helps creating Cobrand Context(CobSession).<br>
	 * Cobrand Context can be used to invoke Cobrand bound APIs.
	 * 
	 * 
	 * @return The Cobrand context builder
	 */
	public static CobrandContextBuilder createCobrandContextBuilder() {
		return new CobrandContextBuilder();
	}

	/**
	 * This method is used to obtain User Context builder which helps creating User Context(CobSession and
	 * UserSession).<br>
	 * User Context can be used to invoke any API.
	 * 
	 * 
	 * @return The User JWT token context builder
	 */
	public static UserContextBuilder createUserContextBuilder() {
		return new UserContextBuilder();
	}

	public static ClientCredentialAdminContextBuilder createClientCredentialAdminContextBuilder() {
		return new ClientCredentialAdminContextBuilder();
	}
	
	public static ClientCredentialUserContextBuilder createClientCredentialUserContextBuilder() {
		return new ClientCredentialUserContextBuilder();
	}
}
