/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 * 
 */
package com.yodlee.api.model.transaction.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Operation {
	// amount enum types
	/**
	 * The rule gets applied only when the amount field is equal to the specified value
	 */
	@JsonProperty("numberEquals")
	numberEquals,
	/**
	 * The rule gets applied only when the amount field is lesser than the specified value
	 */
	@JsonProperty("numberLessThan")
	numberLessThan,
	/**
	 * The rule gets applied only when the amount field is less than or equal to the specified value
	 */
	@JsonProperty("numberLessThanEquals")
	numberLessThanEquals,
	/**
	 * The rule gets applied only when the amount field is greater than the specified value
	 */
	@JsonProperty("numberGreaterThan")
	numberGreaterThan,
	/**
	 * The rule gets applied only when the amount field is greater than or equal to the specified value
	 */
	@JsonProperty("numberGreaterThanEquals")
	numberGreaterThanEquals,
	// description enum types
	/**
	 * The rule gets applied only when the description field equals the specified value
	 */
	@JsonProperty("stringEquals")
	stringEquals,
	/**
	 * The rule gets applied only when the description field contains the specified value
	 */
	@JsonProperty("stringContains")
	stringContains;

	public boolean isNumericOperation() {
		switch (this) {
			case numberEquals:
			case numberGreaterThan:
			case numberLessThanEquals:
			case numberLessThan:
			case numberGreaterThanEquals:
				return true;
			default:
				return false;
		}
	}

	public boolean isStringOperation() {
		switch (this) {
			case stringContains:
			case stringEquals:
				return true;
			default:
				return false;
		}
	}
}
