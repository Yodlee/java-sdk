/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"address", "identifier", "paymentBankTransferCode"})
public class CreditAcceleratorPaymentProfile extends AbstractModelComponent {

	@ApiModelProperty(value = "The address of the lender to which the monthly payments or the loan payoff amount should be paid. "
			+ "<br><b>Additional Details:</b>"//
			+ "The address field applies only to the student loan account type.<br>"//
			+ "<b>Account Type</b>: Aggregated<br>"//
			+ "<b>Applicable containers</b>: loan<br>"//
			+ "<b>Endpoints</b>:<br>"//
			+ "<ul>"//
			+ "<li>GET accounts</li>"//
			+ "<li>GET accounts/{accountId}</li>"//
			+ "</ul>")
	@JsonProperty("address")
	private List<CreditAcceleratorAccountAddress> addresses;

	@ApiModelProperty(value = "The additional information such as platform code or payment reference number that is required to make payments."//
			+ "<br><b>Additional Details:</b>" + "The identifier field applies only to the student loan account type."//
			+ "<br><br>"//
			+ "<b>Account Type</b>: Aggregated<br>"//
			+ "<b>Applicable containers</b>: loan<br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET accounts</li>"//
			+ "<li>GET accounts/{accountId}</li>"//
			+ "</ul>")
	@JsonProperty("identifier")
	private PaymentIdentifier identifier;

	@ApiModelProperty(value = "The additional information for payment bank transfer code."//
			+ "<br><br>"//
			+ "<b>Applicable containers</b>: loan<br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET accounts</li>"//
			+ "<li>GET accounts/{accountId}</li>"//
			+ "</ul>")
	@JsonProperty("paymentBankTransferCode")
	private List<CreditAcceleratorPaymentBankTransferCode> paymentBankTransferCode;

	/**
	 * The additional information for payment bank transfer code.<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return paymentBankTransferCode
	 */
	public List<CreditAcceleratorPaymentBankTransferCode> getPaymentBankTransferCode() {
		return paymentBankTransferCode;
	}

	/**
	 * The address of the lender to which the monthly payments or the loan payoff amount should be paid. <br>
	 * <b>Additional Details:</b> The address field applies only to the student loan account type.<br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return address
	 */
	@JsonProperty("address")
	public List<CreditAcceleratorAccountAddress> getAddress() {
		return addresses == null ? null : Collections.unmodifiableList(addresses);
	}

	/**
	 * The additional information such as platform code or payment reference number that is required to make payments.
	 * <br>
	 * <b>Additional Details:</b> * The identifier field applies only to the student loan account type. <br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return identifier
	 */
	public PaymentIdentifier getIdentifier() {
		return identifier;
	}

	@Override
	public String toString() {
		return "PaymentProfile [addresses=" + addresses + ", identifier=" + identifier + ", paymentBankTransferCode="
				+ paymentBankTransferCode + "]";
	}
}
