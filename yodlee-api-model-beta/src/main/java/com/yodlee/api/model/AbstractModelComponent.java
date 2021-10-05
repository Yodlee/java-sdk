/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.api.model.validator.Validator;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractModelComponent {

	public List<Problem> validate() {
		return Validator.validate(this);
	}
}
