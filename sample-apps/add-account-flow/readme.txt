Demo to showcase Add Account flow with REFRESH webhooks using JWT authentication

Step to execute Demo application -
1. Go to /resources/configuration/jwtConfiguration.json and update below entries
	<BASEPATH> - base path of yodlee server
	<APIKEY> - client's api key
	<RSA_PRIVATE_KEY> - client's RSA private Key
2. Go to /resources/sampleAppResources.json and update below entries
	<DNSNAME> - dns name for webhooks callback notification
	<USER LOGIN NAME> - login name will be used for registeration and have to change it before every execution
	<SEARCH_PROVIDER> - search string for searching provider
	<PROVIDER_ID> - providerId to link an account
	<FIELD_ID> - field id for link an account
	<FIELD_VALUE> - field value for link an account
3. Go to DemoAddAccountApplication.java and execute it.



The DemoAddAccountApplication (springboot application) does the following-

1.Creates a JWT App Context
2.Subscribes a REFRESH event for webhook notification. The callback URL provided here should be publicly accessible as Yodlee would make a POST call on this callBack URL. Please note that subscription is a one-time activity, hence, to run the application more than once, comment subscribeRefreshEvent method call. 
3.Registers a user. Please note that user registeration is a one-time activity, hence to re-run the application, either comment registerUser method call or change the userLoginName in sampleAppResources.json . 
4.Creates a JWT user context for the registered user in #3.
5.It then searches for the provider that is provided in "searchProvider".
6.Invokes an API to fetch the provider details with login form.
7.It then invokes an API that links all the accounts with the 'providerId' and for the 'field' mentioned in sampleAppResources.json
8.Further flow happens based on the Webhooks callback Flow end-point registered in #2 where-in the status is looked up. On a SUCCESS/PARTIAL_SUCCESS status, the get accounts API is invoked.