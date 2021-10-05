/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class UserSession extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "Session provided for a valid user to access API services upon successful authentication."
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>POST user/samlLogin</li>"//
							  + "<li>POST user/register</li>"//
							  + "</ul>")
	@JsonProperty("userSession")
	private String userSession;

	/**
	 * Session provided for a valid user to access API services upon successful authentication. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST user/samlLogin</li>
	 * <li>POST user/register</li>
	 * </ul>
	 * 
	 * @return userSession
	 */
	public String getUserSession() {
		return userSession;
	}

	@Override
	public String toString() {
		return "UserSession [userSession=" + userSession + "]";
	}
}
