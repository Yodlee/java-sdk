/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.consent.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.consent.UpdateConsent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdatedConsentResponse extends AbstractModelComponent implements Response {
	
	@ApiModelProperty(readOnly=true)
	@JsonProperty(value = "consent", required = false)
	private List<UpdateConsent> consents;
	
	@JsonProperty("consent")
	public List<UpdateConsent> getConsents() {
		return consents == null ? null : Collections.unmodifiableList(consents);
	}

	@Override
	public String toString() {
		return "UpdatedConsentResponse [consents=" + consents + "]";
	}
	
}
