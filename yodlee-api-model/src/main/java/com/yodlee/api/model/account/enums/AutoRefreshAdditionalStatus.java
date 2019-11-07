/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account.enums;

public enum AutoRefreshAdditionalStatus {
	/**
	 * Auto refresh is scheduled
	 */
	SCHEDULED,//
	/**
	 * Auto refresh is temporarily disabled due to site or technical issues
	 */
	TEMP_ERROR,//
	/**
	 * Auto refresh is disabled due to site blocking
	 */
	SITE_BLOCKING,//
	/**
	 * Auto refresh is disabled because the site no longer supports updates
	 */
	SITE_NOT_SUPPORTED, //
	/**
	 * Auto refresh is disabled because the site requires real time MFA information to get account updates
	 */
	REAL_TIME_MFA_REQUIRED,//
	/**
	 * Auto refresh is disabled as the user needs to take action at site or update the credentials or answers for
	 * security questions
	 * 
	 */
	USER_ACTION_REQUIRED,//
	/**
	 * Auto refresh is disabled because:<br>
	 * <ul>
	 * 
	 * <li>The customer has unsubscribed to auto refreshes.</li>
	 * <li>Yodlee has disabled auto refreshes for the customer due to site or technical issues.</li>
	 * <li>Auto refresh no longer subscribed at the provider account level.</li>
	 * <li>The site has been disabled for auto refreshes.</li>
	 * <li>The account is inactive or closed.</li>
	 * </ul>
	 * 
	 */
	UNSUBSCRIBED,//
	/**
	 * Auto refresh is disabled because the account is a manual account
	 * 
	 */
	MANUAL_ACCOUNT
}
