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
import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({"userDefinedRuleId", "memId", "transactionCategorisationId", "rulePriority", "categoryLevelId"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionCategorizationRule extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "Unique identifier generated for every rule the user creates."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, investment, insurance, loan<br>"//
	)
	@JsonProperty("userDefinedRuleId")
	private Long userDefinedRuleId;

	@ApiModelProperty(readOnly = true,
					  value = "Unique identifier of the user."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, investment, insurance, loan<br>"//
	)
	@JsonProperty("memId")
	private Long memId;

	@ApiModelProperty(readOnly = true,
					  value = "Category id that is assigned to the transaction when the transaction matches the rule clause. This is the id field of the transaction category resource."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, investment, insurance, loan<br>"//
	)
	@JsonProperty("transactionCategorisationId")
	private Long transactionCategorisationId;

	@ApiModelProperty(readOnly = true,
					  value = "The order in which the rules get executed on transactions."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, investment, insurance, loan<br>"//
	)
	@JsonProperty("rulePriority")
	private Integer rulePriority;

	@ApiModelProperty(readOnly = true,
					  value = "Details of rules. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, investment, insurance, loan<br>"//
	)
	@JsonProperty("ruleClauses")
	private List<RuleClause> ruleClauses;

	@ApiModelProperty(readOnly = true,
					  value = "The level of the category for which the rule is created."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: creditCard, insurance, loan<br>"//
	)
	@JsonProperty("categoryLevelId")
	private Integer categoryLevelId;

	/**
	 * Details of rules. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, investment, insurance, loan<br>
	 * 
	 * @return ruleClauses
	 */
	@JsonProperty("ruleClauses")
	public List<RuleClause> getRuleClauses() {
		return ruleClauses == null ? null : Collections.unmodifiableList(ruleClauses);
	}

	/**
	 * Unique identifier generated for every rule the user creates. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, investment, insurance, loan<br>
	 * 
	 * @return userDefinedRuleId
	 */
	public Long getUserDefinedRuleId() {
		return userDefinedRuleId;
	}

	/**
	 * Unique identifier of the user. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, investment, insurance, loan<br>
	 * 
	 * @return memId
	 */
	public Long getMemId() {
		return memId;
	}

	/**
	 * Category id that is assigned to the transaction when the transaction matches the rule clause. This is the id
	 * field of the transaction category resource. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, investment, insurance, loan<br>
	 * 
	 * @return transactionCategorisationId
	 */
	public Long getTransactionCategorisationId() {
		return transactionCategorisationId;
	}

	/**
	 * The order in which the rules get executed on transactions. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, investment, insurance, loan<br>
	 * 
	 * @return rulePriority
	 */
	public Integer getRulePriority() {
		return rulePriority;
	}

	/**
	 * The level of the category for which the rule is created. <br>
	 * <br>
	 * <b>Applicable containers</b>: creditCard, insurance, loan<br>
	 * 
	 * @return categoryLevelId
	 */
	public Integer getCategoryLevelId() {
		return categoryLevelId;
	}

	@Override
	public String toString() {
		return "TransactionCategorizationRule [userDefinedRuleId=" + userDefinedRuleId + ", memId=" + memId
				+ ", transactionCategorisationId=" + transactionCategorisationId + ", rulePriority=" + rulePriority
				+ ", ruleClauses=" + ruleClauses + ", categoryLevelId=" + categoryLevelId + "]";
	}
}
