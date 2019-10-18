/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 * 
 */
package com.yodlee.api.model.cobrand.enums;

public enum CobrandNotificationEventType {
	/**
	 * Events that happen during add, edit and update aggregated accounts processes
	 */
	REFRESH,//
	/**
	 * Data updates that happen on provider accounts, accounts, transactions and holdings data due to user actions or
	 * auto updates. This event is triggered to help the customer perform data extracts from Yodlee system to their
	 * system
	 * 
	 */
	DATA_UPDATES,//
	/**
	 * Events that gets triggered once there is a change in the state of cache refresh
	 */
	AUTO_REFRESH_UPDATES
}
