package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	// static for logging purpose, so it will not be overwritten
	public static RequestSpecification ReqAddPlace;
	public static ResponseSpecification ResAddPlace;

	public RequestSpecification requestSpecsBuilder() throws IOException {
		// check if Request data is null, for logging purpose
		if (ReqAddPlace == null) {
			// Stream for logging, file created on run
			PrintStream logStream = new PrintStream(new FileOutputStream("logging.txt"));

			// Request spec builder reusable setting for request
			// Request and response filter for logging
			/*
			 * ReqAddPlace = new RequestSpecBuilder().setBaseUri(getGLobalValues("baseUrl"))
			 * .addQueryParam("key",
			 * "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(logStream))
			 * .addFilter(ResponseLoggingFilter.logResponseTo(logStream)).setContentType(
			 * ContentType.JSON).build();
			 */
			ReqAddPlace = new RequestSpecBuilder().setBaseUri(getGLobalValues("baseUrl"))
					.addFilter(RequestLoggingFilter.logRequestTo(logStream))
					.addFilter(ResponseLoggingFilter.logResponseTo(logStream)).setContentType(ContentType.JSON).build();
			return ReqAddPlace;
		}
		return ReqAddPlace;
	}

	public ResponseSpecification responseSpecsBuilder() {
		// Response spec builder reusable setting for response
		ResAddPlace = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return ResAddPlace;
	}

	// Guide to read and write external property file
	public static String getGLobalValues(String key) throws IOException {
		// Instantiate properties object
		Properties prop = new Properties();
		// Set read properties file location
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\resources\\global.properties");
		// Load properties file to read mode
		prop.load(fis);
		// Get value of specific property
		return prop.getProperty(key);
	}

	// Returns specific key value of JSON response body
	public String getJsonpath(Response responseBod, String key) {
		String ResponseStr = responseBod.asString();
		// parse JSON string or file
		JsonPath jp = new JsonPath(ResponseStr);
		return jp.get(key).toString();
	}
}
