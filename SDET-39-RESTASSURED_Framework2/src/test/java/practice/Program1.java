package practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Program1 {

	@Test
	public void program()
	{
		baseURI ="http://localhost";
		port = 8084;
		 when()
			.get("/projects/TY_PROJ_004")
			.then()
			.log().all();
	}
}
