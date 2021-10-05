/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.verifyaccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.enums.BaseType;
import com.yodlee.api.model.enums.Matched;
import com.yodlee.api.model.transaction.Transaction;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerifyTransactionCriteria extends AbstractModelComponent {

	@NotNull(message = "{verifyAccounts.txnCriteria.amount.required}")
	@JsonProperty(value = "amount", required = true)
	private Double amount;

	@JsonProperty("keyword")
	private String keyword;

	@ApiModelProperty(readOnly = false,
					  value = "Indicates if the transaction appears as a debit or a credit transaction in the account. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@NotNull(message = "{verifyAccounts.txnCriteria.baseType.required}")
	@JsonProperty(value = "baseType", required = true)
	private BaseType baseType;

	@NotNull(message = "{verifyAccounts.txnCriteria.date.required}")
	@JsonProperty(value = "date", required = true)
	private String date;

	@JsonProperty("dateVariance")
	private String dateVariance;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates if the criteria is matched or not. "//
							  + "<br>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("matched")
	private Matched matched;

	@ApiModelProperty(readOnly = true)
	@JsonProperty("verifiedTransaction")
	private List<Transaction> verifiedTransactions;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Matched getMatched() {
		return matched;
	}

	public String getDateVariance() {
		return dateVariance;
	}

	public void setDateVariance(String dateVariance) {
		this.dateVariance = dateVariance;
	}

	@JsonProperty("verifiedTransaction")
	public List<Transaction> getVerifiedTransactions() {
		return (verifiedTransactions == null ? null : Collections.unmodifiableList(verifiedTransactions));
	}

	public void setVerifiedTransactions(List<Transaction> verifiedTransactions) {
		this.verifiedTransactions = verifiedTransactions;
	}

	public boolean addVerifiedTransaction(Transaction verifiedTransaction) {
		if (this.verifiedTransactions == null) {
			this.verifiedTransactions = new ArrayList<>();
		}
		return this.verifiedTransactions.add(verifiedTransaction);
	}

	public boolean removeVerifiedTransaction(Transaction verifiedTransaction) {
		if (this.verifiedTransactions != null) {
			return this.verifiedTransactions.remove(verifiedTransaction);
		}
		return false;
	}

	public void clearVerifiedTransaction() {
		if (verifiedTransactions != null) {
			verifiedTransactions.clear();
		}
	}

	/**
	 * Indicates if the transaction appears as a debit or a credit transaction in the account. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return baseType
	 */
	public BaseType getBaseType() {
		return baseType;
	}

	public void setBaseType(BaseType baseType) {
		this.baseType = baseType;
	}

	@Override
	public String toString() {
		return "VerifyTransactionCriteria [amount=" + amount + ", keyword=" + keyword + ", baseType=" + baseType
				+ ", date=" + date + ", dateVariance=" + dateVariance + ", matched=" + matched
				+ ", verifiedTransaction=" + verifiedTransactions + "]";
	}
}
