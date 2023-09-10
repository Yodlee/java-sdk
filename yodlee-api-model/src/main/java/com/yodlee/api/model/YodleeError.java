/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({"errorCode", "errorMessage"})
public class YodleeError extends AbstractModelComponent {

	@JsonProperty("errorCode")
	@ApiModelProperty(readOnly = true, value = "The error code follows the format YNNN. The error codes do not change. New error codes may be added as we introduce new features and enhance functionalities.")
	private String errorCode;

	@JsonProperty("errorMessage")
	@ApiModelProperty(readOnly = true, value = "The descriptive message that explains the error scenario.")
	private String errorMessage;

	@JsonProperty("referenceCode")
	@ApiModelProperty(readOnly = true, value = "Unique Yodlee identifier used to troubleshoot issues at Yodlee’s end.")
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
