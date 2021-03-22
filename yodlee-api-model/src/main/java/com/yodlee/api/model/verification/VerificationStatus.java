/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.verification;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class VerificationStatus extends Verification {
	
	@ApiModelProperty(readOnly = true)
	@JsonProperty("remainingAttempts")
	private Long remainingAttempts;
}
