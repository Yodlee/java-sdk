/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"paymentAccountNumber", "unmaskedAccountNumber"})
public class FullAccountNumberList {
	
	@ApiModelProperty(readOnly = true,
			  value = "Payment Account Number of given account."//
					  + "<br><br>"//
					  + "<b>Endpoints</b>:"//
					  + "<ul>"//
					  + "<li>GET accounts</li>"//
					  + "<li>GET accounts/{accountId}</li>"//
					  + "</ul>"//
			)
	@JsonProperty("paymentAccountNumber")
	private String paymentAccountNumber;
	
	@ApiModelProperty(readOnly = true,
			  value = "Unmasked account number of given account."//
					  + "<br><br>"//
					  + "<b>Endpoints</b>:"//
					  + "<ul>"//
					  + "<li>GET accounts</li>"//
					  + "<li>GET accounts/{accountId}</li>"//
					  + "</ul>"//
			)
	@JsonProperty("unmaskedAccountNumber")
	private String unmaskedAccountNumber;


	/**
	 * Payment Account Number of given account. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return paymentAccountNumber
	 */
	public String getPaymentAccountNumber() {
		return paymentAccountNumber;
	}


	/**
	 * Unmasked account number of given account. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return unmaskedAccountNumber
	 */
	public String getUnmaskedAccountNumber() {
		return unmaskedAccountNumber;
	}

	@Override
	public String toString() {
		return "FullAccountNumberList [paymentAccountNumber=" + paymentAccountNumber + ", unmaskedAccountNumber=" + unmaskedAccountNumber + "]";
	}
}
