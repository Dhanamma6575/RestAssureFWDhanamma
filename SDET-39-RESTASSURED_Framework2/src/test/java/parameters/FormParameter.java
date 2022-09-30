package parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParameter {

	@Test
	public void formparameter()
	{
		baseURI ="http://localhost";
		port=8084;
		
		given()
		.formParam("createdBy", "dhanamma")
		.formParam("projectName", "testyantra123")
		.formParam("teamSize", 20)
		.contentType(ContentType.JSON)
		
		//step 2: send the request and validate response
		.when()
		.post("/addProject")
		.then()
		.log().all();
	}
}
