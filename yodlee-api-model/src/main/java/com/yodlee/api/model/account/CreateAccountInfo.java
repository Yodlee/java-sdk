/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.account.enums.ValuationType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"accountType", "accountName", "nickname", "accountNumber", "balance", "url", "loginName",
		"password", "includeInNetWorth", "memo", "dueDate", "homeValue", "valuationType", "amountDue", "frequency"})
public class CreateAccountInfo extends AbstractAccountInfo {

	@NotEmpty(message = "{accounts.accountName.required}")
	@Size(min = 1, max = 100, message = "{accounts.accountName.size.invalid}")
	@JsonProperty("accountName")
	private String accountName;

	@NotEmpty(message = "{accounts.accountType.required}")
	@JsonProperty("accountType")
	private String accountType;

	@JsonProperty("valuationType")
	private ValuationType valuationType;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public ValuationType getValuationType() {
		return valuationType;
	}

	public void setValuationType(ValuationType valuationType) {
		this.valuationType = valuationType;
	}

	@Override
	public String toString() {
		return "CreateAccountInfo [accountName=" + accountName + ", accountType=" + accountType + ", valuationType="
				+ valuationType + ", nickname=" + nickname + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ ", includeInNetWorth=" + includeInNetWorth + ", memo=" + memo + ", dueDate=" + dueDate
				+ ", homeValue=" + homeValue + ", amountDue=" + amountDue + ", frequency=" + frequency + "]";
	}
}
