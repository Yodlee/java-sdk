/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.account;

import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;

public class Claim extends AbstractModelComponent {

	private String number;

	private String date;

	private String status;

	private String provider;

	private Money cost;

	private Money owed;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public Money getCost() {
		return cost;
	}

	public void setCost(Money cost) {
		this.cost = cost;
	}

	public Money getOwed() {
		return owed;
	}

	public void setOwed(Money owed) {
		this.owed = owed;
	}
}
