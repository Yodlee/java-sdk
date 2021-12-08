/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.verification.enums;

public enum VerificationAccountFailedReason {
	
	/**
	 * <b>Description: </b>Required data is not available.<br>
	 * <b>Next Action: </b>No action is required as it is an end state.
	 */
	REQUIRED_DATA_NOT_AVAILABLE,

	/**
	 * <b>Description: </b>Matching failed.<br>
	 * <b>Next Action: </b>No action is required as it is an end state.
	 */
	MATCHING_FAILED

}
