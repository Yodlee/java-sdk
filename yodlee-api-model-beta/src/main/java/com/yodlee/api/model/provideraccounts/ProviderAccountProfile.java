/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.provideraccounts;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Profile;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "profile"})
public class ProviderAccountProfile extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "Unique identifier for profile"//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts/profile</li>"//
							  + "</ul>")
	@JsonProperty("id")
	private Long id;

	@ApiModelProperty(readOnly = true,
					  value = "PII related data like address, name, phoneNumber, identifier and email."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts/profile</li>"//
							  + "</ul>")
	@JsonProperty("profile")
	private List<Profile> profiles;

	/**
	 * Unique identifier for profile <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/profile</li>
	 * </ul>
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * PII related data like address, name, phoneNumber, identifier and email. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/profile</li>
	 * </ul>
	 * 
	 * @return profile
	 */
	@JsonProperty("profile")
	public List<Profile> getProfiles() {
		return profiles == null ? null : Collections.unmodifiableList(profiles);
	}

	@Override
	public String toString() {
		return "ProviderAccountProfle [id=" + id + ", profile=" + profiles + "]";
	}
}
