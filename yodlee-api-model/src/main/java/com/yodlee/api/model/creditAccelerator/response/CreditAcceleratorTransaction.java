/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.transaction.AbstractTransaction;
import com.yodlee.api.model.transaction.CreditAcceleratorAbstractTransaction;

import io.swagger.annotations.ApiModelProperty;

public class CreditAcceleratorTransaction extends CreditAcceleratorAbstractTransaction {
	
	@JsonProperty("categoryLabel")
	@ApiModelProperty(readOnly = true,
		value = "Additional category information from the Yodlee reference data, if available.")
	private String categoryLabel;
	
	@JsonProperty("logoURL")
	@ApiModelProperty(readOnly = true,
		value = "The URL of the merchant logo.")
	private String logoURL;
	
	@JsonProperty("merchantLogoURL")
	@ApiModelProperty(readOnly = true,
		value = "The URL of the merchant logo.")
	private String merchantLogoURL;
	
	public String getCategoryLabel() {
		return categoryLabel;
	}

	public void setCategoryLabel(String categoryLabel) {
		this.categoryLabel = categoryLabel;
	}

	public String getLogoURL() {
		return logoURL;
	}

	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}

	public String getMerchantLogoURL() {
		return merchantLogoURL;
	}

	public void setMerchantLogoURL(String merchantLogoURL) {
		this.merchantLogoURL = merchantLogoURL;
	}

}
