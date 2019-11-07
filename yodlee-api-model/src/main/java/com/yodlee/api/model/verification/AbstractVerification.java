/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.verification;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.verification.enums.VerificationFailureReasonType;
import com.yodlee.api.model.verification.enums.VerificationStatus;
import com.yodlee.api.model.verification.enums.VerificationType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractVerification extends AbstractModelComponent {

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

	@ApiModelProperty(readOnly = true,
					  value = "The date of the account verification."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>POST verification</li>"//
							  + "<li>GET verification</li>"//
							  + "<li>PUT verification</li>"//
							  + "</ul>")
	@JsonProperty("verificationDate")
	protected String verificationDate;

	@ApiModelProperty(readOnly = true,
					  value = "The reason the account verification failed."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>POST verification</li>"//
							  + "<li>GET verification</li>"//
							  + "<li>PUT verification</li>"//
							  + "</ul>")
	@JsonProperty("reason")
	protected VerificationFailureReasonType reason;

	@ApiModelProperty(readOnly = true,
					  value = "The status of the account verification."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>POST verification</li>"//
							  + "<li>GET verification</li>"//
							  + "<li>PUT verification</li>"//
							  + "</ul>"//
							  + "<br><b>Applicable Values</b>")
	@JsonProperty("verificationStatus")
	protected VerificationStatus verificationStatus;

	@ApiModelProperty(readOnly = true,
					  value = "Unique identifier for the verification request."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>POST verification</li>"//
							  + "<li>GET verification</li>"//
							  + "<li>PUT verification</li>"//
							  + "</ul>")
	@JsonProperty("verificationId")
	protected Long verificationId;

	@Valid
	@JsonProperty("account")
	protected VerificationAccount account;

	public VerificationAccount getAccount() {
		return account;
	}

	public void setAccount(VerificationAccount account) {
		this.account = account;
	}

	/**
	 * The date of the account verification. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST verification</li>
	 * <li>GET verification</li>
	 * <li>PUT verification</li>
	 * </ul>
	 * 
	 * @return verificationDate
	 */
	public String getVerificationDate() {
		return verificationDate;
	}

	public void setVerificationDate(String verificationDate) {
		this.verificationDate = verificationDate;
	}

	/**
	 * The reason the account verification failed. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST verification</li>
	 * <li>GET verification</li>
	 * <li>PUT verification</li>
	 * </ul>
	 * 
	 * @return reason
	 */
	public VerificationFailureReasonType getReason() {
		return reason;
	}

	public void setReason(VerificationFailureReasonType reason) {
		this.reason = reason;
	}

	/**
	 * The status of the account verification. <br>
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
	 * @return verificationStatus
	 */
	public VerificationStatus getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(VerificationStatus verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	/**
	 * Unique identifier for the verification request. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST verification</li>
	 * <li>GET verification</li>
	 * <li>PUT verification</li>
	 * </ul>
	 * 
	 * @return verificationId
	 */
	public Long getVerificationId() {
		return verificationId;
	}

	public void setVerificationId(Long verificationId) {
		this.verificationId = verificationId;
	}

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
				+ ", providerAccountId=" + providerAccountId + ", verificationDate=" + verificationDate + ", reason="
				+ reason + ", verificationStatus=" + verificationStatus + ", verificationId=" + verificationId
				+ ", account=" + account + "]";
	}
}
