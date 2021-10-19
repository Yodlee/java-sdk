/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account.enums;

public enum AccountLatestBalanceFailedReason {
	/**
	 * The account related details are not available at the FI site.
	 */
	REQUIRED_DATA_NOT_AVAILABLE,//
	/**
	 * User input required for the site login.
	 */
	USER_INPUT_REQUIRED,//
	/**
	 * Login errors due to outdated credentials.
	 */
	CREDENTIALS_UPDATE_NEEDED,//
	/**
	 * Login errors due to incorrect credentials.
	 */
	INCORRECT_CREDENTIALS,//
	/**
	 * All errors that need a user action at the site.
	 */
	USER_ACTION_NEEDED_AT_SITE,//
	/**
	 * Additional MFA information needed at the site.
	 */
	ADDL_AUTHENTICATION_REQUIRED,//
	/**
	 * Invalid MFA information provided by the user.
	 */
	INVALID_ADDL_INFO_PROVIDED,//
	/**
	 * Account locked at the end site.
	 */
	ACCOUNT_LOCKED,//
	/**
	 * All errors where support is not available to complete the requested action.
	 */
	SITE_NOT_SUPPORTED,//
	/**
	 * Yodlee IP is blocked.
	 */
	SITE_BLOCKING_ERROR,//
	/**
	 * Technical error has occurred.
	 */
	TECH_ERROR,//
	/**
	 * All errors related to site issues such as site down for maintenance.
	 */
	UNEXPECTED_SITE_ERROR,//
	/**
	 * Site unavailable due to issue such as site down for maintenance.
	 */
	SITE_UNAVAILABLE,//
	/**
	 * Errors related to multiple sessions or session terminated by site.
	 */
	SITE_SESSION_INVALIDATED,//
	/**
	 * Request has timed out.
	 */
	REQUEST_TIME_OUT,//
	/**
	 * The site has informed to provide user-consent for aggregation.
	 */
	CONSENT_EXPIRED,//
	/**
	 * The site has informed that consent is revoked by the user for aggregation.
	 */
	CONSENT_REVOKED,//
	/**
	 * The site has informed that tokens provided are incorrect.
	 */
	INCORRECT_OAUTH_TOKEN,//
	/**
	 * The site has informed that user-consent is required.
	 */
	CONSENT_REQUIRED,//
	/**
	 * The site has requested for an OAuth authentication.
	 */
	NEW_AUTHENTICATION_REQUIRED;
}
