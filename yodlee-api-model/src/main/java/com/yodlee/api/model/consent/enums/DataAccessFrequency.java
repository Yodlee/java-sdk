/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.consent.enums;


public enum DataAccessFrequency {
	/**
	* Every time a new consent is obtained.<br>
	*/
	ONE_TIME,//
	/**
	* The same consent is used for multiple aggregations till expirationDate.<br>
	*/	
	RECURRING//
}
