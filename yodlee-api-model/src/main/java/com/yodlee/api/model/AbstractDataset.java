/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.enums.DatasetNameType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractDataset extends AbstractModelComponent {

	@ApiModelProperty(value = "The name of the dataset requested from the provider site" + "<br><br>"//
			+ "<b>Account Type</b>: Manual<br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET accounts</li>"//
			+ "<li>GET accounts/{accountId}</li>"//
			+ "<li>GET providerAccounts</li>"//
			+ "<li>POST providerAccounts</li>"//
			+ "<li>PUT providerAccounts/{providerAccountId}</li>"//
			+ "<li>GET providerAccounts/{providerAccountId}</li>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "<li>GET providers</li>"//
			+ "</ul>"//
			+ "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("name")
	private DatasetNameType name;

	/**
	 * The name of the dataset requested from the provider site <br>
	 * <br>
	 * <b>Account Type</b>: Manual<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * <li>GET providerAccounts</li>
	 * <li>POST providerAccounts</li>
	 * <li>PUT providerAccounts/{providerAccountId}</li>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return name
	 */
	public DatasetNameType getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractDataset other = (AbstractDataset) obj;
		return name == other.name;
	}
	
	
}
