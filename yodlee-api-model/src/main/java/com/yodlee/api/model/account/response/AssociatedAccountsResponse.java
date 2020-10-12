/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.account.AssociatedAccount;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssociatedAccountsResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("account")
	private List<AssociatedAccount> associatedAccounts;

	@JsonProperty("account")
	public List<AssociatedAccount> getAssociatedAccounts() {
		return associatedAccounts == null ? null : Collections.unmodifiableList(associatedAccounts);
	}

	@Override
	public String toString() {
		return "AssociateAccountsResponse [accounts=" + associatedAccounts + "]";
	}
}
