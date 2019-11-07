/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.api.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import com.yodlee.api.model.validator.Problem;

public class ApiUtils {

	private static final String VALIDATION_MESSAGES_BUNDLE = "ValidationMessages";

	private static final ConcurrentMap<Locale, ResourceBundle> resourcBundleMap = new ConcurrentHashMap<>();
	static {
		resourcBundleMap.put(Locale.getDefault(), ResourceBundle.getBundle(VALIDATION_MESSAGES_BUNDLE));
	}

	private ApiUtils() {}

	public static String getMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName().replace("Async", "");
	}

	public static String getErrorMessage(String errorString, Object... values) {
		String keyNotFound = "Error message : " + errorString + " not found.";
		String errorMessage = resourcBundleMap.get(Locale.getDefault()).getString(errorString);
		return formattedMessage(keyNotFound, errorMessage, values);
	}

	public static String getErrorMessage(String errorString, Locale locale, Object... values) {
		resourcBundleMap.putIfAbsent(locale, ResourceBundle.getBundle(VALIDATION_MESSAGES_BUNDLE, locale));
		ResourceBundle defaultValue = resourcBundleMap.get(Locale.US);
		String keyNotFound = "Error message : " + errorString + " not found.";
		String errorMessage = null;
		if (resourcBundleMap.get(locale) == null) {
			errorMessage = defaultValue.getString(errorString);
		} else {
			errorMessage = resourcBundleMap.get(locale).getString(errorString);
		}
		return formattedMessage(keyNotFound, errorMessage, values);
	}

	private static String formattedMessage(String keyNotFound, String errorMessage, Object... values) {
		return errorMessage == null ? keyNotFound : MessageFormat.format(errorMessage, values);
	}

	public static String convertArrayToString(Object[] request) {
		if (request == null) {
			return "";
		}
		StringBuilder values = new StringBuilder();
		for (int i = 0; i < request.length; i++) {
			values.append(request[i]).append(i < request.length - 1 ? "," : "");
		}
		return values.toString();
	}

	public static String convertArrayToString(long[] request) {
		if (request == null) {
			return "";
		}
		StringBuilder values = new StringBuilder();
		for (int i = 0; i < request.length; i++) {
			values.append(request[i]).append(i < request.length - 1 ? "," : "");
		}
		return values.toString();
	}

	public static List<Problem> isConflictingParams(Object arg1, Object arg2, String errMsg) {
		List<Problem> problems = new ArrayList<>();
		if (arg1 != null && arg2 != null)
			problems.add(new Problem(ApiUtils.getErrorMessage(errMsg), ""));
		return problems;
	}
}
