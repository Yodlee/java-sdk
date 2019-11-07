/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account.enums;

public enum HolderOwnershipType {
	/**
	 * The account holder is a primary holder of the account
	 */
	PRIMARY,//
	/**
	 * The account holder is a secondary holder of the account
	 */
	SECONDARY,//
	/**
	 * The account holder is a custodian of the account
	 */
	CUSTODIAN,//
	/**
	 * An account ownership other than what has been listed here
	 */
	OTHERS,//
	/**
	 * The account holder has a power of attorney authorizing him or her to access the account
	 */
	POWER_OF_ATTORNEY,//
	/**
	 * The account holder is a trustee that controls funds for the benefit of another party - an individual or a group
	 */
	TRUSTEE,//
	/**
	 * The account holder has a joint ownership of the account
	 */
	JOINT_OWNER,//
	/**
	 * The account holder is a beneficiary of the account. The beneficiary has no control or ownership of the account
	 * while the account owner is alive, but is designated by the account owner to own the account upon the owner's
	 * death
	 */
	BENEFICIARY,//
	/**
	 * Indicates that the account holder is an authorized account signatory (AAS)
	 */
	AAS,//
	/**
	 * Indicates that the account holder is a business
	 */
	BUSINESS,//
	/**
	 * Indicates that the account holder is a business using a different name, i.e., doing business as (DBA)
	 */
	DBA,//
	/**
	 * Indicates that the account holder is a trust
	 */
	TRUST
}
