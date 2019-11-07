/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account.enums;

public enum LifeInsuranceType {
	//
	//
	/**
	 * Other type of insurances
	 */
	OTHER,
	//
	//
	/**
	 * Term insurance, a type of life insurance, provides coverage for a certain period of time or years. If the insured
	 * dies over the policy tenure a death benefit (or sum assured) is paid out. No payout is made if the insured
	 * survives the tenure
	 */
	TERM_LIFE_INSURANCE,
	//
	//
	/**
	 * Universal life insurance (often shortened to UL) is a type of cash value life insurance, sold primarily in the
	 * United States of America. Under the terms of the policy, the excess of premium payments above the current cost of
	 * insurance is credited to the cash value of the policy
	 */
	UNIVERSAL_LIFE_INSURANCE,
	//
	//
	/**
	 * Life insurance policy which is guaranteed to remain in force for the insured's entire lifetime, provided required
	 * premiums are paid, or to the maturity date
	 */
	WHOLE_LIFE_INSURANCE,
	//
	//
	/**
	 * Variable life insurance is a permanent life insurance policy with an investment component
	 */
	VARIABLE_LIFE_INSURANCE,
	//
	//
	/**
	 * ULIP is a life insurance product, which provides risk cover for the policy holder along with investment options
	 * to invest in any number of qualified investments such as stocks, bonds or mutual funds
	 */
	ULIP,
	//
	//
	/**
	 * An endowment policy is a life insurance contract designed to pay a lump sum after a specific term (on its
	 * 'maturity') or on death
	 */
	ENDOWMENT;
}
