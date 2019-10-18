/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 * 
 */
package com.yodlee.api.model.enums;

public enum FieldType {
	/**
	 * The field values can be accepted in a clear text when the user enters the values
	 */
	text,//
	/**
	 * The field values should be accepted in a masked form when the user enters the values
	 */
	password,//
	/**
	 * The field values should be displayed in a drop down
	 */
	option,//
	/**
	 * The field values should be displayed in a check box
	 */
	checkbox,//
	/**
	 * The field values should be displayed as radio options
	 */
	radio,//
	/**
	 * The field values should be displayed as image
	 */
	image
}
