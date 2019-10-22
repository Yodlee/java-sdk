/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.sampleflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.yodlee.api.model.providers.response.ProviderDetailResponse;
import com.yodlee.api.model.user.response.UserResponse;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.context.JWTAppContext;
import com.yodlee.sdk.context.JWTUserContext;

@SpringBootApplication
@ComponentScan({"com.yodlee.sdk.sampleflow"})
public class DemoAddAccountApplication {

	public static final SampleAppResources RESOURCES = Utils.load("/sampleAppResources.json", SampleAppResources.class);

	public static void main(String[] args) {
		try {
			SpringApplication.run(DemoAddAccountApplication.class, args);
			// Create JWT App Context to webhook subscription
			JWTAppContext jwtAppContext = ContextFactory.createJWTAppContext();
			// Subscribe REFRESH event for webhook notification - This is a one-time activity
			AddAccountFlow.subscribeRefreshEvent(jwtAppContext);
			// Register a user - This is a one-time activity for a user
			UserResponse userResponse = AddAccountFlow.registerUser(jwtAppContext, RESOURCES.getUserLoginName());
			// Create JWT user context for the created user
			JWTUserContext jwtUserContext = createJWTUserContext(jwtAppContext, userResponse);
			// Search provider
			long providerId = AddAccountFlow.getProviderId(jwtUserContext, RESOURCES.getSearchProvider(),
					RESOURCES.getProviderId());
			if (providerId > 0) {
				// Fetch the provider details
				ProviderDetailResponse providerDetails = AddAccountFlow.getProviderDetails(jwtUserContext, providerId);
				// Link Account
				AddAccountFlow.linkAccount(jwtUserContext, providerDetails, providerId, RESOURCES.getField());
				// Further flow will be at Webhooks Callback Flow
			}
		} catch (ApiException e) {
			System.out.println("Error Occurred : " + Utils.printException(e));
		}
	}

	private static JWTUserContext createJWTUserContext(JWTAppContext jwtAppContext, UserResponse userResponse)
			throws ApiException {
		String loginName = userResponse.getUser().getLoginName();
		JWTUserContext jwtUserContext =
				ContextFactory.createJWTUserContext(jwtAppContext.getConfiguration(), loginName);
		UserManager.getInstance().addUser(loginName, jwtUserContext);
		return jwtUserContext;
	}
}
