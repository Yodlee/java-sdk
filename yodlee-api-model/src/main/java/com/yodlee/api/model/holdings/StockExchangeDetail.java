/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.holdings;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"symbol", "currencyCode", "countryCode", "exchangeCode"})
public class StockExchangeDetail extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "Ticker symbol representing particular securities listed on an exchange."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("symbol")
	private String symbol;

	@ApiModelProperty(readOnly = true,
					  value = "ISO codes of currency."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("currencyCode")
	private String currencyCode;

	@ApiModelProperty(readOnly = true,
					  value = "Country codes are geocodes developed to represent countries and dependent areas."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("countryCode")
	private String countryCode;

	@ApiModelProperty(readOnly = true,
					  value = "An Exchange code is a four-character code used to identify stock markets and other trading exchanges within global trading."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("exchangeCode")
	private String exchangeCode;

	/**
	 * Ticker symbol representing particular securities listed on an exchange. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * ISO codes of currency. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * Country codes are geocodes developed to represent countries and dependent areas. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * An Exchange code is a four-character code used to identify stock markets and other trading exchanges within
	 * global trading. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return exchangeCode
	 */
	public String getExchangeCode() {
		return exchangeCode;
	}

	@Override
	public String toString() {
		return "StockExchangeDetail [symbol=" + symbol + ", currencyCode=" + currencyCode + ", countryCode="
				+ countryCode + ", exchangeCode=" + exchangeCode + "]";
	}
}
