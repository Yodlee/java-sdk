/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;
import com.yodlee.api.model.account.enums.DataPointSource;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"isAsset", "date", "asOfDate", "dataSourceType", "balance"})
public class HistoricalBalance extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "Indicates whether the balance is an asset or liability."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Applicable containers</b>: bank, creditCard, investment, insurance, realEstate, loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts/historicalBalances</li>"//
							  + "</ul>")
	@JsonProperty("isAsset")
	private Boolean isAsset;

	@ApiModelProperty(readOnly = true,
					  value = "Date for which the account balance was provided.  This balance could be a carryforward, calculated or a scraped balance."//
							  + "<br><b>Additional Details</b>:"//
							  + "<br><b>Scraped</b>: Balance shown in the provider site. This balance gets stored in Yodlee system during system/user account updates."//
							  + "<br><b>CarryForward</b>: Balance carried forward from the scraped balance to the days for which the balance was not available in the system. Balance may not be available for all the days in the system due to MFA information required, error in the site, credential changes, etc."//
							  + "<br><b>calculated</b>: Balances that gets calculated for the days that are prior to the account added date.  "//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Applicable containers</b>: bank, creditCard, investment, insurance, realEstate, loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts/historicalBalances</li>"//
							  + "<li>GET derived/networth</li>"//
							  + "</ul>")
	@JsonProperty("date")
	private String date;

	@ApiModelProperty(readOnly = true,
					  value = "Date as of when the balance is last updated due to the auto account updates or user triggered updates. This balance will be carry forward for the days where there is no balance available in the system. "//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Applicable containers</b>: bank, creditCard, investment, insurance, realEstate, loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts/historicalBalances</li>"//
							  + "</ul>")
	@JsonProperty("asOfDate")
	private String asOfDate;

	@ApiModelProperty(readOnly = true,
					  value = "The source of balance information."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Applicable containers</b>: bank, creditCard, investment, insurance, realEstate, loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts/historicalBalances</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("dataSourceType")
	private DataPointSource dataSourceType;

	@ApiModelProperty(readOnly = true,
					  value = "Balance amount of the account."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Applicable containers</b>: bank, creditCard, investment, insurance, realEstate, loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts/historicalBalances</li>"//
							  + "</ul>")
	@JsonProperty("balance")
	private Money balance;

	/**
	 * Balance amount of the account. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: bank, creditCard, investment, insurance, realEstate, loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts/historicalBalances</li>
	 * </ul>
	 * 
	 * @return balance
	 */
	public Money getBalance() {
		return balance;
	}

	/**
	 * Date as of when the balance is last updated due to the auto account updates or user triggered updates. This
	 * balance will be carry forward for the days where there is no balance available in the system. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: bank, creditCard, investment, insurance, realEstate, loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts/historicalBalances</li>
	 * </ul>
	 * 
	 * @return asOfDate
	 */
	public String getAsOfDate() {
		return asOfDate;
	}

	/**
	 * Indicates whether the balance is an asset or liability. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: bank, creditCard, investment, insurance, realEstate, loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts/historicalBalances</li>
	 * </ul>
	 * 
	 * @return isAsset
	 */
	public Boolean getIsAsset() {
		return isAsset;
	}

	/**
	 * Date for which the account balance was provided. This balance could be a carryforward, calculated or a scraped
	 * balance. <br>
	 * <b>Additional Details</b>: <br>
	 * <b>Scraped</b>: Balance shown in the provider site. This balance gets stored in Yodlee system during system/user
	 * account updates. <br>
	 * <b>CarryForward</b>: Balance carried forward from the scraped balance to the days for which the balance was not
	 * available in the system. Balance may not be available for all the days in the system due to MFA information
	 * required, error in the site, credential changes, etc. <br>
	 * <b>calculated</b>: Balances that gets calculated for the days that are prior to the account added date. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: bank, creditCard, investment, insurance, realEstate, loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts/historicalBalances</li>
	 * <li>GET derived/networth</li>
	 * </ul>
	 * 
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * The source of balance information. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: bank, creditCard, investment, insurance, realEstate, loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts/historicalBalances</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return dataSourceType
	 */
	public DataPointSource getDataSourceType() {
		return dataSourceType;
	}

	@Override
	public String toString() {
		return "HistoricalBalance [isAsset=" + isAsset + ", date=" + date + ", asOfDate=" + asOfDate
				+ ", dataSourceType=" + dataSourceType + ", balance=" + balance + "]";
	}
}
