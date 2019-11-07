/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.provideraccounts.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.provideraccounts.ProviderAccountProfile;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProviderAccountUserProfileResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("providerAccount")
	private List<ProviderAccountProfile> providerAccountProfiles;

	@JsonProperty("providerAccount")
	public List<ProviderAccountProfile> getProviderAccountProfile() {
		return providerAccountProfiles == null ? null : Collections.unmodifiableList(providerAccountProfiles);
	}
}
