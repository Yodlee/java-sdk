/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.saml;

import org.testng.annotations.Test;
import com.yodlee.sdk.context.Context;
import com.yodlee.sdk.context.UserContext;
import com.yodlee.sdk.test.ContextSerializationDeserilizationTest;

public class SAMLSerializationDeserializationTest {

	public static final String COBRAND_CONTEXT_SERIALIABLE_FILE =
			"\\ContextSerializable\\CobrandContextSerializable.txt";

	public static final String USER_CONTEXT_SERIALIABLE_FILE = "\\ContextSerializable\\UserContextSerializable.txt";

	public static final String COBRAND_CONTEXT_ERROR_MESSAGE = "Cobrand Context";

	public static final String USER_CONTEXT_ERROR_MESSAGE = "User Context";

	private Context<?> cobrandContext;

	private UserContext userContext;

	public SAMLSerializationDeserializationTest() {
		cobrandContext = AbstractSdkSAMLCobrandTestSuite.setup();
		userContext = AbstractSdkSAMLUserTestSuite.setup();
	}

	@Test(enabled = true)
	public void CobrandContextSerializeAndDeserializeTest() {
		ContextSerializationDeserilizationTest.contextSerializeAndDeserializeTest(cobrandContext,
				COBRAND_CONTEXT_SERIALIABLE_FILE, COBRAND_CONTEXT_ERROR_MESSAGE);
	}

	@Test(enabled = true)
	public void UserContextSerializeAndDeserializeTest() {
		ContextSerializationDeserilizationTest.contextSerializeAndDeserializeTest(userContext,
				USER_CONTEXT_SERIALIABLE_FILE, USER_CONTEXT_ERROR_MESSAGE);
	}
}
