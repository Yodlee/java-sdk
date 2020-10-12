/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.transaction.request;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.enums.AggregationSource;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateCategoryRequest extends AbstractModelComponent implements Request {

	@NotNull(message = "{transactions.updateTransactionCategory.id.required}")
	@Digits(message = "{transactions.updateTransactionCategory.id.invalid}", fraction = 0, integer = 11)
	@Min(value=1, message = "{transactions.updateTransactionCategory.id.invalid}")
	@JsonProperty("id")
	private Long id;

	@JsonProperty("categoryName")
	private String categoryName;

	@NotNull(message = "{transactions.updateTransactionCategory.source.required}")
	@JsonProperty("source")
	private AggregationSource source;

	@JsonProperty("highLevelCategoryName")
	private String highLevelCategoryName;

	public String getHighLevelCategoryName() {
		return highLevelCategoryName;
	}

	public void setHighLevelCategoryName(String highLevelCategoryName) {
		this.highLevelCategoryName = highLevelCategoryName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public AggregationSource getSource() {
		return source;
	}

	public void setSource(AggregationSource source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "UpdateCategoryRequest [id=" + id + ", categoryName=" + categoryName + ", source=" + source
				+ ", highLevelCategoryName=" + highLevelCategoryName + "]";
	}
}
