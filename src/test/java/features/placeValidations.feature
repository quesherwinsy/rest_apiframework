# for comment add #
# for tags add @
Feature: Validating place APIs 

@AddPlaceAPI @Regression
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI 
	Given Add place payload with "<name>" "<language>" "<address>" 
	When user calls "AddPlaceAPI" with "Post" http request 
	Then the API call got success with success code 200 
	And "status" in response body is "OK" 
	And "scope" in response body is "APP" 
	And verify "place_id" created maps to "<name>" using "GetPlaceAPI"
	
	Examples: 
		|name |language |address|
		|AAhouse |English |World cross center|
		|BBhouse |Spanish |Sea cross center|

@DeletePlaceAPI @Regression
Scenario Outline: Verify if DeletePlaceAPI functionality is working 
	Given DeletePlaceAPI Payload 
	When user calls "DeletePlaceAPI" with "Delete" http request 
	Then the API call got success with success code 200 
	And "status" in response body is "OK"