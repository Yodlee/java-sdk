/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"paymentAccountId", "payment", "applyFutureStmts", "recurringEventId", "type", "lastUpdated"})
public class PaymentPref extends AbstractModelComponent {

	@JsonProperty("paymentAccountId")
	private Long paymentAccountId;

	@JsonProperty("payment")
	private Money payment;

	@JsonProperty("applyFutureStmts")
	private Boolean applyFutureStmts;

	@JsonProperty("recurringEventId")
	private Long recurringEventId;

	@JsonProperty("type")
	private String paymPrefType;

	@JsonProperty("lastUpdated")
	private String lastUpdated;

	public Long getPaymentAccountId() {
		return paymentAccountId;
	}

	public void setPaymentAccountId(Long paymentAccountId) {
		this.paymentAccountId = paymentAccountId;
	}

	public Money getPayment() {
		return payment;
	}

	public void setPayment(Money payment) {
		this.payment = payment;
	}

	public Boolean getApplyFutureStmts() {
		return applyFutureStmts;
	}

	public void setApplyFutureStmts(Boolean applyFutureStmts) {
		this.applyFutureStmts = applyFutureStmts;
	}

	public Long getRecurringEventId() {
		return recurringEventId;
	}

	public void setRecurringEventId(Long recurringEventId) {
		this.recurringEventId = recurringEventId;
	}

	public String getPaymPrefType() {
		return paymPrefType;
	}

	public void setPaymPrefType(String paymPrefType) {
		this.paymPrefType = paymPrefType;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "PaymentPref [paymentAccountId=" + paymentAccountId + ", payment=" + payment + ", applyFutureStmts="
				+ applyFutureStmts + ", recurringEventId=" + recurringEventId + ", paymPrefType=" + paymPrefType
				+ ", lastUpdated=" + lastUpdated + "]";
	}
}
