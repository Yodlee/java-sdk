/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
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
