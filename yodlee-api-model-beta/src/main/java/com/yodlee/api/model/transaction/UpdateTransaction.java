/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.transaction;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.enums.AggregationSource;
import com.yodlee.api.model.enums.Container;
import io.swagger.annotations.ApiModelProperty;
import com.yodlee.api.model.transaction.enums.MerchantType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"accountId", "merchant", "status", "CONTAINER", "isManual", "postDate", "categoryType",
		"categoryId", "lastUpdated", "type", "date", "runningBalance", "id", "amount", "category", "baseType",
		"highLevelCategoryId", "subType", "description", "createdDate", "categorySource", "memo","isPhysical","merchantType","detailCategoryId"})
public class UpdateTransaction extends AbstractModelComponent {

	@NotNull(message = "{transactions.container.required}")
	@ApiModelProperty(required = true)
	@JsonProperty("container")
	private Container container;

	@NotNull(message = "{transactions.categoryId.required}")
	@Digits(message = "{transactions.categoryId.invalid}", fraction = 0, integer = 11)
	@ApiModelProperty(required = true)
	@JsonProperty("categoryId")
	private Long categoryId;

	@JsonProperty("description")
	private Description description;

	@NotNull(message = "{transactions.categorySource.required}")
	@ApiModelProperty(required = true)
	@JsonProperty("categorySource")
	private AggregationSource categorySource;

	@JsonProperty("memo")
	private String memo;
	
	@JsonProperty("isPhysical")
	private Boolean isPhysical;
	
	@JsonProperty("merchantType")
	private MerchantType merchantType;
	
	@JsonProperty("detailCategoryId")
	private Long detailCategoryId;

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public AggregationSource getCategorySource() {
		return categorySource;
	}

	public void setCategorySource(AggregationSource categorySource) {
		this.categorySource = categorySource;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Boolean getIsPhysical() {
		return isPhysical;
	}

	public void setIsPhysical(Boolean isPhysical) {
		this.isPhysical = isPhysical;
	}

	public MerchantType getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(MerchantType merchantType) {
		this.merchantType = merchantType;
	}

	public Long getDetailCategoryId() {
		return detailCategoryId;
	}

	public void setDetailCategoryId(Long detailCategoryId) {
		this.detailCategoryId = detailCategoryId;
	}
	
	@Override
	public String toString() {
		return "UpdateTransaction [container=" + container + ", categoryId=" + categoryId + ", description="
				+ description + ", categorySource=" + categorySource + ",  memo=" + memo + " , isPhysical=" + isPhysical
				+ ", " + " detailCategoryId= " + detailCategoryId + ", merchantType=" + merchantType + "]";
	}
}
