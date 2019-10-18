/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.transaction.enums.Operation;
import com.yodlee.api.model.transaction.enums.TransactionClauseType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ruleClauseId", "userDefinedRuleId", "field", "operation", "fieldValue"})
public class RuleClause extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "Unique identifier generated for the rule clause."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>"//
	)
	@JsonProperty("ruleClauseId")
	private Long ruleClauseId;

	@ApiModelProperty(readOnly = true,
					  value = "Unique identifier generated for every rule the user creates."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>"//
	)
	@JsonProperty("userDefinedRuleId")
	private Long userDefinedRuleId;

	@ApiModelProperty(readOnly = true,
					  value = "Field for which the clause is created."//
							  + "<br><br>"//
							  + "<br><b>Valid Values</b>:amount,description"//
							  + "<b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>"//
	)
	@JsonProperty("field")
	private TransactionClauseType field;

	@ApiModelProperty(readOnly = true,
					  value = "Operation for which the clause is created."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>"//
	)
	@JsonProperty("operation")
	private Operation operation;

	@ApiModelProperty(readOnly = true,
					  value = "The value would be the amount value in case of amount based rule clause or the string value in case of description based rule clause."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>"//
	)
	@JsonProperty("fieldValue")
	private String fieldValue;

	/**
	 * Field for which the clause is created. <br>
	 * <br>
	 * <br>
	 * <b>Valid Values</b>:amount,description <b>Applicable containers</b>: bill, creditCard, investment, insurance,
	 * loan<br>
	 * 
	 * @return field
	 */
	public TransactionClauseType getField() {
		return field;
	}

	public void setField(TransactionClauseType field) {
		this.field = field;
	}

	/**
	 * Operation for which the clause is created. <br>
	 * <br>
	 * <b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>
	 * 
	 * @return operation
	 */
	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	/**
	 * Unique identifier generated for the rule clause. <br>
	 * <br>
	 * <b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>
	 * 
	 * @return ruleClauseId
	 */
	public Long getRuleClauseId() {
		return ruleClauseId;
	}

	public void setRuleClauseId(Long ruleClauseId) {
		this.ruleClauseId = ruleClauseId;
	}

	/**
	 * The value would be the amount value in case of amount based rule clause or the string value in case of
	 * description based rule clause. <br>
	 * <br>
	 * <b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>
	 * 
	 * @return fieldValue
	 */
	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	/**
	 * Unique identifier generated for every rule the user creates. <br>
	 * <br>
	 * <b>Applicable containers</b>: bill, creditCard, investment, insurance, loan<br>
	 * 
	 * @return userDefinedRuleId
	 */
	public Long getUserDefinedRuleId() {
		return userDefinedRuleId;
	}

	public void setUserDefinedRuleId(Long userDefinedRuleId) {
		this.userDefinedRuleId = userDefinedRuleId;
	}

	@Override
	public String toString() {
		return "RuleClauses [ruleClauseId=" + ruleClauseId + ", userDefinedRuleId=" + userDefinedRuleId + ", field="
				+ field + ", operation=" + operation + ", fieldValue=" + fieldValue + "]";
	}
}
