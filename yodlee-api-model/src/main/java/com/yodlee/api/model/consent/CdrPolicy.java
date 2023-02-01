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
@JsonPropertyOrder({"description", "url"})
public class CdrPolicy {
	@ApiModelProperty(name = "description", required = true, value = "Consumer Data Right Policy")
    @JsonProperty("description")
	private String description;

    @ApiModelProperty(name = "url", required = true, value = "https://solutions.yodlee.com/au-cdr.html")
    @JsonProperty("url")
    private String url;
    
    /**
     * description of CdrPolicy
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
     * url of CdrPolicy
     * <br>
     * 	 <b>Endpoints</b>:
     * 	 <ul>
     * 	<li>POST Consent</li>
     * 	</ul>
     *
     * @return url
     */

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
    public String toString() {
        return "CdrPolicy[" +
                "description=" + description + ", url=" + url + "]";
    }

}
