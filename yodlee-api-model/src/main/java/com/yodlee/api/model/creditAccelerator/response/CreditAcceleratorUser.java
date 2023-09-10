/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.Name;
import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({"userId", "loginName", "email", "name"})
public class CreditAcceleratorUser {
	
	@JsonProperty("userId")
	@ApiModelProperty(readOnly = true,
		value = "The unique identifier of a consumer/user in the Yodlee system for whom the API services would be accessed for.")
	private long userId;
	
	@JsonProperty("loginName")
	@ApiModelProperty(readOnly = true,
		value = "The login name of the user used for authentication. This has to be provided as an input to the POST user/login service.")
	private String loginName;
	
	@JsonProperty("email")
	@ApiModelProperty(readOnly = true,
		value = "The email address of the user.")
	private String email;
	
	@JsonProperty("name")
	@ApiModelProperty(readOnly = true,
		value = "First, middle and last names of the user")
	private Name name;

	public long getUserId() {
		return userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public String getEmail() {
		return email;
	}

	public Name getName() {
		return name;
	}
}

