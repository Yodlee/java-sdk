/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.builder;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.impl.PublicClaims;

public class JWTUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(JWTUtil.class);

	private JWTUtil() {}

	/**
	 * Description: Generates the JWT token which will be valid for provide time.
	 * 
	 * @param jwtKey - JWT Key is the issuer id (iss)
	 * @param privateKeyString - The key used to generate the JWT Token along with JWT Key
	 * @param userName - The sub field used to identify the user. For App Context this is null.
	 * @param expiresIn - The duration in seconds for which the generated JWT token is valid
	 * @param locale - The locale for the token
	 * @return jwtToken - The generated JWT token
	 */
	public static String getJWTToken(String jwtKey, String privateKeyString, String userName, int expiresIn,
			String locale) {
		// SIGNING the token
		PrivateKey privateKey = null;
		try {
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			byte[] content = privateKeyString.getBytes();
			String pkcs8Pem = new String(content, StandardCharsets.UTF_8);
			byte[] pkcs8EncodedBytes = org.apache.commons.codec.binary.Base64.decodeBase64(pkcs8Pem);
			KeyFactory factory = KeyFactory.getInstance("RSA");
			PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(pkcs8EncodedBytes);
			privateKey = factory.generatePrivate(privKeySpec);
		} catch (NoSuchAlgorithmException e) {
			String msg =
					String.format("Error while generating JWT token (NoSuchAlgorithmException) : %s", e.getMessage());
			LOGGER.error(msg);
		} catch (InvalidKeySpecException e) {
			String msg = String.format("Error while generating JWT token (Private Key - InvalidKeySpecException) : %s",
					e.getMessage());
			LOGGER.error(msg);
		}
		// Generating signed JWT Token
		Algorithm algo = Algorithm.RSA512(null, (RSAPrivateKey) privateKey);
		Long expiryTime = System.currentTimeMillis() + (expiresIn * 1000);
		Date today = new Date();
		return JWT.create().withIssuer(jwtKey).withClaim(PublicClaims.ISSUED_AT, today)
				.withClaim(PublicClaims.EXPIRES_AT, new Date(expiryTime)).withSubject(userName)
				.withClaim("locale", locale).sign(algo);
	}
}
