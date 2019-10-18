/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.webhooks;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.dataextracts.DataExtractsUser;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"links", "user"})
public class UserData {

	@JsonProperty("links")
	private List<Link> links;

	@JsonProperty("user")
	private DataExtractsUser user;

	@JsonProperty("links")
	public List<Link> getLinks() {
		return links == null ? null : Collections.unmodifiableList(links);
	}

	@JsonProperty("user")
	public DataExtractsUser getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "UserData [links=" + links + ", user=" + user + "]";
	}
}
