/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.client.util;

import java.util.concurrent.TimeUnit;
import com.yodlee.sdk.client.UnzippingInterceptor;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

public enum OkHttpUtil {
	OKHTTP_INSTANCE;

	private OkHttpClient okhttpClient = null;

	private final OkHttpClient.Builder okHttpBuilder;

	OkHttpUtil() {
		okHttpBuilder = new OkHttpClient.Builder();
	}

	public OkHttpClient getOkHttpClient(int socketTimeOut, int readTimeOut, int writeTimeOut, int maxIdleConnection,
			int connectionKeepAliveDuration) {
		if (okhttpClient == null) {
			synchronized (OkHttpUtil.class) {
				if (okhttpClient == null) {
					okHttpBuilder.connectTimeout(socketTimeOut, TimeUnit.MILLISECONDS)
							.readTimeout(readTimeOut, TimeUnit.MILLISECONDS)
							.writeTimeout(writeTimeOut, TimeUnit.MILLISECONDS)
							.connectionPool(new ConnectionPool(maxIdleConnection, connectionKeepAliveDuration,
									TimeUnit.MILLISECONDS))
							.addInterceptor(new UnzippingInterceptor());
					okhttpClient = okHttpBuilder.build();
				}
			}
		}
		return okhttpClient;
	}

	public OkHttpClient.Builder getOkHttpBuilder() {
		return okHttpBuilder;
	}
}
