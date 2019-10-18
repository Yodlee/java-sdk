/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.derived;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;
import com.yodlee.api.model.derived.enums.BalanceDataSourceType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"accountId", "date", "asOfDate", "balance", "isAsset", "dataSourceType"})
public class DerivedNetworthHistoricalBalance extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("accountId")
	private Long accountId;

	@ApiModelProperty(readOnly = true,
					  value = "Date for which the account balance was provided.  This balance could be a carryforward, calculated or a scraped balance. "
							  + "AdditIonal Details: scraped: Balance shown in the provider site. This balance gets stored in Yodlee system during system/user account updates. "
							  + "carryForward : Balance carried forward from the scraped balance to the days for which the balance was not available in the system. Balance may not be available for all the days in the system due to MFA information required, error in the site, credential changes, etc. "
							  + "calculated: Balances that gets calculated for the days that are prior to the account added date."//
							  + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated and Manual<br>"//
							  + "<b>Applicable containers</b>: bank, creditCard, investment, insurance, realEstate, loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts/historicalBalances</li>"//
							  + "<li>GET derived/networth</li>"//
							  + "</ul>")
	@JsonProperty("date")
	private String date;

	@ApiModelProperty(readOnly = true,
					  value = "Date as of when the balance is last  updated due to the auto account updates or user triggered updates. "
							  + "This balance will be carry forward for the days where there is no balance available in the system. "//
							  + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated and Manual<br>"//
							  + "<b>Applicable containers</b>: bank, creditCard, investment, insurance, realEstate, loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts/historicalBalances</li>"//
							  + "</ul>")
	@JsonProperty("asOfDate")
	private String asOfDate;

	@ApiModelProperty(readOnly = true,
					  value = "Balance amount of the account."//
							  + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated and Manual<br>"//
							  + "<b>Applicable containers</b>: bank, creditCard, investment, insurance, realEstate, loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts/historicalBalances</li>"//
							  + "</ul>")
	@JsonProperty("balance")
	private Money balance;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates whether the balance is an asset or liability."//
							  + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated and Manual<br>"//
							  + "<b>Applicable containers</b>: bank, creditCard, investment, insurance, realEstate, loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts/historicalBalances</li>"//
							  + "</ul>")
	@JsonProperty("isAsset")
	private Boolean isAsset;

	@ApiModelProperty(readOnly = true,
					  value = "The source of balance information."//
							  + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated and Manual<br>"//
							  + "<b>Applicable containers</b>: bank, creditCard, investment, insurance, realEstate, loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts/historicalBalances</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("dataSourceType")
	private BalanceDataSourceType dataSourceType;

	public Long getAccountId() {
		return accountId;
	}

	/**
	 * Date for which the account balance was provided. This balance could be a carryforward, calculated or a scraped
	 * balance. AdditIonal Details: scraped: Balance shown in the provider site. This balance gets stored in Yodlee
	 * system during system/user account updates. carryForward : Balance carried forward from the scraped balance to the
	 * days for which the balance was not available in the system. Balance may not be available for all the days in the
	 * system due to MFA information required, error in the site, credential changes, etc. calculated: Balances that
	 * gets calculated for the days that are prior to the account added date. <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated and Manual<br>
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
	 * Date as of when the balance is last updated due to the auto account updates or user triggered updates. This
	 * balance will be carry forward for the days where there is no balance available in the system. <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated and Manual<br>
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
	 * Balance amount of the account. <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated and Manual<br>
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
	 * Indicates whether the balance is an asset or liability. <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated and Manual<br>
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
	 * The source of balance information. <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated and Manual<br>
	 * <b>Applicable containers</b>: bank, creditCard, investment, insurance, realEstate, loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts/historicalBalances</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return dataSourceType
	 */
	public BalanceDataSourceType getDataSourceType() {
		return dataSourceType;
	}

	@Override
	public String toString() {
		return "DerivedNetworthHistoricalBalance [accountId=" + accountId + ", date=" + date + ", asOfDate=" + asOfDate
				+ ", balance=" + balance + ", isAsset=" + isAsset + ", dataSourceType=" + dataSourceType + "]";
	}
}
