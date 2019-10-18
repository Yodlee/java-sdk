/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.derived;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;
import com.yodlee.api.model.derived.enums.TransactionCategoryType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"categoryType", "creditTotal", "debitTotal", "categorySummary", "links"})
public class DerivedTransactionsSummary extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "Type of categories provided by transactions/categories service."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, bank, investment<br>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("categoryType")
	private TransactionCategoryType categoryType;

	@ApiModelProperty(readOnly = true,
					  value = "The total of credit transactions for the category type."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, bank, investment<br>"//
	)
	@JsonProperty("creditTotal")
	private Money creditTotal;

	@ApiModelProperty(readOnly = true,
					  value = "The total of debit transactions for the category type."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, bank, investment<br>"//
	)
	@JsonProperty("debitTotal")
	private Money debitTotal;

	@ApiModelProperty(readOnly = true,
					  value = "Summary of transaction amouts at category level."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, bank, investment<br>"//
	)
	@JsonProperty("categorySummary")
	private List<DerivedCategorySummary> categorySummaries;

	@ApiModelProperty(readOnly = true,
					  value = "Link of the API services that corresponds to the value derivation."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, bank, investment<br>"//
	)
	@JsonProperty("links")
	private DerivedTransactionsLinks links;

	/**
	 * The total of debit transactions for the category type. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, bank, investment<br>
	 * 
	 * @return debitTotal
	 */
	public Money getDebitTotal() {
		return debitTotal;
	}

	/**
	 * The total of credit transactions for the category type. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, bank, investment<br>
	 * 
	 * @return creditTotal
	 */
	public Money getCreditTotal() {
		return creditTotal;
	}

	/**
	 * Type of categories provided by transactions/categories service. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, bank, investment<br>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return categoryType
	 */
	public TransactionCategoryType getCategoryType() {
		return categoryType;
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
	 * Summary of transaction amounts at category level. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, bank, investment<br>
	 * 
	 * @return list of category summary
	 */
	public List<DerivedCategorySummary> getCategorySummaries() {
		return categorySummaries == null ? null : Collections.unmodifiableList(categorySummaries);
	}

	@Override
	public String toString() {
		return "DerivedTransactionsSummary [categoryType=" + categoryType + ", creditTotal=" + creditTotal
				+ ", debitTotal=" + debitTotal + ", categorySummaries=" + categorySummaries + ", links=" + links + "]";
	}
}
