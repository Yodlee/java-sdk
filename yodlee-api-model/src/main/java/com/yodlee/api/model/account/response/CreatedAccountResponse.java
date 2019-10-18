/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.account.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.account.CreatedAccountInfo;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreatedAccountResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("account")
	private List<CreatedAccountInfo> createdAccountInfos;

	@JsonProperty("account")
	public List<CreatedAccountInfo> getAccount() {
		return createdAccountInfos == null ? null : Collections.unmodifiableList(createdAccountInfos);
	}

	@Override
	public String toString() {
		return "CreatedAccountResponse [createdAccountInfos=" + createdAccountInfos + "]";
	}
}
