/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "loginName", "name", "address", "preferences", "roleType"})
public class UserDetail extends AbstractUser {

	@ApiModelProperty(readOnly = true,
					  value = "The email address of the user."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET user</li>"//
							  + "</ul>")
	@JsonProperty("email")
	private String email;

	@ApiModelProperty(readOnly = true,
					  value = "The address of the user."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET user</li>"//
							  + "</ul>")
	@JsonProperty("address")
	protected UserAddress address;

	@JsonProperty("segmentName")
	protected String segmentName;

	/**
	 * The email address of the user. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET user</li>
	 * </ul>
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * The address of the user. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET user</li>
	 * </ul>
	 * 
	 * @return address
	 */
	@JsonProperty("address")
	public UserAddress getAddress() {
		return address;
	}

	public String getSegmentName() {
		return segmentName;
	}

	@Override
	public String toString() {
		return "UserDetail [email=" + email + ", id=" + id + ", loginName=" + loginName + ", name=" + name
				+ ", address=" + address + ", preferences=" + preferences + ", roleType=" + roleType + ", segmentName="
				+ segmentName + "]";
	}
}
