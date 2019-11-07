/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.providers.ContainerAttributes;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "container", "containerAttributes"})
public class Attribute extends AbstractAttribute {

	/**
	 * Applicable only to Attributes of type Transaction Datasets in Providers GET.
	 */
	@ApiModelProperty(readOnly = true)
	@JsonProperty("containerAttributes")
	private ContainerAttributes containerAttributes;

	/**
	 * Containers for which the attributes are supported. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return container attributes
	 */
	public ContainerAttributes getContainerAttributes() {
		return containerAttributes;
	}

	public void setContainerAttributes(ContainerAttributes containerAttributes) {
		this.containerAttributes = containerAttributes;
	}

	@Override
	public String toString() {
		return "Attribute [containerAttributes=" + containerAttributes + ", name=" + name + ", containers=" + containers
				+ "]";
	}
}
