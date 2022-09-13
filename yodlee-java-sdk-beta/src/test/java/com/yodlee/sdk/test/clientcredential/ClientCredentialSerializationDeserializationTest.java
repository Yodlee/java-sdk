/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.clientcredential;

import org.testng.annotations.Test;
import com.yodlee.sdk.context.ClientCredentialAdminContext;
import com.yodlee.sdk.context.ClientCredentialUserContext;
import com.yodlee.sdk.test.ContextSerializationDeserilizationTest;

public class ClientCredentialSerializationDeserializationTest {

	public static final String CLIENT_CREDENTIAL_APP_CONTEXT_SERIALIABLE_FILE =
			"\\ContextSerializable\\ClientCredentialAppContextSerializable.txt";

	public static final String CLIENT_CREDENTIAL_USER_CONTEXT_SERIALIABLE_FILE =
			"\\ContextSerializable\\ClientCredentialUserContextSerializable.txt";

	public static final String CLIENT_CREDENTIAL_APP_CONTEXT_ERROR_MESSAGE = "Client Credential App Context";

	public static final String CLIENT_CREDENTIAL_USER_CONTEXT_ERROR_MESSAGE = "Client Credential User Context";

	private ClientCredentialAdminContext clientCredentialAdminContext;

	private ClientCredentialUserContext clientCredentialUserContext;

	public ClientCredentialSerializationDeserializationTest() {
		clientCredentialAdminContext = AbstractSdkClientCredentialAppTestSuite.setup();
		clientCredentialUserContext = AbstractSdkClientCredentialUserTestSuite.setup();
	}

	@Test(enabled = true)
	public void ClientCredentialAppContextSerializeAndDeserializeTest() {
		ContextSerializationDeserilizationTest.contextSerializeAndDeserializeTest(clientCredentialAdminContext,
				CLIENT_CREDENTIAL_APP_CONTEXT_SERIALIABLE_FILE, CLIENT_CREDENTIAL_APP_CONTEXT_ERROR_MESSAGE);
	}

	@Test(enabled = true)
	public void ClientCredentialUserContextSerializeAndDeserializeTest() {
		ContextSerializationDeserilizationTest.contextSerializeAndDeserializeTest(clientCredentialUserContext,
				CLIENT_CREDENTIAL_USER_CONTEXT_SERIALIABLE_FILE, CLIENT_CREDENTIAL_USER_CONTEXT_ERROR_MESSAGE);
	}
}
