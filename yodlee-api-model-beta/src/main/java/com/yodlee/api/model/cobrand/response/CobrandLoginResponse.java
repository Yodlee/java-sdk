/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.cobrand.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.cobrand.CobrandSession;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"cobrandId", "applicationId", "session", "locale"})
public class CobrandLoginResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true,
					  value = "Unique identifier of the cobrand (customer) in the system."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>POST cobrand/login</li>"//
							  + "</ul>")
	@JsonProperty("cobrandId")
	private Long cobrandId;

	@ApiModelProperty(readOnly = true,
					  value = "The application identifier."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>POST cobrand/login</li>"//
							  + "</ul>")
	@JsonProperty("applicationId")
	private String applicationId;

	@JsonProperty("session")
	private CobrandSession session;

	@ApiModelProperty(readOnly = true,
					  value = "The customer's locale that will be considered for the localization functionality."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>POST cobrand/login</li>"//
							  + "</ul>")
	@JsonProperty("locale")
	private String locale;

	@JsonProperty("session")
	public CobrandSession getSession() {
		return session;
	}

	/**
	 * The customer's locale that will be considered for the localization functionality. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST cobrand/login</li>
	 * </ul>
	 * 
	 * @return customer's locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * The application identifier. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST cobrand/login</li>
	 * </ul>
	 * 
	 * @return applicationId
	 */
	public String getApplicationId() {
		return applicationId;
	}

	/**
	 * Unique identifier of the cobrand (customer) in the system. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST cobrand/login</li>
	 * </ul>
	 * 
	 * @return cobrandId
	 */
	public Long getCobrandId() {
		return cobrandId;
	}

	@Override
	public String toString() {
		return "CobrandLoginResponse [cobrandId=" + cobrandId + ", applicationId=" + applicationId + ", session="
				+ session + ", locale=" + locale + "]";
	}
}
