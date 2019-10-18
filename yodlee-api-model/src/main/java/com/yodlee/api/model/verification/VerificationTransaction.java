/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.verification;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;
import com.yodlee.api.model.enums.BaseType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"amount", "baseType"})
public class VerificationTransaction extends AbstractModelComponent {

	@JsonProperty("amount")
	@NotNull(message = "verifications.transaction.amount.required")
	@Valid
	private Money amount;

	@JsonProperty("baseType")
	@NotNull(message = "verifications.transaction.baseType.required")
	private BaseType baseType;

	public Money getAmount() {
		return amount;
	}

	public void setAmount(Money amount) {
		this.amount = amount;
	}

	public BaseType getBaseType() {
		return baseType;
	}

	public void setBaseType(BaseType baseType) {
		this.baseType = baseType;
	}

	@Override
	public String toString() {
		return "Transaction [amount=" + amount + ", baseType=" + baseType + "]";
	}
}
