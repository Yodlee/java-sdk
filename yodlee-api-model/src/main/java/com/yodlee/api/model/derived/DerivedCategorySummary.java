/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.derived;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"categoryId", "categoryName", "debitTotal", "creditTotal", "details", "links"})
public class DerivedCategorySummary extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "Id of the category. This information is provided by transactions/categories service."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, bank, investment<br>"//
	)
	@JsonProperty("categoryId")
	private Long categoryId;

	@ApiModelProperty(readOnly = true,
					  value = "The name of the category."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, bank, investment<br>"//
	)
	@JsonProperty("categoryName")
	private String categoryName;

	@ApiModelProperty(readOnly = true,
					  value = "The total of debit transactions for the category."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, bank, investment<br>"//
	)
	@JsonProperty("debitTotal")
	private Money debitTotal;

	@ApiModelProperty(readOnly = true,
					  value = "The total of credit transactions for the category."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, bank, investment<br>"//
	)
	@JsonProperty("creditTotal")
	private Money creditTotal;

	@ApiModelProperty(readOnly = true,
					  value = "Credit and debit summary per date."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, bank, investment<br>"//
	)
	@JsonProperty("details")
	private List<DerivedCategorySummaryDetails> categorySummarydetails;

	@ApiModelProperty(readOnly = true,
					  value = "Link of the API services that corresponds to the value derivation."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, bank, investment<br>"//
	)
	@JsonProperty("links")
	private DerivedTransactionsLinks links;

	/**
	 * The total of credit transactions for the category. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, bank, investment<br>
	 * 
	 * @return creditTotal
	 */
	@JsonProperty("creditTotal")
	public Money getCreditTotal() {
		return creditTotal;
	}

	/**
	 * Credit and debit summary per date. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, bank, investment<br>
	 * 
	 * @return details
	 */
	@JsonProperty("details")
	public List<DerivedCategorySummaryDetails> getCategorySummaryDetails() {
		return categorySummarydetails == null ? null : Collections.unmodifiableList(categorySummarydetails);
	}

	/**
	 * The total of debit transactions for the category. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, bank, investment<br>
	 * 
	 * @return debitTotal
	 */
	public Money getDebitTotal() {
		return debitTotal;
	}

	/**
	 * Link of the API services that corresponds to the value derivation. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, bank, investment<br>
	 * 
	 * @return links
	 */
	public DerivedTransactionsLinks getLinks() {
		return links;
	}

	/**
	 * The name of the category. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, bank, investment<br>
	 * 
	 * @return categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Id of the category. This information is provided by transactions/categories service. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, bank, investment<br>
	 * 
	 * @return categoryId
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	@Override
	public String toString() {
		return "CategorySummary [creditTotal=" + creditTotal + ", categoryName=" + categoryName + ", categoryId="
				+ categoryId + ", details=" + categorySummarydetails + ", debitTotal=" + debitTotal + ", links=" + links
				+ "]";
	}
}
