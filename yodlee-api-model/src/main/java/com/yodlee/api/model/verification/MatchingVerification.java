/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.verification;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.verification.enums.VerificationType;
import io.swagger.annotations.ApiModelProperty;

public class MatchingVerification extends AbstractModelComponent {


	@ApiModelProperty(value = "Unique identifier for the account."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>POST verification</li>"//
			+ "<li>GET verification</li>"//
			+ "<li>PUT verification</li>"//
			+ "</ul>")
	@JsonProperty("accountId")
	protected Long accountId;

	@ApiModelProperty(value = "The account verification type."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>POST verification</li>"//
			+ "<li>GET verification</li>"//
			+ "<li>PUT verification</li>"//
			+ "</ul>"//
			+ "<br><b>Applicable Values</b>")
	@NotNull(message = "{verifications.param.verificationType.required}")
	@JsonProperty("verificationType")
	protected VerificationType verificationType;

	@ApiModelProperty(value = "Unique identifier for the provider account."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>POST verification</li>"//
			+ "<li>GET verification</li>"//
			+ "<li>PUT verification</li>"//
			+ "</ul>")
	@JsonProperty("providerAccountId")
	protected Long providerAccountId;


	/**
	 * Unique identifier for the account. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST verification</li>
	 * <li>GET verification</li>
	 * <li>PUT verification</li>
	 * </ul>
	 * 
	 * @return accountId
	 */
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	/**
	 * The account verification type. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST verification</li>
	 * <li>GET verification</li>
	 * <li>PUT verification</li>
	 * </ul>
	 * <br>
	 * <b>Applicable Values</b>
	 * 
	 * @return verificationType
	 */
	public VerificationType getVerificationType() {
		return verificationType;
	}

	public void setVerificationType(VerificationType verificationType) {
		this.verificationType = verificationType;
	}

	/**
	 * Unique identifier for the provider account. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST verification</li>
	 * <li>GET verification</li>
	 * <li>PUT verification</li>
	 * </ul>
	 * 
	 * @return providerAccountId
	 */
	public Long getProviderAccountId() {
		return providerAccountId;
	}

	public void setProviderAccountId(Long providerAccountId) {
		this.providerAccountId = providerAccountId;
	}

	@Override
	public String toString() {
		return "Verification [accountId=" + accountId + ", verificationType=" + verificationType
				+ ", providerAccountId=" + providerAccountId + "]";
	}

}
