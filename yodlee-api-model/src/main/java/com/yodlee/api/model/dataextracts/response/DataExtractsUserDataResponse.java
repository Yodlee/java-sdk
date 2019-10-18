/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.dataextracts.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.dataextracts.DataExtractsUserData;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"userData"})
public class DataExtractsUserDataResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("userData")
	private List<DataExtractsUserData> userData;

	@JsonProperty("userData")
	public List<DataExtractsUserData> getUserData() {
		return userData == null ? null : Collections.unmodifiableList(userData);
	}

	@Override
	public String toString() {
		return "DataExtractsUserDataResponse [userData=" + userData + "]";
	}
}
