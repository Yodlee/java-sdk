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
import com.yodlee.api.model.user.enums.RoleType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractUser extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "The unique identifier of a consumer/user in Yodlee system for whom the API services would be accessed for."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>POST user/samlLogin</li>"//
							  + "<li>POST user/register</li>"//
							  + "<li>GET user</li>"//
							  + "</ul>")
	@JsonProperty("id")
	protected Long id;

	@ApiModelProperty(readOnly = true,
					  value = "The login name of the user used for authentication."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>POST user/register</li>"//
							  + "<li>GET user</li>"//
							  + "</ul>")
	@JsonProperty("loginName")
	protected String loginName;

	@ApiModelProperty(readOnly = true,
					  value = "First, middle and last names of the user."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>POST user/samlLogin</li>"//
							  + "<li>POST user/register</li>"//
							  + "<li>GET user</li>"//
							  + "</ul>")
	@JsonProperty("name")
	protected Name name;

	@ApiModelProperty(readOnly = true,
					  value = "Preferences of the user to be respected in the data provided through various API services."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>POST user/samlLogin</li>"//
							  + "<li>POST user/register</li>"//
							  + "<li>GET user</li>"//
							  + "</ul>")
	@JsonProperty("preferences")
	protected UserResponsePreferences preferences;

	@JsonProperty("roleType")
	protected RoleType roleType;

	public AbstractUser() {}

	/**
	 * The unique identifier of a consumer/user in Yodlee system for whom the API services would be accessed for. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST user/samlLogin</li>
	 * <li>POST user/register</li>
	 * <li>GET user</li>
	 * </ul>
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * First, middle and last names of the user. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST user/samlLogin</li>
	 * <li>POST user/register</li>
	 * <li>GET user</li>
	 * </ul>
	 * 
	 * @return name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * Preferences of the user to be respected in the data provided through various API services. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST user/samlLogin</li>
	 * <li>POST user/register</li>
	 * <li>GET user</li>
	 * </ul>
	 * 
	 * @return user preferences
	 */
	public UserResponsePreferences getPreferences() {
		return preferences;
	}

	/**
	 * The login name of the user used for authentication. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST user/register</li>
	 * <li>GET user</li>
	 * </ul>
	 * 
	 * @return loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	public RoleType getRoleType() {
		return roleType;
	}
}
