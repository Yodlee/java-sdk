/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.configuration.cobrand;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CobrandConfiguration extends AbstractCobrandConfiguration {

	private static final long serialVersionUID = 1L;

	public CobrandConfiguration() {}

	public CobrandConfiguration(String basePath, String apiVersion, String name) {
		super(basePath, apiVersion, name);
	}
}
