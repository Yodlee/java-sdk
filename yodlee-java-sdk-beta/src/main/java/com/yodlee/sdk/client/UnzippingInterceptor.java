/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.client;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yodlee.sdk.api.ApiConstants;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.http.RealResponseBody;
import okio.GzipSource;
import okio.Okio;

public class UnzippingInterceptor implements Interceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(UnzippingInterceptor.class);

	@Override
	public Response intercept(Chain chain) throws IOException {
		Response response = chain.proceed(chain.request());
		return unzip(response);
	}

	// copied from okhttp3.internal.http.HttpEngine (because is private)
	private Response unzip(final Response response) throws IOException {
		if (response.body() == null) {
			return response;
		}
		// check if we have gzip response
		String contentEncoding = response.headers().get(ApiConstants.CONTENT_ENCODING);
		// this is used to decompress gzipped responses
		if (contentEncoding != null && contentEncoding.equals(ApiConstants.GZIP)) {
			LOGGER.info("Decompressing the gzip response ");
			Long contentLength = response.body().contentLength();
			GzipSource responseBody = new GzipSource(response.body().source());
			Headers strippedHeaders = response.headers().newBuilder().build();
			return response.newBuilder().headers(strippedHeaders)
					.body(new RealResponseBody(response.body().contentType().toString(), contentLength,
							Okio.buffer(responseBody)))
					.build();
		} else {
			return response;
		}
	}
}
