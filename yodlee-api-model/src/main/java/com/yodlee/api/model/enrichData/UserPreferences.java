/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.enrichData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.user.enums.Currency;
import com.yodlee.api.model.user.enums.Locale;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"currency", "locale"})
public class UserPreferences extends AbstractModelComponent {

	@ApiModelProperty(value = "The currency of the user. This currency will be respected while providing the response for derived API services."//
			+ "<br><b>Applicable Values</b><br>"//
	)
	@JsonProperty("currency")
	protected Currency currency;

	@ApiModelProperty(value = "The locale of the user. This locale will be considered for localization features like providing the provider information in the supported locale or providing category names in the transaction related services."//
			+ "<br><b>Applicable Values</b><br>"//
	)
	@JsonProperty("locale")
	protected Locale locale;

	
	/**
	 * The locale of the user. This locale will be considered for localization features like providing the provider
	 * information in the supported locale or providing category names in the transaction related services. <br>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return locale
	 */
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * The currency of the user. This currency will be respected while providing the response for derived API services.
	 * <br>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return currency
	 */
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "UserPreferences [currency=" + currency + ", locale=" + locale + "]";
	}
}
