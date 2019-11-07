/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.verifyaccount.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.verifyaccount.VerifyAccount;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerifyAccountResponse extends AbstractModelComponent implements Response {

	@JsonProperty("verifyAccount")
	private VerifyAccount verifyAccount;

	public VerifyAccount getVerifyAccount() {
		return verifyAccount;
	}

	@Override
	public String toString() {
		return "VerifyAccountResponse [verifyAccount=" + verifyAccount + "]";
	}
}
