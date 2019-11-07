/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.sdk.api;

class ApiEndpoint {

	private ApiEndpoint() {}

	static final String COBRAND_LOGIN = "/cobrand/login";

	static final String COBRAND_LOGOUT = "/cobrand/logout";

	static final String COBRAND_CONFIG_NOTIFICATIONS_EVENTS_EVENT_NAME =
			"/cobrand/config/notifications/events/{eventName}";

	static final String COBRAND_CONFIG_NOTIFICATIONS_EVENTS = "/cobrand/config/notifications/events";

	static final String COBRAND_PUBLIC_KEY = "/cobrand/publicKey";

	static final String USER_DETAILS = "/user";

	static final String USER_SAML_LOGIN = "/user/samlLogin";

	static final String USER_REGISTER = "/user/register";

	static final String USER_LOGOUT = "/user/logout";

	static final String USER_ACCESS_TOKEN = "/user/accessTokens";

	static final String USER_UNREGISTER = "/user/unregister";

	static final String PROVIDERS = "/providers";

	static final String PROVIDER_DETAIL = "/providers/{providerId}";

	static final String PROVIDERS_COUNT = "/providers/count";

	static final String STATEMENTS = "/statements";

	static final String ACCOUNT_ACCOUNTID = "/accounts/{accountId}";

	static final String ACCOUNTS = "/accounts";

	static final String GET_HISTORICAL_BALANCES = "/accounts/historicalBalances";

	static final String HOLDINGS = "/holdings";

	static final String HOLDINGS_SECURITIES = "/holdings/securities";

	static final String HOLDINGS_TYPE_LIST = "/holdings/holdingTypeList";

	static final String HOLDINGS_ASSET_CLASSIFICATION_LIST = "/holdings/assetClassificationList";

	static final String PROVIDER_ACCOUNTS = "/providerAccounts";

	static final String PROVIDER_ACCOUNT_DETAILS = "/providerAccounts/{providerAccountId}";

	static final String PROVIDER_ACCOUNTS_PROFILE = "/providerAccounts/profile";

	static final String PROVIDER_ACCOUNTS_PREFERENCES = "/providerAccounts/{providerAccountId}/preferences";

	static final String AUTH_DELETE_TOKEN = "/auth/token";

	static final String AUTH_APIKEY = "/auth/apiKey";

	static final String AUTH_DELETE_APIKEY = "/auth/apiKey/{key}";

	static final String DATA_EXTRACTS_EVENTS = "/dataExtracts/events";

	static final String DATA_EXTRACTS_USER_DATA = "/dataExtracts/userData";

	static final String VERIFY_ACCOUNTS = "/verifyAccount/{providerAccountId}";

	static final String TRANSACTIONS = "/transactions";

	static final String TRANSACTIONS_COUNT = "/transactions/count";

	static final String UPDATE_TRANSACTIONS = "/transactions/{transactionId}";

	static final String GET_TRANSACTIONS_CATEGORIZATION_RULES = "/transactions/categories/txnRules";

	static final String TRANSACTIONS_CATEGORIZATION = "/transactions/categories";

	static final String TRANSACTIONS_CATEGORIZATION_RULES = "/transactions/categories/rules";

	static final String TRANSACTIONS_CATEGORIZATION_RULES_WITH_RULEID = "/transactions/categories/rules/{ruleId}";

	static final String TRANSACTIONS_CATEGORIZATION_WITH_CATEGORYID = "/transactions/categories/{categoryId}";

	static final String DERIVED_TRANSACTION_SUMMARY = "/derived/transactionSummary";

	static final String DERIVED_HOLDING_SUMMARY = "/derived/holdingSummary";

	static final String DERIVED_NETWORTH = "/derived/networth";

	static final String VERIFICATION = "/verification";

	static final String DOCUMENTS = "/documents";

	static final String DOCUMENTS_WITH_ID = "/documents/{documentId}";
}
