/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test.utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ModelUtil {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	public static <T> T load(String filePath, Class<T> t) {
		try (InputStream configStream = ModelUtil.class.getResourceAsStream(filePath)) {
			return MAPPER.readValue(configStream, t);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String loadSamlResponse(String samlResponsePath) {
		StringBuilder samlResponse = new StringBuilder("");
		try (InputStream inputStream = ModelUtil.class.getResourceAsStream(samlResponsePath);
				BufferedInputStream bis = new BufferedInputStream(inputStream)) {
			while (bis.available() > 0) {
				samlResponse.append((char) bis.read());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return samlResponse.toString();
	}

	public static void printModel(Object object) {
		try {
			System.out.println(MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(object));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
