/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.providers;

import java.util.Collections;
import java.util.List;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.enums.Container;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "container", "containerAttributes"})
public class Capability extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true)
	@NotNull(message = "name cannot be null")
	@JsonProperty("name")
	private String name;

	@ApiModelProperty(readOnly = true)
	@NotNull(message = "container cannot be null")
	@JsonProperty("container")
	private List<Container> containers;

	public String getName() {
		return name;
	}

	@JsonProperty("container")
	public List<Container> getContainers() {
		return containers == null ? null : Collections.unmodifiableList(containers);
	}

	@Override
	public String toString() {
		return "Capability [name=" + name + ", containers=" + containers + "]";
	}
}
