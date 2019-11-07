/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "address", "email", "phoneNumber", "identifier"})
public class Profile extends AbstractProfile {

	@ApiModelProperty(readOnly = true,
					  value = "Name of the provider account holder."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts/profile</li>"//
							  + "</ul>")
	@JsonProperty("name")
	private Name name;

	@ApiModelProperty(readOnly = true,
					  value = "Gender of the provider account holder."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts/profile</li>"//
							  + "</ul>")
	@JsonProperty("gender")
	private String gender;

	/**
	 * Name of the provider account holder. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/profile</li>
	 * </ul>
	 * 
	 * @return name
	 */
	public Name getName() {
		return name;
	}

	/***
	 * Gender of the provider account holder.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/profile</li>
	 * </ul>
	 * 
	 * @return gender
	 */
	public String gender() {
		return gender;
	}

	@Override
	public String toString() {
		return "Profile [name=" + name + ", addresses=" + addresses + ", emails=" + emails + "]";
	}
}
