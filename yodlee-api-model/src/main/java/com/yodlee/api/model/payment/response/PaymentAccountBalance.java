/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.payment.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.Money;

import io.swagger.annotations.ApiModelProperty;

public class PaymentAccountBalance extends PaymentAccountBase {
	@ApiModelProperty(readOnly = true, value = "The balance in the account that is available at the beginning of the "
			+ "business day; it is equal to the ledger balance of the account.<br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul><li>GET /partner/paymentProcessor/account</li>"//
			+ "<li>GET /partner/paymentProcessor/account/balance</li>"//
			+ "<li>GET /partner/paymentProcessor/account/holder</li>"//
			+ "</ul>")
	@JsonProperty("currentBalance")
	protected Money currentBalance;

	@ApiModelProperty(readOnly = true, value = "The balance in the account that is available for spending. "
			+ "For checking accounts with overdraft, available balance may include "
			+ "overdraft amount, if end site adds overdraft balance to available balance.<br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul><li>GET /partner/paymentProcessor/account</li>"//
			+ "<li>GET /partner/paymentProcessor/account/balance</li>"//
			+ "<li>GET /partner/paymentProcessor/account/holder</li>"//
			+ "</ul>")
	@JsonProperty("availableBalance")
	protected Money availableBalance;
	
	
	
	/**
	 * The balance in the account that is available at the beginning of the business day; it is equal to the ledger
	 * balance of the account.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return currentBalance
	 */
	public Money getCurrentBalance() {
		return currentBalance;
	}
	
	/**
	 * The balance in the account that is available for spending. For checking accounts with overdraft, available
	 * balance may include overdraft amount, if end site adds overdraft balance to available balance.<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:<br>
	 * GET accounts/{accountId}
	 * 
	 * @return availableBalance
	 */
	public Money getAvailableBalance() {
		return availableBalance;
	}
	
}
