/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;

import io.swagger.annotations.ApiModelProperty;

public class CreditAcceleratorDocument extends AbstractModelComponent {
	
	@JsonProperty("id")
	@ApiModelProperty(readOnly = true,
	  value = "The document's primary key and unique identifier."
	          + "<br><br>"//
	          + "<b>Applicable containers</b>: bank and investment<br>")
	private String id;
	
	@JsonProperty("accountID")
	@ApiModelProperty(readOnly = true,
	  value = "The primary key of the account resource and the unique identifier for the account."
	          + "<br><br>"//
	          + "<b>Aggregated / Manual</b>: Both <br>"//
	          + "<b>Applicable containers</b>: All containers<br>"//
	          + "<b>Endpoints</b>:"//
	          + "<ul>"//
	          + "<li>GET accounts </li>"//
	          + "<li>GET accounts/{accountId}</li>"//
	          + "<li>GET investmentOptions</li>"//
	          + "<li>GET accounts/historicalBalances</li>"//
	          + "<li>POST accounts</ul>")
	private Long accountID;
	
	@JsonProperty("docType")
	@ApiModelProperty(readOnly = true,
	  value = "Indicates the type of the document.")
	private String docType;
	
	@JsonProperty("formType")
	@ApiModelProperty(readOnly = true,
	  value = "Indicates the type of the tax form.")
	private String formType;
	
	@JsonProperty("name")
	@ApiModelProperty(readOnly = true,
	  value = "The name of the document."
			  + "<br><br>"//
	          + "<b>Applicable containers</b>: bank and investment<br>")
	private String name;
	
	@JsonProperty("source")
	@ApiModelProperty(readOnly = true,
	  value = "Indicates the source of the document download."
			  + "<br><br>"//
	          + "<b>Applicable containers</b>: bank and investment<br>")
	private String source;
	
	@JsonProperty("lastUpdated")
	@ApiModelProperty(readOnly = true,
	  value = "Indicates the date and time the document was last updated."
			  + "<br><br>"//
	          + "<b>Applicable containers</b>: bank and investment<br>")
	private String lastUpdated;
	
	@JsonProperty("statementDate")
	@ApiModelProperty(readOnly = true,
	  value = "Indicates the date and time of the document."
			  + "<br><br>"//
	          + "<b>Applicable containers</b>: bank and investment<br>")
	private String statementDate;
	
	@JsonProperty("status")
	@ApiModelProperty(readOnly = true,
			 value = "Indicates the status of the document download."
					 + "<br><br>"//
			          + "<b>Applicable containers</b>: bank and investment<br>")
	private String status;
	
	@JsonProperty("uri")
	@ApiModelProperty(readOnly = true,
	  value = "Relative URI to fetch the actual document")
	private String uri;

	public String getId() {
		return id;
	}

	public Long getAccountID() {
		return accountID;
	}

	public String getDocType() {
		return docType;
	}

	public String getFormType() {
		return formType;
	}

	public String getName() {
		return name;
	}

	public String getSource() {
		return source;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public String getStatementDate() {
		return statementDate;
	}

	public String getStatus() {
		return status;
	}

	public String getUri() {
		return uri;
	}

}
