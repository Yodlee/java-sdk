/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "attributes"})
public class ProvidersDataset extends AbstractDataset {

	@ApiModelProperty(value = "The name of the dataset attribute suported by the provider." + "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "<li>GET providers</li>"//
			+ "</ul>")
	@JsonProperty("attribute")
	private List<Attribute> attributes;

	/**
	 * The name of the dataset attribute suported by the provider. * <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers/{providerId}</li>
	 * <li>GET providers</li>
	 * </ul>
	 * 
	 * @return attribute
	 */
	public List<Attribute> getAttributes() {
		return attributes == null ? null : Collections.unmodifiableList(attributes);
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public boolean addAttribute(Attribute attribute) {
		if (attribute == null) {
			return false;
		}
		if (attributes == null) {
			attributes = new ArrayList<>();
		}
		return attributes.add(attribute);
	}

	public boolean removeAttribute(Attribute attribute) {
		if (attributes != null) {
			return attributes.remove(attribute);
		}
		return false;
	}

	public void clearAttributes() {
		if (attributes != null) {
			attributes.clear();
		}
	}

	@Override
	public String toString() {
		return "ProvidersDataset [attributes=" + attributes + "]";
	}
}
