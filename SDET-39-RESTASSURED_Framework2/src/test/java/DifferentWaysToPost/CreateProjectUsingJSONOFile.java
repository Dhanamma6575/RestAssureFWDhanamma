package DifferentWaysToPost;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.Random;

public class CreateProjectUsingJSONOFile {

	@Test
	public void createproject()
	{
		
		baseURI = "http://localhost";
		port = 8084;
		
		//create Prereqisites
		File file = new File(".\\data.json");
		
		//send the request and validate the response
		given()
		.body(file)
		.contentType(ContentType.JSON)
		.when().post("/addProject")
		.then()
		.log().all();
		
	}
}
