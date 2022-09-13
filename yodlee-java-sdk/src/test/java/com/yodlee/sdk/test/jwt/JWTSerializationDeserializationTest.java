/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.jwt;

import org.testng.annotations.Test;
import com.yodlee.sdk.context.JWTAppContext;
import com.yodlee.sdk.context.JWTUserContext;
import com.yodlee.sdk.test.ContextSerializationDeserilizationTest;

public class JWTSerializationDeserializationTest {

	public static final String JWT_COBRAND_CONTEXT_SERIALIABLE_FILE =
			"\\ContextSerializable\\JWTCobrandContextSerializable.txt";

	public static final String JWT_USER_CONTEXT_SERIALIABLE_FILE =
			"\\ContextSerializable\\JWTUserContextSerializable.txt";

	public static final String JWT_COBRAND_CONTEXT_ERROR_MESSAGE = "JWT Cobrand Context";

	public static final String JWT_USER_CONTEXT_ERROR_MESSAGE = "JWT User Context";

	private JWTAppContext jwtAppContext;

	private JWTUserContext jwtUserContext;

	public JWTSerializationDeserializationTest() {
		jwtAppContext = AbstractSdkJWTCobrandTestSuite.setup();
		jwtUserContext = AbstractSdkJWTUserTestSuite.setup();
	}

	@Test(enabled = true)
	public void JWTCobrandContextSerializeAndDeserializeTest() {
		ContextSerializationDeserilizationTest.contextSerializeAndDeserializeTest(jwtAppContext,
				JWT_COBRAND_CONTEXT_SERIALIABLE_FILE, JWT_COBRAND_CONTEXT_ERROR_MESSAGE);
	}

	@Test(enabled = true)
	public void JWTUserContextSerializeAndDeserializeTest() {
		ContextSerializationDeserilizationTest.contextSerializeAndDeserializeTest(jwtUserContext,
				JWT_USER_CONTEXT_SERIALIABLE_FILE, JWT_USER_CONTEXT_ERROR_MESSAGE);
	}
}
