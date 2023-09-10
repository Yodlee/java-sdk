/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.consent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "methodType", "rel", "href" })
public class Links {

	@ApiModelProperty(name = "methodType", required = true, value = "Type of the HTTP method "
			+ "<br/> GET , PUT , POST , DELETE , ...")
	@JsonProperty("methodType")
	private String methodType;

	@ApiModelProperty(name = "rel", required = true, value = "Get Consent preference")
	@JsonProperty("rel")
	private String rel;

	@ApiModelProperty(name = "href", required = true, value = "Get Consent preference Endpoint")
	@JsonProperty("href")
	private String href;

	public String getMethodType() {
		return methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	@Override
	public String toString() {
		return "Links [methodType=" + methodType + ", rel=" + rel + ", href=" + href + "]";
	}

}
