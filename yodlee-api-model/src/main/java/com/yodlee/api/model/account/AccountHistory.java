/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.account;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "historicalBalances"})
public class AccountHistory extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("id")
	private Long id;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("historicalBalances")
	private List<HistoricalBalance> historicalBalances;

	public Long getId() {
		return id;
	}

	@JsonProperty("historicalBalances")
	public List<HistoricalBalance> getHistoricalBalances() {
		return historicalBalances == null ? null : Collections.unmodifiableList(historicalBalances);
	}

	@Override
	public String toString() {
		return "AccountHistory [id=" + id + ", historicalBalances=" + historicalBalances + "]";
	}
}
