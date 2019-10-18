/*
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.auth.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.auth.AbstractApiKey;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiKeyRequest extends AbstractApiKey implements Request {}
