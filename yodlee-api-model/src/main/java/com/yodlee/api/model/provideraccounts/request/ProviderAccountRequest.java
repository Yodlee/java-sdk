/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.provideraccounts.request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.Field;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"consentId", "loginForm", "dataset"})
public class ProviderAccountRequest extends AbstractProviderAccountRequest {

	@ApiModelProperty(name = "consentId",
					  required = false,
					  value = "Consent Id generated for the request through POST Consent."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>POST Provider Account</li>" //
							  + "<li>PUT Provider Account</li>" //
							  + "</ul>")
	@JsonProperty("consentId")
	private Long consentId;

	@NotNull(message = "{providerAccounts.param.field.required}")
	@Valid
	@JsonProperty("field")
	private List<Field> fields;

	@JsonProperty("field")
	public List<Field> getField() {
		return fields == null ? null : Collections.unmodifiableList(fields);
	}

	@JsonProperty("field")
	public void setField(List<Field> fields) {
		this.fields = fields;
	}

	public boolean addField(Field field) {
		if (field == null) {
			return false;
		}
		if (fields == null) {
			fields = new ArrayList<>();
		}
		return fields.add(field);
	}

	public boolean removeField(Field field) {
		if (field == null) {
			return false;
		}
		return fields.remove(field);
	}

	public void clearFields() {
		if (fields != null) {
			fields.clear();
		}
	}

	/**
	 * Consent Id generated for the request through POST Consent. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>POST Provider Account</li>
	 * <li>PUT Provider Account</li>
	 * </ul>
	 * 
	 * @return consentId
	 */
	public Long getConsentId() {
		return consentId;
	}

	public void setConsentId(Long consentId) {
		this.consentId = consentId;
	}

	@Override
	public String toString() {
		return "ProviderAccountRequest [consentId=" + consentId + ", datasets=" + datasets + ", preferences="
				+ preferences + ", field=" + fields + ", datasetName=" + datasetNames + "]";
	}
}
