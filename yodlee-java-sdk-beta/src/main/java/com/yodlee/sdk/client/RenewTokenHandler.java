/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yodlee.sdk.api.ApiConstants;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.builder.ContextBuilderFactory;
import com.yodlee.sdk.builder.JWTAppContextBuilder;
import com.yodlee.sdk.builder.JWTUserContextBuilder;
import com.yodlee.sdk.builder.ClientCredentialAdminContextBuilder;
import com.yodlee.sdk.builder.ClientCredentialUserContextBuilder;
import com.yodlee.sdk.configuration.cobrand.JWTAppConfiguration;
import com.yodlee.sdk.configuration.cobrand.ClientCredentialAdminConfiguration;
import com.yodlee.sdk.configuration.user.JWTUserConfiguration;
import com.yodlee.sdk.configuration.user.ClientCredentialUserConfiguration;
import com.yodlee.sdk.context.AbstractJWTContext;
import com.yodlee.sdk.context.AbstractClientCredentialContext;
import com.yodlee.sdk.context.Context;
import com.yodlee.sdk.context.JWTAppContext;
import com.yodlee.sdk.context.JWTUserContext;
import com.yodlee.sdk.context.ClientCredentialAdminContext;
import com.yodlee.sdk.context.ClientCredentialUserContext;

public class RenewTokenHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(RenewTokenHandler.class);

	private RenewTokenHandler() {}

	public static void checkAndRenewToken(Context<?> context) {
		try {
			if (context instanceof JWTAppContext && isJWTTokenExpired((JWTAppContext) context)) {
				handleJWTAppContextRenewal(context);
			} else if (context instanceof JWTUserContext && isJWTTokenExpired((JWTUserContext) context)) {
				handleJWTUserContextRenewal(context);
			} else if (context instanceof ClientCredentialAdminContext
					&& isClientCredentialTokenExpired((ClientCredentialAdminContext) context)) {
				handleClientCredentialAppContextRenewal(context);
			} else if (context instanceof ClientCredentialUserContext
					&& isClientCredentialTokenExpired((ClientCredentialUserContext) context)) {
				handleClientCredentialUserContextRenewal(context);
			}
		} catch (ApiException e) {
			LOGGER.error("Exception occurred while renewing token", e);
		}
	}

	private static boolean isJWTTokenExpired(AbstractJWTContext<?> jwtContext) {
		DecodedJWT jwtToken = JWT.decode(jwtContext.getJwtToken());
		return jwtToken.getExpiresAt().before(new Date());
	}

	private static void handleJWTAppContextRenewal(Context<?> context) throws ApiException {
		JWTAppContextBuilder jwtAppContextBuilder = ContextBuilderFactory.createJWTAppContextBuilder();
		JWTAppContext renewedJWTContext = jwtAppContextBuilder.build((JWTAppConfiguration) context.getConfiguration());
		JWTAppContext originalContext = (JWTAppContext) context;
		originalContext.setJwtToken(renewedJWTContext.getJwtToken());
	}

	private static void handleJWTUserContextRenewal(Context<?> context) throws ApiException {
		JWTUserContextBuilder jwtAppContextBuilder = ContextBuilderFactory.createJWTUserContextBuilder();
		JWTUserContext renewedJWTContext =
				jwtAppContextBuilder.build((JWTUserConfiguration) context.getConfiguration());
		JWTUserContext originalContext = (JWTUserContext) context;
		originalContext.setJwtToken(renewedJWTContext.getJwtToken());
	}

	private static void handleClientCredentialAppContextRenewal(Context<?> context) throws ApiException {
		ClientCredentialAdminContextBuilder clientCredentialAppContextBuilder =
				ContextBuilderFactory.createClientCredentialAdminContextBuilder();
		ClientCredentialAdminContext renewedClientCredentialContext = clientCredentialAppContextBuilder
				.build((ClientCredentialAdminConfiguration) context.getConfiguration());
		ClientCredentialAdminContext originalContext = (ClientCredentialAdminContext) context;
		updateClientCredentialContextValues(renewedClientCredentialContext, originalContext);
	}

	private static void handleClientCredentialUserContextRenewal(Context<?> context) throws ApiException {
		ClientCredentialUserContextBuilder clientCredentialAppContextBuilder =
				ContextBuilderFactory.createClientCredentialUserContextBuilder();
		ClientCredentialUserContext renewedClientCredentialContext =
				clientCredentialAppContextBuilder.build((ClientCredentialUserConfiguration) context.getConfiguration());
		ClientCredentialUserContext originalContext = (ClientCredentialUserContext) context;
		updateClientCredentialContextValues(renewedClientCredentialContext, originalContext);
	}

	private static void updateClientCredentialContextValues(
			AbstractClientCredentialContext<?> renewedClientCredentialContext,
			AbstractClientCredentialContext<?> originalContext) {
		originalContext.setAccessToken(renewedClientCredentialContext.getAccessToken());
		originalContext.setIssuedAt(renewedClientCredentialContext.getIssuedAt());
		originalContext.setExpiresIn(renewedClientCredentialContext.getExpiresIn());
	}

	private static boolean
			isClientCredentialTokenExpired(final AbstractClientCredentialContext<?> clientCredentialContext) {
		final Calendar currentTime = Calendar.getInstance();
		final String issuedAt = clientCredentialContext.getIssuedAt();
		final int expiresIn = clientCredentialContext.getExpiresIn();
		final SimpleDateFormat sdf = new SimpleDateFormat(ApiConstants.YYYY_MM_DD_T_HH_MM_SS_Z);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		try {
			final Date parsedDate = sdf.parse(issuedAt);
			final long timeInMillis = parsedDate.getTime();
			final long checkForExpiry = timeInMillis + expiresIn * ApiConstants.THOUSAND_MILLIS;
			final Calendar expiryTime = Calendar.getInstance();
			expiryTime.setTimeInMillis(checkForExpiry);
			return currentTime.after(expiryTime);
		} catch (ParseException pe) {}
		return false;
	}
}
