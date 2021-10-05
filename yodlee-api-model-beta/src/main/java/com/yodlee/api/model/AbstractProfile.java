/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.account.AccountAddress;
import io.swagger.annotations.ApiModelProperty;

public abstract class AbstractProfile extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
			 value = "Address available in the profile page of the account."//
			  + "<br><br>"//
			  + "<b>Account Type</b>: Aggregated<br>"//
			  + "<b>Endpoints</b>:"//
			  + "<ul>"//
			  + "<li>GET accounts</li>"//
			  + "<li>GET accounts/{accountId}</li>"//
			  + "</ul>")
	@JsonProperty("address")
	protected List<AccountAddress> addresses;

	@ApiModelProperty(readOnly = true,
			 value = "Phone number available in the profile page of the account."//
			  + "<br><br>"//
			  + "<b>Account Type</b>: Aggregated<br>"//
			  + "<b>Endpoints</b>:"//
			  + "<ul>"//
			  + "<li>GET accounts</li>"//
			  + "<li>GET accounts/{accountId}</li>"//
			  + "</ul>")
	@JsonProperty("phoneNumber")
	protected List<PhoneNumber> phoneNumbers;

	@ApiModelProperty(readOnly = true,
			value = "Email Id available in the profile page of the account."//
			  + "<br><br>"//
			  + "<b>Account Type</b>: Aggregated<br>"//
			  + "<b>Endpoints</b>:"//
			  + "<ul>"//
			  + "<li>GET accounts</li>"//
			  + "<li>GET accounts/{accountId}</li>"//
			  + "</ul>")
	@JsonProperty("email")
	protected List<Email> emails;

	@ApiModelProperty(readOnly = true,
			value = "Identifiers available in the profile page of the account."//
			  + "<br><br>"//
			  + "<b>Account Type</b>: Aggregated<br>"//
			  + "<b>Endpoints</b>:"//
			  + "<ul>"//
			  + "<li>GET accounts</li>"//
			  + "<li>GET accounts/{accountId}</li>"//
			  + "</ul>")
	@JsonProperty("identifier")
	protected List<Identifier> identifiers;

	public AbstractProfile() {
		super();
	}

	/**
	 * Email Id available in the profile page of the account. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * <li>GET providerAccounts/profile</li>
	 * </ul>
	 * 
	 * @return email
	 */
	@JsonProperty("email")
	public List<Email> getEmails() {
		return emails == null ? null : Collections.unmodifiableList(emails);
	}

	/**
	 * Address available in the profile page of the account. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * <li>GET providerAccounts/profile</li>
	 * </ul>
	 * 
	 * @return address
	 */
	@JsonProperty("address")
	public List<AccountAddress> getAddresses() {
		return addresses == null ? null : Collections.unmodifiableList(addresses);
	}

	/**
	 * Phone number available in the profile page of the account. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * <li>GET providerAccounts/profile</li>
	 * </ul>
	 * 
	 * @return phoneNumber
	 */
	@JsonProperty("phoneNumber")
	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers == null ? null : Collections.unmodifiableList(phoneNumbers);
	}

	/**
	 * Identifiers available in the profile page of the account. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * <li>GET providerAccounts/profile</li>
	 * </ul>
	 * 
	 * @return identifier
	 */
	@JsonProperty("identifier")
	public List<Identifier> getIdentifier() {
		return identifiers == null ? null : Collections.unmodifiableList(identifiers);
	}
}
