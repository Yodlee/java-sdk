/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.verification;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"accountId", "providerAccountId", "verificationType", "verificationDate", "reason",
		"verificationStatus", "verificationId", "account"})
public class Verification extends AbstractVerification {

	@Override
	public String toString() {
		return "Verification [accountId=" + accountId + ", verificationType=" + verificationType
				+ ", providerAccountId=" + providerAccountId + ", verificationDate=" + verificationDate + ", reason="
				+ reason + ", verificationStatus=" + verificationStatus + ", verificationId=" + verificationId
				+ ", account=" + account + "]";
	}
}
