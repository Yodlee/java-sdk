/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.account;

import com.yodlee.api.model.AbstractModelComponent;

public class AccountAssetClassification extends AbstractModelComponent {

	private Long securitiesAssetClassMapId;

	private Long assetClassificationId;

	private Double allocation;

	private String rowCreated;

	private String rowLastUpdated;

	private Boolean isDeleted;

	public Long getSecuritiesAssetClassMapId() {
		return securitiesAssetClassMapId;
	}

	public void setSecuritiesAssetClassMapId(Long securitiesAssetClassMapId) {
		this.securitiesAssetClassMapId = securitiesAssetClassMapId;
	}

	public Long getAssetClassificationId() {
		return assetClassificationId;
	}

	public void setAssetClassificationId(Long assetClassificationId) {
		this.assetClassificationId = assetClassificationId;
	}

	public Double getAllocation() {
		return allocation;
	}

	public void setAllocation(Double allocation) {
		this.allocation = allocation;
	}

	public String getRowCreated() {
		return rowCreated;
	}

	public void setRowCreated(String rowCreated) {
		this.rowCreated = rowCreated;
	}

	public String getRowLastUpdated() {
		return rowLastUpdated;
	}

	public void setRowLastUpdated(String rowLastUpdated) {
		this.rowLastUpdated = rowLastUpdated;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
