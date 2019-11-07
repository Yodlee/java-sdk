/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
/*
 * Copyright (c) 2017 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 * 
 */
package com.yodlee.api.model.account.enums;

public enum CoverageLimitType {
	/**
	 * Indicates the doctor or facility providing the health care services has negotiated a contracted rate with the
	 * health insurance company
	 * 
	 */
	IN_NETWORK,
	/**
	 * Indicates the doctor or facility providing health care services has no contract with the health insurance company
	 * 
	 */
	OUT_NETWORK
}
