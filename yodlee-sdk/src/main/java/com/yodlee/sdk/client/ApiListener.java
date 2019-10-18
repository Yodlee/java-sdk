/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.client;

import java.util.EventListener;

public interface ApiListener extends EventListener {

	public void requestUpdate(long bytesWritten, long contentLength, boolean done);

	public void responseUpdate(long bytesRead, long contentLength, boolean done);
}
