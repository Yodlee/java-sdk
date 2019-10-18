/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.account;

import java.util.List;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;
import com.yodlee.api.model.enums.HoldingType;

public class InvestmentOption extends AbstractModelComponent {

	private HoldingType holdingType;

	private String cusipNumber;

	private String description;

	private String isin;

	private Long id;

	private Money price;

	private String priceAsOfDate;

	private String sedol;

	private String symbol;

	private String inceptionDate;

	private String inceptionToDateReturn;

	private Double yearToDateReturn;

	private Double grossExpenseRatio;

	private Double netExpenseRatio;

	private Money grossExpenseAmount;

	private Money netExpenseAmount;

	private HistoricReturn historicReturns;

	private List<AccountAssetClassification> assetClassification;

	public HoldingType getHoldingType() {
		return holdingType;
	}

	public void setHoldingType(HoldingType holdingType) {
		this.holdingType = holdingType;
	}

	public String getCusipNumber() {
		return cusipNumber;
	}

	public void setCusipNumber(String cusipNumber) {
		this.cusipNumber = cusipNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

	public String getPriceAsOfDate() {
		return priceAsOfDate;
	}

	public void setPriceAsOfDate(String priceAsOfDate) {
		this.priceAsOfDate = priceAsOfDate;
	}

	public String getSedol() {
		return sedol;
	}

	public void setSedol(String sedol) {
		this.sedol = sedol;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getInceptionDate() {
		return inceptionDate;
	}

	public void setInceptionDate(String inceptionDate) {
		this.inceptionDate = inceptionDate;
	}

	public String getInceptionToDateReturn() {
		return inceptionToDateReturn;
	}

	public void setInceptionToDateReturn(String inceptionToDateReturn) {
		this.inceptionToDateReturn = inceptionToDateReturn;
	}

	public Double getYearToDateReturn() {
		return yearToDateReturn;
	}

	public void setYearToDateReturn(Double yearToDateReturn) {
		this.yearToDateReturn = yearToDateReturn;
	}

	public Double getGrossExpenseRatio() {
		return grossExpenseRatio;
	}

	public void setGrossExpenseRatio(Double grossExpenseRatio) {
		this.grossExpenseRatio = grossExpenseRatio;
	}

	public Double getNetExpenseRatio() {
		return netExpenseRatio;
	}

	public void setNetExpenseRatio(Double netExpenseRatio) {
		this.netExpenseRatio = netExpenseRatio;
	}

	public Money getGrossExpenseAmount() {
		return grossExpenseAmount;
	}

	public void setGrossExpenseAmount(Money grossExpenseAmount) {
		this.grossExpenseAmount = grossExpenseAmount;
	}

	public Money getNetExpenseAmount() {
		return netExpenseAmount;
	}

	public void setNetExpenseAmount(Money netExpenseAmount) {
		this.netExpenseAmount = netExpenseAmount;
	}

	public HistoricReturn getHistoricReturns() {
		return historicReturns;
	}

	public void setHistoricReturns(HistoricReturn historicReturns) {
		this.historicReturns = historicReturns;
	}

	public List<AccountAssetClassification> getAssetClassification() {
		return assetClassification;
	}

	public void setAssetClassification(List<AccountAssetClassification> assetClassification) {
		this.assetClassification = assetClassification;
	}
}
