/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.user.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.user.UpdateUserRegistration;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateUserRequest extends AbstractModelComponent implements Request {

	@NotNull(message = "{user.required}")
	@Valid
	@JsonProperty("user")
	private UpdateUserRegistration user;

	public UpdateUserRegistration getUser() {
		return user;
	}

	public void setUser(UpdateUserRegistration user) {
		this.user = user;
	}
}
