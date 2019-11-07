/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "accountNumber", "accountName"})
public class CreatedAccountInfo extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("id")
	private Long id;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("accountNumber")
	private String accountNumber;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("accountName")
	private String accountName;

	public Long getId() {
		return id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	@Override
	public String toString() {
		return "CreatedAccountInfo [id=" + id + ", accountNumber=" + accountNumber + ", accountName=" + accountName
				+ "]";
	}
}
