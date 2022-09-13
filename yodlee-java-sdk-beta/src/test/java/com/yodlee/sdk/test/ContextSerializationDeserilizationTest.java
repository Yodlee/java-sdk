/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test;

import static org.testng.Assert.assertTrue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.yodlee.sdk.configuration.AbstractConfiguration;
import com.yodlee.sdk.configuration.cobrand.AbstractClientCredentialConfiguration;
import com.yodlee.sdk.configuration.cobrand.AbstractCobrandConfiguration;
import com.yodlee.sdk.configuration.cobrand.AbstractJWTConfiguration;
import com.yodlee.sdk.context.Context;
import com.yodlee.sdk.test.utils.PrintUtil;

public class ContextSerializationDeserilizationTest {

	@SuppressWarnings("resource")
	public static void contextSerializeAndDeserializeTest(Context<?> context, String contextFileName, String message) {
		Path resourceDirectory = Paths.get("src", "test", "resources");
		String absolutePath = resourceDirectory.toFile().getAbsolutePath();
		String contextFilePath = absolutePath + contextFileName;
		try (FileOutputStream fileOutputStream = new FileOutputStream(contextFilePath);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {
			objectOutputStream.writeObject(context);
			FileInputStream fileInputStream = new FileInputStream(contextFilePath);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			try {
				Context<?> inputContext = (Context<?>) objectInputStream.readObject();
				AbstractConfiguration abstractConfiguration = inputContext.getConfiguration();
				assertTrue(validateDeserializedObject(abstractConfiguration));
			} catch (ClassNotFoundException e) {
				PrintUtil.assertFail("", message + " Class", e);
			}
		} catch (FileNotFoundException e) {
			PrintUtil.assertFail("", message + " Serialization", e);
		} catch (IOException e) {
			PrintUtil.assertFail("", message + " Serialization File Loading", e);
		}
	}

	private static Boolean validateDeserializedObject(AbstractConfiguration abstractConfiguration) {
		Class<? extends AbstractConfiguration> contextClass = abstractConfiguration.getClass();
		String className = contextClass.getSimpleName();
		if (className.contains("ClientCredential")) {
			validateClientCredentialContext(abstractConfiguration);
		} else if (className.contains("JWT")) {
			validateJWTContext(abstractConfiguration);
		} else {
			validateSAMLContext(abstractConfiguration);
		}
		return true;
	}

	private static void validateClientCredentialContext(AbstractConfiguration abstractConfiguration) {
		AbstractClientCredentialConfiguration abstractClientCredentialConfiguration =
				(AbstractClientCredentialConfiguration) abstractConfiguration;
		String clientId = abstractClientCredentialConfiguration.getClientId();
		String secret = abstractClientCredentialConfiguration.getSecret();
		String loginName = abstractClientCredentialConfiguration.getLoginName();
		assertTrue(!clientId.isEmpty());
		assertTrue(!secret.isEmpty());
		assertTrue(!loginName.isEmpty());
	}

	private static void validateJWTContext(AbstractConfiguration abstractConfiguration) {
		AbstractJWTConfiguration abstractJWTConfiguration = (AbstractJWTConfiguration) abstractConfiguration;
		String apiKey = abstractJWTConfiguration.getApiKey();
		String privateKey = abstractJWTConfiguration.getPrivateKey();
		assertTrue(!apiKey.isEmpty());
		assertTrue(!privateKey.isEmpty());
	}

	private static void validateSAMLContext(AbstractConfiguration abstractConfiguration) {
		AbstractCobrandConfiguration abstractCobrandConfiguration =
				(AbstractCobrandConfiguration) abstractConfiguration;
		String cobrandName = abstractCobrandConfiguration.getName();
		String loginName = abstractCobrandConfiguration.getLoginName();
		String password = abstractCobrandConfiguration.getPassword();
		assertTrue(!cobrandName.isEmpty());
		assertTrue(!loginName.isEmpty());
		assertTrue(!password.isEmpty());
	}
}
