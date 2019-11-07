/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.sdk.configuration.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.sdk.configuration.cobrand.AbstractCobrandConfiguration;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserConfiguration extends AbstractCobrandConfiguration {

	@JsonProperty("issuer")
	private String issuer;

	@JsonProperty("source")
	private String source;

	@JsonProperty("samlResponse")
	private String samlResponse;

	public UserConfiguration() {}

	public UserConfiguration(String basePath, String apiVersion, String cobrandName, String issuer, String source,
			String samlResponse) {
		super(basePath, apiVersion, cobrandName);
		this.issuer = issuer;
		this.source = source;
		this.samlResponse = samlResponse;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSamlResponse() {
		return samlResponse;
	}

	public void setSamlResponse(String samlResponse) {
		this.samlResponse = samlResponse;
	}
}
