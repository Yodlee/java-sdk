/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.user;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"loginName", "email", "name", "address", "preferences"})
public class UserRegistration extends AbstractUserRegistration {

	@NotEmpty(message = "{user.loginName.required}")
	@Size(min = 3, max = 150, message = "{user.loginName.length.invalid}")
	@Pattern(regexp = "[^\\s]+", message = "{user.loginName.invalid}")
	@JsonProperty("loginName")
	private String loginName;

	@NotEmpty(message = "{user.email.required}")
	@Email(message = "{user.email.invalid}")
	@JsonProperty("email")
	private String email;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserRegistration [loginName=" + loginName + ", email=" + email + ", name=" + name + ", address="
				+ address + ", preferences=" + preferences + "]";
	}
}
