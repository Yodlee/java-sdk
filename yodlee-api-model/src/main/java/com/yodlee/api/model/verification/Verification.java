/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
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
