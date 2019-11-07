/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.account;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;
import com.yodlee.api.model.account.enums.FrequencyType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"nickname", "accountNumber", "balance", "includeInNetWorth", "memo", "dueDate", "homeValue",
		"amountDue"})
public class AbstractAccountInfo extends AbstractModelComponent {

	@Size(max = 50, message = "{accounts.nickname.length.invalid}")
	@JsonProperty("nickname")
	protected String nickname;

	@Size(max = 100, message = "{accounts.accountNumber.length.invalid}")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "{accounts.accountNumber.invalid}")
	@JsonProperty("accountNumber")
	protected String accountNumber;

	@Valid
	@JsonProperty("balance")
	protected Money balance;

	@JsonProperty("includeInNetWorth")
	protected String includeInNetWorth;

	@Size(max = 250, message = "{accounts.memo.length.invalid}")
	@JsonProperty("memo")
	protected String memo;

	@JsonProperty("dueDate")
	protected String dueDate;

	@Valid
	@JsonProperty("homeValue")
	protected Money homeValue;

	@Valid
	@JsonProperty("amountDue")
	protected Money amountDue;

	@JsonProperty("frequency")
	protected FrequencyType frequency;

	public Money getBalance() {
		return balance;
	}

	public void setBalance(Money balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getIncludeInNetWorth() {
		return includeInNetWorth;
	}

	public void setIncludeInNetWorth(String includeInNetWorth) {
		this.includeInNetWorth = includeInNetWorth;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Money getHomeValue() {
		return homeValue;
	}

	public void setHomeValue(Money homeValue) {
		this.homeValue = homeValue;
	}

	public Money getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(Money amountDue) {
		this.amountDue = amountDue;
	}

	public FrequencyType getFrequency() {
		return frequency;
	}

	public void setFrequency(FrequencyType frequency) {
		this.frequency = frequency;
	}
}
