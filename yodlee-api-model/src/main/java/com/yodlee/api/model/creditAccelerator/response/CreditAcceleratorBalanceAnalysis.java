/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;


@JsonInclude(Include.ALWAYS)
@JsonPropertyOrder({"timePeriod", "daysAboveAverage", "daysBelowAverage", "balanceStandardDeviation"})
public class CreditAcceleratorBalanceAnalysis {
	
	@JsonProperty("timePeriod")
	@ApiModelProperty(readOnly = true, value = "Time intervals to consider up to the number of days the application was requested")
	private String timePeriod;

	@JsonProperty("daysAboveAverage")
	@ApiModelProperty(readOnly = true, value = "Number of Daily Balances that are above the average for the time period.")
	private Double daysAboveAverage;

	@JsonProperty("daysBelowAverage")
	@ApiModelProperty(readOnly = true, value = "Number of Daily Balances that are below the average for the time period.")
	private Double daysBelowAverage;

	@JsonProperty("balanceStandardDeviation")
	@ApiModelProperty(readOnly = true, value = "Standard Deviation of Daily Balance for the time period.")
	private Double balanceStandardDeviation;

	public String getTimePeriod() {
		return timePeriod;
	}

	public Double getDaysAboveAverage() {
		return daysAboveAverage;
	}

	public Double getDaysBelowAverage() {
		return daysBelowAverage;
	}

	public Double getBalanceStandardDeviation() {
		return balanceStandardDeviation;
	}

}
