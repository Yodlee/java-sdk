/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.configuration;

import java.io.Serializable;

public abstract class AbstractConfiguration implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String SDK_VERSION = "1.0.22.beta4";

	protected AbstractConfiguration() {}
}
