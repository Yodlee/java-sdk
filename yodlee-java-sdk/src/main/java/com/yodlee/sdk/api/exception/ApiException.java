/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.sdk.api.exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yodlee.api.model.YodleeError;
import com.yodlee.api.model.validator.Problem;

public class ApiException extends Exception {

	private static final long serialVersionUID = 755063301177528109L;

	private static final Logger LOGGER = LoggerFactory.getLogger(ApiException.class);

	private final boolean isClientSideError;

	private final int httpStatus;

	private final String responseBody;

	private final transient YodleeError serverError;

	private final transient List<Problem> problems = new ArrayList<>();

	private final transient Map<String, List<String>> responseHeaders = new HashMap<>();

	public ApiException(Throwable throwable) {
		this(throwable.getMessage(), Collections.<Problem>emptyList(), throwable, 0,
				Collections.<String, List<String>>emptyMap(), null, false);
	}

	public ApiException(String message) {
		this(message, Collections.<Problem>emptyList(), (Throwable) null, 0,
				Collections.<String, List<String>>emptyMap(), null, false);
	}

	public ApiException(List<Problem> problems) {
		this("Validation failed.", problems, (Throwable) null, 0, Collections.<String, List<String>>emptyMap(), null,
				true);
	}

	public ApiException(List<Problem> problems, String message, boolean isClientSideError) {
		this(message, problems, (Throwable) null, 0, null, null, isClientSideError);
	}

	public ApiException(String message, int httpStatus, Map<String, List<String>> responseHeaders,
			String responseBody) {
		this(message, Collections.<Problem>emptyList(), (Throwable) null, httpStatus, responseHeaders, responseBody,
				false);
	}

	public ApiException(String message, Throwable throwable, int httpStatus,
			Map<String, List<String>> responseHeaders) {
		this(message, Collections.<Problem>emptyList(), throwable, httpStatus, responseHeaders, null, false);
	}

	public ApiException(String message, List<Problem> problems, Throwable throwable, int httpStatus,
			Map<String, List<String>> responseHeaders, String responseBody, boolean isClientSideError) {
		super(message, throwable);
		this.httpStatus = httpStatus;
		this.problems.addAll(problems);
		this.responseHeaders.putAll(responseHeaders);
		this.responseBody = responseBody;
		this.isClientSideError = isClientSideError;
		YodleeError yodleeError = null;
		if (responseBody != null) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				yodleeError = mapper.readValue(responseBody, YodleeError.class);
			} catch (IOException e) {
				LOGGER.error("Exception occurred.", e);
			}
		}
		serverError = yodleeError == null ? null : yodleeError;
	}

	public List<Problem> getProblems() {
		return Collections.unmodifiableList(problems);
	}

	public boolean isClientSideError() {
		return isClientSideError;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public Map<String, List<String>> getResponseHeaders() {
		return Collections.unmodifiableMap(responseHeaders);
	}

	public String getResponseBody() {
		return responseBody;
	}

	public YodleeError getServerError() {
		return serverError;
	}

	private String isHttpCodeExist(int httpStatus) {
		return httpStatus == 0 ? "" : (", httpStatus=" + httpStatus);
	}

	@Override
	public String toString() {
		return "ApiException [problems=" + problems + ", isClientSideError=" + isClientSideError
				+ isHttpCodeExist(httpStatus) + ", responseHeaders=" + responseHeaders + ", responseBody="
				+ responseBody + ", message=" + getMessage() + "]";
	}
}
