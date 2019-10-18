/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
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
