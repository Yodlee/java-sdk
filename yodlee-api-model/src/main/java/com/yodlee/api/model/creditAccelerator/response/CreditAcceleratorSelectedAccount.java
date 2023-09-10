/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({"id", "providerAccountId"})
public class CreditAcceleratorSelectedAccount {
	
	@JsonProperty("id")
	@ApiModelProperty(readOnly = true,
	  value = "The primary key of the account resource and the unique identifier for the account.")
	private Long id;

	@JsonProperty("providerAccountId")
	@ApiModelProperty(readOnly = true,
	  value = "Unique identifier for the provider account resource. This is created during account addition.")
    private Long providerAccountId;
	
	public Long getId() {
		return id;
	}

	public Long getProviderAccountId() {
		return providerAccountId;
	}
}
