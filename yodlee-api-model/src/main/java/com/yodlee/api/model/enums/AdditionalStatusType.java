/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.enums;

public enum AdditionalStatusType {
	/**
	 * <b>Description: </b>Login to provider site is in progress <br>
	 * <b>Next Action: </b>Not applicable as it is not a final status
	 */
	LOGIN_IN_PROGRESS,
	//
	//
	/**
	 * 
	 * <b>Description: </b>Data aggregation is in progress. <br>
	 * <b>Next Action: </b>Not applicable as it is not a final status
	 */
	DATA_RETRIEVAL_IN_PROGRESS,
	//
	//
	/**
	 * 
	 * <b>Description: </b>Basic account data is retrieved. k<br>
	 * <b>Next Action: </b>Not applicable as it is not a final status
	 */
	ACCT_SUMMARY_RECEIVED,
	//
	//
	/**
	 * 
	 * <b>Description: </b>All the data available at the provider site is retrieved for the provided dataset. <br>
	 * <b>Next Action: </b>Not applicable
	 */
	AVAILABLE_DATA_RETRIEVED,
	//
	//
	/**
	 * 
	 * <b>Description: </b>Partial data is retrieved for the dataset. <br>
	 * <b>Next Action: </b>Instruct the user to try again if the mandatory data is missing. If the request fails
	 * repeatedly, report the issue to the customer service team
	 */
	PARTIAL_DATA_RETRIEVED,
	//
	//
	/**
	 * 
	 * <b>Description: </b>Failed to retrieve the data due to unexpected issues. <br>
	 * <b>Next Action: </b>Instruct the user to try again later. If the request fails repeatedly, report the issue to
	 * the customer service team
	 */
	DATA_RETRIEVAL_FAILED,
	//
	//
	/**
	 * 
	 * <b>Description: </b>The requested data or document is not available at the provider site. <br>
	 * <b>Next Action: </b>Instruct the user to check with the respective data provider or provider site. <br>
	 * 
	 */
	DATA_NOT_AVAILABLE,
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
	/**
	 * <b>Description: </b> <br>
	 * <b>Next Action: </b>
	 */
	BETA_SITE_DEV_IN_PROGRESS, //
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
	/**
	 * <b>Description: </b>The property value is not available. <br>
	 * <b>Next Action: </b>Instruct the user to provide the property value
	 */
	PROPERTY_VALUE_NOT_AVAILABLE,
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
	 * <b>Description: </b>The requested datasets are not supported. <br>
	 * <b>Next Action: </b>Either get the dataset/attribute enabled or remove the dataset/attribute from the input
	 */
	DATASET_NOT_SUPPORTED,
	//
	//
	/**
	 * 
	 * <b>Description: </b>The dataset cannot be retrieved as the user has not enrolled for it. <br>
	 * <b>Next Action: </b>Instruct the user to enroll for the dataset and then request for it
	 */
	ENROLLMENT_REQUIRED_FOR_DATASET
}
