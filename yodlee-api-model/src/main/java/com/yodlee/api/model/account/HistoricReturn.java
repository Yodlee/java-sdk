/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.account;

import com.yodlee.api.model.AbstractModelComponent;

public class HistoricReturn extends AbstractModelComponent {

	private Double oneMonthReturn;

	private Double threeMonthReturn;

	private Double oneYearReturn;

	private Double threeYearReturn;

	private Double fiveYearReturn;

	private Double tenYearReturn;

	public Double getOneMonthReturn() {
		return oneMonthReturn;
	}

	public void setOneMonthReturn(Double oneMonthReturn) {
		this.oneMonthReturn = oneMonthReturn;
	}

	public Double getThreeMonthReturn() {
		return threeMonthReturn;
	}

	public void setThreeMonthReturn(Double threeMonthReturn) {
		this.threeMonthReturn = threeMonthReturn;
	}

	public Double getOneYearReturn() {
		return oneYearReturn;
	}

	public void setOneYearReturn(Double oneYearReturn) {
		this.oneYearReturn = oneYearReturn;
	}

	public Double getThreeYearReturn() {
		return threeYearReturn;
	}

	public void setThreeYearReturn(Double threeYearReturn) {
		this.threeYearReturn = threeYearReturn;
	}

	public Double getFiveYearReturn() {
		return fiveYearReturn;
	}

	public void setFiveYearReturn(Double fiveYearReturn) {
		this.fiveYearReturn = fiveYearReturn;
	}

	public Double getTenYearReturn() {
		return tenYearReturn;
	}

	public void setTenYearReturn(Double tenYearReturn) {
		this.tenYearReturn = tenYearReturn;
	}
}
