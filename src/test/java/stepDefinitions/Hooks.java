package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	// cucumber hook uses before & after tag
	// @Before(@Tagname) - will run before specific step definition tag
	// @Before - will run before at all step definition test tag

	@Before("@DeletePlaceAPI")
	public void beforeScenario() throws Throwable {
		// code that will give place_id, run when place_id is null
		StepDefinition sd_temp = new StepDefinition();
		// check existing object if place_id is null
		if (StepDefinition.place_id_exp == null) {
			sd_temp.add_place_payload_with("Shetty", "French", "Asia");
			sd_temp.user_calls_something_with_post_http_request("AddPlaceAPI", "Post");
			sd_temp.verify_place_id_created_maps_to_using("place_id", "Shetty", "GetPlaceAPI");
		}
	}

	@After
	public void afterScenario() {
		// System.out.println("run after the Scenario");
	}
}
