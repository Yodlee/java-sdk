/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.derived.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.derived.DerivedHoldingsLinks;
import com.yodlee.api.model.derived.DerivedHoldingsSummary;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"holdingsSummary", "link"})
public class DerivedHoldingSummaryResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("holdingSummary")
	private List<DerivedHoldingsSummary> derivedHoldingsSummaries;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("link")
	private DerivedHoldingsLinks links;

	@JsonProperty("holdingSummary")
	public List<DerivedHoldingsSummary> getDerivedHoldingsSummaries() {
		return derivedHoldingsSummaries == null ? null : Collections.unmodifiableList(derivedHoldingsSummaries);
	}

	public DerivedHoldingsLinks getLinks() {
		return links;
	}

	@Override
	public String toString() {
		return "HoldingSummaryResponse [holdingsSummary=" + derivedHoldingsSummaries + ", links=" + links + "]";
	}
}
