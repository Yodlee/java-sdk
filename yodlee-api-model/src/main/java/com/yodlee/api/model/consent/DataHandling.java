/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.consent;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"headerDescription", "dataList"})
public class DataHandling {
	
	@ApiModelProperty(name = "headerDescription", required = true, value = "De-identification of data")
    @JsonProperty("headerDescription")
	private String headerDescription;

    @ApiModelProperty(name = "dataList", required = true, value = "We will apply the CDR de-identificatiion process. "
    		+ "<br/> De-identificatied data will be used without further consent."
    		+ "<br/> De-identification of CDR data means your data cannot be associated with your identity after de-identification process takes place.")
    @JsonProperty("dataList")
    private List<String> dataList;
    
    /**
     * headerDescription of DataHandling
     * <br>
     * 	 <b>Endpoints</b>:
     * 	 <ul>
     * 	<li>POST Consent</li>
     * 	</ul>
     *
     * @return url
     */

	public String getHeaderDescription() {
		return headerDescription;
	}

	public void setHeaderDescription(String headerDescription) {
		this.headerDescription = headerDescription;
	}
	
	/**
     * dataList of DataHandling
     * <br>
     * 	 <b>Endpoints</b>:
     * 	 <ul>
     * 	<li>POST Consent</li>
     * 	</ul>
     *
     * @return dataList
     */

	public List<String> getDataList() {
		return dataList;
	}

	public void setDataList(List<String> dataList) {
		this.dataList = dataList;
	}
	
	@Override
    public String toString() {
        return "DataHandling[" +
                "headerDescription=" + headerDescription + ", dataList=" + dataList + "]";
    }

}
