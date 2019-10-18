/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.derived;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"transactions"})
public class DerivedTransactionsLinks extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "Link of the transaction API service that corresponds to the value derivation."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, bank, investment<br>"//
	)
	@JsonProperty("transactions")
	private String transactions;

	/**
	 * Link of the transaction API service that corresponds to the value derivation. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, bank, investment<br>
	 * 
	 * @return transactions
	 */
	public String getTransactions() {
		return transactions;
	}

	@Override
	public String toString() {
		return "TransactionsLinks [transactions=" + transactions + "]";
	}
}
