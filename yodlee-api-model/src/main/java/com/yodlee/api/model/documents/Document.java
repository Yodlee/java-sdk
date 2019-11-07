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
import com.yodlee.api.model.documents.enums.DocType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"docType", "id", "accountID", "name", "source", "lastUpdated", "providerAccountId", "status",
		"formType"})
public class Document extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the type of the document."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank, investment, creditCard, loan, bills, insurance<br>"//
	)
	@JsonProperty("docType")
	private DocType docType;

	@ApiModelProperty(readOnly = true,
					  value = "The document's primary key and unique identifier."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank, investment, creditCard, loan, bills, insurance<br>"//
	)
	@JsonProperty("id")
	private String id;

	@ApiModelProperty(readOnly = true,
					  value = "The unique identifier for the account. The account ID to which the document is linked."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank, investment, creditCard, loan, bills, insurance<br>"//
	)
	@JsonProperty("accountID")
	private Long accountID;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the name of the document."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank, investment, creditCard, loan, bills, insurance<br>"//
	)
	@JsonProperty("name")
	private String name;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the date and time the document was last updated."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank, investment, creditCard, loan, bills, insurance<br>"//
	)
	@JsonProperty("lastUpdated")
	private String lastUpdated;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the status of the document download."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank, investment, creditCard, loan, bills, insurance<br>"//
	)
	@JsonProperty("status")
	private String status;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the type of the tax form."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank, investment, creditCard, loan, bills, insurance<br>"//
	)
	@JsonProperty("formType")
	private String formType;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the source of the document download."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank, investment, creditCard, loan, bills, insurance<br>"//
	)
	@JsonProperty("source")
	private String source;

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
	 * The unique identifier for the account. The account ID to which the document is linked. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank, investment, creditCard, loan, bills, insurance<br>
	 * 
	 * @return accountID
	 */
	public Long getAccountID() {
		return accountID;
	}

	/**
	 * Indicates the type of the tax form. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank, investment, creditCard, loan, bills, insurance<br>
	 * 
	 * @return formType
	 */
	public String getFormType() {
		return formType;
	}

	/**
	 * Indicates the type of the document. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank, investment, creditCard, loan, bills, insurance<br>
	 * 
	 * @return docType
	 */
	public DocType getDocType() {
		return docType;
	}

	/**
	 * Indicates the status of the document download. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank, investment, creditCard, loan, bills, insurance<br>
	 * 
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Indicates the name of the document. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank, investment, creditCard, loan, bills, insurance<br>
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Indicates the date and time the document was last updated. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank, investment, creditCard, loan, bills, insurance<br>
	 * 
	 * @return lastUpdated
	 */
	public String getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * Indicates the source of the document download. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank, investment, creditCard, loan, bills, insurance<br>
	 * 
	 * @return source
	 */
	public String getSource() {
		return source;
	}

	@Override
	public String toString() {
		return "Document [docType=" + docType + ", id=" + id + ", accountID=" + accountID + ", name=" + name
				+ ", lastUpdated=" + lastUpdated + ", status=" + status + ", formType=" + formType + ", source="
				+ source + "]";
	}
}
