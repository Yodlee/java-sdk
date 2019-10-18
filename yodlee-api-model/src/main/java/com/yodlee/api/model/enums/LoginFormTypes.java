/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 * 
 */
package com.yodlee.api.model.enums;

public enum LoginFormTypes {
	/**
	 * The primary login form displayed in the provider site
	 */
	login,//
	/**
	 * The form requesting answers for the secret questions from the user during login
	 */
	questionAndAnswer,//
	/**
	 * The form requesting additional token information from the user during login
	 */
	token,
	/**
	 * The loginform that displays CAPTCHA for an user to enter the text during login
	 */
	image
}
