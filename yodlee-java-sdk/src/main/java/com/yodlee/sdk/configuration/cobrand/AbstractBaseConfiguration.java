/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.configuration.cobrand;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.sdk.configuration.AbstractConfiguration;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractBaseConfiguration extends AbstractConfiguration {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "{config.basepath.required}")
	@URL(message = "{config.basepath.invalid}")
	@JsonProperty("basePath")
	protected String basePath;

	@NotEmpty(message = "{config.apiVersion.required}")
	@JsonProperty("apiVersion")
	protected String apiVersion;

	@Pattern(regexp = "[a-z]{2}_[A-Z]{2}", message = "{config.locale.invalid}")
	@JsonProperty("locale")
	protected String locale;

	@Min(value = 1, message = "{config.socketTimeout.min}")
	@Max(value = Integer.MAX_VALUE, message = "{config.socketTimeout.max}")
	@JsonProperty("socketTimeout")
	protected Integer socketTimeout;

	@Min(value = 1, message = "{config.readTimeout.min}")
	@Max(value = Integer.MAX_VALUE, message = "{config.readTimeout.max}")
	@JsonProperty("readTimeout")
	protected Integer readTimeout;

	@Min(value = 1, message = "{config.writeTimeout.min}")
	@Max(value = Integer.MAX_VALUE, message = "{config.writeTimeout.max}")
	@JsonProperty("writeTimeout")
	protected Integer writeTimeout;

	public AbstractBaseConfiguration() {}

	public AbstractBaseConfiguration(String basePath, String apiVersion) {
		this.basePath = basePath;
		this.apiVersion = apiVersion;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Integer getSocketTimeout() {
		return socketTimeout;
	}

	public void setSocketTimeout(Integer socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	public Integer getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(Integer readTimeout) {
		this.readTimeout = readTimeout;
	}

	public Integer getWriteTimeout() {
		return writeTimeout;
	}

	public void setWriteTimeout(Integer writeTimeout) {
		this.writeTimeout = writeTimeout;
	}
}
