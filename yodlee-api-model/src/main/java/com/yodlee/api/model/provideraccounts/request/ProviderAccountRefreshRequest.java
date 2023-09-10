/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.provideraccounts.request;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProviderAccountRefreshRequest extends AbstractModelComponent implements Request {
	
	@JsonProperty("configName")
	@ApiModelProperty(readOnly = true, value = "The name of configuration created at the time onboarding or configuration creation.")
	public String configName;

	@JsonProperty("providerAccountIds")
	@ApiModelProperty(readOnly = true, value = "Comma separated providerAccountIds.")
	public ArrayList<Long> providerAccountIds;

	public String getConfigName() {
		return configName;
	}

	public ArrayList<Long> getProviderAccountIds() {
		return providerAccountIds;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public void setProviderAccountIds(ArrayList<Long> providerAccountIds) {
		this.providerAccountIds = providerAccountIds;
	}
	
}
