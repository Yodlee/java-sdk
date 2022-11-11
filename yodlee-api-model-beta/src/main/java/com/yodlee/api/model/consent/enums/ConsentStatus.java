/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.consent.enums;


public enum ConsentStatus {
	/**
	 *	The consent is Active when the user adds/edits an account with a
	 * 	generated consent ID.
	 */
	ACTIVE,//
	/**
	* Consent generated from input dataset or implicit dataset.<br>
	*/
	CONSENT_GENERATED,//
	/**
	* Consent is accepted by user by selecting from list of consent attributes.<br>
	*/
	CONSENT_ACCEPTED,//
	/**
	* Consent is authorized when user adds/updates an account with generated consent id.<br>
	*/
	CONSENT_AUTHORIZED,//
	/**
	* When user provides not accepted consent id or already authorized consent for add/update account.<br>
	*/
	CONSENT_MISMATCH,//
	/**
	 * The consent is PENDING when it is yet to be authorized by the user
	 * with the generated consent ID.
	 */
	PENDING,//
	/**
	 * The consent is expired when it runs out of its expiry period.
	 */
	EXPIRED,//
	/**
	 * The consent is revoked when the user explicitly revokes it.
	 */
	REVOKED,//
	/**
	 * The consent is invalid and needs reauthorization from provider end.
	 */
	CONSENT_REPEALED//
	
}
