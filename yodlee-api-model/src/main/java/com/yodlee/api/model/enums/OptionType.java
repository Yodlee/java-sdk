/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 * 
 */
package com.yodlee.api.model.enums;

public enum OptionType {
	/**
	 * An option to sell assets at an agreed price on or before a particular date
	 */
	put,//
	/**
	 * An option to buy assets at an agreed price on or before a particular date
	 */
	call,
	unknown,
	other
}
