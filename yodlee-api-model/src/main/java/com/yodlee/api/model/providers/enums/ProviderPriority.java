/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 * 
 */
package com.yodlee.api.model.providers.enums;

public enum ProviderPriority {
	/**
	 * Popular providers
	 */
	POPULAR,//
	/**
	 * Suggested providers for the user
	 */
	SUGGESTED,//
	/**
	 * Yodlee supported providers
	 */
	COBRAND,//
	/**
	 * Providers matching the search text
	 */
	SEARCH
}
