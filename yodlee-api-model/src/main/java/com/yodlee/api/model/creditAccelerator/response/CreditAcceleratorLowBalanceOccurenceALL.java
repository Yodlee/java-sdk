/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"segment1", "segment2", "segment3", "segment4"})
public class CreditAcceleratorLowBalanceOccurenceALL {
	
	// for all account analysis
	@JsonProperty("segment1")
	private List<CreditAcceleratorAllAccountBalanceOccurrence> segment1;
	
	@JsonProperty("segment2")
	private List<CreditAcceleratorAllAccountBalanceOccurrence> segment2;
	
	@JsonProperty("segment3")
	private List<CreditAcceleratorAllAccountBalanceOccurrence> segment3;
	
	@JsonProperty("segment4")
	private List<CreditAcceleratorAllAccountBalanceOccurrence> segment4;

	public List<CreditAcceleratorAllAccountBalanceOccurrence> getSegment1() {
		return segment1;
	}

	public List<CreditAcceleratorAllAccountBalanceOccurrence> getSegment2() {
		return segment2;
	}

	public List<CreditAcceleratorAllAccountBalanceOccurrence> getSegment3() {
		return segment3;
	}

	public List<CreditAcceleratorAllAccountBalanceOccurrence> getSegment4() {
		return segment4;
	}

}
