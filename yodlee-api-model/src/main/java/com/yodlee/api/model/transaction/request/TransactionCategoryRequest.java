/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.transaction.request;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionCategoryRequest extends AbstractModelComponent implements Request {

	@Size(min = 1, max = 50, message = "{transactions.categoryName.min.max.invalid}")
	@JsonProperty("categoryName")
	private String categoryName;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("source")
	private String source;

	@NotNull(message = "{transactions.parentCategoryId.required}")
	@Digits(message = "{transactions.parentCategoryId.invalid}", fraction = 0, integer = 11)
	@Min(value=1, message = "{transactions.parentCategoryId.invalid}")
	@ApiModelProperty(required = true)
	@JsonProperty("parentCategoryId")
	private Integer parentCategoryId;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(Integer parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "TransactionCategoryRequest [categoryName=" + categoryName + ", source=" + source + ", parentCategoryId="
				+ parentCategoryId + "]";
	}
}
