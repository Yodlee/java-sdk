/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"segment1", "segment2", "segment3", "segment4"})
public class CreditAcceleratorLowBalanceOccurrence {
	
	@JsonProperty("segment1")
	private CreditAcceleratorBalanceOccurrence segment1;
	
	@JsonProperty("segment2")
	private CreditAcceleratorBalanceOccurrence segment2;
	
	@JsonProperty("segment3")
	private CreditAcceleratorBalanceOccurrence segment3;
	
	@JsonProperty("segment4")
	private CreditAcceleratorBalanceOccurrence segment4;

	public CreditAcceleratorBalanceOccurrence getSegment1() {
		return segment1;
	}

	public CreditAcceleratorBalanceOccurrence getSegment2() {
		return segment2;
	}

	public CreditAcceleratorBalanceOccurrence getSegment3() {
		return segment3;
	}

	public CreditAcceleratorBalanceOccurrence getSegment4() {
		return segment4;
	}
	
}
