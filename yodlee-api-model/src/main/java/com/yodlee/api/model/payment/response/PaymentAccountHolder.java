/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.payment.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Email;
import com.yodlee.api.model.Identifier;
import com.yodlee.api.model.Name;
import com.yodlee.api.model.PhoneNumber;
import com.yodlee.api.model.account.AccountAddress;
import com.yodlee.api.model.account.enums.HolderOwnershipType;

import io.swagger.annotations.ApiModelProperty;

public class PaymentAccountHolder extends PaymentAccountBase {
	@ApiModelProperty(readOnly = true, value = "The details of the account holder’s profile."//
			+ "<br>"//
			+ "<b>Endpoints</b>:"//
			+ "<li>GET /partner/paymentProcessor/account/holder</li>"//
			+ "</ul>")
	@JsonProperty("profile")
	private AccountProfileDetail profile;

	@ApiModelProperty(readOnly = true, value = "Holder details of the account."//
			+ "<br>"//
			+ "<b>Endpoints</b>:"//
			+ "<li>GET /partner/paymentProcessor/account/holder</li>"//
			+ "</ul>")
	@JsonProperty("holder")
	private List<AccountHolderData> holders;
	

	/**
	 * Profile information of the account. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return profile
	 */
	public AccountProfileDetail getProfile() {
		return profile;
	}
	
	/**
	 * Holder details of the account. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return holder
	 */
	@JsonProperty("holder")
	public List<AccountHolderData> getHolders() {
		return holders == null ? null : Collections.unmodifiableList(holders);
	}
	
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({"address", "email", "phoneNumber", "identifier"})
	public abstract class AccountProfileDetail extends AbstractModelComponent {

		@ApiModelProperty(readOnly = true,
				 value = "Address available in the profile page of the account."//
				  + "<br>"//
				  + "<b>Endpoints</b>:"//
				  + "<li>GET /partner/paymentProcessor/account/holder</li>"//
				  + "</ul>")
		@JsonProperty("address")
		protected List<AccountAddress> addresses;

		@ApiModelProperty(readOnly = true,
				 value = "Phone number available in the profile page of the account."//
				  + "<br>"//
				  + "<b>Endpoints</b>:"//
				  + "<li>GET /partner/paymentProcessor/account/holder</li>"//
				  + "</ul>")
		@JsonProperty("phoneNumber")
		protected List<PhoneNumber> phoneNumbers;

		@ApiModelProperty(readOnly = true,
				value = "Email Id available in the profile page of the account."//
				  + "<br>"//
				  + "<b>Endpoints</b>:"//
				  + "<li>GET /partner/paymentProcessor/account/holder</li>"//
				  + "</ul>")
		@JsonProperty("email")
		protected List<Email> emails;

		@ApiModelProperty(readOnly = true,
				value = "Identifiers available in the profile page of the account."//
				  + "<br>"//
				  + "<b>Endpoints</b>:"//
				  + "<li>GET /partner/paymentProcessor/account/holder</li>"//
				  + "</ul>")
		@JsonProperty("identifier")
		protected List<Identifier> identifiers;

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
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({"ownership", "name", "identifier", "gender"})
	public class AccountHolderData extends AbstractModelComponent {

		@ApiModelProperty(readOnly = true,
						  value = "Name of the account holder."//
								  + "<br>"//
								  + "<b>Endpoints</b>:"//
								  + "<li>GET /partner/paymentProcessor/account/holder</li>"//
								  + "</ul>")
		@JsonProperty("name")
		private Name name;

		@ApiModelProperty(readOnly = true,
						  value = "Identifiers of the account holder."//
								  + "<br>"//
								  + "<b>Endpoints</b>:"//
								  + "<li>GET /partner/paymentProcessor/account/holder</li>"//
								  + "</ul>")
		@JsonProperty("identifier")
		private List<Identifier> identifier;

		@ApiModelProperty(readOnly = true,
						  value = "Identifiers of the account holder."//
								  + "<br>"//
								  + "<b>Endpoints</b>:"//
								  + "<li>GET /partner/paymentProcessor/account/holder</li>"//
								  + "</ul>")
		@JsonProperty("gender")
		private String gender;

		@ApiModelProperty(readOnly = true,
						  value = "Indicates the ownership of the account."//
								  + "<br>"//
								  + "<b>Endpoints</b>:"//
								  + "<li>GET /partner/paymentProcessor/account/holder</li>"//
								  + "</ul>")
		@JsonProperty("ownership")
		private HolderOwnershipType ownership;

		/**
		 * Name of the account holder. <br>
		 * <br>
		 * <b>Aggregated / Manual</b>: Aggregated <br>
		 * <b>Applicable containers</b>: bank<br>
		 * <b>Endpoints</b>:
		 * <ul>
		 * <li>GET accounts</li>
		 * <li>GET accounts/{accountId}</li>
		 * </ul>
		 * 
		 * @return name
		 */
		public Name getName() {
			return name;
		}

		/**
		 * Identifiers of the account holder. <br>
		 * <br>
		 * <b>Aggregated / Manual</b>: Aggregated <br>
		 * <b>Applicable containers</b>: bank<br>
		 * <b>Endpoints</b>:
		 * <ul>
		 * <li>GET accounts</li>
		 * <li>GET accounts/{accountId}</li>
		 * </ul>
		 * 
		 * @return identifier
		 */
		public List<Identifier> getIdentifier() {
			return identifier == null ? null : Collections.unmodifiableList(identifier);
		}

		/**
		 * Identifiers of the account holder. <br>
		 * <br>
		 * <b>Aggregated / Manual</b>: Aggregated <br>
		 * <b>Applicable containers</b>: bank<br>
		 * <b>Endpoints</b>:
		 * <ul>
		 * <li>GET accounts</li>
		 * <li>GET accounts/{accountId}</li>
		 * </ul>
		 * 
		 * @return gender
		 */
		public String getGender() {
			return gender;
		}

		/**
		 * Indicates the ownership of the account. <br>
		 * <br>
		 * <b>Aggregated / Manual</b>: Aggregated <br>
		 * <b>Applicable containers</b>: bank<br>
		 * <b>Endpoints</b>:
		 * <ul>
		 * <li>GET accounts</li>
		 * <li>GET accounts/{accountId}</li>
		 * </ul>
		 * <b>Applicable Values</b><br>
		 * 
		 * @return ownership
		 */
		public HolderOwnershipType getOwnership() {
			return ownership;
		}

		@Override
		public String toString() {
			return "AccountHolderData [name=" + name + ", identifier=" + identifier + ", gender=" + gender + ", ownership="
					+ ownership + "]";
		}
	}

	
	

}
