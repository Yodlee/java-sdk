/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.payment.request;

import java.util.List;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentProcessorTokenRequest extends AbstractModelComponent implements Request{

	@ApiModelProperty(value = "The unique identifier for the user's account.", required = true)
	@JsonProperty(value = "accountId", required = true)
	@NotNull
	List<Long> accountId;

	@ApiModelProperty(value = "The payment processor with whom the customer is integrating.", required = true)
	@JsonProperty(value = "processor", required = true)
	@NotNull
	String processor;

	
	@JsonProperty("accountId")
	public List<Long> getAccountId() {
		return accountId;
	}

	@JsonProperty("accountId")
	public void setAccountId(List<Long> accountId) {
		this.accountId = accountId;
	}

	@JsonProperty("processor")
	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getProcessor() {
		return processor;
	}
	

}
