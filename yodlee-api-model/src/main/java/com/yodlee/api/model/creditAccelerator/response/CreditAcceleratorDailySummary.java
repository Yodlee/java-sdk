/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({"timePeriod", "sum", "count", "avg", "min", "max"})
public class CreditAcceleratorDailySummary {
	
	@JsonProperty("timePeriod")
	@ApiModelProperty(readOnly = true, value = "Time intervals to consider up to the number of days the application was requested.")
	private String timePeriod;
	
	@JsonProperty("sum")
	@ApiModelProperty(readOnly = true, value = "Total amount for the time period.")
	private Double sum;
	
	@JsonProperty("count")
	@ApiModelProperty(readOnly = true, value = "Number of data points available in the time period.")
	private Double count;
	
	@JsonProperty("avg")
	@ApiModelProperty(readOnly = true, value = "Average amount for the time period (sum divided by count).")
	private Double avg;
	
	@JsonProperty("min")
	private CreditAcceleratorBalance min;
	
	@JsonProperty("max")
	private CreditAcceleratorBalance max;

	public String getTimePeriod() {
		return timePeriod;
	}

	public Double getSum() {
		return sum;
	}

	public Double getCount() {
		return count;
	}

	public Double getAvg() {
		return avg;
	}

	public CreditAcceleratorBalance getMin() {
		return min;
	}

	public CreditAcceleratorBalance getMax() {
		return max;
	}
	
}
