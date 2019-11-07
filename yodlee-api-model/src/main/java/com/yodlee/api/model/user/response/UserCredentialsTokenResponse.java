/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.user.response;

import java.util.Date;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"loginName", "validUntil", "token"})
public class UserCredentialsTokenResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("loginName")
	@NotNull(message = "loginName cannot be null")
	private String loginName;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("validUntil")
	@NotNull(message = "validUntil cannot be null")
	private Date validUntil;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("token")
	@NotNull(message = "token cannot be null")
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Override
	public String toString() {
		return "UserCredentialsTokenResponse [token = " + token + ", validUntil = " + validUntil + ", loginName = "
				+ loginName + "]";
	}
}
