/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.enums.AggregationSource;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"categoryId", "priority", "source", "ruleClause"})
public class TransactionCategorizationRuleInfo extends AbstractModelComponent {

	@NotNull(message = "{transactions.rule.categoryId.required}")
	@Digits(integer = 11, fraction = 0, message = "{transactions.rule.categoryId.invalid}")
	@JsonProperty("categoryId")
	private Integer categoryId;

	@Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "{transactions.rule.priority.invalid}")
	@JsonProperty("priority")
	private Integer priority;

	@JsonProperty("source")
	private AggregationSource source;

	@NotNull(message = "{transactions.rule.ruleClause.required}")
	@Valid
	@Size(min = 1, message = "{transactions.rule.ruleClause.length.invalid}")
	@JsonProperty("ruleClause")
	private List<FieldOperation> ruleClauses;

	public AggregationSource getSource() {
		return source;
	}

	public void setSource(AggregationSource source) {
		this.source = source;
	}

	@JsonProperty("ruleClause")
	public List<FieldOperation> getRuleClauses() {
		return ruleClauses == null ? null : Collections.unmodifiableList(ruleClauses);
	}

	@JsonProperty("ruleClause")
	public void setRuleClauses(List<FieldOperation> ruleClause) {
		this.ruleClauses = ruleClause;
	}

	public void addRuleClause(FieldOperation ruleClauseInfo) {
		if (this.ruleClauses == null) {
			this.ruleClauses = new ArrayList<>();
		}
		this.ruleClauses.add(ruleClauseInfo);
	}

	public boolean removeRuleClause(FieldOperation ruleClauseInfo) {
		if (this.ruleClauses != null) {
			return this.ruleClauses.remove(ruleClauseInfo);
		}
		return false;
	}

	public void clearRuleClause() {
		if (this.ruleClauses != null) {
			ruleClauses.clear();
		}
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "TransactionCategorizationRuleInfo [categoryId=" + categoryId + ", priority=" + priority + ", source="
				+ source + ", ruleClauses=" + ruleClauses + "]";
	}
}
