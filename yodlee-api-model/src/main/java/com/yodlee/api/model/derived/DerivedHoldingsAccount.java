/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.derived;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "value"})
public class DerivedHoldingsAccount extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "The primary key of the account resource and the unique identifier for the account.<br>"
							  + "Required Feature Enablement: Asset classification feature."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("id")
	private Long id;

	@ApiModelProperty(readOnly = true,
					  value = "The investment accounts cash balance.<br>"
							  + "Required Feature Enablement: Asset classification feature."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("value")
	private Money value;

	/**
	 * The primary key of the account resource and the unique identifier for the account.<br>
	 * Required Feature Enablement: Asset classification feature. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * The investment accounts cash balance.<br>
	 * Required Feature Enablement: Asset classification feature. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return value
	 */
	public Money getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "DerivedHoldingsAccount [id=" + id + ", value=" + value + "]";
	}
}
