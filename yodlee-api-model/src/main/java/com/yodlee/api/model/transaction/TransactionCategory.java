/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.transaction;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.transaction.enums.TransactionCategoryClassification;
import com.yodlee.api.model.transaction.enums.TransactionCategorySource;
import com.yodlee.api.model.transaction.enums.TransactionCategoryType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "highLevelCategoryName", "category", "source", "highLevelCategoryId", "type",
		"detailCategory", "defaultCategoryName", "defaultHighLevelCategoryName"})
public class TransactionCategory extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "Unique identifier of the category."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>"//
	)
	@JsonProperty("id")
	private Long id;

	@ApiModelProperty(readOnly = true,
					  value = "The name of the high level category. A group of similar transaction categories are clubbed together to form a high-level category."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>"//
	)
	@JsonProperty("highLevelCategoryName")
	private String highLevelCategoryName;

	@ApiModelProperty(readOnly = true,
					  value = "The name of the category."
							  + "<br><b>Note</b>: Transaction categorization is one of the core features offered by Yodlee and the categories are assigned to the transactions by the system. Transactions can be clubbed together by the category that is assigned to them.  "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>"//
	)
	@JsonProperty("category")
	private String category;

	@ApiModelProperty(readOnly = true,
					  value = "Source used to identify whether the transaction category is user defined category or system created category."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("source")
	private TransactionCategorySource source;

	@ApiModelProperty(readOnly = true,
					  value = "The unique identifier of the high level category."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>"//
	)
	@JsonProperty("highLevelCategoryId")
	private Long highLevelCategoryId;

	@ApiModelProperty(readOnly = true,
					  value = "Transaction categories and high-level categories are further mapped to five transaction category types. Customers, based on their needs can either use the transaction categories, the high-level categories, or the transaction category types. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("type")
	private TransactionCategoryType type;

	@ApiModelProperty(readOnly = true,
					  value = "Entity that provides detail category attributes"//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>"//
	)
	@JsonProperty("detailCategory")
	private List<DetailCategory> detailCategory;

	@ApiModelProperty(readOnly = true,
					  value = "Category Classification."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("classification")
	private TransactionCategoryClassification classification;

	@ApiModelProperty(readOnly = true,
					  value = "A attribute which will always hold the first value(initial name) of Yodlee defined category attribute."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, investment, insurance, loan<br>"//
	)
	@JsonProperty("defaultCategoryName")
	private String defaultCategoryName;

	@ApiModelProperty(readOnly = true,
					  value = "A attribute which will always hold the first value(initial name) of Yodlee defined highLevelCategoryName attribute."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, investment, insurance, loan<br>"//
	)
	@JsonProperty("defaultHighLevelCategoryName")
	private String defaultHighLevelCategoryName;

	/**
	 * Unique identifier of the category. <br>
	 * <br>
	 * <b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * The name of the high level category. A group of similar transaction categories are clubbed together to form a
	 * high-level category. <br>
	 * <br>
	 * <b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>
	 * 
	 * @return highLevelCategoryName
	 */
	public String getHighLevelCategoryName() {
		return highLevelCategoryName;
	}

	/**
	 * The name of the category. <br>
	 * <b>Note</b>: Transaction categorization is one of the core features offered by Yodlee and the categories are
	 * assigned to the transactions by the system. Transactions can be clubbed together by the category that is assigned
	 * to them. <br>
	 * <br>
	 * <b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>
	 * 
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Source used to identify whether the transaction category is user defined category or system created category.
	 * <br>
	 * <br>
	 * <b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return source
	 */
	public TransactionCategorySource getSource() {
		return source;
	}

	/**
	 * The unique identifier of the high level category. <br>
	 * <br>
	 * <b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>
	 * 
	 * @return highLevelCategoryId
	 */
	public Long getHighLevelCategoryId() {
		return highLevelCategoryId;
	}

	/**
	 * Transaction categories and high-level categories are further mapped to five transaction category types.
	 * Customers, based on their needs can either use the transaction categories, the high-level categories, or the
	 * transaction category types. <br>
	 * <br>
	 * <b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return type
	 */
	public TransactionCategoryType getType() {
		return type;
	}

	/**
	 * Entity that provides detail category attributes <br>
	 * <br>
	 * <b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>
	 * 
	 * @return detailCategory
	 */
	@JsonProperty("detailCategory")
	public List<DetailCategory> getDetailCategories() {
		return detailCategory == null ? null : Collections.unmodifiableList(detailCategory);
	}

	/**
	 * Category Classification. <br>
	 * <br>
	 * <b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return classification
	 */
	public TransactionCategoryClassification getClassification() {
		return classification;
	}

	/**
	 * A attribute which will always hold the first value(initial name) of Yodlee defined category attribute. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, investment, insurance, loan<br>
	 * 
	 * @return defaultCategoryName
	 */
	public String getDefaultCategoryName() {
		return defaultCategoryName;
	}

	/**
	 * A attribute which will always hold the first value(initial name) of Yodlee defined highLevelCategoryName
	 * attribute. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, investment, insurance, loan<br>
	 * 
	 * @return defaultHighLevelCategoryName
	 */
	public String getDefaultHighLevelCategoryName() {
		return defaultHighLevelCategoryName;
	}

	@Override
	public String toString() {
		return "TransactionCategory [id=" + id + ", highLevelCategoryName=" + highLevelCategoryName + ", category="
				+ category + ", source=" + source + ", highLevelCategoryId=" + highLevelCategoryId + ", type=" + type
				+ ", detailCategory=" + detailCategory + ", classification=" + classification + ", defaultCategoryName="
				+ defaultCategoryName + ", defaultHighLevelCategoryName=" + defaultHighLevelCategoryName + "]";
	}
}
