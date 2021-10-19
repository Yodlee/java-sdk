/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetailCategory extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "The unique identifier of the detail category."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, investment, insurance, loan<br>"//
	)
	@JsonProperty("id")
	private Long id;

	@ApiModelProperty(readOnly = true,
					  value = "The name of the detail category"//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, investment, insurance, loan<br>"//
	)
	@JsonProperty("name")
	private String name;

	/**
	 * The unique identifier of the detail category. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, investment, insurance, loan<br>
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * The name of the detail category <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, investment, insurance, loan<br>
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DetailCategory [id=" + id + ", name=" + name + "]";
	}
}
