/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.sampleflow;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yodlee.api.model.AbstractModelComponent;

public class Utils {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	private Utils() {}

	public static <T> T load(String filePath, Class<T> t) {
		try (InputStream configStream = ContextFactory.class.getResourceAsStream(filePath)) {
			return MAPPER.readValue(configStream, t);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Long[] convertStringtoLongArray(String param) {
		if (StringUtils.isBlank(param)) {
			return null;
		}
		String[] stringArray = param.split("#");
		Long[] value = new Long[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			value[i] = Long.valueOf(stringArray[i]);
		}
		return value;
	}

	public static String printResponse(AbstractModelComponent response) {
		try {
			System.out.println();
			return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(response);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
