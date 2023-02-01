/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.consent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"description", "cdrPolicy", "dataHandling"})
public class UserDataTreatment {
	
	@ApiModelProperty(name = "description", required = true, value = "After we have finished using your data or you have withdraw your consent to use the data, it will be de-identified as per our")
    @JsonProperty("description")
	private String description;

    @ApiModelProperty(name = "cdrPolicy", required = true, value = "Details of CDR Policy")
    @JsonProperty("cdrPolicy")
    private CdrPolicy cdrPolicy;
    
    @ApiModelProperty(name = "dataHandling", required = true, value = "Details of CDR Data Handling")
    @JsonProperty("dataHandling")
    private DataHandling dataHandling;
    
    /**
     * description of UserDataTreatment
     * <br>
     * 	 <b>Endpoints</b>:
     * 	 <ul>
     * 	<li>POST Consent</li>
     * 	</ul>
     *
     * @return description
     */

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
     * cdrPolicy of UserDataTreatment
     * <br>
     * 	 <b>Endpoints</b>:
     * 	 <ul>
     * 	<li>POST Consent</li>
     * 	</ul>
     *
     * @return cdrPolicy
     */

	public CdrPolicy getCdrPolicy() {
		return cdrPolicy;
	}

	public void setCdrPolicy(CdrPolicy cdrPolicy) {
		this.cdrPolicy = cdrPolicy;
	}
	
	/**
     * dataHandling of UserDataTreatment
     * <br>
     * 	 <b>Endpoints</b>:
     * 	 <ul>
     * 	<li>POST Consent</li>
     * 	</ul>
     *
     * @return dataHandling
     */

	public DataHandling getDataHandling() {
		return dataHandling;
	}

	public void setDataHandling(DataHandling dataHandling) {
		this.dataHandling = dataHandling;
	}
	
	@Override
    public String toString() {
        return "UserDataTreatment[" +
                "description=" + description + ", cdrPolicy=" + cdrPolicy + ", dataHandling=" + dataHandling +"]";
    }
}
