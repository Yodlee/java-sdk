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
@JsonPropertyOrder({"url", "name"})
public class ThirdPartyADR {

    @ApiModelProperty(name = "url", required = true, value = "Unique Id of ADR")
    @JsonProperty("url")
    String url;

    @ApiModelProperty(name = "name", required = true, value = "name of ADR")
    @JsonProperty("name")
    String name;

    /**
     * Url of ThirdPartyADR
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

    /**
     * Name of ThirdPartyADR
     * <br>
     * 	 <b>Endpoints</b>:
     * 	 <ul>
     * 	<li>POST Consent</li>
     * 	</ul>
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ThirdPartyADR[" +
                "url=" + url + ", name=" + name + "]";
    }
}
