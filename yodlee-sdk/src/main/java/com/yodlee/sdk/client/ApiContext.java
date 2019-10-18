/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiContext {

	private String path;

	private HttpMethod httpMethod;

	private final List<Pair> queryParams;

	private final List<Pair> collectionQueryParams;

	private final Object body;

	private final Map<String, String> headerParams;

	private final Map<String, Object> formParams;

	private String[] authNames;

	public ApiContext(String path, HttpMethod httpMethod, Object body) {
		this.path = path;
		this.httpMethod = httpMethod;
		this.body = body;
		queryParams = new ArrayList<>();
		collectionQueryParams = new ArrayList<>();
		headerParams = new HashMap<>();
		formParams = new HashMap<>();
		headerParams.put("Accept", "application/json");
		headerParams.put("Content-Type", "application/json");
	}

	public String getPath() {
		return path;
	}

	public HttpMethod getHttpMethod() {
		return httpMethod;
	}

	public List<Pair> getQueryParams() {
		return Collections.unmodifiableList(queryParams);
	}

	public void addQueryParam(Pair queryParam) {
		queryParams.add(queryParam);
	}

	public void removeQueryParam(Pair queryParam) {
		queryParams.remove(queryParam);
	}

	public void clearQueryParams() {
		queryParams.clear();
	}

	public List<Pair> getCollectionQueryParams() {
		return Collections.unmodifiableList(collectionQueryParams);
	}

	public Object getBody() {
		return body;
	}

	public Map<String, String> getHeaderParams() {
		return Collections.unmodifiableMap(headerParams);
	}

	public String addHeaderParam(String key, String value) {
		return headerParams.put(key, value);
	}

	public String removeHeaderParam(String key) {
		return headerParams.remove(key);
	}

	public void clearHeaderParams() {
		headerParams.clear();
	}

	public Map<String, Object> getFormParams() {
		return Collections.unmodifiableMap(formParams);
	}

	public Object addFormParam(String key, Object value) {
		return formParams.put(key, value);
	}

	public Object removeFormParam(String key) {
		return formParams.remove(key);
	}

	public void clearFormParams() {
		formParams.clear();
	}

	public String[] getAuthNames() {
		return authNames;
	}
}
