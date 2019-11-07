/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.enums.FieldType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "name", "size", "maxLength", "minLength", "type", "isValueProvided", "value", "isOptional",
		"valueEditable", "option", "prefix", "suffix", "validation"})
public class Field extends AbstractModelComponent {

	@ApiModelProperty(value = "Identifier for the field."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providerAccounts/{providerAccountId}</li>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "</ul>")
	@NotEmpty(message="{providerAccounts.param.field.id.required}")
	@JsonProperty("id")
	private String id;

	@ApiModelProperty(readOnly = true,
					  value = "Name of the field."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "</ul>")
	@JsonProperty("name")
	private String name;

	@JsonProperty("size")
	private Long size;

	@ApiModelProperty(readOnly = true,
					  value = "The maximum length of the login form field."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "</ul>")
	@JsonProperty("maxLength")
	private Long maxLength;

	@ApiModelProperty(readOnly = true,
					  value = "The minimum length of the login form field."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "</ul>")
	@JsonProperty("minLength")
	private Long minLength;

	@ApiModelProperty(readOnly = true,
					  value = "This indicates the display type of the field. For example, text box, image, etc. "//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("type")
	private FieldType type;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates that the answer to the security question already exists in the Yodlee system."
							  + "Persuading the user to provide the answer to the security question again during the edit-credential flow can be avoided.<br>"
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts?include=questions</li>"//
							  + "<li>GET providerAccounts/{providerAccountId}? include=questions</li>"//
							  + "</ul>")
	@JsonProperty("isValueProvided")
	private Boolean isValueProvided;

	@ApiModelProperty(value = "Value expected from the user for the field. This will be blank and is expected to be filled and sent back when submitting the login or MFA information."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providerAccounts/{providerAccountId}</li>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "</ul>")
	@NotEmpty(message="{providerAccounts.param.field.value.required}")
	@JsonProperty("value")
	private String value;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates if a field is an optional field or a mandatory field."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "</ul>")
	@JsonProperty("isOptional")
	private Boolean isOptional;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates whether the field is editable or not."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "</ul>")
	@JsonProperty("valueEditable")
	private String valueEditable;

	@ApiModelProperty(readOnly = true,
					  value = "Provides the different values that are available for the user to choose. This field is applicable for drop-down or radio field types."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "</ul>")
	@JsonProperty("option")
	private List<Option> options;

	@ApiModelProperty(readOnly = true,
					  value = "The prefix string that has to be displayed before the field value."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "</ul>")
	@JsonProperty("prefix")
	private String prefix;

	@ApiModelProperty(readOnly = true,
					  value = "The suffix string that has to be displayed next to the field value."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "</ul>")
	@JsonProperty("suffix")
	private String suffix;

	/**
	 * Identifier for the field. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * The maximum length of the login form field. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return maxLength
	 */
	public Long getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Long maxLength) {
		this.maxLength = maxLength;
	}

	/**
	 * The minimum length of the login form field. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return minLength
	 */
	public Long getMinLength() {
		return minLength;
	}

	public void setMinLength(Long minLength) {
		this.minLength = minLength;
	}

	/**
	 * Name of the field. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Indicates that the answer to the security question already exists in the Yodlee system. Persuading the user to
	 * provide the answer to the security question again during the edit-credential flow can be avoided.<br>
	 * <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts?include=questions</li>
	 * <li>GET providerAccounts/{providerAccountId}? include=questions</li>
	 * </ul>
	 * 
	 * @return isValueProvided
	 */
	public Boolean getIsValueProvided() {
		return isValueProvided;
	}

	public void setIsValueProvided(Boolean isValueProvided) {
		this.isValueProvided = isValueProvided;
	}

	/**
	 * Value expected from the user for the field. This will be blank and is expected to be filled and sent back when
	 * submitting the login or MFA information. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
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
	 * Indicates whether the field is editable or not. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return valueEditable
	 */
	public String getValueEditable() {
		return valueEditable;
	}

	public void setValueEditable(String valueEditable) {
		this.valueEditable = valueEditable;
	}

	/**
	 * This indicates the display type of the field. For example, text box, image, etc. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return type
	 */
	public FieldType getType() {
		return type;
	}

	public void setType(FieldType type) {
		this.type = type;
	}

	/**
	 * Indicates if a field is an optional field or a mandatory field. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return isOptional
	 */
	public Boolean getIsOptional() {
		return isOptional;
	}

	public void setIsOptional(Boolean isOptional) {
		this.isOptional = isOptional;
	}

	/**
	 * Provides the different values that are available for the user to choose. This field is applicable for drop-down
	 * or radio field types. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return option
	 */
	@JsonProperty("option")
	public List<Option> getOption() {
		return options == null ? null : Collections.unmodifiableList(options);
	}

	@JsonProperty("option")
	public void setOption(List<Option> option) {
		if (this.options == null) {
			this.options = new ArrayList<>();
		}
		this.options = option;
	}

	public void addOption(Option option) {
		if (this.options == null) {
			this.options = new ArrayList<>();
		}
		this.options.add(option);
	}

	public boolean removeOption(Option option) {
		if (this.options != null) {
			return this.options.remove(option);
		}
		return false;
	}

	public void clearOption() {
		if (this.options != null) {
			this.options.clear();
		}
	}

	/**
	 * The prefix string that has to be displayed before the field value. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * The suffix string that has to be displayed next to the field value. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return suffix
	 */
	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Field [id=" + id + ", name=" + name + ", size=" + size + ", maxLength=" + maxLength + ", minLength="
				+ minLength + ", type=" + type + ", isValueProvided=" + isValueProvided + ", value=" + value
				+ ", isOptional=" + isOptional + ", valueEditable=" + valueEditable + ", options=" + options
				+ ", prefix=" + prefix + ", suffix=" + suffix + "]";
	}
}
