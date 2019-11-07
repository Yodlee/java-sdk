/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.account.enums;

public enum LoanRepaymentPlanType {
	/**
	 * A 10-year payment plan where the borrower makes the same fixed payments every month
	 */
	STANDARD,//
	/**
	 * A 10-year payment plan where the monthly payments start small and increase every two years
	 */
	GRADUATED,//
	/**
	 * A payment plan with low monthly payments and an extended repayment term of up to 25 years. The borrower can
	 * either choose fixed monthly payments or graduated payments that increase over time
	 * 
	 */
	EXTENDED,//
	INCOME_BASED,//
	INCOME_CONTINGENT,//
	INCOME_SENSITIVE,//
	PAY_AS_YOU_EARN,//
	REVISED_PAY_AS_YOU_EARN;//
}
