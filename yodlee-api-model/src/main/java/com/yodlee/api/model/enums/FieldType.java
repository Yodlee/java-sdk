/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
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
	options,//
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
