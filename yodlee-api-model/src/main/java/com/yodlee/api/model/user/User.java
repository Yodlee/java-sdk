/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "loginName", "name", "session", "preferences", "roleType"})
public class User extends AbstractUser {

	@ApiModelProperty(readOnly = true,
					  value = "Session token of the user using which other services are invoked in the system."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>POST user/samlLogin</li>"//
							  + "<li>POST user/register</li>"//
							  + "</ul>")
	@JsonProperty("session")
	protected UserSession session;

	/**
	 * Session token of the user using which other services are invoked in the system. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST user/samlLogin</li>
	 * <li>POST user/register</li>
	 * </ul>
	 * 
	 * @return session
	 */
	public UserSession getSession() {
		return session;
	}

	

	@Override
	public String toString() {
		return "User [session=" + session + ", id=" + id + ", loginName=" + loginName + ", name=" + name
				+ ", preferences=" + preferences + ", roleType=" + roleType + "]";
	}
}
