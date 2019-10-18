/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.account.enums.HolderOwnershipType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ownership", "name", "identifier", "gender"})
public class AccountHolder extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "Name of the account holder."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated <br>"//
							  + "<b>Applicable containers</b>: bank<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>")
	@JsonProperty("name")
	private Name name;

	@ApiModelProperty(readOnly = true,
					  value = "Identifiers of the account holder."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated <br>"//
							  + "<b>Applicable containers</b>: bank<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>")
	@JsonProperty("identifier")
	private List<Identifier> identifier;

	@ApiModelProperty(readOnly = true,
					  value = "Identifiers of the account holder."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated <br>"//
							  + "<b>Applicable containers</b>: bank<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>")
	@JsonProperty("gender")
	private String gender;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the ownership of the account."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated <br>"//
							  + "<b>Applicable containers</b>: bank<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
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
		return "AccountHolder [name=" + name + ", identifier=" + identifier + ", gender=" + gender + ", ownership="
				+ ownership + "]";
	}
}
