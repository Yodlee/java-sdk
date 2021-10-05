/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Name;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractUserRegistration extends AbstractModelComponent {

	@JsonProperty("name")
	protected Name name;

	@JsonProperty("address")
	protected UserAddress address;

	@JsonProperty("preferences")
	protected UserRequestPreferences preferences;

	@JsonProperty("segmentName")
	protected String segmentName;

	@JsonProperty("address")
	public UserAddress getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(UserAddress address) {
		this.address = address;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public UserRequestPreferences getPreferences() {
		return preferences;
	}

	public void setPreferences(UserRequestPreferences preferences) {
		this.preferences = preferences;
	}

	public String getSegmentName() {
		return segmentName;
	}

	public void setSegmentName(String segmentName) {
		this.segmentName = segmentName;
	}
}
