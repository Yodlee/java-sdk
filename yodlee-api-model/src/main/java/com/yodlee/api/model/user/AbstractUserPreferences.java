/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.user;

import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.user.enums.Currency;
import com.yodlee.api.model.user.enums.Locale;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"currency", "timeZone", "dateFormat", "locale"})
public abstract class AbstractUserPreferences extends AbstractModelComponent {

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

	@ApiModelProperty(value = "The timezone of the user. This attribute is just a place holder and has no impact on any other API services.")
	@NotEmpty(message = "timeZone cannot be empty")
	@JsonProperty("timeZone")
	protected String timeZone;

	@ApiModelProperty(value = "The dateformat of the user.This attribute is just a place holder and has no impact on any other API services.")
	@NotEmpty(message = "dateFormat cannot be empty")
	@JsonProperty("dateFormat")
	protected String dateFormat;

	/**
	 * The dateformat of the user.This attribute is just a place holder and has no impact on any other API services.)
	 * 
	 * @return dateFormat
	 */
	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	/**
	 * The timezone of the user. This attribute is just a place holder and has no impact on any other API services.
	 * 
	 * @return timeZone
	 */
	@JsonProperty("timeZone")
	public String getTimeZone() {
		return timeZone;
	}

	@JsonProperty("timeZone")
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

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
}
