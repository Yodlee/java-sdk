/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"first", "middle", "last", "fullName"})
public class Name extends AbstractModelComponent {

	@JsonProperty("first")
	private String first;

	@JsonProperty("middle")
	private String middle;

	@JsonProperty("last")
	private String last;

	@JsonProperty("fullName")
	private String fullName;

	public void setFirst(String first) {
		this.first = first;
	}

	public String getFirst() {
		return first;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getMiddle() {
		return middle;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getLast() {
		return last;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "Name [first=" + first + ", middle=" + middle + ", last=" + last + ", fullName=" + fullName + "]";
	}
}
