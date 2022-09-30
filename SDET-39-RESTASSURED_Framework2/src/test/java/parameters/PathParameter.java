package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {

	@Test
	public void pathparameter()
	{
	  // step 1: pre requisites
	   baseURI = "http://localhost";
	   port = 8084;
	   
	   given()
	   .pathParam("pid", "TY_PROJ_10015")
	
	   .when().get("/projects/{pid}")
	   
	   .then().log().all();
	
	}
}
