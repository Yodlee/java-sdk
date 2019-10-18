/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 * 
 */
package com.yodlee.api.model.account.enums;

public enum GoalStatus {
	NOT_STARTED(1),//
	IN_PROGRESS(2),//
	COMPLETED(3),//
	REALIZED(4);

	private long id;

	private GoalStatus(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
}
