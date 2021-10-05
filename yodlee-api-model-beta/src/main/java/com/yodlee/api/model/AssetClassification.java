/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"classificationType", "classificationValue", "allocation"})
public class AssetClassification extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "The type of classification to which the investment belongs (assetClass, country, sector, and style)."
							  + "<br><b>Required Feature Enablement</b>: Asset classification feature"//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("classificationType")
	private String classificationType;

	@ApiModelProperty(readOnly = true,
					  value = "The allocation percentage of the holding.<br>"
							  + "<br><b>Required Feature Enablement</b>: Asset classification feature"//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("allocation")
	private Double allocation;

	@ApiModelProperty(readOnly = true,
					  value = "The value for each classificationType."
							  + "<br><b>Required Feature Enablement</b>: Asset classification feature"//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("classificationValue")
	private String classificationValue;

	/**
	 * The value for each classificationType. <br>
	 * <b>Required Feature Enablement</b>: Asset classification feature <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return classificationValue
	 */
	public String getClassificationValue() {
		return classificationValue;
	}

	/**
	 * The allocation percentage of the holding.<br>
	 * <br>
	 * <b>Required Feature Enablement</b>: Asset classification feature <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return allocation
	 */
	public Double getAllocation() {
		return allocation;
	}

	/**
	 * The type of classification to which the investment belongs (assetClass, country, sector, and style). <br>
	 * <b>Required Feature Enablement</b>: Asset classification feature <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return classificationType
	 */
	public String getClassificationType() {
		return classificationType;
	}

	@Override
	public String toString() {
		return "AssetClassification [classificationType=" + classificationType + ", allocation=" + allocation
				+ ", classificationValue=" + classificationValue + "]";
	}
}
