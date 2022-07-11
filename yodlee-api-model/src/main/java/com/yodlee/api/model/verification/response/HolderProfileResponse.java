/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.verification.response;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HolderProfileResponse extends AbstractModelComponent implements Response {
	
	@ApiModelProperty(readOnly = true, value = "The holder profile entity encapsulates all the user's details, such as the corresponding accounts and the user’s profile data under it")
	@JsonProperty("holderProfile")
	private List<VerificationHolderProfile> holderProfileList;
	
	@JsonProperty("holderProfile")
	public List<VerificationHolderProfile> getHolderProfileList() {
		return holderProfileList == null ? null : Collections.unmodifiableList(holderProfileList);
	}

	@Override
	public String toString() {
		return "HolderProfileResponse [holderProfileList=" + holderProfileList + "]";
	}
}

