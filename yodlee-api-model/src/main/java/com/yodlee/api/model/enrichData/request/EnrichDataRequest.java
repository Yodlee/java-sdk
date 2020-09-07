/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.enrichData.request;

import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.enrichData.EnrichUserData;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"userData"})
public class EnrichDataRequest extends AbstractModelComponent implements Request {

	@Valid
	@JsonProperty("userData")
	private EnrichUserData userData;

	public EnrichUserData getUserData() {
		return userData;
	}

	public void setUserData(EnrichUserData userData) {
		this.userData = userData;
	}

	@Override
	public String toString() {
		return "DataEnrichRequest [userData=" + userData + "]";
	}
}
