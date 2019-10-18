/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;
import com.yodlee.api.model.account.enums.GoalStatus;

public class UserGoal extends AbstractModelComponent {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("goalId")
	private Long goalId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("currentSaveAmount")
	private Money currentSaveAmount;

	@JsonProperty("targetDate")
	private String targetDate;

	@JsonProperty("targetGoalAmount")
	private Money targetGoalAmount;

	@JsonProperty("status")
	private GoalStatus status;

	@JsonProperty("completionDate")
	private String completionDate;

	@JsonProperty("currency")
	private String currency;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGoalId() {
		return goalId;
	}

	public void setGoalId(Long goalId) {
		this.goalId = goalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Money getCurrentSaveAmount() {
		return currentSaveAmount;
	}

	public void setCurrentSaveAmount(Money currentSaveAmount) {
		this.currentSaveAmount = currentSaveAmount;
	}

	public String getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}

	public Money getTargetGoalAmount() {
		return targetGoalAmount;
	}

	public void setTargetGoalAmount(Money targetGoalAmount) {
		this.targetGoalAmount = targetGoalAmount;
	}

	public GoalStatus getStatus() {
		return status;
	}

	public void setStatus(GoalStatus status) {
		this.status = status;
	}

	public String getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
