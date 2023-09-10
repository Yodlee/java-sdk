/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractAddress extends AbstractModelComponent {

	@JsonProperty("address1")
	@ApiModelProperty(readOnly = true, value = "Address Line 1.")
	protected String address1;

	@JsonProperty("address2")
	@ApiModelProperty(readOnly = true, value = "Address Line 2.")
	protected String address2;

	@JsonProperty("address3")
	@ApiModelProperty(readOnly = true, value = "Address Line 3.")
	protected String address3;

	@JsonProperty("state")
	@ApiModelProperty(readOnly = true, value = "State.")
	protected String state;

	@JsonProperty("city")
	@ApiModelProperty(readOnly = true, value = "City.")
	protected String city;

	@JsonProperty("zip")
	@ApiModelProperty(readOnly = true, value = "Zip.")
	protected String zip;

	@JsonProperty("country")
	@ApiModelProperty(readOnly = true, value = "Country.")
	protected String country;

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
