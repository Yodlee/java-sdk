/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.verification;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.verification.enums.VerificationAccountType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"accountNumber", "accountType", "bankTransferCode"})
public class VerificationAccount extends AbstractModelComponent {

	@NotNull(message = "{verifications.account.number.required}")
	@Size(min = 3, max = 17, message = "{verifications.account.number.length.invalid}")
	@JsonProperty("accountNumber")
	private String accountNumber;

	@NotNull(message = "{verifications.account.type.required}")
	@JsonProperty("accountType")
	private VerificationAccountType verificationAccountType;

	@NotNull(message = "{verifications.banktransfercode.required}")
	@Valid
	@JsonProperty("bankTransferCode")
	private VerificationBankTransferCode bankTransferCode;

	@JsonProperty("accountName")
	private String accountName;

	public VerificationBankTransferCode getBankTransferCode() {
		return bankTransferCode;
	}

	public void setBankTransferCode(VerificationBankTransferCode bankTransferCode) {
		this.bankTransferCode = bankTransferCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@JsonProperty("accountType")
	public VerificationAccountType getVerificationAccountType() {
		return verificationAccountType;
	}

	@JsonProperty("accountType")
	public void setVerificationAccountType(VerificationAccountType accountType) {
		this.verificationAccountType = accountType;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Override
	public String toString() {
		return "VerificationAccount [accountNumber=" + accountNumber + ", verificationAccountType="
				+ verificationAccountType + ", bankTransferCode=" + bankTransferCode + ", accountName=" + accountName
				+ "]";
	}
}
