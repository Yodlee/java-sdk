/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.provideraccounts;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.LoginForm;
import io.swagger.annotations.ApiModelProperty;

public class UpdatedProviderAccount extends AbstractProviderAccount {

	@ApiModelProperty(readOnly = true,
					  value = "The date on when the provider account is created in the system."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts</li>"//
							  + "<li>POST providerAccounts</li>"//
							  + "<li>PUT providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("createdDate")
	private String createdDate;

	@ApiModelProperty(readOnly = true,
					  value = "This entity gets returned in the response for only MFA based provider accounts during the add/update account polling process. This indicates that the MFA information is expected from the user to complete the process. This represents the structure of MFA form that is displayed to the user in the provider site."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts</li>"//
							  + "<li>POST providerAccounts</li>"//
							  + "<li>PUT providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "</ul>")
	@JsonProperty("loginForm")
	private List<LoginForm> loginForm;

	/**
	 * The date on when the provider account is created in the system. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts</li>
	 * <li>POST providerAccounts</li>
	 * <li>PUT providerAccounts/{providerAccountId}</li>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * </ul>
	 * 
	 * @return createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * This entity gets returned in the response for only MFA based provider accounts during the add/update account
	 * polling process. This indicates that the MFA information is expected from the user to complete the process. This
	 * represents the structure of MFA form that is displayed to the user in the provider site. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts</li>
	 * <li>POST providerAccounts</li>
	 * <li>PUT providerAccounts/{providerAccountId}</li>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * </ul>
	 * 
	 * @return loginForm
	 */
	public List<LoginForm> getLoginForm() {
		return loginForm == null ? null : Collections.unmodifiableList(loginForm);
	}

	@Override
	public String toString() {
		return "UpdatedProviderAccount [createdDate=" + createdDate + ", loginForm=" + loginForm + ", id=" + id
				+ ", aggregationSource=" + aggregationSource + ", providerId=" + providerId + ", isManual=" + isManual
				+ ", requestId=" + requestId + ", status=" + status + ", datasets=" + datasets + "]";
	}
}
