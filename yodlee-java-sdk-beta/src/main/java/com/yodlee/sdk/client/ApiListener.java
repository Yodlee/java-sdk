/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.client;

import java.util.EventListener;

public interface ApiListener extends EventListener {

	public void requestUpdate(long bytesWritten, long contentLength, boolean done);

	public void responseUpdate(long bytesRead, long contentLength, boolean done);
}
