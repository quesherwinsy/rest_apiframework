package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.Utils;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.junit.runner.RunWith;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class StepDefinition extends Utils {
	RequestSpecification res;
	Response ResponseBody;
	TestDataBuild bodyData = new TestDataBuild();
	// static value preserves data after execution of code
	static String place_id_exp;
	JsonPath jp;

	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws Throwable {
		System.out.println("Given");

		// POST add place API request with ResquestSpecBuilder
		// SERIALIZATION convert JAVA object Pojo body into JSON body
		res = given().spec(requestSpecsBuilder()).body(bodyData.addPlacePayload(name, language, address));
	}

	@When("^user calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
	public void user_calls_something_with_post_http_request(String api_name, String http_method) throws Throwable {
		System.out.println("When");

		// Create object of class ApiResources & set value of specific API URL
		ApiResources resources = ApiResources.valueOf(api_name);

		if (http_method.equalsIgnoreCase("POST")) {
			// Response process POST API
			System.out.println(resources.getResource().toString());
			ResponseBody = res.when().post(resources.getResource());
			// .then().assertThat().spec(responseSpecsBuilder()).extract().response()
		} else if (http_method.equalsIgnoreCase("GET")) {
			// Response process GET API
			System.out.println(resources.getResource().toString());
			ResponseBody = res.when().get(resources.getResource());
		} else if (http_method.equalsIgnoreCase("DELETE")) {
			// Response process DELETE API
			System.out.println(resources.getResource().toString());
			ResponseBody = res.when().get(resources.getResource());
		}
	}

	@Then("^the API call got success with success code (\\d+)$")
	public void the_api_call_got_success_with_success_code_200(int int1) throws Throwable {
		System.out.println("Then");
		Assert.assertEquals(ResponseBody.getStatusCode(), int1);
	}

	@And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void something_in_response_body_is_something(String key1, String value1) throws Throwable {
		// TestNg check if JSON response value is equal to expected value
		// With reusable method getJsonpath()
		Assert.assertEquals(getJsonpath(ResponseBody, key1), value1);
		// System.out.println("And actual result " + getJsonpath(ResponseBody, key1));
	}

	@And("verify {string} created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String place_id, String expected_name, String api_name)
			throws Throwable {
		// Get place_id value from resulting JSON
		// With reusable method getJsonpath()
		place_id_exp = getJsonpath(ResponseBody, place_id);
		// GET add place API request with ResquestSpecBuilder
		res = given().spec(requestSpecsBuilder()).queryParam("place_id", place_id_exp);
		// reuse method to submit GET place API
		user_calls_something_with_post_http_request(api_name, "GET");
		// TestNg check if JSON response name value is equal to expected name value
		// With reusable method getJsonpath()
		Assert.assertEquals(getJsonpath(ResponseBody, "name"), expected_name);
	}

	@Given("DeletePlaceAPI Payload")
	public void delete_place_api_payload() throws IOException {
		// POST delete place API request with ResquestSpecBuilder
		// SERIALIZATION convert JAVA object Pojo body into JSON body
		res = given().spec(requestSpecsBuilder()).body(bodyData.deletePlacePayload(place_id_exp));
	}

}
