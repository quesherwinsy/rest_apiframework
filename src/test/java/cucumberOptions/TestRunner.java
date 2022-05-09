package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//feature = path of feature file
//glue = path of step definition file
//tags = specify @test definition to run
//plugin = specify type of output and path
@CucumberOptions(features = "src/test/java/features", plugin = "json:target/jsonReports/cucumber-report.json", glue = {
		"stepDefinitions" }/*, tags = "@AddPlaceAPI or @DeletePlaceAPI"*/)

public class TestRunner {

}

// run in command line via Maven
// get project path ex. C:\Users\SherwQUE\eclipse-workspace\APIframework
// open command line to project path
// mvn compile - will compile the project
// mvn test - will compile and run the project
// mvn test -Dcucumber.options="--tags @AddPlace"
// maven w/ cucumber option param

// maven Java cucumber reporting source
// https://github.com/damianszczepanik/maven-cucumber-reporting
// copy the text and place in pom.xml
// update net.masterthought version based on github
// remove tags classificationDirectory and classificationFiles
// mvn test verify - run then it will create reports