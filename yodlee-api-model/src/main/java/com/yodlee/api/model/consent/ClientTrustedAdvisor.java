/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.consent;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class ClientTrustedAdvisor {
	@ApiModelProperty(required = true,
            value = "Name of the client trusted advisor")
    @JsonProperty("name")
    private String name;
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@ApiModelProperty(required = true,value = "<b>Email Id of the Client Trusted Advisor</b>: PRIMARY , SECONDARY , PERSONAL , WORK and OTHERS"//
	)
	@JsonProperty("email")
	private String email;
	
	@ApiModelProperty(required = true,value = "<b>Role of the Client Trusted Advisor</b>: Example : Lawyer , Accountant , etc...")
	@JsonProperty("role")
	private String role;

    /**
	 * preference id. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>PUT consents/{consentId}/renewal</li>
	 * </ul>
	 * 
	 * @return id
	 */

    
	@Override
    public String toString() {
        return "clientTrustedAdvisor{" +
                "name=" + name + ", email=" + email + ", role = " + role + "}";
    }
    
}
