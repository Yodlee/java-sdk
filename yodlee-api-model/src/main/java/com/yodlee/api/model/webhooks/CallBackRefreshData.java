/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.webhooks;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.provideraccounts.UpdatedProviderAccount;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"providerAccount"})
public class CallBackRefreshData extends AbstractModelComponent {

	@JsonProperty("providerAccount")
	private List<UpdatedProviderAccount> providerAccount;

	@JsonProperty("providerAccount")
	public List<UpdatedProviderAccount> getProviderAccount() {
		return providerAccount == null ? null : Collections.unmodifiableList(providerAccount);
	}

	@Override
	public String toString() {
		return "CallBackRefreshData [providerAccount=" + providerAccount + "]";
	}
}
