/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.sdk.builder;

import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.configuration.AbstractConfiguration;
import com.yodlee.sdk.context.Context;

public interface Builder<C extends AbstractConfiguration, T extends Context<C>> {

	public abstract T build(C configuration) throws ApiException;
}
