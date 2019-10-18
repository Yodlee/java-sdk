/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
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
