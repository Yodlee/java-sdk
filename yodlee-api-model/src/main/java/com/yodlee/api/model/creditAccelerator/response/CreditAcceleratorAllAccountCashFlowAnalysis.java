/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({"timePeriod", "cashInflow", "cashInflowIncome", "cashInflowDeposits", 
	"cashInflowTransfers", "cashInflowOtherCredits", "cashOutflow", "cashOutflowExpenses", 
	"cashOutflowWithdrawals", "cashOutflowTransfers", "cashOutflowDebitServicing", "cashOutflowOtherDebits", 
	"cashLeftover", "adjustedCashInflow", "adjustedCashInflowIncome", "adjustedCashInflowDeposits", 
	"adjustedCashInflowTransfers", "adjustedCashInflowOtherCredits", "adjustedCashOutflow", 
	"adjustedCashOutflowExpenses", "adjustedCashOutflowWithdrawals", "adjustedCashOutflowTransfers",
	"adjustedCashOutflowDebitServicing", "adjustedCashOutflowOtherDebits", "adjustedCashLeftover", 
	"cashInflowBank", "cashOutflowBank", "cashLeftoverBank", "adjustedCashInflowBank", "adjustedCashOutflowBank", 
	"adjustedCashLeftoverBank"})
public class CreditAcceleratorAllAccountCashFlowAnalysis {

	@JsonProperty("timePeriod")
	@ApiModelProperty(readOnly = true, value = "Time intervals to consider up to the number of days the application was requested.")
	private String timePeriod;
	
	@JsonProperty("cashInflow")
	@ApiModelProperty(readOnly = true, value = "Sum of all cash inflow transactions.")
	private Double cashInflow;
	
	@JsonProperty("cashInflowIncome")
	@ApiModelProperty(readOnly = true, value = "Sum of cash inflow transactions identified as income.")
	private Double cashInflowIncome;
	
	@JsonProperty("cashInflowDeposits")
	@ApiModelProperty(readOnly = true, value = "Sum of cash inflow transactions identified as deposits (excluding income).")
	private Double cashInflowDeposits;
	
	@JsonProperty("cashInflowTransfers")
	@ApiModelProperty(readOnly = true, value = "Sum of cash inflow transactions identified as transfers (excluding large amounts), grouped by Currency.")
	private Double cashInflowTransfers;
	
	@JsonProperty("cashInflowOtherCredits")
	@ApiModelProperty(readOnly = true, value = "Sum of cash inflow transactions identified as other credits.")
	private Double cashInflowOtherCredits;

	@JsonProperty("cashOutflow")
	@ApiModelProperty(readOnly = true, value = "Sum of all cash outflow transactions.")
	private Double cashOutflow;
	
	@JsonProperty("cashOutflowExpenses")
	@ApiModelProperty(readOnly = true, value = "Sum of cash outflow transactions identified as expenses.")
	private Double cashOutflowExpenses;
	
	@JsonProperty("cashOutflowWithdrawals")
	@ApiModelProperty(readOnly = true, value = "Sum of cash outflow transactions identified as checks and withdrawals.")
	private Double cashOutflowWithdrawals;
	
	@JsonProperty("cashOutflowTransfers")
	@ApiModelProperty(readOnly = true, value = "Sum of cash outflow transactions identified as transfers.")
	private Double cashOutflowTransfers;
	
	@JsonProperty("cashOutflowDebitServicing")
	@ApiModelProperty(readOnly = true, value = "Sum of cash outflow transactions identified as repayments of debt.")
	private Double cashOutflowDebitServicing;
	
	@JsonProperty("cashOutflowOtherDebits")
	@ApiModelProperty(readOnly = true, value = "Sum of cash outflow transactions identified as other debits.")
	private Double cashOutflowOtherDebits;
	
	@JsonProperty("cashLeftover")
	@ApiModelProperty(readOnly = true, value = "Cash inflow subtracted by cash outflow.")
	private Double cashLeftover; // all credits - all debits
	
	@JsonProperty("adjustedCashInflow")
	@ApiModelProperty(readOnly = true, value = "Sum of all cash inflow transactions (excluding large amounts), grouped by Currency.")
	private Double adjustedCashInflow;
	
	@JsonProperty("adjustedCashInflowIncome")
	@ApiModelProperty(readOnly = true, value = "Sum of cash inflow transactions identified as income (excluding large amounts), grouped by Currency.")
	private Double adjustedCashInflowIncome;
	
	@JsonProperty("adjustedCashInflowDeposits")
	@ApiModelProperty(readOnly = true, value = "Sum of cash inflow transactions identified as deposits (excluding income and large amounts), grouped by Currency.")
	private Double adjustedCashInflowDeposits;
	
	@JsonProperty("adjustedCashInflowTransfers")
	@ApiModelProperty(readOnly = true, value = "Sum of cash outflow transactions identified as checks and withdrawals.")
	private Double adjustedCashInflowTransfers;
	
	@JsonProperty("adjustedCashInflowOtherCredits")
	@ApiModelProperty(readOnly = true, value = "Sum of cash inflow transactions identified as other credits (excluding large amounts), grouped by Currency.")
	private Double adjustedCashInflowOtherCredits;
	
	@JsonProperty("adjustedCashOutflow")
	@ApiModelProperty(readOnly = true, value = "Sum of all cash outflow transactions (excluding large amounts), grouped by Currency.")
	private Double adjustedCashOutflow;
	
	@JsonProperty("adjustedCashOutflowExpenses")
	@ApiModelProperty(readOnly = true, value = "Sum of cash outflow transactions identified as expenses (excluding large amounts), grouped by Currency.")
	private Double adjustedCashOutflowExpenses;
	
	@JsonProperty("adjustedCashOutflowWithdrawals")
	@ApiModelProperty(readOnly = true, value = "Sum of cash outflow transactions identified as checks and withdrawals (excluding large amounts), grouped by Currency.")
	private Double adjustedCashOutflowWithdrawals;
	
	@JsonProperty("adjustedCashOutflowTransfers")
	@ApiModelProperty(readOnly = true, value = "Sum of cash outflow transactions identified as transfers (excluding large amounts), grouped by Currency.")
	private Double adjustedCashOutflowTransfers;
	
	@JsonProperty("adjustedCashOutflowDebitServicing")
	@ApiModelProperty(readOnly = true, value = "Sum of cash outflow transactions identified as repayments of debt (excluding large amounts), grouped by Currency.")
	private Double adjustedCashOutflowDebitServicing;
	
	@JsonProperty("adjustedCashOutflowOtherDebits")
	@ApiModelProperty(readOnly = true, value = "Sum of cash outflow transactions identified as other debits (excluding large amounts), grouped by Currency.")
	private Double adjustedCashOutflowOtherDebits;
	
	@JsonProperty("adjustedCashLeftover")
	@ApiModelProperty(readOnly = true, value = "Cash inflow (excluding large amounts) subtracted by cash outflow (excluding large amounts).")
	private Double adjustedCashLeftover;
	
	// only Bank
	@JsonProperty("cashInflowBank")
	@ApiModelProperty(readOnly = true, value = "Sum of all cash inflow transactions for Bank accounts only, grouped by Currency.")
	private Double cashInflowBank;
	
	@JsonProperty("cashOutflowBank")
	@ApiModelProperty(readOnly = true, value = "Sum of all cash outflow transactions for Bank accounts only, grouped by Currency.")
	private Double cashOutflowBank;
	
	@JsonProperty("cashLeftoverBank")
	@ApiModelProperty(readOnly = true, value = "Bank cash inflow subtracted by Bank cash outflow.")
	private Double cashLeftoverBank;
	
	@JsonProperty("adjustedCashInflowBank")
	@ApiModelProperty(readOnly = true, value = "Sum of all cash inflow transactions (excluding large amounts) for Bank accounts only, grouped by Currency.")
	private Double adjustedCashInflowBank;
	
	@JsonProperty("adjustedCashOutflowBank")
	@ApiModelProperty(readOnly = true, value = "Sum of all cash outflow transactions (excluding large amounts) for Bank accounts only, grouped by Currency.")
	private Double adjustedCashOutflowBank;
	
	@JsonProperty("adjustedCashLeftoverBank")
	@ApiModelProperty(readOnly = true, value = "Bank cash inflow (excluding large amounts) subtracted by Bank cash outflow (excluding large amounts).")
	private Double adjustedCashLeftoverBank;
	
	public String getTimePeriod() {
		return timePeriod;
	}
	public Double getCashInflow() {
		return cashInflow;
	}
	public Double getCashInflowIncome() {
		return cashInflowIncome;
	}
	public Double getCashInflowDeposits() {
		return cashInflowDeposits;
	}
	public Double getCashInflowTransfers() {
		return cashInflowTransfers;
	}
	public Double getCashInflowOtherCredits() {
		return cashInflowOtherCredits;
	}
	public Double getCashOutflow() {
		return cashOutflow;
	}
	public Double getCashOutflowExpenses() {
		return cashOutflowExpenses;
	}
	public Double getCashOutflowWithdrawals() {
		return cashOutflowWithdrawals;
	}
	public Double getCashOutflowTransfers() {
		return cashOutflowTransfers;
	}
	public Double getCashOutflowDebitServicing() {
		return cashOutflowDebitServicing;
	}
	public Double getCashOutflowOtherDebits() {
		return cashOutflowOtherDebits;
	}
	public Double getCashLeftover() {
		return cashLeftover;
	}
	public Double getAdjustedCashInflow() {
		return adjustedCashInflow;
	}
	public Double getAdjustedCashInflowIncome() {
		return adjustedCashInflowIncome;
	}
	public Double getAdjustedCashInflowDeposits() {
		return adjustedCashInflowDeposits;
	}
	public Double getAdjustedCashInflowTransfers() {
		return adjustedCashInflowTransfers;
	}
	public Double getAdjustedCashInflowOtherCredits() {
		return adjustedCashInflowOtherCredits;
	}
	public Double getAdjustedCashOutflow() {
		return adjustedCashOutflow;
	}
	public Double getAdjustedCashOutflowExpenses() {
		return adjustedCashOutflowExpenses;
	}
	public Double getAdjustedCashOutflowWithdrawals() {
		return adjustedCashOutflowWithdrawals;
	}
	public Double getAdjustedCashOutflowTransfers() {
		return adjustedCashOutflowTransfers;
	}
	public Double getAdjustedCashOutflowDebitServicing() {
		return adjustedCashOutflowDebitServicing;
	}
	public Double getAdjustedCashOutflowOtherDebits() {
		return adjustedCashOutflowOtherDebits;
	}
	public Double getAdjustedCashLeftover() {
		return adjustedCashLeftover;
	}
	public Double getCashInflowBank() {
		return cashInflowBank;
	}
	public Double getCashOutflowBank() {
		return cashOutflowBank;
	}
	public Double getCashLeftoverBank() {
		return cashLeftoverBank;
	}
	public Double getAdjustedCashInflowBank() {
		return adjustedCashInflowBank;
	}
	public Double getAdjustedCashOutflowBank() {
		return adjustedCashOutflowBank;
	}
	public Double getAdjustedCashLeftoverBank() {
		return adjustedCashLeftoverBank;
	}

}
