/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.sampleflow;

import java.util.HashMap;
import java.util.Map;
import com.yodlee.sdk.context.JWTUserContext;

public class UserManager {

	private static final UserManager INSTANCE = new UserManager();

	private final Map<String, JWTUserContext> userContextMap = new HashMap<>();

	private UserManager() {}

	public static UserManager getInstance() {
		return INSTANCE;
	}

	public JWTUserContext getContext(String userIdentity) {
		return userContextMap.get(userIdentity);
	}
	
	public void addUser(String userIdentity, JWTUserContext jwtUserContext) {
		userContextMap.put(userIdentity, jwtUserContext);
	}

	public void removeUser(String userIdentity) {
		userContextMap.remove(userIdentity);
	}

	public void clear() {
		userContextMap.clear();
	}
}
