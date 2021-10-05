/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.configuration.cobrand;

import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractCobrandConfiguration extends AbstractBaseConfiguration {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "{config.cobrandName.required}")
	@JsonProperty("cobrandName")
	protected String name;

	@NotEmpty(message = "{config.cobrandLoginName.required}")
	@JsonProperty("loginName")
	private String loginName;

	@NotEmpty(message = "{config.cobrandPassword.required}")
	@JsonProperty("password")
	private String password;

	public AbstractCobrandConfiguration() {
		super();
	}

	public AbstractCobrandConfiguration(String basePath, String apiVersion, String name) {
		super(basePath, apiVersion);
		this.name = name;
	}

	@JsonProperty("cobrandName")
	public String getName() {
		return name;
	}

	@JsonProperty("cobrandName")
	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
