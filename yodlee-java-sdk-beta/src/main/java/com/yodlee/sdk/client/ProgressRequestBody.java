/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
/*
 * Yodlee Core APIs This file describes the Yodlee Platform APIs, using the swagger notation. You can use this swagger
 * file to generate client side SDKs to the Yodlee Platform APIs for many different programming languages. You can
 * generate a client SDK for Python, Java, javascript, PHP or other languages according to your development needs. For
 * more details about our APIs themselves, please refer to https://developer.yodlee.com/Yodlee_API/.
 *
 * OpenAPI spec version: 1.1.0 Contact: developer@yodlee.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git Do not edit the class manually.
 */
package com.yodlee.sdk.client;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

public class ProgressRequestBody extends RequestBody {

	public interface ProgressRequestListener {

		void onRequestProgress(long bytesWritten, long contentLength, boolean done);
	}

	private final RequestBody requestBody;

	private final ProgressRequestListener progressListener;

	public ProgressRequestBody(RequestBody requestBody, ProgressRequestListener progressListener) {
		this.requestBody = requestBody;
		this.progressListener = progressListener;
	}

	@Override
	public MediaType contentType() {
		return requestBody.contentType();
	}

	@Override
	public long contentLength() throws IOException {
		return requestBody.contentLength();
	}

	@Override
	public void writeTo(BufferedSink sink) throws IOException {
		BufferedSink bufferedSink = Okio.buffer(sink(sink));
		requestBody.writeTo(bufferedSink);
		bufferedSink.flush();
	}

	private Sink sink(Sink sink) {
		return new ForwardingSink(sink) {

			long bytesWritten = 0L;

			long contentLength = 0L;

			@Override
			public void write(Buffer source, long byteCount) throws IOException {
				super.write(source, byteCount);
				if (contentLength == 0) {
					contentLength = contentLength();
				}
				bytesWritten += byteCount;
				progressListener.onRequestProgress(bytesWritten, contentLength, bytesWritten == contentLength);
			}
		};
	}
}