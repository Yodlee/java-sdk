/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.sampleflow;

import java.util.Collections;
import java.util.List;
import com.yodlee.api.model.Field;

public class SampleAppResources {

	private String dnsName;

	private String userLoginName;

	private String searchProvider;

	private String providerId;

	private List<Field> field;

	public String getDnsName() {
		return dnsName;
	}

	public void setDnsName(String dnsName) {
		this.dnsName = dnsName;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getSearchProvider() {
		return searchProvider;
	}

	public void setSearchProvider(String searchProvider) {
		this.searchProvider = searchProvider;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public List<Field> getField() {
		return field == null ? null : Collections.unmodifiableList(field);
	}

	public void setField(List<Field> field) {
		this.field = field;
	}
}
