/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
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
