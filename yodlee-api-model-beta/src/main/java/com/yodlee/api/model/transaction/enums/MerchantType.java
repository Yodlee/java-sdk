package com.yodlee.api.model.transaction.enums;
/**
 * Copyright (c) 2021 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */

public enum MerchantType {
	BILLERS(1L),
	SUBSCRIPTION(2L),
	OTHERS(3L);
	
	private long id;

	private MerchantType(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

}
