/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.provideraccounts.response;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;

import io.swagger.annotations.ApiModelProperty;

public class RefreshProviderAccountResponse extends AbstractModelComponent implements Response {
	
	@JsonProperty("statusLink")
	@ApiModelProperty(readOnly = true)
	public ArrayList<StatusLink> statusLink;

	public ArrayList<StatusLink> getStatusLink() {
		return statusLink;
	}

}
