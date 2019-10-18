/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.consent.request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.consent.enums.DataCluster;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"scopeId"})
public class UpdateConsentRequest extends AbstractModelComponent implements Request {

	@ApiModelProperty(value = "Applicable Open Banking data cluster values."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>PUT Consent</li>"//
			+ "</ul>")
	@JsonProperty(value = "scopeId", required = true)
	private List<DataCluster> scopeIds;

	/**
	 * Applicable Open Banking data cluster values. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>PUT Consent</li>
	 * </ul>
	 * 
	 * @return scopeIds
	 */
	@JsonProperty("scopeId")
	public List<DataCluster> getScopeIds() {
		return scopeIds == null ? null : Collections.unmodifiableList(scopeIds);
	}

	@JsonProperty("scopeId")
	public void setScopeIds(List<DataCluster> scopeId) {
		if (scopeIds == null) {
			scopeIds = new ArrayList<>();
		}
		this.scopeIds = scopeId;
	}

	public boolean addScopeId(DataCluster scopeId) {
		if (scopeIds == null) {
			scopeIds = new ArrayList<>();
		}
		return this.scopeIds.add(scopeId);
	}

	public boolean removeScopeId(DataCluster scopeId) {
		if (scopeIds != null) {
			return this.scopeIds.remove(scopeId);
		}
		return false;
	}

	public void clearScopeIds() {
		if (scopeIds != null) {
			scopeIds.clear();
		}
	}

	@Override
	public String toString() {
		return "UpdatedConsentRequest [scopeId = " + scopeIds + "]";
	}
}
