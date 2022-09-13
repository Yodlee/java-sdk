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
@JsonPropertyOrder({"title", "id","value","label","type"})
public class Preferences {

    @ApiModelProperty(name = "title",
            required = true,
            value = "Type of the preferences " + "<br/> additionalUseOfData"
                    + "<br/> userDataPurge")
    @JsonProperty("title")
    private String title;

    @ApiModelProperty(name = "id", required = true, value = "Id of the preference")
    @JsonProperty("id")
    private int id;

    @ApiModelProperty(name = "value", required = true, value = "Value of the preference")
    @JsonProperty("value")
    private String value;

    @ApiModelProperty(name = "label", required = false, value = "Detailed description for each preference")
    @JsonProperty("label")
    private String label;

    @ApiModelProperty(name = "type", required = true, value = "Visual Type of the preference selection")
    @JsonProperty("type")
    private String type;

    /**
     * Title of the Preference
     * <br>
     * 	 <b>Endpoints</b>:
     * 	 <ul>
     * 	<li>POST Consent</li>
     * 	</ul>
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Identifier of the Preference
     * <br>
     * 	 <b>Endpoints</b>:
     * 	 <ul>
     * 	<li>POST Consent</li>
     * 	</ul>
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Value of the Preference
     * <br>
     * 	 <b>Endpoints</b>:
     * 	 <ul>
     * 	<li>POST Consent</li>
     * 	</ul>
     *
     * @return value
     */
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Label for the selected Preference
     * <br>
     * 	 <b>Endpoints</b>:
     * 	 <ul>
     * 	<li>POST Consent</li>
     * 	</ul>
     *
     * @return label
     */
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Type of the Preference
     * <br>
     * 	 <b>Endpoints</b>:
     * 	 <ul>
     * 	<li>POST Consent</li>
     * 	</ul>
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Preferences[" +
                "title=" + title + ", id=" + id + ", value="
                + value + ", label=" + label + ", type=" + type  + "]";
    }
}
