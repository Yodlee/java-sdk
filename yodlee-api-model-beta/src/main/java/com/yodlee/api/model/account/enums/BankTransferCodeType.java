/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account.enums;

public enum BankTransferCodeType {
	/**
	 * BSB is a Bank-State-Branch number used to identify the branch in Australia and is required for performing
	 * transfers
	 * 
	 */
	BSB,
	//
	//
	/**
	 * IFSC is Indian Financial System Code. It is an alphanumeric code that is used to identify the particular branch
	 * in India and is required for electronic funds settlement
	 * 
	 */
	IFSC, //
	//
	//
	/**
	 * Bank routing number or routing transit number (RTN) is a nine digit number used in US to identify financial
	 * institution in a transaction. Most common transaction types where routing numbers are used are ACH and wire
	 * transfers
	 * 
	 */
	ROUTING_NUMBER,//
	//
	//
	/**
	 * The sort code is a six-digit number used in UK to identify both the bank and the branch where the account is held
	 * 
	 */
	SORT_CODE
}
