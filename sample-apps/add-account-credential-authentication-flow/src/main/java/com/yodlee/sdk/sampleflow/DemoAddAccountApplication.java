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
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.context.ClientCredentialAdminContext;
import com.yodlee.sdk.context.ClientCredentialUserContext;

@SpringBootApplication
@ComponentScan({"com.yodlee.sdk.sampleflow"})
public class DemoAddAccountApplication {

	public static final SampleAppResources RESOURCES = Utils.load("/sampleAppResources.json", SampleAppResources.class);

	public static void main(String[] args) {
		try {
			SpringApplication.run(DemoAddAccountApplication.class, args);
			// Create Client-Credential admin context
			ClientCredentialAdminContext clientCredentialAdminContext =
					ContextFactory.createClientCredentialAdminContext();
			// Subscribe REFRESH event for webhook notification - This is a one-time
			// activity
			AddAccountFlow.subscribeRefreshEvent(clientCredentialAdminContext);
			// Register a user - This is a one-time activity for a user
			AddAccountFlow.registerUser(clientCredentialAdminContext, RESOURCES.getUserLoginName());
			// Create Client-Credential user context
			ClientCredentialUserContext clientCredentialUserContext =
					ContextFactory.createClientCredentialUserContext();
			// Search provider
			long providerId = AddAccountFlow.getProviderId(clientCredentialUserContext, RESOURCES.getSearchProvider(),
					RESOURCES.getProviderId());
			if (providerId > 0) {
				// Fetch the provider details
				ProviderDetailResponse providerDetails =
						AddAccountFlow.getProviderDetails(clientCredentialUserContext, providerId);
				// Link Account
				AddAccountFlow.linkAccount(clientCredentialUserContext, providerDetails, providerId,
						RESOURCES.getField());
				// Further flow will be at Webhooks Callback Flow
			}
		} catch (ApiException e) {
			System.out.println("Error Occurred : " + Utils.printException(e));
		}
	}
}
