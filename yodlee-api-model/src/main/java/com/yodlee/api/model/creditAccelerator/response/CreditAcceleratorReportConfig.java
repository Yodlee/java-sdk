/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.creditAccelerator.CreditAcceleratorRequestingFirm;
import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({"lowBalAmt1", "lowBalAmt2", "lowBalAmt3", "lowBalAmt4", "largeCreditAmt", "days", "requestingFirm"})
public class CreditAcceleratorReportConfig {
	
	@ApiModelProperty(readOnly = true,
		value = "First upper limit which is used to count the number of times the consumer''s Daily Balance amount fell below this amount in Low Balance Occurrence: Segment 1")
	@JsonProperty("lowBalAmt1")
	private double lowBalAmt1;

	@ApiModelProperty(readOnly = true,
		value = "Second upper limit which is used to count the number of times the consumer''s Daily Balance amount fell below this amount in Low Balance Occurrence: Segment 2")
	@JsonProperty("lowBalAmt2")
	private double lowBalAmt2;

	@ApiModelProperty(readOnly = true,
		value = "Third upper limit which is used to count the number of times the consumer''s Daily Balance amount fell below this amount in Low Balance Occurrence: Segment 3")
	@JsonProperty("lowBalAmt3")
	private double lowBalAmt3;

	@ApiModelProperty(readOnly = true,
		value = "Fourth upper limit which is used to count the number of times the consumer''s Daily Balance amount fell below this amount in Low Balance Occurrence: Segment 4")
	@JsonProperty("lowBalAmt4")
	private double lowBalAmt4;

	@ApiModelProperty(readOnly = true,
		value = "Lower limit used to count the number of times the consumer's credit transactions exceeded this amount in Large Deposit Occurrence and Large Transfer Occurrence")
	@JsonProperty("largeCreditAmt")
	private double largeCreditAmt;

	@ApiModelProperty(readOnly = true,
		value = "No of days for which the credit accelerator file is requested")
	@JsonProperty("days")
	private int days;

	@ApiModelProperty(readOnly = true,
		value = "Details the partner can provide to identify the requestor")
	@JsonProperty("requestingFirm")
	private CreditAcceleratorRequestingFirm requestingFirm;

	public double getLowBalAmt1() {
		return lowBalAmt1;
	}

	public double getLowBalAmt2() {
		return lowBalAmt2;
	}

	public double getLowBalAmt3() {
		return lowBalAmt3;
	}

	public double getLowBalAmt4() {
		return lowBalAmt4;
	}

	public double getLargeCreditAmt() {
		return largeCreditAmt;
	}

	public int getDays() {
		return days;
	}

	public CreditAcceleratorRequestingFirm getRequestingFirm() {
		return requestingFirm;
	}
}
