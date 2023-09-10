/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.enrichData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"original"})
public class EnrichTransactionDescription extends AbstractModelComponent {

	@ApiModelProperty(value = "Original transaction description as it appears at the FI site."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, insurance, loan<br>"//
	)
	@JsonProperty("original")
	private String original;
	

	/**
	 * Original transaction description as it appears at the FI site. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, bank, loan<br>
	 * 
	 * @return original
	 */
	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}
	

	@Override
	public String toString() {
		return "Description [original=" + original +"]";
	}
}
