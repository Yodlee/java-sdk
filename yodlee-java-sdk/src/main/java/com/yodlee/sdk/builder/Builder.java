/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.builder;

import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.configuration.AbstractConfiguration;
import com.yodlee.sdk.context.Context;

public interface Builder<C extends AbstractConfiguration, T extends Context<C>> {

	public abstract T build(C configuration) throws ApiException;
}
