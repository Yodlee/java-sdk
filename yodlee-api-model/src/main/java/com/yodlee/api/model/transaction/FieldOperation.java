/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.transaction;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.transaction.enums.Operation;
import com.yodlee.api.model.transaction.enums.TransactionClauseType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"field", "operation", "value"})
public class FieldOperation extends AbstractModelComponent {

	@NotNull(message = "{transactions.rule.ruleClauses.field.required}")
	@ApiModelProperty(value = "Field for which the clause is created."//
			+ "<br><br>"//
			+ "<b>Applicable containers</b>: bank, creditCard, investment, insurance, loan<br>"//
			+ "<b>Applicable Values</b>:"//
			+ "<ul>"//
			+ "<li>amount</li>"//
			+ "<li>description</li>"//
			+ "</ul>"//
			+ "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("field")
	private TransactionClauseType field;

	@NotNull(message = "{transactions.rule.ruleClauses.operation.required}")
	@ApiModelProperty(value = "Operation for which the clause is created."//
			+ "<br><br>"//
			+ "<b>Applicable containers</b>: bank, creditCard, investment, insurance, loan<br>"//
			+ "<b>Applicable values (depends on the value of field)</b>:"//
			+ "<ul>"//
			+ "<li>field is <b>description</b> -> operation can be"//
			+ "<ol>"//
			+ "<li>stringEquals</li>"//
			+ "<li>stringContains</li>"//
			+ "</ol>"//
			+ "</li>"//
			+ "<li>field is <b>amount</b> -> operation can be"//
			+ "<ol>"//
			+ "<li>numberEquals</li>"//
			+ "<li>numberLessThan</li>"//
			+ "<li>numberLessThanEquals</li>"//
			+ "<li>numberGreaterThan</li>"//
			+ "<li>numberGreaterThanEquals</li>"//
			+ "</ol>"//
			+ "</li>"//
			+ "</ul>"//
			+ "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("operation")
	private Operation operation;

	@NotNull(message = "{transactions.rule.ruleClauses.value.required}")
	@ApiModelProperty(value = "The value would be the amount value in case of amount based rule clause or the string value in case of description based rule clause."//
			+ "<br><br>"//
			+ "<b>Applicable containers</b>: bank, creditCard, investment, insurance, loan<br>"//
			+ "<b>Applicable Values</b>:"//
			+ "<ul>"//
			+ "<li>field is <b>description</b> -> value should be <b>min of 3 and max of 50 characters</b></li>"//
			+ "<li>field is <b>amount</b> -> value should be <b> min value of 0 and a max value of 99999999999.99</b></li>"//
			+ "</ul>")
	@JsonProperty("value")
	private Object value;

	public TransactionClauseType field() {
		return field;
	}

	public void setField(TransactionClauseType field) {
		this.field = field;
	}

	/**
	 * Operation for which the clause is created. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank, creditCard, investment, insurance, loan<br>
	 * <b>Applicable values (depends on the value of field)</b>:
	 * <ul>
	 * <li>field is <b>description</b> -{@literal >} operation can be
	 * <ol>
	 * <li>stringEquals</li>
	 * <li>stringContains</li>
	 * </ol>
	 * </li>
	 * <li>field is <b>amount</b> -{@literal >} operation can be
	 * <ol>
	 * <li>numberEquals</li>
	 * <li>numberLessThan</li>
	 * <li>numberLessThanEquals</li>
	 * <li>numberGreaterThan</li>
	 * <li>numberGreaterThanEquals</li>
	 * </ol>
	 * </li>
	 * </ul>
	 * <b>Applicable Values</b><br>
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
	 * The value would be the amount value in case of amount based rule clause or the string value in case of
	 * description based rule clause. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank, creditCard, investment, insurance, loan<br>
	 * <b>Applicable Values</b>:
	 * <ul>
	 * <li>field is <b>description</b> -{@literal >} value should be <b>min of 3 and max of 50 characters</b></li>
	 * <li>field is <b>amount</b> -{@literal >} value should be <b> min value of 0 and a max value of 99999999999.99</b></li>
	 * </ul>
	 * 
	 * @return value
	 */
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "FieldOperation [field=" + field + ", operation=" + operation + ", value=" + value + "]";
	}
}
