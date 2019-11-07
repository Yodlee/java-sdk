/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.consent.request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.ProvidersDataset;
import com.yodlee.api.model.Request;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author haribabug
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateConsentRequest extends AbstractModelComponent implements Request {

	@ApiModelProperty(value = "Unique identifier for the provider site."//
			+ "(e.g., financial institution sites, biller sites, lender sites, etc.)."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>POST Consent</li>"//
			+ "</ul>")
	@JsonProperty(value = "providerId", required = true)
	private Long providerId;

	@ApiModelProperty(value = "The name of the application."//
			+ "If no applicationName is provided in the input, the default applicationName will be considered" //
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>POST Consent</li>"//
			+ "</ul>")
	@JsonProperty(value = "applicationName", required = false)
	private String applicationName;

	@ApiModelProperty(value = "The name of the dataset attribute supported by the provider." //
			+ "If no dataset value is provided, the datasets that are configured for the customer will be considered." //
			+ "The configured dataset can be overridden by providing the dataset as an input." //
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>POST Consent</li>"//
			+ "</ul>")
	@JsonProperty(value = "dataset", required = false)
	private List<ProvidersDataset> datasets;

	/**
	 * Unique identifier for the provider site. <br>
	 * (e.g., financial institution sites, biller sites, lender sites, etc.). <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * </ul>
	 * 
	 * @return providerId
	 */
	public Long getProviderId() {
		return providerId;
	}

	/**
	 * The name of the application. <br>
	 * If no applicationName is provided in the input, the default applicationName will be considered <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * </ul>
	 * 
	 * @return applicationName
	 */
	public String getApplicationName() {
		return applicationName;
	}

	/**
	 * The name of the dataset attribute supported by the provider. If no dataset value is provided, the datasets that
	 * are configured for the customer will be considered. The configured dataset can be overridden by providing the
	 * dataset as an input. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Consent</li>
	 * </ul>
	 * 
	 * @return datasets
	 */
	public List<ProvidersDataset> getDatasets() {
		return datasets == null ? null : Collections.unmodifiableList(datasets);
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public void setDatasets(List<ProvidersDataset> datasets) {
		if (this.datasets == null) {
			this.datasets = new ArrayList<>();
		}
		this.datasets = datasets;
	}

	public boolean addDataset(ProvidersDataset dataset) {
		if (datasets == null) {
			datasets = new ArrayList<>();
		}
		return this.datasets.add(dataset);
	}

	public boolean removeDataset(ProvidersDataset dataset) {
		if (datasets != null) {
			return this.datasets.remove(dataset);
		}
		return false;
	}

	public void clearDatasets() {
		if (datasets != null) {
			datasets.clear();
		}
	}

	@Override
	public String toString() {
		return "CreateConsentRequest [providerId=" + providerId + ", applicationName=" + applicationName + ", dataset="
				+ datasets + "]";
	}
}
