/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.context;

import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.configuration.AbstractConfiguration;

public interface Context<C extends AbstractConfiguration> {

	public ContextType getContextType();

	public ApiClient getApiClient();

	public C getConfiguration();
}
