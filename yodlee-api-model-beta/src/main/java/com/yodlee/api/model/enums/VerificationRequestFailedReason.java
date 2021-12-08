/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.enums;

public enum VerificationRequestFailedReason {
	/**
	 * <b>Description: </b>The account is locked at the provider site. The user has exceeded the maximum number of
	 * incorrect login attempts resulting in the account getting locked. <br>
	 * <b>Next Action: </b>Instruct the user to visit the provider site and take necessary actions to unlock the account
	 */
	ACCOUNT_LOCKED,
	//
	//
	/**
	 * 
	 * <b>Description: </b> <br>
	 * <b>Next Action: </b>
	 */
	ADDL_AUTHENTICATION_REQUIRED, //
	//
	//
	/**
	 * <b>Description: </b>Unable to log in to the provider site due to out-dated credentials. The site may be prompting
	 * the user to change or verify the credentials. <br>
	 * <b>Next Action: </b>Instruct the user to visit the provider site and perform the required actions, and invoke the
	 * edit account flow to update the credentials in the Yodlee system
	 */
	CREDENTIALS_UPDATE_NEEDED,
	//
	//
	/**
	 * 
	 * <b>Description: </b>Unable to log in to the provider site due to incorrect credentials. The credentials that the
	 * user has provided are incorrect. <br>
	 * <b>Next Action: </b>Instruct the user to provide the correct credentials by invoking the edit account flow.
	 */
	INCORRECT_CREDENTIALS, //
	//
	//
	/**
	 * 
	 * <b>Description: </b>The user has provided incorrect MFA information or the MFA information provided has expired.
	 * <br>
	 * <b>Next Action: </b>Instruct the user to provide the correct MFA information
	 */
	INVALID_ADDL_INFO_PROVIDED,
	//
	//
	/**
	 * 
	 * <b>Description: </b>The request has timed-out due to technical reasons. <br>
	 * <b>Next Action: </b>Instruct the user to try again later. If the request fails repeatedly, report the issue to
	 * the customer service team
	 */
	REQUEST_TIME_OUT,
	//
	//
	/**
	 * 
	 * <b>Description: </b>The Yodlee IP is blocked by the provider site. <br>
	 * <b>Next Action: </b>Instruct the user to try again later. If the request fails repeatedly, report the issue to
	 * the customer service team
	 */
	SITE_BLOCKING_ERROR,
	//
	//
	/**
	 * 
	 * <b>Description: </b>All error indicating issues at the provider site, such as the site is down for maintenance.
	 * <br>
	 * <b>Next Action: </b>Instruct the user to try again later. If the request fails repeatedly, report the issue to
	 * the customer service team
	 */
	UNEXPECTED_SITE_ERROR,
	//
	//
	/**
	 * 
	 * <b>Description: </b>Indicates that the site does not support the requested data or support is not available to
	 * complete the requested action. For example, site not available, document download not supported at the site, etc.
	 * <br>
	 * <b>Next Action: </b>Inform the user about the latest available status
	 */
	SITE_NOT_SUPPORTED,
	//
	//
	/**
	 * 
	 * <b>Description: </b>The provider site is unavailable due to issues such as the site is down for maintenance. <br>
	 * <br>
	 * <b>Next Action: </b>Instruct the user to try again later. If the request fails repeatedly, report the issue to
	 * the customer service team
	 */
	SITE_UNAVAILABLE,
	//
	//
	/**
	 * 
	 * <b>Description: </b>Indicates there is a technical error. <br>
	 * <b>Next Action: </b> Instruct the user to try again later. If the request fails repeatedly, report the issue to
	 * the customer service team.<br>
	 */
	TECH_ERROR, //
	/**
	 * <b>Description: </b>The errors that require users to take action at the provider site, for example, accept T{@literal &}C,
	 * etc. <br>
	 * <b>Next Action: </b>Instruct the user to visit the provider site and perform the necessary action
	 */
	USER_ACTION_NEEDED_AT_SITE,
	//
	//
	/**
	 * 
	 * <b>Description: </b>Indicates if multiple sessions or a session is terminated by the provider site. <br>
	 * <b>Next Action: </b>Instruct the user to try again later
	 */
	SITE_SESSION_INVALIDATED,
	//
	//
	/**
	 * 
	 * <b>Description: </b>The site has requested for OAuth authentication.<br>
	 * <b>Next Action: </b>The OAUTH based authentication sites can be added or updated only using Yodlee FastLink and
	 * not Yodlee APIs. Instruct the user to add the account using FastLink
	 */
	NEW_AUTHENTICATION_REQUIRED,
	//
	//
	/**
	 * 
	 * <b>Description: </b>The user has to provide consent to access the account information through Open Banking.<br>
	 * <b>Next Action: </b>Instruct the user to provide the consent through the edit account flow.
	 */
	CONSENT_REQUIRED,
	//
	//
	/**
	 * 
	 * <b>Description: </b>The consent provided by the user to access the account information through Open Banking has expired.<br>
	 * <b>Next Action: </b>Instruct the user to provide the consent through the edit account flow.
	 */
	CONSENT_EXPIRED,
	//
	//
	/**
	 * 
	 * <b>Description: </b>The user has revoked the consent to access the account information through Open Banking.<br>
	 * <b>Next Action: </b>Instruct the user to provide the consent through the add account flow.
	 */
	CONSENT_REVOKED,
	//
	//
	/**
	 * 
	 * <b>Description: </b>Failed to log in to the Open Banking provider site due to incorrect token.<br>
	 * <b>Next Action: </b>Instruct the user to provide the consent through the edit account flow.
	 */
	INCORRECT_OAUTH_TOKEN,
	//
	//
	/**
	 * <b>Description: </b>Required data is not available.<br>
	 * <b>Next Action: </b>No action is required as it is an end state.
	 */
	REQUIRED_DATA_NOT_AVAILABLE,
	//
	//
	/**
	 * <b>Description: </b>Matching failed.<br>
	 * <b>Next Action: </b>No action is required as it is an end state.
	 */
	MATCHING_FAILED,
	//
	//
	/**
	 * <b>Description: </b>No eligible accounts for given configuration.<br>
	 * <b>Next Action: </b>No action is required as it is an end state.
	 */
	NO_ELIGIBLE_ACCOUNTS,
	//
	//
	/**
	 * <b>Description: </b>Additional MFA information required from the user.
	 * <br>
	 * <b>Next Action: </b>Instruct the user to provide the MFA information
	 */
	USER_INPUT_REQUIRED
}
