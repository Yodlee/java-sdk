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
import com.yodlee.api.model.account.enums.PaymentBankTransferCodeType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"type", "id", "sourceType"})
public class CreditAcceleratorPaymentBankTransferCode extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true, value = "The bank transfer code type varies depending on the region of the account origination. <br><b>Account Type</b>: Aggregated<br><b>Applicable containers</b>: bank, investment<br><b>Endpoints</b>:<br><ul><li>GET accounts</li><li>GET accounts/{accountId}</li></ul><b>Applicable Values</b><br> * BSB: BSB is a Bank-State-Branch number used to identify the branch in Australia and is required for performing transfers.<br> * IFSC: IFSC is Indian Financial System Code. It is an alphanumeric code that is used to identify the particular branch in India and is required for electronic funds settlement.<br> * ROUTING_NUMBER: Bank routing number or routing transit number (RTN) is a nine digit number used in US to identify financial institution in a transaction. Most common transaction types where routing numbers are used are ACH and wire transfers.<br> * SORT_CODE: The sort code is a six-digit number used in UK to identify both the bank and the branch where the account is held.<br>")
	@JsonProperty("type")
	private PaymentBankTransferCodeType type;

	@ApiModelProperty(readOnly = true, value = "The FI's branch identification number.Additional Details: The routing number of the bank account in the United States. For non-United States accounts, it is the IFSC code (India), BSB number (Australia), and sort code (United Kingdom).\n" + 
			"Account Type: Aggregated\n" + 
			"Applicable containers: bank, investment")
	@JsonProperty("id")
	private String id;
	
	@ApiModelProperty(readOnly = true, value = "Source type")
	@JsonProperty("sourceType")
	private String sourceType;

	public PaymentBankTransferCodeType getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "PaymentBankTransferCode [type=" + type + ", id=" + id + "]";
	}
}
