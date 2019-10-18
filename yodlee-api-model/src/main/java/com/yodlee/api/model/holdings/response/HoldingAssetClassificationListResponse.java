/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.holdings.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.holdings.AssetClassificationList;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HoldingAssetClassificationListResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("assetClassificationList")
	private List<AssetClassificationList> assetClassificationLists;

	@JsonProperty("assetClassificationList")
	public List<AssetClassificationList> getAssetClassificationList() {
		return assetClassificationLists == null ? null : Collections.unmodifiableList(assetClassificationLists);
	}

	@Override
	public String toString() {
		return "AssetClassificationListResponse [assetClassificationList=" + assetClassificationLists + "]";
	}
}
