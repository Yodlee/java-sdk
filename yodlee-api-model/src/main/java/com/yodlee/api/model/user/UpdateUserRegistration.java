/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.user;

import org.hibernate.validator.constraints.Email;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"loginName", "email", "name", "address", "preferences"})
public class UpdateUserRegistration extends AbstractUserRegistration {

	@Email(message = "{user.email.invalid}")
	@JsonProperty("email")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UpdateUserRegistration [email=" + email + ", name=" + name + ", address=" + address + ", preferences="
				+ preferences + "]";
	}
}
