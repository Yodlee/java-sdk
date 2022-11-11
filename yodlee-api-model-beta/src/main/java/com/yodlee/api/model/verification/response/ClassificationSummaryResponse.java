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
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.verification.ClassificationSummaryAccountSummary;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClassificationSummaryResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true, value = "The account summary entity encapsulates the account-level summary information, "
			+ "and the transaction entity provides a transaction-level summary for an account passed.")
	@JsonProperty("accountSummary")
	private List<ClassificationSummaryAccountSummary> accountSummary;

	@JsonProperty("accountSummary")
	public List<ClassificationSummaryAccountSummary> getAccountSummary() {
		return accountSummary == null ? null : Collections.unmodifiableList(accountSummary);
	}

	@Override
	public String toString() {
		return "ClassificationSummaryAccountSummary [accountSummary=" + accountSummary + "]";
	}
}
