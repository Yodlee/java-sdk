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


public class ConsentPreferences {
	@ApiModelProperty(name = "id",
            required = true,
            value = "preference id for AU Open Banking only."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET consents/preferences/{consentId}</li>"//
			+ "</ul>")
    @JsonProperty("id")
    private Long id;
    
    @ApiModelProperty(name = "value",
            required = true,
            value = "preference value for AU Open Banking only."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET consents/preferences/{consentId}</li>"//
			+ "</ul>")
    @JsonProperty("value")
    private String value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ConsentPreferences [id=" + id + ", value=" + value + "]";
	}

    
    
	
}