/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.utils;

import org.testng.Assert;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.client.ApiResponse;

public class PrintUtil {

	private static final ObjectMapper mapper = new ObjectMapper();

	public static void printJSONResponse(String testCaseId, String testCaseName, ApiResponse<?> response) {
		System.out.println(String.format("Test case Id=%s\t Test case name=%s", testCaseId, testCaseName));
		if (response != null) {
			System.out.println("========  Response Begin ============");
			try {
				System.out.println("Server response : "
						+ mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response.getData()));
			} catch (JsonProcessingException e) {
				Assert.fail(e.getMessage());
			}
			System.out.println("========  Response End   ============");
		}
	}

	public static void assertFail(String testCaseId, String testCaseName, ApiException e) {
		String responseBody = e.getResponseBody();
		String message = String.format("Test case Id = %s\tTest case name = %s\tmessage = %s", testCaseId, testCaseName,
				responseBody != null ? responseBody
						: (e.getProblems() != null && e.getProblems().size() > 0 ? e.getProblems().get(0).getMessage()
								: "No Error Message recieved"));
		Assert.fail(message, e);
	}

	public static void assertFail(String testCaseId, String testCaseName, Exception e) {
		String message = String.format("Test case Id = %s\tTest case name = %s\tmessage = %s", testCaseId, testCaseName,
				e.getMessage());
		Assert.fail(message, e);
	}
}
