/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.holdings.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.holdings.SecurityHolding;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HoldingSecuritiesResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("holding")
	private List<SecurityHolding> holdings;

	@JsonProperty("holding")
	public List<SecurityHolding> getHolding() {
		return holdings == null ? null : Collections.unmodifiableList(holdings);
	}

	@Override
	public String toString() {
		return "SecuritiesResponse [holdings=" + holdings + "]";
	}
}
