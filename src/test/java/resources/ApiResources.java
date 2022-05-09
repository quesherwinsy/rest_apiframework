package resources;

// enum is Java special class, collection of constant or method
// enum method dont need argument
// enum is separated by comma and ends with semi-colon
// enum method needs constructor with argument
public enum ApiResources {

	AddPlaceAPI("/maps/api/place/add/json"), GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");

	private String resources;

	ApiResources(String resources) {
		this.resources = resources;
	}

	public String getResource() {
		return resources;
	}
}
