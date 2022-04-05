/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account;

import java.util.Collections;
import java.util.List;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.account.enums.ItemAccountStatus;
import com.yodlee.api.model.enums.Container;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"accountType", "accountName", "nickname", "accountNumber", "balance", "url", "loginName",
		"password", "accountStatus", "includeInNetWorth", "memo", "dueDate", "homeValue", "valuationType", "amountDue",
		"frequency"})
public class UpdateAccountInfo extends AbstractAccountInfo {

	@Size(min = 1, max = 100, message = "{accounts.accountName.size.invalid}")
	@JsonProperty("accountName")
	private String accountName;

	@JsonProperty("container")
	private Container container;

	@JsonProperty("accountStatus")
	private ItemAccountStatus accountStatus;

	@JsonProperty("isEbillEnrolled")
	private String isEbillEnrolled;
	
	@ApiModelProperty(value = "List of loan accounts to which a real-estate account is linked.")
	@JsonProperty("linkedAccountIds")
	protected List<Long> linkedAccountIds;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Container getContainer() {
		return container;
	}

	public ItemAccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(ItemAccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getIsEbillEnrolled() {
		return isEbillEnrolled;
	}

	public void setIsEbillEnrolled(String isEbillEnrolled) {
		this.isEbillEnrolled = isEbillEnrolled;
	}
	
	public List<Long> getLinkedAccountIds() {
		return linkedAccountIds == null ? null : Collections.unmodifiableList(linkedAccountIds);
	}

	public void setLinkedAccountIds(List<Long> linkedAccountIds) {
		this.linkedAccountIds = linkedAccountIds;
	}

	@Override
	public String toString() {
		return "UpdateAccountInfo [accountName=" + accountName + ", container=" + container + ", accountStatus="
				+ accountStatus + ", isEbillEnrolled=" + isEbillEnrolled + ", linkedAccountIds=" + linkedAccountIds
				+ ", nickname=" + nickname + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ ", includeInNetWorth=" + includeInNetWorth + ", memo=" + memo + ", dueDate=" + dueDate
				+ ", homeValue=" + homeValue + ", amountDue=" + amountDue + ", frequency=" + frequency + "]";
	}
}
