/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.providers.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.providers.Providers;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProviderResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("provider")
	private List<Providers> providers;

	@JsonProperty("provider")
	public List<Providers> getProviders() {
		return providers == null ? null : Collections.unmodifiableList(providers);
	}

	@Override
	public String toString() {
		return "ProviderResponse [providers=" + providers + "]";
	}
}
