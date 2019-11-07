/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.verification;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.account.AbstractBankTransferCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "type"})
public class VerificationBankTransferCode extends AbstractBankTransferCode {

	@Override
	public String toString() {
		return "VerificationBankTransferCode [id=" + id + ", type=" + type + "]";
	}
}
