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
import com.yodlee.api.model.account.enums.RewardBalanceType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"description", "balance", "units", "balanceType", "expiryDate", "balanceToLevel",
		"balanceToReward"})
public class RewardBalance extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "The description for the reward balance as available at provider source."//
							  + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: reward<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("description")
	private String description;

	@ApiModelProperty(readOnly = true,
					  value = "The actual reward balance."//
							  + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: reward<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("balance")
	private Double balance;

	@ApiModelProperty(readOnly = true,
					  value = "Unit of reward balance - miles, points, segments, dollars, credits."//
							  + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: reward<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("units")
	private String units;

	@ApiModelProperty(readOnly = true,
					  value = "The type of reward balance."//
							  + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: reward<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("balanceType")
	private RewardBalanceType balanceType;

	@ApiModelProperty(readOnly = true,
					  value = "The date on which the balance expires."//
							  + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: reward<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("expiryDate")
	private String expiryDate;

	@ApiModelProperty(readOnly = true,
					  value = "The balance required to reach a reward level."//
							  + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: reward<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("balanceToLevel")
	private String balanceToLevel;

	@ApiModelProperty(readOnly = true,
					  value = "The balance required to qualify for a reward such as retaining membership, business reward, etc."//
							  + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: reward<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("balanceToReward")
	private String balanceToReward;

	/**
	 * The description for the reward balance as available at provider source. <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Applicable containers</b>: reward<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * The actual reward balance. <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Applicable containers</b>: reward<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return balance
	 */
	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/**
	 * Unit of reward balance - miles, points, segments, dollars, credits. <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Applicable containers</b>: reward<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return units
	 */
	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	/**
	 * The type of reward balance. <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Applicable containers</b>: reward<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return balanceType
	 */
	public RewardBalanceType getBalanceType() {
		return balanceType;
	}

	public void setBalanceType(RewardBalanceType balanceType) {
		this.balanceType = balanceType;
	}

	/**
	 * The date on which the balance expires. <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Applicable containers</b>: reward<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return expiryDate
	 */
	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * The balance required to reach a reward level. <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Applicable containers</b>: reward<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return balanceToLevel
	 */
	public String getBalanceToLevel() {
		return balanceToLevel;
	}

	public void setBalanceToLevel(String balanceToLevel) {
		this.balanceToLevel = balanceToLevel;
	}

	/**
	 * The balance required to qualify for a reward such as retaining membership, business reward, etc. <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Applicable containers</b>: reward<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return balanceToReward
	 */
	public String getBalanceToReward() {
		return balanceToReward;
	}

	public void setBalanceToReward(String balanceToReward) {
		this.balanceToReward = balanceToReward;
	}

	@Override
	public String toString() {
		return "RewardBalance [description=" + description + ", balance=" + balance + ", units=" + units
				+ ", balanceType=" + balanceType + ", expiryDate=" + expiryDate + ", balanceToLevel=" + balanceToLevel
				+ ", balanceToReward=" + balanceToReward + "]";
	}
}
