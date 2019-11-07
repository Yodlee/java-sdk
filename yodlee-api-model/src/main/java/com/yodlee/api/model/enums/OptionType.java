/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
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
