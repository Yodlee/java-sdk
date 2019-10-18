/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
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
@JsonPropertyOrder({"id", "label", "form", "fieldRowChoice", "field"})
public class Row extends AbstractModelComponent {

	@ApiModelProperty(value = "Unique identifier of the row."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providerAccounts/{providerAccountId}</li>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "</ul>")
	@JsonProperty("id")
	private String id;

	@ApiModelProperty(value = "The label text displayed for a row in the form."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providerAccounts/{providerAccountId}</li>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "</ul>")
	@JsonProperty("label")
	private String label;

	@ApiModelProperty(value = "Form denotes the set of the fields that are related. "//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providerAccounts/{providerAccountId}</li>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "</ul>")
	@JsonProperty("form")
	private String form;

	@ApiModelProperty(value = "Fields that belong to a particular choice are collected together using this field."
			+ "<br><b>Recommendations</b>: All the field row choices label to be grouped and displayed as options to the customer. On choosing a particular choice field, we recommend displaying the fields relevant to them. First field choice could be selected by default."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providerAccounts/{providerAccountId}</li>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "</ul>")
	@JsonProperty("fieldRowChoice")
	private String fieldRowChoice;

	@ApiModelProperty(value = "Details of fields that belong to the row."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providerAccounts/{providerAccountId}</li>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "</ul>")
	@JsonProperty("field")
	private List<Field> fields;

	/**
	 * Details of fields that belong to the row. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return field
	 */
	@JsonProperty("field")
	public List<Field> getFields() {
		return fields == null ? null : Collections.unmodifiableList(fields);
	}

	@JsonProperty("field")
	public void setFields(List<Field> field) {
		if (this.fields == null) {
			this.fields = new ArrayList<>();
		}
		this.fields.clear();
		this.fields.addAll(field);
	}

	public void addField(Field field) {
		if (this.fields == null) {
			this.fields = new ArrayList<>();
		}
		this.fields.add(field);
	}

	public boolean removeField(Field field) {
		if (this.fields != null) {
			return this.fields.remove(field);
		}
		return false;
	}

	public void clearField() {
		if (fields != null) {
			fields.clear();
		}
	}

	/**
	 * Unique identifier of the row. <br>
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
	 * Form denotes the set of the fields that are related. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return form
	 */
	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	/**
	 * The label text displayed for a row in the form. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
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
	 * Fields that belong to a particular choice are collected together using this field. <br>
	 * <b>Recommendations</b>: All the field row choices label to be grouped and displayed as options to the customer.
	 * On choosing a particular choice field, we recommend displaying the fields relevant to them. First field choice
	 * could be selected by default. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return fieldRowChoice
	 */
	public String getFieldRowChoice() {
		return fieldRowChoice;
	}

	public void setFieldRowChoice(String fieldRowChoice) {
		this.fieldRowChoice = fieldRowChoice;
	}

	@Override
	public String toString() {
		return "Row [id=" + id + ", label=" + label + ", form=" + form + ", fieldRowChoice=" + fieldRowChoice
				+ ", fields=" + fields + "]";
	}
}
