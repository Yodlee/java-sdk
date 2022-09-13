/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.payment.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.account.enums.BankTransferCodeType;

import io.swagger.annotations.ApiModelProperty;

public class PaymentAccount extends PaymentAccountBalance {

	@ApiModelProperty(readOnly = true, value = "Full account number List of the account that is included only when include = fullAccountNumberList is provided in the request. "
			+ "<br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul><li>GET /partner/paymentProcessor/account</li>"//
			+ "</ul>")
	@JsonProperty("fullAccountNumberList")
	private FullAccountNumbers fullAccountNumberList;

	@ApiModelProperty(readOnly = true, value = "Bank and branch identification information.<br>"//
			+ "<br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul><li>GET /partner/paymentProcessor/account</li>"//
			+ "</ul>")
	@JsonProperty("bankTransferCode")
	protected List<PaymentBankTransferCodeData> bankTransferCode;

	/**
	 * Full account number List of the account that is included only when include =
	 * fullAccountNumberList is provided in the request. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: bank, creditCard, investment, insurance, loan,
	 * reward, otherAssets, otherLiabilities <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * 
	 * @return fullAccountNumberList
	 */
	public FullAccountNumbers getFullAccountNumberList() {
		return fullAccountNumberList;
	}

	@JsonProperty("bankTransferCode")
	public List<PaymentBankTransferCodeData> getBankTransferCode() {
		return bankTransferCode == null ? null : Collections.unmodifiableList(bankTransferCode);
	}
	
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({"paymentAccountNumber", "unmaskedAccountNumber"})
	public class FullAccountNumbers {
		
		@ApiModelProperty(readOnly = true,
				  value = "The payment account number is used for payments in all regions, this may be looked as an ACH account number in the US."//
						    + "<br>"//
							+ "<b>Endpoints</b>:"//
							+ "<ul><li>GET /partner/paymentProcessor/account</li>"//
							+ "</ul>")
		@JsonProperty("paymentAccountNumber")
		private String paymentAccountNumber;
		
		@ApiModelProperty(readOnly = true,
				  value = "The unmasked account number is same as account number that is used to refer to an account and is not partial or masked."//
						    + "<br>"//
							+ "<b>Endpoints</b>:"//
							+ "<ul><li>GET /partner/paymentProcessor/account</li>"//
							+ "</ul>")
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
	
	public abstract class PaymentBankTransferCodeData extends AbstractModelComponent {

		@ApiModelProperty(value = "The financial institution's branch identification number that is associated with the lender."//
				 + "<br>"//
					+ "<b>Endpoints</b>:"//
					+ "<ul><li>GET /partner/paymentProcessor/account</li>"//
					+ "</ul>")
		@JsonProperty("id")
		protected String id;

		@ApiModelProperty(value = "The payment bank transfer code type varies based on the region of the account originates from. <br>Valid Values: BSB, IFSC, ROUTING_NUMBER, SORT_CODE"//
				 + "<br>"//
					+ "<b>Endpoints</b>:"//
					+ "<ul><li>GET /partner/paymentProcessor/account</li>"//
					+ "</ul>"
				+ "<b>Applicable Values</b><br>")
		@JsonProperty("type")
		protected BankTransferCodeType type;

		/**
		 * The FI's branch identification number. Additional Details: The routing number of the bank account in the United
		 * States. For non-United States accounts, it is the IFSC code (India), BSB number (Australia), and sort code
		 * (United Kingdom). <br>
		 * <b>Account Type</b>: Aggregated<br>
		 * <b>Applicable containers</b>: bank, investment<br>
		 * <b>Endpoints</b>:<br>
		 * <ul>
		 * <li>GET accounts</li>
		 * <li>GET accounts/{accountId}</li>
		 * <li>POST verification</li>
		 * </ul>
		 * 
		 * @return id
		 */
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		/**
		 * The bank transfer code type varies depending on the region of the account origination. <br>
		 * <b>Account Type</b>: Aggregated<br>
		 * <b>Applicable containers</b>: bank, investment<br>
		 * <b>Endpoints</b>:<br>
		 * <ul>
		 * <li>GET accounts</li>
		 * <li>GET accounts/{accountId}</li>
		 * <li>POST verification</li>
		 * </ul>
		 * <b>Applicable Values</b><br>
		 * 
		 * @return type
		 */
		public BankTransferCodeType getType() {
			return type;
		}

		public void setType(BankTransferCodeType type) {
			this.type = type;
		}
	}
	

}
