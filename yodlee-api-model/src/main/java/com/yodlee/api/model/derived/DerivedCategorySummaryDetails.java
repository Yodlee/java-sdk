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
@JsonPropertyOrder({"creditTotal", "debitTotal", "date"})
public class DerivedCategorySummaryDetails extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "Total of credit transaction amounts that had occured on the date."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, bank, investment<br>"//
	)
	@JsonProperty("creditTotal")
	private Money creditTotal;

	@ApiModelProperty(readOnly = true,
					  value = "Total of debit transaction amounts that had occured on the date."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, bank, investment<br>"//
	)
	@JsonProperty("debitTotal")
	private Money debitTotal;

	@ApiModelProperty(readOnly = true,
					  value = "Date on which the credit and debit transactions had occured."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, bank, investment<br>"//
	)
	@JsonProperty("date")
	private String date;

	/**
	 * Total of credit transaction amounts that had occured on the date. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, bank, investment<br>
	 * 
	 * @return creditTotal
	 */
	public Money getCreditTotal() {
		return creditTotal;
	}

	/**
	 * Total of debit transaction amounts that had occured on the date. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, bank, investment<br>
	 * 
	 * @return debitTotal
	 */
	public Money getDebitTotal() {
		return debitTotal;
	}

	/**
	 * Date on which the credit and debit transactions had occured. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, bank, investment<br>
	 * 
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "CategorySummaryDetails [creditTotal=" + creditTotal + ", debitTotal=" + debitTotal + ", date=" + date
				+ "]";
	}
}
