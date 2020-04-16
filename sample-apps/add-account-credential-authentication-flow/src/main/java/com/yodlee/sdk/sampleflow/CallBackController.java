/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.sampleflow;

import static com.yodlee.sdk.sampleflow.DemoAddAccountApplication.RESOURCES;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yodlee.api.model.account.response.AccountResponse;
import com.yodlee.api.model.provideraccounts.UpdatedProviderAccount;
import com.yodlee.api.model.provideraccounts.enums.ProviderAccountStatus;
import com.yodlee.api.model.webhooks.CallBackRefreshData;
import com.yodlee.api.model.webhooks.CallBackRefreshEvent;
import com.yodlee.api.model.webhooks.CallBackRefreshEventResponse;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.context.ClientCredentialUserContext;

@RestController
public class CallBackController {

	/**
	 * Below implementation is for shows 'REFRESH' callback flow for demonstration purposes only.<br>
	 * Clients should make appropriate changes for their perusal.
	 * 
	 * Callback URL should be publicly accessible as Yodlee would make a POST call on this callBack URL
	 * 
	 */
	@RequestMapping(path = "/yourApp/callback",
					method = RequestMethod.POST,
					consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE,
							MediaType.ALL_VALUE})
	public void webhookCallBack(@RequestBody(required = false) String payloadResponse, HttpServletRequest request) {
		CallBackRefreshEventResponse callBackEventResponse = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (payloadResponse != null) {
				// For Form URL encode content-type
				String response = request.getParameter("payload");
				if (response != null && !response.trim().isEmpty()) {
					callBackEventResponse = mapper.readValue(response, CallBackRefreshEventResponse.class);
				} else {
					// For application/json content type
					if (!payloadResponse.trim().isEmpty()) {
						callBackEventResponse = mapper.readValue(payloadResponse, CallBackRefreshEventResponse.class);
					}
				}
				processPayloadResponse(callBackEventResponse);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void processPayloadResponse(CallBackRefreshEventResponse callBackEventResponse) throws ApiException {
		if (callBackEventResponse != null) {
			CallBackRefreshEvent event = callBackEventResponse.getEvent();
			if (event != null) {
				CallBackRefreshData data = event.getData();
				processCallbackData(data);
			}
		}
	}

	private static void processCallbackData(CallBackRefreshData data) throws ApiException {
		if (data != null) {
			List<UpdatedProviderAccount> providerAccounts = data.getProviderAccount();
			if (providerAccounts != null && !providerAccounts.isEmpty()) {
				for (UpdatedProviderAccount providerAccount : providerAccounts) {
					ProviderAccountStatus status = providerAccount.getStatus();
					switch (status) {
						case SUCCESS:
						case PARTIAL_SUCCESS:
							System.out.println("Account addition done with status : " + status);
							handleSuccessFlow(providerAccount);
							break;
						case FAILED:
							System.out.println("Account addition failed with status : " + status);
							break;
						case IN_PROGRESS:
						case LOGIN_IN_PROGRESS:
							System.out.println("Account addition status is " + status);
							break;
						default:
							break;
					}
				}
			}
		}
	}

	private static void handleSuccessFlow(UpdatedProviderAccount providerAccount) throws ApiException {
		String loginName = RESOURCES.getUserLoginName();
		ClientCredentialUserContext clientCredentialUserContext = UserManager.getInstance().getContext(loginName);
		Long providerAccountId = providerAccount.getId();
		AccountResponse accounts = AddAccountFlow.getAccounts(clientCredentialUserContext, providerAccountId);
		System.out.println("Linked Accounts : " + Utils.printResponse(accounts));
	}
}
