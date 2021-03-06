/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.cobrand;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class CobrandSession extends AbstractModelComponent {

	@JsonProperty("cobSession")
	private String cobSession;

	public String getCobSession() {
		return cobSession;
	}

	@Override
	public String toString() {
		return "CobrandSession [cobSession=" + cobSession + "]";
	}
}
