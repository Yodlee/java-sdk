/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.provideraccounts.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.provideraccounts.ProviderAccountPreferences;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"preferences"})
public class ProviderAccountPreferencesRequest extends AbstractModelComponent implements Request {

	@ApiModelProperty(value = "The preference set for the provider account. " + "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providerAccounts?include=preferences</li>"//
			+ "<li>GET providerAccounts/{providerAccountId}?include=preferences</li>"//
			+ "</ul>"//
	)
	@JsonProperty("preferences")
	private ProviderAccountPreferences providerAccountPreferences;

	/**
	 * The preference set for the provider account. * <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts?include=preferences</li>
	 * <li>GET providerAccounts/{providerAccountId}?include=preferences</li>
	 * </ul>
	 * 
	 * @return preferences
	 */
	@JsonProperty("preferences")
	public ProviderAccountPreferences getProviderAccountPreferences() {
		return providerAccountPreferences;
	}

	@JsonProperty("preferences")
	public void setProviderAccountPreferences(ProviderAccountPreferences providerPreferences) {
		this.providerAccountPreferences = providerPreferences;
	}

	@Override
	public String toString() {
		return "ProvidersPreferencesRequest [providerAccountPreferences=" + providerAccountPreferences + "]";
	}
}
