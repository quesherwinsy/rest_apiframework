# for comment add #
# for tags add @
Feature: Validating Create Client APIs 

@AddPlaceAPI1 @Regression
Scenario Outline: Verify if client is being successfully added using AddPlaceAPI 
	Given Add client payload with "<username>" "<password>" and body "<client_id>" "<client_name>" "<redirect_uris>" "<website_uri>" "<description>" "<logo_uri>" "<consent_required>" "<client_group>" "<token_endpoint_auth_method>"
	When user calls "AddClientAPI" with "Post" http request 
	Then the API call got success with success code 201 
#	And "status" in response body is "OK" 
#	And "scope" in response body is "APP" 
#	And verify "place_id" created maps to "<name>" using "GetPlaceAPI"
	
	Examples: 
		|username|password|client_id |client_name |redirect_uris|website_uri|description|logo_uri|consent_required|client_group|token_endpoint_auth_method|
		|admin|P@ssw0rd123$|test_upd5 |test_upd5 |https://www.google.com/|https://www.facebook.com|test|https://www.pngfind.com/pngs/m/597-5976288_sample-design-icon-sign-hd-png-download.png|true|oidc|client_secret_basic|

@AddPlaceAPIerror1 @Regression
Scenario Outline: Verify if client add failed using existing data
	Given Add client payload with "<username>" "<password>" and body "<client_id>" "<client_name>" "<redirect_uris>" "<website_uri>" "<description>" "<logo_uri>" "<consent_required>" "<client_group>" "<token_endpoint_auth_method>"
	When user calls "AddClientAPI" with "Post" http request 
	Then the API call got success with success code 500 
	
	Examples: 
		|username|password|client_id |client_name |redirect_uris|website_uri|description|logo_uri|consent_required|client_group|token_endpoint_auth_method|
		|admin|P@ssw0rd123$|test_upd5 |test_upd5 |https://www.google.com/|https://www.facebook.com|test|https://www.pngfind.com/pngs/m/597-5976288_sample-design-icon-sign-hd-png-download.png|true|oidc|client_secret_basic|

@AddPlaceAPIerror2 @Regression
Scenario Outline: Verify if client add failed using invalid credential
	Given Add client payload with "<username>" "<password>" and body "<client_id>" "<client_name>" "<redirect_uris>" "<website_uri>" "<description>" "<logo_uri>" "<consent_required>" "<client_group>" "<token_endpoint_auth_method>"
	When user calls "AddClientAPI" with "Post" http request 
	Then the API call got success with success code 401 
	
	Examples: 
		|username|password|client_id |client_name |redirect_uris|website_uri|description|logo_uri|consent_required|client_group|token_endpoint_auth_method|
		|adminer|passworder|test_upd5 |test_upd5 |https://www.google.com/|https://www.facebook.com|test|https://www.pngfind.com/pngs/m/597-5976288_sample-design-icon-sign-hd-png-download.png|true|oidc|client_secret_basic|
		|admin|passworder|test_upd5 |test_upd5 |https://www.google.com/|https://www.facebook.com|test|https://www.pngfind.com/pngs/m/597-5976288_sample-design-icon-sign-hd-png-download.png|true|oidc|client_secret_basic|
		|adminer|P@ssw0rd123$|test_upd5 |test_upd5 |https://www.google.com/|https://www.facebook.com|test|https://www.pngfind.com/pngs/m/597-5976288_sample-design-icon-sign-hd-png-download.png|true|oidc|client_secret_basic|

@AddPlaceAPIerror3 @Regression
Scenario Outline: Verify if client add failed using invalid redirect URL
	Given Add client payload with "<username>" "<password>" and body "<client_id>" "<client_name>" "<redirect_uris>" "<website_uri>" "<description>" "<logo_uri>" "<consent_required>" "<client_group>" "<token_endpoint_auth_method>"
	When user calls "AddClientAPI" with "Post" http request 
	Then the API call got success with success code 400 
	And "error" in response body is "Bad Request" 
	
	Examples: 
		|username|password|client_id |client_name |redirect_uris|website_uri|description|logo_uri|consent_required|client_group|token_endpoint_auth_method|
		|admin|P@ssw0rd123$|test_upd5 |test_upd5 |https-invalid-url|https://www.facebook.com|test|https://www.pngfind.com/pngs/m/597-5976288_sample-design-icon-sign-hd-png-download.png|true|oidc|client_secret_basic|

@AddPlaceAPIerror4 @Regression
Scenario Outline: Verify if client add failed using invalid token_endpoint_auth_method value
	Given Add client payload with "<username>" "<password>" and body "<client_id>" "<client_name>" "<redirect_uris>" "<website_uri>" "<description>" "<logo_uri>" "<consent_required>" "<client_group>" "<token_endpoint_auth_method>"
	When user calls "AddClientAPI" with "Post" http request 
	Then the API call got success with success code 400 
	
	Examples: 
		|username|password|client_id |client_name |redirect_uris|website_uri|description|logo_uri|consent_required|client_group|token_endpoint_auth_method|
		|admin|P@ssw0rd123$|test_upd5 |test_upd5 |https://www.google.com/|https://www.facebook.com|test|https://www.pngfind.com/pngs/m/597-5976288_sample-design-icon-sign-hd-png-download.png|true|oidc|client_secreter|

@AddPlaceAPI2 @Regression
Scenario Outline: Verify if client is being successfully added verify client_id 
	Given Add client payload with "<username>" "<password>" and body "<client_id>" "<client_name>" "<redirect_uris>" "<website_uri>" "<description>" "<logo_uri>" "<consent_required>" "<client_group>" "<token_endpoint_auth_method>"
	When user calls "AddClientAPI" with "Post" http request 
	Then the API call got success with success code 201 
	And verify "client_id" created maps to "<client_id>" using "GetClientAPI" with "<username>" "<password>"

	Examples: 
		|username|password|client_id |client_name |redirect_uris|website_uri|description|logo_uri|consent_required|client_group|token_endpoint_auth_method|
		|admin|P@ssw0rd123$|test_upd71 |test_upd71 |https://www.google.com/|https://www.facebook.com|test|https://www.pngfind.com/pngs/m/597-5976288_sample-design-icon-sign-hd-png-download.png|true|oidc|client_secret_basic|
		
#@GetClientAPI1 @Regression
#Scenario Outline: Verify if GetClientAPI functionality is working 
#	Given GetClientAPI Payload with "<username>" "<password>" and query "<client_id>"
#	When user calls "GetClientAPI" with "Get" http request 
#	Then the API call got success with success code 200 
#	And "client_id" in response body is "<client_id>"

#	Examples: 
#		|username|password|client_id |
#		|admin|P@ssw0rd123$|test_upd99 |
		
#@DeletePlaceAPI @Regression
#Scenario Outline: Verify if DeletePlaceAPI functionality is working 
#	Given DeletePlaceAPI Payload 
#	When user calls "DeletePlaceAPI" with "Delete" http request 
#	Then the API call got success with success code 200 
#	And "status" in response body is "OK"