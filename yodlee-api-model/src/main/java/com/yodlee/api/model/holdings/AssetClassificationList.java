/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.holdings;

import java.util.Collections;
import java.util.List;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"classificationType", "classificationValue"})
public class AssetClassificationList extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "The type of classification to which the investment belongs (assetClass, country, sector, and style)."
							  + "<br><b>Required Feature Enablement</b>: Asset classification feature"//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@NotNull(message = "classificationType cannot be null")
	@JsonProperty("classificationType")
	private String classificationType;

	@ApiModelProperty(readOnly = true,
					  value = "The value for each classificationType."
							  + "<br><b>Required Feature Enablement</b>: Asset classification feature"//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@NotNull(message = "classificationValue cannot be null")
	@JsonProperty("classificationValue")
	private List<String> classificationValues;

	/**
	 * The value for each classificationType. <br>
	 * <b>Required Feature Enablement</b>: Asset classification feature <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return classificationValue
	 */
	public List<String> getClassificationValue() {
		return classificationValues == null ? null : Collections.unmodifiableList(classificationValues);
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
		return "AssetClassificationList [classificationValue=" + classificationValues + ", classificationType="
				+ classificationType + "]";
	}
}
