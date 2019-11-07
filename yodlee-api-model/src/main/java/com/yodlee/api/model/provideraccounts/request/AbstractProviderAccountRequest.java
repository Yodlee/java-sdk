/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.provideraccounts.request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.ProvidersDataset;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.enums.DatasetNameType;
import com.yodlee.api.model.provideraccounts.ProviderAccountPreferences;

public abstract class AbstractProviderAccountRequest extends AbstractModelComponent implements Request {

	@JsonProperty("dataset")
	protected List<ProvidersDataset> datasets;

	@JsonProperty("preferences")
	protected ProviderAccountPreferences preferences;

	@JsonProperty("datasetName")
	protected List<DatasetNameType> datasetNames;

	public AbstractProviderAccountRequest() {
		super();
	}

	@JsonProperty("dataset")
	public List<ProvidersDataset> getDatasets() {
		return datasets == null ? null : Collections.unmodifiableList(datasets);
	}

	@JsonProperty("dataset")
	public void setDatasets(List<ProvidersDataset> datasets) {
		this.datasets = datasets;
	}

	public boolean addDataset(ProvidersDataset dataset) {
		if (dataset == null) {
			return false;
		}
		if (datasets == null) {
			datasets = new ArrayList<>();
		}
		return this.datasets.add(dataset);
	}

	public boolean removeDataset(ProvidersDataset dataset) {
		if (datasets == null) {
			return false;
		}
		return this.datasets.remove(dataset);
	}

	public void clearDatasets() {
		if (datasets != null) {
			datasets.clear();
		}
	}

	@JsonProperty("preferences")
	public ProviderAccountPreferences getPreferences() {
		return preferences;
	}

	@JsonProperty("preferences")
	public void setPreferences(ProviderAccountPreferences preferences) {
		this.preferences = preferences;
	}

	@JsonProperty("datasetName")
	public List<DatasetNameType> getDatasetName() {
		return datasetNames == null ? null : Collections.unmodifiableList(datasetNames);
	}

	@JsonProperty("datasetName")
	public void setDatasetNames(List<DatasetNameType> datasetNames) {
		this.datasetNames = datasetNames;
	}

	public boolean addDatasetName(DatasetNameType datasetName) {
		if (datasetName == null) {
			return false;
		}
		if (datasetNames == null) {
			datasetNames = new ArrayList<>();
		}
		return datasetNames.add(datasetName);
	}

	public boolean removeDatasetName(DatasetNameType datasetName) {
		if (datasetNames == null) {
			return false;
		}
		return datasetNames.remove(datasetName);
	}

	public void clearDatasetNames() {
		if (datasetNames != null) {
			datasetNames.clear();
		}
	}
}
