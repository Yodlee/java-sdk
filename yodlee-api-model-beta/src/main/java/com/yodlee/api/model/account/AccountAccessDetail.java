/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"method", "version"})
public class AccountAccessDetail extends AbstractModelComponent {

	@JsonProperty("method")
	private List<String> methods;

	@JsonProperty("version")
	private List<String> versions;

	@JsonProperty("method")
	public List<String> getMethods() {
		return methods;
	}

	@JsonProperty("method")
	public void setMethods(List<String> method) {
		this.methods = method;
	}

	@JsonProperty("version")
	public List<String> getVersions() {
		return versions;
	}

	@JsonProperty("version")
	public void setVersions(List<String> version) {
		this.versions = version;
	}

	@Override
	public String toString() {
		return "AccountAccessDetail [methods=" + methods + ", versions=" + versions + "]";
	}
}
