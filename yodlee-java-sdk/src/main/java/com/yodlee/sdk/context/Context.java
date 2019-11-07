/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.context;

import com.yodlee.sdk.client.ApiClient;
import com.yodlee.sdk.configuration.AbstractConfiguration;

public interface Context<C extends AbstractConfiguration> {

	public ContextType getContextType();

	public ApiClient getApiClient();

	public C getConfiguration();
}
