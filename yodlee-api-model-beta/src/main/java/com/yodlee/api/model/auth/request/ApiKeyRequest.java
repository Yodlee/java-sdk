/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.auth.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yodlee.api.model.Request;
import com.yodlee.api.model.auth.AbstractApiKey;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiKeyRequest extends AbstractApiKey implements Request {}
