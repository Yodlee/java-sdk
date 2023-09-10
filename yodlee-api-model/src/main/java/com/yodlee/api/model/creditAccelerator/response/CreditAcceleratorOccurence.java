/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.ALWAYS)
@JsonPropertyOrder({"timePeriod", "count"})
public class CreditAcceleratorOccurence {
	
	@JsonProperty("timePeriod")
	@ApiModelProperty(readOnly = true, value = "Time intervals to consider up to the number of days the application was requested.")
	private String timePeriod;
	
	@JsonProperty("count")
	@ApiModelProperty(readOnly = true, value = "Number of times the event has occurred within the given time period.")
	private Double count;

	public String getTimePeriod() {
		return timePeriod;
	}

	public Double getCount() {
		return count;
	}

}
