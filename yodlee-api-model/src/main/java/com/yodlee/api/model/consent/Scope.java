/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.consent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.consent.enums.DataCluster;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"scopeId", "title", "titleBody", "datasetAttributes"})
public class Scope extends AbstractModelComponent {

	@ApiModelProperty(name = "scopeId",
					  required = true,
					  value = "Unique Dataset Cluster name for the consent group like " + "<br/> ACCOUNT_DETAILS"
							  + "<br/> STATEMENT_DETAILS" + "<br/> CONTACT_DETAILS" + "<br/> TRANSACTION_DETAILS")
	@JsonProperty("scopeId")
	private DataCluster scopeId;

	@ApiModelProperty(name = "title", required = true, value = "Title for the Data Cluster.")
	@JsonProperty("title")
	private String title;

	@ApiModelProperty(name = "titleBody", required = true, value = "Title body that explains the purpose of the scope.")
	@JsonProperty("titleBody")
	private List<String> titleBodies;

	@ApiModelProperty(name = "datasetAttributes",
					  required = true,
					  value = "Permissions that are associated with the Consent group like"
							  + "<br/> BASIC_AGG_DATA.BASIC_ACCOUNT_INFO" + "<br/> BASIC_AGG_DATA.ACCOUNT_DETAILS"
							  + "<br/> BASIC_AGG_DATA.STATEMENTS" + "<br/> BASIC_AGG_DATA.TRANSACTIONS"
							  + "<br/> ACCT_PROFILE.HOLDER_NAME" + "<br/> ACCT_PROFILE.FULL_ACCT_NUMBER"
							  + "<br/> ACCT_PROFILE.BANK_TRANSFER_CODE" + "<br/> ACCT_PROFILE.HOLDER_DETAILS")
	@JsonProperty("datasetAttributes")
	private List<String> datasetAttributes;

	/**
	 * Unique Dataset Cluster name for the consent group like <br>
	 * ACCOUNT_DETAILS <br>
	 * STATEMENT_DETAILS <br>
	 * CONTACT_DETAILS <br>
	 * TRANSACTION_DETAILS <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * <li>GET Consent</li>
	 * </ul>
	 * 
	 * @return scopeId
	 */
	public DataCluster getScopeId() {
		return scopeId;
	}

	/**
	 * Title for the Data Cluster. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * <li>GET Consent</li>
	 * </ul>
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Title body that explains the purpose of the scope. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * <li>GET Consent</li>
	 * </ul>
	 * 
	 * @return titleBody
	 */
	@JsonProperty("titleBody")
	public List<String> getTitleBodies() {
		return titleBodies == null ? null : Collections.unmodifiableList(titleBodies);
	}

	/**
	 * Permissions that are associated with the Consent group like <br>
	 * BASIC_AGG_DATA.BASIC_ACCOUNT_INFO <br>
	 * BASIC_AGG_DATA.ACCOUNT_DETAILS <br>
	 * BASIC_AGG_DATA.STATEMENTS <br>
	 * BASIC_AGG_DATA.TRANSACTIONS <br>
	 * ACCT_PROFILE.HOLDER_NAME <br>
	 * ACCT_PROFILE.FULL_ACCT_NUMBER <br>
	 * ACCT_PROFILE.BANK_TRANSFER_CODE <br>
	 * ACCT_PROFILE.HOLDER_DETAILS <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * <li>GET Consent</li>
	 * </ul>
	 * 
	 * @return datasetAttributes
	 */
	public List<String> getDatasetAttributes() {
		return datasetAttributes == null ? null : Collections.unmodifiableList(datasetAttributes);
	}

	public void setScopeId(DataCluster scopeId) {
		this.scopeId = scopeId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("titleBody")
	public void setTitleBodies(List<String> titleBodies) {
		if (this.titleBodies == null) {
			this.titleBodies = new ArrayList<>();
		}
		this.titleBodies = titleBodies;
	}

	public boolean addTitleBodies(String titleBody) {
		if (titleBodies == null) {
			titleBodies = new ArrayList<>();
		}
		return titleBodies.add(titleBody);
	}

	public boolean removeTitleBodies(String titleBody) {
		if (titleBodies != null) {
			return titleBodies.remove(titleBody);
		}
		return false;
	}

	public void clearTitleBodies() {
		if (titleBodies != null) {
			titleBodies.clear();
		}
	}

	public void setDatasetAttributes(List<String> datasetAttributes) {
		if (this.datasetAttributes == null) {
			this.datasetAttributes = new ArrayList<>();
		}
		this.datasetAttributes = datasetAttributes;
	}

	public boolean addDatasetAttributes(String datasetAttributes) {
		if (this.datasetAttributes == null) {
			this.datasetAttributes = new ArrayList<>();
		}
		return this.datasetAttributes.add(datasetAttributes);
	}

	public boolean removeDatasetAttributes(String datasetAttributes) {
		if (this.datasetAttributes != null) {
			return this.datasetAttributes.remove(datasetAttributes);
		}
		return false;
	}

	public void clearDatasetAttributes() {
		if (datasetAttributes != null) {
			datasetAttributes.clear();
		}
	}

	@Override
	public String toString() {
		return "Scope [scopeId=" + scopeId + ", title=" + title + ", titleBodies=" + titleBodies
				+ ", datasetAttributes=" + datasetAttributes + "]";
	}
}
