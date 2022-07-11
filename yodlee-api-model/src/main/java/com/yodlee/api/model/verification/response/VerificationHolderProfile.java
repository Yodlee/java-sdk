/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.verification.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractAddress;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Email;
import com.yodlee.api.model.PhoneNumber;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.enums.VerificationRequestFailedReason;
import com.yodlee.api.model.user.UserAddress;
import com.yodlee.api.model.verification.Verification;
import com.yodlee.api.model.verification.VerifiedAccounts;
import com.yodlee.api.model.verification.enums.VerifiedAccountsVerificationState;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"providerAccountId", "accountId", "holder", "phoneNumber", "email"})
public class VerificationHolderProfile extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true, value = "The primary key of the provider account resource")
	@JsonProperty("providerAccountId")
	private Long providerAccountId;
	
	@ApiModelProperty(readOnly = true, value = "The primary key of the account resource and the unique identifier for the account")
	@JsonProperty("accountId")
	private Long accountId;
	
	@ApiModelProperty(readOnly = true, value = "The holder entity is account-specific and captures the ownership status and the name details of the user")
	@JsonProperty("holder")
	private List<VerificationHolder> holder;
	
	@ApiModelProperty(readOnly = true, value = "The account holder's address available at the profile and account levels")
	@JsonProperty("address")
	private List<AbstractAddress> address;
	
	@ApiModelProperty(readOnly = true, value = "The account holder's phone number available at the profile and account levels")
	@JsonProperty("phoneNumber")
	private List<PhoneNumber> phoneNumber;
	
	@ApiModelProperty(readOnly = true, value = "The account holder's email ID available at the profile and account levels")
	@JsonProperty("email")
	private List<Email> email;
	
	
	@JsonProperty("providerAccountId")
	public Long getProviderAccountId() {
		return providerAccountId;
	}


	@JsonProperty("accountId")
	public Long getAccountId() {
		return accountId;
	}


	@JsonProperty("holder")
	public List<VerificationHolder> getHolder() {
		return holder == null ? null : Collections.unmodifiableList(holder);
	}


	@JsonProperty("phoneNumber")
	public List<PhoneNumber> getPhoneNumber() {
		return phoneNumber == null ? null : Collections.unmodifiableList(phoneNumber);
	}


	@JsonProperty("email")
	public List<Email> getEmail() {
		return email == null ? null : Collections.unmodifiableList(email);
	}



	@Override
	public String toString() {
		return "VerificationHolderProfile [providerAccountId=" + providerAccountId + ", accountId=" + accountId
				+ ", holder=" + holder + ", address=" + address  + ", phoneNumber=" + phoneNumber  + ", email=" + email + "]";
	}
}
