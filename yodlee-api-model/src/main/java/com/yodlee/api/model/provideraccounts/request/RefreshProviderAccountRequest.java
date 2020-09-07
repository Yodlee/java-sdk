/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.provideraccounts.request;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RefreshProviderAccountRequest extends AbstractProviderAccountRequest {

	@Override
	public String toString() {
		return "RefreshProviderAccountRequest [datasets=" + datasets + ", preferences=" + preferences
				+ ", datasetNames=" + datasetNames + ", aggregationSource" + aggregationSource + "]";
	}
}
