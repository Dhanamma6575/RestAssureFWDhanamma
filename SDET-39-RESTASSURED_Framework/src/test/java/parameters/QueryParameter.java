package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter {

	@Test
	public void queryparameter()
	{
		//step 1: create pre requsites
		baseURI = "http://reqres.in";
		port = 8084;
		
		//step 2: send request and validate the response
		given()
		.queryParam("page", 3)
		
		.when()
		.get("/api/users")
		
		.then().log().all();
	}
}
