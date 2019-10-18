/*
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class Coordinates {

	@ApiModelProperty(value = "Latitude of the merchant"//
			+ "<br><br>"//
			+ "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("latitude")
	private Double latitude;

	@ApiModelProperty(value = "Longitude of the merchant"//
			+ "<br><br>"//
			+ "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("longitude")
	private Double longitude;

	/**
	 * Latitude of the merchant <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,loan<br>
	 * 
	 * @return latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Longitude of the merchant <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,loan<br>
	 * 
	 * @return longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Coordinates [latitude=" + latitude + ", longitude=" + longitude + "]";
	}
}
