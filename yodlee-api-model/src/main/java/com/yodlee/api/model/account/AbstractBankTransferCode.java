/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.account;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.account.enums.BankTransferCodeType;
import io.swagger.annotations.ApiModelProperty;

public abstract class AbstractBankTransferCode extends AbstractModelComponent {

	@ApiModelProperty(value = "The FI's branch identification number."
			+ "Additional Details: The routing number of the bank account in the United States. For non-United States accounts, it is the "//
			+ "IFSC code (India), BSB number (Australia), and sort code (United Kingdom). <br>"//
			+ "<b>Account Type</b>: Aggregated<br>"//
			+ "<b>Applicable containers</b>: bank, investment<br>" + "<b>Endpoints</b>:<br>"//
			+ "<ul>"//
			+ "<li>GET accounts</li>"//
			+ "<li>GET accounts/{accountId}</li>"//
			+ "<li>POST verification</li>"//
			+ "</ul>")
	@NotNull(message = "verifications.param.banktransfercode.id.required")
	@JsonProperty("id")
	protected String id;

	@ApiModelProperty(value = "The bank transfer code type varies depending on the region of the account origination. <br>"//
			+ "<b>Account Type</b>: Aggregated<br>"//
			+ "<b>Applicable containers</b>: bank, investment<br>" + "<b>Endpoints</b>:<br>"//
			+ "<ul>"//
			+ "<li>GET accounts</li>"//
			+ "<li>GET accounts/{accountId}</li>"//
			+ "<li>POST verification</li>"//
			+ "</ul>"//
			+ "<b>Applicable Values</b><br>")
	@NotNull(message = "verifications.param.banktransfercode.type.required")
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
