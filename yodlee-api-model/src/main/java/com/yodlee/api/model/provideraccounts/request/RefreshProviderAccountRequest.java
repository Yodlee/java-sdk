/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.provideraccounts.request;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RefreshProviderAccountRequest extends AbstractProviderAccountRequest {

	@Override
	public String toString() {
		return "RefreshProviderAccountRequest [datasets=" + datasets + ", preferences=" + preferences
				+ ", datasetNames=" + datasetNames + "]";
	}
}
