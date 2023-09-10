/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.enrichData;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.enrichData.EnrichUserName;
import com.yodlee.api.model.user.UserAddress;
import com.yodlee.api.model.enrichData.UserPreferences;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrichDataUser extends AbstractModelComponent {

	@NotEmpty(message = "{enrichData.data.invalid}")
	@Size(min = 3, max = 150, message = "{user.loginName.length.invalid}")
	@JsonProperty("loginName")
	private String loginName;

	@NotEmpty(message = "{enrichData.data.invalid}")
	@Email(message= "{user.email.invalid}")
	@JsonProperty("email")
	private String email;

	@JsonProperty("name")
	protected EnrichUserName name;

	@JsonProperty("address")
	protected UserAddress address;

	@JsonProperty("preferences")
	protected UserPreferences preferences;
	

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

	public EnrichUserName getName() {
		return name;
	}

	public void setName(EnrichUserName name) {
		this.name = name;
	}

	@JsonProperty("address")
	public UserAddress getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(UserAddress address) {
		this.address = address;
	}

	public UserPreferences getPreferences() {
		return preferences;
	}

	public void setPreferences(UserPreferences preferences) {
		this.preferences = preferences;
	}	

	@Override
	public String toString() {
		return "EnrichDataUser [loginName=" + loginName + ", email=" + email + ", name=" + name + ", address=" + address
				+ ", preferences=" + preferences + "]";
	}
}
