/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.documents;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "docContent"})
public class DocumentDownload extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "The document's primary key and unique identifier."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank, investment, creditCard, loan, bills, insurance<br>"//
	)
	@JsonProperty("id")
	private String id;

	@ApiModelProperty(readOnly = true,
					  value = "Contents of the document in Base64 format."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank, investment, creditCard, loan, bills, insurance<br>"//
	)
	@JsonProperty("docContent")
	private String docContent;

	/**
	 * The document's primary key and unique identifier. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank, investment, creditCard, loan, bills, insurance<br>
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Contents of the document in Base64 format. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank, investment, creditCard, loan, bills, insurance<br>
	 * 
	 * @return docContent
	 */
	public String getDocContent() {
		return docContent;
	}

	@Override
	public String toString() {
		return "DocumentDownload [id=" + id + "]";
	}
}
