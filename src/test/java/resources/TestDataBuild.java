package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.DeletePlace;
import pojo.Location;

public class TestDataBuild {

	public AddPlace addPlacePayload(String name, String language, String address) {
		// Initialize and set JAVA object for Serialization, used as test data
		AddPlace ap = new AddPlace();
		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		ap.setLocation(loc);
		ap.setAccuracy(50);
		ap.setName(name);
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setAddress(address);
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		ap.setTypes(myList);
		ap.setWebsite("http://google.com");
		ap.setLanguage(language);
		return ap;
	}

	public DeletePlace deletePlacePayload(String place_id) {
		// Initialize and set JAVA object for Serialization, used as test data
		DeletePlace dp = new DeletePlace();
		dp.setPlace_id(place_id);
		return dp;
	}
}
