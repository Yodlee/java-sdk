/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"errorCode", "errorMessage"})
public class YodleeError extends AbstractModelComponent {

	@JsonProperty("errorCode")
	private String errorCode;

	@JsonProperty("errorMessage")
	private String errorMessage;

	@JsonProperty("referenceCode")
	private String referenceCode;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	@Override
	public String toString() {
		return "YodleeError [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", referenceCode="
				+ referenceCode + "]";
	}
}
