/*
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.auth.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.auth.ApiKeyOutput;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"apiKey"})
public class ApiKeyResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(value = "ApiKey customer details."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET /auth/apiKey</li>"//
			+ "<li>POST /auth/apiKey</li>"//
			+ "</ul>")
	@JsonProperty("apiKey")
	private List<ApiKeyOutput> apiKeyList;

	/**
	 * ApiKey customer details. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET /auth/apiKey</li>
	 * <li>POST /auth/apiKey</li>
	 * </ul>
	 * 
	 * @return apiKey
	 */
	@JsonProperty("apiKey")
	public List<ApiKeyOutput> getApiKeyList() {
		return apiKeyList == null ? null : Collections.unmodifiableList(apiKeyList);
	}

	@Override
	public String toString() {
		return "ApiKeyResponse [apiKeyList=" + apiKeyList + "]";
	}
}
