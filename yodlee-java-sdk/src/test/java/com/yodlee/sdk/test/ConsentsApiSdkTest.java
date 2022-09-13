/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.sdk.test;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.yodlee.sdk.api.IncludeConsentParam;
import org.apache.commons.lang3.StringUtils;

import com.yodlee.api.model.RenewalConsent;
import com.yodlee.api.model.consent.Scope;
import com.yodlee.api.model.consent.enums.DataCluster;
import com.yodlee.api.model.consent.request.CreateConsentRequest;
import com.yodlee.api.model.consent.request.RenewConsentRequest;
import com.yodlee.api.model.consent.request.UpdateConsentRequest;
import com.yodlee.api.model.consent.response.ConsentResponse;
import com.yodlee.api.model.consent.response.CreatedConsentResponse;
import com.yodlee.api.model.consent.response.RenewConsentResponse;
import com.yodlee.api.model.consent.response.UpdatedConsentResponse;
import com.yodlee.sdk.api.ConsentsApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.test.utils.ModelUtil;
import com.yodlee.sdk.test.utils.PrintUtil;

public class ConsentsApiSdkTest {

	public static void getConsentsTest(ConsentsApi consentsApi, String testCaseId, String testCaseName,
									   String consentIdsStr, String providerAccountIdsStr, IncludeConsentParam includeConsentParam) {
		try {
			Long[] consentIds = StringUtils.isBlank(consentIdsStr) ? null : convertStringtoLongArray(consentIdsStr);
			Long[] providerAccountIds =
					StringUtils.isBlank(providerAccountIdsStr) ? null : convertStringtoLongArray(providerAccountIdsStr);
			ApiResponse<ConsentResponse> consentResp = consentsApi.getConsent(consentIds, providerAccountIds,
					includeConsentParam);
			if (includeConsentParam!=null && "renewal".equals(includeConsentParam.getValue())){
				assertNotNull(consentResp.getData().getConsents().get(0).getRenewal());
			}
			assertEquals(consentResp.getStatusCode(), 200);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
	
	public static void getAuthorizationURLTest(ConsentsApi consentsApi, String testCaseId, String testCaseName,
			long consentId) {
		try {
			ApiResponse<UpdatedConsentResponse> authorizationURL = consentsApi.getAuthorizationURL(consentId);
			assertEquals(authorizationURL.getStatusCode(), 200);
			assertEquals(authorizationURL.getData().getConsents().get(0).getConsentId(), Long.valueOf(consentId));
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
	
	public static void captureConsentTest(ConsentsApi consentsApi, String testCaseId, String testCaseName,
			String fileName) {
		try {
			// Create Consent request triggered to generate consentId to invoke Update Consent request
			CreateConsentRequest createConsentRequest = ModelUtil.load(fileName, CreateConsentRequest.class);
			ApiResponse<CreatedConsentResponse> createConsentResponse = consentsApi.createConsent(createConsentRequest);
			assertEquals(createConsentResponse.getStatusCode(), 201);
			assertNotNull(createConsentResponse.getData().getConsents().get(0).getConsentId());
			// Get consentId & scope for Update Consent Request
			Long consentId = createConsentResponse.getData().getConsents().get(0).getConsentId();
			List<Scope> consentScopeIds = createConsentResponse.getData().getConsents().get(0).getScopes();
			List<DataCluster> scopeIds= new ArrayList<DataCluster>();
			for (Scope scopeId : consentScopeIds) {
				scopeIds.add(scopeId.getScopeId());
			}

			UpdateConsentRequest updateConsentRequest = new UpdateConsentRequest();
			updateConsentRequest.setScopeIds(scopeIds);
			ApiResponse<UpdatedConsentResponse> updateConsentResponse = consentsApi.captureConsent(consentId, updateConsentRequest);
			assertEquals(updateConsentResponse.getStatusCode(), 200);
			assertEquals(updateConsentResponse.getData().getConsents().get(0).getConsentId(), consentId);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
	
	public static void createConsentTest(ConsentsApi consentsApi, String testCaseId, String testCaseName,
			String fileName) {
		try {
			CreateConsentRequest createConsentRequest = ModelUtil.load(fileName, CreateConsentRequest.class);
			ApiResponse<CreatedConsentResponse> createConsentResponse = consentsApi.createConsent(createConsentRequest);
			assertEquals(createConsentResponse.getStatusCode(), 201);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
	
	public static void renewConsentTest(ConsentsApi consentsApi, String testCaseId, String testCaseName,
			long consentId, Long[] renewal) {
		try {
			RenewConsentRequest renewConsentRequest = new RenewConsentRequest();
			RenewalConsent renewalObject = new RenewalConsent();
			renewalObject.setDefaultRenewalDuration("90");
			renewalObject.setIsReauthorizationRequired(true);
			renewConsentRequest.setRenewal(renewalObject);
			ApiResponse<RenewConsentResponse> renewConsentResponse = consentsApi.renewConsent(consentId, renewConsentRequest);
			assertEquals(renewConsentResponse.getStatusCode(), 200);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}

	public static void renewConsentTest1(ConsentsApi consentsApi, String testCaseId, String testCaseName,
			long consentId, Long[] renewal) {
		try {
			ApiResponse<RenewConsentResponse> renewConsentResponse = consentsApi.renewConsent(consentId, null);
			assertEquals(renewConsentResponse.getStatusCode(), 200);
		} catch (ApiException e) {
			PrintUtil.assertFail(testCaseId, testCaseName, e);
		}
	}
	
	private static Long[] convertStringtoLongArray(String param) {
		if (StringUtils.isBlank(param))
			return null;
		String[] stringArray = param.split(",");
		Long[] value = new Long[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			value[i] = Long.valueOf(stringArray[i]);
		}
		return value;
	}
}
