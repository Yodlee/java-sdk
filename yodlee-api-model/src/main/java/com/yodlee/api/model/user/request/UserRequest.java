/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.user.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.user.UserRegistration;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest extends AbstractModelComponent implements Request {

	@NotNull(message = "{user.required}")
	@Valid
	@JsonProperty("user")
	private UserRegistration user;

	public UserRegistration getUser() {
		return user;
	}

	public void setUser(UserRegistration user) {
		this.user = user;
	}
}
