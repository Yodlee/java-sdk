/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.webhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"methodType", "rel", "href"})
public class Link {

	@JsonProperty("methodType")
	private String methodType;

	@JsonProperty("rel")
	private String rel;

	@JsonProperty("href")
	private String href;

	@JsonProperty("methodType")
	public String getMethodType() {
		return methodType;
	}

	@JsonProperty("rel")
	public String getRel() {
		return rel;
	}

	@JsonProperty("href")
	public String getHref() {
		return href;
	}

	@Override
	public String toString() {
		return "Link [methodType=" + methodType + ", rel=" + rel + ", href=" + href + "]";
	}
}
