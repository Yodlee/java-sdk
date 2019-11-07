/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.enums.AttributeName;
import com.yodlee.api.model.enums.Container;
import io.swagger.annotations.ApiModelProperty;

public abstract class AbstractAttribute extends AbstractModelComponent {

	@ApiModelProperty(value = "Attributes that are supported for a dataset."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providers</li>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "</ul>")
	@NotNull(message = "name cannot be null")
	@JsonProperty("name")
	protected AttributeName name;

	@ApiModelProperty(value = "Containers for which the attributes are supported."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providers</li>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "</ul>"//
	)
	@JsonProperty("container")
	protected List<Container> containers;

	/**
	 * Attributes that are supported for a dataset. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return name
	 */
	public AttributeName getName() {
		return name;
	}

	public void setName(AttributeName name) {
		this.name = name;
	}

	/**
	 * Containers for which the attributes are supported. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providers</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return container
	 */
	@JsonProperty("container")
	public List<Container> getContainers() {
		return containers == null ? null : Collections.unmodifiableList(containers);
	}

	@JsonProperty("container")
	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}

	public boolean addContainer(Container container) {
		if (container == null) {
			return false;
		}
		if (containers == null) {
			containers = new ArrayList<>();
		}
		return containers.add(container);
	}

	public boolean removeContainer(Container container) {
		if (containers != null) {
			return containers.remove(container);
		}
		return false;
	}

	public void clearContainers() {
		if (containers != null) {
			containers.clear();
		}
	}
}
