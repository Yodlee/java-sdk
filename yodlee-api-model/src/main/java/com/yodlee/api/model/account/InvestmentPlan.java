/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.account;

import java.util.List;
import com.yodlee.api.model.AbstractModelComponent;

public class InvestmentPlan extends AbstractModelComponent {

	private Long providerId;

	private String providerName;

	private String asOfDate;

	private String planName;

	private String planNumber;

	private Long id;

	private String lastUpdated;

	private String returnAsOfDate;

	private String feesAsOfDate;

	private List<InvestmentOption> investmentOption;

	public Long getProviderId() {
		return providerId;
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getAsOfDate() {
		return asOfDate;
	}

	public void setAsOfDate(String asOfDate) {
		this.asOfDate = asOfDate;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanNumber() {
		return planNumber;
	}

	public void setPlanNumber(String planNumber) {
		this.planNumber = planNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getReturnAsOfDate() {
		return returnAsOfDate;
	}

	public void setReturnAsOfDate(String returnAsOfDate) {
		this.returnAsOfDate = returnAsOfDate;
	}

	public String getFeesAsOfDate() {
		return feesAsOfDate;
	}

	public void setFeesAsOfDate(String feesAsOfDate) {
		this.feesAsOfDate = feesAsOfDate;
	}

	public List<InvestmentOption> getInvestmentOption() {
		return investmentOption;
	}

	public void setInvestmentOption(List<InvestmentOption> investmentOption) {
		this.investmentOption = investmentOption;
	}
}
