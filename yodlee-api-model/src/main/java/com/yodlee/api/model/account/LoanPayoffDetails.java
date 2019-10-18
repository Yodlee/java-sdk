/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"payByDate", "payoffAmount", "outstandingBalance"})
public class LoanPayoffDetails extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "The date by which the payoff amount should be paid."//
							  + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>")
	@JsonProperty("payByDate")
	private String payByDate;

	@ApiModelProperty(readOnly = true,
					  value = "The loan payoff amount."//
							  + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>")
	@JsonProperty("payoffAmount")
	private Money payoffAmount;

	@ApiModelProperty(readOnly = true,
					  value = "The outstanding balance on the loan account. "//
							  + "The outstanding balance amount may differ from the payoff amount. "//
							  + "It is usually the sum of outstanding principal, unpaid interest, and fees, if any."//
							  + "<br><br>"//
							  + "<b>Account Type</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>")
	@JsonProperty("outstandingBalance")
	private Money outstandingBalance;

	/**
	 * The date by which the payoff amount should be paid. <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return payByDate
	 */
	public String getPayByDate() {
		return payByDate;
	}

	/**
	 * The loan payoff amount. <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return payoffAmount
	 */
	public Money getPayoffAmount() {
		return payoffAmount;
	}

	/**
	 * The outstanding balance on the loan account. The outstanding balance amount may differ from the payoff amount. It
	 * is usually the sum of outstanding principal, unpaid interest, and fees, if any. <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return outstandingBalance
	 */
	public Money getOutstandingBalance() {
		return outstandingBalance;
	}

	public void setOutstandingBalance(Money outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}

	@Override
	public String toString() {
		return "LoanPayoffDetails [payByDate=" + payByDate + ", payoffAmount=" + payoffAmount + ", outstandingBalance="
				+ outstandingBalance + "]";
	}
}
