/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.configuration.cobrand;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CobrandConfiguration extends AbstractCobrandConfiguration {

	public CobrandConfiguration() {}

	public CobrandConfiguration(String basePath, String apiVersion, String name) {
		super(basePath, apiVersion, name);
	}
}
