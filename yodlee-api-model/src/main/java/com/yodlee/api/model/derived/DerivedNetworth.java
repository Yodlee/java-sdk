/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.derived;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"date", "asset", "liability", "networth", "historicalBalances"})
public class DerivedNetworth extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "The date as of when the networth information is provided."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank, creditcard, investment, insurance, realEstate, loan<br>"//
	)
	@JsonProperty("date")
	private String date;

	@ApiModelProperty(readOnly = true,
					  value = "The asset value that the user owns."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank, creditcard, investment, insurance, realEstate, loan<br>"//
	)
	@JsonProperty("asset")
	private Money asset;

	@ApiModelProperty(readOnly = true,
					  value = "The liability amount that the user owes."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank, creditcard, investment, insurance, realEstate, loan<br>"//
	)
	@JsonProperty("liability")
	private Money liability;

	@ApiModelProperty(readOnly = true,
					  value = "Networth of the user."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank, creditcard, investment, insurance, realEstate, loan<br>"//
	)
	@JsonProperty("networth")
	private Money networth;

	@ApiModelProperty(readOnly = true,
					  value = "Balances of the accounts over the period of time."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank, creditcard, investment, insurance, realEstate, loan<br>"//
	)
	@JsonProperty("historicalBalances")
	private List<DerivedNetworthHistoricalBalance> historicalBalances;

	/**
	 * The date as of when the networth information is provided. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank, creditcard, investment, insurance, realEstate, loan<br>
	 * 
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * The asset value that the user owns. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank, creditcard, investment, insurance, realEstate, loan<br>
	 * 
	 * @return asset
	 */
	public Money getAsset() {
		return asset;
	}

	/**
	 * The liability amount that the user owes. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank, creditcard, investment, insurance, realEstate, loan<br>
	 * 
	 * @return liability
	 */
	public Money getLiability() {
		return liability;
	}

	/**
	 * Networth of the user. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank, creditcard, investment, insurance, realEstate, loan<br>
	 * 
	 * @return networth
	 */
	public Money getNetworth() {
		return networth;
	}

	/**
	 * Balances of the accounts over the period of time. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank, creditcard, investment, insurance, realEstate, loan<br>
	 * 
	 * @return historicalBalances
	 */
	@JsonProperty("historicalBalances")
	public List<DerivedNetworthHistoricalBalance> getHistoricalBalances() {
		return historicalBalances == null ? null : Collections.unmodifiableList(historicalBalances);
	}

	@Override
	public String toString() {
		return "DerivedNetworth [date=" + date + ", asset=" + asset + ", liability=" + liability + ", networth="
				+ networth + ", historicalBalances=" + historicalBalances + "]";
	}
}
